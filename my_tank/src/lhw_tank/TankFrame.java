package lhw_tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	
	int x = 200, y = 200;
	
	public TankFrame() {
		setSize(800, 600);
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
	
	

	@Override
	public void paint(Graphics g) {  						//接受 系统给的Graphics参数———画笔
	
		System.out.println("调用paint");
		g.fillRect(x, y, 50, 50);						//用画笔绘制黑色方块
		x += 50;
		//y += 50;
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
			default: 
				break;
			}
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
			default: 
				break;
			}
		}
	}
	
}
