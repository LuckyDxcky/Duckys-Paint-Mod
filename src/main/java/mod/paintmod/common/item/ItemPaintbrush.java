package mod.paintmod.common.item;

import java.awt.Color;

import mod.paintmod.PaintMod;
import mod.paintmod.common.paint.EnumBrushSize;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemPaintbrush extends Item {

	public ItemPaintbrush() {
		super();
		setRegistryName(new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush"));
		setUnlocalizedName(this.getRegistryName().toString());
		setHasSubtypes(true);
		maxStackSize = 1;
		setCreativeTab(PaintMod.tabPaint);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (!world.isRemote)
			return EnumActionResult.FAIL;

		if (player.dimension != 0)
			return EnumActionResult.FAIL;

		Block blockHit = world.getBlockState(pos).getBlock();
		ItemStack held = player.getHeldItem(hand);

		if (blockHit != null && blockHit != Blocks.AIR) {

			int gridX = MathHelper.floor_float(hitX / (1F / 16F));
			int gridY = MathHelper.floor_float(hitY / (1F / 16F));
			int gridZ = MathHelper.floor_float(hitZ / (1F / 16F));

			if (this.getDamage(held) < 17) {

				if (this.getDamage(held) == 0)
					return EnumActionResult.PASS;

				Color col = new Color(ItemDye.DYE_COLORS[EnumDyeColor.byMetadata(this.getDamage(held) - 1).getDyeDamage()]);

				PaintMod.proxy.getPaintHandler().onPaintbrushUse(player, world, pos, facing, gridX, gridY, gridZ, EnumBrushSize.MEDIUM, col);
			} else if (this.getDamage(held) >= 17 && this.getDamage(held) <= 33) {

				if (this.getDamage(held) == 17)
					return EnumActionResult.PASS;

				Color col = new Color(ItemDye.DYE_COLORS[EnumDyeColor.byMetadata(this.getDamage(held) - 18).getDyeDamage()]);

				PaintMod.proxy.getPaintHandler().onPaintbrushUse(player, world, pos, facing, gridX, gridY, gridZ, EnumBrushSize.SMALL, col);
			} else if (this.getDamage(held) >= 34 && this.getDamage(held) <= 50) {

				if (this.getDamage(held) == 34)
					return EnumActionResult.PASS;

				Color col = new Color(ItemDye.DYE_COLORS[EnumDyeColor.byMetadata(this.getDamage(held) - 35).getDyeDamage()]);

				PaintMod.proxy.getPaintHandler().onPaintbrushUse(player, world, pos, facing, gridX, gridY, gridZ, EnumBrushSize.MEDIUM, col);
			}
			
			else if (this.getDamage(held) >= 51 && this.getDamage(held) <= 67) {

				if (this.getDamage(held) == 51)
					return EnumActionResult.PASS;

				Color col = new Color(ItemDye.DYE_COLORS[EnumDyeColor.byMetadata(this.getDamage(held) - 52).getDyeDamage()]);

				PaintMod.proxy.getPaintHandler().onPaintbrushUse(player, world, pos, facing, gridX, gridY, gridZ, EnumBrushSize.LARGE, col);
			}
			return EnumActionResult.SUCCESS;
		}

		return EnumActionResult.PASS;
	}

	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
		for (int i = 0; i < 68; i++) {
			subItems.add(new ItemStack(itemIn, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getItemDamage()) {
		case 0:
			return super.getUnlocalizedName() + "_" + "pixel";
		case 1:
			return super.getUnlocalizedName() + "_" + "pixel" + "_" + "white";
		case 2:
			return super.getUnlocalizedName() + "_" + "pixel" + "_" + "orange";
		case 3:
			return super.getUnlocalizedName() + "_" + "pixel" + "_" + "magenta";
		case 4:
			return super.getUnlocalizedName() + "_" + "pixel" + "_" + "lightblue";
		case 5:
			return super.getUnlocalizedName() + "_" + "pixel" + "_" + "yellow";
		case 6:
			return super.getUnlocalizedName() + "_" + "pixel" + "_" + "lime";
		case 7:
			return super.getUnlocalizedName() + "_" + "pixel" + "_" + "pink";
		case 8:
			return super.getUnlocalizedName() + "_" + "pixel" + "_" + "gray";
		case 9:
			return super.getUnlocalizedName() + "_" + "pixel" + "_" + "silver";
		case 10:
			return super.getUnlocalizedName() + "_" + "pixel" + "_" + "cyan";
		case 11:
			return super.getUnlocalizedName() + "_" + "pixel" + "_" + "purple";
		case 12:
			return super.getUnlocalizedName() + "_" + "pixel" + "_" + "blue";
		case 13:
			return super.getUnlocalizedName() + "_" + "pixel" + "_" + "brown";
		case 14:
			return super.getUnlocalizedName() + "_" + "pixel" + "_" + "green";
		case 15:
			return super.getUnlocalizedName() + "_" + "pixel" + "_" + "red";
		case 16:
			return super.getUnlocalizedName() + "_" + "pixel" + "_" + "black";
		case 17:
			return super.getUnlocalizedName() + "_" + "small";
		case 18:
			return super.getUnlocalizedName() + "_" + "small" + "_" + "white";
		case 19:
			return super.getUnlocalizedName() + "_" + "small" + "_" + "orange";
		case 20:
			return super.getUnlocalizedName() + "_" + "small" + "_" + "magenta";
		case 21:
			return super.getUnlocalizedName() + "_" + "small" + "_" + "lightblue";
		case 22:
			return super.getUnlocalizedName() + "_" + "small" + "_" + "yellow";
		case 23:
			return super.getUnlocalizedName() + "_" + "small" + "_" + "lime";
		case 24:
			return super.getUnlocalizedName() + "_" + "small" + "_" + "pink";
		case 25:
			return super.getUnlocalizedName() + "_" + "small" + "_" + "gray";
		case 26:
			return super.getUnlocalizedName() + "_" + "small" + "_" + "silver";
		case 27:
			return super.getUnlocalizedName() + "_" + "small" + "_" + "cyan";
		case 28:
			return super.getUnlocalizedName() + "_" + "small" + "_" + "purple";
		case 29:
			return super.getUnlocalizedName() + "_" + "small" + "_" + "blue";
		case 30:
			return super.getUnlocalizedName() + "_" + "small" + "_" + "brown";
		case 31:
			return super.getUnlocalizedName() + "_" + "small" + "_" + "green";
		case 32:
			return super.getUnlocalizedName() + "_" + "small" + "_" + "red";
		case 33:
			return super.getUnlocalizedName() + "_" + "small" + "_" + "black";
		case 34:
			return super.getUnlocalizedName() + "_" + "medium";
		case 35:
			return super.getUnlocalizedName() + "_" + "medium" + "_" + "white";
		case 36:
			return super.getUnlocalizedName() + "_" + "medium" + "_" + "orange";
		case 37:
			return super.getUnlocalizedName() + "_" + "medium" + "_" + "magenta";
		case 38:
			return super.getUnlocalizedName() + "_" + "medium" + "_" + "lightblue";
		case 39:
			return super.getUnlocalizedName() + "_" + "medium" + "_" + "yellow";
		case 40:
			return super.getUnlocalizedName() + "_" + "medium" + "_" + "lime";
		case 41:
			return super.getUnlocalizedName() + "_" + "medium" + "_" + "pink";
		case 42:
			return super.getUnlocalizedName() + "_" + "medium" + "_" + "gray";
		case 43:
			return super.getUnlocalizedName() + "_" + "medium" + "_" + "silver";
		case 44:
			return super.getUnlocalizedName() + "_" + "medium" + "_" + "cyan";
		case 45:
			return super.getUnlocalizedName() + "_" + "medium" + "_" + "purple";
		case 46:
			return super.getUnlocalizedName() + "_" + "medium" + "_" + "blue";
		case 47:
			return super.getUnlocalizedName() + "_" + "medium" + "_" + "brown";
		case 48:
			return super.getUnlocalizedName() + "_" + "medium" + "_" + "green";
		case 49:
			return super.getUnlocalizedName() + "_" + "medium" + "_" + "red";
		case 50:
			return super.getUnlocalizedName() + "_" + "medium" + "_" + "black";
		case 51:
			return super.getUnlocalizedName() + "_" + "large";
		case 52:
			return super.getUnlocalizedName() + "_" + "large" + "_" + "white";
		case 53:
			return super.getUnlocalizedName() + "_" + "large" + "_" + "orange";
		case 54:
			return super.getUnlocalizedName() + "_" + "large" + "_" + "magenta";
		case 55:
			return super.getUnlocalizedName() + "_" + "large" + "_" + "lightblue";
		case 56:
			return super.getUnlocalizedName() + "_" + "large" + "_" + "yellow";
		case 57:
			return super.getUnlocalizedName() + "_" + "large" + "_" + "lime";
		case 58:
			return super.getUnlocalizedName() + "_" + "large" + "_" + "pink";
		case 59:
			return super.getUnlocalizedName() + "_" + "large" + "_" + "gray";
		case 60:
			return super.getUnlocalizedName() + "_" + "large" + "_" + "silver";
		case 61:
			return super.getUnlocalizedName() + "_" + "large" + "_" + "cyan";
		case 62:
			return super.getUnlocalizedName() + "_" + "large" + "_" + "purple";
		case 63:
			return super.getUnlocalizedName() + "_" + "large" + "_" + "blue";
		case 64:
			return super.getUnlocalizedName() + "_" + "large" + "_" + "brown";
		case 65:
			return super.getUnlocalizedName() + "_" + "large" + "_" + "green";
		case 66:
			return super.getUnlocalizedName() + "_" + "large" + "_" + "red";
		case 67:
			return super.getUnlocalizedName() + "_" + "large" + "_" + "black";
		}
		return super.getUnlocalizedName();
	}

}
