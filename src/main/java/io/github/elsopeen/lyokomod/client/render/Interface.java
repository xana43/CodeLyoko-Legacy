package io.github.elsopeen.lyokomod.client.render;

import net.minecraft.tileentity.TileEntity;

/**
 * A wrapper around ChunkRender.
 * Stores the a render of the chunk (16x16x16) surrounding a TileEntity
 * TODO: Make this work on 1.15
 *
 * @author Cadiboo
 * Modified by Elsopeen to match the needed type
 * still doesn't work
 */
public class Interface {
    //	// We only create one of these per cache, we reset it each time we rebuild
//	public final RegionRenderCacheBuilder regionRenderCacheBuilder;
//	private final ChunkRender chunkRender;
//	public ChunkRenderTask generator;
    private boolean isCompiled = false;

//	private Interface(final ChunkRender chunkRender, final RegionRenderCacheBuilder regionRenderCacheBuilder) {
//		this.chunkRender = chunkRender;
//		this.regionRenderCacheBuilder = regionRenderCacheBuilder;
//	}

    public static Interface forTileEntity(final TileEntity tileEntity) {
//        final ChunkRender chunkRender = new ChunkRender(tileEntity.getWorld(), Minecraft.getInstance().worldRenderer);
//        final BlockPos pos = tileEntity.getPos();
//
//		// We want to render everything in a 16x16x16 radius, with the centre being the TileEntity
//		chunkRender.setPosition(pos.getX() - 8, pos.getY() - 8, pos.getZ() - 8);
//
//		return new Interface(chunkRender, new RegionRenderCacheBuilder());
        return null;
//        return this;
    }

    /**
     * (re)build the render
     */
    public void compile() {
//		final ChunkRender chunkRender = this.chunkRender;
//		final RegionRenderCacheBuilder buffers = this.regionRenderCacheBuilder;
//
//		final ChunkRenderTask generator = chunkRender.makeCompileTaskChunk();
//		this.generator = generator;
//
//		// Setup generator
//		generator.setStatus(ChunkRenderTask.Status.COMPILING);
//		generator.setRegionRenderCacheBuilder(buffers);
//
//		final Vec3d vec3d = Minecraft.getInstance().gameRenderer.getActiveRenderInfo().getProjectedView();
//
//		// Rebuild the ChunkRender.
//		// This resets all the buffers it uses and renders every block in the chunk to the buffers
//		chunkRender.rebuildChunk((float) vec3d.x, (float) vec3d.y, (float) vec3d.z, generator);
//
//		// ChunkRender#rebuildChunk increments this, we don't want it incremented so we decrement it.
//		--ChunkRender.renderChunksUpdated;
//
//		// Set the translation of each buffer back to 0
//		final int length = BLOCK_RENDER_LAYERS.length;
//		for (int ordinal = 0; ordinal < length; ++ordinal) {
//			buffers.getBuilder(ordinal).setTranslation(0, 0, 0);
//		}
//		this.isBuilt = true;
    }

    public boolean isCompiled() {
        return isCompiled;
    }

}