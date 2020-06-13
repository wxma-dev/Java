package JOptionPane;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogShow implements ActionListener{

	JFrame myFrame;
	JButton button1,button2,button3;
	Container con;

	public DialogShow() {
		myFrame= new JFrame("对话框使用范例");
		button1= new JButton("显示消息");
		button2= new JButton("显示确认对话");
		button3= new JButton("显示输入对话框");

		con=myFrame.getContentPane();
		con.add(button1);
		con.add(button2);
		con.add(button3);
		con.setLayout(new FlowLayout());

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		myFrame.setSize(500, 500);
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//居中显示
		myFrame.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new DialogShow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1)
			JOptionPane.showConfirmDialog(myFrame,"这是一个有三个按钮的确认框，\n按任意按钮返回");
		else if(e.getSource()==button2)
			JOptionPane.showMessageDialog(myFrame, "这是一个简单的消息框");
		else
			JOptionPane.showInputDialog(myFrame,"这是一个可供用户输入信息的对话框");
	}

}