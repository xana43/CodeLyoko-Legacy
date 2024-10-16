Stream.of(
Block.makeCuboidShape(2, 0, -2, 14, 1, 18),
Block.makeCuboidShape(-4, 0, 5, -3, 32, 11),
Block.makeCuboidShape(-3, 31, 5, -2, 32, 11),
Block.makeCuboidShape(-3, 0, 5, -2, 1, 11),
Block.makeCuboidShape(19, 0, 5, 20, 32, 11),
Block.makeCuboidShape(5, 31, -3, 11, 32, -2),
Block.makeCuboidShape(5, 0, -3, 11, 1, -2),
Block.makeCuboidShape(5, 0, 19, 11, 32, 20),
Block.makeCuboidShape(5, 31, 18, 11, 32, 19),
Block.makeCuboidShape(5, 0, 18, 11, 1, 19),
Block.makeCuboidShape(-3, 0, 2, -2, 32, 5),
Block.makeCuboidShape(18, 0, 11, 19, 32, 14),
Block.makeCuboidShape(-3, 0, 11, -2, 32, 14),
Block.makeCuboidShape(18, 0, 2, 19, 32, 5),
Block.makeCuboidShape(11, 0, -3, 14, 1, -2),
Block.makeCuboidShape(11, 31, -3, 14, 32, -2),
Block.makeCuboidShape(2, 0, 18, 5, 32, 19),
Block.makeCuboidShape(2, 0, -3, 5, 1, -2),
Block.makeCuboidShape(2, 31, -3, 5, 32, -2),
Block.makeCuboidShape(11, 0, 18, 14, 32, 19),
Block.makeCuboidShape(-2, 0, 1, -1, 32, 2),
Block.makeCuboidShape(-2, 31, 2, -1, 32, 14),
Block.makeCuboidShape(-2, 0, 2, -1, 1, 14),
Block.makeCuboidShape(-1, 31, 1, 0, 32, 15),
Block.makeCuboidShape(-1, 0, 1, 0, 1, 15),
Block.makeCuboidShape(0, 31, 0, 1, 32, 16),
Block.makeCuboidShape(0, 0, 0, 1, 1, 16),
Block.makeCuboidShape(1, 31, -1, 2, 32, 17),
Block.makeCuboidShape(1, 0, -1, 2, 1, 17),
Block.makeCuboidShape(14, 31, -1, 15, 32, 17),
Block.makeCuboidShape(14, 0, -1, 15, 1, 17),
Block.makeCuboidShape(15, 31, 0, 16, 32, 16),
Block.makeCuboidShape(15, 0, 0, 16, 1, 16),
Block.makeCuboidShape(16, 31, 1, 17, 32, 15),
Block.makeCuboidShape(16, 0, 1, 17, 1, 15),
Block.makeCuboidShape(17, 31, 2, 18, 32, 14),
Block.makeCuboidShape(17, 0, 2, 18, 1, 14),
Block.makeCuboidShape(18, 31, 5, 19, 32, 11),
Block.makeCuboidShape(18, 0, 5, 19, 1, 11),
Block.makeCuboidShape(17, 0, 14, 18, 32, 15),
Block.makeCuboidShape(1, 0, 17, 2, 32, 18),
Block.makeCuboidShape(14, 0, -2, 15, 32, -1),
Block.makeCuboidShape(-1, 0, 0, 0, 32, 1),
Block.makeCuboidShape(16, 0, 15, 17, 32, 16),
Block.makeCuboidShape(0, 0, 16, 1, 32, 17),
Block.makeCuboidShape(15, 0, -1, 16, 32, 0),
Block.makeCuboidShape(0, 0, -1, 1, 32, 0),
Block.makeCuboidShape(15, 0, 16, 16, 32, 17),
Block.makeCuboidShape(-1, 0, 15, 0, 32, 16),
Block.makeCuboidShape(16, 0, 0, 17, 32, 1),
Block.makeCuboidShape(1, 0, -2, 2, 32, -1),
Block.makeCuboidShape(14, 0, 17, 15, 32, 18),
Block.makeCuboidShape(-2, 0, 14, -1, 32, 15),
Block.makeCuboidShape(17, 0, 1, 18, 32, 2),
Block.makeCuboidShape(2, 31, -2, 14, 32, 18)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});