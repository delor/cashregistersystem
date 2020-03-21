
package me.plich.cashregistersystem.generated.datastore.POJOfromXSD;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SpolkiCywilneKtorychWspolnikiemJestPrzedsiebiorcaTyp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SpolkiCywilneKtorychWspolnikiemJestPrzedsiebiorcaTyp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InformacjeOSpolce" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NIP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="REGON" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="DataZawieszeniaWynonywaniaDzialalnosciGospodarczejWSpolce" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpolkiCywilneKtorychWspolnikiemJestPrzedsiebiorcaTyp", propOrder = {
    "informacjeOSpolce"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class SpolkiCywilneKtorychWspolnikiemJestPrzedsiebiorcaTyp {

    @XmlElement(name = "InformacjeOSpolce")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<SpolkiCywilneKtorychWspolnikiemJestPrzedsiebiorcaTyp.InformacjeOSpolce> informacjeOSpolce;

    /**
     * Gets the value of the informacjeOSpolce property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the informacjeOSpolce property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInformacjeOSpolce().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpolkiCywilneKtorychWspolnikiemJestPrzedsiebiorcaTyp.InformacjeOSpolce }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<SpolkiCywilneKtorychWspolnikiemJestPrzedsiebiorcaTyp.InformacjeOSpolce> getInformacjeOSpolce() {
        if (informacjeOSpolce == null) {
            informacjeOSpolce = new ArrayList<SpolkiCywilneKtorychWspolnikiemJestPrzedsiebiorcaTyp.InformacjeOSpolce>();
        }
        return this.informacjeOSpolce;
    }


    /**
     * Informacje o spółce cywilnej, której wspólnikiem jest przedsiębiorca
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
     *         &lt;element name="NIP" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="REGON" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="DataZawieszeniaWynonywaniaDzialalnosciGospodarczejWSpolce" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "nip",
        "regon",
        "dataZawieszeniaWynonywaniaDzialalnosciGospodarczejWSpolce"
    })
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public static class InformacjeOSpolce {

        @XmlElement(name = "NIP", required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String nip;
        @XmlElement(name = "REGON", required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String regon;
        @XmlElement(name = "DataZawieszeniaWynonywaniaDzialalnosciGospodarczejWSpolce")
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String dataZawieszeniaWynonywaniaDzialalnosciGospodarczejWSpolce;

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
         * Gets the value of the regon property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getREGON() {
            return regon;
        }

        /**
         * Sets the value of the regon property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setREGON(String value) {
            this.regon = value;
        }

        /**
         * Gets the value of the dataZawieszeniaWynonywaniaDzialalnosciGospodarczejWSpolce property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getDataZawieszeniaWynonywaniaDzialalnosciGospodarczejWSpolce() {
            return dataZawieszeniaWynonywaniaDzialalnosciGospodarczejWSpolce;
        }

        /**
         * Sets the value of the dataZawieszeniaWynonywaniaDzialalnosciGospodarczejWSpolce property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setDataZawieszeniaWynonywaniaDzialalnosciGospodarczejWSpolce(String value) {
            this.dataZawieszeniaWynonywaniaDzialalnosciGospodarczejWSpolce = value;
        }

    }

}
