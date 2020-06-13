package WIFI_AUTO_CONNECT;

public class Struct_Ipconfig{
	public String sInterface_Name;     /* 网卡名称 */

	public String sBd_Connect_DNS_Zz;  /* 连接特定的 DNS 后缀 */
	public String sBd_Connect_Ipv6;    /* 本地链接 IPv6 地址   */
	public String sAddr_Ipv4;          /* IPv4 地址 */
	public String sZwym;               /* 子网掩码 */
	public String sMrwg;               /* 默认网关 */

	/* 配置赋值 */
	public static int Set_Struct_IpconfigInfo(Struct_Ipconfig st_cf, String sNode_Name, String sNode_Value)
	{
		int iRet = 1;

		if ( null == st_cf )
		{
			 if ( 8 <= sNode_Name.length() )
			 {
				 if ( 0 == sNode_Name.substring(0, 8).compareTo("无线局域网适配器") )
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
			if ( 8 <= sNode_Name.length() )
			{
				
				/*
				 * 获取接口名
				 */
				if ( 0 == sNode_Name.substring(0, 8).compareTo("无线局域网适配器") )
				{
					/* 将sNode_Value根据空格再次分割下，取后者 */
					String line_Jq_Qm = "";
					String line_Jq_Hm = "";

					/*
					 * sNode_Name 举例为："无线局域网适配器 无线网络连接 2:"
					 * 这种情况不能 sNode_Name.split(" ") 取第二个为接口名，只能讲
					 * 
					 */
					
					/* del by mawx@20180712
					String[] sourceStrArray = sNode_Name.split(" ");
					*/
					String[] sourceStrArray = {null,null};
					sourceStrArray[0] = sNode_Name.substring(0, "无线局域网适配器".length());
					sourceStrArray[1] = sNode_Name.substring( "无线局域网适配器".length() + 1, sNode_Name.length());

					if (null != sourceStrArray )
					{
						int iLeng_Arrys = sourceStrArray.length;
						if ( iLeng_Arrys < 2 )
						{
							/* do nothing */
						}
						else if ( sourceStrArray[0] != null && sourceStrArray[1] != null )
						{
							line_Jq_Qm = sourceStrArray[0].trim();
							line_Jq_Hm = sourceStrArray[1].trim();   //接口名

							/*
							 * 接口名赋值给结构体
							 */
							st_cf.sInterface_Name   = line_Jq_Hm;
						}
					}
				}
			}

			if ( 0 == sNode_Name.trim().compareTo("连接特定的 DNS 后缀"))
			{
				st_cf.sBd_Connect_DNS_Zz = sNode_Value;
			}
			else if ( 0 == sNode_Name.trim().compareTo("本地链接 IPv6 地址"))
			{
				st_cf.sBd_Connect_Ipv6   = sNode_Value;
			}
			else if ( 0 == sNode_Name.trim().compareTo("IPv4 地址"))
			{
				st_cf.sAddr_Ipv4         = sNode_Value;
			}
			else if ( 0 == sNode_Name.trim().compareTo("子网掩码"))
			{
				st_cf.sZwym              = sNode_Value;
			}
			else if ( 0 == sNode_Name.trim().compareTo("默认网关"))
			{
				st_cf.sMrwg              = sNode_Value;
			}

		}
		return iRet;
	}
}






