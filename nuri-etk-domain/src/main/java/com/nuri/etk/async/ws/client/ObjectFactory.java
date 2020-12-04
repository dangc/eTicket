
package com.nuri.etk.async.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.aimir.etk.ws.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CmdSTSBlockTariffResponse_QNAME = new QName("http://server.ws.command.fep.aimir.com/", "cmdSTSBlockTariffResponse");
    private final static QName _CmdSendIHDData_QNAME = new QName("http://server.ws.command.fep.aimir.com/", "cmdSendIHDData");
    private final static QName _CmdSendIHDDataResponse_QNAME = new QName("http://server.ws.command.fep.aimir.com/", "cmdSendIHDDataResponse");
    private final static QName _IcmpPingResponse_QNAME = new QName("http://server.ws.command.fep.aimir.com/", "icmpPingResponse");
    private final static QName _TracerouteResponse_QNAME = new QName("http://server.ws.command.fep.aimir.com/", "tracerouteResponse");
    private final static QName _CmdTCPTriggerResponse_QNAME = new QName("http://server.ws.command.fep.aimir.com/", "cmdTCPTriggerResponse");
    private final static QName _IcmpPing_QNAME = new QName("http://server.ws.command.fep.aimir.com/", "icmpPing");
    private final static QName _RelayValveOnResponse_QNAME = new QName("http://server.ws.command.fep.aimir.com/", "relayValveOnResponse");
    private final static QName _CmdSTSNetCharge_QNAME = new QName("http://server.ws.command.fep.aimir.com/", "cmdSTSNetCharge");
    private final static QName _Exception_QNAME = new QName("http://server.ws.command.fep.aimir.com/", "Exception");
    private final static QName _CmdSTSGeneralCommand_QNAME = new QName("http://server.ws.command.fep.aimir.com/", "cmdSTSGeneralCommand");
    private final static QName _CmdSTSBlockTariff_QNAME = new QName("http://server.ws.command.fep.aimir.com/", "cmdSTSBlockTariff");
    private final static QName _CmdSTSGeneralCommandResponse_QNAME = new QName("http://server.ws.command.fep.aimir.com/", "cmdSTSGeneralCommandResponse");
    private final static QName _CmdSTSNetChargeResponse_QNAME = new QName("http://server.ws.command.fep.aimir.com/", "cmdSTSNetChargeResponse");
    private final static QName _RelayValveOn_QNAME = new QName("http://server.ws.command.fep.aimir.com/", "relayValveOn");
    private final static QName _Traceroute_QNAME = new QName("http://server.ws.command.fep.aimir.com/", "traceroute");
    private final static QName _CmdTCPTrigger_QNAME = new QName("http://server.ws.command.fep.aimir.com/", "cmdTCPTrigger");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.aimir.etk.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ResponseMap }
     * 
     */
    public ResponseMap createResponseMap() {
        return new ResponseMap();
    }

    /**
     * Create an instance of {@link ResponseMap.Response }
     * 
     */
    public ResponseMap.Response createResponseMapResponse() {
        return new ResponseMap.Response();
    }

    /**
     * Create an instance of {@link CmdTCPTrigger }
     * 
     */
    public CmdTCPTrigger createCmdTCPTrigger() {
        return new CmdTCPTrigger();
    }

    /**
     * Create an instance of {@link CmdSTSBlockTariff }
     * 
     */
    public CmdSTSBlockTariff createCmdSTSBlockTariff() {
        return new CmdSTSBlockTariff();
    }

    /**
     * Create an instance of {@link CmdSTSGeneralCommandResponse }
     * 
     */
    public CmdSTSGeneralCommandResponse createCmdSTSGeneralCommandResponse() {
        return new CmdSTSGeneralCommandResponse();
    }

    /**
     * Create an instance of {@link CmdSTSNetChargeResponse }
     * 
     */
    public CmdSTSNetChargeResponse createCmdSTSNetChargeResponse() {
        return new CmdSTSNetChargeResponse();
    }

    /**
     * Create an instance of {@link Traceroute }
     * 
     */
    public Traceroute createTraceroute() {
        return new Traceroute();
    }

    /**
     * Create an instance of {@link java.lang.Exception }
     * 
     */
    public java.lang.Exception createException() {
        return new java.lang.Exception();
    }

    /**
     * Create an instance of {@link CmdSTSGeneralCommand }
     * 
     */
    public CmdSTSGeneralCommand createCmdSTSGeneralCommand() {
        return new CmdSTSGeneralCommand();
    }

    /**
     * Create an instance of {@link CmdSTSNetCharge }
     * 
     */
    public CmdSTSNetCharge createCmdSTSNetCharge() {
        return new CmdSTSNetCharge();
    }

    /**
     * Create an instance of {@link IcmpPingResponse }
     * 
     */
    public IcmpPingResponse createIcmpPingResponse() {
        return new IcmpPingResponse();
    }

    /**
     * Create an instance of {@link TracerouteResponse }
     * 
     */
    public TracerouteResponse createTracerouteResponse() {
        return new TracerouteResponse();
    }

    /**
     * Create an instance of {@link CmdTCPTriggerResponse }
     * 
     */
    public CmdTCPTriggerResponse createCmdTCPTriggerResponse() {
        return new CmdTCPTriggerResponse();
    }

    /**
     * Create an instance of {@link IcmpPing }
     * 
     */
    public IcmpPing createIcmpPing() {
        return new IcmpPing();
    }

    /**
     * Create an instance of {@link CmdSTSBlockTariffResponse }
     * 
     */
    public CmdSTSBlockTariffResponse createCmdSTSBlockTariffResponse() {
        return new CmdSTSBlockTariffResponse();
    }


    /**
     * Create an instance of {@link ResponseMap.Response.Entry }
     * 
     */
    public ResponseMap.Response.Entry createResponseMapResponseEntry() {
        return new ResponseMap.Response.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CmdSTSBlockTariffResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.command.fep.aimir.com/", name = "cmdSTSBlockTariffResponse")
    public JAXBElement<CmdSTSBlockTariffResponse> createCmdSTSBlockTariffResponse(CmdSTSBlockTariffResponse value) {
        return new JAXBElement<CmdSTSBlockTariffResponse>(_CmdSTSBlockTariffResponse_QNAME, CmdSTSBlockTariffResponse.class, null, value);
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IcmpPingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.command.fep.aimir.com/", name = "icmpPingResponse")
    public JAXBElement<IcmpPingResponse> createIcmpPingResponse(IcmpPingResponse value) {
        return new JAXBElement<IcmpPingResponse>(_IcmpPingResponse_QNAME, IcmpPingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TracerouteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.command.fep.aimir.com/", name = "tracerouteResponse")
    public JAXBElement<TracerouteResponse> createTracerouteResponse(TracerouteResponse value) {
        return new JAXBElement<TracerouteResponse>(_TracerouteResponse_QNAME, TracerouteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CmdTCPTriggerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.command.fep.aimir.com/", name = "cmdTCPTriggerResponse")
    public JAXBElement<CmdTCPTriggerResponse> createCmdTCPTriggerResponse(CmdTCPTriggerResponse value) {
        return new JAXBElement<CmdTCPTriggerResponse>(_CmdTCPTriggerResponse_QNAME, CmdTCPTriggerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IcmpPing }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.command.fep.aimir.com/", name = "icmpPing")
    public JAXBElement<IcmpPing> createIcmpPing(IcmpPing value) {
        return new JAXBElement<IcmpPing>(_IcmpPing_QNAME, IcmpPing.class, null, value);
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CmdSTSNetCharge }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.command.fep.aimir.com/", name = "cmdSTSNetCharge")
    public JAXBElement<CmdSTSNetCharge> createCmdSTSNetCharge(CmdSTSNetCharge value) {
        return new JAXBElement<CmdSTSNetCharge>(_CmdSTSNetCharge_QNAME, CmdSTSNetCharge.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link java.lang.Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.command.fep.aimir.com/", name = "Exception")
    public JAXBElement<java.lang.Exception> createException(java.lang.Exception value) {
        return new JAXBElement<java.lang.Exception>(_Exception_QNAME, java.lang.Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CmdSTSGeneralCommand }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.command.fep.aimir.com/", name = "cmdSTSGeneralCommand")
    public JAXBElement<CmdSTSGeneralCommand> createCmdSTSGeneralCommand(CmdSTSGeneralCommand value) {
        return new JAXBElement<CmdSTSGeneralCommand>(_CmdSTSGeneralCommand_QNAME, CmdSTSGeneralCommand.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CmdSTSBlockTariff }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.command.fep.aimir.com/", name = "cmdSTSBlockTariff")
    public JAXBElement<CmdSTSBlockTariff> createCmdSTSBlockTariff(CmdSTSBlockTariff value) {
        return new JAXBElement<CmdSTSBlockTariff>(_CmdSTSBlockTariff_QNAME, CmdSTSBlockTariff.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CmdSTSGeneralCommandResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.command.fep.aimir.com/", name = "cmdSTSGeneralCommandResponse")
    public JAXBElement<CmdSTSGeneralCommandResponse> createCmdSTSGeneralCommandResponse(CmdSTSGeneralCommandResponse value) {
        return new JAXBElement<CmdSTSGeneralCommandResponse>(_CmdSTSGeneralCommandResponse_QNAME, CmdSTSGeneralCommandResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CmdSTSNetChargeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.command.fep.aimir.com/", name = "cmdSTSNetChargeResponse")
    public JAXBElement<CmdSTSNetChargeResponse> createCmdSTSNetChargeResponse(CmdSTSNetChargeResponse value) {
        return new JAXBElement<CmdSTSNetChargeResponse>(_CmdSTSNetChargeResponse_QNAME, CmdSTSNetChargeResponse.class, null, value);
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Traceroute }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.command.fep.aimir.com/", name = "traceroute")
    public JAXBElement<Traceroute> createTraceroute(Traceroute value) {
        return new JAXBElement<Traceroute>(_Traceroute_QNAME, Traceroute.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CmdTCPTrigger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.command.fep.aimir.com/", name = "cmdTCPTrigger")
    public JAXBElement<CmdTCPTrigger> createCmdTCPTrigger(CmdTCPTrigger value) {
        return new JAXBElement<CmdTCPTrigger>(_CmdTCPTrigger_QNAME, CmdTCPTrigger.class, null, value);
    }

}
