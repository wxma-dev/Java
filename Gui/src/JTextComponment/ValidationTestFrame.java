package JTextComponment;

/*
 * 只能在文本框中输入数字
 */
import java.awt.Container;   
import java.awt.Graphics;   
import java.awt.event.WindowAdapter;   
import java.awt.event.WindowEvent;   
  
import javax.swing.JFrame;   
import javax.swing.JLabel;   
import javax.swing.JPanel;   
import javax.swing.JTextField;   
import javax.swing.event.DocumentEvent;   
import javax.swing.event.DocumentListener;   
import javax.swing.text.AttributeSet;   
import javax.swing.text.BadLocationException;   
import javax.swing.text.Document;   
import javax.swing.text.PlainDocument;   
  
public class ValidationTestFrame extends JFrame implements DocumentListener {   
  JLabel label = new JLabel("I only accept numbers");   
  private IntTextField intFiled;   
  
  public ValidationTestFrame() {   
    setTitle("ValidationTest");   
    setSize(300, 200);   
    addWindowListener(new WindowAdapter() {   
      public void windowClosing(WindowEvent e) {   
        System.exit(0);   
      }   
    });   
  
    Container contentPane = getContentPane();   
  
    JPanel p = new JPanel();   
    intFiled = new IntTextField(12, 3);   
    p.add(intFiled);   
  
    //增加DocumentListener事件   
    intFiled.getDocument().addDocumentListener(this);   
  
    contentPane.add(p, "South");   
    contentPane.add(label, "Center");   
  }   
  
  public void insertUpdate(DocumentEvent e) {   
    setLabel();   
  }   
  
  public void removeUpdate(DocumentEvent e) {   
    setLabel();   
  }   
  
  public void changedUpdate(DocumentEvent e) {   
  }   
  
  public void setLabel() {   
    if (intFiled.isValid() ) {   
      int value = intFiled.getValue();   
      label.setText(Integer.toString(value));   
    }   
  }   
  
  public static void main(String[] args) {   
    JFrame frame = new ValidationTestFrame();   
    frame.show();   
  }   
  
}   
  
class IntTextField extends JTextField {   
  public IntTextField(int defval, int size) {   
    super("" + defval, size);   
  }   
  
  protected Document createDefaultModel() {   
    return new IntTextDocument();   
  }   
  
  public boolean isValid() {   
    try {   
      Integer.parseInt(getText());   
      return true;   
    } catch (NumberFormatException e) {   
      return false;   
    }   
  }   
  
  public int getValue() {   
    try {   
      return Integer.parseInt(getText());   
    } catch (NumberFormatException e) {   
      return 0;   
    }   
  }   
  class IntTextDocument extends PlainDocument {   
  
    //中写方法实现需求   
    public void insertString(int offs, String str, AttributeSet a)   
        throws BadLocationException {   
      if (str == null)   
        return;   
      String oldString = getText(0, getLength());   
      String newString = oldString.substring(0, offs) + str   
          + oldString.substring(offs);   
      try {   
        Integer.parseInt(newString + "0");   
      
        //向Document中插入文本前判断   
        super.insertString(offs, str, a);   
      } catch (NumberFormatException e) {   
      }   
    }   
  }   
  
}   