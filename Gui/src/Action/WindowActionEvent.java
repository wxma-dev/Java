package Action;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WindowActionEvent extends JFrame {
    JTextField text;
    JTextArea textShow;
    JButton button;
    Reader_ActionListener listener;

    public WindowActionEvent() throws HeadlessException {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init() {
        setLayout(new FlowLayout());
        text = new JTextField(10);
        button = new JButton("读取");
        textShow = new JTextArea(9,30);
        listener = new Reader_ActionListener();
        listener.setJTextField(text);
        listener.setJTextArea(textShow);
        text.addActionListener(listener);
        button.addActionListener(listener);
        add(text);
        add(button);
        add(new JScrollPane(textShow));
    }
    
    public static void main(String[] args) {
        WindowActionEvent win = new WindowActionEvent();
        win.setBounds(100,100,360,300);
        win.setTitle("处理ActionEvent事件");
    }
    
}

class Reader_ActionListener implements ActionListener {
    JTextField text;
    JTextArea textShow;

    public void setJTextField(JTextField text) {
        this.text = text;
    }


    public void setJTextArea(JTextArea textShow) {
        this.textShow = textShow;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            File file = new File(text.getText()); //getDocument()
            FileReader inOne = new FileReader(file);
            BufferedReader inTwo = new BufferedReader(inOne);
            String s = null;
            while ((s = inTwo.readLine()) != null) {
                textShow.append(s+"\n");
            }
            inOne.close();
            inTwo.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }

    }

}

