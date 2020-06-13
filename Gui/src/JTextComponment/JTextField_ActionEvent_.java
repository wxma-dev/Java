package JTextComponment;

import java.awt.event.ActionEvent;
//from  w  w  w. ja va2s  .c o m
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JTextField_ActionEvent_ {

public static void main(String[] a) {
  JFrame frame = new JFrame();
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  JTextField jTextField1 = new JTextField();

  jTextField1.setText("jTextField1");
  //添加监听机制
  jTextField1.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(ActionEvent e) {
      System.out.println("action");
    }
  });
  frame.add(jTextField1);

  frame.setSize(300, 200);
  frame.setVisible(true);
}

}