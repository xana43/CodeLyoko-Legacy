package com.Ultra_Nerd.CodeLyokoLegacy.items.PowerupItems;

import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.security.SecureRandom;

public final class CryptoKey extends Item {
    private static final SecureRandom random = new SecureRandom();
    public CryptoKey(final Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(final World world, final PlayerEntity user, final Hand hand) {
        if(!world.isClient) {
            if (MethodUtil.DimensionCheck.isPlayerInLyoko(user)) {
                final int classId = CardinalData.LyokoClass.getLyokoClass(user);
                switch (classId) {
                    case 0 -> {
                    }
                    case 1 -> CardinalData.LyokoClass.ExtraClassData.SamuraiData.setMaxClones(user, random.nextInt(1, 3));
                    case 2 -> {
                    }
                    case 3 -> {
                    }
                    default -> throw new IllegalArgumentException("unexpected class id:" + classId);
                }
                return TypedActionResult.consume(user.getStackInHand(hand));
            }
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
