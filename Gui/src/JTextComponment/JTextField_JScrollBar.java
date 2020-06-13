package JTextComponment;

/*
 * 将文本输入框增加在滚动条面板中 
 */
import java.awt.BorderLayout;   
import java.awt.event.ActionEvent;   
import java.awt.event.ActionListener;   
  
import javax.swing.BoundedRangeModel;   
import javax.swing.BoxLayout;   
import javax.swing.JFrame;   
import javax.swing.JPanel;   
import javax.swing.JScrollBar;   
import javax.swing.JTextField;   
  
public class JTextField_JScrollBar {   
  
  public static void main(String args[]) {   
    JFrame frame = new JFrame("Text Slider");   
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
  
    final JTextField textField = new JTextField();   
  
    JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);   
  
    JPanel panel = new JPanel();   
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));   
  
    BoundedRangeModel brm = textField.getHorizontalVisibility();   
    scrollBar.setModel(brm);   
    panel.add(textField);   
    panel.add(scrollBar);   
  
    final JTextField_JScrollBar ts = new JTextField_JScrollBar();   
    textField.addActionListener(new ActionListener() {   
      public void actionPerformed(ActionEvent e) {   
        System.out.println("Text: " + textField.getText());   
      }   
    });   
    frame.add(panel, BorderLayout.NORTH);   
    frame.setSize(300, 100);   
    frame.setVisible(true);   
  }   
}   