package Action;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class JButton_JTextField_ActionEvent  {
	private JFrame 
	frame=new JFrame("ButtonDemo");
	private JButton
	b1 = new JButton("按钮1"),
	b2 = new JButton("按钮2");
	private JTextField 
	txt = new JTextField(10);

	//这里是使用一个匿名类来实现对按钮的监听
	private ActionListener p1 = new ActionListener() {
		//实现监听类中的抽象函数
		public void actionPerformed(ActionEvent e) {
			String name = ((JButton)e.getSource()).getText();
			txt.setText(name);
		}
	};

	public JButton_JTextField_ActionEvent () {
		//将监听对象注册给两个按钮
		b1.addActionListener(p1); 
		b2.addActionListener(p1);
		frame.setLayout(new FlowLayout());
		frame.add(b1);
		frame.add(b2);
		frame.add(txt);
		frame.setVisible(true);
		frame.setSize(200,150);
	}

	public static void main(String[] args) {
		new JButton_JTextField_ActionEvent ();
	}
}