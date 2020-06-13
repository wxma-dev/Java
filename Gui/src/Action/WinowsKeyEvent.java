package Action;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import javax.swing.*;

class Winows extends JFrame {
    JTextField text[] = new JTextField[3]; // 3个文本框
    Police police;
    JButton b;

    Winows() {
        setLayout(new FlowLayout());
        police = new Police(); // 初始化监视器
        for (int i = 0; i < 3; i++) {
            text[i] = new JTextField(7); // 文本框显示的长度
            text[i].addKeyListener(police); // 监视键盘事件
            text[i].addFocusListener(police);
            add(text[i]);
        }
        b = new JButton("确定");
        add(b);
        text[0].requestFocusInWindow(); // 第一个文本框获得焦点，光标处于第一个文本框
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class Police implements KeyListener, FocusListener {

    public void keyPressed(KeyEvent e) {
        JTextField t = (JTextField) e.getSource(); // 获取事件源
        if (t.getCaretPosition() >= 5) // 光标的位置(>0)大于5则焦点移动到下一个文本框(可以输入6个数字)
            t.transferFocus(); //失去当前焦点  transferFocus(false);
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void focusGained(FocusEvent e) {
        JTextField text = (JTextField) e.getSource();
        text.setText(null);
    }

    public void focusLost(FocusEvent e) {
    }
}

public class WinowsKeyEvent {
    public static void main(String args[]) {
        Winows win = new Winows();
        win.setTitle("输入序列号");
        win.setBounds(10, 10, 460, 160);
    }
}



