Stream.of(
Block.makeCuboidShape(7.5, 1, 13.75, 8.5, 3, 14.75),
Block.makeCuboidShape(8.5, 0, -0.25, 16.5, 3, 15.75),
Block.makeCuboidShape(7.5, 0, -0.25, 8.5, 3, 0.75),
Block.makeCuboidShape(7.5, 0, 14.75, 8.5, 3, 15.75),
Block.makeCuboidShape(7.5, 0, 0.75, 8.5, 1, 14.75),
Block.makeCuboidShape(7.5, 2, 0.75, 8.5, 3, 3.75),
Block.makeCuboidShape(7.5, 2, 3.75, 8.5, 3, 13.75),
Block.makeCuboidShape(7.5, 1, 3.75, 8.5, 2, 4.75),
Block.makeCuboidShape(7.5, 1, 5.75, 8.5, 2, 6.75),
Block.makeCuboidShape(7.5, 1, 7.75, 8.5, 2, 8.75),
Block.makeCuboidShape(7.5, 1, 9.75, 8.5, 2, 10.75),
Block.makeCuboidShape(7.5, 1, 11.75, 8.5, 2, 12.75)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});