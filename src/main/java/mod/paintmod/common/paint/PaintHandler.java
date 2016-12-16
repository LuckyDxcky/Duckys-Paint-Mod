package mod.paintmod.common.paint;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import mod.paintmod.PaintMod;
import mod.paintmod.common.network.PacketHandler;
import mod.paintmod.common.network.PacketPaint;
import mod.paintmod.common.network.PacketRemovePaint;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockBeetroot;
import net.minecraft.block.BlockCake;
import net.minecraft.block.BlockChorusFlower;
import net.minecraft.block.BlockChorusPlant;
import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.BlockPressurePlateWeighted;
import net.minecraft.block.BlockRail;
import net.minecraft.block.BlockRailDetector;
import net.minecraft.block.BlockRailPowered;
import net.minecraft.block.BlockRedstoneComparator;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.block.BlockRedstoneLight;
import net.minecraft.block.BlockRedstoneTorch;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.BlockReed;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.BlockWall;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//This class is kind of bulky and could be cut down quite a lot -- but it works
//TODO: Change dependent on dimension
//TODO: Add highlight of where paint will be placed(needs testing)
//TODO: If paint doesn't have valid block to placed on then don't paint
public class PaintHandler {

	public List<Class<? extends Block>> paintBlackList = new ArrayList<>();

	public void onPaintbrushUse(EntityPlayer player, World world, BlockPos pos, EnumFacing face, int gridX, int gridY, int gridZ, EnumBrushSize size, Color color) {

		List<PaintLocation> temp = new ArrayList<>();

		switch (size) {
		case PIXEL:
			temp.add(new PaintLocation(pos, face, color, gridX, gridY, gridZ));
			break;
		case SMALL:
			temp.add(new PaintLocation(pos, face, color, gridX, gridY, gridZ));

			switch (face.getAxis()) {
			case X:
				temp.add(new PaintLocation(pos, face, color, gridX, gridY + 1, gridZ));
				temp.add(new PaintLocation(pos, face, color, gridX, gridY - 1, gridZ));
				temp.add(new PaintLocation(pos, face, color, gridX, gridY, gridZ + 1));
				temp.add(new PaintLocation(pos, face, color, gridX, gridY, gridZ - 1));

				break;
			case Y:
				temp.add(new PaintLocation(pos, face, color, gridX + 1, gridY, gridZ));
				temp.add(new PaintLocation(pos, face, color, gridX - 1, gridY, gridZ));
				temp.add(new PaintLocation(pos, face, color, gridX, gridY, gridZ + 1));
				temp.add(new PaintLocation(pos, face, color, gridX, gridY, gridZ - 1));

				break;
			case Z:
				temp.add(new PaintLocation(pos, face, color, gridX, gridY + 1, gridZ));
				temp.add(new PaintLocation(pos, face, color, gridX, gridY - 1, gridZ));
				temp.add(new PaintLocation(pos, face, color, gridX + 1, gridY, gridZ));
				temp.add(new PaintLocation(pos, face, color, gridX - 1, gridY, gridZ));
				break;
			}
			break;
		case MEDIUM:
			switch (face.getAxis()) {
			case X:
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						temp.add(new PaintLocation(pos, face, color, gridX, gridY + i - 2, gridZ + j - 1));
					}
				}

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 5; j++) {
						temp.add(new PaintLocation(pos, face, color, gridX, gridY + i - 1, gridZ + j - 2));
					}
				}
				break;
			case Y:
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						temp.add(new PaintLocation(pos, face, color, gridX + i - 2, gridY, gridZ + j - 1));
					}
				}

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 5; j++) {
						temp.add(new PaintLocation(pos, face, color, gridX + i - 1, gridY, gridZ + j - 2));
					}
				}
				break;
			case Z:
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						temp.add(new PaintLocation(pos, face, color, gridX + i - 2, gridY + j - 1, gridZ));
					}
				}

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 5; j++) {
						temp.add(new PaintLocation(pos, face, color, gridX + i - 1, gridY + j - 2, gridZ));
					}
				}
				break;

			}
			break;
		case LARGE:
			switch (face.getAxis()) {
			case X:
				for (int i = 0; i < 7; i++) {
					for (int j = 0; j < 5; j++) {
						temp.add(new PaintLocation(pos, face, color, gridX, gridY + i - 3, gridZ + j - 2));
					}
				}

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 7; j++) {
						temp.add(new PaintLocation(pos, face, color, gridX, gridY + i - 2, gridZ + j - 3));
					}
				}
				break;
			case Y:
				for (int i = 0; i < 7; i++) {
					for (int j = 0; j < 5; j++) {
						temp.add(new PaintLocation(pos, face, color, gridX + i - 3, gridY, gridZ + j - 2));
					}
				}

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 7; j++) {
						temp.add(new PaintLocation(pos, face, color, gridX + i - 2, gridY, gridZ + j - 3));
					}
				}
				break;
			case Z:
				for (int i = 0; i < 7; i++) {
					for (int j = 0; j < 5; j++) {
						temp.add(new PaintLocation(pos, face, color, gridX + i - 3, gridY + j - 2, gridZ));
					}
				}

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 7; j++) {
						temp.add(new PaintLocation(pos, face, color, gridX + i - 2, gridY + j - 3, gridZ));
					}
				}
				break;

			}
			break;
		}

		List<PaintLocation> toRemove = new ArrayList<>();
		for (PaintLocation location : PaintMod.proxy.getPaintList()) {
			BlockPos bp = location.getBlockPos();
			EnumFacing facing = location.getFacing();
			float x = location.getGridX();
			float y = location.getGridY();
			float z = location.getGridZ();

			if (pos.getX() == bp.getX() && pos.getY() == bp.getY() && pos.getZ() == bp.getZ()) {
				if (face == facing) {
					if (gridX == x && gridY == y && gridZ == z) {
						toRemove.add(location);
					}
				}
			}
		}

		PaintMod.proxy.removeAllPaint(toRemove);
		PaintMod.proxy.addAllPaint(temp);
		PacketHandler.INSTANCE.sendToAll(new PacketPaint(temp));
	}

	public void removePaint(World world, BlockPos pos, EnumFacing face, EnumBrushSize size, int gridX, int gridY, int gridZ) {
		List<PaintLocation> toRemove = new ArrayList<>();
		for (PaintLocation location : PaintMod.proxy.getPaintList()) {
			BlockPos checkPos = location.getBlockPos();
			EnumFacing checkFacing = location.getFacing();

			int checkX = checkPos.getX();
			int checkY = checkPos.getY();
			int checkZ = checkPos.getZ();

			switch (size) {
			case PIXEL:
				if (checkX == pos.getX() && checkY == pos.getY() && checkZ == pos.getZ()) {
					if (checkFacing == face) {
						int x = location.getGridX();
						int y = location.getGridY();
						int z = location.getGridZ();

						if (gridX == x && gridY == y && gridZ == z) {
							toRemove.add(location);
						}
					}
				}
				break;
			case SMALL:
				if (checkX == pos.getX() && checkY == pos.getY() && checkZ == pos.getZ()) {
					if (checkFacing == face) {
						int x = location.getGridX();
						int y = location.getGridY();
						int z = location.getGridZ();

						if (gridX == x && gridY == y && gridZ == z) {
							toRemove.add(location);
						}
						switch (face.getAxis()) {
						case X:
							if (gridX == x && gridY == y + 1 && gridZ == z) {
								toRemove.add(location);
							}
							if (gridX == x && gridY == y - 1 && gridZ == z) {
								toRemove.add(location);
							}
							if (gridX == x && gridY == y && gridZ == z + 1) {
								toRemove.add(location);
							}
							if (gridX == x && gridY == y && gridZ == z - 1) {
								toRemove.add(location);
							}
							break;
						case Y:
							if (gridX == x + 1 && gridY == y && gridZ == z) {
								toRemove.add(location);
							}
							if (gridX == x - 1 && gridY == y && gridZ == z) {
								toRemove.add(location);
							}
							if (gridX == x && gridY == y && gridZ == z + 1) {
								toRemove.add(location);
							}
							if (gridX == x && gridY == y && gridZ == z - 1) {
								toRemove.add(location);
							}
							break;
						case Z:
							if (gridX == x + 1 && gridY == y && gridZ == z) {
								toRemove.add(location);
							}
							if (gridX == x - 1 && gridY == y && gridZ == z) {
								toRemove.add(location);
							}
							if (gridX == x && gridY == y + 1 && gridZ == z) {
								toRemove.add(location);
							}
							if (gridX == x && gridY == y - 1 && gridZ == z) {
								toRemove.add(location);
							}
							break;
						}
						break;
					}
				}
			case MEDIUM:
				if (checkX == pos.getX() && checkY == pos.getY() && checkZ == pos.getZ()) {
					if (checkFacing == face) {
						int x = location.getGridX();
						int y = location.getGridY();
						int z = location.getGridZ();

						if (gridX == x && gridY == y && gridZ == z) {
							toRemove.add(location);
						}

						switch (face.getAxis()) {
						case X:
							for (int i = 0; i < 5; i++) {
								for (int j = 0; j < 3; j++) {
									if (gridX == x && gridY == y + i - 2 && gridZ == z + j - 1) {
										toRemove.add(location);
									}
								}
							}
							for (int i = 0; i < 3; i++) {
								for (int j = 0; j < 5; j++) {
									if (gridX == x && gridY == y + i - 1 && gridZ == z + j - 2) {
										toRemove.add(location);
									}
								}
							}
							break;
						case Y:
							for (int i = 0; i < 5; i++) {
								for (int j = 0; j < 3; j++) {
									if (gridX == x + i - 2 && gridY == y && gridZ == z + j - 1) {
										toRemove.add(location);
									}
								}
							}
							for (int i = 0; i < 3; i++) {
								for (int j = 0; j < 5; j++) {
									if (gridX == x + i - 1 && gridY == y && gridZ == z + j - 2) {
										toRemove.add(location);
									}
								}
							}
							break;
						case Z:
							for (int i = 0; i < 5; i++) {
								for (int j = 0; j < 3; j++) {
									if (gridX == x + i - 2 && gridY == y + j - 1 && gridZ == z) {
										toRemove.add(location);
									}
								}
							}
							for (int i = 0; i < 3; i++) {
								for (int j = 0; j < 5; j++) {
									if (gridX == x + i - 1 && gridY == y + j - 2 && gridZ == z) {
										toRemove.add(location);
									}
								}
							}
							break;
						}
						break;
					}
				}
			case LARGE:
				if (checkX == pos.getX() && checkY == pos.getY() && checkZ == pos.getZ()) {
					if (checkFacing == face) {
						int x = location.getGridX();
						int y = location.getGridY();
						int z = location.getGridZ();

						if (gridX == x && gridY == y && gridZ == z) {
							toRemove.add(location);
						}

						switch (face.getAxis()) {
						case X:
							for (int i = 0; i < 7; i++) {
								for (int j = 0; j < 5; j++) {
									if (gridX == x && gridY == y + i - 3 && gridZ == z + j - 2) {
										toRemove.add(location);
									}
								}
							}
							for (int i = 0; i < 5; i++) {
								for (int j = 0; j < 7; j++) {
									if (gridX == x && gridY == y + i - 2 && gridZ == z + j - 3) {
										toRemove.add(location);
									}
								}
							}
							break;
						case Y:
							for (int i = 0; i < 7; i++) {
								for (int j = 0; j < 5; j++) {
									if (gridX == x + i - 3 && gridY == y && gridZ == z + j - 2) {
										toRemove.add(location);
									}
								}
							}
							for (int i = 0; i < 5; i++) {
								for (int j = 0; j < 7; j++) {
									if (gridX == x + i - 2 && gridY == y && gridZ == z + j - 3) {
										toRemove.add(location);
									}
								}
							}
							break;
						case Z:
							for (int i = 0; i < 7; i++) {
								for (int j = 0; j < 5; j++) {
									if (gridX == x + i - 3 && gridY == y + j - 2 && gridZ == z) {
										toRemove.add(location);
									}
								}
							}
							for (int i = 0; i < 5; i++) {
								for (int j = 0; j < 7; j++) {
									if (gridX == x + i - 2 && gridY == y + j - 3 && gridZ == z) {
										toRemove.add(location);
									}
								}
							}
							break;
						}
						break;
					}
				}
				break;
			}
		}

		PaintMod.proxy.removeAllPaint(toRemove);
		PacketHandler.INSTANCE.sendToAll(new PacketRemovePaint(toRemove));
	}

	public void initBlackList() {
		paintBlackList.add(BlockFence.class);
		paintBlackList.add(BlockFenceGate.class);
		paintBlackList.add(BlockWall.class);

		paintBlackList.add(BlockTorch.class);
		paintBlackList.add(BlockBed.class);
		paintBlackList.add(BlockGrass.class);
		paintBlackList.add(BlockTallGrass.class);
		paintBlackList.add(BlockBeetroot.class);
		paintBlackList.add(BlockCake.class);
		paintBlackList.add(BlockCake.class);
		paintBlackList.add(BlockChorusFlower.class);
		paintBlackList.add(BlockChorusPlant.class);
		paintBlackList.add(BlockCocoa.class);
		paintBlackList.add(BlockFlower.class);
		paintBlackList.add(BlockFlowerPot.class);
		paintBlackList.add(BlockReed.class);
		paintBlackList.add(BlockDoublePlant.class);

		paintBlackList.add(BlockGlass.class);
		paintBlackList.add(BlockStainedGlass.class);
		paintBlackList.add(BlockStainedGlassPane.class);

		paintBlackList.add(BlockPressurePlate.class);
		paintBlackList.add(BlockPressurePlateWeighted.class);
		paintBlackList.add(BlockRedstoneTorch.class);
		paintBlackList.add(BlockRedstoneWire.class);
		paintBlackList.add(BlockRedstoneComparator.class);
		paintBlackList.add(BlockRedstoneDiode.class);
		paintBlackList.add(BlockRedstoneLight.class);

		paintBlackList.add(BlockFluidBase.class);

		paintBlackList.add(BlockRail.class);
		paintBlackList.add(BlockRailDetector.class);
		paintBlackList.add(BlockRailPowered.class);
	}

	@SubscribeEvent
	public void onPlayerJoinWorld(EntityJoinWorldEvent event) {

		if (!event.getWorld().isRemote)
			return;

		if (event.getEntity() instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) event.getEntity();
			PacketHandler.INSTANCE.sendTo(new PacketPaint(PaintMod.proxy.getPaintList(), true), player);
		}

	}

	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event) {

		List<PaintLocation> temp = new ArrayList<>();

		for (PaintLocation location : PaintMod.proxy.getPaintList()) {
			BlockPos breakPos = event.getPos();
			BlockPos checkPos = location.getBlockPos();

			if (breakPos.getX() == checkPos.getX() && breakPos.getY() == checkPos.getY() && breakPos.getZ() == checkPos.getZ()) {
				temp.add(location);
			}
		}

		PaintMod.proxy.removeAllPaint(temp);
		PacketHandler.INSTANCE.sendToAll(new PacketRemovePaint(temp));
	}

	public void fillList(List<PaintLocation> list) {
		PaintMod.proxy.addAllPaint(list);
	}

	// ==========Client methods==========
	@SideOnly(Side.CLIENT)
	public void addPaintForRender(List<PaintLocation> locations) {
	}

	@SideOnly(Side.CLIENT)
	public void removeClientPaint(List<PaintLocation> locations) {
	}
}
