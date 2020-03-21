package me.plich.cashregistersystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntrepreneurOutputDto {
    private String imie;
    private String nazwisko;
    private String nip;
    private String regon;
    private String firma;
    private String adresPocztyElektronicznej;
    private String telefon;
    private String ulica;
    private String budynek;
    private String lokal;
    private String kodPocztowy;
    private String miejscowosc;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getAdresPocztyElektronicznej() {
        return adresPocztyElektronicznej;
    }

    public void setAdresPocztyElektronicznej(String adresPocztyElektronicznej) {
        this.adresPocztyElektronicznej = adresPocztyElektronicznej;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBudynek() {
        return budynek;
    }

    public void setBudynek(String budynek) {
        this.budynek = budynek;
    }

    public String getLokal() {
        return lokal;
    }

    public void setLokal(String lokal) {
        this.lokal = lokal;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    @Override
    public String toString() {
        return "EntrepreneurOutputDto{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nip='" + nip + '\'' +
                ", regon='" + regon + '\'' +
                ", firma='" + firma + '\'' +
                ", adresPocztyElektronicznej='" + adresPocztyElektronicznej + '\'' +
                ", telefon='" + telefon + '\'' +
                ", ulica='" + ulica + '\'' +
                ", budynek='" + budynek + '\'' +
                ", lokal='" + lokal + '\'' +
                ", kodPocztowy='" + kodPocztowy + '\'' +
                ", miejscowosc='" + miejscowosc + '\'' +
                '}';
    }
}
