package lhw_tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		TankFrame tf = new TankFrame();
		//初始化敌方坦克
		for (int i = 0; i < 5; ++i) {
			tf.tanks.add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, tf));
		}
		
		//背景音乐
//		new Thread(()->new Audio("audio/war1.wav").loop()).start();
		
		while (true) {
			Thread.sleep(25);     					 //每50毫秒 调用repaint函数，repaint调用paint函数（因为没画笔Graphics 这是系统传给paint的）
			tf.repaint();
		}
		
	}

}
