
package me.plich.cashregistersystem.generated.datastore.POJOfromXSD;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DaneAdresoweTyp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DaneAdresoweTyp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AdresGlownegoMiejscaWykonywaniaDzialalnosci" type="{}AdresTyp"/>
 *         &lt;element name="AdresyDodatkowychMiejscWykonywaniaDzialalnosci" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Adres" type="{}AdresTyp" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AdresDoDoreczen" type="{}AdresTyp"/>
 *         &lt;element name="PrzedsiebiorcaPosiadaObywatelstwaPanstw" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DaneAdresoweTyp", propOrder = {
    "adresGlownegoMiejscaWykonywaniaDzialalnosci",
    "adresyDodatkowychMiejscWykonywaniaDzialalnosci",
    "adresDoDoreczen",
    "przedsiebiorcaPosiadaObywatelstwaPanstw"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class DaneAdresoweTyp {

    @XmlElement(name = "AdresGlownegoMiejscaWykonywaniaDzialalnosci", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected AdresTyp adresGlownegoMiejscaWykonywaniaDzialalnosci;
    @XmlElement(name = "AdresyDodatkowychMiejscWykonywaniaDzialalnosci")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DaneAdresoweTyp.AdresyDodatkowychMiejscWykonywaniaDzialalnosci adresyDodatkowychMiejscWykonywaniaDzialalnosci;
    @XmlElement(name = "AdresDoDoreczen", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected AdresTyp adresDoDoreczen;
    @XmlElement(name = "PrzedsiebiorcaPosiadaObywatelstwaPanstw", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String przedsiebiorcaPosiadaObywatelstwaPanstw;

    /**
     * Gets the value of the adresGlownegoMiejscaWykonywaniaDzialalnosci property.
     * 
     * @return
     *     possible object is
     *     {@link AdresTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public AdresTyp getAdresGlownegoMiejscaWykonywaniaDzialalnosci() {
        return adresGlownegoMiejscaWykonywaniaDzialalnosci;
    }

    /**
     * Sets the value of the adresGlownegoMiejscaWykonywaniaDzialalnosci property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdresTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setAdresGlownegoMiejscaWykonywaniaDzialalnosci(AdresTyp value) {
        this.adresGlownegoMiejscaWykonywaniaDzialalnosci = value;
    }

    /**
     * Gets the value of the adresyDodatkowychMiejscWykonywaniaDzialalnosci property.
     * 
     * @return
     *     possible object is
     *     {@link DaneAdresoweTyp.AdresyDodatkowychMiejscWykonywaniaDzialalnosci }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DaneAdresoweTyp.AdresyDodatkowychMiejscWykonywaniaDzialalnosci getAdresyDodatkowychMiejscWykonywaniaDzialalnosci() {
        return adresyDodatkowychMiejscWykonywaniaDzialalnosci;
    }

    /**
     * Sets the value of the adresyDodatkowychMiejscWykonywaniaDzialalnosci property.
     * 
     * @param value
     *     allowed object is
     *     {@link DaneAdresoweTyp.AdresyDodatkowychMiejscWykonywaniaDzialalnosci }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setAdresyDodatkowychMiejscWykonywaniaDzialalnosci(DaneAdresoweTyp.AdresyDodatkowychMiejscWykonywaniaDzialalnosci value) {
        this.adresyDodatkowychMiejscWykonywaniaDzialalnosci = value;
    }

    /**
     * Gets the value of the adresDoDoreczen property.
     * 
     * @return
     *     possible object is
     *     {@link AdresTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public AdresTyp getAdresDoDoreczen() {
        return adresDoDoreczen;
    }

    /**
     * Sets the value of the adresDoDoreczen property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdresTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setAdresDoDoreczen(AdresTyp value) {
        this.adresDoDoreczen = value;
    }

    /**
     * Gets the value of the przedsiebiorcaPosiadaObywatelstwaPanstw property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getPrzedsiebiorcaPosiadaObywatelstwaPanstw() {
        return przedsiebiorcaPosiadaObywatelstwaPanstw;
    }

    /**
     * Sets the value of the przedsiebiorcaPosiadaObywatelstwaPanstw property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setPrzedsiebiorcaPosiadaObywatelstwaPanstw(String value) {
        this.przedsiebiorcaPosiadaObywatelstwaPanstw = value;
    }


    /**
     * Adresy dodatkowych miejsc wykonywania działalności
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
     *         &lt;element name="Adres" type="{}AdresTyp" maxOccurs="unbounded"/>
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
        "adres"
    })
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public static class AdresyDodatkowychMiejscWykonywaniaDzialalnosci {

        @XmlElement(name = "Adres", required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected List<AdresTyp> adres;

        /**
         * Gets the value of the adres property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the adres property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAdres().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AdresTyp }
         * 
         * 
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public List<AdresTyp> getAdres() {
            if (adres == null) {
                adres = new ArrayList<AdresTyp>();
            }
            return this.adres;
        }

    }

}
