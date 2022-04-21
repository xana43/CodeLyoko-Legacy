package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

public final class FrontierBlock extends TransparentBlock{

/*


    private static int DamangeTime = 10000;



    @Override
    public void randomTick(final BlockState pState, final ServerLevel pLevel, final BlockPos pPos, final Random pRandom) {
        super.randomTick(pState, pLevel, pPos, pRandom);
        if(pLevel.dimension() == ModDimensions.FRONTIER) {
            DamangeTime -= this.RANDOM.nextInt(0, 10);
        }
    }

    @Override
    public void tick(final BlockState pState, final ServerLevel pLevel, final BlockPos pPos, final Random pRandom) {
        super.tick(pState, pLevel, pPos, pRandom);

        if(DamangeTime <= 0)
        {
            final LevelEntityGetter<Entity> serverEntities = pLevel.getEntities();
            final DamageSource source = new DamageSource(this.getRegistryName().toString()).bypassArmor().bypassMagic();
           for(Entity entity : serverEntities.getAll())
           {
               if(entity instanceof ItemEntity itemEntity)
               {
                   itemEntity.remove(Entity.RemovalReason.KILLED);
               }
               entity.hurt(source,this.RANDOM.nextInt(0,20));
           }
            DamangeTime = 10000;
        }
    }

 */
}
