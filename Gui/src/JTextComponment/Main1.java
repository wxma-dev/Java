package JTextComponment;

import java.awt.BorderLayout;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main1 {
  public static void main(String args[]) {
    JFrame frame = new JFrame("Verifier Sample");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JTextField textField1 = new JTextField();
    JTextField textField2 = new JTextField();
    InputVerifier verifier = new InputVerifier() {     //创建一个验证
      public boolean verify(JComponent comp) {
        boolean returnValue;
        JTextField textField = (JTextField) comp;      //强制转换，将控件类型的comp转换成JTextFiled类型的
        try {
          Integer.parseInt(textField.getText());    //将输入的内容转化程int类型，如果输入的字符串不是十进制的话就会触发                                                          //NumberFormateException错误
          returnValue = true;
        } catch (NumberFormatException e) {   
          returnValue = false;
        }
        return returnValue;        //如果返回false的话，那么指针就会一直聚焦在此文本框中，不能移动到其他的组件上
      }
    };
    textField1.setInputVerifier(verifier);
    frame.add(textField1, BorderLayout.NORTH);
    frame.add(textField2, BorderLayout.CENTER);
    frame.setSize(300, 100);
    frame.setVisible(true);
  }
}