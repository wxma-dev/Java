package JOptionPane;

import javax.swing.JOptionPane;

public class DialogInput {

	public static void main( String[] args ) {

		String firstNumber;
		String secondNumber;
		int number1;
		int number2;
		int sum;

		firstNumber = JOptionPane.showInputDialog( "First Num" );
		secondNumber = JOptionPane.showInputDialog( "Second Num" );
		number1 = Integer.parseInt( firstNumber );
		number2 = Integer.parseInt( secondNumber );
		sum = number1 + number2;

		JOptionPane.showMessageDialog(
		null,
		"The Sum is:" + sum,
		"Results",
		JOptionPane.PLAIN_MESSAGE
		);

		System.exit( 0 );
	}
}