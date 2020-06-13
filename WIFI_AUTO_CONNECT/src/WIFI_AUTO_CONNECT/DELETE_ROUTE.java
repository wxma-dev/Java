package WIFI_AUTO_CONNECT;

import java.io.IOException;

public class DELETE_ROUTE{

	private String strcmd;
	private int    iCount;
	
	private  String sIPV4_Nw;
	private  String sIPV4_Ww;
	public   String sRoute_Mr_Nw;
	private  String sRoute_Mr_Ww;
	
	private  ROUTE routehh;

	public DELETE_ROUTE() {
			strcmd = "bat/ipconfigtofile.bat";
			CMD_DO docmd1 = new CMD_DO(strcmd);
			
			strcmd = "bat/routeprint.bat";
			CMD_DO docmd2 = new CMD_DO(strcmd);
			
			IPCONFIG GetIpconfig = new IPCONFIG( "tmpfile/ipconfig.txt" );
			
			sIPV4_Nw = GetIpconfig.getIPV4_Nw();
			System.out.println( sIPV4_Nw );
			
			sRoute_Mr_Nw = GetIpconfig.getRoute_Nw();
			System.out.println( sRoute_Mr_Nw );
	
			sIPV4_Ww = GetIpconfig.getIPV4_Ww();
			System.out.println( sIPV4_Ww );
			
			sRoute_Mr_Ww = GetIpconfig.getRoute_Ww();
			System.out.println( sRoute_Mr_Ww );
			
			routehh = new ROUTE( "tmpfile/route.txt" );
			
			if ( 	null != sIPV4_Nw &&
					null != sIPV4_Ww &&
					null != sRoute_Mr_Nw &&
					null != sRoute_Mr_Ww )
			{
				/* 组删除路由bat */
				if ( -1 == routehh.delRoute_Hd_Mr_Nw( sRoute_Mr_Nw ) )
				{
					/* do nothing */
					System.out.println( "Do nothing" + "组删除路由bat" );
				}
				else
				{
						/* 删除活动路由表 */
						strcmd = "DelMrRouteYj.bat";
						CMD_DO strcmd3 = new CMD_DO(strcmd);
				}
			}
			else
			{
				System.out.println( "Do nothing" + "不符合条件" );
			}
	}

	public int DelYMG_AddXWG(String del_wg, String add_wg)
	{
		return routehh.DelYMG_AddXWG(del_wg,add_wg);
	}
	
}
