package com.Ultra_Nerd.CodeLyokoRemake15.tileentity.test;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import com.mojang.datafixers.util.Pair;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import vazkii.patchouli.api.IMultiblock;

import javax.annotation.Nullable;
import java.util.Collection;

public class TestTE extends TileEntity implements IMultiblock {
    private final ResourceLocation ID = new ResourceLocation(Base.MOD_ID, "test");

    public TestTE(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
        Base.registerMultiBlocks(ID, this);
    }

    public TestTE() {
        this(ModTileEntities.TEST_TILE_ENTITY.get());
    }

    private BlockPos core = this.pos;


    @Override
    public IMultiblock offset(int i, int i1, int i2) {
        return null;
    }

    @Override
    public IMultiblock offsetView(int i, int i1, int i2) {
        return null;
    }

    @Override
    public IMultiblock setSymmetrical(boolean b) {
        return null;
    }

    @Override
    public IMultiblock setId(ResourceLocation resourceLocation) {
        return null;
    }

    @Override
    public boolean isSymmetrical() {
        return false;
    }

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override
    public void place(World world, BlockPos blockPos, Rotation rotation) {

    }

    @Override
    public Pair<BlockPos, Collection<SimulateResult>> simulate(World world, BlockPos blockPos, Rotation rotation, boolean b) {
        return null;
    }

    @Nullable
    @Override
    public Rotation validate(World world, BlockPos blockPos) {
        return null;
    }

    @Override
    public boolean validate(World world, BlockPos blockPos, Rotation rotation) {
        return false;
    }

    @Override
    public boolean test(World world, BlockPos blockPos, int i, int i1, int i2, Rotation rotation) {
        return false;
    }

    @Override
    public Vec3i getSize() {
        return null;
    }


}
