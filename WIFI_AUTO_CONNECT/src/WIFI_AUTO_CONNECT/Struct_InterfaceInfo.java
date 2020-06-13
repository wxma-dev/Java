package WIFI_AUTO_CONNECT;

public class Struct_InterfaceInfo{
	public String sInterface_Mc   ;              /* 名称            */
	public String sInterface_Ms   ;              /* 描述            */
	public String sInterface_GUID ;              /* GUID            */
	public String sInterface_Wldz ;              /* 物理地址        */
	public String sInterface_Zt   ;              /* 状态            */
	public String sInterface_SSID ;              /* SSID            */
	public String sInterface_BSSID;              /* BSSID           */
	public String sInterface_Wllx ;              /* 网络类型        */
	public String sInterface_Wxdlx;              /* 无线电类型      */
	public String sInterface_Sfyz ;              /* 身份验证        */
	public String sInterface_Mm   ;              /* 密码            */
	public String sInterface_Ljms ;              /* 连接模式        */
	public String sInterface_Xd   ;              /* 信道            */
	public String sInterface_Jssl ;              /* 接收速率(Mbps)  */
	public String sInterface_Cssl ;              /* 传输速率 (Mbps) */
	public String sInterface_Xh   ;              /* 信号            */
	public String sInterface_Pzwj ;              /* 配置文件        */

	public static int Set_Struct_InterfaceInfo(Struct_InterfaceInfo st_cf, String sNode_Name, String sNode_Value)
	{
		int iRet = 1;

		if ( null == st_cf )
		{
			 if ( 0 == sNode_Name.compareTo("名称") )
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
			if ( 0 == sNode_Name.compareTo("名称") )
			{
			st_cf.sInterface_Mc    = sNode_Value;
			}
			if ( 0 == sNode_Name.compareTo("描述") )
			{
			st_cf.sInterface_Ms    = sNode_Value;
			}
			if ( 0 == sNode_Name.compareTo("GUID") )
			{
			st_cf.sInterface_GUID  = sNode_Value;
			}
			if ( 0 == sNode_Name.compareTo("物理地址") )
			{
			st_cf.sInterface_Wldz  = sNode_Value;
			}
			if ( 0 == sNode_Name.compareTo("状态") )
			{
			st_cf.sInterface_Zt    = sNode_Value;
			}
			if ( 0 == sNode_Name.compareTo("SSID") )
			{
			st_cf.sInterface_SSID  = sNode_Value;
			}
			if ( 0 == sNode_Name.compareTo("BSSID") )
			{
			st_cf.sInterface_BSSID = sNode_Value;
			}
			if ( 0 == sNode_Name.compareTo("网络类型") )
			{
			st_cf.sInterface_Wllx  = sNode_Value;
			}
			if ( 0 == sNode_Name.compareTo("无线电类型") )
			{
			st_cf.sInterface_Wxdlx = sNode_Value;
			}
			if ( 0 == sNode_Name.compareTo("身份验证") )
			{
			st_cf.sInterface_Sfyz  = sNode_Value;
			}
			if ( 0 == sNode_Name.compareTo("密码") )
			{
			st_cf.sInterface_Mm    = sNode_Value;
			}
			if ( 0 == sNode_Name.compareTo("连接模式") )
			{
			st_cf.sInterface_Ljms  = sNode_Value;
			}
			if ( 0 == sNode_Name.compareTo("信道") )
			{
			st_cf.sInterface_Xd    = sNode_Value;
			}
			if ( 0 == sNode_Name.compareTo("接收速率(Mbps)") )
			{
			st_cf.sInterface_Jssl  = sNode_Value;
			}
			if ( 0 == sNode_Name.compareTo("传输速率 (Mbps)") )
			{
			st_cf.sInterface_Cssl  = sNode_Value;
			}
			if ( 0 == sNode_Name.compareTo("信号") )
			{
			st_cf.sInterface_Xh    = sNode_Value;
			}
			if ( 0 == sNode_Name.compareTo("配置文件") )
			{
			st_cf.sInterface_Pzwj  = sNode_Value;
			}

		}
		return iRet;
	}
}


