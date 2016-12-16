package mod.paintmod.common.network;

import mod.paintmod.PaintMod;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {

	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(PaintMod.MOD_ID);

	public static void init() {
		INSTANCE.registerMessage(PacketPaint.class, PacketPaint.class, 0, Side.CLIENT);
		INSTANCE.registerMessage(PacketRemovePaint.class, PacketRemovePaint.class, 1, Side.CLIENT);
	}

}
