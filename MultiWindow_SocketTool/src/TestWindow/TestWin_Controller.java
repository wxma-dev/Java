package TestWindow;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class TestWin_Controller {
	
    private TestWin_View testview;
    private TestWin_Model testmodel;

    public TestWin_Controller() {
        testview = new TestWin_View();
        testmodel= new TestWin_Model();
        testview.addActionListener_List_Text(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//获取请求内容
                testmodel.setInfo( testview.getTextAreaOne() );

                //SOCKET发送接受
                
                /*
                testmodel.setYjz( testview.getJComboBox_Src() );
                testmodel.setMjz( testview.getJComboBox_Dst() );
				*/

                //设置返回内容
                testview.setTextAreaTwo( testmodel.getInfo() );
            }
        });

        testview.addItemListener_List_Src(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            	testview.getJComboBox_Src();
            	//System.out.println( testview.getJComboBox_Src() );
            }
        });

        testview.addItemListener_List_Dst(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            	testview.getJComboBox_Dst();
            	//System.out.println( testview.getJComboBox_Dst() );
            }
        });
    }

    public JPanel getView(){
        return testview;
    }
}

