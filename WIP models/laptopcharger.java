public VoxelShape makeShape(){
	VoxelShape shape = VoxelShapes.empty();
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0, 0, 0.9375, 0.0625, 0.0625));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0, 0.9375, 0.9375, 0.0625, 1));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.9375, 0, 0.0625, 1, 0.0625, 0.9375));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0, 0, 0.0625, 0.125, 0.0625));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0, 0.9375, 0.0625, 0.125, 1));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.9375, 0, 0.9375, 1, 0.125, 1));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.9375, 0, 0, 1, 0.125, 0.0625));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0, 0.0625, 0.9375, 0.0625, 0.9375));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0, 0.0625, 0.0625, 0.0625, 0.9375));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0.0625, 0.0625, 0.0625, 0.125, 0.9375));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.9375, 0.0625, 0.0625, 1, 0.125, 0.9375));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0.0625, 0, 0.9375, 0.125, 0.0625));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0.0625, 0.9375, 0.9375, 0.125, 1));

	return shape;
}