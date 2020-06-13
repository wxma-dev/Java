package Action;

import javax.swing.*;     //引入Swing包名
	//import com.sun.java.swing.*;
	//使用JDK 1.2 Beta 4版和所有Swing 1.1 Beta 3
	//之前的版本,引入Swing包名用此方法。
import java.awt.*;
import java.awt.event.*;

public class JButton_JLabel_ActionEvent {
	private static String labelPrefix = "Number of button clicks: ";
	private int numClicks = 0; //计数器，计算点击次数

	public Component createComponents() {
		final JLabel label = new JLabel(labelPrefix + "0 ");

		JButton button = new JButton("I'm a Swing button!");
		button.setMnemonic(KeyEvent.VK_I); //设置按钮的热键为'I'
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numClicks++;
				label.setText(labelPrefix + numClicks);
								//显示按钮被点击的次数

			}
		});
		label.setLabelFor(button);

		JPanel pane = new JPanel();
		pane.setBorder(BorderFactory.createEmptyBorder(
			30, //top
			30, //left
			10, //bottom
			30) //right
			);
		pane.setLayout(new GridLayout(0, 1)); //单列多行
		pane.add(button);
		pane.add(label);
		return pane;
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(
				UIManager.getCrossPlatformLookAndFeelClassName());
													//设置窗口风格
		} catch (Exception e) { }

		//创建顶层容器并添加内容.
		JFrame frame = new JFrame("SwingApplication");
		JButton_JLabel_ActionEvent app = new JButton_JLabel_ActionEvent();
		Component contents = app.createComponents();
		frame.getContentPane().add(contents, BorderLayout.CENTER);

		//窗口设置结束，开始显示
		frame.addWindowListener(new WindowAdapter() {
			//匿名类用于注册监听器
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		frame.pack();
		frame.setVisible(true);
	}

}