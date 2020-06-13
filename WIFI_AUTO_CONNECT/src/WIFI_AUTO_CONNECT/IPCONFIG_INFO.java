package WIFI_AUTO_CONNECT;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;



public class IPCONFIG_INFO {
	private Struct_Ipconfig[] st_ipconfig;
	
	public IPCONFIG_INFO()
	{
		st_ipconfig = new Struct_Ipconfig[100];
		Set_IpconfigInfo();
	}

	/*
	 * 获取某个网卡是否能 默认网关
	 *         sWk_Name       网卡名称
	 * return  默认网关
	 */
	public String Get_Mrgw(String sWk_Name)
	{
		String sIP_Mrgw = null;
		int i = 0;
		for( i = 0; i < this.Get_StructSize_Ipconfig(); i++)
		{
			if ( null != this.st_ipconfig[i].sInterface_Name )
			{
				if ( 0 == this.st_ipconfig[i].sInterface_Name.compareTo(sWk_Name) )
				{
					sIP_Mrgw = this.st_ipconfig[i].sMrwg ;
				}
			}
		}
		return sIP_Mrgw;
	}
	
	/*
	 * 获取Struct_Ipconfig 节点的个数
	 */
	public int Get_StructSize_Ipconfig()
	{
		int i = 0;
		int iGs = 0;
		for( i = 0; i < st_ipconfig.length; i++)
		{
			if( st_ipconfig[i] != null )
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

	private void Set_IpconfigInfo()
	{
		int i = -1;
		String sFile_Name = "tmpfile/ipconfig.txt";
		int iRet = -1;

		CMD_DO_TOFILE.Do_Bat_ByStr( "ipconfig" +" > " + sFile_Name, null );
		try {
			FileInputStream fis   = new FileInputStream( sFile_Name );
			InputStreamReader isr = new InputStreamReader(fis, "GB2312");
			BufferedReader br     = new BufferedReader(isr);

			String line="";              /* 行buf */
			String line_Jq_Qm = "";      /* 截取字符串-前面 */
			String line_Jq_Hm = "";      /* 截取字符串-后面 */
			
			int iLeng_Arrys = 0;
			while ((line=br.readLine())!=null)
			{
				if ( 0 == line.trim().length() ) //line 去空格后，计算长度
				{
					/* do nothing */
				}
				else
				{
					line_Jq_Qm = "";
					line_Jq_Hm = "";

					String[] sourceStrArray = line.split(":");
					iLeng_Arrys = sourceStrArray.length;

					if ( iLeng_Arrys < 2 && sourceStrArray[0] == null )
					{
						/* do nothing */
					}
					else if ( iLeng_Arrys < 2 && sourceStrArray[0] != null )
					{
						
						if ( 0 == sourceStrArray[0].substring(0, 8).compareTo("无线局域网适配器") )
						{
							line_Jq_Qm = sourceStrArray[0].trim();
							line_Jq_Hm = null;
							
/*
无线局域网适配器 无线网络连接 2:

	   连接特定的 DNS 后缀 . . . . . . . :
	   本地链接 IPv6 地址. . . . . . . . : fe80::e51b:a1f1:528e:9661%17
	   IPv4 地址 . . . . . . . . . . . . : 10.242.134.67
	   子网掩码  . . . . . . . . . . . . : 255.255.255.0
	   默认网关. . . . . . . . . . . . . : 10.242.134.254
*/

							/* 去掉字符串中的 .号 */
							line_Jq_Qm = line_Jq_Qm.replace( ".", "");

							iRet = -1;
							iRet = Struct_Ipconfig.Set_Struct_IpconfigInfo( null, line_Jq_Qm, line_Jq_Hm );
							if ( 0 ==  iRet )
							{
								i++;
								st_ipconfig[i] = new Struct_Ipconfig();
							}

							if ( -1 != i )
							{
								Struct_Ipconfig.Set_Struct_IpconfigInfo( st_ipconfig[i], line_Jq_Qm, line_Jq_Hm );
							}
						}
						else
						{
							/* do nothing */
						}
	
					}
					else if ( sourceStrArray[0] != null && sourceStrArray[1] != null )
					{
						line_Jq_Qm = sourceStrArray[0].trim();
						line_Jq_Hm = sourceStrArray[1].trim();
						
						/* 去掉字符串中的 .号 */
						line_Jq_Qm = line_Jq_Qm.replace( ".", "");
	
						iRet = -1;
						iRet = Struct_Ipconfig.Set_Struct_IpconfigInfo( null, line_Jq_Qm, line_Jq_Hm );
						if ( 0 ==  iRet )
						{
							i++;
							st_ipconfig[i] = new Struct_Ipconfig();
						}
	
						if ( -1 != i )
						{
							Struct_Ipconfig.Set_Struct_IpconfigInfo( st_ipconfig[i], line_Jq_Qm, line_Jq_Hm );
						}
					}
					else
					{
						/* do nothing */
					}
				}
			}

			br.close();
			isr.close();
			fis.close();

		} catch (IOException e){
			e.printStackTrace();
		}
	}

/*	public static void main(String[] args)
	{
		WLAN_NETWORKS_INFO a = new WLAN_NETWORKS_INFO();
		System.out.println( a.Get_StructSize_NetworkInfo() );
		System.out.println( a.st_ipconfig[0].Get_StructSize_Struct_SSID() );
		System.out.println( a.st_ipconfig[1].Get_StructSize_Struct_SSID() );
	}*/

	
}