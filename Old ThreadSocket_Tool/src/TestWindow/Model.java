package TestWindow;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Model {

    private String Ysj;          /* 原数据 */
    private String Ysj_Tmp;      /* 原数据临时 */
    private String Msj;          /* 转换后的数据 */
    private String Yjz;          /* 原进制 */
    private String Mjz;          /* 目标进制 */

    public String getInfo(){
    	/* 此处增加转换的业务逻辑处理 */
    	int iYjz,jMjz;

    	Logger.getGlobal().info("Yjz=" + Yjz );
    	Logger.getGlobal().info("Mjz=" + Mjz);
    	
    	iYjz = iGetjz(Yjz);
    	jMjz = iGetjz(Mjz);
    	
    	Logger.getGlobal().info("iYjz=" + iYjz);
    	Logger.getGlobal().info("jMjz=" + jMjz);
    	
    	if ( 0 == iYjz || 0 == jMjz )
    	{
    		/* 异常 */
    		Logger.getGlobal().info( "0 == iYjz || 0 == jMjz,异常" );
    		return null;
    	}
    	
    	//System.out.println(iYjz);
    	//System.out.println(jMjz);
    	Logger.getGlobal().info( "iYjz=" + iYjz );
    	Logger.getGlobal().info( "jMjz=" + jMjz );
    	
    	if ( iYjz == jMjz )
    	{
    		//源进制与目标进制相同，则不用转换，直接赋值
    		Msj = Ysj;

    		Logger.getGlobal().info("源进制与目标进制相同，则不用转换");
    	}
    	else
    	{
    		try {
	    		if ( -1 == iYjz )
	    		{
	    			//字符转换成10进制
	    			Logger.getGlobal().info("字符转换成10进制");
	    			char cChar_Tmp = Ysj.charAt(0);
	    			int  iInt_Tmp = cChar_Tmp;
	    			Ysj_Tmp = String.valueOf( iInt_Tmp );
	    		}
	    		else if ( 2 == iYjz )
		    	{
		    		//2进制转换成10进制
	    			Logger.getGlobal().info("2进制转换成10进制");
		    		Ysj_Tmp = Integer.valueOf( Ysj,2).toString();
		    	}
		    	else if ( 10 == iYjz )
		    	{
		    		//10进制不用转换
		    		Logger.getGlobal().info("10进制不用转换");
		    		Ysj_Tmp = Ysj;
		    	}
		    	else if ( 8 == iYjz )
		    	{
		    		//8进制转换成10进制
		    		Logger.getGlobal().info("8进制转换成10进制");
		    		Ysj_Tmp = Integer.valueOf( Ysj,8).toString();
		    	}
		    	else if ( 16 == iYjz )
		    	{
		    		//16进制转换成10进制
		    		Logger.getGlobal().info("16进制转换成10进制");
		    		Ysj_Tmp = Integer.valueOf( Ysj,16).toString();
		    	}
	
		    	/* 原数据 均 转换成 10进制的 ，再转成目标进制的数据 */
	    		if ( -1 == jMjz )
	    		{
	    			char cChar_Tmp = (char)Integer.parseInt(Ysj_Tmp);
	    			Msj = String.valueOf(cChar_Tmp);
	    		}
	    		else if ( 2 == jMjz )
				{
					Msj = Integer.toBinaryString( Integer.parseInt(Ysj_Tmp) );
				}
				else if ( 10 == jMjz )
				{
					//10 进制不用转换
					Msj = Ysj_Tmp;
				}
				else if ( 8 == jMjz )
				{
					Msj = Integer.toOctalString( Integer.parseInt(Ysj_Tmp) );
				}
				else if ( 16 == jMjz )
				{
					Msj = Integer.toHexString( Integer.parseInt(Ysj_Tmp) );
				}
    		}
    		catch (Exception e){
    			//在控制终端
    			e.printStackTrace();
    			
    			//字符串赋值
    			Msj = "异常，不能处理！";
    			
    			//做一个弹出对话框

    		}
    	}
    	Logger.getGlobal().info( Msj );
    	return Msj;
    }

    public void setInfo(String message){
        this.Ysj = message;
    }

    public void setYjz(String message){
        this.Yjz = message;
    }

    public void setMjz(String message){
        this.Mjz = message;
    }

    private int iGetjz(String str){
    	Logger.getGlobal().info("-----iGetjz---start-----");
    	
    	int num = 0;
    	if ( 0 == str.compareTo("字符") )
    	{
    		Logger.getGlobal().info("字符");
    		num = -1;
    	}
    	else if ( 0 == str.compareTo("2进制") )
    	{
    		Logger.getGlobal().info("2进制");
    		num = 2;
    	}
    	else if ( 0 == str.compareTo("8进制") )
    	{
    		Logger.getGlobal().info("8进制");
    		num = 8;
    	}
    	else if ( 0 == str.compareTo("10进制") )
    	{
    		Logger.getGlobal().info("10进制");
    		num = 10;
    	}
    	else if ( 0 == str.compareTo("16进制") )
    	{
    		Logger.getGlobal().info("16进制");
    		num = 16;
    	}
    	else
    	{
    		Logger.getGlobal().info("异常");
    		num = 0;
    	}

    	Logger.getGlobal().info("-----iGetjz---end-----");
    	return num;
    }
}

