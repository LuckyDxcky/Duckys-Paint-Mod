package mod.paintmod.client.render;

import java.util.List;

import mod.paintmod.PaintMod;
import mod.paintmod.common.paint.PaintHandler;
import mod.paintmod.common.paint.PaintLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientPaintHandler extends PaintHandler {

	@Override
	@SideOnly(Side.CLIENT)
	public void addPaintForRender(List<PaintLocation> locations) {
		PaintMod.proxy.addAllPaint(locations);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void removeClientPaint(List<PaintLocation> locations) {
		PaintMod.proxy.removeAllPaint(locations);
	}


	@Override
	@SideOnly(Side.CLIENT)
	public void fillList(List<PaintLocation> list) {
		PaintMod.proxy.addAllPaint(list);
	}

}
