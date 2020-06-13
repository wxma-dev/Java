package JTextComponment;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class JTextAreaShowText extends JFrame{
    public JTextAreaShowText() {
        init();
    }
    
    private void init(){
        final JTextArea area=new JTextArea();//存放文本的文本域
        JButton btn=new JButton("GO");
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // 单击按钮事件
            	try {
					File file=new File("test.txt");//要读取的文件

					if(file!=null && file.isFile()){
					
						FileReader fr=new FileReader(file);
						BufferedReader br=new BufferedReader(fr);
						String str=br.readLine();//读取一行
						while(str!=null){
							area.append(str+"\n");//将读取的数据追加到文本域
							str=br.readLine();//读取下一行
						}
					}
					else
					{
						//do nothing
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });
        this.setSize(400, 300);
        this.add(area,BorderLayout.CENTER);
        this.add(btn,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[]args){
    	JTextAreaShowText test=new JTextAreaShowText();
        test.setVisible(true);
    }
}
