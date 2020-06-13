package WIFI_AUTO_CONNECT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class IPCONFIG {

	private String sFile_Name;
	private String sIP_Nw_Bf;			/* 内网ip中部分内容 */
	private String sIP_Ww_Bf;			/* 外网ip中部分内容 */
	private String sIP_Nw;				/* 内网IP */
	private String sIP_Ww;				/* 外网IP */
	private String sRoute_Mr_Nw;		/* 内网默认网关 */
	private String sRoute_Mr_Ww;		/* 外网默认网关 */
	
	
	public IPCONFIG(String file_name)
	{
		sFile_Name = file_name;
		sIP_Nw_Bf = "10.242";
		sIP_Ww_Bf = "192.168.43";
		sIP_Nw = null;
		sIP_Ww = null;
		sRoute_Mr_Nw = null;
		sRoute_Mr_Ww = null;
	}
	
	//获取内网IP
	public String getIPV4_Nw() {
		try {
		FileInputStream fis=new FileInputStream( sFile_Name );
		InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		//简写如下
		//BufferedReader br = new BufferedReader(new InputStreamReader(
		//new FileInputStream("E:/phsftp/evdokey/evdokey_201103221556.txt"), "UTF-8"));
		String line="";
		String[] arrs=null;
		while ((line=br.readLine())!=null) {

			//System.out.println(line);
			
			int index = 0;
			index = line.indexOf(sIP_Nw_Bf, index);
			if ( -1 != index )
			{
				int index_1 = 0;
				index_1 = line.indexOf("IPv4", index_1);
				if ( -1 != index_1 )
				{
					//System.out.print("Ww:");
					 index = 0;
					 index = line.indexOf(sIP_Nw_Bf, index);

					 String substr1=line.substring(index);
					 //System.out.println( substr1 );
					 sIP_Nw = substr1;
				}
			}
		}
		br.close();
		isr.close();
		fis.close();
		
		} catch (IOException e) {  
			e.printStackTrace();  
		}  
		return sIP_Nw;
	}


	//获取内网网关
	public String getRoute_Nw()
	{
		int iCount = 0;
		int iIndex = 0;
		
		try {
		FileInputStream fis=new FileInputStream( sFile_Name );
		InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		//简写如下
		//BufferedReader br = new BufferedReader(new InputStreamReader(
		//new FileInputStream("E:/phsftp/evdokey/evdokey_201103221556.txt"), "UTF-8"));
		String line="";
		String[] arrs=null;
		while ((line=br.readLine())!=null) {

			//System.out.println(line);
			if ( iCount != 0 )
			{
				iCount++;
			}
			
			int index = 0;
			index = line.indexOf(sIP_Nw_Bf, index);
			if ( -1 != index )
			{
				int index_1 = 0;
				index_1 = line.indexOf("IPv4", index_1);
				if ( -1 != index_1 )
				{
					iCount++;

					 index = 0;
					 index = line.indexOf(sIP_Nw_Bf, index);
					 
					 iIndex = index;
					 
					 String substr1=line.substring(index);
					 //System.out.println( substr1 );
					 sIP_Nw = substr1;

				}
			}
			
			if ( 3 == iCount )
			{
				int index_2 = 0;
				if ( -1 == line.indexOf(sIP_Nw_Bf, index_2) )
				{
					/* do nothing */
				}
				else
				{
					String substr1=line.substring(index);
					sRoute_Mr_Nw = substr1;
				}

			}
		}
		br.close();
		isr.close();
		fis.close();
		
		} catch (IOException e) {  
			e.printStackTrace();  
		}  
		return sRoute_Mr_Nw;
	}
	

	//获取外网IP
	public String getIPV4_Ww()
	{
		try {
			FileInputStream fis=new FileInputStream( sFile_Name );
			InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			//简写如下
			//BufferedReader br = new BufferedReader(new InputStreamReader(
			//new FileInputStream("E:/phsftp/evdokey/evdokey_201103221556.txt"), "UTF-8"));
			String line="";
			String[] arrs=null;
			while ((line=br.readLine())!=null) {

				//System.out.println(line);
				
				int index = 0;
				index = line.indexOf(sIP_Ww_Bf, index);
				if ( -1 != index )
				{
					int index_1 = 0;
					index_1 = line.indexOf("IPv4", index_1);
					if ( -1 != index_1 )
					{
						//System.out.print("Ww:");
						 index = 0;
						 index = line.indexOf(sIP_Ww_Bf, index);

						 String substr1=line.substring(index);
						 //System.out.println( substr1 );
						 sIP_Ww = substr1;
					}
				}
			}
			br.close();
			isr.close();
			fis.close();
			
			} catch (IOException e) {  
				e.printStackTrace();  
			}  
			return sIP_Ww;
	}

	//获取外网网关
	public String getRoute_Ww()
	{
		int iCount = 0;
		int iIndex = 0;
		
		try {
		FileInputStream fis=new FileInputStream( sFile_Name );
		InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		//简写如下
		//BufferedReader br = new BufferedReader(new InputStreamReader(
		//new FileInputStream("E:/phsftp/evdokey/evdokey_201103221556.txt"), "UTF-8"));
		String line="";
		String[] arrs=null;
		while ((line=br.readLine())!=null) {

			//System.out.println(line);
			if ( iCount != 0 )
			{
				iCount++;
			}
			
			int index = 0;
			index = line.indexOf(sIP_Ww_Bf, index);
			if ( -1 != index )
			{
				int index_1 = 0;
				index_1 = line.indexOf("IPv4", index_1);
				if ( -1 != index_1 )
				{
					iCount++;

					 index = 0;
					 index = line.indexOf(sIP_Ww_Bf, index);
					 
					 iIndex = index;
					 
					 String substr1=line.substring(index);
					 //System.out.println( substr1 );
					 sIP_Nw = substr1;

				}
			}
			
			if ( 3 == iCount )
			{
				//String substr1=line.substring(index);
				//sRoute_Mr_Ww = substr1;
				
				int index_2 = 0;
				if ( -1 == line.indexOf(sIP_Ww_Bf, index_2) )
				{
					/* do nothing */
				}
				else
				{
					String substr1=line.substring(index);
					sRoute_Mr_Ww = substr1;
				}
			}
		}
		br.close();
		isr.close();
		fis.close();
		
		} catch (IOException e) {  
			e.printStackTrace();  
		}
		return sRoute_Mr_Ww;
	}

}
