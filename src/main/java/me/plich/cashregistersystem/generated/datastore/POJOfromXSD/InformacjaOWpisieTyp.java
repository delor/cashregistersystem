
package me.plich.cashregistersystem.generated.datastore.POJOfromXSD;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InformacjaOWpisieTyp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InformacjaOWpisieTyp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdentyfikatorWpisu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DanePodstawowe" type="{}DanePodstawoweTyp"/>
 *         &lt;element name="DaneKontaktowe" type="{}DaneKontaktoweTyp"/>
 *         &lt;element name="DodatkowaInformacjaoNIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DaneAdresowe" type="{}DaneAdresoweTyp"/>
 *         &lt;element name="DaneDodatkowe" type="{}DaneDodatkoweTyp"/>
 *         &lt;element name="SpolkiCywilneKtorychWspolnikiemJestPrzedsiebiorca" type="{}SpolkiCywilneKtorychWspolnikiemJestPrzedsiebiorcaTyp"/>
 *         &lt;element name="Zakazy" type="{}ZakazyTyp"/>
 *         &lt;element name="InformacjeDotyczaceUpadlosciPostepowaniaNaprawczego" type="{}InformacjeDotyczaceUpadlosciPostepowaniaNaprawczegoTyp"/>
 *         &lt;element name="Uprawnienia" type="{}UprawnieniaTyp" minOccurs="0"/>
 *         &lt;element name="Ograniczenia" type="{}OgraniczeniaTyp" minOccurs="0"/>
 *         &lt;element name="DataZgonu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Sukcesja" type="{}SukcesjaTyp"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InformacjaOWpisieTyp", propOrder = {
    "identyfikatorWpisu",
    "danePodstawowe",
    "daneKontaktowe",
    "dodatkowaInformacjaoNIP",
    "daneAdresowe",
    "daneDodatkowe",
    "spolkiCywilneKtorychWspolnikiemJestPrzedsiebiorca",
    "zakazy",
    "informacjeDotyczaceUpadlosciPostepowaniaNaprawczego",
    "uprawnienia",
    "ograniczenia",
    "dataZgonu",
    "sukcesja"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class InformacjaOWpisieTyp {

    @XmlElement(name = "IdentyfikatorWpisu", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String identyfikatorWpisu;
    @XmlElement(name = "DanePodstawowe", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DanePodstawoweTyp danePodstawowe;
    @XmlElement(name = "DaneKontaktowe", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DaneKontaktoweTyp daneKontaktowe;
    @XmlElement(name = "DodatkowaInformacjaoNIP")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String dodatkowaInformacjaoNIP;
    @XmlElement(name = "DaneAdresowe", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DaneAdresoweTyp daneAdresowe;
    @XmlElement(name = "DaneDodatkowe", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DaneDodatkoweTyp daneDodatkowe;
    @XmlElement(name = "SpolkiCywilneKtorychWspolnikiemJestPrzedsiebiorca", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected SpolkiCywilneKtorychWspolnikiemJestPrzedsiebiorcaTyp spolkiCywilneKtorychWspolnikiemJestPrzedsiebiorca;
    @XmlElement(name = "Zakazy", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected ZakazyTyp zakazy;
    @XmlElement(name = "InformacjeDotyczaceUpadlosciPostepowaniaNaprawczego", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected InformacjeDotyczaceUpadlosciPostepowaniaNaprawczegoTyp informacjeDotyczaceUpadlosciPostepowaniaNaprawczego;
    @XmlElement(name = "Uprawnienia")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected UprawnieniaTyp uprawnienia;
    @XmlElement(name = "Ograniczenia")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected OgraniczeniaTyp ograniczenia;
    @XmlElement(name = "DataZgonu", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String dataZgonu;
    @XmlElement(name = "Sukcesja", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected SukcesjaTyp sukcesja;

    /**
     * Gets the value of the identyfikatorWpisu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getIdentyfikatorWpisu() {
        return identyfikatorWpisu;
    }

    /**
     * Sets the value of the identyfikatorWpisu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setIdentyfikatorWpisu(String value) {
        this.identyfikatorWpisu = value;
    }

    /**
     * Gets the value of the danePodstawowe property.
     * 
     * @return
     *     possible object is
     *     {@link DanePodstawoweTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DanePodstawoweTyp getDanePodstawowe() {
        return danePodstawowe;
    }

    /**
     * Sets the value of the danePodstawowe property.
     * 
     * @param value
     *     allowed object is
     *     {@link DanePodstawoweTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setDanePodstawowe(DanePodstawoweTyp value) {
        this.danePodstawowe = value;
    }

    /**
     * Gets the value of the daneKontaktowe property.
     * 
     * @return
     *     possible object is
     *     {@link DaneKontaktoweTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DaneKontaktoweTyp getDaneKontaktowe() {
        return daneKontaktowe;
    }

    /**
     * Sets the value of the daneKontaktowe property.
     * 
     * @param value
     *     allowed object is
     *     {@link DaneKontaktoweTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setDaneKontaktowe(DaneKontaktoweTyp value) {
        this.daneKontaktowe = value;
    }

    /**
     * Gets the value of the dodatkowaInformacjaoNIP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getDodatkowaInformacjaoNIP() {
        return dodatkowaInformacjaoNIP;
    }

    /**
     * Sets the value of the dodatkowaInformacjaoNIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setDodatkowaInformacjaoNIP(String value) {
        this.dodatkowaInformacjaoNIP = value;
    }

    /**
     * Gets the value of the daneAdresowe property.
     * 
     * @return
     *     possible object is
     *     {@link DaneAdresoweTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DaneAdresoweTyp getDaneAdresowe() {
        return daneAdresowe;
    }

    /**
     * Sets the value of the daneAdresowe property.
     * 
     * @param value
     *     allowed object is
     *     {@link DaneAdresoweTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setDaneAdresowe(DaneAdresoweTyp value) {
        this.daneAdresowe = value;
    }

    /**
     * Gets the value of the daneDodatkowe property.
     * 
     * @return
     *     possible object is
     *     {@link DaneDodatkoweTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DaneDodatkoweTyp getDaneDodatkowe() {
        return daneDodatkowe;
    }

    /**
     * Sets the value of the daneDodatkowe property.
     * 
     * @param value
     *     allowed object is
     *     {@link DaneDodatkoweTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setDaneDodatkowe(DaneDodatkoweTyp value) {
        this.daneDodatkowe = value;
    }

    /**
     * Gets the value of the spolkiCywilneKtorychWspolnikiemJestPrzedsiebiorca property.
     * 
     * @return
     *     possible object is
     *     {@link SpolkiCywilneKtorychWspolnikiemJestPrzedsiebiorcaTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public SpolkiCywilneKtorychWspolnikiemJestPrzedsiebiorcaTyp getSpolkiCywilneKtorychWspolnikiemJestPrzedsiebiorca() {
        return spolkiCywilneKtorychWspolnikiemJestPrzedsiebiorca;
    }

    /**
     * Sets the value of the spolkiCywilneKtorychWspolnikiemJestPrzedsiebiorca property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpolkiCywilneKtorychWspolnikiemJestPrzedsiebiorcaTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setSpolkiCywilneKtorychWspolnikiemJestPrzedsiebiorca(SpolkiCywilneKtorychWspolnikiemJestPrzedsiebiorcaTyp value) {
        this.spolkiCywilneKtorychWspolnikiemJestPrzedsiebiorca = value;
    }

    /**
     * Gets the value of the zakazy property.
     * 
     * @return
     *     possible object is
     *     {@link ZakazyTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public ZakazyTyp getZakazy() {
        return zakazy;
    }

    /**
     * Sets the value of the zakazy property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZakazyTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setZakazy(ZakazyTyp value) {
        this.zakazy = value;
    }

    /**
     * Gets the value of the informacjeDotyczaceUpadlosciPostepowaniaNaprawczego property.
     * 
     * @return
     *     possible object is
     *     {@link InformacjeDotyczaceUpadlosciPostepowaniaNaprawczegoTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public InformacjeDotyczaceUpadlosciPostepowaniaNaprawczegoTyp getInformacjeDotyczaceUpadlosciPostepowaniaNaprawczego() {
        return informacjeDotyczaceUpadlosciPostepowaniaNaprawczego;
    }

    /**
     * Sets the value of the informacjeDotyczaceUpadlosciPostepowaniaNaprawczego property.
     * 
     * @param value
     *     allowed object is
     *     {@link InformacjeDotyczaceUpadlosciPostepowaniaNaprawczegoTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setInformacjeDotyczaceUpadlosciPostepowaniaNaprawczego(InformacjeDotyczaceUpadlosciPostepowaniaNaprawczegoTyp value) {
        this.informacjeDotyczaceUpadlosciPostepowaniaNaprawczego = value;
    }

    /**
     * Gets the value of the uprawnienia property.
     * 
     * @return
     *     possible object is
     *     {@link UprawnieniaTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public UprawnieniaTyp getUprawnienia() {
        return uprawnienia;
    }

    /**
     * Sets the value of the uprawnienia property.
     * 
     * @param value
     *     allowed object is
     *     {@link UprawnieniaTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setUprawnienia(UprawnieniaTyp value) {
        this.uprawnienia = value;
    }

    /**
     * Gets the value of the ograniczenia property.
     * 
     * @return
     *     possible object is
     *     {@link OgraniczeniaTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public OgraniczeniaTyp getOgraniczenia() {
        return ograniczenia;
    }

    /**
     * Sets the value of the ograniczenia property.
     * 
     * @param value
     *     allowed object is
     *     {@link OgraniczeniaTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setOgraniczenia(OgraniczeniaTyp value) {
        this.ograniczenia = value;
    }

    /**
     * Gets the value of the dataZgonu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getDataZgonu() {
        return dataZgonu;
    }

    /**
     * Sets the value of the dataZgonu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setDataZgonu(String value) {
        this.dataZgonu = value;
    }

    /**
     * Gets the value of the sukcesja property.
     * 
     * @return
     *     possible object is
     *     {@link SukcesjaTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public SukcesjaTyp getSukcesja() {
        return sukcesja;
    }

    /**
     * Sets the value of the sukcesja property.
     * 
     * @param value
     *     allowed object is
     *     {@link SukcesjaTyp }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-03-21T12:38:11+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setSukcesja(SukcesjaTyp value) {
        this.sukcesja = value;
    }

}
