package MessageHeader;

/*
3.2 报文头的基本组成
表1 报文头的组成
域                  域名                                           长度（单位：Byte）
Field1              头长度（Header Length）                        1
Field2              头标识和版本号（Header Flag and Version）      1
Field3              整个报文长度（Total Message Length）           4
Field4              目的 ID（Destination ID）                      11
Field5              源 ID（Source ID）                             11
Field6              保留使用（Reserved for Use）                   3
Field7              批次号（Batch Number）                         1
Field8              交易信息（Transaction Information）            8
Field9              用户信息（User Information）                   1
Field10             拒绝码（Reject Code）                          5
共占46个字节。所有域都为必填域。
 */
public class MessageHeader {
	private  String  sMessageHeaderField1 ;        /* 头长度（Header Length）                        1  */
	private  String  sMessageHeaderField2 ;        /* 头标识和版本号（Header Flag and Version）      1  */
	private  String  sMessageHeaderField3 ;        /* 整个报文长度（Total Message Length）           4  */
	private  String  sMessageHeaderField4 ;        /* 目的 ID（Destination ID）                      11 */
	private  String  sMessageHeaderField5 ;        /* 源 ID（Source ID）                             11 */
	private  String  sMessageHeaderField6 ;        /* 保留使用（Reserved for Use）                   3  */
	private  String  sMessageHeaderField7 ;        /* 批次号（Batch Number）                         1  */
	private  String  sMessageHeaderField8 ;        /* 交易信息（Transaction Information）            8  */
	private  String  sMessageHeaderField9 ;        /* 用户信息（User Information）                   1  */
	private  String  sMessageHeaderField10;        /* 拒绝码（Reject Code）                          5  */

	private  int  iSetFlag_MessageHeaderField1 ;   /* 某域是否已经填值 */
	private  int  iSetFlag_MessageHeaderField2 ;   /* 某域是否已经填值 */
	private  int  iSetFlag_MessageHeaderField3 ;   /* 某域是否已经填值 */
	private  int  iSetFlag_MessageHeaderField4 ;   /* 某域是否已经填值 */
	private  int  iSetFlag_MessageHeaderField5 ;   /* 某域是否已经填值 */
	private  int  iSetFlag_MessageHeaderField6 ;   /* 某域是否已经填值 */
	private  int  iSetFlag_MessageHeaderField7 ;   /* 某域是否已经填值 */
	private  int  iSetFlag_MessageHeaderField8 ;   /* 某域是否已经填值 */
	private  int  iSetFlag_MessageHeaderField9 ;   /* 某域是否已经填值 */
	private  int  iSetFlag_MessageHeaderField10;   /* 某域是否已经填值 */

	private  String sMessageHeader;

	/*
	 * 无参构造函数
	 */
	public MessageHeader()
	{
		this.sMessageHeaderField1  = null;
		this.sMessageHeaderField2  = null;
		this.sMessageHeaderField3  = null;
		this.sMessageHeaderField4  = null;
		this.sMessageHeaderField5  = null;
		this.sMessageHeaderField6  = null;
		this.sMessageHeaderField7  = null;
		this.sMessageHeaderField8  = null;
		this.sMessageHeaderField9  = null;
		this.sMessageHeaderField10 = null;
		
		this.iSetFlag_MessageHeaderField1 = 0;
		this.iSetFlag_MessageHeaderField2 = 0;
		this.iSetFlag_MessageHeaderField3 = 0;
		this.iSetFlag_MessageHeaderField4 = 0;
		this.iSetFlag_MessageHeaderField5 = 0;
		this.iSetFlag_MessageHeaderField6 = 0;
		this.iSetFlag_MessageHeaderField7 = 0;
		this.iSetFlag_MessageHeaderField8 = 0;
		this.iSetFlag_MessageHeaderField9 = 0;
		this.iSetFlag_MessageHeaderField10= 0;
		
		this.sMessageHeader = null;
	}
	
	/*
	 * MessageHeader构造函数：
	 * 入参：String sMsg     整个报文字符串
	 * 
	 */
	public MessageHeader(String sMsg)
	{
		this();

		this.sMessageHeaderField1  = sMsg.substring( 0,  1 );    /* 头长度（Header Length）                        1  */
		this.sMessageHeaderField2  = sMsg.substring( 1,  2 );    /* 头标识和版本号（Header Flag and Version）      1  */
		this.sMessageHeaderField3  = sMsg.substring( 2,  6 );    /* 整个报文长度（Total Message Length）           4  */
		this.sMessageHeaderField4  = sMsg.substring( 6,  17);    /* 目的 ID（Destination ID）                      11 */
		this.sMessageHeaderField5  = sMsg.substring( 17, 28);    /* 源 ID（Source ID）                             11 */
		this.sMessageHeaderField6  = sMsg.substring( 28, 31);    /* 保留使用（Reserved for Use）                   3  */
		this.sMessageHeaderField7  = sMsg.substring( 31, 32);    /* 批次号（Batch Number）                         1  */
		this.sMessageHeaderField8  = sMsg.substring( 32, 40);    /* 交易信息（Transaction Information）            8  */
		this.sMessageHeaderField9  = sMsg.substring( 40, 41);    /* 用户信息（User Information）                   1  */
		this.sMessageHeaderField10 = sMsg.substring( 41, 46);    /* 拒绝码（Reject Code）                          5  */

		/* 将设置标志设置为： 1-已设置 */
		this.iSetFlag_MessageHeaderField1 = 1;
		this.iSetFlag_MessageHeaderField2 = 1;
		this.iSetFlag_MessageHeaderField3 = 1;
		this.iSetFlag_MessageHeaderField4 = 1;
		this.iSetFlag_MessageHeaderField5 = 1;
		this.iSetFlag_MessageHeaderField6 = 1;
		this.iSetFlag_MessageHeaderField7 = 1;
		this.iSetFlag_MessageHeaderField8 = 1;
		this.iSetFlag_MessageHeaderField9 = 1;
		this.iSetFlag_MessageHeaderField10= 1;
	}

	/*
	 * checkSetFlagMessageHeader
	 * 检查报文头是否设置完全了
	 * 返回 1 设置完全
	 * 返回 0 设置不完全
	 */
	public int checkSetFlagMessageHeader()
	{
		int  iSetFlag_MessageHreader = 0;
		if ( 
			this.iSetFlag_MessageHeaderField1  == 1 && 
			this.iSetFlag_MessageHeaderField2  == 1 && 
			this.iSetFlag_MessageHeaderField3  == 1 && 
			this.iSetFlag_MessageHeaderField4  == 1 && 
			this.iSetFlag_MessageHeaderField5  == 1 && 
			this.iSetFlag_MessageHeaderField6  == 1 && 
			this.iSetFlag_MessageHeaderField7  == 1 && 
			this.iSetFlag_MessageHeaderField8  == 1 && 
			this.iSetFlag_MessageHeaderField9  == 1 && 
			this.iSetFlag_MessageHeaderField10 == 1 )
		{
			iSetFlag_MessageHreader = 1;
		}
		else
		{
			iSetFlag_MessageHreader = 0;
		}

		return iSetFlag_MessageHreader;
	}

	/*
	 * getMessageHeader
	 * 获取报文头
	 * 返回 null   报文头没有设置完等原因，导致无法返回
	 * 返回 String 报文头
	 */
	public String getMessageHeader()
	{
		String s_MessageHreader = null;
		if ( 1 == checkSetFlagMessageHeader() )
		{
			s_MessageHreader = this.sMessageHeader;
		}
		else
		{
			s_MessageHreader = null;
		}

		return s_MessageHreader;
	}

	/*
	 * setMessageHeader
	 * 设置报文头
	 * 返回 null   报文头没有设置完等原因，导致无法返回
	 * 返回 String 报文头
	 */
	public String setMessageHeader()
	{
		StringBuilder sBuild_MessageHreader = new StringBuilder();
		if ( 1 == checkSetFlagMessageHeader() )
		{
			sBuild_MessageHreader.append(this.sMessageHeaderField1 );
			sBuild_MessageHreader.append(this.sMessageHeaderField2 );
			sBuild_MessageHreader.append(this.sMessageHeaderField3 );
			sBuild_MessageHreader.append(this.sMessageHeaderField4 );
			sBuild_MessageHreader.append(this.sMessageHeaderField5 );
			sBuild_MessageHreader.append(this.sMessageHeaderField6 );
			sBuild_MessageHreader.append(this.sMessageHeaderField7 );
			sBuild_MessageHreader.append(this.sMessageHeaderField8 );
			sBuild_MessageHreader.append(this.sMessageHeaderField9 );
			sBuild_MessageHreader.append(this.sMessageHeaderField10);

			this.sMessageHeader = sBuild_MessageHreader.toString();
		}
		else
		{
			sBuild_MessageHreader = null;
		}

		return this.sMessageHeader;
	}

	/*
	 * checkMessageHeaderField
	 * 检查报文头的域是否合法
	 * 入参：sMessageHeaderFiled  域的内容
	 *       sMethodName          调用函数的名字
	 * 返回 null   不合法
	 * 返回 String 合法的报文域内容
	 */
	private String checkMessageHeaderField(String sMessageHeaderFiled,String sMethodName){
		String   ret_Str = null;
		boolean  ret_boolean = false;
		int iNum_Field = Integer.valueOf( sMessageHeaderFiled.substring(21), 2);
		if ( iNum_Field == 1 ) { 
			/* 头长度（Header Length）                        1  */
			if ( sMessageHeaderFiled.length() > 1 || sMessageHeaderFiled.length() < 0 ){
				ret_boolean = false;
			}
		}
		else if ( iNum_Field == 2 ) {
			/* 头标识和版本号（Header Flag and Version）      1  */
			if ( sMessageHeaderFiled.length() > 1 || sMessageHeaderFiled.length() < 0 ){
				ret_boolean = false;
			}
		}
		else if ( iNum_Field == 3 ) {
			/* 整个报文长度（Total Message Length）           4  */
			if ( sMessageHeaderFiled.length() > 4 || sMessageHeaderFiled.length() < 0 ){
				ret_boolean = false;
			}
		}
		else if ( iNum_Field == 4 ) {
			/* 目的 ID（Destination ID）                      11 */
			if ( sMessageHeaderFiled.length() > 11 || sMessageHeaderFiled.length() < 0 ){
				ret_boolean = false;
			}
		}
		else if ( iNum_Field == 5 ) {
			/* 源 ID（Source ID）                             11 */
			if ( sMessageHeaderFiled.length() > 11 || sMessageHeaderFiled.length() < 0 ){
				ret_boolean = false;
			}
		}
		else if ( iNum_Field == 6 ) {
			/* 保留使用（Reserved for Use）                   3  */
			if ( sMessageHeaderFiled.length() > 3 || sMessageHeaderFiled.length() < 0 ){
				ret_boolean = false;
			}
		}
		else if ( iNum_Field == 7 ) {
			/* 批次号（Batch Number）                         1  */
			if ( sMessageHeaderFiled.length() > 3 || sMessageHeaderFiled.length() < 0 ){
				ret_boolean = false;
			}
		}
		else if ( iNum_Field == 8 ) {
			/* 交易信息（Transaction Information）            8  */
			if ( sMessageHeaderFiled.length() > 8 || sMessageHeaderFiled.length() < 0 ){
				ret_boolean = false;
			}
		}
		else if ( iNum_Field == 9 ) {
			/* 用户信息（User Information）                   1  */
			if ( sMessageHeaderFiled.length() > 1 || sMessageHeaderFiled.length() < 0 ){
				ret_boolean = false;
			}
		}
		else if ( iNum_Field == 10) {
			/* 拒绝码（Reject Code）                          5  */
			if ( sMessageHeaderFiled.length() > 5 || sMessageHeaderFiled.length() < 0 ){
				ret_boolean = false;
			}
		}
		else {
			ret_boolean = false; 
		}

		if ( false == ret_boolean )
		{
			ret_Str = null;
		}
		else 
		{
			ret_Str = sMessageHeaderFiled;
		}

		return ret_Str;
	}

	/*
	 * get set的方法
	 */
	public String getsMessageHeaderField1() {
		return checkMessageHeaderField( sMessageHeaderField1, Thread.currentThread().getStackTrace()[2].getMethodName() );
	}
	public void setsMessageHeaderField1(String sMessageHeaderField1) {
		this.sMessageHeaderField1 = sMessageHeaderField1;
		this.iSetFlag_MessageHeaderField1 = 1;
	}
	public String getsMessageHeaderField2() {
		return checkMessageHeaderField( sMessageHeaderField2, Thread.currentThread().getStackTrace()[2].getMethodName() );
	}
	public void setsMessageHeaderField2(String sMessageHeaderField2) {
		this.sMessageHeaderField2 = sMessageHeaderField2;
		this.iSetFlag_MessageHeaderField2 = 1;
	}
	public String getsMessageHeaderField3() {
		return checkMessageHeaderField( sMessageHeaderField3, Thread.currentThread().getStackTrace()[2].getMethodName() );
	}
	public void setsMessageHeaderField3(String sMessageHeaderField3) {
		this.sMessageHeaderField3 = sMessageHeaderField3;
		this.iSetFlag_MessageHeaderField3 = 1;
	}
	public String getsMessageHeaderField4() {
		return checkMessageHeaderField( sMessageHeaderField4, Thread.currentThread().getStackTrace()[2].getMethodName() );
	}
	public void setsMessageHeaderField4(String sMessageHeaderField4) {
		this.sMessageHeaderField4 = sMessageHeaderField4;
		this.iSetFlag_MessageHeaderField4 = 1;
	}
	public String getsMessageHeaderField5() {
		return checkMessageHeaderField( sMessageHeaderField5, Thread.currentThread().getStackTrace()[2].getMethodName() );
	}
	public void setsMessageHeaderField5(String sMessageHeaderField5) {
		this.sMessageHeaderField5 = sMessageHeaderField5;
		this.iSetFlag_MessageHeaderField5 = 1;
	}
	public String getsMessageHeaderField6() {
		return checkMessageHeaderField( sMessageHeaderField6, Thread.currentThread().getStackTrace()[2].getMethodName() );
	}
	public void setsMessageHeaderField6(String sMessageHeaderField6) {
		this.sMessageHeaderField6 = sMessageHeaderField6;
		this.iSetFlag_MessageHeaderField6 = 1;
	}
	public String getsMessageHeaderField7() {
		return checkMessageHeaderField( sMessageHeaderField7, Thread.currentThread().getStackTrace()[2].getMethodName() );
	}
	public void setsMessageHeaderField7(String sMessageHeaderField7) {
		this.sMessageHeaderField7 = sMessageHeaderField7;
		this.iSetFlag_MessageHeaderField7 = 1;
	}
	public String getsMessageHeaderField8() {
		return checkMessageHeaderField( sMessageHeaderField8, Thread.currentThread().getStackTrace()[2].getMethodName() );
	}
	public void setsMessageHeaderField8(String sMessageHeaderField8) {
		this.sMessageHeaderField8 = sMessageHeaderField8;
		this.iSetFlag_MessageHeaderField8 = 1;
	}
	public String getsMessageHeaderField9() {
		return checkMessageHeaderField( sMessageHeaderField9, Thread.currentThread().getStackTrace()[2].getMethodName() );
	}
	public void setsMessageHeaderField9(String sMessageHeaderField9) {
		this.sMessageHeaderField9 = sMessageHeaderField9;
		this.iSetFlag_MessageHeaderField9 = 1;
	}
	public String getsMessageHeaderField10() {
		return checkMessageHeaderField( sMessageHeaderField10, Thread.currentThread().getStackTrace()[2].getMethodName() );
	}
	public void setsMessageHeaderField10(String sMessageHeaderField10) {
		this.sMessageHeaderField10 = sMessageHeaderField10;
		this.iSetFlag_MessageHeaderField10 = 1;
	}
	
	public static void  main(String[] args) //only unit test
	{
		String str1 = 
				"2e 02 30 33 38 33 30 34 30 31 30 30 30 30 20 20 " +
				"20 30 30 30 31 30 30 30 30 20 20 20 00 00 00 00 " +
				"30 30 30 30 30 30 30 30 00 30 30 30 30 30 30 32 " +
				"30 30 f2 3a 46 81 ac e0 80 10 00 00 00 00 10 00 " +
				"00 81 31 38 36 32 30 35 32 32 30 30 31 30 31 31 " +
				"39 35 35 37 31 35 30 30 30 30 30 30 30 30 30 30 " +
				"30 30 30 31 30 30 30 30 30 36 31 33 31 39 33 35 " +
				"33 37 30 30 37 33 31 34 31 39 33 35 33 37 30 36 " +
				"31 33 30 36 31 33 37 30 31 31 30 35 32 30 30 30 " +
				"30 36 30 38 39 32 30 31 30 30 30 30 30 38 39 32 " +
				"30 31 30 30 30 30 33 37 36 32 30 35 32 32 30 30 " +
				"31 30 31 31 39 35 35 37 31 35 3d 31 35 36 32 30 " +
				"30 37 31 34 36 30 30 30 30 30 30 30 31 30 30 30 " +
				"30 30 30 30 30 30 30 35 33 30 37 37 39 30 34 31 " +
				"32 33 34 35 36 37 38 31 32 33 34 35 36 37 38 39 " +
				"30 31 32 33 34 35 d6 d0 b9 fa d2 f8 c1 aa 43 48 " +
				"49 4e 41 20 55 4e 49 4f 4e 50 41 59 20 53 49 4d " +
				"55 4c 41 54 4f 52 20 20 20 20 20 20 20 20 31 35 " +
				"36 30 32 37 30 30 30 30 30 36 30 30 30 33 30 30 " +
				"30 30 30 30 30 30 30 30 34 30 31 32 30 30 30 30 " +
				"38 30 34 30 31 30 30 30 30 30 34 33 35 31 43 53 " +
				"32 32 30 30 30 30 30 34 35 30 33 31 30 30 30 30 " +
				"30 20 20 20 30 30 30 30 30 30 30 30 30 30 30 30 " +
				"30 30 30 30 30 30 30 31 30 35 30 31 45 36 35";

		System.out.print(str1);

	}
	
}
