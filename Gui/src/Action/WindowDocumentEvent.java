package Action;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.event.*;
import javax.swing.*;
import java.util.*;


public class WindowDocumentEvent extends JFrame { 
   JTextArea inputText,showText; //一个用于输入，一个用于输出
   PoliceListen listen;
   WindowDocumentEvent() { 
      init();
      setLayout(new FlowLayout());
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
   }
   void init() {
      inputText = new JTextArea(9,10);
      showText = new JTextArea(9,10);
      add(new JScrollPane(inputText));
      add(new JScrollPane(showText));
      listen = new PoliceListen();
      listen.setInputText(inputText);
      listen.setShowText(showText);  
      (inputText.getDocument()).addDocumentListener(listen);//向文档注册监视器
   }
   
   public static void main(String args[]) {
	   WindowDocumentEvent win=new WindowDocumentEvent();
	      win.setBounds(10,10,360,260);
	      win.setTitle("处理DocumentEvent事件");
	}
}

class PoliceListen implements DocumentListener {
    JTextArea inputText, showText;

    public void setInputText(JTextArea text) {
        inputText = text;
    }

    public void setShowText(JTextArea text) {
        showText = text;
    }

    public void removeUpdate(DocumentEvent e) {
        changedUpdate(e);
    }

    public void insertUpdate(DocumentEvent e) {
        changedUpdate(e);
    }

    public void changedUpdate(DocumentEvent e) {
        String str = inputText.getText();
        // 空格、数字和符号(!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~)组成的正则表达式:
        String regex = "[\\s\\d\\p{Punct}]+";
        String words[] = str.split(regex);
        Arrays.sort(words); // 按字典序从小到大排序
        showText.setText(null);
        for (String s : words)
            showText.append(s + ",");
    }
}
