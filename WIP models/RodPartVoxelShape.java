Stream.of(
Block.makeCuboidShape(6, 0, 6, 10, 16, 10),
Block.makeCuboidShape(7, 0, 5, 9, 16, 6),
Block.makeCuboidShape(7, 0, 10, 9, 16, 11),
Block.makeCuboidShape(5, 0, 7, 6, 16, 9),
Block.makeCuboidShape(10, 0, 7, 11, 16, 9)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});