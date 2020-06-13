package JTextComponment;
/*
 * 共享数据模型 
 */
import javax.swing.BoxLayout;   
import javax.swing.JFrame;   
import javax.swing.JScrollPane;   
import javax.swing.JTextArea;   
import javax.swing.JTextField;   
import javax.swing.text.Document;   
public class JTextField_JScrollPane {   
  public static void main(String args[]) {   
    JFrame frame = new JFrame("Sharing Sample");   
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    JTextField textarea1 = new JTextField();   
    Document document = textarea1.getDocument();   
    JTextArea textarea2 = new JTextArea(document);   
    JTextArea textarea3 = new JTextArea(document);
    frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
    frame.add(new JScrollPane(textarea1));
    frame.add(new JScrollPane(textarea2));
    frame.add(new JScrollPane(textarea3));
    frame.setSize(300, 400);
    frame.setVisible(true);
  }
}
