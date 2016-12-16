package mod.paintmod.common.paint;

import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mod.paintmod.PaintMod;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PaintSaveHandler {

	@SubscribeEvent
	public void onWorldLoad(WorldEvent.Load event) {
		if (!event.getWorld().isRemote)
			loadPaint(event.getWorld().getSaveHandler().getWorldDirectory());
	}

	@SubscribeEvent
	public void onWorldUnload(WorldEvent.Unload event) {
		if (!event.getWorld().isRemote)
			savePaint(event.getWorld().getSaveHandler().getWorldDirectory());
	}

	@SubscribeEvent
	public void onWorldSave(WorldEvent.Save event) {
		if (!event.getWorld().isRemote)
			savePaint(event.getWorld().getSaveHandler().getWorldDirectory());
	}

	public void savePaint(File worldDir) {
		File file = new File(worldDir, "world.paint");
		try {

			if (!file.exists())
				file.createNewFile();

			DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			out.writeInt(PaintMod.proxy.getPaintList().size());

			for (PaintLocation location : PaintMod.proxy.getPaintList()) {
				out.writeInt(location.getBlockPos().getX());
				out.writeInt(location.getBlockPos().getY());
				out.writeInt(location.getBlockPos().getZ());

				out.writeInt(location.getFacing().ordinal());
				out.writeInt(location.getColor().getRGB());

				out.writeInt(location.getGridX());
				out.writeInt(location.getGridY());
				out.writeInt(location.getGridZ());
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadPaint(File worldDir) {
		try {
			File file = new File(worldDir, "world.paint");
			DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
			List<PaintLocation> temp = new ArrayList<>();
			int size = in.readInt();
			for (int i = 0; i < size; ++i) {

				BlockPos pos = new BlockPos(in.readInt(), in.readInt(), in.readInt());

				EnumFacing face = EnumFacing.VALUES[in.readInt()];
				Color col = new Color(in.readInt());

				int gridX = in.readInt();
				int gridY = in.readInt();
				int gridZ = in.readInt();

				temp.add(new PaintLocation(pos, face, col, gridX, gridY, gridZ));
			}
			in.close();

			PaintMod.proxy.addAllPaint(temp);
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
