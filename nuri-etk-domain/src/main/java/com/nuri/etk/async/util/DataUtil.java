package com.nuri.etk.async.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

/**
 * bcd encode/decode
 *
 * @author D.J Park (dong7603@nuritelecom.com)
 * @version $Rev: 1 $, $Date: 2005-11-21 15:59:15 +0900 $,
 */
public class DataUtil
{
    private static Log log = LogFactory.getLog(DataUtil.class);
    private static ApplicationContext appCtx = null;
        // new ClassPathXmlApplicationContext(new String[]{"/config/spring.xml"});
    
    /**
     * constructor
     */
    public DataUtil()
    {
    }


    public static void setApplicationContext(ApplicationContext ctx) {
        appCtx = ctx;
    }
    
    public static <T> T getBean(Class<T> clazz) {
    	if (appCtx != null){
		    return appCtx.getBean(clazz);
        }

        log.info("##GetBean_Tclass: return null");
        return null;
    }
    
    public static Object getBean(String beanName) {
    	if (appCtx != null){
            return appCtx.getBean(beanName);
        }

        log.info("##GetBean_Str: return null");
        return null;
    }
    
    public static Object getBean(String beanName, Class clazz) {
        if (appCtx != null) return appCtx.getBean(beanName, clazz);
        
        return null;
    }
}
