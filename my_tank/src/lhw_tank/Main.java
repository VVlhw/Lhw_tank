package lhw_tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	public static void main(String[] args) {
		Frame f = new Frame();
		f.setSize(800, 600);
		f.setVisible(true);
		f.setResizable(false); 								//无法改变 窗户大小,玩游戏嘛，肯定不能变
		f.setTitle("LHW Tank War");
		
		//匿名类
		f.addWindowListener(new WindowAdapter() {  			//WindowAdapter 实现了WindowListener接口
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		//JFrame与Frame的区别
		/*
		  1.JFrame是javax.swing.JFrame包中的类,Frame是java.awt.Frame包中的类
		  2.关闭窗口的方式不同
		  	JFrame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		  	Frame要如上加监听事件
		*/
		
	}

}
