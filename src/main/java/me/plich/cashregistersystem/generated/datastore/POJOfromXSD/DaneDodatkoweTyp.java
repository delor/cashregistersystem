
package me.plich.cashregistersystem.generated.datastore.POJOfromXSD;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DaneDodatkoweTyp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DaneDodatkoweTyp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DataRozpoczeciaWykonywaniaDzialalnosciGospodarczej" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DataZawieszeniaWykonywaniaDzialalnosciGospodarczej" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DataWznowieniaWykonywaniaDzialalnosciGospodarczej" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DataZaprzestaniaWykonywaniaDzialalnosciGospodarczej" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DataWykresleniaWpisuZRejestru" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MalzenskaWspolnoscMajatkowa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PodstawaPrawnaWykreslenia" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Informacja" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="KodyPKD" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DaneDodatkoweTyp", propOrder = {
    "dataRozpoczeciaWykonywaniaDzialalnosciGospodarczej",
    "dataZawieszeniaWykonywaniaDzialalnosciGospodarczej",
    "dataWznowieniaWykonywaniaDzialalnosciGospodarczej",
    "dataZaprzestaniaWykonywaniaDzialalnosciGospodarczej",
    "dataWykresleniaWpisuZRejestru",
    "malzenskaWspolnoscMajatkowa",
    "status",
    "podstawaPrawnaWykreslenia",
    "kodyPKD"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class DaneDodatkoweTyp {

    @XmlElement(name = "DataRozpoczeciaWykonywaniaDzialalnosciGospodarczej", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String dataRozpoczeciaWykonywaniaDzialalnosciGospodarczej;
    @XmlElement(name = "DataZawieszeniaWykonywaniaDzialalnosciGospodarczej", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String dataZawieszeniaWykonywaniaDzialalnosciGospodarczej;
    @XmlElement(name = "DataWznowieniaWykonywaniaDzialalnosciGospodarczej", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String dataWznowieniaWykonywaniaDzialalnosciGospodarczej;
    @XmlElement(name = "DataZaprzestaniaWykonywaniaDzialalnosciGospodarczej", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String dataZaprzestaniaWykonywaniaDzialalnosciGospodarczej;
    @XmlElement(name = "DataWykresleniaWpisuZRejestru", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String dataWykresleniaWpisuZRejestru;
    @XmlElement(name = "MalzenskaWspolnoscMajatkowa", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String malzenskaWspolnoscMajatkowa;
    @XmlElement(name = "Status", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String status;
    @XmlElement(name = "PodstawaPrawnaWykreslenia")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DaneDodatkoweTyp.PodstawaPrawnaWykreslenia podstawaPrawnaWykreslenia;
    @XmlElement(name = "KodyPKD", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String kodyPKD;

    /**
     * Gets the value of the dataRozpoczeciaWykonywaniaDzialalnosciGospodarczej property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getDataRozpoczeciaWykonywaniaDzialalnosciGospodarczej() {
        return dataRozpoczeciaWykonywaniaDzialalnosciGospodarczej;
    }

    /**
     * Sets the value of the dataRozpoczeciaWykonywaniaDzialalnosciGospodarczej property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setDataRozpoczeciaWykonywaniaDzialalnosciGospodarczej(String value) {
        this.dataRozpoczeciaWykonywaniaDzialalnosciGospodarczej = value;
    }

    /**
     * Gets the value of the dataZawieszeniaWykonywaniaDzialalnosciGospodarczej property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getDataZawieszeniaWykonywaniaDzialalnosciGospodarczej() {
        return dataZawieszeniaWykonywaniaDzialalnosciGospodarczej;
    }

    /**
     * Sets the value of the dataZawieszeniaWykonywaniaDzialalnosciGospodarczej property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setDataZawieszeniaWykonywaniaDzialalnosciGospodarczej(String value) {
        this.dataZawieszeniaWykonywaniaDzialalnosciGospodarczej = value;
    }

    /**
     * Gets the value of the dataWznowieniaWykonywaniaDzialalnosciGospodarczej property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getDataWznowieniaWykonywaniaDzialalnosciGospodarczej() {
        return dataWznowieniaWykonywaniaDzialalnosciGospodarczej;
    }

    /**
     * Sets the value of the dataWznowieniaWykonywaniaDzialalnosciGospodarczej property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setDataWznowieniaWykonywaniaDzialalnosciGospodarczej(String value) {
        this.dataWznowieniaWykonywaniaDzialalnosciGospodarczej = value;
    }

    /**
     * Gets the value of the dataZaprzestaniaWykonywaniaDzialalnosciGospodarczej property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getDataZaprzestaniaWykonywaniaDzialalnosciGospodarczej() {
        return dataZaprzestaniaWykonywaniaDzialalnosciGospodarczej;
    }

    /**
     * Sets the value of the dataZaprzestaniaWykonywaniaDzialalnosciGospodarczej property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setDataZaprzestaniaWykonywaniaDzialalnosciGospodarczej(String value) {
        this.dataZaprzestaniaWykonywaniaDzialalnosciGospodarczej = value;
    }

    /**
     * Gets the value of the dataWykresleniaWpisuZRejestru property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getDataWykresleniaWpisuZRejestru() {
        return dataWykresleniaWpisuZRejestru;
    }

    /**
     * Sets the value of the dataWykresleniaWpisuZRejestru property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setDataWykresleniaWpisuZRejestru(String value) {
        this.dataWykresleniaWpisuZRejestru = value;
    }

    /**
     * Gets the value of the malzenskaWspolnoscMajatkowa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getMalzenskaWspolnoscMajatkowa() {
        return malzenskaWspolnoscMajatkowa;
    }

    /**
     * Sets the value of the malzenskaWspolnoscMajatkowa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setMalzenskaWspolnoscMajatkowa(String value) {
        this.malzenskaWspolnoscMajatkowa = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the podstawaPrawnaWykreslenia property.
     * 
     * @return
     *     possible object is
     *     {@link DaneDodatkoweTyp.PodstawaPrawnaWykreslenia }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DaneDodatkoweTyp.PodstawaPrawnaWykreslenia getPodstawaPrawnaWykreslenia() {
        return podstawaPrawnaWykreslenia;
    }

    /**
     * Sets the value of the podstawaPrawnaWykreslenia property.
     * 
     * @param value
     *     allowed object is
     *     {@link DaneDodatkoweTyp.PodstawaPrawnaWykreslenia }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setPodstawaPrawnaWykreslenia(DaneDodatkoweTyp.PodstawaPrawnaWykreslenia value) {
        this.podstawaPrawnaWykreslenia = value;
    }

    /**
     * Gets the value of the kodyPKD property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getKodyPKD() {
        return kodyPKD;
    }

    /**
     * Sets the value of the kodyPKD property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setKodyPKD(String value) {
        this.kodyPKD = value;
    }


    /**
     * Podstawa prawna wykreślenia
     * 
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Informacja" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "informacja"
    })
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public static class PodstawaPrawnaWykreslenia {

        @XmlElement(name = "Informacja", required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected List<String> informacja;

        /**
         * Gets the value of the informacja property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the informacja property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInformacja().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public List<String> getInformacja() {
            if (informacja == null) {
                informacja = new ArrayList<String>();
            }
            return this.informacja;
        }

    }

}
