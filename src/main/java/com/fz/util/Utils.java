/**
 * 
 */
package com.fz.util;

//import java.util.HashMap;
import java.io.PrintWriter;
import java.util.Locale;
//import java.util.Map;
import java.util.ResourceBundle;

import org.apache.struts2.ServletActionContext;

/**
 * 工具类
 * @author fansy
 * @date 2015-6-8
 */
public class Utils {

	// hadoop 常量
//	private static Map<String,String> HADOOPCONSTANTS=new HashMap<String,String>();
	private static ResourceBundle resb = null;
	private static PrintWriter  writer=null;
	
	public static String  getKey(String key){
		if(resb==null){
			Locale locale = new Locale("zh", "CN"); 
            resb = ResourceBundle.getBundle("util", locale); 
		}
        return resb.getString(key);
	}
	
	public static void write2PrintWriter(String info){
		try{
			writer= ServletActionContext.getResponse().getWriter();
			writer.write(info);//响应输出
			//释放资源，关闭流
			writer.flush();
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
}
