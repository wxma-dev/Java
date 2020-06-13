package WIFI_AUTO_CONNECT;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class CONFIG {
    private String sFile_Config = null;
    private Struct_Conf[] St_cfg;
    
    public CONFIG()
    {
    	/* 启动的初始化配置文件 */
        sFile_Config = "etc/init.xml";

        St_cfg  = new Struct_Conf[100];

        Init_Conf();
    }
    
    /*
     * 获取外网配置的WIFI
     */
    public String Get_WwWifiName_ByConf()
    {
    	String SName = null;
    	int i = 0;
    	for( i = 0; i < Get_StructSize_Cfg(); i++)
    	{
    		if ( 0 == St_cfg[i].sFlag_Nw_Ww.compareTo("WW") )
    		{
    			SName = St_cfg[i].sSsid;
    		}
    	}
    	
    	return SName;
    }
    
    /*
     * 获取内网配置的WIFI
     */
    public String Get_NwWifiName_ByConf()
    {
    	String SName = null;
    	int i = 0;
    	for( i = 0; i < Get_StructSize_Cfg(); i++)
    	{
    		if ( 0 == St_cfg[i].sFlag_Nw_Ww.compareTo("NW") )
    		{
    			SName = St_cfg[i].sSsid;
    		}
    	}
    	
    	return SName;
    }
    
    /*
     * 获取外网接口名
     */
    public String Get_WwInterfaceName_ByConf()
    {
    	String SName = null;
    	int i = 0;
    	for( i = 0; i < Get_StructSize_Cfg(); i++)
    	{
    		if ( 0 == St_cfg[i].sFlag_Nw_Ww.compareTo("WW") )
    		{
    			SName = St_cfg[i].sInterface;
    		}
    	}
    	
    	return SName;
    }
    
    /*
     * 获取内网接口名
     */
    public String Get_NwInterfaceName_ByConf()
    {
    	String SName = null;
    	int i = 0;
    	for( i = 0; i < Get_StructSize_Cfg(); i++)
    	{
    		if ( 0 == St_cfg[i].sFlag_Nw_Ww.compareTo("NW") )
    		{
    			SName = St_cfg[i].sInterface;
    		}
    	}
    	
    	return SName;
    }
    
    /*
     * 获取配置节点的首地址
     */
    public Struct_Conf[] Get_Addr_Struct_Conf()
    {
    	return St_cfg;
    }
    
    /*
     * 获取配置的节点的个数
     */
    public int Get_StructSize_Cfg()
    {
		int i = 0;
		int iGs = 0;
		for( i = 0; i < St_cfg.length; i++)
		{
			if( St_cfg[i] != null )
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
 
    private void Init_Conf(){
        //创建一个DocumentBuilderFactory的对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //创建一个DocumentBuilder的对象
        try {
            //创建DocumentBuilder对象
            DocumentBuilder db = dbf.newDocumentBuilder();
            //通过DocumentBuilder对象的parser方法加载books.xml文件到当前项目下
            Document document = db.parse( sFile_Config );
            //获取所有book节点的集合
            NodeList bookList = document.getElementsByTagName("net");
            //通过nodelist的getLength()方法可以获取bookList的长度
            
            /* del by mawx@20180713
            System.out.println("一共有" + bookList.getLength() + "本书");
            */
            System.out.println("一共有" + bookList.getLength() + "个节点配置。");
            
            //遍历每一个book节点
            for (int i = 0; i < bookList.getLength(); i++) {
            	/* del by mawx@20180713
                System.out.println("下面开始遍历第" + (i + 1) + "节点的内容=================");
                */
            	System.out.println("第" + (i + 1) + "节点配置的内容=================START");
            	
                //通过 item(i)方法 获取一个book节点，nodelist的索引值从0开始
                Node book = bookList.item(i);
                //获取book节点的所有属性集合
                NamedNodeMap attrs = book.getAttributes();
                System.out.println("第 " + (i + 1) + "个节点共有" + attrs.getLength() + "个属性");
                //遍历book的属性
                for (int j = 0; j < attrs.getLength(); j++) {
                    //通过item(index)方法获取book节点的某一个属性
                    Node attr = attrs.item(j);
                    //获取属性名
                    System.out.print("属性名：" + attr.getNodeName());
                    //获取属性值
                    System.out.println("--属性值" + attr.getNodeValue());
                }
                //解析book节点的子节点
                NodeList childNodes = book.getChildNodes();
                //遍历childNodes获取每个节点的节点名和节点值
                System.out.println("第" + (i+1) + "个节点共有" + 
                childNodes.getLength() + "个子节点");
                
                St_cfg[i] =  new Struct_Conf();
                
                for (int k = 0; k < childNodes.getLength(); k++) {
                    //区分出text类型的node以及element类型的node
                    if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
                    /*
                        //获取了element类型节点的节点名
                        System.out.print("第" + (k + 1) + "个节点的节点名："  + childNodes.item(k).getNodeName());
                        //获取了element类型节点的节点值
                        System.out.println("--节点值是：" + childNodes.item(k).getFirstChild().getNodeValue());
                        //System.out.println("--节点值是：" + childNodes.item(k).getTextContent());
                    */
                    	String s1 = childNodes.item(k).getNodeName();
                    	String s2 = childNodes.item(k).getFirstChild().getNodeValue();

                        //配置结构赋值
                    	Struct_Conf.Set_Struct_Conf(St_cfg[i],s1,s2);
                    }
                }
                System.out.println("内网外标志:" + St_cfg[i].sFlag_Nw_Ww);
                System.out.println("接口名称    :" + St_cfg[i].sInterface);
                System.out.println("SSID名称   :" + St_cfg[i].sSsid);
                System.out.println("第" + (i + 1) + "个节点配置的内容=================END");
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/*
    public static void main(String[] args) {
    	CONFIG cfg1 = new CONFIG();
    	System.out.println(cfg1.Get_StructSize_Cfg());
    }
*/
}
