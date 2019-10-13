package lhw_tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		TankFrame tf = new TankFrame();
		
		while (true) {
			Thread.sleep(50);     					 //每50毫秒 调用repaint函数，repaint调用paint函数（因为没画笔Graphics 这是系统传给paint的）
			tf.repaint();
		}
		
	}

}
