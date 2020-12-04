/**
 * 
 */
package com.nuri.etk.async.util;

import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * FMP Properties Manager
 * @author	: sejin 
 * @date	: 2018. 6. 27.
 */
public class ETKProperty {

	private static Log log = LogFactory.getLog(ETKProperty.class);
	private static final Properties properties;
	
	static {
        String it = "/etk.properties";

        Properties result = new Properties();
        try
        {
            InputStream is = 
            		ETKProperty.class.getResourceAsStream(it);
            result.load(is);
            is.close();

        } catch(Exception e) {
        	log.error("Cannot find etk.properties");
        	try {
        		it = "/etk.properties";
        		InputStream is = ETKProperty.class.getResourceAsStream(it);
        		result.load(is);
        		is.close();
        	} catch (Exception e1) {
        		log.error(e1,e1);
        	}
        }

        properties = result;
    }
	
	private ETKProperty() {
		super();
	}
	
	
	/**
     * get PropertyURL
     *
     * @param key <code>String</code>
     * @return url <code>URL</code>
     */
    public static URL getPropertyURL(String key)
    {
        String val = properties.getProperty(key);

        URL url = null;
        try { url = new URL(val); }catch(Exception ex) {}

        if(url == null)
        {
            url = ETKProperty.class.getResource(val);
        }

        return url;

    }
    
    /**
     * get property
     *
     * @param key <code>String</code> key
     * @return value <code>String</code>
     */
    public static String getProperty(String key)
    {
        return properties.getProperty(key);
    }

    
    /**
     * get property
     *
     * @param key <code>String</code> key
     * @param key <code>String</code> value
     * @return value <code>String</code>
     */
    public static String getProperty(String key,String value)
    {
        return properties.getProperty(key,value);
    }

    
    /**
     * get property names
     *
     * @return enumeration <code>Enumeration</code>
     */
    public static Enumeration<?> propertyNames()
    {
        return properties.propertyNames();
    }
}
