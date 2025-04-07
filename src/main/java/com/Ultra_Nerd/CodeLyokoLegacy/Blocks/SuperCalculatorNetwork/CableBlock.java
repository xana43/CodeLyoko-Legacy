package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.SuperCalculatorNetwork;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.CableNetworkConnectedBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;
import net.minecraft.datafixer.DataFixTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.PersistentState;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public final class CableBlock extends FenceBlock {



    public static final class CableNetworkWorldState extends PersistentState{
        private final Object2ObjectMap<BlockPos, UUID> CABLE_NETWORKS = new Object2ObjectOpenHashMap<>();
        private final Object2ObjectMap<UUID, ObjectOpenHashSet<BlockPos>> NETWORKS = new Object2ObjectOpenHashMap<>();
        private static final String CABLE_NETWORK = "cable_network";
        private static final String NETWORK = "network";
        @Override
        public NbtCompound writeNbt(final NbtCompound nbt,final RegistryWrapper.WrapperLookup registryLookup) {
            final NbtList cableList = new NbtList();
            CABLE_NETWORKS.forEach((pos, uuid) -> {
                final NbtCompound cable = new NbtCompound();
                cable.putLong("position",pos.asLong());
                cable.putUuid("uuid",uuid);
                cableList.add(cable);
            });
            nbt.put(CABLE_NETWORK, cableList);
            final NbtList networkList = new NbtList();
            NETWORKS.forEach((uuid, set) -> {
                final NbtCompound network = new NbtCompound();
                network.putUuid("uuid",uuid);
                final NbtList networkPositions = new NbtList();
                set.forEach(networkPosition -> {
                    final NbtCompound networkPositionTag = new NbtCompound();
                    networkPositionTag.putLong("position",networkPosition.asLong());
                    networkPositions.add(networkPositionTag);
                });
                network.put("positions",networkPositions);
                networkList.add(network);
            });
            nbt.put(NETWORK, networkList);
            CodeLyokoMain.LOG.debug("saving cable states {} {}", CABLE_NETWORKS,NETWORKS);
            return nbt;
        }

        public static CableNetworkWorldState createFromNbt(final NbtCompound nbt,final RegistryWrapper.WrapperLookup registryLookup) {
            final CableNetworkWorldState state = new CableNetworkWorldState();
            final NbtList cableList = nbt.getList(CABLE_NETWORK, NbtElement.COMPOUND_TYPE);
            for(final NbtElement cable : cableList){
                final NbtCompound cableTag = (NbtCompound) cable;
                state.CABLE_NETWORKS.put(BlockPos.fromLong(cableTag.getLong("position")),cableTag.getUuid("uuid"));
            }
            final NbtList networkList = nbt.getList(NETWORK, NbtElement.COMPOUND_TYPE);
            for(final NbtElement network : networkList){
                final NbtCompound networkTag = (NbtCompound) network;
                final ObjectOpenHashSet<BlockPos> positions = new ObjectOpenHashSet<>();
                final NbtList positionList = networkTag.getList("positions", NbtElement.COMPOUND_TYPE);
                for(final NbtElement position : positionList){
                    final NbtCompound positionTag = (NbtCompound) position;
                    positions.add(BlockPos.fromLong(positionTag.getLong("position")));
                }
                state.NETWORKS.put(networkTag.getUuid("uuid"),positions);
            }
            CodeLyokoMain.LOG.debug("loaded cable states {} {}", state.CABLE_NETWORKS, state.NETWORKS);
            return state;
        }
        public Object2ObjectMap<BlockPos,UUID> getCableNetworks(){
            return CABLE_NETWORKS;
        }
        public Object2ObjectMap<UUID, ObjectOpenHashSet<BlockPos>> getNetworks(){
            return NETWORKS;
        }
        private static final Type<CableNetworkWorldState> type = new Type<>(CableNetworkWorldState::new,CableNetworkWorldState::createFromNbt, DataFixTypes.LEVEL);
        public static void getFromServer(final MinecraftServer server){
            final ServerWorld world = server.getWorld(World.OVERWORLD);
            assert world != null;
            getFromServerWorld(world);
        }
        private static CableNetworkWorldState getFromServerWorld(final ServerWorld world){
            assert world != null;
            final CableNetworkWorldState state = world.getPersistentStateManager().getOrCreate(type,CodeLyokoMain.MOD_ID);
            state.markDirty();
            return state;
        }
    }

    public CableBlock(final Settings settings) {
        super(settings);
        //super(2.0F, 2.0F, 16.0F, 16.0F, 24.0F, settings);
        //this.shape = this.createShapes(10, 10, 10, 10, 10);
        //this.setDefaultState(this.getDefaultState().with(WATERLOGGED, Boolean.FALSE));
    }

    public static Set<BlockPos> getNetworkMembers(final BlockPos pos,final ServerWorld world) {
        final CableNetworkWorldState worldState = CableNetworkWorldState.getFromServerWorld(world);
        final Object2ObjectMap<BlockPos,UUID> CABLE_NETWORKS = worldState.getCableNetworks();
        final Object2ObjectMap<UUID,ObjectOpenHashSet<BlockPos>> NETWORKS = worldState.getNetworks();
        UUID networkId = CABLE_NETWORKS.get(pos);
        return NETWORKS.getOrDefault(networkId, ObjectOpenHashSet.of());
    }

    public static boolean isConnected(final BlockPos pos1, final BlockPos pos2,final ServerWorld world) {
        final CableNetworkWorldState worldState = CableNetworkWorldState.getFromServerWorld(world);
        final Object2ObjectMap<BlockPos,UUID> CABLE_NETWORKS = worldState.getCableNetworks();
        return CABLE_NETWORKS.get(pos1).equals(CABLE_NETWORKS.get(pos2));
    }
    private static void testNetworkConnection(final BlockPos pos, final ServerWorld world) {
        if(world.getBlockState(pos) instanceof CableNetworkConnectedBlockEntity blockEntity){
            if(!blockEntity.canConnect())
            {
                return;
            }
            blockEntity.tryConnect();
        }
    }
    @Override
    public void onPlaced(final World world, final BlockPos pos, final BlockState state, @Nullable final LivingEntity placer, final ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        if(world.isClient()){
            return;
        }
        final CableNetworkWorldState worldState = CableNetworkWorldState.getFromServerWorld((ServerWorld) world);
        final Object2ObjectMap<BlockPos,UUID> CABLE_NETWORKS = worldState.getCableNetworks();
        final Object2ObjectMap<UUID,ObjectOpenHashSet<BlockPos>> NETWORKS = worldState.getNetworks();
        final ObjectOpenHashSet<UUID> adjacentNetworks = new ObjectOpenHashSet<>();
        //check adjacent networks
        for (final Direction direction : Direction.values()) {
            final BlockPos adjacentPos = pos.offset(direction);
            if (CABLE_NETWORKS.containsKey(adjacentPos)) {
                adjacentNetworks.add(CABLE_NETWORKS.get(adjacentPos));
            }
           testNetworkConnection(adjacentPos, (ServerWorld) world);
        }
        if (adjacentNetworks.isEmpty()) {
            //create a new network if there's none found around this cable
            final UUID newUUID = UUID.randomUUID();
            CABLE_NETWORKS.put(pos, newUUID);
            NETWORKS.put(newUUID, new ObjectOpenHashSet<>(Set.of(pos)));
            CodeLyokoMain.LOG.debug("New network added: {} with the contents:{}:{}", newUUID, CABLE_NETWORKS, NETWORKS);
            return;
        }
        //if there is one, merge all adjacent into the largest existing network
        final UUID largestNetworkID = adjacentNetworks.stream().max(
                Comparator.comparingInt(id -> NETWORKS.get(id).size())).orElseThrow();

        final ObjectOpenHashSet<BlockPos> mergedPositions = new ObjectOpenHashSet<>();
        for (final UUID networkID : adjacentNetworks) {
            if (networkID.equals(largestNetworkID)) {
                continue;
            }
            final Set<BlockPos> positions = NETWORKS.remove(networkID);
            mergedPositions.addAll(positions);
            positions.forEach(position -> CABLE_NETWORKS.put(position, largestNetworkID));
        }

        final Set<BlockPos> largestNetwork = NETWORKS.get(largestNetworkID);
        largestNetwork.add(pos);
        largestNetwork.addAll(mergedPositions);
        CABLE_NETWORKS.put(pos, largestNetworkID);
        CodeLyokoMain.LOG.debug("Merged networks: {}at UUID{} final result:{}", largestNetwork, largestNetworkID, CABLE_NETWORKS);

    }

    public static void removeFromNetwork(final BlockPos pos,final ServerWorld world) {
        final CableNetworkWorldState worldState = CableNetworkWorldState.getFromServerWorld(world);
        final Object2ObjectMap<BlockPos,UUID> CABLE_NETWORKS = worldState.getCableNetworks();
        final Object2ObjectMap<UUID,ObjectOpenHashSet<BlockPos>> NETWORKS = worldState.getNetworks();
        final UUID networkId = CABLE_NETWORKS.get(pos);
        if(networkId == null){
            return;
        }
        CABLE_NETWORKS.remove(pos);
        final ObjectOpenHashSet<BlockPos> network = NETWORKS.get(networkId);
        network.remove(pos);
        CodeLyokoMain.LOG.debug("Removed network: {} with the contents:{}", networkId, network);
        if (network.isEmpty()) {
            NETWORKS.remove(networkId);
            CodeLyokoMain.LOG.debug("Removed network: {} at UUID{}", networkId, networkId);
        } else {
            final ObjectOpenHashSet<BlockPos> remaining = new ObjectOpenHashSet<>(network);
            final ObjectArrayList<ObjectOpenHashSet<BlockPos>> components = new ObjectArrayList<>();
            while (!remaining.isEmpty()) {
                final BlockPos start = remaining.iterator().next();
                final ObjectOpenHashSet<BlockPos> component = floodFill(start, remaining);
                components.add(component);
                remaining.removeAll(component);
            }
            if (components.size() > 1) {
                NETWORKS.remove(networkId);
                for (Set<BlockPos> component : components) {
                    final UUID newUUID = UUID.randomUUID();
                    NETWORKS.put(newUUID, new ObjectOpenHashSet<>(component));
                    component.forEach(position -> CABLE_NETWORKS.put(position, networkId));
                }
            }
            CodeLyokoMain.LOG.debug("split networks: {},{}", NETWORKS, CABLE_NETWORKS);
        }
    }

    private static ObjectOpenHashSet<BlockPos> floodFill(final BlockPos start, final Set<BlockPos> candidates) {
        final ObjectOpenHashSet<BlockPos> result = new ObjectOpenHashSet<>();
        final Queue<BlockPos> queue = new LinkedList<>();
        queue.add(start);
        result.add(start);
        while (!queue.isEmpty()) {
            final BlockPos current = queue.poll();
            for (final Direction direction : Direction.values()) {
                final BlockPos adjacentPos = current.offset(direction);
                if (candidates.contains(adjacentPos) && !result.contains(adjacentPos)) {
                    result.add(adjacentPos);
                    queue.add(adjacentPos);
                }
            }
        }
        return result;
    }

    @Override
    public void onBroken(final WorldAccess world, final BlockPos pos, final BlockState state) {
        super.onBroken(world, pos, state);
        if(world.isClient()){
            return;
        }
        removeFromNetwork(pos,(ServerWorld) world);


    }


    @Override
    public void onStateReplaced(final BlockState state, final World world, final BlockPos pos, final BlockState newState, final boolean moved) {
        super.onStateReplaced(state, world, pos, newState, moved);
        if(world.isClient()){
            return;
        }
        removeFromNetwork(pos,(ServerWorld) world);
    }

    @Override
    public void neighborUpdate(final BlockState state, final World world, final BlockPos pos, final Block sourceBlock, final BlockPos sourcePos, final boolean notify) {
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
        if(world.isClient()){
            return;
        }
        testNetworkConnection(pos,(ServerWorld) world);
    }
}
