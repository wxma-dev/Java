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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class MainWin_ViewJPanel extends JPanel {
	private JButton button_Add;
	private JButton button_Init;
	private JToolBar toolbar;
	
	private List<ActionListener> listeners_Add;
	private List<ActionListener> listeners_Init;
	
    public void addActionListener_List_Button_Add(ActionListener actionlistener){
    	listeners_Add.add(actionlistener);
    }

    public void addActionListener_List_Button_Init(ActionListener actionlistener){
    	listeners_Init.add(actionlistener);
    }

	public MainWin_ViewJPanel()
	{
		listeners_Add  = new ArrayList<ActionListener>();
		listeners_Init = new ArrayList<ActionListener>();
		
		button_Add = new JButton("新测试窗口");
		button_Init = new JButton("初始化");
		
		toolbar = new JToolBar();
		toolbar.add(button_Add);
		toolbar.add(button_Init);

		BorderLayout bord = new BorderLayout();
		this.setLayout(bord);
		this.add("North",toolbar);
		
		
        /* 注册监听器 */
		button_Add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<listeners_Add.size();++i){
                	listeners_Add.get(i).actionPerformed(e);
                }
            }
        });
		
        /* 注册监听器 */
		button_Init.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<listeners_Init.size();++i){
                	listeners_Init.get(i).actionPerformed(e);
                }
            }
        });
	}
}

