package JTextComponment;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JTextAreaGetText {

    public static void main(String[] args) {
        JFrame frame = new JFrame("ShareModel");
       
        JTextArea areaFiftyOne = new JTextArea();
        JTextArea areaFiftyTwo = new JTextArea();
        areaFiftyTwo.setDocument(areaFiftyOne.getDocument());
        JTextArea areaFiftyThree = new JTextArea();
        areaFiftyThree.setDocument(areaFiftyOne.getDocument());
       
        Container content = frame.getContentPane();
        content.setLayout(new GridLayout(3,1));
        content.add(new JScrollPane(areaFiftyOne));
        content.add(new JScrollPane(areaFiftyTwo));
        content.add(new JScrollPane(areaFiftyThree));
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}

