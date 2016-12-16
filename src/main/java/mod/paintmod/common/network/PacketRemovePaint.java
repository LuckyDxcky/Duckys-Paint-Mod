package mod.paintmod.common.network;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import io.netty.buffer.ByteBuf;
import mod.paintmod.PaintMod;
import mod.paintmod.common.paint.PaintLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PacketRemovePaint implements IMessage, IMessageHandler<PacketRemovePaint, IMessage> {

	private List<PaintLocation> locs;

	public PacketRemovePaint() {

	}

	public PacketRemovePaint(List<PaintLocation> locations) {
		this.locs = new ArrayList<>();
		this.locs.addAll(locations);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.locs = new ArrayList<>();

		int len = buf.readInt();

		for (int i = 0; i < len; i++) {
			int blockX = buf.readInt();
			int blockY = buf.readInt();
			int blockZ = buf.readInt();

			int face = buf.readInt();
			int color = buf.readInt();

			int gridX = buf.readInt();
			int gridY = buf.readInt();
			int gridZ = buf.readInt();

			this.locs.add(new PaintLocation(new BlockPos(blockX, blockY, blockZ), EnumFacing.VALUES[face], new Color(color), gridX, gridY, gridZ));
		}
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.locs.size());
		for (int i = 0; i < this.locs.size(); i++) {
			buf.writeInt(this.locs.get(i).getBlockPos().getX());
			buf.writeInt(this.locs.get(i).getBlockPos().getY());
			buf.writeInt(this.locs.get(i).getBlockPos().getZ());

			buf.writeInt(this.locs.get(i).getFacing().ordinal());
			buf.writeInt(this.locs.get(i).getColor().getRGB());

			buf.writeInt(this.locs.get(i).getGridX());
			buf.writeInt(this.locs.get(i).getGridY());
			buf.writeInt(this.locs.get(i).getGridZ());
		}
	}

	@Override
	public IMessage onMessage(final PacketRemovePaint msg, MessageContext ctx) {
		if (ctx.side == Side.CLIENT) {
			IThreadListener thread = Minecraft.getMinecraft();
			thread.addScheduledTask(new Runnable() {
				@Override
				public void run() {
					PaintMod.proxy.removeAllPaint(msg.locs);
				}
			});
		}
		return null;
	}

}
