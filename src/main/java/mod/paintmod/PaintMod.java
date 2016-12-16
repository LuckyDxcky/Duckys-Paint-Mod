package mod.paintmod;

import mod.paintmod.common.CommonProxy;
import mod.paintmod.common.network.PacketHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = PaintMod.MOD_ID, name = PaintMod.MOD_NAME, version = PaintMod.MOD_VER)
public class PaintMod {

	public static final String MOD_NAME = "Ducky's PaintMod";
	public static final String MOD_ID = "paintmod";
	public static final String MOD_VER = "@VERSION@";

	public static final String COMMON_PROXY = "mod.paintmod.common.CommonProxy";
	public static final String CLIENT_PROXY = "mod.paintmod.client.ClientProxy";

	@Instance(MOD_ID)
	public static PaintMod instance;

	@SidedProxy(serverSide = COMMON_PROXY, clientSide = CLIENT_PROXY)
	public static CommonProxy proxy;

	public static CreativeTabs tabPaint = new CreativeTabs("creativeTabPaint") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(proxy.itemPaintbrush, 1, 0);
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit();
		proxy.registerModel();
		proxy.registerRecipes();
		proxy.registerEvents();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		PacketHandler.init();
		proxy.getPaintHandler().initBlackList();
	}
}
