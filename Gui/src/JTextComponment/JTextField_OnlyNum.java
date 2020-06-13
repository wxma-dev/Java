package JTextComponment;
/*
 * 验证文本框，如果第一个文本框中为输入数字则第二个文本框不能输入
 */
import java.awt.BorderLayout;   
import javax.swing.InputVerifier;   
import javax.swing.JComponent;   
import javax.swing.JFrame;   
import javax.swing.JTextField;   
public class JTextField_OnlyNum {   
  public static void main(String args[]) {   
    JFrame frame = new JFrame("Verifier Sample");   
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    JTextField textField1 = new JTextField();   
    JTextField textField2 = new JTextField();   
    InputVerifier verifier = new InputVerifier() {   
      public boolean verify(JComponent comp) {   
        boolean returnValue;   
        JTextField textField = (JTextField) comp;   
        try {   
          Integer.parseInt(textField.getText());   
          returnValue = true;   
        } catch (NumberFormatException e) {   
          returnValue = false;   
        }   
        return returnValue;   
      }   
    };   
    textField1.setInputVerifier(verifier);   
    frame.add(textField1, BorderLayout.NORTH);   
    frame.add(textField2, BorderLayout.CENTER);   
    frame.setSize(300, 100);   
    frame.setVisible(true);   
  }   
}   