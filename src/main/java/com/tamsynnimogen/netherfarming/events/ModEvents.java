package com.tamsynnimogen.netherfarming.events;

import com.tamsynnimogen.netherfarming.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEvents
{
    @SubscribeEvent
    public void onCopperedEntity(AttackEntityEvent event)
    {
        if(event.getPlayer().getHeldItemMainhand().getItem() == ModItems.GLOWBERRY.get())
        {
            if(event.getTarget().isAlive())
            {
                LivingEntity target = (LivingEntity)event.getTarget();
                    PlayerEntity player = event.getPlayer();

                    // "delete" one of the held Items
                    player.getHeldItemMainhand().shrink(1);

                    target.addPotionEffect(new EffectInstance(Effects.GLOWING, 100));
                }
        }
    }
}

