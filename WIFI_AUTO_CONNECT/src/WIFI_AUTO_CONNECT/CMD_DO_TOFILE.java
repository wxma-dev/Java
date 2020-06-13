package WIFI_AUTO_CONNECT;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class CMD_DO_TOFILE {
	private  static  long  iId_BatFile;              /* 文件序号 */

	/* 获取字符串格式的文件名 */
	private static String getBatFileName()
	{
		String sFile_name = null;
		if ( iId_BatFile > 100 )
		{
			iId_BatFile = 0;
		}
		iId_BatFile++;
		sFile_name =  iId_BatFile + ".bat";
		
		return sFile_name;
	}
	
	public static String changeCharset(String str, String newCharset) throws UnsupportedEncodingException {
        if(str != null) {
            //用默认字符编码解码字符串。与系统相关，中文windows默认为GB2312
            byte[] bs = str.getBytes();
            return new String(bs, newCharset);    //用新的字符编码生成字符串
        }
        return null;
    }
	
	/** 将字符编码转换成GB2312     */
    public static String toGB2312(String str) throws UnsupportedEncodingException {
        return changeCharset(str,"GB2312");
    }


	/*
	 * 该函数实现，执行bat字符串的处理，将bat执行的记过放在sOutFile_Name文件中
	 * sCmd_Str      命令字符串
	 * sOutFile_Name 执行的结果放在该文件中, 可以为null
	 * return: 0    执行是成功的
	 *         -1  执行是失败的
	 */
	public static int Do_Bat_ByStr( String sCmd_Str, String sOutFile_Name )
	{
		int iFlag_Succ = -1;
		String sCmd = null;
		String sFileName = null;
		
		if ( null != sOutFile_Name )
		{
			sCmd = sCmd_Str + " > " + sOutFile_Name;
		}
		else
		{
			sCmd = sCmd_Str;
		}
/*
		FileWriter writer;
		try {
		  sFileName = getBatFileName();
		  writer = new FileWriter( sFileName );

		  String sCmd_Gb2312 = new String( sCmd.getBytes("utf-8"), "gb2312");

		} catch (IOException e) {
		  e.printStackTrace();
		  iFlag_Succ = -1;
		}
*/
		String sBatDir = null;
		String sFileName_Bat = null;
		try {
			
		  sFileName = getBatFileName();
		  //writer = new FileWriter( sFileName );
		  //String sCmd_Gb2312 = new String( sCmd.getBytes("utf-8"), "gb2312");
		  
		  sBatDir = "bat/";
		  sFileName_Bat = sBatDir + sFileName;

		  FileOutputStream fos = new FileOutputStream( sFileName_Bat );   
	       OutputStreamWriter osw = new OutputStreamWriter(fos, "gb2312");   
	       osw.write(sCmd);   
	       osw.flush(); 
	       osw.close();
	       
		} catch (IOException e) {
		  e.printStackTrace();
		  iFlag_Succ = -1;
		}
		
		CMD_DO docmd1 = new CMD_DO( sFileName_Bat );

		iFlag_Succ = 0;
		return iFlag_Succ;
	}
/*
	public static void main(String args[])
	{
		String str1 = new String("无线网络连接 2");
		
		try {
			FileWriter writer = new FileWriter( "1.txt" );
			byte[] tembyte = str1.getBytes("utf-8");
			String str2=new String (tembyte);

			  writer.write( str2 );

			  writer.flush();
			  writer.close();
			  
			  FileOutputStream fos = new FileOutputStream("test.txt");   
		       OutputStreamWriter osw = new OutputStreamWriter(fos, "gb2312");   
		       osw.write(str2);   
		       osw.flush(); 
		       osw.close();
			  
		} catch (IOException e) {
			
		}
	}
*/
}
