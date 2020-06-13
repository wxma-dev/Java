package Menu;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;


/**
 * 自定义窗口WindowMenu
 * @author Peng
 */
public class MenuWindow extends JFrame {
    JMenuBar menubar;
    JMenu menu, subMenu;
    JMenuItem item1, item2;

    public MenuWindow() {
    }

    public MenuWindow(String s, int x, int y, int w, int h) {
        init(s);
        setLocation(x, y);
        setSize(w, h);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    void init(String s) {
        setTitle(s);
        menubar = new JMenuBar();
        menu = new JMenu("菜单"); // JMnud的实例就是一个菜单

        /**
         * 一级菜单项
         */
        subMenu = new JMenu("软件项目"); // 子菜单
        item1 = new JMenuItem("Java话题"); // 创建菜单项
        //为菜单项设置图标
        ImageIcon icon = new ImageIcon("a.png");
        item1.setIcon(icon);

        //使用JMenuItem的构造方法设置图标
        item2 = new JMenuItem("动画话题", new ImageIcon("b.png"));
        item1.setAccelerator(KeyStroke.getKeyStroke('A'));
        item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        menu.add(item1);
        menu.addSeparator();
        menu.add(item2);
        menu.add(subMenu);
        /**
         * 添加二级菜单项
         */
        subMenu.add(new JMenuItem("汽车销售系统", new ImageIcon("c.png")));
        subMenu.add(new JMenuItem("农场信息系统", new ImageIcon("d.png")));
        menubar.add(menu); // 菜单条中加入菜单
        setJMenuBar(menubar); // 添加一个菜单条

    }
    
    public static void main(String[] args) {
    	MenuWindow win = new MenuWindow("带窗口的菜单", 20, 30, 400, 500);
    }
}


