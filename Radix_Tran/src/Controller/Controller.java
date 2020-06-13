package Controller;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;


import Model.Model;
import View.View;

import Model.LogFactory;
import Model.LogUtil;

public class Controller {

    private View testview;
    private Model testmodel;

    public Controller() {
        testview = new View();
        testmodel= new Model();
        testview.addActionListener_List_Text(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                testmodel.setInfo( testview.getTextAreaOne() );
                testmodel.setYjz( testview.getJComboBox_Src() );
                testmodel.setMjz( testview.getJComboBox_Dst() );

                testview.setTextAreaTwo( testmodel.getInfo() );
            }
        });

        testview.addItemListener_List_Src(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            	testview.getJComboBox_Src();
            	System.out.println( testview.getJComboBox_Src() );
            }
        });

        testview.addItemListener_List_Dst(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            	testview.getJComboBox_Dst();
            	System.out.println( testview.getJComboBox_Dst() );
            }
        });
    }

    public JPanel getView(){
        return testview;
    }

    public static void main(String[] args) {

        // Jdk1.7以后自带的全局log（后面我添加了FileHandler，用于写入文件日志）  
        Logger sysLog = Logger.getGlobal();

        //由于jdk自带的全局log没有写入文件的功能，我这里手动添加了文件handler  
        LogUtil.addFileHandler(sysLog, Level.INFO, LogFactory.LOG_FOLDER + File.separator + "sys.log");

    	Controller testcontroller=new Controller();
    	sysLog.info("new Controller sucess!");

        JFrame frame = new JFrame("进制转换器");
        sysLog.info("new JFrame sucess!");

        frame.setLayout(new BorderLayout());
        sysLog.info("frame.setLayout(new BorderLayout()) sucess!");
        
        frame.setBounds(100, 100, 450, 300);
        sysLog.info("frame.setBounds(100, 100, 450, 300); sucess!");
        
        frame.getContentPane().add(testcontroller.getView());
        sysLog.info("frame.getContentPane().add(testcontroller.getView()); sucess!");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sysLog.info("frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); sucess!");
        
        frame.setVisible(true);
        sysLog.info("frame.setVisible(true); sucess!");
    }
}

