package MainWindow;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class MainWin_ViewJMenuBar extends JMenuBar {

	private JMenu menu1;
	private JMenu menu2;
	private JMenu menu3;
	
	private JMenuItem item1;
	private JMenuItem item2;

	public MainWin_ViewJMenuBar()
	{
		menu1=new JMenu("配置");
		menu2=new JMenu("说明文档");
		menu3=new JMenu("Version");

		this.add(menu1);
		this.add(menu2);
		this.add(menu3);
		
		item1=new JMenuItem("子菜单1");
		item2=new JMenuItem("子菜单2");
		JMenuItem item3=new JMenuItem("Exit");
		JMenuItem item4=new JMenuItem("子菜单4");
		JMenuItem item5=new JMenuItem("子菜单5");
		JMenuItem item6=new JMenuItem("子菜单6");
		JMenuItem item7=new JMenuItem("子菜单7");

		menu1.add(item1);
		menu1.addSeparator();
		menu1.add(item2);
		menu1.addSeparator();
		menu1.add(item3);
		menu2.add(item4);
		menu2.addSeparator();
		menu2.add(item5);
		menu3.add(item6);
		menu3.addSeparator();
		menu3.add(item7);

	}

}

