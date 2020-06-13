package View;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class View extends JPanel {

    private JPanel Jpenel_Container1;
    private JPanel Jpenel_Container2;
    private JPanel Jpenel_Container3;
    private JTextArea areaFiftyOne;
    private JTextArea areaFiftyTwo;
    private JPanel Jpenel_Src;
    private JLabel JLabel_Src;
    private JPanel Jpenel_Dst;
    private JLabel JLabel_Dst;
    private JButton textbtn;
    
    JComboBox<Object> JComboBox_Src;
    JComboBox<Object> JComboBox_Dst;
    private int flag;
    
    private List<ActionListener> listeners;
    private List<ItemListener>   item_listeners_src;
    private List<ItemListener>   item_listeners_dst;
    
    public void addActionListener_List_Text(ActionListener actionlistener){
        listeners.add(actionlistener);
    }

    public void addItemListener_List_Src(ItemListener itemlistener){
        item_listeners_src.add(itemlistener);
    }
    
    public void addItemListener_List_Dst(ItemListener itemlistener){
        item_listeners_dst.add(itemlistener);
    }
    
    public void setTextAreaTwo(String text){
        areaFiftyTwo.setText(text);
    }

    public String getTextAreaOne(){
        return areaFiftyOne.getText();
    }
    
    public String getJComboBox_Src(){
        return JComboBox_Src.getSelectedItem().toString();
    }

    public String getJComboBox_Dst(){
        return JComboBox_Dst.getSelectedItem().toString();
    }

    public View() {
        listeners=new ArrayList<ActionListener>();
        item_listeners_src=new ArrayList<ItemListener>();
        item_listeners_dst=new ArrayList<ItemListener>();

        //容器Jpenel_Container
        Jpenel_Container1 =  new JPanel();
        Jpenel_Container2 =  new JPanel();
        Jpenel_Container3 =  new JPanel();
        Jpenel_Container1.setLayout(new BorderLayout());
        Jpenel_Container2.setLayout(new BorderLayout());
        Jpenel_Container3.setLayout(new GridLayout(1,3));
        
        //输入框
        areaFiftyOne = new JTextArea();
        areaFiftyTwo = new JTextArea();

        //源进制
        Jpenel_Src =  new JPanel();
        Jpenel_Src.setLayout(new GridLayout(2,1));
        
        JLabel_Src = new JLabel("源进制:");

        flag = 0;
        
        JComboBox_Src = new JComboBox<>();
        JComboBox_Src.addItem("字符");
        JComboBox_Src.addItem("2进制");
        JComboBox_Src.addItem("8进制");
        JComboBox_Src.addItem("10进制");
        JComboBox_Src.addItem("16进制");
        JComboBox_Src.addItem("16进制字符串-空格分割");

        Jpenel_Src.add(JLabel_Src);
        Jpenel_Src.add(JComboBox_Src);
        
        Jpenel_Container3.add(Jpenel_Src);
        
        //目标进制
        Jpenel_Dst =  new JPanel();
        Jpenel_Dst.setLayout(new GridLayout(2,1));
        
        JLabel_Dst = new JLabel("目标进制:");

        JComboBox_Dst = new JComboBox<>();
        JComboBox_Dst.addItem("字符");
        JComboBox_Dst.addItem("2进制");
        JComboBox_Dst.addItem("8进制");
        JComboBox_Dst.addItem("10进制");
        JComboBox_Dst.addItem("16进制");
        JComboBox_Dst.addItem("字符串");

        Jpenel_Dst.add(JLabel_Dst);
        Jpenel_Dst.add(JComboBox_Dst);

        Jpenel_Container3.add(Jpenel_Dst);

        //JButton按钮
        textbtn=new JButton("转换");
        textbtn.setBounds(120, 140, 150, 40);

        //将组件加入到Jpenel_Container
        Jpenel_Container1.add(new JScrollPane(areaFiftyOne));
        Jpenel_Container2.add(new JScrollPane(areaFiftyTwo));
        Jpenel_Container3.add(textbtn);

        setLayout(new GridLayout(3,1));
        add(Jpenel_Container1);
        add(Jpenel_Container2);
        add(Jpenel_Container3);

        /* 注册监听器 */
        textbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<listeners.size();++i){
                    listeners.get(i).actionPerformed(e);
                }
            }
        });

        JComboBox_Src.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                //for(int i=0;i<item_listeners_src.size();++i){
            		if ( flag == 0 )
            		{
            			flag++;
            		}
            		else
            		{
            			item_listeners_src.get(item_listeners_src.size()-1).itemStateChanged(e);
            			flag = 0;
            		}
                //}
            }
        });

        JComboBox_Dst.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                //for(int i=0;i<item_listeners_dst.size();++i){
        		if ( flag == 0 )
        		{
        			flag++;
        		}
        		else
        		{
                	item_listeners_dst.get(item_listeners_src.size()-1).itemStateChanged(e);
        			flag = 0;
        		}
                //}
            }
        });

    }
}

