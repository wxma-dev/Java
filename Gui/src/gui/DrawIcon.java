package gui;

import java.awt.*;
import javax.swing.*;
 
/**
 * This example shows the drawing of an icon using the Icon interface
 *  for the JLable component.
 * @author han
 *
 */
public class DrawIcon implements Icon{//该类实现该接口icon
    private int width;
    private int height;

    @Override
    public int getIconHeight(){
        return this.height;
    }

    @Override
    public int getIconWidth(){
        return this.width;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y){
        g.setColor(Color.red);
        g.fillOval(x, y, width, height);
    }

    /*the construct function*/
    public DrawIcon(int width, int height){
        this.width=width;
        this.height=height;
    }

    public static void main(String[] args){
        DrawIcon icon=new DrawIcon(15,15);  //这应该是绘制图表
        JLabel jl=new JLabel("测试",icon,SwingConstants.CENTER);
        JFrame jf=new JFrame();
        Container c=jf.getContentPane();
        c.add(jl);
        jf.setVisible(true);
        jf.setSize(300,300);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}