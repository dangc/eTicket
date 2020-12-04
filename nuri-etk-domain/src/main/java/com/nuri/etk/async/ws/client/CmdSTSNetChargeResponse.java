
package com.nuri.etk.async.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *
 * <pre>
 * &lt;complexType name="cmdSTSNetChargeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://server.ws.command.fep.aimir.com/}responseMap" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cmdSTSNetChargeResponse", propOrder = {
    "_return"
})
public class CmdSTSNetChargeResponse {

    @XmlElement(name = "return")
    protected ResponseMap _return;

    /**
     * @return
     *     possible object is
     *     {@link ResponseMap }
     *     
     */
    public ResponseMap getReturn() {
        return _return;
    }

    /**
     * @param value
     *     allowed object is
     *     {@link ResponseMap }
     *     
     */
    public void setReturn(ResponseMap value) {
        this._return = value;
    }

}
