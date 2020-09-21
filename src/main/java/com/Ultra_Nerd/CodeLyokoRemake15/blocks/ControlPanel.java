package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.ComputerControlPanelTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.stream.Stream;

public class ControlPanel extends Block {

    public static final DirectionProperty PANEL = HorizontalBlock.HORIZONTAL_FACING;
    public static final BooleanProperty ScreenOn = BooleanProperty.create("screen_on");
    private static final VoxelShape shapeN = Stream.of(
            Block.makeCuboidShape(0.09999999999999964, -4, 2.2226819720551028, 1.1000000000000014, 0.025, 3.2226819720551028),
            Block.makeCuboidShape(0.09999999999999964, 6.598148784203678, 12.919292458096445, 15.125000000000002, 7.548148784203677, 21.919292458096443),
            Block.makeCuboidShape(0.07500000000000107, 6.59814878420368, 12.085408981613261, 16.1, 7.548148784203679, 12.935408981613262),
            Block.makeCuboidShape(0.09999999999999964, 6.5908264537333405, 21.91116023151728, 16.1, 7.540826453733343, 22.811160231517285),
            Block.makeCuboidShape(-0.9000000000000004, 6.593826453733341, 12.093519544397996, 0.09999999999999964, 7.551826453733339, 22.818519544397994),
            Block.makeCuboidShape(15.100000000000001, 6.593826453733341, 12.093519544397996, 16.1, 7.551826453733339, 22.818519544397994),
            Block.makeCuboidShape(6.100000000000001, 5.8410420030171295, 12.212185676909897, 10.100000000000001, 6.8410420030171295, 18.212185676909897),
            Block.makeCuboidShape(6.100000000000001, 1, 12.222681972055103, 10.100000000000001, 11, 13.222681972055103),
            Block.makeCuboidShape(5.100000000000001, 0, 12.222681972055103, 11.100000000000001, 1, 13.222681972055103),
            Block.makeCuboidShape(11.100000000000001, -4, 11.222681972055103, 12.100000000000001, 0.9, 12.222681972055103),
            Block.makeCuboidShape(4.100000000000001, -4, 11.222681972055103, 5.100000000000001, 0.9, 12.222681972055103),
            Block.makeCuboidShape(12.100000000000001, 0, 10.222681972055103, 13.100000000000001, 0.8, 11.222681972055103),
            Block.makeCuboidShape(2.1000000000000014, -4, 10.222681972055103, 3.1000000000000014, 0.7, 11.222681972055103),
            Block.makeCuboidShape(13.100000000000001, -4, 10.222681972055103, 14.100000000000001, 0.7, 11.222681972055103),
            Block.makeCuboidShape(3.1000000000000014, 0, 10.222681972055103, 4.100000000000001, 0.8, 11.222681972055103),
            Block.makeCuboidShape(13.100000000000001, 0, 9.222681972055103, 14.100000000000001, 0.6, 10.222681972055103),
            Block.makeCuboidShape(2.1000000000000014, 0, 9.222681972055103, 3.1000000000000014, 0.6, 10.222681972055103),
            Block.makeCuboidShape(14.100000000000001, 0, 8.222681972055103, 15.100000000000001, 0.5, 9.222681972055103),
            Block.makeCuboidShape(1.1000000000000014, 0, 8.222681972055103, 2.1000000000000014, 0.5, 9.222681972055103),
            Block.makeCuboidShape(15.100000000000001, 0, 7.222681972055103, 16.1, 0.4, 8.222681972055103),
            Block.makeCuboidShape(15.100000000000001, 0, 6.222681972055103, 16.1, 0.3, 7.222681972055103),
            Block.makeCuboidShape(15.100000000000001, -5, 5.222681972055103, 16.1, 0.2, 6.222681972055103),
            Block.makeCuboidShape(15.100000000000001, 0, 4.222681972055103, 16.1, 0.1, 5.222681972055103),
            Block.makeCuboidShape(15.100000000000001, 0, 3.2226819720551028, 16.1, 0.05, 4.222681972055103),
            Block.makeCuboidShape(15.100000000000001, -4, 2.2226819720551028, 16.1, 0.025, 3.2226819720551028),
            Block.makeCuboidShape(0.09999999999999964, 0, 7.222681972055103, 1.1000000000000014, 0.4, 8.222681972055103),
            Block.makeCuboidShape(0.09999999999999964, 0, 6.222681972055103, 1.1000000000000014, 0.3, 7.222681972055103),
            Block.makeCuboidShape(0.09999999999999964, -5, 5.222681972055103, 1.1000000000000014, 0.2, 6.222681972055103),
            Block.makeCuboidShape(0.09999999999999964, 0, 4.222681972055103, 1.1000000000000014, 0.1, 5.222681972055103),
            Block.makeCuboidShape(0.09999999999999964, 0, 3.2226819720551028, 1.1000000000000014, 0.05, 4.222681972055103)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();
    private static final VoxelShape shapeS = Stream.of(
            Block.makeCuboidShape(15, -4, 14, 16, 0.025, 15),
            Block.makeCuboidShape(0.9749999999999996, 6.598148784203678, -4.69661048604134, 16, 7.548148784203677, 4.303389513958658),
            Block.makeCuboidShape(-1.7763568394002505e-15, 6.59814878420368, 4.28727299044184, 16.025, 7.548148784203679, 5.137272990441842),
            Block.makeCuboidShape(-1.7763568394002505e-15, 6.5908264537333405, -5.588478259462182, 16, 7.540826453733343, -4.688478259462176),
            Block.makeCuboidShape(16, 6.593826453733341, -5.595837572342891, 17, 7.551826453733339, 5.129162427657107),
            Block.makeCuboidShape(-1.7763568394002505e-15, 6.593826453733341, -5.595837572342891, 1, 7.551826453733339, 5.129162427657107),
            Block.makeCuboidShape(6, 5.8410420030171295, -0.9895037048547941, 10, 6.8410420030171295, 5.010496295145206),
            Block.makeCuboidShape(6, 1, 4, 10, 11, 5),
            Block.makeCuboidShape(5, 0, 4, 11, 1, 5),
            Block.makeCuboidShape(4, -4, 5, 5, 0.9, 6),
            Block.makeCuboidShape(11, -4, 5, 12, 0.9, 6),
            Block.makeCuboidShape(3, 0, 6, 4, 0.8, 7),
            Block.makeCuboidShape(13, -4, 6, 14, 0.7, 7),
            Block.makeCuboidShape(2, -4, 6, 3, 0.7, 7),
            Block.makeCuboidShape(12, 0, 6, 13, 0.8, 7),
            Block.makeCuboidShape(2, 0, 7, 3, 0.6, 8),
            Block.makeCuboidShape(13, 0, 7, 14, 0.6, 8),
            Block.makeCuboidShape(1, 0, 8, 2, 0.5, 9),
            Block.makeCuboidShape(14, 0, 8, 15, 0.5, 9),
            Block.makeCuboidShape(-1.7763568394002505e-15, 0, 9, 1, 0.4, 10),
            Block.makeCuboidShape(-1.7763568394002505e-15, 0, 10, 1, 0.3, 11),
            Block.makeCuboidShape(-1.7763568394002505e-15, -5, 11, 1, 0.2, 12),
            Block.makeCuboidShape(-1.7763568394002505e-15, 0, 12, 1, 0.1, 13),
            Block.makeCuboidShape(-1.7763568394002505e-15, 0, 13, 1, 0.05, 14),
            Block.makeCuboidShape(-1.7763568394002505e-15, -4, 14, 1, 0.025, 15),
            Block.makeCuboidShape(15, 0, 9, 16, 0.4, 10),
            Block.makeCuboidShape(15, 0, 10, 16, 0.3, 11),
            Block.makeCuboidShape(15, -5, 11, 16, 0.2, 12),
            Block.makeCuboidShape(15, 0, 12, 16, 0.1, 13),
            Block.makeCuboidShape(15, 0, 13, 16, 0.05, 14)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();
    private static final VoxelShape shapeE = Stream.of(
            Block.makeCuboidShape(13.43865901397245, -4, 0.6613409860275503, 14.43865901397245, 0.025, 1.661340986027552),
            Block.makeCuboidShape(-5.257951472068891, 6.598148784203678, 0.6613409860275503, 3.7420485279311073, 7.548148784203677, 15.686340986027552),
            Block.makeCuboidShape(3.7259320044142896, 6.59814878420368, 0.6363409860275517, 4.575932004414291, 7.548148784203679, 16.661340986027554),
            Block.makeCuboidShape(-6.1498192454897325, 6.5908264537333405, 0.6613409860275503, -5.249819245489727, 7.540826453733343, 16.661340986027554),
            Block.makeCuboidShape(-6.1571785583704415, 6.593826453733341, -0.3386590139724497, 4.567821441629556, 7.551826453733339, 0.6613409860275503),
            Block.makeCuboidShape(-6.1571785583704415, 6.593826453733341, 15.661340986027552, 4.567821441629556, 7.551826453733339, 16.661340986027554),
            Block.makeCuboidShape(-1.5508446908823448, 5.8410420030171295, 6.661340986027552, 4.449155309117655, 6.8410420030171295, 10.661340986027552),
            Block.makeCuboidShape(3.4386590139724493, 1, 6.661340986027552, 4.438659013972449, 11, 10.661340986027552),
            Block.makeCuboidShape(3.4386590139724493, 0, 5.661340986027552, 4.438659013972449, 1, 11.661340986027552),
            Block.makeCuboidShape(4.438659013972449, -4, 11.661340986027552, 5.438659013972449, 0.9, 12.661340986027552),
            Block.makeCuboidShape(4.438659013972449, -4, 4.661340986027552, 5.438659013972449, 0.9, 5.661340986027552),
            Block.makeCuboidShape(5.438659013972449, 0, 12.661340986027552, 6.438659013972449, 0.8, 13.661340986027552),
            Block.makeCuboidShape(5.438659013972449, -4, 2.661340986027552, 6.438659013972449, 0.7, 3.661340986027552),
            Block.makeCuboidShape(5.438659013972449, -4, 13.661340986027552, 6.438659013972449, 0.7, 14.661340986027552),
            Block.makeCuboidShape(5.438659013972449, 0, 3.661340986027552, 6.438659013972449, 0.8, 4.661340986027552),
            Block.makeCuboidShape(6.438659013972449, 0, 13.661340986027552, 7.438659013972449, 0.6, 14.661340986027552),
            Block.makeCuboidShape(6.438659013972449, 0, 2.661340986027552, 7.438659013972449, 0.6, 3.661340986027552),
            Block.makeCuboidShape(7.438659013972449, 0, 14.661340986027552, 8.43865901397245, 0.5, 15.661340986027552),
            Block.makeCuboidShape(7.438659013972449, 0, 1.661340986027552, 8.43865901397245, 0.5, 2.661340986027552),
            Block.makeCuboidShape(8.43865901397245, 0, 15.661340986027552, 9.43865901397245, 0.4, 16.661340986027554),
            Block.makeCuboidShape(9.43865901397245, 0, 15.661340986027552, 10.43865901397245, 0.3, 16.661340986027554),
            Block.makeCuboidShape(10.43865901397245, -5, 15.661340986027552, 11.43865901397245, 0.2, 16.661340986027554),
            Block.makeCuboidShape(11.43865901397245, 0, 15.661340986027552, 12.43865901397245, 0.1, 16.661340986027554),
            Block.makeCuboidShape(12.43865901397245, 0, 15.661340986027552, 13.43865901397245, 0.05, 16.661340986027554),
            Block.makeCuboidShape(13.43865901397245, -4, 15.661340986027552, 14.43865901397245, 0.025, 16.661340986027554),
            Block.makeCuboidShape(8.43865901397245, 0, 0.6613409860275503, 9.43865901397245, 0.4, 1.661340986027552),
            Block.makeCuboidShape(9.43865901397245, 0, 0.6613409860275503, 10.43865901397245, 0.3, 1.661340986027552),
            Block.makeCuboidShape(10.43865901397245, -5, 0.6613409860275503, 11.43865901397245, 0.2, 1.661340986027552),
            Block.makeCuboidShape(11.43865901397245, 0, 0.6613409860275503, 12.43865901397245, 0.1, 1.661340986027552),
            Block.makeCuboidShape(12.43865901397245, 0, 0.6613409860275503, 13.43865901397245, 0.05, 1.661340986027552)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();
    private static final VoxelShape shapeW = Stream.of(
            Block.makeCuboidShape(1.661340986027552, -4, 15.56134098602755, 2.661340986027552, 0.025, 16.561340986027552),
            Block.makeCuboidShape(12.357951472068894, 6.598148784203678, 1.5363409860275503, 21.35795147206889, 7.548148784203677, 16.561340986027552),
            Block.makeCuboidShape(11.52406799558571, 6.59814878420368, 0.5613409860275489, 12.374067995585712, 7.548148784203679, 16.58634098602755),
            Block.makeCuboidShape(21.349819245489726, 6.5908264537333405, 0.5613409860275489, 22.249819245489732, 7.540826453733343, 16.561340986027552),
            Block.makeCuboidShape(11.532178558370445, 6.593826453733341, 16.561340986027552, 22.25717855837044, 7.551826453733339, 17.561340986027552),
            Block.makeCuboidShape(11.532178558370445, 6.593826453733341, 0.5613409860275489, 22.25717855837044, 7.551826453733339, 1.5613409860275507),
            Block.makeCuboidShape(11.650844690882346, 5.8410420030171295, 6.561340986027551, 17.650844690882344, 6.8410420030171295, 10.56134098602755),
            Block.makeCuboidShape(11.661340986027552, 1, 6.561340986027551, 12.661340986027552, 11, 10.56134098602755),
            Block.makeCuboidShape(11.661340986027552, 0, 5.561340986027551, 12.661340986027552, 1, 11.56134098602755),
            Block.makeCuboidShape(10.661340986027552, -4, 4.561340986027551, 11.661340986027552, 0.9, 5.561340986027551),
            Block.makeCuboidShape(10.661340986027552, -4, 11.56134098602755, 11.661340986027552, 0.9, 12.56134098602755),
            Block.makeCuboidShape(9.661340986027552, 0, 3.5613409860275507, 10.661340986027552, 0.8, 4.561340986027551),
            Block.makeCuboidShape(9.661340986027552, -4, 13.56134098602755, 10.661340986027552, 0.7, 14.56134098602755),
            Block.makeCuboidShape(9.661340986027552, -4, 2.5613409860275507, 10.661340986027552, 0.7, 3.5613409860275507),
            Block.makeCuboidShape(9.661340986027552, 0, 12.56134098602755, 10.661340986027552, 0.8, 13.56134098602755),
            Block.makeCuboidShape(8.661340986027552, 0, 2.5613409860275507, 9.661340986027552, 0.6, 3.5613409860275507),
            Block.makeCuboidShape(8.661340986027552, 0, 13.56134098602755, 9.661340986027552, 0.6, 14.56134098602755),
            Block.makeCuboidShape(7.661340986027552, 0, 1.5613409860275507, 8.661340986027552, 0.5, 2.5613409860275507),
            Block.makeCuboidShape(7.661340986027552, 0, 14.56134098602755, 8.661340986027552, 0.5, 15.56134098602755),
            Block.makeCuboidShape(6.661340986027552, 0, 0.5613409860275489, 7.661340986027552, 0.4, 1.5613409860275507),
            Block.makeCuboidShape(5.661340986027552, 0, 0.5613409860275489, 6.661340986027552, 0.3, 1.5613409860275507),
            Block.makeCuboidShape(4.661340986027552, -5, 0.5613409860275489, 5.661340986027552, 0.2, 1.5613409860275507),
            Block.makeCuboidShape(3.661340986027552, 0, 0.5613409860275489, 4.661340986027552, 0.1, 1.5613409860275507),
            Block.makeCuboidShape(2.661340986027552, 0, 0.5613409860275489, 3.661340986027552, 0.05, 1.5613409860275507),
            Block.makeCuboidShape(1.661340986027552, -4, 0.5613409860275489, 2.661340986027552, 0.025, 1.5613409860275507),
            Block.makeCuboidShape(6.661340986027552, 0, 15.56134098602755, 7.661340986027552, 0.4, 16.561340986027552),
            Block.makeCuboidShape(5.661340986027552, 0, 15.56134098602755, 6.661340986027552, 0.3, 16.561340986027552),
            Block.makeCuboidShape(4.661340986027552, -5, 15.56134098602755, 5.661340986027552, 0.2, 16.561340986027552),
            Block.makeCuboidShape(3.661340986027552, 0, 15.56134098602755, 4.661340986027552, 0.1, 16.561340986027552),
            Block.makeCuboidShape(2.661340986027552, 0, 15.56134098602755, 3.661340986027552, 0.05, 16.561340986027552)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    public ControlPanel() {
        super(Properties.create(Material.IRON)

                .hardnessAndResistance(10, 10)
                .sound(SoundType.METAL)
                .lightValue(0)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        );
        this.setDefaultState(this.stateContainer.getBaseState().with(PANEL, Direction.NORTH).with(ScreenOn, false));
    }


    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(PANEL).add(ScreenOn);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.COMPUTER_CONTROL_PLANEL_TILE_ENTITY.get().create();
    }

    @Nonnull
    @Override
    public VoxelShape getShape(BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos, @Nonnull ISelectionContext context) {
        switch (state.get(PANEL)) {
            case NORTH:
                return shapeN;

            case SOUTH:
                return shapeS;

            case EAST:
                return shapeE;
            case WEST:
                return shapeW;
            default:
                return shapeN;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        // TODO Auto-generated method stub
        return this.getDefaultState().with(PANEL, context.getPlacementHorizontalFacing().getOpposite());
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(PANEL, rot.rotate(state.get(PANEL)));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(PANEL)));
    }
    //

    @Override
    public boolean isNormalCube(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isTransparent(@Nonnull BlockState state) {
        // TODO Auto-generated method stub
        return true;
    }


    @Nonnull
    @Override
    public ActionResultType onBlockActivated(@Nonnull BlockState state, World worldIn, @Nonnull BlockPos pos, @Nonnull PlayerEntity player,
                                             @Nonnull Hand handIn, @Nonnull BlockRayTraceResult result) {
        if (!worldIn.isRemote) {
            if(this.getExtendedState(state,worldIn,pos).get(ScreenOn)) {
                TileEntity panel = worldIn.getTileEntity(pos);
                if (panel instanceof ComputerControlPanelTileEntity) {
                    NetworkHooks.openGui((ServerPlayerEntity) player, (ComputerControlPanelTileEntity) panel, pos);
                    return ActionResultType.SUCCESS;
                }
           }
        }
        return ActionResultType.FAIL;
    }

}
