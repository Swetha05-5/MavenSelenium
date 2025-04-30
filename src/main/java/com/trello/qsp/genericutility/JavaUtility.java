package com.trello.qsp.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class JavaUtility {
/**
 * To read data from property file in the form of key and value pair
 * @param key
 * @return value
 * @throws IOException 
 * @throws FileNotFoundException
 */
	
	public String readDataFromPropertyFile(String key) throws IOException, FileNotFoundException
	{
		Properties pobj=new Properties();
		pobj.load(new FileInputStream("./src/test/resources/trellodata.properties"));
		String value=pobj.getProperty(key);
		return value;
	}
}
