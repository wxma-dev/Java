package Action;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import javax.swing.*;

public class WindowMouseEvent  extends JFrame {
   JTextField text; 
   JButton button;
   JTextArea textArea;
   MousePolice police; 
   WindowMouseEvent() {
      init();
      setBounds(100,100,420,220);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   }
   
   void init() {
      setLayout(new FlowLayout());
      text=new JTextField(8);
      textArea=new JTextArea(10,28);
      police=new MousePolice();
      police.setJTextArea(textArea); 
      text.addMouseListener(police);
      button=new JButton("按钮"); 
      button.addMouseListener(police);
      addMouseListener(police);
      add(button);
      add(text);
      add(new JScrollPane(textArea));
   }
   
   public static void main(String args[]) {
	   WindowMouseEvent win=new WindowMouseEvent();
	      win.setTitle("处理鼠标事件"); 
	      win.setBounds(100,100,460,360);
   }
   
}

class MousePolice implements MouseListener {
	   JTextArea area;
	   public void setJTextArea(JTextArea area) {
	      this.area=area;
	   }
	   public void mousePressed(MouseEvent e) {
	      area.append("\n鼠标按下,位置:"+"("+e.getX()+","+e.getY()+")");
	   }
	   public void mouseReleased(MouseEvent e) {
	      area.append("\n鼠标释放,位置:"+"("+e.getX()+","+e.getY()+")");
	   }
	   public void mouseEntered(MouseEvent e)  {
	      if(e.getSource() instanceof JButton) // 得到的事件源是JButton的对象时，返回true
	        area.append("\n鼠标进入按纽,位置:"+"("+e.getX()+","+e.getY()+")");
	      if(e.getSource() instanceof JTextField)
	        area.append("\n鼠标进入文本框,位置:"+"("+e.getX()+","+e.getY()+")");
	      if(e.getSource() instanceof JFrame)
	        area.append("\n鼠标进入窗口,位置:"+"("+e.getX()+","+e.getY()+")"); 
	   }
	   public void mouseExited(MouseEvent e) {
	      area.append("\n鼠标退出,位置:"+"("+e.getX()+","+e.getY()+")");
	   }
	   public void mouseClicked(MouseEvent e) {
	      if(e.getClickCount()>=2)
	         area.setText("鼠标连击，位置:"+"("+e.getX()+","+e.getY()+")");
	   }
}


