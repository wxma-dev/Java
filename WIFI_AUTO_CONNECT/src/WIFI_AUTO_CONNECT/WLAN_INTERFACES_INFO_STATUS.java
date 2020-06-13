package WIFI_AUTO_CONNECT;

public class WLAN_INTERFACES_INFO_STATUS {
    private CONFIG initcfg;
    private WLAN_INTERFACES_INFO  interfacekk;

    public WLAN_INTERFACES_INFO_STATUS()
    {        
        initcfg = new CONFIG();
        interfacekk = new WLAN_INTERFACES_INFO();
    }
    
    /*
     * 获取内网连接状态
     * return:    0  无连接
     *            1  有连接
     */
    private int get_wifinetwork_status_Nw()
    {
    	int i = 0;
    	int iRet = 0;
    	Struct_Conf[] b;
    	if ( 0 < this.initcfg.Get_StructSize_Cfg() )
    	{
    		b = this.initcfg.Get_Addr_Struct_Conf();

        	for( i = 0; i < this.initcfg.Get_StructSize_Cfg(); i++)
        	{
        		if ( 0 == b[i].sFlag_Nw_Ww.compareTo( "NW" ) )
        		{
        			
        			iRet = interfacekk.Get_WifiConnectStatus(b[i].sInterface, b[i].sSsid);
        		}
        	}
    	}
    	else
    	{
    		/* do nothing */
    	}

    	return iRet;
    }
    
    /*
     * 获取外网连接状态
     * return:    0  无连接
     *            1  有连接
     */
    private int get_wifinetwork_status_Ww()
    {
    	int i = 0;
    	int iRet = 0;
    	Struct_Conf[] b;
    	if ( 0 < this.initcfg.Get_StructSize_Cfg() )
    	{
    		b = this.initcfg.Get_Addr_Struct_Conf();

        	for( i = 0; i < this.initcfg.Get_StructSize_Cfg(); i++)
        	{
        		if ( 0 == b[i].sFlag_Nw_Ww.compareTo( "WW" ) )
        		{
        			
        			iRet = interfacekk.Get_WifiConnectStatus(b[i].sInterface, b[i].sSsid);
        		}
        	}
    	}
    	else
    	{
    		/* do nothing */
    	}

    	return iRet;
    }
    
    
    /*
     * 获取网络状态，
     * 内网网的连接情况接口：内外网  0
     *                       内网     1
     *                       外网     2
     *                       无         3
     */
    public int get_wifinetwork_status()
    {
    	int iRet = 3;
    	int iRet_Nw = -1;
    	int iRet_Ww = -1;
    	
    	iRet_Nw = this.get_wifinetwork_status_Nw();
    	iRet_Ww = this.get_wifinetwork_status_Ww();
        
    	if ( 1 == iRet_Nw && 1 == iRet_Ww )
    	{
    		iRet = 0;
    	}
    	else if ( 1 == iRet_Nw && 0 == iRet_Ww )
    	{
    		iRet = 1;
    	}
    	else if ( 0 == iRet_Nw && 1 == iRet_Ww )
    	{
    		iRet = 2;
    	}
    	else if ( 0 == iRet_Nw && 0 == iRet_Ww )
    	{
    		iRet = 3;
    	}
    	
        return iRet;
    }
    
/*
    public static void main(String[] args) 
    {
    	WIFI_NOW_CONNECT_STATUS a = new WIFI_NOW_CONNECT_STATUS();
    	System.out.println(a.get_wifinetwork_status_Nw());
    	System.out.println(a.get_wifinetwork_status_Ww());
    	System.out.println(a.get_wifinetwork_status());
    }
*/
}
