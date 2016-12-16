package mod.paintmod.client;

import java.util.ArrayList;
import java.util.List;

import mod.paintmod.PaintMod;
import mod.paintmod.client.render.ClientPaintHandler;
import mod.paintmod.client.render.RenderPaint;
import mod.paintmod.common.CommonProxy;
import mod.paintmod.common.paint.PaintHandler;
import mod.paintmod.common.paint.PaintLocation;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

	public ClientPaintHandler clientPaintHandler = new ClientPaintHandler();

	private List<PaintLocation> clientPaintList = new ArrayList<>();

	private ResourceLocation PAINTCHIPPER_PIXEL = new ResourceLocation(PaintMod.MOD_ID, "item_paintchipper_pixel");
	private ResourceLocation PAINTCHIPPER_SMALL = new ResourceLocation(PaintMod.MOD_ID, "item_paintchipper_small");
	private ResourceLocation PAINTCHIPPER_MEDIUM = new ResourceLocation(PaintMod.MOD_ID, "item_paintchipper_medium");
	private ResourceLocation PAINTCHIPPER_LARGE = new ResourceLocation(PaintMod.MOD_ID, "item_paintchipper_large");

	private ResourceLocation PAINTBRUSH_PIXEL = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_pixel");
	private ResourceLocation PAINTBRUSH_PIXEL_WHITE = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_pixel_white");
	private ResourceLocation PAINTBRUSH_PIXEL_ORANGE = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_pixel_orange");
	private ResourceLocation PAINTBRUSH_PIXEL_MAGENTA = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_pixel_magenta");
	private ResourceLocation PAINTBRUSH_PIXEL_LIGHT_BLUE = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_pixel_lightblue");
	private ResourceLocation PAINTBRUSH_PIXEL_YELLOW = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_pixel_yellow");
	private ResourceLocation PAINTBRUSH_PIXEL_LIME = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_pixel_lime");
	private ResourceLocation PAINTBRUSH_PIXEL_PINK = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_pixel_pink");
	private ResourceLocation PAINTBRUSH_PIXEL_GRAY = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_pixel_gray");
	private ResourceLocation PAINTBRUSH_PIXEL_SILVER = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_pixel_silver");
	private ResourceLocation PAINTBRUSH_PIXEL_CYAN = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_pixel_cyan");
	private ResourceLocation PAINTBRUSH_PIXEL_PURPLE = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_pixel_purple");
	private ResourceLocation PAINTBRUSH_PIXEL_BLUE = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_pixel_blue");
	private ResourceLocation PAINTBRUSH_PIXEL_BROWN = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_pixel_brown");
	private ResourceLocation PAINTBRUSH_PIXEL_GREEN = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_pixel_green");
	private ResourceLocation PAINTBRUSH_PIXEL_RED = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_pixel_red");
	private ResourceLocation PAINTBRUSH_PIXEL_BLACK = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_pixel_black");

	private ResourceLocation PAINTBRUSH_SMALL = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_small");
	private ResourceLocation PAINTBRUSH_SMALL_WHITE = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_small_white");
	private ResourceLocation PAINTBRUSH_SMALL_ORANGE = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_small_orange");
	private ResourceLocation PAINTBRUSH_SMALL_MAGENTA = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_small_magenta");
	private ResourceLocation PAINTBRUSH_SMALL_LIGHT_BLUE = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_small_lightblue");
	private ResourceLocation PAINTBRUSH_SMALL_YELLOW = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_small_yellow");
	private ResourceLocation PAINTBRUSH_SMALL_LIME = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_small_lime");
	private ResourceLocation PAINTBRUSH_SMALL_PINK = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_small_pink");
	private ResourceLocation PAINTBRUSH_SMALL_GRAY = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_small_gray");
	private ResourceLocation PAINTBRUSH_SMALL_SILVER = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_small_silver");
	private ResourceLocation PAINTBRUSH_SMALL_CYAN = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_small_cyan");
	private ResourceLocation PAINTBRUSH_SMALL_PURPLE = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_small_purple");
	private ResourceLocation PAINTBRUSH_SMALL_BLUE = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_small_blue");
	private ResourceLocation PAINTBRUSH_SMALL_BROWN = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_small_brown");
	private ResourceLocation PAINTBRUSH_SMALL_GREEN = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_small_green");
	private ResourceLocation PAINTBRUSH_SMALL_RED = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_small_red");
	private ResourceLocation PAINTBRUSH_SMALL_BLACK = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_small_black");
	
	private ResourceLocation PAINTBRUSH_MEDIUM = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_medium");
	private ResourceLocation PAINTBRUSH_MEDIUM_WHITE = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_medium_white");
	private ResourceLocation PAINTBRUSH_MEDIUM_ORANGE = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_medium_orange");
	private ResourceLocation PAINTBRUSH_MEDIUM_MAGENTA = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_medium_magenta");
	private ResourceLocation PAINTBRUSH_MEDIUM_LIGHT_BLUE = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_medium_lightblue");
	private ResourceLocation PAINTBRUSH_MEDIUM_YELLOW = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_medium_yellow");
	private ResourceLocation PAINTBRUSH_MEDIUM_LIME = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_medium_lime");
	private ResourceLocation PAINTBRUSH_MEDIUM_PINK = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_medium_pink");
	private ResourceLocation PAINTBRUSH_MEDIUM_GRAY = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_medium_gray");
	private ResourceLocation PAINTBRUSH_MEDIUM_SILVER = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_medium_silver");
	private ResourceLocation PAINTBRUSH_MEDIUM_CYAN = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_medium_cyan");
	private ResourceLocation PAINTBRUSH_MEDIUM_PURPLE = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_medium_purple");
	private ResourceLocation PAINTBRUSH_MEDIUM_BLUE = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_medium_blue");
	private ResourceLocation PAINTBRUSH_MEDIUM_BROWN = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_medium_brown");
	private ResourceLocation PAINTBRUSH_MEDIUM_GREEN = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_medium_green");
	private ResourceLocation PAINTBRUSH_MEDIUM_RED = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_medium_red");
	private ResourceLocation PAINTBRUSH_MEDIUM_BLACK = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_medium_black");
	
	private ResourceLocation PAINTBRUSH_LARGE = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_large");
	private ResourceLocation PAINTBRUSH_LARGE_WHITE = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_large_white");
	private ResourceLocation PAINTBRUSH_LARGE_ORANGE = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_large_orange");
	private ResourceLocation PAINTBRUSH_LARGE_MAGENTA = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_large_magenta");
	private ResourceLocation PAINTBRUSH_LARGE_LIGHT_BLUE = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_large_lightblue");
	private ResourceLocation PAINTBRUSH_LARGE_YELLOW = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_large_yellow");
	private ResourceLocation PAINTBRUSH_LARGE_LIME = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_large_lime");
	private ResourceLocation PAINTBRUSH_LARGE_PINK = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_large_pink");
	private ResourceLocation PAINTBRUSH_LARGE_GRAY = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_large_gray");
	private ResourceLocation PAINTBRUSH_LARGE_SILVER = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_large_silver");
	private ResourceLocation PAINTBRUSH_LARGE_CYAN = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_large_cyan");
	private ResourceLocation PAINTBRUSH_LARGE_PURPLE = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_large_purple");
	private ResourceLocation PAINTBRUSH_LARGE_BLUE = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_large_blue");
	private ResourceLocation PAINTBRUSH_LARGE_BROWN = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_large_brown");
	private ResourceLocation PAINTBRUSH_LARGE_GREEN = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_large_green");
	private ResourceLocation PAINTBRUSH_LARGE_RED = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_large_red");
	private ResourceLocation PAINTBRUSH_LARGE_BLACK = new ResourceLocation(PaintMod.MOD_ID, "item_paintbrush_large_black");

	@Override
	public void registerModel() {
		// Must be a better way of doing this????
		ModelBakery.registerItemVariants(PaintMod.proxy.itemPaintChipper, PAINTCHIPPER_PIXEL, PAINTCHIPPER_SMALL, PAINTCHIPPER_MEDIUM, PAINTCHIPPER_LARGE);

		ModelBakery.registerItemVariants(PaintMod.proxy.itemPaintbrush, PAINTBRUSH_PIXEL, PAINTBRUSH_PIXEL_WHITE, PAINTBRUSH_PIXEL_ORANGE, PAINTBRUSH_PIXEL_MAGENTA, PAINTBRUSH_PIXEL_LIGHT_BLUE,
				PAINTBRUSH_PIXEL_YELLOW, PAINTBRUSH_PIXEL_LIME, PAINTBRUSH_PIXEL_PINK, PAINTBRUSH_PIXEL_GRAY, PAINTBRUSH_PIXEL_SILVER, PAINTBRUSH_PIXEL_CYAN, PAINTBRUSH_PIXEL_PURPLE,
				PAINTBRUSH_PIXEL_BLUE, PAINTBRUSH_PIXEL_BROWN, PAINTBRUSH_PIXEL_GREEN, PAINTBRUSH_PIXEL_RED, PAINTBRUSH_PIXEL_BLACK, PAINTBRUSH_SMALL, PAINTBRUSH_SMALL_WHITE, PAINTBRUSH_SMALL_ORANGE,
				PAINTBRUSH_SMALL_MAGENTA, PAINTBRUSH_SMALL_LIGHT_BLUE, PAINTBRUSH_SMALL_YELLOW, PAINTBRUSH_SMALL_LIME, PAINTBRUSH_SMALL_PINK, PAINTBRUSH_SMALL_GRAY, PAINTBRUSH_SMALL_SILVER,
				PAINTBRUSH_SMALL_CYAN, PAINTBRUSH_SMALL_PURPLE, PAINTBRUSH_SMALL_BLUE, PAINTBRUSH_SMALL_BROWN, PAINTBRUSH_SMALL_GREEN, PAINTBRUSH_SMALL_RED, PAINTBRUSH_SMALL_BLACK, PAINTBRUSH_MEDIUM, PAINTBRUSH_MEDIUM_WHITE, PAINTBRUSH_MEDIUM_ORANGE,
				PAINTBRUSH_MEDIUM_MAGENTA, PAINTBRUSH_MEDIUM_LIGHT_BLUE, PAINTBRUSH_MEDIUM_YELLOW, PAINTBRUSH_MEDIUM_LIME, PAINTBRUSH_MEDIUM_PINK, PAINTBRUSH_MEDIUM_GRAY, PAINTBRUSH_MEDIUM_SILVER,
				PAINTBRUSH_MEDIUM_CYAN, PAINTBRUSH_MEDIUM_PURPLE, PAINTBRUSH_MEDIUM_BLUE, PAINTBRUSH_MEDIUM_BROWN, PAINTBRUSH_MEDIUM_GREEN, PAINTBRUSH_MEDIUM_RED, PAINTBRUSH_MEDIUM_BLACK, PAINTBRUSH_LARGE, PAINTBRUSH_LARGE_WHITE, PAINTBRUSH_LARGE_ORANGE,
				PAINTBRUSH_LARGE_MAGENTA, PAINTBRUSH_LARGE_LIGHT_BLUE, PAINTBRUSH_LARGE_YELLOW, PAINTBRUSH_LARGE_LIME, PAINTBRUSH_LARGE_PINK, PAINTBRUSH_LARGE_GRAY, PAINTBRUSH_LARGE_SILVER,
				PAINTBRUSH_LARGE_CYAN, PAINTBRUSH_LARGE_PURPLE, PAINTBRUSH_LARGE_BLUE, PAINTBRUSH_LARGE_BROWN, PAINTBRUSH_LARGE_GREEN, PAINTBRUSH_LARGE_RED, PAINTBRUSH_LARGE_BLACK);

		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintChipper, 0, new ModelResourceLocation("paintmod:item_paintchipper_pixel", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintChipper, 1, new ModelResourceLocation("paintmod:item_paintchipper_small", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintChipper, 2, new ModelResourceLocation("paintmod:item_paintchipper_medium", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintChipper, 3, new ModelResourceLocation("paintmod:item_paintchipper_large", "inventory"));

		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 0, new ModelResourceLocation("paintmod:item_paintbrush_pixel", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 1, new ModelResourceLocation("paintmod:item_paintbrush_pixel_white", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 2, new ModelResourceLocation("paintmod:item_paintbrush_pixel_orange", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 3, new ModelResourceLocation("paintmod:item_paintbrush_pixel_magenta", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 4, new ModelResourceLocation("paintmod:item_paintbrush_pixel_lightblue", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 5, new ModelResourceLocation("paintmod:item_paintbrush_pixel_yellow", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 6, new ModelResourceLocation("paintmod:item_paintbrush_pixel_lime", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 7, new ModelResourceLocation("paintmod:item_paintbrush_pixel_pink", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 8, new ModelResourceLocation("paintmod:item_paintbrush_pixel_gray", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 9, new ModelResourceLocation("paintmod:item_paintbrush_pixel_silver", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 10, new ModelResourceLocation("paintmod:item_paintbrush_pixel_cyan", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 11, new ModelResourceLocation("paintmod:item_paintbrush_pixel_purple", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 12, new ModelResourceLocation("paintmod:item_paintbrush_pixel_blue", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 13, new ModelResourceLocation("paintmod:item_paintbrush_pixel_brown", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 14, new ModelResourceLocation("paintmod:item_paintbrush_pixel_green", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 15, new ModelResourceLocation("paintmod:item_paintbrush_pixel_red", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 16, new ModelResourceLocation("paintmod:item_paintbrush_pixel_black", "inventory"));

		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 17, new ModelResourceLocation("paintmod:item_paintbrush_small", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 18, new ModelResourceLocation("paintmod:item_paintbrush_small_white", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 19, new ModelResourceLocation("paintmod:item_paintbrush_small_orange", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 20, new ModelResourceLocation("paintmod:item_paintbrush_small_magenta", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 21, new ModelResourceLocation("paintmod:item_paintbrush_small_lightblue", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 22, new ModelResourceLocation("paintmod:item_paintbrush_small_yellow", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 23, new ModelResourceLocation("paintmod:item_paintbrush_small_lime", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 24, new ModelResourceLocation("paintmod:item_paintbrush_small_pink", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 25, new ModelResourceLocation("paintmod:item_paintbrush_small_gray", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 26, new ModelResourceLocation("paintmod:item_paintbrush_small_silver", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 27, new ModelResourceLocation("paintmod:item_paintbrush_small_cyan", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 28, new ModelResourceLocation("paintmod:item_paintbrush_small_purple", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 29, new ModelResourceLocation("paintmod:item_paintbrush_small_blue", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 30, new ModelResourceLocation("paintmod:item_paintbrush_small_brown", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 31, new ModelResourceLocation("paintmod:item_paintbrush_small_green", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 32, new ModelResourceLocation("paintmod:item_paintbrush_small_red", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 33, new ModelResourceLocation("paintmod:item_paintbrush_small_black", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 34, new ModelResourceLocation("paintmod:item_paintbrush_medium", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 35, new ModelResourceLocation("paintmod:item_paintbrush_medium_white", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 36, new ModelResourceLocation("paintmod:item_paintbrush_medium_orange", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 37, new ModelResourceLocation("paintmod:item_paintbrush_medium_magenta", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 38, new ModelResourceLocation("paintmod:item_paintbrush_medium_lightblue", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 39, new ModelResourceLocation("paintmod:item_paintbrush_medium_yellow", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 40, new ModelResourceLocation("paintmod:item_paintbrush_medium_lime", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 41, new ModelResourceLocation("paintmod:item_paintbrush_medium_pink", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 42, new ModelResourceLocation("paintmod:item_paintbrush_medium_gray", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 43, new ModelResourceLocation("paintmod:item_paintbrush_medium_silver", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 44, new ModelResourceLocation("paintmod:item_paintbrush_medium_cyan", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 45, new ModelResourceLocation("paintmod:item_paintbrush_medium_purple", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 46, new ModelResourceLocation("paintmod:item_paintbrush_medium_blue", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 47, new ModelResourceLocation("paintmod:item_paintbrush_medium_brown", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 48, new ModelResourceLocation("paintmod:item_paintbrush_medium_green", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 49, new ModelResourceLocation("paintmod:item_paintbrush_medium_red", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 50, new ModelResourceLocation("paintmod:item_paintbrush_medium_black", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 51, new ModelResourceLocation("paintmod:item_paintbrush_large", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 52, new ModelResourceLocation("paintmod:item_paintbrush_large_white", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 53, new ModelResourceLocation("paintmod:item_paintbrush_large_orange", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 54, new ModelResourceLocation("paintmod:item_paintbrush_large_magenta", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 55, new ModelResourceLocation("paintmod:item_paintbrush_large_lightblue", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 56, new ModelResourceLocation("paintmod:item_paintbrush_large_yellow", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 57, new ModelResourceLocation("paintmod:item_paintbrush_large_lime", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 58, new ModelResourceLocation("paintmod:item_paintbrush_large_pink", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 59, new ModelResourceLocation("paintmod:item_paintbrush_large_gray", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 60, new ModelResourceLocation("paintmod:item_paintbrush_large_silver", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 61, new ModelResourceLocation("paintmod:item_paintbrush_large_cyan", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 62, new ModelResourceLocation("paintmod:item_paintbrush_large_purple", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 63, new ModelResourceLocation("paintmod:item_paintbrush_large_blue", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 64, new ModelResourceLocation("paintmod:item_paintbrush_large_brown", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 65, new ModelResourceLocation("paintmod:item_paintbrush_large_green", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 66, new ModelResourceLocation("paintmod:item_paintbrush_large_red", "inventory"));
		ModelLoader.setCustomModelResourceLocation(PaintMod.proxy.itemPaintbrush, 67, new ModelResourceLocation("paintmod:item_paintbrush_large_black", "inventory"));
	}

	@Override
	public PaintHandler getPaintHandler() {
		return clientPaintHandler;
	}

	@Override
	public List<PaintLocation> getPaintList() {
		return this.clientPaintList;
	}

	@Override
	public void addPaint(PaintLocation location) {
		this.clientPaintList.add(location);
	}

	public void addAllPaint(List<PaintLocation> location) {
		this.clientPaintList.addAll(location);
	}

	@Override
	public void removePaint(PaintLocation location) {
		this.clientPaintList.remove(location);
	}

	@Override
	public void removeAllPaint(List<PaintLocation> locations) {
		this.clientPaintList.removeAll(locations);
	}

	@Override
	public void clearPaint() {
		this.clientPaintList.clear();
	}

	@Override
	public void registerEvents() {
		super.registerEvents();
		MinecraftForge.EVENT_BUS.register(new RenderPaint());
	}

}
