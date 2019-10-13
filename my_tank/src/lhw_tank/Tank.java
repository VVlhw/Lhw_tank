package lhw_tank;

import java.awt.Graphics;

public class Tank {
	 private int x, y;
	 private Dir dir = Dir.DOWN;
	 private static final int SPEED = 5;					//static final 不能改变的真正常量
	 
	 private boolean moving = false;
	 
	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public Dir getDir() {
		 return dir;
	 }

	 public void setDir(Dir dir) {
		 this.dir = dir;
	 }

	 
	 public Tank(int x, int y, Dir dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	 }

	public void paint(Graphics g) {
		g.fillRect(x, y, 50, 50);						//用画笔绘制黑色方块
		
		move();
		
	}
	
	private void move() {
		if (!moving) return;
		
		switch(dir) {
		case LEFT:
			x -= SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		}
	}
	 
	 
}
