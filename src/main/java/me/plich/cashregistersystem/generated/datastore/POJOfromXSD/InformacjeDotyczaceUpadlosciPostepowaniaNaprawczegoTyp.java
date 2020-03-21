
package me.plich.cashregistersystem.generated.datastore.POJOfromXSD;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InformacjeDotyczaceUpadlosciPostepowaniaNaprawczegoTyp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InformacjeDotyczaceUpadlosciPostepowaniaNaprawczegoTyp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Informacja" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DataOrzeczeniaWszczeciaPostepowaniaNaprawczego" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="RodzajInformacji" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="SygnaturaSprawy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="OrganWprowadzajacy" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "InformacjeDotyczaceUpadlosciPostepowaniaNaprawczegoTyp", propOrder = {
    "informacja"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class InformacjeDotyczaceUpadlosciPostepowaniaNaprawczegoTyp {

    @XmlElement(name = "Informacja")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<InformacjeDotyczaceUpadlosciPostepowaniaNaprawczegoTyp.Informacja> informacja;

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
     * {@link InformacjeDotyczaceUpadlosciPostepowaniaNaprawczegoTyp.Informacja }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<InformacjeDotyczaceUpadlosciPostepowaniaNaprawczegoTyp.Informacja> getInformacja() {
        if (informacja == null) {
            informacja = new ArrayList<InformacjeDotyczaceUpadlosciPostepowaniaNaprawczegoTyp.Informacja>();
        }
        return this.informacja;
    }


    /**
     * Informacja dotycząca upadłości / postępowania naprawczego
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
     *         &lt;element name="DataOrzeczeniaWszczeciaPostepowaniaNaprawczego" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="RodzajInformacji" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="SygnaturaSprawy" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="OrganWprowadzajacy" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "dataOrzeczeniaWszczeciaPostepowaniaNaprawczego",
        "rodzajInformacji",
        "sygnaturaSprawy",
        "organWprowadzajacy"
    })
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public static class Informacja {

        @XmlElement(name = "DataOrzeczeniaWszczeciaPostepowaniaNaprawczego", required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String dataOrzeczeniaWszczeciaPostepowaniaNaprawczego;
        @XmlElement(name = "RodzajInformacji", required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String rodzajInformacji;
        @XmlElement(name = "SygnaturaSprawy", required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String sygnaturaSprawy;
        @XmlElement(name = "OrganWprowadzajacy", required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String organWprowadzajacy;

        /**
         * Gets the value of the dataOrzeczeniaWszczeciaPostepowaniaNaprawczego property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getDataOrzeczeniaWszczeciaPostepowaniaNaprawczego() {
            return dataOrzeczeniaWszczeciaPostepowaniaNaprawczego;
        }

        /**
         * Sets the value of the dataOrzeczeniaWszczeciaPostepowaniaNaprawczego property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setDataOrzeczeniaWszczeciaPostepowaniaNaprawczego(String value) {
            this.dataOrzeczeniaWszczeciaPostepowaniaNaprawczego = value;
        }

        /**
         * Gets the value of the rodzajInformacji property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getRodzajInformacji() {
            return rodzajInformacji;
        }

        /**
         * Sets the value of the rodzajInformacji property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setRodzajInformacji(String value) {
            this.rodzajInformacji = value;
        }

        /**
         * Gets the value of the sygnaturaSprawy property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getSygnaturaSprawy() {
            return sygnaturaSprawy;
        }

        /**
         * Sets the value of the sygnaturaSprawy property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setSygnaturaSprawy(String value) {
            this.sygnaturaSprawy = value;
        }

        /**
         * Gets the value of the organWprowadzajacy property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getOrganWprowadzajacy() {
            return organWprowadzajacy;
        }

        /**
         * Sets the value of the organWprowadzajacy property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setOrganWprowadzajacy(String value) {
            this.organWprowadzajacy = value;
        }

    }

}
