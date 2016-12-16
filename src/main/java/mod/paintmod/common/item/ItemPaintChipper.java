package mod.paintmod.common.item;

import mod.paintmod.PaintMod;
import mod.paintmod.common.paint.EnumBrushSize;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemPaintChipper extends Item {

	public ItemPaintChipper() {
		super();
		setRegistryName(new ResourceLocation(PaintMod.MOD_ID, "item_paintchipper"));
		setUnlocalizedName(this.getRegistryName().toString());
		setHasSubtypes(true);
		maxStackSize = 1;
		setCreativeTab(PaintMod.tabPaint);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (!world.isRemote)
			return EnumActionResult.FAIL;

		Block blockHit = world.getBlockState(pos).getBlock();

		if (blockHit != null && blockHit != Blocks.AIR) {

			int gridX = MathHelper.floor_float(hitX / (1F / 16F));
			int gridY = MathHelper.floor_float(hitY / (1F / 16F));
			int gridZ = MathHelper.floor_float(hitZ / (1F / 16F));

			switch (this.getDamage(player.getHeldItem(hand))) {
			case 0:
				PaintMod.proxy.getPaintHandler().removePaint(world, pos, facing, EnumBrushSize.PIXEL, gridX, gridY, gridZ);
				break;
			case 1:
				PaintMod.proxy.getPaintHandler().removePaint(world, pos, facing, EnumBrushSize.SMALL, gridX, gridY, gridZ);
				break;
			case 2:
				PaintMod.proxy.getPaintHandler().removePaint(world, pos, facing, EnumBrushSize.MEDIUM, gridX, gridY, gridZ);
				break;
			case 3:
				PaintMod.proxy.getPaintHandler().removePaint(world, pos, facing, EnumBrushSize.LARGE, gridX, gridY, gridZ);
				break;
			}

			return EnumActionResult.SUCCESS;
		}

		return EnumActionResult.PASS;
	}

	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
		for (int i = 0; i < 4; i++) {
			subItems.add(new ItemStack(itemIn, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getItemDamage()) {
		case 0:
			return super.getUnlocalizedName() + "_" + "pixel";
		case 1:
			return super.getUnlocalizedName() + "_" + "small";
		case 2:
			return super.getUnlocalizedName() + "_" + "medium";
		case 3:
			return super.getUnlocalizedName() + "_" + "large";
		}

		return super.getUnlocalizedName();
	}

}
