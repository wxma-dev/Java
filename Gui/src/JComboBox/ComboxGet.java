package JComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComboxGet implements ItemListener
{
    private   JComboBox<Object> comboBox ;
    public ComboxGet()
    {
        JFrame frame = new JFrame("window");
         
        final String def[] =
        { "A", "B", "C", "D", "E" };        
        comboBox = new JComboBox<Object>(def);
        comboBox.addItemListener(this);
        comboBox.setEditable(true);
        frame.add(comboBox, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        for(int i = 0;i<comboBox.getItemCount();i++)
            System.out.println(comboBox.getItemAt(i));
         
    }
    public static void main(final String args[])
    {
        new ComboxGet();
    }
    @Override
    public void itemStateChanged(ItemEvent e)
    {
        System.out.println(comboBox.getSelectedItem()); 
    }
}

