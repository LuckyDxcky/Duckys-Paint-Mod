package mod.paintmod.common;

import java.util.ArrayList;
import java.util.List;

import mod.paintmod.PaintMod;
import mod.paintmod.common.item.ItemPaintChipper;
import mod.paintmod.common.item.ItemPaintbrush;
import mod.paintmod.common.paint.PaintHandler;
import mod.paintmod.common.paint.PaintLocation;
import mod.paintmod.common.paint.PaintSaveHandler;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public Item itemPaintbrush;
	public Item itemPaintChipper;

	private PaintHandler paintHandler = new PaintHandler();

	private List<PaintLocation> paintList = new ArrayList<>();

	public void preInit() {
		itemPaintbrush = new ItemPaintbrush();
		GameRegistry.register(itemPaintbrush);

		itemPaintChipper = new ItemPaintChipper();
		GameRegistry.register(itemPaintChipper);
	}

	public PaintHandler getPaintHandler() {
		return paintHandler;
	}

	public List<PaintLocation> getPaintList() {
		return this.paintList;
	}

	public void addPaint(PaintLocation location) {
		this.paintList.add(location);
	}

	public void addAllPaint(List<PaintLocation> locations) {

		// Remove duplicate positions
		for (PaintLocation location : locations) {
			for (PaintLocation storedLoc : PaintMod.proxy.getPaintList()) {
				BlockPos pos = location.getBlockPos();
				EnumFacing facing = location.getFacing();
				int gridX = location.getGridX();
				int gridY = location.getGridY();
				int gridZ = location.getGridZ();

				if (storedLoc.getBlockPos().getX() == pos.getX() && storedLoc.getBlockPos().getY() == pos.getY() && storedLoc.getBlockPos().getZ() == pos.getZ()) {
					if (facing == storedLoc.getFacing()) {
						if (gridX == storedLoc.getGridX() && gridY == storedLoc.getGridY() && gridZ == storedLoc.getGridZ()) {
							PaintMod.proxy.removePaint(storedLoc);
						}
					}
				}
			}
		}

		this.paintList.addAll(locations);
	}

	public void removePaint(PaintLocation location) {
		this.paintList.remove(location);
	}

	public void removeAllPaint(List<PaintLocation> locations) {
		this.paintList.removeAll(locations);
	}

	public void clearPaint() {
		this.paintList.clear();
	}

	public void registerRecipes() {
		// Add pixel brush recipes
		for (int i = 1; i < 16; i++) {
			GameRegistry.addShapelessRecipe(new ItemStack(itemPaintbrush, 1, i),
					new Object[] { new ItemStack(itemPaintbrush, 1, 0), new ItemStack(Items.DYE, 1, EnumDyeColor.byMetadata(i - 1).getDyeDamage()) });
		}
	}

	public void registerModel() {
	}

	public void registerEvents() {
		MinecraftForge.EVENT_BUS.register(new PaintHandler());
		MinecraftForge.EVENT_BUS.register(new PaintSaveHandler());
	}

}
