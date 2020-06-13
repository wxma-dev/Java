package WIFI_AUTO_CONNECT;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ROUTE {
	private String sFile_Name;
	private String sRoute_Hd_Mr_Nw;   

	public ROUTE(String sFName )
	{
		sFile_Name = sFName;
		sRoute_Hd_Mr_Nw = null;
	}

	/* 组bat文件：永久删除默认路由 */
	private int writebat_DelMrRouteYj( String sRoute )
	{
		int iFlag_Succ = -1;
		//route delete 0.0.0.0 mask 0.0.0.0 10.242.134.254
		String sCmd = null;
		sCmd = "route delete 0.0.0.0 mask 0.0.0.0 " + sRoute;
		
		FileWriter writer;
		try {
		  writer = new FileWriter("DelMrRouteYj.bat");
		  writer.write(sCmd);
		  writer.flush();
		  writer.close();
		} catch (IOException e) {
		  e.printStackTrace();
		  iFlag_Succ = -1;
		}
		iFlag_Succ = 0;
		
		return iFlag_Succ;
		
		
	}

	/* 删除活动默认路由 */
	public int delRoute_Hd_Mr_Nw(String sRoute_Mr_Nw)
	{
		int iFlag_succ = -1;
		if ( null == sRoute_Mr_Nw )
		{
			iFlag_succ = -1;
		}
		else
		{
			try {
			FileInputStream fis=new FileInputStream( sFile_Name );
			InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			//简写如下
			//BufferedReader br = new BufferedReader(new InputStreamReader(
			//new FileInputStream("E:/phsftp/evdokey/evdokey_201103221556.txt"), "UTF-8"));
			String line="";
			String[] arrs=null;
			while ((line=br.readLine())!=null) {

				int index = 0;
				index = line.indexOf( "0.0.0.0", index);
				if ( -1 != index )
				{
					int index_1 = 0;
					index_1 = line.indexOf( sRoute_Mr_Nw, index_1);
					if ( -1 != index_1 )
					{
						/* 写删除路由的脚本  */
						iFlag_succ = writebat_DelMrRouteYj( sRoute_Mr_Nw ) ;
					}
				}
			}
			br.close();
			isr.close();
			fis.close();
			
			} catch (IOException e) {  
				e.printStackTrace();  
			}  
		}
		return iFlag_succ;
	}
	
	public int DelYMG_AddXWG(String del_wg, String add_wg)
	{
		int iFlag_Succ = -1;
		//route delete 0.0.0.0 mask 0.0.0.0 10.242.134.254
		String sCmd_del = null;
		String sCmd_add = null;
		sCmd_del = "route -p del 10.0.0.0 mask 255.0.0.0 " + del_wg;
		sCmd_add = "route -p add 10.0.0.0 mask 255.0.0.0 " + add_wg + " metric 1";
		
		FileWriter writer;
		try {
		  writer = new FileWriter("DelYMG_AddXWG.bat");
		  writer.write(sCmd_del);
		  writer.write( "\r\n");
		  writer.write(sCmd_add);
		  writer.flush();
		  writer.close();
		} catch (IOException e) {
		  e.printStackTrace();
		  iFlag_Succ = -1;
		}
		iFlag_Succ = 0;
		
		String strcmd = "DelYMG_AddXWG.bat";
		CMD_DO strcmd3 = new CMD_DO(strcmd);

		return iFlag_Succ;
	}
}
