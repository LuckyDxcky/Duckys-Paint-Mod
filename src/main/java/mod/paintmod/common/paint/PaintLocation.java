package mod.paintmod.common.paint;

import java.awt.Color;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class PaintLocation {

	private BlockPos blockPos;
	private EnumFacing facing;
	private Color color;
	private int gridX, gridY, gridZ;

	public PaintLocation(BlockPos blockPos, EnumFacing facing, Color color, int gridX, int gridY, int gridZ) {
		this.blockPos = blockPos;
		this.facing = facing;
		this.color = color;
		this.gridX = gridX;
		this.gridY = gridY;
		this.gridZ = gridZ;
	}
	
	public BlockPos getBlockPos() {
		return blockPos;
	}

	public EnumFacing getFacing() {
		return facing;
	}

	public Color getColor() {
		return color;
	}

	public int getGridX() {
		return gridX;
	}

	public int getGridY() {
		return gridY;
	}

	public int getGridZ() {
		return gridZ;
	}

}
