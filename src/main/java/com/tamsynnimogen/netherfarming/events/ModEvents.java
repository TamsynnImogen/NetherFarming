package com.tamsynnimogen.netherfarming.events;

import com.tamsynnimogen.netherfarming.block.ModBlocks;
import com.tamsynnimogen.netherfarming.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
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

    @SubscribeEvent
    public void onSoulSoilClick(PlayerInteractEvent.RightClickBlock e) {
        World worldIn = e.getWorld();
        PlayerEntity player = e.getPlayer();
        ItemStack hand = e.getItemStack();
        BlockPos pos = e.getPos();
        BlockState state = worldIn.getBlockState(pos);
        Block block = state.getBlock();
        if (worldIn.isRemote) {
            return;
        }
        if (!hand.getItem().equals(Items.BONE_MEAL)) {
            return;
        }
        if (block == (Blocks.SOUL_SOIL)) {
            worldIn.setBlockState(pos, ModBlocks.FERTILE_SOUL_SOIL.get().getDefaultState());
            if (!player.isCreative()) {
                hand.shrink(1);
            }
        }

    }
}