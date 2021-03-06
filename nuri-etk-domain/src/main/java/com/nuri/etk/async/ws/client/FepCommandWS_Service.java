package com.nuri.etk.async.ws.client;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.0
 * 2018-11-23T16:23:48.041+09:00
 * Generated source version: 2.7.0
 * 
 */
@WebServiceClient(name = "FepCommandWS",
                  wsdlLocation = "http://172.16.10.139:8081/services/CommandWS?wsdl",
                  targetNamespace = "http://server.ws.command.fep.aimir.com/") 
public class FepCommandWS_Service extends Service {

    public static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://server.ws.command.fep.aimir.com/", "CommandWS");
    public final static QName CommandWSPort = new QName("http://server.ws.command.fep.aimir.com/", "CommandWSPort");
    /*static {
        URL url = null;
        try {
            url = new URL("http://172.16.10.139:8081/services/CommandWS?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CommandWS_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://172.16.10.139:8081/services/CommandWS?wsdl");
        }
        WSDL_LOCATION = url;
    }*/

    public FepCommandWS_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public FepCommandWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FepCommandWS_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public FepCommandWS_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public FepCommandWS_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public FepCommandWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns FepCommandWS
     */
    @WebEndpoint(name = "CommandWSPort")
    public FepCommandWS getCommandWSPort() {
        return super.getPort(CommandWSPort, FepCommandWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FepCommandWS
     */
    @WebEndpoint(name = "CommandWSPort")
    public FepCommandWS getCommandWSPort(WebServiceFeature... features) {
        return super.getPort(CommandWSPort, FepCommandWS.class, features);
    }

}
