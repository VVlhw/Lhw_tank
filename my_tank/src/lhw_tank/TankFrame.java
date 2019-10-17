package lhw_tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TankFrame extends Frame {
	
	Tank myTank = new Tank(200, 400, Dir.DOWN, this);
	List<Bullet> bullets = new ArrayList<>();
	List<Tank> tanks = new ArrayList<>();
	Bullet b = new Bullet(300, 300, Dir.DOWN, this);
	static final int GAME_WIDTH = 800, GAME_HEIGHT = 600; 
	
	public TankFrame() {
		setSize(GAME_WIDTH, GAME_HEIGHT);
		setVisible(true);
		setResizable(false); 								//无法改变 窗户大小,玩游戏嘛，肯定不能变
		setTitle("LHW Tank War");
		
		this.addKeyListener(new MyKeyListener());			//不匿名试试，就单纯自己定义一个内部类
		
		
		//匿名类
		addWindowListener(new WindowAdapter() {  			//WindowAdapter 实现了WindowListener接口
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		/*
		 【JFrame与Frame的区别】
		  1.JFrame是javax.swing.JFrame包中的类,Frame是java.awt.Frame包中的类
		  2.关闭窗口的方式不同
		  	JFrame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		  	Frame要如上加监听事件
		*/
		
		
	}
	
	//双缓冲
	Image offScreenImage = null;
	@Override
	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	@Override
	public void paint(Graphics g) {  						//接受 系统给的Graphics参数———画笔
		Color c = g.getColor();
		g.setColor(Color.white);
		g.drawString("子弹的数量：" + bullets.size(), 10, 60);
		g.setColor(c);
		
		myTank.paint(g); 
		for (int i = 0; i < bullets.size(); ++i) {
			bullets.get(i).paint(g);
		}
		
		for (int i = 0; i < tanks.size(); ++i) {
			tanks.get(i).paint(g);
		}
		
//		for (Iterator<Bullet> it = bullets.iterator(); it.hasNext();) {
//			Bullet b = it.next();
//			if (!b.getlive()) it.remove();
//		}
	}
	
	   
	class MyKeyListener extends KeyAdapter {
		boolean L = false; 
		boolean R = false;
		boolean U = false;
		boolean D = false;
		
		@Override
		public void keyPressed(KeyEvent e) {
			//System.out.println("key pressed");
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				L = true;
				break;
			case KeyEvent.VK_RIGHT:
				R = true;
				break;
			case KeyEvent.VK_UP:
				U = true;
				break;
			case KeyEvent.VK_DOWN:
				D = true;
				break;
			case KeyEvent.VK_CONTROL:
				myTank.fire();
				break;
			default: 
				break;
			}
			
			setMainTankDir();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			//System.out.println("key released");
			int key = e.getKeyCode();					//从事件中获取按的是什么按键
														//为什么要标记，因为机器进入 一定有先后，所以用标记，而不是直接加
			switch (key) {
			case KeyEvent.VK_LEFT:
				L = false;
				break;
			case KeyEvent.VK_RIGHT:
				R = false;
				break;
			case KeyEvent.VK_UP:
				U = false;
				break;
			case KeyEvent.VK_DOWN:
				D = false;
				break;
			case KeyEvent.VK_CONTROL:
				break;
			default: 
				break;
			}
			
			setMainTankDir();							//要考虑松开了，都没按就停
		}

		private void setMainTankDir() {
			if (!L && !U && !R && !D)	myTank.setMoving(false);
			else {
				myTank.setMoving(true);
				if (L) myTank.setDir(Dir.LEFT);				//可能两个键同时按 所以都是if 
				if (U) myTank.setDir(Dir.UP);
				if (R) myTank.setDir(Dir.RIGHT);
				if (D) myTank.setDir(Dir.DOWN);
			}
			
			
			
		}
	}
	
}
