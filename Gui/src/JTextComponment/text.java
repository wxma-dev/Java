package JTextComponment;

import javax.swing.*;
import java.awt.*;

public class text extends JFrame {
    private JTextField textField1;
    private JTextField textField2;

    public static void main(String args[]) {
        text my = new text();
        my.setVisible(true);

    }

    public text() {
        //this.setBounds(100,100,300,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(2, 1));
        textField1 = new JTextField(10);
        textField2 = new JTextField();
        panel.add(textField1);
        panel.add(textField2);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.pack();
        InputVerifier verifier = new InputVerifier() {    //添加验证方式
            @Override
            public boolean verify(JComponent input) {     //重载函数
                boolean value;
                textField1 = (JTextField) input;    //将input组件强制转化为JTextField类型的单行文本框
                return textField1.getText().equals("pass");  //判断是否输入的时pass,如果不是就会验证错误

            }
        };
        textField1.setInputVerifier(verifier);   //设置验证方式
        textField1.setHorizontalAlignment(JTextField.CENTER);   //设置水平对齐方式
        Font font = new Font("楷体", Font.BOLD + Font.ITALIC, 20);
        textField1.setFont(font);   //设置字体
        textField1.setDragEnabled(true);  //设置在单行文本框中能够拖放文本，如果为false则不能够拖放文本


    }
}