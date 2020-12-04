package com.nuri.etk.async.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;


/**
 * Same as aimir-web package.
 */
public class CmdProperty {
    private static Log log = LogFactory.getLog(CmdProperty.class);
    private static final Properties properties;

    static {
        String it = "/config/command.properties";

        Properties result = new Properties();
        try
        {
            InputStream is =
                    CmdProperty.class.getResourceAsStream(it);
            result.load(is);
            is.close();

        } catch(Exception e) {
			try {
        		it = "/command.properties";
        		InputStream is = CmdProperty.class.getResourceAsStream(it);
        		result.load(is);
        		is.close();
        	} catch (Exception e1) {
        		log.error(e1,e1);
        	}
        }

        properties = result;
    }

    private CmdProperty() {
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
            url = CmdProperty.class.getResource(val);
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
    public static Enumeration propertyNames()
    {
        return properties.propertyNames();
    }
}
