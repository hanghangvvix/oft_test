package ct.oft.util;

import java.io.File;

public class IPARAM {
	
	public static String INVEST_ORDER_FILE_PATH = DataUtil.getProperty("INVEST_ORDER_FILE_PATH");
	
	static {
		File file = new File(INVEST_ORDER_FILE_PATH);
		// 上级目录不存在时生成
		if (!file.exists()) {
			file.mkdirs();
		}
	}
	
	// 字符编码格式 支持 gbk 或 utf-8
	public static String CHARSET = "UTF-8";
	// 签名方式
	public static String SIGN_TYPE = "MD5";
	
	// 
//	public static String INVEST_ORDER_FILE_PATH = DataUtil.getProperty("INVEST_ORDER_FILE_PATH");
	public static String INVEST_ORDER_FILE_TYPE = DataUtil.getProperty("INVEST_ORDER_FILE_TYPE");
	
	
}
