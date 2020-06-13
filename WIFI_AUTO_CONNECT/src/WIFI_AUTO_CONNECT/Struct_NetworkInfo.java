package WIFI_AUTO_CONNECT;

/*
Struct_SSID结构体需要存放如下内容：
SSID 1 : BOSZJKF
    Network type            : 结构
    身份验证                : WPA2 - 个人
    加密                    : CCMP
*/
class Struct_SSID{
	public String sSSID_SSID;                    /* SSID   */
	public String sSSID_NetworkType;             /* Network type   */
	public String sSSID_Sfyz      ;              /* 身份验证       */
	public String sSSID_Jm        ;              /* 加密           */
	
	public static int Set_Struct_SSID(Struct_SSID st_cf, String sNode_Name, String sNode_Value)
	{
		int iRet = 1;

		if ( null == st_cf )
		{
			
			 if ( 4 <= sNode_Name.length() )
			 {
				 if ( 0 == sNode_Name.substring(0, 4).compareTo("SSID") )
				 {
					 iRet = 0;
				 }
				 else
				 {
					 /* do nothing */
				 }
			 }
			 else
			 {
				 /* do nothing */
			 }
		}
		else
		{
			if ( 4 <= sNode_Name.length() )
			{
				if ( 0 == sNode_Name.substring(0, 4).compareTo("SSID") )
				{
				st_cf.sSSID_SSID              = sNode_Value;
				}
			}
			if ( 0 == sNode_Name.compareTo("Network type") )
			{
			st_cf.sSSID_NetworkType       = sNode_Value;
			}
			if ( 0 == sNode_Name.compareTo("身份验证") )
			{
			st_cf.sSSID_Sfyz              = sNode_Value;
			}
			if ( 0 == sNode_Name.compareTo("加密") )
			{
			st_cf.sSSID_Jm         = sNode_Value;
			}

		}
		return iRet;
	}
}

public class Struct_NetworkInfo{
	public String sNetwork_Jkmc   ;              /* 接口名称       */
	public Struct_SSID[] pSt_Network_Struct_SSID;/* 该接口下能够扫描的WIFI网络的数组 */
	
	public Struct_NetworkInfo()
	{
		pSt_Network_Struct_SSID = new Struct_SSID[100];
	}

	/*
	 * 获取Struct_SSID节点的个数
	 */
	public int Get_StructSize_Struct_SSID()
	{
		int i = 0;
		int iGs = 0;
		for( i = 0; i < pSt_Network_Struct_SSID.length; i++)
		{
			if( pSt_Network_Struct_SSID[i] != null )
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
	
	public static int Set_Struct_NetworkInfo(Struct_NetworkInfo st_cf, String sNode_Name, String sNode_Value)
	{
		int iRet = 1;
		int iIndex1 = 0, iIndex2 = 0;
		int i = 0;

		if ( null == st_cf )
		{
			if ( 0 == sNode_Name.compareTo("接口名称") )
			{
				iRet = 0;
			}
			else
			{
				/* do nothing */
			}
		}
		else
		{

			if ( 0 == sNode_Name.compareTo("接口名称") )
			{
			st_cf.sNetwork_Jkmc    = sNode_Value;
			}
			else
			{
				iRet = -1;
				iRet = Struct_SSID.Set_Struct_SSID( null, sNode_Name, sNode_Value );
				if ( 0 ==  iRet )
				{
					int j = 0;
					for( j = 0; j < st_cf.pSt_Network_Struct_SSID.length ;j++)
					{
						if ( null != st_cf.pSt_Network_Struct_SSID[j] )
						{
							/* do nothing */
						}
						else
						{
							iIndex1 = j;
							break;
						}
					}
					
					st_cf.pSt_Network_Struct_SSID[iIndex1] = new Struct_SSID();
				}
				
				int j = 0;
				for( j = 0; j < st_cf.pSt_Network_Struct_SSID.length ;j++)
				{
					if ( null != st_cf.pSt_Network_Struct_SSID[j] )
					{
						/* do nothing */
					}
					else
					{
						iIndex2 = j -1;
						break;
					}
				}

				if ( -1 != iIndex2 )
				{
				Struct_SSID.Set_Struct_SSID(st_cf.pSt_Network_Struct_SSID[iIndex2], sNode_Name, sNode_Value);
				}
			}
		}
		return iRet;
	}
}


