Stream.of(
Block.makeCuboidShape(1.75, 1, 7.25, 2.75, 3, 8.25),
Block.makeCuboidShape(0.75, 0, 8.25, 16.75, 3, 16.25),
Block.makeCuboidShape(15.75, 0, 7.25, 16.75, 3, 8.25),
Block.makeCuboidShape(0.75, 0, 7.25, 1.75, 3, 8.25),
Block.makeCuboidShape(1.75, 0, 7.25, 15.75, 1, 8.25),
Block.makeCuboidShape(12.75, 2, 7.25, 15.75, 3, 8.25),
Block.makeCuboidShape(2.75, 2, 7.25, 12.75, 3, 8.25),
Block.makeCuboidShape(11.75, 1, 7.25, 12.75, 2, 8.25),
Block.makeCuboidShape(9.75, 1, 7.25, 10.75, 2, 8.25),
Block.makeCuboidShape(7.75, 1, 7.25, 8.75, 2, 8.25),
Block.makeCuboidShape(5.75, 1, 7.25, 6.75, 2, 8.25),
Block.makeCuboidShape(3.75, 1, 7.25, 4.75, 2, 8.25)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});