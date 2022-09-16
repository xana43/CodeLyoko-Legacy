package net.codelyoko.world.WorldGen;

public class WorldFilter /*extends PlacementFilter*/ {
    /*
    private final Predicate<ResourceKey<Level>> check;

    public WorldFilter(Predicate<ResourceKey<Level>> test) {
        this.check = test;
    }

    @Override
    protected boolean shouldPlace(final PlacementContext ctx, final Random rand, final BlockPos pos) {
        if (check.test(ctx.getLevel().getLevel().dimension())) {
            PlacedFeature placedFeature = ctx.topFeature().orElseThrow(() -> new IllegalStateException("feature not registered"));
            Holder<Biome> biomeRegistryObject = ctx.getLevel().getBiome(pos);
            return biomeRegistryObject.value().getGenerationSettings().hasFeature(placedFeature);
        } else {
            return false;
        }
    }

    @Override
    public PlacementModifierType<?> type() {
        return PlacementModifierType.BIOME_FILTER;
    }

     */
}
