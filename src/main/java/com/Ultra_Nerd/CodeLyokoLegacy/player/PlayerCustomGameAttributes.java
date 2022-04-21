package com.Ultra_Nerd.CodeLyokoLegacy.player;

//@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public record PlayerCustomGameAttributes() {
    /*
    private static final ResourceLocation HEALTH_TEX = new ResourceLocation(CodeLyokoMain.MOD_ID, "textures/gui/lyoko_health_bar.png");




    @SubscribeEvent
    public static void PlayerDie(final @NotNull LivingDeathEvent event)
    {
        if (event.getEntity() instanceof Player playerEntity)
        {


            if (DimensionCheck.playerNotInVanillaWorld(playerEntity))
            {

                Minecraft.getInstance().getSoundManager().stop(SoundEvents.PLAYER_DEATH.getLocation(), SoundSource.PLAYERS);
                playerEntity.level.playSound(playerEntity,playerEntity.blockPosition(), ModSounds.DEVIRTUALIZATION.get(),SoundSource.PLAYERS, 1,1);
            }

        }
    }


    @SubscribeEvent
    public static void removeHunger(final @NotNull PlayerEvent event) {
        if (event.getPlayer() != null) {

            if (DimensionCheck.playerNotInVanillaWorld(event.getPlayer()) ){
                if(!event.getPlayer().isInvulnerable()) {
                    event.getPlayer().getFoodData().setFoodLevel(40);
                    event.getPlayer().getFoodData().setExhaustion(0);
                    event.getPlayer().getFoodData().setSaturation(40);
                    event.getPlayer().causeFoodExhaustion(0);
                    event.getPlayer().canEat(true);

                    //event.getPlayer().addEffect(new MobEffectInstance(MobEffects.SATURATION, 255,255,false,false,false));
                }
                if(event.getPlayer().getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).getItem() == ModItems.BLANKHELMET.get())
                {
                    final ItemStack HatItem = event.getPlayer().getInventory().getArmor(EquipmentSlot.HEAD.getIndex());
                    if(!HatItem.isEnchanted())
                    {
                        HatItem.enchant(Enchantments.BINDING_CURSE,Enchantments.BINDING_CURSE.getMaxLevel());
                    }
                    HatItem.hideTooltipPart(ItemStack.TooltipPart.ENCHANTMENTS);
                    if(HatItem.isEnchanted())
                    {
                        HatItem.getItem().isFoil(ItemStack.EMPTY);
                    }
                }

            }


        }
    }

    @SubscribeEvent
    public static void removeLiquidOverlayProperties(final @NotNull RenderBlockOverlayEvent event) {
        if (DimensionCheck.playerNotInVanillaWorld(event.getPlayer()) && event.getPlayer() != null) {
            if (event.getOverlayType() == RenderBlockOverlayEvent.OverlayType.WATER || event.getOverlayType() == RenderBlockOverlayEvent.OverlayType.FIRE) {
                event.setCanceled(true);
            }
        }
    }



    @SubscribeEvent
    public static void removeLiquidFog(final EntityViewRenderEvent.@NotNull RenderFogEvent event)
    {
        if(Minecraft.getInstance().player != null)
        {
            if(DimensionCheck.playerNotInVanillaWorld(Minecraft.getInstance().player))
            {
                event.setCanceled(true);
            }
        }
    }
    @SubscribeEvent
    public static void playerHealthRender(final RenderGameOverlayEvent.@NotNull Pre renderEvent) {
        final Minecraft mc = Minecraft.getInstance();
        if(mc.player != null) {

            if (renderEvent.getType() == RenderGameOverlayEvent.ElementType.ALL) {
                if(DimensionCheck.playerNotInVanillaWorld(mc.player)) {

                    if(Objects.requireNonNull(OverlayRegistry.getEntry(ForgeIngameGui.PLAYER_HEALTH_ELEMENT)).isEnabled() || Objects.requireNonNull(OverlayRegistry.getEntry(ForgeIngameGui.FOOD_LEVEL_ELEMENT)).isEnabled() || Objects.requireNonNull(OverlayRegistry.getEntry(ForgeIngameGui.AIR_LEVEL_ELEMENT)).isEnabled())
                    OverlayRegistry.enableOverlay(ForgeIngameGui.PLAYER_HEALTH_ELEMENT, false);
                    OverlayRegistry.enableOverlay(ForgeIngameGui.FOOD_LEVEL_ELEMENT, false);
                    OverlayRegistry.enableOverlay(ForgeIngameGui.AIR_LEVEL_ELEMENT, false);

                    if (!(mc.screen instanceof ContainerScreen) && !mc.player.isCreative() && !mc.player.isSpectator()) {
                        //renderEvent.getMatrixStack().pushPose();
                        RenderSystem.setShaderTexture(0, HEALTH_TEX);
                        mc.gui.blit(renderEvent.getMatrixStack(), (renderEvent.getWindow().getGuiScaledWidth() >> 7) - 2, renderEvent.getWindow().getGuiScaledHeight() >> 11, 0, 0, 33, 254);
                        if (ClientCapabilitySync.getPlayerClassType() != null) {
                            mc.gui.blit(renderEvent.getMatrixStack(), (renderEvent.getWindow().getGuiScaledWidth() >> 6) - 1, (renderEvent.getWindow().getGuiScaledHeight() >> 11), ClientCapabilitySync.getPlayerClassType().getTextureIndex(), 0, 25, (int) ((12.7) * mc.player.getHealth()));


                            //renderEvent.getMatrixStack().popPose();

                        }
                    }
                }
            } else if (!Objects.requireNonNull(OverlayRegistry.getEntry(ForgeIngameGui.PLAYER_HEALTH_ELEMENT)).isEnabled() || !Objects.requireNonNull(OverlayRegistry.getEntry(ForgeIngameGui.FOOD_LEVEL_ELEMENT)).isEnabled()) {


                if (!DimensionCheck.playerNotInVanillaWorld(mc.player)) {
                    OverlayRegistry.enableOverlay(ForgeIngameGui.PLAYER_HEALTH_ELEMENT, true);
                    OverlayRegistry.enableOverlay(ForgeIngameGui.FOOD_LEVEL_ELEMENT, true);
                    OverlayRegistry.enableOverlay(ForgeIngameGui.AIR_LEVEL_ELEMENT, true);
                }

            }

        }

         


    }

     */




}
