package mod.paintmod.client.render;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import mod.paintmod.PaintMod;
import mod.paintmod.common.paint.PaintLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderPaint {

	private Minecraft mc = Minecraft.getMinecraft();

	@SubscribeEvent
	public void onRenderWorldLastEvent(RenderWorldLastEvent event) {

		if (mc.thePlayer.dimension != 0)
			return;

		float playerX = (float) (mc.thePlayer.prevPosX + (mc.thePlayer.posX - mc.thePlayer.prevPosX) * event.getPartialTicks());
		float playerY = (float) (mc.thePlayer.prevPosY + (mc.thePlayer.posY - mc.thePlayer.prevPosY) * event.getPartialTicks());
		float playerZ = (float) (mc.thePlayer.prevPosZ + (mc.thePlayer.posZ - mc.thePlayer.prevPosZ) * event.getPartialTicks());

		//TODO: Test placement highlight
//		Item mainHand = mc.thePlayer.getHeldItemMainhand().getItem();
//		Item offHand = mc.thePlayer.getHeldItemOffhand().getItem();
//		
//		if (mainHand instanceof ItemPaintbrush) {
//			//Render highlight
//			EnumBrushSize size = null;
//			Color col = new Color(255, 0, 0, 50);
//			RayTraceResult rayTrace = mc.objectMouseOver;
//			BlockPos pos = rayTrace.getBlockPos();
//			float hitX = (float) (rayTrace.hitVec.xCoord - pos.getX());
//			float hitY = (float) (rayTrace.hitVec.yCoord - pos.getY());
//			float hitZ = (float) (rayTrace.hitVec.zCoord - pos.getZ());
//			int flooredX = MathHelper.floor_float((float) (hitX / (1F / 16F)));
//			int flooredY = MathHelper.floor_float((float) (hitY / (1F / 16F)));
//			int flooredZ = MathHelper.floor_float((float) (hitZ / (1F / 16F))); 
//			float interpX = pos.getX() - playerX;
//			float interpY = pos.getY() - playerY;
//			float interpZ = pos.getZ() - playerZ;
//			
//			renderPaintQuads(interpX, interpY, interpZ, rayTrace.sideHit, col, flooredX, flooredY, flooredZ);
//			
//		}
		
		for (PaintLocation location : PaintMod.proxy.getPaintList()) {
			int blockX = location.getBlockPos().getX();
			int blockY = location.getBlockPos().getY();
			int blockZ = location.getBlockPos().getZ();

			EnumFacing facing = location.getFacing();
			Color color = location.getColor();

			int paintX = location.getGridX();
			int paintY = location.getGridY();
			int paintZ = location.getGridZ();

			float interpX = blockX - playerX;
			float interpY = blockY - playerY;
			float interpZ = blockZ - playerZ;

			renderPaint(interpX, interpY, interpZ, facing, color, paintX, paintY, paintZ);
		}
	}

	private void renderPaint(float blockX, float blockY, float blockZ, EnumFacing face, Color color, int gridX, int gridY, int gridZ) {
		GlStateManager.pushMatrix();
		GlStateManager.disableCull();
		GlStateManager.disableTexture2D();
		GlStateManager.disableLighting();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		RenderPaint.renderPaintQuads(blockX, blockY, blockZ, face, color, gridX, gridY, gridZ);

//		if (mc.gameSettings.showDebugInfo) {
//			RenderPaint.renderPaintGrid(blockX, blockY, blockZ, face);
//		}

		GlStateManager.disableBlend();
		GlStateManager.enableLighting();
		GlStateManager.enableTexture2D();
		GlStateManager.popMatrix();
	}

	public static void renderPaintQuads(float blockX, float blockY, float blockZ, EnumFacing face, Color color, int gridX, int gridY, int gridZ) {
		float pixel = 1F / 16F;
		float offset = face == EnumFacing.SOUTH || face == EnumFacing.UP || face == EnumFacing.EAST ? 0.001F : -0.001F;
		float paintX = gridX * pixel + offset;
		float paintY = gridY * pixel + offset;
		float paintZ = gridZ * pixel + offset;

		float r = color.getRed() / 255F;
		float g = color.getGreen() / 255F;
		float b = color.getBlue() / 255F;
		float a = color.getAlpha() / 255F;

		switch (face.getAxis()) {
		case X:
			GlStateManager.glBegin(GL11.GL_QUADS);
			GlStateManager.color(r, g, b, a);
			GlStateManager.glVertex3f(blockX + paintX, blockY + paintY, blockZ + paintZ);
			GlStateManager.glVertex3f(blockX + paintX, blockY + paintY, blockZ + (paintZ + pixel));
			GlStateManager.glVertex3f(blockX + paintX, blockY + (paintY + pixel), blockZ + (paintZ + pixel));
			GlStateManager.glVertex3f(blockX + paintX, blockY + (paintY + pixel), blockZ + paintZ);
			GlStateManager.glEnd();
			break;
		case Y:
			GlStateManager.glBegin(GL11.GL_QUADS);
			GlStateManager.color(r, g, b, a);
			GlStateManager.glVertex3f(blockX + paintX, blockY + paintY, blockZ + paintZ);
			GlStateManager.glVertex3f(blockX + paintX, blockY + paintY, blockZ + (paintZ + pixel));
			GlStateManager.glVertex3f(blockX + (paintX + pixel), blockY + paintY, blockZ + (paintZ + pixel));
			GlStateManager.glVertex3f(blockX + (paintX + pixel), blockY + paintY, blockZ + paintZ);
			GlStateManager.glEnd();
			break;
		case Z:
			GlStateManager.glBegin(GL11.GL_QUADS);
			GlStateManager.color(r, g, b, a);
			GlStateManager.glVertex3f(blockX + paintX, blockY + paintY, blockZ + paintZ);
			GlStateManager.glVertex3f(blockX + paintX, blockY + (paintY + pixel), blockZ + paintZ);
			GlStateManager.glVertex3f(blockX + (paintX + pixel), blockY + (paintY + pixel), blockZ + paintZ);
			GlStateManager.glVertex3f(blockX + (paintX + pixel), blockY + paintY, blockZ + paintZ);
			GlStateManager.glEnd();
			break;
		default:
			break;

		}
	}

	public static void renderPaintGrid(float blockX, float blockY, float blockZ, EnumFacing face) {
		GlStateManager.glBegin(GL11.GL_LINES);
		GlStateManager.color(1, 0, 0);

		float pixel = 1F / 16F;

		for (int i = 0; i < 16; i++) {
			switch (face) {
			case NORTH:
				GlStateManager.glVertex3f(blockX + (pixel * i), blockY, blockZ);
				GlStateManager.glVertex3f(blockX + (pixel * i), blockY + 1, blockZ);

				GlStateManager.glVertex3f(blockX, blockY + (pixel * i), blockZ);
				GlStateManager.glVertex3f(blockX + 1, blockY + (pixel * i), blockZ);
				break;
			case SOUTH:
				GlStateManager.glVertex3f(blockX + (pixel * i), blockY, blockZ + 1 + 0.001F);
				GlStateManager.glVertex3f(blockX + (pixel * i), blockY + 1, blockZ + 1 + 0.001F);

				GlStateManager.glVertex3f(blockX, blockY + (pixel * i), blockZ + 1 + 0.001F);
				GlStateManager.glVertex3f(blockX + 1, blockY + (pixel * i), blockZ + 1 + 0.001F);
				break;
			case UP:
				GlStateManager.glVertex3f(blockX + (pixel * i), blockY + 1 + 0.001F, blockZ);
				GlStateManager.glVertex3f(blockX + (pixel * i), blockY + 1 + 0.001F, blockZ + 1);

				GlStateManager.glVertex3f(blockX + 1, blockY + 1 + 0.001F, blockZ + (pixel * i));
				GlStateManager.glVertex3f(blockX, blockY + 1 + 0.001F, blockZ + (pixel * i));
				break;
			case DOWN:
				GlStateManager.glVertex3f(blockX + (pixel * i), blockY, blockZ);
				GlStateManager.glVertex3f(blockX + (pixel * i), blockY, blockZ + 1);

				GlStateManager.glVertex3f(blockX + 1, blockY, blockZ + (pixel * i));
				GlStateManager.glVertex3f(blockX, blockY, blockZ + (pixel * i));
				break;
			case EAST:
				GlStateManager.glVertex3f(blockX + 1 - 0.001F, blockY, blockZ + (pixel * i));
				GlStateManager.glVertex3f(blockX + 1 - 0.001F, blockY + 1, blockZ + (pixel * i));

				GlStateManager.glVertex3f(blockX + 1 - 0.001F, blockY + (pixel * i), blockZ);
				GlStateManager.glVertex3f(blockX + 1 - 0.001F, blockY + (pixel * i), blockZ + 1);

				break;
			case WEST:
				GlStateManager.glVertex3f(blockX, blockY, blockZ + (pixel * i));
				GlStateManager.glVertex3f(blockX, blockY + 1, blockZ + (pixel * i));

				GlStateManager.glVertex3f(blockX, blockY + (pixel * i), blockZ);
				GlStateManager.glVertex3f(blockX, blockY + (pixel * i), blockZ + 1);
				break;
			default:
				break;
			}
		}
		GlStateManager.glEnd();
	}

}
