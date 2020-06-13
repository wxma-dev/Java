package WIFI_AUTO_CONNECT;

public class Struct_Conf{
	public String sFlag_Nw_Ww;  /* 内外网连接标志 */
	public String sInterface;   /* 接口 */
	public String sSsid;        /* ssid */

	/* 配置赋值 */
	public static void Set_Struct_Conf(Struct_Conf st_cf, String sNode_Name, String sNode_Value)
	{
		if ( 0 == sNode_Name.compareTo("flag_network"))
		{
			st_cf.sFlag_Nw_Ww = sNode_Value;
		}
		else if ( 0 == sNode_Name.compareTo("interface"))
		{
			st_cf.sInterface  = sNode_Value;
		}
		else if ( 0 == sNode_Name.compareTo("ssid"))
		{
			st_cf.sSsid       = sNode_Value;
		}
	}
}