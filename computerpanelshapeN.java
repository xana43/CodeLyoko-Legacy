Stream.of(
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
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});