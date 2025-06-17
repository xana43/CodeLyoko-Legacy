package com.Ultra_Nerd.CodeLyokoLegacy.Items.Armor;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.world.World;

public final class ArmorFeline extends LyokoArmor /*implements GeoItem*/ {

    //private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    //private final Supplier<Object> rendererProvider = GeoItem.makeRenderer(this);
    private static final double movement_modifier = 0.6;
    private static final StatusEffectInstance JUMPEFFECT = new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1, 3,
            true, false, false);

    public ArmorFeline(net.minecraft.item.equipment.ArmorMaterial material, EquipmentType type, Settings settings) {
        super(material, type, settings);
    }

    /*@Override
    public AttributeModifiersComponent getAttributeModifiers() {
        final List<AttributeModifiersComponent.Entry> entries = new ArrayList<>();
        entries.add(new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_MOVEMENT_SPEED,new EntityAttributeModifier(Identifier.of("speed_modifier"),movement_modifier, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL), AttributeModifierSlot.FEET));
       return new AttributeModifiersComponent(entries,true);
    }*/


    @Override
    public void onArmorTick(PlayerEntity player, World world, Item armorItem, EquipmentSlot slot) {
        super.onArmorTick(player, world, armorItem, slot);
        if (player.getEquippedStack(EquipmentSlot.FEET)
                .getItem() != ModItems.ODD_BOOTS || player.getEquippedStack(EquipmentSlot.LEGS).getItem() != ModItems.ODD_LEGGINGS) {
            return;
        }
        if (!player.hasStatusEffect(StatusEffects.JUMP_BOOST)) {

            player.addStatusEffect(JUMPEFFECT);


        }
        player.fallDistance = 0;
    }

/*
    @Override
    public void createRenderer(final Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private GeoArmorRenderer<?> render;
            @Override
            public BipedEntityModel<LivingEntity> getHumanoidArmorModel(final LivingEntity livingEntity, final ItemStack itemStack, final EquipmentSlot equipmentSlot, final BipedEntityModel<LivingEntity> original) {
                if(this.render == null){
                    this.render = new FelineArmorRenderer();
                }
                this.render.prepForRender(livingEntity,itemStack,equipmentSlot,original);
                return this.render;
            }
        });
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return this.rendererProvider;
    }

    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<GeoAnimatable>(this,20,state -> {
            state.getController().setAnimation(DefaultAnimations.IDLE);
            return PlayState.CONTINUE;
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }*/
}
