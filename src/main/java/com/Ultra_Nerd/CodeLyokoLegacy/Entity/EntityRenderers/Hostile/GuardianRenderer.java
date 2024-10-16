package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Hostile;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.LyokoGuardianEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.GeneralRendererUtils.CommonRenderRoutines;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public final class GuardianRenderer<T extends LyokoGuardianEntity> extends EntityRenderer<T> {
    private static final Identifier GUARDIAN_TEXTURE = CodeLyokoMain.codeLyokoPrefix("textures/entity/guardian/guardian.png"), GUARDIAN_OVERLAY = CodeLyokoMain.codeLyokoPrefix("textures/entity/guardian/guardianoverlay.png") ;
    private static final float RADIUS = 6f;
    private static final int latitude = 200, longitude = 200;
    private static final Tessellator tessellator = Tessellator.getInstance();
    public GuardianRenderer(final EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(final T entity) {
        return GUARDIAN_TEXTURE;
    }

    @Override
    public void render(final T entity, final float yaw, final float tickDelta, final MatrixStack matrices, final VertexConsumerProvider vertexConsumers, final int light) {
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);

        CommonRenderRoutines.renderTexturedSphere(tessellator,RADIUS - 1,latitude,longitude,matrices,GUARDIAN_TEXTURE,0,0,255,255,255,255,0,RADIUS / 2, 0);
        CommonRenderRoutines.renderTranslucentTexturedSphere(tessellator,RADIUS,latitude,longitude,matrices,GUARDIAN_OVERLAY,0,0,255,255,255,255,0,RADIUS / 2,0);
    }


}
