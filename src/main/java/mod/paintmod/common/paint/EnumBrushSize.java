package mod.paintmod.common.paint;

public enum EnumBrushSize {

	PIXEL, SMALL, MEDIUM, LARGE;

	public static EnumBrushSize getSize(int size) {
		switch (size) {
		case 0:
			return EnumBrushSize.PIXEL;
		case 1:
			return EnumBrushSize.SMALL;
		case 2:
			return EnumBrushSize.MEDIUM;
		case 3:
			return EnumBrushSize.LARGE;
		default:
			return EnumBrushSize.PIXEL;
		}
	}
}
