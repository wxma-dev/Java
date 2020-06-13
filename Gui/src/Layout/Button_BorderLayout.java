package Layout;
import javax.swing.*;
import java.awt.*;

public class Button_BorderLayout
{
    static final int WIDTH=600;
    static final int HEIGHT=400;
    public static void main(String[] args)
    {
        JFrame jf=new JFrame("测试程序");
        jf.setSize(WIDTH,HEIGHT);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        JPanel contentPane=new JPanel();
        jf.setContentPane(contentPane);
        JButton b1=new JButton("生活");
        JButton b2=new JButton("工作");
        JButton b3=new JButton("睡觉");
        JButton b4=new JButton("购物");
        JButton b5=new JButton("饮食");
        BorderLayout lay=new BorderLayout();//创建一个布局管理器对象，将中间容器设置为此布局管理
        jf.setLayout(lay);
        //contentPane.add(b1,"North");//将五个普通按钮组件分别按照东、南、西、北、中五个方位添加到中间容器中
        contentPane.add(b1,BorderLayout.NORTH);
        contentPane.add(b2,"South");
        contentPane.add(b3,"East");
        contentPane.add(b4,"West");
        contentPane.add(b5,"Center");
    }  
}