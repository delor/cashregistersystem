
package me.plich.cashregistersystem.generated.datastore.POJOfromXSD;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZakazyTyp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZakazyTyp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InformacjaOZakazie" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Typ" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Opis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="OkresNaJakiZostalOrzeczonyZakaz" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ZakazWydal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Nazwa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SygnaturaAktSprawy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="DataWydaniaOrzeczenia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="DataUprawomocnieniaOrzeczenia" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "ZakazyTyp", propOrder = {
    "informacjaOZakazie"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class ZakazyTyp {

    @XmlElement(name = "InformacjaOZakazie")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<ZakazyTyp.InformacjaOZakazie> informacjaOZakazie;

    /**
     * Gets the value of the informacjaOZakazie property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the informacjaOZakazie property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInformacjaOZakazie().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ZakazyTyp.InformacjaOZakazie }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<ZakazyTyp.InformacjaOZakazie> getInformacjaOZakazie() {
        if (informacjaOZakazie == null) {
            informacjaOZakazie = new ArrayList<ZakazyTyp.InformacjaOZakazie>();
        }
        return this.informacjaOZakazie;
    }


    /**
     * Informacja o zakazie
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
     *         &lt;element name="Typ" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Opis" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="OkresNaJakiZostalOrzeczonyZakaz" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ZakazWydal" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Nazwa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SygnaturaAktSprawy" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="DataWydaniaOrzeczenia" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="DataUprawomocnieniaOrzeczenia" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "typ",
        "opis",
        "okresNaJakiZostalOrzeczonyZakaz",
        "zakazWydal",
        "nazwa",
        "sygnaturaAktSprawy",
        "dataWydaniaOrzeczenia",
        "dataUprawomocnieniaOrzeczenia"
    })
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public static class InformacjaOZakazie {

        @XmlElement(name = "Typ", required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String typ;
        @XmlElement(name = "Opis", required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String opis;
        @XmlElement(name = "OkresNaJakiZostalOrzeczonyZakaz", required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String okresNaJakiZostalOrzeczonyZakaz;
        @XmlElement(name = "ZakazWydal", required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String zakazWydal;
        @XmlElement(name = "Nazwa")
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String nazwa;
        @XmlElement(name = "SygnaturaAktSprawy", required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String sygnaturaAktSprawy;
        @XmlElement(name = "DataWydaniaOrzeczenia", required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String dataWydaniaOrzeczenia;
        @XmlElement(name = "DataUprawomocnieniaOrzeczenia", required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String dataUprawomocnieniaOrzeczenia;

        /**
         * Gets the value of the typ property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getTyp() {
            return typ;
        }

        /**
         * Sets the value of the typ property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setTyp(String value) {
            this.typ = value;
        }

        /**
         * Gets the value of the opis property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getOpis() {
            return opis;
        }

        /**
         * Sets the value of the opis property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setOpis(String value) {
            this.opis = value;
        }

        /**
         * Gets the value of the okresNaJakiZostalOrzeczonyZakaz property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getOkresNaJakiZostalOrzeczonyZakaz() {
            return okresNaJakiZostalOrzeczonyZakaz;
        }

        /**
         * Sets the value of the okresNaJakiZostalOrzeczonyZakaz property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setOkresNaJakiZostalOrzeczonyZakaz(String value) {
            this.okresNaJakiZostalOrzeczonyZakaz = value;
        }

        /**
         * Gets the value of the zakazWydal property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getZakazWydal() {
            return zakazWydal;
        }

        /**
         * Sets the value of the zakazWydal property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setZakazWydal(String value) {
            this.zakazWydal = value;
        }

        /**
         * Gets the value of the nazwa property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getNazwa() {
            return nazwa;
        }

        /**
         * Sets the value of the nazwa property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setNazwa(String value) {
            this.nazwa = value;
        }

        /**
         * Gets the value of the sygnaturaAktSprawy property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getSygnaturaAktSprawy() {
            return sygnaturaAktSprawy;
        }

        /**
         * Sets the value of the sygnaturaAktSprawy property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setSygnaturaAktSprawy(String value) {
            this.sygnaturaAktSprawy = value;
        }

        /**
         * Gets the value of the dataWydaniaOrzeczenia property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getDataWydaniaOrzeczenia() {
            return dataWydaniaOrzeczenia;
        }

        /**
         * Sets the value of the dataWydaniaOrzeczenia property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setDataWydaniaOrzeczenia(String value) {
            this.dataWydaniaOrzeczenia = value;
        }

        /**
         * Gets the value of the dataUprawomocnieniaOrzeczenia property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getDataUprawomocnieniaOrzeczenia() {
            return dataUprawomocnieniaOrzeczenia;
        }

        /**
         * Sets the value of the dataUprawomocnieniaOrzeczenia property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setDataUprawomocnieniaOrzeczenia(String value) {
            this.dataUprawomocnieniaOrzeczenia = value;
        }

    }

}
