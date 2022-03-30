package com.Ultra_Nerd.CodeLyokoRemake15.player;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.client.DimensionCheck;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.ContainerScreen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.OverlayRegistry;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;


@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PlayerHealthCustom {
    private static final ResourceLocation HEALTH_TEX = new ResourceLocation(CodeLyokoMain.MOD_ID, "textures/gui/lyoko_health_bar.png");


    @SubscribeEvent
    public static void removehunger(final PlayerEvent event) {

        if (event.getPlayer() != null) {

            if (DimensionCheck.playerNotInVanillaWorld(event.getPlayer()) && !event.getPlayer().isInvulnerable()) {
                event.getPlayer().getFoodData().setFoodLevel(40);
                event.getPlayer().getFoodData().setExhaustion(0);
                event.getPlayer().getFoodData().setSaturation(40);
                event.getPlayer().causeFoodExhaustion(0);
                event.getPlayer().canEat(true);
                event.getPlayer().isInvulnerableTo(DamageSource.STARVE);
                //event.getPlayer().addEffect(new MobEffectInstance(MobEffects.SATURATION, 255,255,false,false,false));



            }

        }
    }


    @SubscribeEvent
    public static void PlayerHealthRender(final RenderGameOverlayEvent.Pre renderEvent) {

        if (renderEvent.getType() == RenderGameOverlayEvent.ElementType.ALL && DimensionCheck.playerNotInVanillaWorld(Minecraft.getInstance().player != null ? Minecraft.getInstance().player : null) && Minecraft.getInstance().player != null
        ) {

            OverlayRegistry.enableOverlay(ForgeIngameGui.PLAYER_HEALTH_ELEMENT,false);
            OverlayRegistry.enableOverlay(ForgeIngameGui.FOOD_LEVEL_ELEMENT,false);
            if(!(Minecraft.getInstance().screen instanceof ContainerScreen) && !Minecraft.getInstance().player.isCreative() && !Minecraft.getInstance().player.isSpectator()) {
                //renderEvent.getMatrixStack().pushPose();
                RenderSystem.setShaderTexture(0,HEALTH_TEX);
                Minecraft.getInstance().gui.blit(renderEvent.getMatrixStack(),6, 1, 0, 0, 33, 254);
                Minecraft.getInstance().gui.blit(renderEvent.getMatrixStack(),12, 1, CodeLyokoMain.playerClassType.get(3).getTextureIndex() , 0, 25, (int) ((12.7) * Minecraft.getInstance().player.getHealth()));
                //renderEvent.getMatrixStack().popPose();
            }

        }
        else if(!Objects.requireNonNull(OverlayRegistry.getEntry(ForgeIngameGui.PLAYER_HEALTH_ELEMENT)).isEnabled() || !Objects.requireNonNull(OverlayRegistry.getEntry(ForgeIngameGui.FOOD_LEVEL_ELEMENT)).isEnabled())
        {

            assert Minecraft.getInstance().player != null;
            if(!DimensionCheck.playerNotInVanillaWorld(Minecraft.getInstance().player) && Minecraft.getInstance().player != null)
            {
                OverlayRegistry.enableOverlay(ForgeIngameGui.PLAYER_HEALTH_ELEMENT,true);
                OverlayRegistry.enableOverlay(ForgeIngameGui.FOOD_LEVEL_ELEMENT,true);
            }

        }
        


         


    }




}
