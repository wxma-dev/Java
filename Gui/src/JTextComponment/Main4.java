package JTextComponment;
/*
 * 添加键盘监听机制
 */
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main4 extends JFrame {
  public Main4() throws HeadlessException {
    setSize(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout(FlowLayout.LEFT));

    JLabel usernameLabel = new JLabel("Username: ");
    JTextField usernameTextField = new JTextField();
    usernameTextField.setPreferredSize(new Dimension(100, 20));
    add(usernameLabel);
    add(usernameTextField);

    usernameTextField.addKeyListener(new KeyAdapter() {   //创建机制
      public void keyReleased(KeyEvent e) {        //重载函数，释放按键触发
        JTextField textField = (JTextField) e.getSource();  //得到最初发生event的组件对象,既是文本框对象
        String text = textField.getText();
        textField.setText(text.toUpperCase());      //将所有的小写字母转换成大写字母
      }
       public void keyTyped(KeyEvent e) {           //键入时触发
      }

      public void keyPressed(KeyEvent e) {       //释放按键时触发的函数
      }   
    });
  }

  public static void main(String[] args) {
    new Main4().setVisible(true);
  }
}