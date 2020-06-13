package WIFI_AUTO_CONNECT;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;



public class WLAN_NETWORKS_INFO {
	private Struct_NetworkInfo[] st_network;

	public WLAN_NETWORKS_INFO()
	{
		st_network = new Struct_NetworkInfo[100];
		Set_NetworkInfo();
	}

	/*
	 * 获取某个网卡是否能 侦测到 指定的WIFI
	 * return  1  能侦测到指定的WIFI
	 *         0 未能侦测到指定的WIFI
	 */
	public int Get_CheckNetwork(String sWk_Name, String sWifi_Name)
	{
		int i = 0;
		int iRet = 0;
		for( i = 0; i < this.Get_StructSize_NetworkInfo(); i++)
		{
			if ( null != this.st_network[i].sNetwork_Jkmc )
			{
				if ( 0 == this.st_network[i].sNetwork_Jkmc.compareTo(sWk_Name) )
				{
					int j = 0;
					for( j = 0; j < st_network[i].Get_StructSize_Struct_SSID(); j++)
					{
						if( 0 == st_network[i].pSt_Network_Struct_SSID[j].sSSID_SSID.compareTo(sWifi_Name) )
						{
							iRet = 1;
						}
					}
				}
			}
			
		}
		return iRet;
	}
	
	/*
	 * 获取Struct_NetworkInfo 节点的个数
	 */
	public int Get_StructSize_NetworkInfo()
	{
		int i = 0;
		int iGs = 0;
		for( i = 0; i < st_network.length; i++)
		{
			if( st_network[i] != null )
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
	
	/*
	 * 获取指定Struct_NetworkInfo中的Struct_SSID 节点的个数
	 */
	public int Get_StructSize_Struct_SSID(Struct_NetworkInfo Node)
	{
		int iGs = 0;
		
		iGs = Node.Get_StructSize_Struct_SSID();
		
		return iGs;
	}


	private void Set_NetworkInfo()
	{
		int i = -1;
		String sFile_Name = "tmpfile/netsh_wlan_show_network.txt";
		int iRet = -1;

		CMD_DO_TOFILE.Do_Bat_ByStr( "netsh wlan show network" +" > " + sFile_Name, null );
		try {
			FileInputStream fis   = new FileInputStream( sFile_Name );
			//InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			InputStreamReader isr = new InputStreamReader(fis, "GB2312");
			BufferedReader br     = new BufferedReader(isr);

			String line="";              /* 行buf */
			String line_Jq_Qm = "";      /* 截取字符串-前面 */
			String line_Jq_Hm = "";      /* 截取字符串-后面 */
			
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
					iRet = Struct_NetworkInfo.Set_Struct_NetworkInfo( null, line_Jq_Qm, line_Jq_Hm );
					if ( 0 ==  iRet )
					{
						i++;
						st_network[i] = new Struct_NetworkInfo();
					}

					if ( -1 != i )
					{
						Struct_NetworkInfo.Set_Struct_NetworkInfo( st_network[i], line_Jq_Qm, line_Jq_Hm );
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
		WLAN_NETWORKS_INFO a = new WLAN_NETWORKS_INFO();
		System.out.println( a.Get_StructSize_NetworkInfo() );
		System.out.println( a.st_network[0].Get_StructSize_Struct_SSID() );
		System.out.println( a.st_network[1].Get_StructSize_Struct_SSID() );
	}
*/
	
}