package WIFI_AUTO_CONNECT;

public class WLAN_NETWORKS_INFO_STATUS {
    private CONFIG initcfg;
    private WLAN_NETWORKS_INFO  networkkk;

    public WLAN_NETWORKS_INFO_STATUS()
    {        
        initcfg = new CONFIG();
        networkkk = new WLAN_NETWORKS_INFO();
    }
    
    /*
     * 侦测指定网卡是否有可连接的内网WIFI
     * return:    0  无
     *            1  有
     */
    public int get_checknetwork_status_Nw()
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
        			
        			iRet = networkkk.Get_CheckNetwork(b[i].sInterface, b[i].sSsid);
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
     * 侦测指定网卡是否有可连接的外网WIFI
     * return:    0  无
     *            1  有
     */
    public int get_checknetwork_status_Ww()
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
        			
        			iRet = networkkk.Get_CheckNetwork(b[i].sInterface, b[i].sSsid);
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
    public static void main(String[] args) 
    {
    	WLAN_NETWORKS_INFO_STATUS a = new WLAN_NETWORKS_INFO_STATUS();
    	System.out.println(a.get_checknetwork_status_Nw());
    	System.out.println(a.get_checknetwork_status_Ww());

    }
*/
}
