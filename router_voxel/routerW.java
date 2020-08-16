Stream.of(
Block.makeCuboidShape(8.25, 1, 1.5, 9.25, 3, 2.5),
Block.makeCuboidShape(0.25, 0, 0.5, 8.25, 3, 16.5),
Block.makeCuboidShape(8.25, 0, 15.5, 9.25, 3, 16.5),
Block.makeCuboidShape(8.25, 0, 0.5, 9.25, 3, 1.5),
Block.makeCuboidShape(8.25, 0, 1.5, 9.25, 1, 15.5),
Block.makeCuboidShape(8.25, 2, 12.5, 9.25, 3, 15.5),
Block.makeCuboidShape(8.25, 2, 2.5, 9.25, 3, 12.5),
Block.makeCuboidShape(8.25, 1, 11.5, 9.25, 2, 12.5),
Block.makeCuboidShape(8.25, 1, 9.5, 9.25, 2, 10.5),
Block.makeCuboidShape(8.25, 1, 7.5, 9.25, 2, 8.5),
Block.makeCuboidShape(8.25, 1, 5.5, 9.25, 2, 6.5),
Block.makeCuboidShape(8.25, 1, 3.5, 9.25, 2, 4.5)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});