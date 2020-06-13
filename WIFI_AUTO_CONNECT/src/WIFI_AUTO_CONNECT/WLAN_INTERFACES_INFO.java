package WIFI_AUTO_CONNECT;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;



public class WLAN_INTERFACES_INFO {
	private Struct_InterfaceInfo[] st_interface;

	public WLAN_INTERFACES_INFO()
	{
		st_interface = new Struct_InterfaceInfo[100];
		Set_InterfaceInfo();
	}

	/*
	 * 获取某个网卡是否连接指定wifi
	 * return  1  网卡已经连接指定wifi
	 *         0 网卡未连接指定wifi
	 */
	public int Get_WifiConnectStatus(String sWk_Interface, String sWifi_Name)
	{
		int i = 0;
		int iRet = 0;
		for( i = 0; i < this.Get_StructSize_InterfaceInfo(); i++)
		{
			if ( null != this.st_interface[i].sInterface_SSID &&
				 null != this.st_interface[i].sInterface_Mc )
			{
				if ( 0 == this.st_interface[i].sInterface_Mc.compareTo(sWk_Interface) && 
					 0 == this.st_interface[i].sInterface_SSID.compareTo(sWifi_Name) )
				{
					iRet = 1;
				}
			}
			
		}
		return iRet;
	}
	
	/*
	 * 获取接口信息的个数
	 */
	public int Get_StructSize_InterfaceInfo()
	{
		int i = 0;
		int iGs = 0;
		for( i = 0; i < st_interface.length; i++)
		{
			if( st_interface[i] != null )
			{
				iGs++;
			}
			else
			{
				break;
			}
		}
		return iGs;
	}


	private void Set_InterfaceInfo()
	{
		int i = -1;
		String sFile_Name = "tmpfile/netsh_wlan_show_interface.txt";
		int iRet = -1;
		int iLength_Str = 0;

		CMD_DO_TOFILE.Do_Bat_ByStr( "netsh wlan show interface" +" > " + sFile_Name, null );
		try {
			FileInputStream fis   = new FileInputStream( sFile_Name );
			//InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			InputStreamReader isr = new InputStreamReader(fis, "GB2312");
			BufferedReader br     = new BufferedReader(isr);

			String line="";              /* 行buf */
			String line_Jq_Qm = "";      /* 截取字符串-前面 */
			String line_Jq_Hm = "";      /* 截取字符串-后面 */
			String[] arrs=null;
			
			int iLeng_Arrys = 0;
			while ((line=br.readLine())!=null)
			{
				line_Jq_Qm = "";
				line_Jq_Hm = "";
				String[] sourceStrArray = line.split(":");
				iLeng_Arrys = sourceStrArray.length;
				if ( iLeng_Arrys < 2 )
				{
					/* do nothing */
				}
				else if ( sourceStrArray[0] != null && sourceStrArray[1] != null )
				{
					line_Jq_Qm = sourceStrArray[0].trim();
					line_Jq_Hm = sourceStrArray[1].trim();
					
					iRet = -1;
					iRet = Struct_InterfaceInfo.Set_Struct_InterfaceInfo( null, line_Jq_Qm, line_Jq_Hm );
					if ( 0 ==  iRet )
					{
						i++;
						st_interface[i] = new Struct_InterfaceInfo();
					}

					if ( -1 != i )
					{
						Struct_InterfaceInfo.Set_Struct_InterfaceInfo( st_interface[i], line_Jq_Qm, line_Jq_Hm );
					}
				}
				else
				{
					/* do nothing */
				}

			}

			br.close();
			isr.close();
			fis.close();

		} catch (IOException e){
			e.printStackTrace();
		}
	}
/*
	public static void main(String[] args)
	{
		WLAN_INTERFACE_INFO a = new WLAN_INTERFACE_INFO();
		System.out.println(a.Get_StructSize_InterfaceInfo() );
		System.out.println(a.Get_WifiConnectStatus("无线网络连接 2", "BOSZJKF") );
		System.out.println(a.Get_WifiConnectStatus("无线网络连接 2", "BOSZJKF1") );
	}
*/
	
}