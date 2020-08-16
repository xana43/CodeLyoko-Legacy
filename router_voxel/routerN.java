Stream.of(
Block.makeCuboidShape(14, 1, 8, 15, 3, 9),
Block.makeCuboidShape(0, 0, 0, 16, 3, 8),
Block.makeCuboidShape(0, 0, 8, 1, 3, 9),
Block.makeCuboidShape(15, 0, 8, 16, 3, 9),
Block.makeCuboidShape(1, 0, 8, 15, 1, 9),
Block.makeCuboidShape(1, 2, 8, 4, 3, 9),
Block.makeCuboidShape(4, 2, 8, 14, 3, 9),
Block.makeCuboidShape(4, 1, 8, 5, 2, 9),
Block.makeCuboidShape(6, 1, 8, 7, 2, 9),
Block.makeCuboidShape(8, 1, 8, 9, 2, 9),
Block.makeCuboidShape(10, 1, 8, 11, 2, 9),
Block.makeCuboidShape(12, 1, 8, 13, 2, 9)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});