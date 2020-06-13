package JTextComponment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main2 extends JFrame {
    private JTextField textField;
    private FileWriter writer;

    public static void main(String args[]) {
    	Main2 my = new Main2();
        my.setVisible(true);
    }

    public Main2() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new BorderLayout());
        JButton button = new JButton("运行");
        JLabel label = new JLabel("name");
        textField = new JTextField();
        panel.add(label, BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);
        final String filename = "text.txt";
        button.addActionListener(new ActionListener() {    //添加一个按钮触发装置，这里只要点击一下anniu就会将文本框中的内容输入到文件中
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    writer = new FileWriter(filename, false);   //创建一个写入文件的对象，这里的false表示不在文件的末尾添加
                    textField.write(writer);     //将单行文本中输入的内容写入到文件中
                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                    System.out.println("false");
                }
            }
        });
        panel.add(button, BorderLayout.SOUTH);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.pack();
    }

}