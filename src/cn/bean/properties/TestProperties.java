package cn.bean.properties;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.junit.Test;

/** 关于properties类常用的操作
 * @author 陈少坚
 * 
 */
public class TestProperties {
    /** 根据key值读取配置文件的值value
     * @param filepath
     * @param key
     * @return
     */
    public String getValueByKey(String filepath, String key) {
    	Properties properties = new Properties();
    	try {
			InputStream inputStream = new BufferedInputStream(new FileInputStream(filepath));
			properties.load(inputStream);
			String value = properties.getProperty(key);
			System.out.println(key+":= "+value);
			return value;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
     //读取Properties的全部信息
     @SuppressWarnings("rawtypes")
	public void GetAllProperties(String filePath) throws IOException {
         Properties pps = new Properties();
         InputStream in = new BufferedInputStream(new FileInputStream(filePath));
         pps.load(in);
         Enumeration en = pps.propertyNames(); //得到配置文件的名字
         
         while(en.hasMoreElements()) {
             String strKey = (String) en.nextElement();
             String strValue = pps.getProperty(strKey);
             System.out.println(strKey + "=" + strValue);
         }
     }
   //写入Properties信息
     public void WriteProperties (String filePath, String pKey, String pValue) throws IOException {
         Properties pps = new Properties();
         
         InputStream in = new FileInputStream(filePath);
         //从输入流中读取属性列表（键和元素对） 
         pps.load(in);
         //调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。  
         //强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
         OutputStream out = new FileOutputStream(filePath);
         pps.setProperty(pKey, pValue);
         //以适合使用 load 方法加载到 Properties 表中的格式，  
         //将此 Properties 表中的属性列表（键和元素对）写入输出流  
         pps.store(out, "Update " + pKey + " name");
     }
     
    @Test
    public void testProperties() throws IOException {
    	TestProperties tProperties = new TestProperties();
    	String value = tProperties.getValueByKey("src/cn/bean/properties/Test.properties", "name");
    	System.out.println(value);
    	tProperties.GetAllProperties("src/cn/bean/properties/Test.properties");
    	tProperties.WriteProperties("src/cn/bean/properties/Test.properties","long", "212");
    }
}
