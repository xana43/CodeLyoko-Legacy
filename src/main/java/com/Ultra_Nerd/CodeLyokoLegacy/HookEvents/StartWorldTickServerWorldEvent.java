package com.Ultra_Nerd.CodeLyokoLegacy.HookEvents;

import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModStats;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.util.ConstantUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.handlers.XanaHandler;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public record StartWorldTickServerWorldEvent() {

    private static int tick = 0;
    public static void consume(final ServerWorld world) {

        world.getPlayers().parallelStream().forEach(serverPlayerEntity -> {

            //tick the xana attack handler and heal player stress
            if ((tick >> 3) % 5 == 0) {
                if (!serverPlayerEntity.getEquippedStack(EquipmentSlot.HEAD).isOf(ModItems.MIND_HELMET)) {
                    CardinalData.MindHelmStress.decreaseStress(serverPlayerEntity);
                }
                CardinalData.CellularDamage.regenerateHealth(serverPlayerEntity);

                if (serverPlayerEntity.getStatHandler().getStat(Stats.CUSTOM, ModStats.ENTERED_LYOKO_IDENTIFIER) > 0) {
                    if (XanaHandler.calculateAttackProbability()) {
                        final int notifyPlayerRandom = world.getRandom().nextInt(world.getPlayers().size());

                        world.getPlayers().get(notifyPlayerRandom).sendMessage(Text.translatable("xana.attack.start")
                                .getWithStyle(ConstantUtil.Styles.GUNSHIP.getThisStyle().withColor(Formatting.RED))
                                .get(0), true);


                    }
                }
            }
            //carry out continuous operations dependant on the dimension
            if (MethodUtil.DimensionCheck.isPlayerInLyoko(serverPlayerEntity)) {
                serverPlayerEntity.getHungerManager().setExhaustion(0);
                serverPlayerEntity.getHungerManager().setSaturationLevel(5);
                serverPlayerEntity.getAbilities().allowModifyWorld = serverPlayerEntity.isCreative();
            }
            serverPlayerEntity.getAbilities().allowModifyWorld = !MethodUtil.DimensionCheck.isPlayerInLyoko(serverPlayerEntity);


        });
        tick++;
        if(tick > 512)
        {
            tick = 0;
        }
    }
}
