package JOptionPane;

public class MessageShow {

	public static final char TRADE_MARK = '\u2122';

	public static void show(String str)
	{
		javax.swing.JOptionPane.showMessageDialog(null, str);
	}

	public static void main(String[] args)
	{
		String message = "Java" + TRADE_MARK;

		System.out.println(message);

		show(message);
		System.exit(0);
	}

}