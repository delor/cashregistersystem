
package me.plich.cashregistersystem.generated.datastore.POJOfromXSD;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZarzadcaTyp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZarzadcaTyp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DataUstanowieniaZarzadcy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ImieZarzadcy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NazwiskoZarzadcy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ObywatelstwaZarzadcy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdresDoDoreczenZarzadcy" type="{}AdresTyp" minOccurs="0"/>
 *         &lt;element name="EmailZarzadcy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdresWWWZarzadcy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NrTelZarzadcy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZarzadcaTyp", propOrder = {
    "dataUstanowieniaZarzadcy",
    "imieZarzadcy",
    "nazwiskoZarzadcy",
    "nip",
    "obywatelstwaZarzadcy",
    "adresDoDoreczenZarzadcy",
    "emailZarzadcy",
    "adresWWWZarzadcy",
    "nrTelZarzadcy"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class ZarzadcaTyp {

    @XmlElement(name = "DataUstanowieniaZarzadcy")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String dataUstanowieniaZarzadcy;
    @XmlElement(name = "ImieZarzadcy")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String imieZarzadcy;
    @XmlElement(name = "NazwiskoZarzadcy")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String nazwiskoZarzadcy;
    @XmlElement(name = "NIP")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String nip;
    @XmlElement(name = "ObywatelstwaZarzadcy")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String obywatelstwaZarzadcy;
    @XmlElement(name = "AdresDoDoreczenZarzadcy")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected AdresTyp adresDoDoreczenZarzadcy;
    @XmlElement(name = "EmailZarzadcy")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String emailZarzadcy;
    @XmlElement(name = "AdresWWWZarzadcy")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String adresWWWZarzadcy;
    @XmlElement(name = "NrTelZarzadcy")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String nrTelZarzadcy;

    /**
     * Gets the value of the dataUstanowieniaZarzadcy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getDataUstanowieniaZarzadcy() {
        return dataUstanowieniaZarzadcy;
    }

    /**
     * Sets the value of the dataUstanowieniaZarzadcy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setDataUstanowieniaZarzadcy(String value) {
        this.dataUstanowieniaZarzadcy = value;
    }

    /**
     * Gets the value of the imieZarzadcy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getImieZarzadcy() {
        return imieZarzadcy;
    }

    /**
     * Sets the value of the imieZarzadcy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setImieZarzadcy(String value) {
        this.imieZarzadcy = value;
    }

    /**
     * Gets the value of the nazwiskoZarzadcy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getNazwiskoZarzadcy() {
        return nazwiskoZarzadcy;
    }

    /**
     * Sets the value of the nazwiskoZarzadcy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setNazwiskoZarzadcy(String value) {
        this.nazwiskoZarzadcy = value;
    }

    /**
     * Gets the value of the nip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getNIP() {
        return nip;
    }

    /**
     * Sets the value of the nip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setNIP(String value) {
        this.nip = value;
    }

    /**
     * Gets the value of the obywatelstwaZarzadcy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getObywatelstwaZarzadcy() {
        return obywatelstwaZarzadcy;
    }

    /**
     * Sets the value of the obywatelstwaZarzadcy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setObywatelstwaZarzadcy(String value) {
        this.obywatelstwaZarzadcy = value;
    }

    /**
     * Gets the value of the adresDoDoreczenZarzadcy property.
     * 
     * @return
     *     possible object is
     *     {@link AdresTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public AdresTyp getAdresDoDoreczenZarzadcy() {
        return adresDoDoreczenZarzadcy;
    }

    /**
     * Sets the value of the adresDoDoreczenZarzadcy property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdresTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setAdresDoDoreczenZarzadcy(AdresTyp value) {
        this.adresDoDoreczenZarzadcy = value;
    }

    /**
     * Gets the value of the emailZarzadcy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getEmailZarzadcy() {
        return emailZarzadcy;
    }

    /**
     * Sets the value of the emailZarzadcy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setEmailZarzadcy(String value) {
        this.emailZarzadcy = value;
    }

    /**
     * Gets the value of the adresWWWZarzadcy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getAdresWWWZarzadcy() {
        return adresWWWZarzadcy;
    }

    /**
     * Sets the value of the adresWWWZarzadcy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setAdresWWWZarzadcy(String value) {
        this.adresWWWZarzadcy = value;
    }

    /**
     * Gets the value of the nrTelZarzadcy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getNrTelZarzadcy() {
        return nrTelZarzadcy;
    }

    /**
     * Sets the value of the nrTelZarzadcy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setNrTelZarzadcy(String value) {
        this.nrTelZarzadcy = value;
    }

}
