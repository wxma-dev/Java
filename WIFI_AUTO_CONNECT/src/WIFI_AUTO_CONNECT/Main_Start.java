package WIFI_AUTO_CONNECT;


public class Main_Start extends Thread {
	private String sRoute_Mr_Nw_Tmp = null;

	private String sName_Interface_Ww ;
	private String sName_Interface_Nw ;
	private String sName_Wifi_Ww      ;
	private String sName_Wifi_Nw      ;

	private int    iFlag_NwStatus_Last;    /*上一此内网的连接状态, 1-上一次内网是连接的，0-上一次内网是没有连接的  */
	private int    iFlag_WwStatus_Last;    /*上一此外网的连接状态 ，1-上一次外网是连接的，0-上一次外网是没有连接的 */
	
	public Main_Start()
	{
		/* 变量初始化 */
		sRoute_Mr_Nw_Tmp = null;
		
		sName_Interface_Ww  = null;
		sName_Interface_Nw  = null;
		sName_Wifi_Ww       = null;
		sName_Wifi_Nw       = null;
		
		iFlag_NwStatus_Last = 0;
		iFlag_WwStatus_Last = 0;
	}
	
	/*
	 * 程序暂停，现设定暂停5秒
	 * 设定秒数，要根据用户体验
	 */
	private void Pause()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 删除对应接口的默认网关
	 * 函数的内部实现：
	 * 		判断有无默认路由，则有删除，无则不做任何动作
	 * sStr_Interface 接口名
	 */
	private void del_Mrgw(String sStr_Interface )
	{
		/*
		 *  删除内网路由
		 *  若0.0.0.0的默认路由为内网的话，则内外网不友好了
		 */
		IPCONFIG_INFO ipcon = new IPCONFIG_INFO();
		String sMrgw = ipcon.Get_Mrgw( sStr_Interface );
		//route delete 0.0.0.0 mask 0.0.0.0 10.242.134.254
		//route add -p 10.0.0.0 mask 255.0.0.0 10.242.134.254 METRIC 1
		//route delete -p 10.0.0.0 mask 255.0.0.0

		System.out.println("操作：准备删除内网默认的无用的路由[" + sMrgw + "]");

		if ( null == sMrgw || 0 == sMrgw.length() )
		{
			/* do nothing  */
			System.out.println("操作：删除内网默认路由为"+ "空" + "不需要删除");
		}
		else
		{
			String cmd2 = "route delete 0.0.0.0 mask 0.0.0.0 " + sMrgw;
			CMD_DO_TOFILE.Do_Bat_ByStr( cmd2, null );
			System.out.println("操作：删除内网默认路由"+ sMrgw + "成功");
		}

		//Thread.sleep(5000);
		System.out.println("操作========================================OPERATE");
		System.out.print("\n\n\n\n");
	}

	public void run()
	{
		while ( true )
		{
			try{
				WLAN_INTERFACES_INFO_STATUS a = new WLAN_INTERFACES_INFO_STATUS();
				int iStatus_Net = a.get_wifinetwork_status();
				
				WLAN_NETWORKS_INFO_STATUS b = new WLAN_NETWORKS_INFO_STATUS();
				int iFlag_Ww = 0;
				iFlag_Ww = b.get_checknetwork_status_Ww();
				
				int iFlag_Nw = 0;
				iFlag_Nw = b.get_checknetwork_status_Nw();

				CONFIG cfg1 = new CONFIG();
				sName_Interface_Ww = cfg1.Get_WwInterfaceName_ByConf();
				sName_Interface_Nw = cfg1.Get_NwInterfaceName_ByConf();
				sName_Wifi_Ww      = cfg1.Get_WwWifiName_ByConf();
				sName_Wifi_Nw      = cfg1.Get_NwWifiName_ByConf();

				//内外网  0, 检查：指定的内外网均连接上，无需处理
				if ( 0 == iStatus_Net )
				{
					/*
					 * 此分支中，可以做相关的内网关的ip映射的、路由删除的事情
					 * 总之就是内外网都连接上的冲突处理，或者特殊的业务需要场景的处理
					 */
					
					System.out.println("检查：指定的内外网均连接上，无需处理");
					/* 无需侦测 */

					del_Mrgw( sName_Interface_Nw );
					
					/* 下次循环前标注本次网络状态 */
					iFlag_NwStatus_Last = 1;
					iFlag_WwStatus_Last = 1;
				}
				//内网     1,只连接上了内网
				else if ( 1 == iStatus_Net )
				{
					System.out.println("检查：只连接上了内网");
					
					if ( 0 == iFlag_Ww ) //没有指定的外网wifi可以连接
					{
						System.out.println("操作：没有指定的外网wifi可以连接");
						
						/*
						 * 现在内网的状态是连接的，但是没有指定的外网可以连接，而上一次外网的状态是连接着的
						 * 这种情况：
						 * 	为了保证 被删除的内网的默认路由可以恢复，现要断开内网
						 * 	在下次的循环中，重新开始。如果下次只有内网的wifi，就能连接上内网，而且不删除路由
						 */
						if ( 1 == iFlag_WwStatus_Last )
						{
							System.out.println("操作：断开连接所有连接");
							/* 断开连接所有连接后，在下一次的循环中就会进入内外网状态都没有连接的分支中，进行重新连接  */
							CMD_DO_TOFILE.Do_Bat_ByStr( "netsh wlan disconnect interface=" + "\"" +
									sName_Interface_Ww + "\"", null);
							CMD_DO_TOFILE.Do_Bat_ByStr( "netsh wlan disconnect interface=" + "\"" +
									sName_Interface_Nw + "\"", null);
							
							/* 下次循环前标注本次网络状态 */
							iFlag_NwStatus_Last = 0;
							iFlag_WwStatus_Last = 0;
						}
						else
						{
							/* 下次循环前标注本次网络状态 */
							iFlag_NwStatus_Last = 1;
							iFlag_WwStatus_Last = 0;
						}
						
					}
					else if (1 == iFlag_Ww )  //有指定的外网wifi可以连接
					{
/////////////////////////////////////////////////////////////////////////////////////////////
//						{//此分支废弃，原因：为了不出现什么异常的情况，不连接指定的外围，就直接断开所有网络，下次循环再处理
//						System.out.println("检查：有指定的外网wifi可以连接，准备连接");
//						
//						System.out.println("操作：连接外网");
//						/* 连接外网  */
//						CMD_DO_TOFILE.Do_Bat_ByStr( "netsh wlan connect interface=" + "\"" +
//								sName_Interface_Ww + "\"" +
//								" ssid=" + "\"" +
//								sName_Wifi_Ww + "\"" +
//								" name=" + "\"" +
//								sName_Wifi_Ww + "\"", null);
//						
//						del_Mrgw( sName_Interface_Nw );
//						
//						/* 下次循环前标注本次网络状态 */
//						iFlag_NwStatus_Last = 1;
//						iFlag_WwStatus_Last = 1;
//						}
/////////////////////////////////////////////////////////////////////////////////////////////
						
						System.out.println("操作：断开连接所有连接");
						/* 断开连接所有连接后，在下一次的循环中就会进入内外网状态都没有连接的分支中，进行重新连接  */
						CMD_DO_TOFILE.Do_Bat_ByStr( "netsh wlan disconnect interface=" + "\"" +
								sName_Interface_Ww + "\"", null);
						CMD_DO_TOFILE.Do_Bat_ByStr( "netsh wlan disconnect interface=" + "\"" +
								sName_Interface_Nw + "\"", null);
						
						/* 下次循环前标注本次网络状态 */
						iFlag_NwStatus_Last = 0;
						iFlag_WwStatus_Last = 0;
						
					}
					else
					{
						System.out.println("检查：异常情况");

					}
				}
				//外网     2,只连接上了外网
				else if ( 2 == iStatus_Net )
				{
					System.out.println("检查：只连接上了外网");

					if ( 0 == iFlag_Nw )
					{
						System.out.println("操作：没有指定的内网wifi可以连接");

						/* 下次循环前标注本次网络状态 */
						iFlag_NwStatus_Last = 0;
						iFlag_WwStatus_Last = 1;
					}
					else if ( 1 == iFlag_Nw )
					{
						System.out.println("检查：有指定的内网wifi可以连接，准备连接");
						
						System.out.println("操作：断开连接所有连接");
						/* 断开连接所有连接后，在下一次的循环中就会进入内外网状态都没有连接的分支中，进行重新连接  */
						CMD_DO_TOFILE.Do_Bat_ByStr( "netsh wlan disconnect interface=" + "\"" +
								sName_Interface_Ww + "\"", null);
						CMD_DO_TOFILE.Do_Bat_ByStr( "netsh wlan disconnect interface=" + "\"" +
								sName_Interface_Nw + "\"", null);
						
/////////////////////////////////////////////////////////////////////////////////////////////
//						{//分支废弃
//						System.out.println("操作：连接内网");
//						/* 连接内网 */
//						CMD_DO_TOFILE.Do_Bat_ByStr( "netsh wlan connect interface=" + "\"" +
//								sName_Interface_Nw + "\"" +
//								" ssid=" + "\"" +
//								sName_Wifi_Nw + "\"" +
//								" name=" + "\"" +
//								sName_Wifi_Nw + "\"", null);
//
//						//Thread.sleep(10000);
//						Pause();
//						Pause();
//						
//						System.out.println("操作：连接外网");
//						/* 连接外网  */
//						CMD_DO_TOFILE.Do_Bat_ByStr( "netsh wlan connect interface=" + "\"" +
//								sName_Interface_Ww + "\"" +
//								" ssid=" + "\"" +
//								sName_Wifi_Ww + "\"" +
//								" name=" + "\"" +
//								sName_Wifi_Ww + "\"", null);
//						
//						del_Mrgw( sName_Interface_Nw );
//						
//						/* 下次循环前标注本次网络状态 */
//						iFlag_NwStatus_Last = 1;
//						iFlag_WwStatus_Last = 1;
//						}
/////////////////////////////////////////////////////////////////////////////////////////////
						
						/* 下次循环前标注本次网络状态 */
						iFlag_NwStatus_Last = 0;
						iFlag_WwStatus_Last = 0;

					}
					else
					{
						System.out.println("检查：异常情况");
					}
				}
				//无         3, 指定的内外网均无连接
				else if ( 3 == iStatus_Net )
				{
					/*
					 * 此分支中，主要做相关的网络的连接处理
					 */
					
					System.out.println("检查：指定的内外网均无连接");
					
					if ( 1 == iFlag_Nw )
					{
						System.out.println("检查：有指定的内网可连接");
						
						System.out.println("操作：连接内网");
						/* 连接内网 */
						CMD_DO_TOFILE.Do_Bat_ByStr( "netsh wlan connect interface=" + "\"" +
								sName_Interface_Nw + "\"" +
								" ssid=" + "\"" +
								sName_Wifi_Nw + "\"" +
								" name=" + "\"" +
								sName_Wifi_Nw + "\"", null);
						
						/* 下次循环前标注本次网络状态 */
						iFlag_NwStatus_Last = 1;

					}

					if ( 1 == iFlag_Ww )
					{
						System.out.println("检查：有指定的外网可连接");
						
						System.out.println("操作：连接外网");
						/* 连接外网  */
						CMD_DO_TOFILE.Do_Bat_ByStr( "netsh wlan connect interface=" + "\"" +
								sName_Interface_Ww + "\"" +
								" ssid=" + "\"" +
								sName_Wifi_Ww + "\"" +
								" name=" + "\"" +
								sName_Wifi_Ww + "\"", null);
						
						/* 下次循环前标注本次网络状态 */
						iFlag_WwStatus_Last = 1;
					}
				}

///////////////////////////////////////////////////////////////////////////////////////////////
//              以下的分支是删除默认路由的处理，已经在其他的地方做了处理，此分支删除
//				/* 删路由 */
//				{
//					DELETE_ROUTE doit = new DELETE_ROUTE();
//					if ( null != sRoute_Mr_Nw_Tmp )
//					{
//						/* 发现前后内网默认网关不相同的话 */
//						if ( doit.sRoute_Mr_Nw != null && 
//							0 != sRoute_Mr_Nw_Tmp.compareTo(doit.sRoute_Mr_Nw) )
//						{
//							/* 则删除原有的  */
//							doit.DelYMG_AddXWG(sRoute_Mr_Nw_Tmp,doit.sRoute_Mr_Nw);
//						}
//					}
//					else
//					{
//						sRoute_Mr_Nw_Tmp = doit.sRoute_Mr_Nw;
//					}
//				}
/////////////////////////////////////////////////////////////////////////////////////////////

				//Pause();
				Thread.sleep(5000);
			}
			catch ( InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
			new Main_Start().start();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 * 准备用此方法进行 关闭cmd窗口的时候，进行断开所有网络的的，发现无法实现，达不到预定的效果
	 */
//    @Override  
//    protected void finalize() throws Throwable {  
//        //super.finalize();  
//        
//		CMD_DO_TOFILE.Do_Bat_ByStr( "netsh wlan disconnect interface=" + "\"" +
//				sName_Interface_Ww + "\"", null);
//		CMD_DO_TOFILE.Do_Bat_ByStr( "netsh wlan disconnect interface=" + "\"" +
//				sName_Interface_Nw + "\"", null);
//        
//    }  
    
}
