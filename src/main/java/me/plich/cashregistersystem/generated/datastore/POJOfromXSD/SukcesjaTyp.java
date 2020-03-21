
package me.plich.cashregistersystem.generated.datastore.POJOfromXSD;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SukcesjaTyp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SukcesjaTyp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DataUstanowieniaZarzadu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DataWygansnieciaZarzadu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Zarzadca" type="{}ZarzadcaTyp" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SukcesjaTyp", propOrder = {
    "dataUstanowieniaZarzadu",
    "dataWygansnieciaZarzadu",
    "zarzadca"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class SukcesjaTyp {

    @XmlElement(name = "DataUstanowieniaZarzadu")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String dataUstanowieniaZarzadu;
    @XmlElement(name = "DataWygansnieciaZarzadu")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String dataWygansnieciaZarzadu;
    @XmlElement(name = "Zarzadca")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected ZarzadcaTyp zarzadca;

    /**
     * Gets the value of the dataUstanowieniaZarzadu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getDataUstanowieniaZarzadu() {
        return dataUstanowieniaZarzadu;
    }

    /**
     * Sets the value of the dataUstanowieniaZarzadu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setDataUstanowieniaZarzadu(String value) {
        this.dataUstanowieniaZarzadu = value;
    }

    /**
     * Gets the value of the dataWygansnieciaZarzadu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getDataWygansnieciaZarzadu() {
        return dataWygansnieciaZarzadu;
    }

    /**
     * Sets the value of the dataWygansnieciaZarzadu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setDataWygansnieciaZarzadu(String value) {
        this.dataWygansnieciaZarzadu = value;
    }

    /**
     * Gets the value of the zarzadca property.
     * 
     * @return
     *     possible object is
     *     {@link ZarzadcaTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public ZarzadcaTyp getZarzadca() {
        return zarzadca;
    }

    /**
     * Sets the value of the zarzadca property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZarzadcaTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setZarzadca(ZarzadcaTyp value) {
        this.zarzadca = value;
    }

}
