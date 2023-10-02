public VoxelShape makeShape(){
	VoxelShape shape = VoxelShapes.empty();
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.875, 0, 0, 1, 1, 1));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5625, 0.875, 0, 0.875, 1, 0.125));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5625, 0.875, 0.875, 0.875, 1, 1));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5625, 0.875, 0.4375, 0.875, 1, 0.5625));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0.8125, 0.4375, 0.5625, 0.9375, 0.5625));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0.8125, 0, 0.5625, 0.9375, 0.125));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0.8125, 0.875, 0.5625, 0.9375, 1));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5625, 0, 0, 0.875, 0.4375, 0.5625));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0.875, 0.4375, 0.1875, 1, 0.5625));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0.875, 0, 0.1875, 1, 0.125));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0.875, 0.875, 0.1875, 1, 1));

	return shape;
}