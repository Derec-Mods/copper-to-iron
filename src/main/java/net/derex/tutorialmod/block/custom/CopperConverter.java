package net.derex.tutorialmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CopperConverter extends Block
{
    public CopperConverter(Settings settings)
    {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit)
    {
        if (world.isClient) return ActionResult.SUCCESS;
        Inventory blockEntity = (Inventory) world.getBlockEntity(pos);

        if(!player.getStackInHand(hand).isEmpty())
        {
            if(player.getStackInHand(hand).getItem().equals(Items.COPPER_INGOT))
            {
                int cnt = player.getStackInHand(hand).getCount();
                player.getStackInHand(hand).setCount(0);
                player.giveItemStack(new ItemStack(Items.IRON_INGOT));
//                world.playSound(null, pos, SoundEvents.ENTITY_SPLASH_POTION_BREAK,);
            }
//            player.getStackInHand(hand).setCount(0);
        }
        return ActionResult.SUCCESS;
    }
}
