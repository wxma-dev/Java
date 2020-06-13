package HexConverter;

public class HexConverter {

	static char HexConverter_16_To_Char(String sStr_16)
	{
		String sStr_Tmp = Integer.valueOf( sStr_16,16).toString();
		char cChar_Tmp = (char)Integer.parseInt(sStr_Tmp);
		return cChar_Tmp;
	}
	
}
