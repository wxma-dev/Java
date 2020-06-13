package Action;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WindowActionItem extends JFrame {
    JComboBox choice;
    JTextArea textShow;
    Reader_ItemListener listener;

    public WindowActionItem() throws HeadlessException {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init() {
        setLayout(new FlowLayout());
        choice = new JComboBox<>();
        choice.addItem("请选择文件:");

        File dir = new File(".");
        FileAccept fileAccept = new FileAccept("java"); // 设置后缀名
        String[] fileName = dir.list(fileAccept);// 把.java后缀的文件名返回，并存到数组中
        for (String name : fileName) { // 遍历返回的.java文件名
            choice.addItem(name); // 把文件名添加到下拉列表中
        }
        textShow = new JTextArea(9, 30);
        listener = new Reader_ItemListener();

        /**
         * 在ItemListener中自定义这个方法
         * 主要是要用到下拉列表框和文本区的变量,进行相应的操作
         */
        listener.setJComboBox(choice);
        listener.setJTextArea(textShow);

        choice.addItemListener(listener);
        add(choice);
        add(new JScrollPane(textShow)); //滚动窗格  常用容器

    }

    class FileAccept implements FilenameFilter { // 文件名过滤器
        private String type;

        FileAccept(String type) {
            this.type = type;
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(type);
        }

    }
    
    public static void main(String[] args) {
    	WindowActionItem win = new WindowActionItem();
        win.setBounds(100, 100, 400, 300);
        win.setTitle("处理ItemEvent事件");
    }
}

class Reader_ItemListener implements ItemListener {
    JComboBox choice;
    JTextArea textShow;

    public void setJComboBox(JComboBox choice) {
        this.choice = choice;
    }

    public void setJTextArea(JTextArea textShow) {
        this.textShow = textShow;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        textShow.setText(null);
        try {
            String fileName = choice.getSelectedItem().toString(); // 获取下拉列表名称
            File file = new File(fileName);
            FileReader inOne = new FileReader(file);
            BufferedReader inTwo = new BufferedReader(inOne); // 专门用来逐行读取
            String s = null;
            while ((s = inTwo.readLine()) != null) { //逐行读出
                textShow.append(s + "\n"); // 依次添加到textShow中
            }
            inOne.close();
            inTwo.close();
        } catch (Exception e2) {
            textShow.append(e2.toString());
        }
    }
}

