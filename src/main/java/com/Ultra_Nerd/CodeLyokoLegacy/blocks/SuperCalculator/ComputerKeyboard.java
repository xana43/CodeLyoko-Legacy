package com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.stream.Stream;

public final class ComputerKeyboard extends HorizontalDirectionalBlock {







    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(-0.3055970149253753, 5.24120673250286, 2.787371867921733, 15.694402985074625, 6.91620673250286, 11.787371867921731),
            Block.box(10.244402985074625, 6.387147486637496, 9.99899916689835, 11.244402985074625, 7.262147486637496, 10.99899916689835),
            Block.box(8.094402985074625, 6.387147486637496, 9.99899916689835, 9.094402985074627, 7.262147486637496, 10.99899916689835),
            Block.box(7.019402985074621, 6.387147486637496, 9.99899916689835, 8.019402985074624, 7.262147486637496, 10.99899916689835),
            Block.box(5.944402985074622, 6.387147486637496, 9.99899916689835, 6.944402985074622, 7.262147486637496, 10.99899916689835),
            Block.box(4.869402985074623, 6.387147486637496, 9.99899916689835, 5.869402985074623, 7.262147486637496, 10.99899916689835),
            Block.box(3.7944029850746235, 6.387147486637496, 9.99899916689835, 4.7944029850746235, 7.262147486637496, 10.99899916689835),
            Block.box(2.7194029850746206, 6.387147486637496, 9.99899916689835, 3.7194029850746206, 7.262147486637496, 10.99899916689835),
            Block.box(1.6444029850746213, 6.387147486637496, 9.99899916689835, 2.6444029850746213, 7.262147486637496, 10.99899916689835),
            Block.box(0.5694029850746221, 6.387147486637496, 9.99899916689835, 1.569402985074622, 7.262147486637496, 10.99899916689835),
            Block.box(9.169402985074626, 6.387147486637496, 9.99899916689835, 10.169402985074626, 7.262147486637496, 10.99899916689835),
            Block.box(11.319402985074628, 6.387147486637496, 9.99899916689835, 12.319402985074625, 7.262147486637496, 10.99899916689835),
            Block.box(12.394402985074624, 6.387147486637496, 9.99899916689835, 13.394402985074624, 7.262147486637496, 10.99899916689835),
            Block.box(13.894402985074624, 6.387147486637496, 9.99899916689835, 14.894402985074624, 7.262147486637496, 10.99899916689835),
            Block.box(13.894402985074624, 6.25309163087795, 8.42812233291787, 14.894402985074624, 7.2530916308779485, 9.42812233291787),
            Block.box(13.419402985074626, 6.258015988138169, 7.349264993371376, 14.894402985074624, 7.258015988138169, 8.349264993371374),
            Block.box(12.344402985074623, 6.258015988138169, 7.349264993371376, 13.344402985074623, 7.258015988138169, 8.349264993371374),
            Block.box(11.269402985074631, 6.258015988138169, 7.349264993371376, 12.269402985074624, 7.258015988138169, 8.349264993371374),
            Block.box(10.194402985074632, 6.258015988138169, 7.349264993371376, 11.194402985074632, 7.258015988138169, 8.349264993371374),
            Block.box(9.119402985074633, 6.258015988138169, 7.349264993371376, 10.119402985074633, 7.258015988138169, 8.349264993371374),
            Block.box(8.044402985074633, 6.258015988138169, 7.349264993371376, 9.044402985074633, 7.258015988138169, 8.349264993371374),
            Block.box(6.969402985074635, 6.258015988138169, 7.349264993371376, 7.969402985074634, 7.258015988138169, 8.349264993371374),
            Block.box(5.894402985074632, 6.258015988138169, 7.349264993371376, 6.894402985074632, 7.258015988138169, 8.349264993371374),
            Block.box(4.819402985074633, 6.258015988138169, 7.349264993371376, 5.819402985074633, 7.258015988138169, 8.349264993371374),
            Block.box(3.7444029850746334, 6.258015988138169, 7.349264993371376, 4.744402985074633, 7.258015988138169, 8.349264993371374),
            Block.box(0.544402985074627, 6.258015988138169, 7.349264993371376, 2.594402985074624, 7.258015988138169, 8.349264993371374),
            Block.box(0.544402985074627, 6.248050619185953, 6.2627450021049125, 3.144402985074625, 7.248050619185953, 7.2627450021049125),
            Block.box(3.2194029850746206, 6.248050619185953, 6.2627450021049125, 4.219402985074621, 7.248050619185953, 7.2627450021049125),
            Block.box(4.2944029850746235, 6.248050619185953, 6.2627450021049125, 5.2944029850746235, 7.248050619185953, 7.2627450021049125),
            Block.box(5.369402985074626, 6.248050619185953, 6.2627450021049125, 6.369402985074626, 7.248050619185953, 7.2627450021049125),
            Block.box(6.444402985074626, 6.248050619185953, 6.2627450021049125, 7.444402985074626, 7.248050619185953, 7.2627450021049125),
            Block.box(7.519402985074625, 6.248050619185953, 6.2627450021049125, 8.519402985074624, 7.248050619185953, 7.2627450021049125),
            Block.box(8.594402985074627, 6.248050619185953, 6.2627450021049125, 9.594402985074627, 7.248050619185953, 7.2627450021049125),
            Block.box(9.669402985074626, 6.248050619185953, 6.2627450021049125, 10.669402985074626, 7.248050619185953, 7.2627450021049125),
            Block.box(10.744402985074625, 6.248050619185953, 6.2627450021049125, 11.744402985074625, 7.248050619185953, 7.2627450021049125),
            Block.box(12.894402985074624, 6.248050619185953, 6.2627450021049125, 14.894402985074624, 7.248050619185953, 7.2627450021049125),
            Block.box(12.344402985074623, 6.2477036522149305, 5.17718655140415, 14.894402985074624, 7.2477036522149305, 6.17718655140415),
            Block.box(13.419402985074626, 6.247305369071849, 4.067569571824917, 14.894402985074624, 7.247305369071849, 5.067569571824917),
            Block.box(3.519402985074625, 6.247305369071849, 4.067569571824917, 4.994402985074626, 7.247305369071849, 5.067569571824917),
            Block.box(11.919402985074626, 6.247305369071849, 4.067569571824917, 13.319402985074625, 7.247305369071849, 5.067569571824917),
            Block.box(2.019402985074625, 6.247305369071849, 4.067569571824917, 3.4194029850746235, 7.247305369071849, 5.067569571824917),
            Block.box(5.069402985074622, 6.247305369071849, 4.067569571824917, 10.319402985074625, 7.247305369071849, 5.067569571824917),
            Block.box(10.419402985074623, 6.247305369071849, 4.067569571824917, 11.819402985074625, 7.247305369071849, 5.067569571824917),
            Block.box(0.5194029850746213, 6.247305369071849, 4.067569571824917, 1.919402985074627, 7.247305369071849, 5.067569571824917),
            Block.box(0.544402985074627, 6.2477036522149305, 5.17718655140415, 3.5944029850746277, 7.2477036522149305, 6.17718655140415),
            Block.box(11.219402985074638, 6.2477036522149305, 5.17718655140415, 12.21940298507463, 7.2477036522149305, 6.17718655140415),
            Block.box(10.144402985074631, 6.2477036522149305, 5.17718655140415, 11.144402985074631, 7.2477036522149305, 6.17718655140415),
            Block.box(9.069402985074632, 6.2477036522149305, 5.17718655140415, 10.069402985074632, 7.2477036522149305, 6.17718655140415),
            Block.box(7.994402985074629, 6.2477036522149305, 5.17718655140415, 8.994402985074629, 7.2477036522149305, 6.17718655140415),
            Block.box(6.919402985074631, 6.2477036522149305, 5.17718655140415, 7.91940298507463, 7.2477036522149305, 6.17718655140415),
            Block.box(5.844402985074631, 6.2477036522149305, 5.17718655140415, 6.844402985074631, 7.2477036522149305, 6.17718655140415),
            Block.box(4.769402985074632, 6.2477036522149305, 5.17718655140415, 5.769402985074632, 7.2477036522149305, 6.17718655140415),
            Block.box(3.6944029850746256, 6.2477036522149305, 5.17718655140415, 4.694402985074626, 7.2477036522149305, 6.17718655140415),
            Block.box(11.819402985074625, 6.248050619185953, 6.2627450021049125, 12.819402985074625, 7.248050619185953, 7.2627450021049125),
            Block.box(2.6694029850746235, 6.258015988138169, 7.349264993371376, 3.6694029850746235, 7.258015988138169, 8.349264993371374),
            Block.box(12.819402985074625, 6.25309163087795, 8.42812233291787, 13.819402985074625, 7.2530916308779485, 9.42812233291787),
            Block.box(11.744402985074625, 6.25309163087795, 8.42812233291787, 12.744402985074625, 7.2530916308779485, 9.42812233291787),
            Block.box(10.669402985074623, 6.25309163087795, 8.42812233291787, 11.669402985074626, 7.2530916308779485, 9.42812233291787),
            Block.box(9.594402985074623, 6.25309163087795, 8.42812233291787, 10.594402985074627, 7.2530916308779485, 9.42812233291787),
            Block.box(8.519402985074624, 6.25309163087795, 8.42812233291787, 9.519402985074624, 7.2530916308779485, 9.42812233291787),
            Block.box(7.444402985074626, 6.25309163087795, 8.42812233291787, 8.444402985074625, 7.2530916308779485, 9.42812233291787),
            Block.box(6.369402985074626, 6.25309163087795, 8.42812233291787, 7.369402985074626, 7.2530916308779485, 9.42812233291787),
            Block.box(5.2944029850746235, 6.25309163087795, 8.42812233291787, 6.2944029850746235, 7.2530916308779485, 9.42812233291787),
            Block.box(4.219402985074624, 6.25309163087795, 8.42812233291787, 5.219402985074624, 7.2530916308779485, 9.42812233291787),
            Block.box(3.144402985074625, 6.25309163087795, 8.42812233291787, 4.144402985074625, 7.2530916308779485, 9.42812233291787),
            Block.box(2.0694029850746256, 6.25309163087795, 8.42812233291787, 3.0694029850746256, 7.2530916308779485, 9.42812233291787),
            Block.box(0.5444029850746235, 6.25309163087795, 8.42812233291787, 1.9944029850746263, 7.2530916308779485, 9.42812233291787)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(0, 5.24120673250286, 3.650424514942717, 16, 6.91620673250286, 12.650424514942717),
            Block.box(4.449999999999998, 6.387147486637496, 4.4387972159660976, 5.449999999999998, 7.262147486637496, 5.4387972159660976),
            Block.box(6.599999999999999, 6.387147486637496, 4.4387972159660976, 7.6, 7.262147486637496, 5.4387972159660976),
            Block.box(7.675, 6.387147486637496, 4.4387972159660976, 8.675000000000002, 7.262147486637496, 5.4387972159660976),
            Block.box(8.750000000000002, 6.387147486637496, 4.4387972159660976, 9.750000000000002, 7.262147486637496, 5.4387972159660976),
            Block.box(9.825000000000003, 6.387147486637496, 4.4387972159660976, 10.825000000000003, 7.262147486637496, 5.4387972159660976),
            Block.box(10.900000000000002, 6.387147486637496, 4.4387972159660976, 11.900000000000002, 7.262147486637496, 5.4387972159660976),
            Block.box(11.975000000000003, 6.387147486637496, 4.4387972159660976, 12.975000000000003, 7.262147486637496, 5.4387972159660976),
            Block.box(13.050000000000002, 6.387147486637496, 4.4387972159660976, 14.050000000000002, 7.262147486637496, 5.4387972159660976),
            Block.box(14.125000000000002, 6.387147486637496, 4.4387972159660976, 15.125000000000002, 7.262147486637496, 5.4387972159660976),
            Block.box(5.524999999999998, 6.387147486637496, 4.4387972159660976, 6.524999999999998, 7.262147486637496, 5.4387972159660976),
            Block.box(3.374999999999999, 6.387147486637496, 4.4387972159660976, 4.374999999999997, 7.262147486637496, 5.4387972159660976),
            Block.box(2.3, 6.387147486637496, 4.4387972159660976, 3.3, 7.262147486637496, 5.4387972159660976),
            Block.box(0.7999999999999998, 6.387147486637496, 4.4387972159660976, 1.8000000000000007, 7.262147486637496, 5.4387972159660976),
            Block.box(0.7999999999999998, 6.25309163087795, 6.009674049946579, 1.8000000000000007, 7.2530916308779485, 7.009674049946579),
            Block.box(0.7999999999999998, 6.258015988138169, 7.088531389493074, 2.275000000000001, 7.258015988138169, 8.088531389493074),
            Block.box(2.3500000000000023, 6.258015988138169, 7.088531389493074, 3.350000000000002, 7.258015988138169, 8.088531389493074),
            Block.box(3.425000000000002, 6.258015988138169, 7.088531389493074, 4.424999999999994, 7.258015988138169, 8.088531389493074),
            Block.box(4.499999999999993, 6.258015988138169, 7.088531389493074, 5.499999999999993, 7.258015988138169, 8.088531389493074),
            Block.box(5.574999999999992, 6.258015988138169, 7.088531389493074, 6.574999999999992, 7.258015988138169, 8.088531389493074),
            Block.box(6.649999999999993, 6.258015988138169, 7.088531389493074, 7.6499999999999915, 7.258015988138169, 8.088531389493074),
            Block.box(7.724999999999991, 6.258015988138169, 7.088531389493074, 8.72499999999999, 7.258015988138169, 8.088531389493074),
            Block.box(8.799999999999992, 6.258015988138169, 7.088531389493074, 9.799999999999992, 7.258015988138169, 8.088531389493074),
            Block.box(9.874999999999991, 6.258015988138169, 7.088531389493074, 10.874999999999991, 7.258015988138169, 8.088531389493074),
            Block.box(10.949999999999992, 6.258015988138169, 7.088531389493074, 11.949999999999992, 7.258015988138169, 8.088531389493074),
            Block.box(13.1, 6.258015988138169, 7.088531389493074, 15.149999999999999, 7.258015988138169, 8.088531389493074),
            Block.box(12.55, 6.248050619185953, 8.17505138075954, 15.149999999999999, 7.248050619185953, 9.17505138075954),
            Block.box(11.475000000000005, 6.248050619185953, 8.17505138075954, 12.475000000000005, 7.248050619185953, 9.17505138075954),
            Block.box(10.4, 6.248050619185953, 8.17505138075954, 11.4, 7.248050619185953, 9.17505138075954),
            Block.box(9.325, 6.248050619185953, 8.17505138075954, 10.325, 7.248050619185953, 9.17505138075954),
            Block.box(8.25, 6.248050619185953, 8.17505138075954, 9.25, 7.248050619185953, 9.17505138075954),
            Block.box(7.175000000000001, 6.248050619185953, 8.17505138075954, 8.175, 7.248050619185953, 9.17505138075954),
            Block.box(6.1, 6.248050619185953, 8.17505138075954, 7.1, 7.248050619185953, 9.17505138075954),
            Block.box(5.025, 6.248050619185953, 8.17505138075954, 6.025, 7.248050619185953, 9.17505138075954),
            Block.box(3.95, 6.248050619185953, 8.17505138075954, 4.95, 7.248050619185953, 9.17505138075954),
            Block.box(0.8, 6.248050619185953, 8.17505138075954, 2.8, 7.248050619185953, 9.17505138075954),
            Block.box(0.7999999999999998, 6.2477036522149305, 9.260609831460302, 3.3500000000000014, 7.2477036522149305, 10.260609831460302),
            Block.box(0.8, 6.247305369071849, 10.370226811039535, 2.2750000000000004, 7.247305369071849, 11.370226811039535),
            Block.box(10.7, 6.247305369071849, 10.370226811039535, 12.174999999999999, 7.247305369071849, 11.370226811039535),
            Block.box(2.3750000000000018, 6.247305369071849, 10.370226811039535, 3.7750000000000004, 7.247305369071849, 11.370226811039535),
            Block.box(12.275, 6.247305369071849, 10.370226811039535, 13.674999999999999, 7.247305369071849, 11.370226811039535),
            Block.box(5.375, 6.247305369071849, 10.370226811039535, 10.625000000000004, 7.247305369071849, 11.370226811039535),
            Block.box(3.875000000000001, 6.247305369071849, 10.370226811039535, 5.275000000000004, 7.247305369071849, 11.370226811039535),
            Block.box(13.774999999999999, 6.247305369071849, 10.370226811039535, 15.175000000000002, 7.247305369071849, 11.370226811039535),
            Block.box(12.099999999999998, 6.2477036522149305, 9.260609831460302, 15.149999999999999, 7.2477036522149305, 10.260609831460302),
            Block.box(3.4749999999999934, 6.2477036522149305, 9.260609831460302, 4.474999999999986, 7.2477036522149305, 10.260609831460302),
            Block.box(4.549999999999995, 6.2477036522149305, 9.260609831460302, 5.549999999999995, 7.2477036522149305, 10.260609831460302),
            Block.box(5.624999999999995, 6.2477036522149305, 9.260609831460302, 6.624999999999995, 7.2477036522149305, 10.260609831460302),
            Block.box(6.699999999999996, 6.2477036522149305, 9.260609831460302, 7.699999999999996, 7.2477036522149305, 10.260609831460302),
            Block.box(7.774999999999995, 6.2477036522149305, 9.260609831460302, 8.774999999999993, 7.2477036522149305, 10.260609831460302),
            Block.box(8.849999999999993, 6.2477036522149305, 9.260609831460302, 9.849999999999993, 7.2477036522149305, 10.260609831460302),
            Block.box(9.924999999999994, 6.2477036522149305, 9.260609831460302, 10.924999999999994, 7.2477036522149305, 10.260609831460302),
            Block.box(11, 6.2477036522149305, 9.260609831460302, 12, 7.2477036522149305, 10.260609831460302),
            Block.box(2.875, 6.248050619185953, 8.17505138075954, 3.875, 7.248050619185953, 9.17505138075954),
            Block.box(12.025, 6.258015988138169, 7.088531389493074, 13.025, 7.258015988138169, 8.088531389493074),
            Block.box(1.875, 6.25309163087795, 6.009674049946579, 2.875000000000001, 7.2530916308779485, 7.009674049946579),
            Block.box(2.95, 6.25309163087795, 6.009674049946579, 3.950000000000001, 7.2530916308779485, 7.009674049946579),
            Block.box(4.025, 6.25309163087795, 6.009674049946579, 5.025000000000001, 7.2530916308779485, 7.009674049946579),
            Block.box(5.1, 6.25309163087795, 6.009674049946579, 6.1000000000000005, 7.2530916308779485, 7.009674049946579),
            Block.box(6.175, 6.25309163087795, 6.009674049946579, 7.175000000000001, 7.2530916308779485, 7.009674049946579),
            Block.box(7.249999999999999, 6.25309163087795, 6.009674049946579, 8.25, 7.2530916308779485, 7.009674049946579),
            Block.box(8.325, 6.25309163087795, 6.009674049946579, 9.325, 7.2530916308779485, 7.009674049946579),
            Block.box(9.4, 6.25309163087795, 6.009674049946579, 10.4, 7.2530916308779485, 7.009674049946579),
            Block.box(10.475, 6.25309163087795, 6.009674049946579, 11.475, 7.2530916308779485, 7.009674049946579),
            Block.box(11.55, 6.25309163087795, 6.009674049946579, 12.55, 7.2530916308779485, 7.009674049946579),
            Block.box(12.625, 6.25309163087795, 6.009674049946579, 13.625, 7.2530916308779485, 7.009674049946579),
            Block.box(13.7, 6.25309163087795, 6.009674049946579, 15.15, 7.2530916308779485, 7.009674049946579)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(3.778727816047806, 5.24120673250286, -0.43390031603046264, 12.778727816047805, 6.91620673250286, 15.566099683969536),
            Block.box(4.567100517071187, 6.387147486637496, 10.116099683969537, 5.567100517071187, 7.262147486637496, 11.116099683969537),
            Block.box(4.567100517071187, 6.387147486637496, 7.966099683969538, 5.567100517071187, 7.262147486637496, 8.966099683969539),
            Block.box(4.567100517071187, 6.387147486637496, 6.891099683969534, 5.567100517071187, 7.262147486637496, 7.891099683969537),
            Block.box(4.567100517071187, 6.387147486637496, 5.816099683969535, 5.567100517071187, 7.262147486637496, 6.816099683969535),
            Block.box(4.567100517071187, 6.387147486637496, 4.741099683969535, 5.567100517071187, 7.262147486637496, 5.741099683969535),
            Block.box(4.567100517071187, 6.387147486637496, 3.666099683969536, 5.567100517071187, 7.262147486637496, 4.666099683969536),
            Block.box(4.567100517071187, 6.387147486637496, 2.5910996839695333, 5.567100517071187, 7.262147486637496, 3.5910996839695333),
            Block.box(4.567100517071187, 6.387147486637496, 1.516099683969534, 5.567100517071187, 7.262147486637496, 2.516099683969534),
            Block.box(4.567100517071187, 6.387147486637496, 0.4410996839695347, 5.567100517071187, 7.262147486637496, 1.4410996839695347),
            Block.box(4.567100517071187, 6.387147486637496, 9.041099683969538, 5.567100517071187, 7.262147486637496, 10.041099683969538),
            Block.box(4.567100517071187, 6.387147486637496, 11.19109968396954, 5.567100517071187, 7.262147486637496, 12.191099683969536),
            Block.box(4.567100517071187, 6.387147486637496, 12.266099683969536, 5.567100517071187, 7.262147486637496, 13.266099683969536),
            Block.box(4.567100517071187, 6.387147486637496, 13.766099683969536, 5.567100517071187, 7.262147486637496, 14.766099683969536),
            Block.box(6.137977351051668, 6.25309163087795, 13.766099683969536, 7.137977351051668, 7.2530916308779485, 14.766099683969536),
            Block.box(7.216834690598163, 6.258015988138169, 13.291099683969538, 8.216834690598162, 7.258015988138169, 14.766099683969536),
            Block.box(7.216834690598163, 6.258015988138169, 12.216099683969535, 8.216834690598162, 7.258015988138169, 13.216099683969535),
            Block.box(7.216834690598163, 6.258015988138169, 11.141099683969543, 8.216834690598162, 7.258015988138169, 12.141099683969536),
            Block.box(7.216834690598163, 6.258015988138169, 10.066099683969544, 8.216834690598162, 7.258015988138169, 11.066099683969544),
            Block.box(7.216834690598163, 6.258015988138169, 8.991099683969544, 8.216834690598162, 7.258015988138169, 9.991099683969544),
            Block.box(7.216834690598163, 6.258015988138169, 7.916099683969546, 8.216834690598162, 7.258015988138169, 8.916099683969545),
            Block.box(7.216834690598163, 6.258015988138169, 6.8410996839695475, 8.216834690598162, 7.258015988138169, 7.841099683969547),
            Block.box(7.216834690598163, 6.258015988138169, 5.766099683969545, 8.216834690598162, 7.258015988138169, 6.766099683969545),
            Block.box(7.216834690598163, 6.258015988138169, 4.691099683969545, 8.216834690598162, 7.258015988138169, 5.691099683969545),
            Block.box(7.216834690598163, 6.258015988138169, 3.616099683969546, 8.216834690598162, 7.258015988138169, 4.616099683969546),
            Block.box(7.216834690598163, 6.258015988138169, 0.41609968396953967, 8.216834690598162, 7.258015988138169, 2.466099683969537),
            Block.box(8.303354681864626, 6.248050619185953, 0.41609968396953967, 9.303354681864626, 7.248050619185953, 3.0160996839695375),
            Block.box(8.303354681864626, 6.248050619185953, 3.0910996839695333, 9.303354681864626, 7.248050619185953, 4.091099683969533),
            Block.box(8.303354681864626, 6.248050619185953, 4.166099683969536, 9.303354681864626, 7.248050619185953, 5.166099683969536),
            Block.box(8.303354681864626, 6.248050619185953, 5.241099683969539, 9.303354681864626, 7.248050619185953, 6.241099683969539),
            Block.box(8.303354681864626, 6.248050619185953, 6.316099683969538, 9.303354681864626, 7.248050619185953, 7.316099683969538),
            Block.box(8.303354681864626, 6.248050619185953, 7.3910996839695375, 9.303354681864626, 7.248050619185953, 8.391099683969536),
            Block.box(8.303354681864626, 6.248050619185953, 8.466099683969539, 9.303354681864626, 7.248050619185953, 9.466099683969539),
            Block.box(8.303354681864626, 6.248050619185953, 9.541099683969538, 9.303354681864626, 7.248050619185953, 10.541099683969538),
            Block.box(8.303354681864626, 6.248050619185953, 10.616099683969537, 9.303354681864626, 7.248050619185953, 11.616099683969537),
            Block.box(8.303354681864626, 6.248050619185953, 12.766099683969536, 9.303354681864626, 7.248050619185953, 14.766099683969536),
            Block.box(9.388913132565389, 6.2477036522149305, 12.216099683969535, 10.388913132565389, 7.2477036522149305, 14.766099683969536),
            Block.box(10.498530112144621, 6.247305369071849, 13.291099683969538, 11.498530112144621, 7.247305369071849, 14.766099683969536),
            Block.box(10.498530112144621, 6.247305369071849, 3.3910996839695375, 11.498530112144621, 7.247305369071849, 4.866099683969539),
            Block.box(10.498530112144621, 6.247305369071849, 11.791099683969538, 11.498530112144621, 7.247305369071849, 13.191099683969536),
            Block.box(10.498530112144621, 6.247305369071849, 1.8910996839695375, 11.498530112144621, 7.247305369071849, 3.291099683969536),
            Block.box(10.498530112144621, 6.247305369071849, 4.941099683969535, 11.498530112144621, 7.247305369071849, 10.191099683969536),
            Block.box(10.498530112144621, 6.247305369071849, 10.291099683969534, 11.498530112144621, 7.247305369071849, 11.691099683969536),
            Block.box(10.498530112144621, 6.247305369071849, 0.391099683969534, 11.498530112144621, 7.247305369071849, 1.7910996839695397),
            Block.box(9.388913132565389, 6.2477036522149305, 0.41609968396953967, 10.388913132565389, 7.2477036522149305, 3.4660996839695404),
            Block.box(9.388913132565389, 6.2477036522149305, 11.09109968396955, 10.388913132565389, 7.2477036522149305, 12.091099683969542),
            Block.box(9.388913132565389, 6.2477036522149305, 10.016099683969543, 10.388913132565389, 7.2477036522149305, 11.016099683969543),
            Block.box(9.388913132565389, 6.2477036522149305, 8.941099683969544, 10.388913132565389, 7.2477036522149305, 9.941099683969544),
            Block.box(9.388913132565389, 6.2477036522149305, 7.866099683969542, 10.388913132565389, 7.2477036522149305, 8.86609968396954),
            Block.box(9.388913132565389, 6.2477036522149305, 6.791099683969543, 10.388913132565389, 7.2477036522149305, 7.791099683969542),
            Block.box(9.388913132565389, 6.2477036522149305, 5.716099683969544, 10.388913132565389, 7.2477036522149305, 6.716099683969544),
            Block.box(9.388913132565389, 6.2477036522149305, 4.641099683969545, 10.388913132565389, 7.2477036522149305, 5.641099683969545),
            Block.box(9.388913132565389, 6.2477036522149305, 3.5660996839695382, 10.388913132565389, 7.2477036522149305, 4.566099683969538),
            Block.box(8.303354681864626, 6.248050619185953, 11.691099683969536, 9.303354681864626, 7.248050619185953, 12.691099683969536),
            Block.box(7.216834690598163, 6.258015988138169, 2.541099683969536, 8.216834690598162, 7.258015988138169, 3.541099683969536),
            Block.box(6.137977351051668, 6.25309163087795, 12.691099683969536, 7.137977351051668, 7.2530916308779485, 13.691099683969536),
            Block.box(6.137977351051668, 6.25309163087795, 11.616099683969537, 7.137977351051668, 7.2530916308779485, 12.616099683969537),
            Block.box(6.137977351051668, 6.25309163087795, 10.541099683969534, 7.137977351051668, 7.2530916308779485, 11.541099683969538),
            Block.box(6.137977351051668, 6.25309163087795, 9.466099683969535, 7.137977351051668, 7.2530916308779485, 10.466099683969539),
            Block.box(6.137977351051668, 6.25309163087795, 8.391099683969536, 7.137977351051668, 7.2530916308779485, 9.391099683969536),
            Block.box(6.137977351051668, 6.25309163087795, 7.316099683969538, 7.137977351051668, 7.2530916308779485, 8.316099683969536),
            Block.box(6.137977351051668, 6.25309163087795, 6.241099683969539, 7.137977351051668, 7.2530916308779485, 7.241099683969539),
            Block.box(6.137977351051668, 6.25309163087795, 5.166099683969536, 7.137977351051668, 7.2530916308779485, 6.166099683969536),
            Block.box(6.137977351051668, 6.25309163087795, 4.091099683969537, 7.137977351051668, 7.2530916308779485, 5.091099683969537),
            Block.box(6.137977351051668, 6.25309163087795, 3.0160996839695375, 7.137977351051668, 7.2530916308779485, 4.0160996839695375),
            Block.box(6.137977351051668, 6.25309163087795, 1.9410996839695382, 7.137977351051668, 7.2530916308779485, 2.9410996839695382),
            Block.box(6.137977351051668, 6.25309163087795, 0.4160996839695361, 7.137977351051668, 7.2530916308779485, 1.866099683969539)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(2.9156751690268203, 5.24120673250286, -0.12830330110508648, 11.91567516902682, 6.91620673250286, 15.871696698894912),
            Block.box(10.127302468003439, 6.387147486637496, 4.321696698894913, 11.127302468003439, 7.262147486637496, 5.321696698894913),
            Block.box(10.127302468003439, 6.387147486637496, 6.471696698894911, 11.127302468003439, 7.262147486637496, 7.471696698894912),
            Block.box(10.127302468003439, 6.387147486637496, 7.546696698894913, 11.127302468003439, 7.262147486637496, 8.546696698894916),
            Block.box(10.127302468003439, 6.387147486637496, 8.621696698894915, 11.127302468003439, 7.262147486637496, 9.621696698894915),
            Block.box(10.127302468003439, 6.387147486637496, 9.696696698894915, 11.127302468003439, 7.262147486637496, 10.696696698894915),
            Block.box(10.127302468003439, 6.387147486637496, 10.771696698894914, 11.127302468003439, 7.262147486637496, 11.771696698894914),
            Block.box(10.127302468003439, 6.387147486637496, 11.846696698894917, 11.127302468003439, 7.262147486637496, 12.846696698894917),
            Block.box(10.127302468003439, 6.387147486637496, 12.921696698894916, 11.127302468003439, 7.262147486637496, 13.921696698894916),
            Block.box(10.127302468003439, 6.387147486637496, 13.996696698894915, 11.127302468003439, 7.262147486637496, 14.996696698894915),
            Block.box(10.127302468003439, 6.387147486637496, 5.396696698894912, 11.127302468003439, 7.262147486637496, 6.396696698894912),
            Block.box(10.127302468003439, 6.387147486637496, 3.2466966988949135, 11.127302468003439, 7.262147486637496, 4.24669669889491),
            Block.box(10.127302468003439, 6.387147486637496, 2.1716966988949142, 11.127302468003439, 7.262147486637496, 3.1716966988949142),
            Block.box(10.127302468003439, 6.387147486637496, 0.6716966988949142, 11.127302468003439, 7.262147486637496, 1.6716966988949142),
            Block.box(8.556425634022958, 6.25309163087795, 0.6716966988949142, 9.556425634022958, 7.2530916308779485, 1.6716966988949142),
            Block.box(7.477568294476463, 6.258015988138169, 0.6716966988949142, 8.477568294476463, 7.258015988138169, 2.146696698894912),
            Block.box(7.477568294476463, 6.258015988138169, 2.221696698894915, 8.477568294476463, 7.258015988138169, 3.221696698894915),
            Block.box(7.477568294476463, 6.258015988138169, 3.2966966988949142, 8.477568294476463, 7.258015988138169, 4.296696698894907),
            Block.box(7.477568294476463, 6.258015988138169, 4.371696698894906, 8.477568294476463, 7.258015988138169, 5.371696698894906),
            Block.box(7.477568294476463, 6.258015988138169, 5.446696698894906, 8.477568294476463, 7.258015988138169, 6.446696698894906),
            Block.box(7.477568294476463, 6.258015988138169, 6.521696698894905, 8.477568294476463, 7.258015988138169, 7.521696698894904),
            Block.box(7.477568294476463, 6.258015988138169, 7.596696698894903, 8.477568294476463, 7.258015988138169, 8.596696698894903),
            Block.box(7.477568294476463, 6.258015988138169, 8.671696698894905, 8.477568294476463, 7.258015988138169, 9.671696698894905),
            Block.box(7.477568294476463, 6.258015988138169, 9.746696698894905, 8.477568294476463, 7.258015988138169, 10.746696698894905),
            Block.box(7.477568294476463, 6.258015988138169, 10.821696698894904, 8.477568294476463, 7.258015988138169, 11.821696698894904),
            Block.box(7.477568294476463, 6.258015988138169, 12.971696698894913, 8.477568294476463, 7.258015988138169, 15.02169669889491),
            Block.box(6.39104830321, 6.248050619185953, 12.421696698894912, 7.39104830321, 7.248050619185953, 15.02169669889491),
            Block.box(6.39104830321, 6.248050619185953, 11.346696698894917, 7.39104830321, 7.248050619185953, 12.346696698894917),
            Block.box(6.39104830321, 6.248050619185953, 10.271696698894914, 7.39104830321, 7.248050619185953, 11.271696698894914),
            Block.box(6.39104830321, 6.248050619185953, 9.196696698894911, 7.39104830321, 7.248050619185953, 10.196696698894911),
            Block.box(6.39104830321, 6.248050619185953, 8.121696698894912, 7.39104830321, 7.248050619185953, 9.121696698894912),
            Block.box(6.39104830321, 6.248050619185953, 7.046696698894914, 7.39104830321, 7.248050619185953, 8.046696698894912),
            Block.box(6.39104830321, 6.248050619185953, 5.971696698894911, 7.39104830321, 7.248050619185953, 6.971696698894911),
            Block.box(6.39104830321, 6.248050619185953, 4.896696698894912, 7.39104830321, 7.248050619185953, 5.896696698894912),
            Block.box(6.39104830321, 6.248050619185953, 3.821696698894913, 7.39104830321, 7.248050619185953, 4.821696698894913),
            Block.box(6.39104830321, 6.248050619185953, 0.6716966988949142, 7.39104830321, 7.248050619185953, 2.6716966988949142),
            Block.box(5.305489852509237, 6.2477036522149305, 0.6716966988949142, 6.305489852509237, 7.2477036522149305, 3.221696698894915),
            Block.box(4.195872872930004, 6.247305369071849, 0.6716966988949142, 5.195872872930004, 7.247305369071849, 2.146696698894912),
            Block.box(4.195872872930004, 6.247305369071849, 10.571696698894911, 5.195872872930004, 7.247305369071849, 12.046696698894912),
            Block.box(4.195872872930004, 6.247305369071849, 2.2466966988949135, 5.195872872930004, 7.247305369071849, 3.646696698894912),
            Block.box(4.195872872930004, 6.247305369071849, 12.146696698894914, 5.195872872930004, 7.247305369071849, 13.546696698894912),
            Block.box(4.195872872930004, 6.247305369071849, 5.2466966988949135, 5.195872872930004, 7.247305369071849, 10.496696698894915),
            Block.box(4.195872872930004, 6.247305369071849, 3.7466966988949135, 5.195872872930004, 7.247305369071849, 5.146696698894916),
            Block.box(4.195872872930004, 6.247305369071849, 13.64669669889491, 5.195872872930004, 7.247305369071849, 15.046696698894916),
            Block.box(5.305489852509237, 6.2477036522149305, 11.97169669889491, 6.305489852509237, 7.2477036522149305, 15.02169669889491),
            Block.box(5.305489852509237, 6.2477036522149305, 3.346696698894908, 6.305489852509237, 7.2477036522149305, 4.346696698894901),
            Block.box(5.305489852509237, 6.2477036522149305, 4.421696698894907, 6.305489852509237, 7.2477036522149305, 5.421696698894907),
            Block.box(5.305489852509237, 6.2477036522149305, 5.496696698894906, 6.305489852509237, 7.2477036522149305, 6.496696698894906),
            Block.box(5.305489852509237, 6.2477036522149305, 6.571696698894909, 6.305489852509237, 7.2477036522149305, 7.571696698894908),
            Block.box(5.305489852509237, 6.2477036522149305, 7.646696698894908, 6.305489852509237, 7.2477036522149305, 8.646696698894907),
            Block.box(5.305489852509237, 6.2477036522149305, 8.721696698894906, 6.305489852509237, 7.2477036522149305, 9.721696698894906),
            Block.box(5.305489852509237, 6.2477036522149305, 9.796696698894905, 6.305489852509237, 7.2477036522149305, 10.796696698894905),
            Block.box(5.305489852509237, 6.2477036522149305, 10.871696698894912, 6.305489852509237, 7.2477036522149305, 11.871696698894912),
            Block.box(6.39104830321, 6.248050619185953, 2.7466966988949135, 7.39104830321, 7.248050619185953, 3.7466966988949135),
            Block.box(7.477568294476463, 6.258015988138169, 11.896696698894914, 8.477568294476463, 7.258015988138169, 12.896696698894914),
            Block.box(8.556425634022958, 6.25309163087795, 1.7466966988949135, 9.556425634022958, 7.2530916308779485, 2.7466966988949135),
            Block.box(8.556425634022958, 6.25309163087795, 2.821696698894913, 9.556425634022958, 7.2530916308779485, 3.821696698894913),
            Block.box(8.556425634022958, 6.25309163087795, 3.896696698894912, 9.556425634022958, 7.2530916308779485, 4.896696698894916),
            Block.box(8.556425634022958, 6.25309163087795, 4.971696698894911, 9.556425634022958, 7.2530916308779485, 5.971696698894915),
            Block.box(8.556425634022958, 6.25309163087795, 6.046696698894914, 9.556425634022958, 7.2530916308779485, 7.046696698894914),
            Block.box(8.556425634022958, 6.25309163087795, 7.1216966988949135, 9.556425634022958, 7.2530916308779485, 8.121696698894912),
            Block.box(8.556425634022958, 6.25309163087795, 8.196696698894911, 9.556425634022958, 7.2530916308779485, 9.196696698894911),
            Block.box(8.556425634022958, 6.25309163087795, 9.271696698894914, 9.556425634022958, 7.2530916308779485, 10.271696698894914),
            Block.box(8.556425634022958, 6.25309163087795, 10.346696698894913, 9.556425634022958, 7.2530916308779485, 11.346696698894913),
            Block.box(8.556425634022958, 6.25309163087795, 11.421696698894912, 9.556425634022958, 7.2530916308779485, 12.421696698894912),
            Block.box(8.556425634022958, 6.25309163087795, 12.496696698894912, 9.556425634022958, 7.2530916308779485, 13.496696698894912),
            Block.box(8.556425634022958, 6.25309163087795, 13.571696698894911, 9.556425634022958, 7.2530916308779485, 15.021696698894914)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();


    public ComputerKeyboard() {
        super(Block.Properties.of(Material.METAL)

                .strength(1, 10)
                .sound(SoundType.METAL)

        );

        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));


    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }



    @Nonnull
    @Override
    public VoxelShape getShape(@NotNull BlockState state, @Nonnull BlockGetter worldIn, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        switch (state.getValue(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }




    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());

    }








}
