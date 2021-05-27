package com.gigabyte2048.GemOPlenty.common.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class JasperRing extends Item {
	
	public JasperRing(Properties properties) {
		super(properties);
		

	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (!playerIn.getCooldownTracker().hasCooldown(this)) {
			playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 200, 3));
			playerIn.getCooldownTracker().setCooldown(this, 1000);
			return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
		}
		return ActionResult.resultFail(playerIn.getHeldItem(handIn));

		
	}
	

}
