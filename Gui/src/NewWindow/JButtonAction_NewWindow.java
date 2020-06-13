package NewWindow;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import Action.JButton_JLabel_ActionEvent;


class JButtonAction_NewWindow extends JFrame implements ActionListener{

   private JButton btn=new JButton("弹出新窗口");
  //private JButton btn1=new JButton("弹出新窗口");

   public JButtonAction_NewWindow(){
         this.setLayout(new FlowLayout());
          this.add(btn);
          //this.add(btn1);
          
          //为什么这地方要使用这个函数
          this.setVisible(true);
          //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
           btn.addActionListener(this);
           //btn1.addActionListener(this);
   }
   public void actionPerformed(ActionEvent event){
	   /*
       MainFrame main=new MainFrame();
       main.setTitle("主窗体");
       main.setLocation(300,200);
       main.setVisible(true);
       */

		JFrame a = new JFrame("SwingApplication");
		JButton_JLabel_ActionEvent t = new JButton_JLabel_ActionEvent();
		Component contents = t.createComponents();
		a.getContentPane().add(contents, BorderLayout.CENTER);
		
		//窗口设置结束，开始显示
		a.addWindowListener(new WindowAdapter() {
			//匿名类用于注册监听器
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		a.pack();
		a.setVisible(true);

  }

   public static void main(String[] args) {
	   JButtonAction_NewWindow win = new JButtonAction_NewWindow();
	   win.setBounds(100, 100, 320, 310);
	   

   }
}



