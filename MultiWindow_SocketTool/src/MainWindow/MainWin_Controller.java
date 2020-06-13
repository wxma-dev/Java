package MainWindow;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import Comm.Configuration;
import TestWindow.TestWin_Controller;

public class MainWin_Controller {
	private MainWin_ViewJMenuBar viewJMenuBar;
	private MainWin_ViewJPanel   viewJPanel;
	
	private int iCount_Test_Win = 0;
	
	public MainWin_Controller()
	{
		viewJMenuBar = new MainWin_ViewJMenuBar();
		viewJPanel   = new MainWin_ViewJPanel();

		//viewJMenuBar.

		viewJPanel.addActionListener_List_Button_Add(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

		          //框架的菜单
		          JMenuBar menubar_Main = new JMenuBar();
		          JMenu menu1=new JMenu("通讯配置");
		          JMenu menu2=new JMenu("日志文件配置");
		          JMenu menu3=new JMenu("报文文件配置");
		          menubar_Main.add(menu1);
		          menubar_Main.add(menu2);
		          menubar_Main.add(menu3);

		          Configuration cf = new Configuration("etc/global.cfg");
		          int iCount_Test_Win = Integer.parseInt( cf.getValue("iCount_TestWin") );

		          //框架命名
		          String sName_Frame = "SOCKET测试窗口";
		      	  sName_Frame = sName_Frame + "【" + iCount_Test_Win + "】";

		      	  //创建目录

		      	  //创建日志

		      	  iCount_Test_Win++;
		      	  cf.setValue("iCount_TestWin", "" + iCount_Test_Win);
		      	  cf.saveFile("etc/global.cfg", "Global Config");

		          //主框架
		          TestWin_Controller testcontroller = new TestWin_Controller();
		          JFrame frame  = new JFrame( sName_Frame );
		          frame.setJMenuBar(menubar_Main);
		          frame.setLayout(new BorderLayout());
		          frame.setBounds(200, 100, 600, 600);
		          frame.getContentPane().add(testcontroller.getView());
		          frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		          frame.setVisible(true);
            }
        });

		viewJPanel.addActionListener_List_Button_Init(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	//将global.cfg配置文件中的iCount_TestWin值置为0
            	Configuration cfg = new Configuration("etc/global.cfg");
            	cfg.setValue("iCount_TestWin", "0");
            	cfg.saveFile("etc/global.cfg", "Global Config");

            }
        });
	}

   public JMenuBar getViewJmenuBar(){
        return viewJMenuBar;
    }
   
   public JPanel getViewJPanel(){
        return viewJPanel;
    }
   
	public static void main(String[] args)
	{
		JFrame fFrame;
		JPanel pPanel;
		JMenuBar menubar1;

		final int WIDTH=600;
		final int HEIGHT=400;
		
		fFrame = new JFrame("多窗口SOCKET测试工具");
		fFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MainWin_Controller contrl = new MainWin_Controller();

		menubar1 = contrl.getViewJmenuBar();
		pPanel = contrl.getViewJPanel();
				
		fFrame.setContentPane(pPanel);
		fFrame.setJMenuBar(menubar1);

		fFrame.setVisible(true);
		fFrame.setSize(WIDTH,HEIGHT);

		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();

		int width=screenSize.width;
		int height=screenSize.height;
		
		int x=(width-WIDTH)/2;
		int y=(height-HEIGHT)/2;

		fFrame.setLocation(x,y);
	}
   
}

