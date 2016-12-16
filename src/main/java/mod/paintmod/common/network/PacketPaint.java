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

public class PacketPaint implements IMessage, IMessageHandler<PacketPaint, IMessage> {

	private List<PaintLocation> locs;
	private boolean login;

	public PacketPaint() {
	}

	public PacketPaint(List<PaintLocation> list) {
		this.locs = new ArrayList<>();
		this.locs.addAll(list);
		this.login = false;
	}

	public PacketPaint(List<PaintLocation> list, boolean login) {
		this.locs = new ArrayList<>();
		this.locs.addAll(list);
		this.login = login;
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

		this.login = buf.readBoolean();
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

		buf.writeBoolean(this.login);
	}

	@Override
	public IMessage onMessage(final PacketPaint msg, final MessageContext ctx) {
		if (ctx.side == Side.CLIENT) {
			IThreadListener thread = Minecraft.getMinecraft();
			thread.addScheduledTask(new Runnable() {
				@Override
				public void run() {
					if (msg.login)
						PaintMod.proxy.clearPaint();

					PaintMod.proxy.getPaintHandler().addPaintForRender(msg.locs);
				}
			});
		}
		return null;
	}

}
