package cn.bean.properties;

import java.util.Properties;

public class ReadJVM {
    public static void main(String[] args) {
		Properties properties = System.getProperties();
		properties.list(System.out);
	}
}
