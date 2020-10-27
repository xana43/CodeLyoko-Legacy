Stream.of(
Block.makeCuboidShape(3, 0, 3, 10, 0.5, 4),
Block.makeCuboidShape(3, 0, 1, 10, 0.5, 2),
Block.makeCuboidShape(9, 0, 1, 16, 0.5, 2),
Block.makeCuboidShape(5, 0, 4, 7, 0.5, 11),
Block.makeCuboidShape(13, 0, 4, 15, 0.5, 11),
Block.makeCuboidShape(5, 0, 8, 7, 0.5, 15),
Block.makeCuboidShape(3.150000000000001, 0, 7, 5.149999999999999, 0.5, 14),
Block.makeCuboidShape(0.1500000000000008, 0, 8, 2.1499999999999986, 0.5, 15),
Block.makeCuboidShape(7.15, 0, 7, 9.149999999999999, 0.5, 14),
Block.makeCuboidShape(9.924999999999997, 0, 2, 11.924999999999995, 0.5, 9),
Block.makeCuboidShape(0.9249999999999972, 0, 2, 2.9249999999999954, 0.5, 9),
Block.makeCuboidShape(11.924999999999997, 0, 6, 12.924999999999995, 0.5, 13),
Block.makeCuboidShape(9.024999999999991, 0, 13.024999999999999, 16.02500000000001, 0.5, 14.024999999999997),
Block.makeCuboidShape(9.024999999999991, 0, 15.024999999999999, 16.02500000000001, 0.5, 16.025),
Block.makeCuboidShape(1.5249999999999915, 0, 15.024999999999999, 8.52500000000001, 0.5, 16.025)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});