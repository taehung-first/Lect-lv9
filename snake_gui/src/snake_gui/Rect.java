package snake_gui;

import java.awt.Color;

public abstract class Rect {
	private int x, y, Width, Height;
	private Color c;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return Width;
	}
	public int getHeight() {
		return Height;
	}
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}
	//»ý¼ºÀÚ
}
