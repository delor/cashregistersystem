package me.plich.cashregistersystem.model;

public class EntrepreneurOutput {

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

    public String getNazwisko() {
        return nazwisko;
    }

    public String getNip() {
        return nip;
    }

    public String getRegon() {
        return regon;
    }

    public String getFirma() {
        return firma;
    }

    public String getAdresPocztyElektronicznej() {
        return adresPocztyElektronicznej;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getUlica() {
        return ulica;
    }

    public String getBudynek() {
        return budynek;
    }

    public String getLokal() {
        return lokal;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    private EntrepreneurOutput(Builder builder) {
        this.imie = builder.imie;
        this.nazwisko = builder.nazwisko;
        this.nip = builder.nip;
        this.regon = builder.regon;
        this.firma = builder.firma;
        this.adresPocztyElektronicznej = builder.adresPocztyElektronicznej;
        this.telefon = builder.telefon;
        this.ulica = builder.ulica;
        this.budynek = builder.budynek;
        this.lokal = builder.lokal;
        this.kodPocztowy = builder.kodPocztowy;
        this.miejscowosc = builder.miejscowosc;
    }

    public static Builder newEntrepreneurOutput() {
        return new Builder();
    }


    public static final class Builder {
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

        private Builder() {
        }

        public EntrepreneurOutput build() {
            return new EntrepreneurOutput(this);
        }

        public Builder imie(String imie) {
            this.imie = imie;
            return this;
        }

        public Builder nazwisko(String nazwisko) {
            this.nazwisko = nazwisko;
            return this;
        }

        public Builder nip(String nip) {
            this.nip = nip;
            return this;
        }

        public Builder regon(String regon) {
            this.regon = regon;
            return this;
        }

        public Builder firma(String firma) {
            this.firma = firma;
            return this;
        }

        public Builder adresPocztyElektronicznej(String adresPocztyElektronicznej) {
            this.adresPocztyElektronicznej = adresPocztyElektronicznej;
            return this;
        }

        public Builder telefon(String telefon) {
            this.telefon = telefon;
            return this;
        }

        public Builder ulica(String ulica) {
            this.ulica = ulica;
            return this;
        }

        public Builder budynek(String budynek) {
            this.budynek = budynek;
            return this;
        }

        public Builder lokal(String lokal) {
            this.lokal = lokal;
            return this;
        }

        public Builder kodPocztowy(String kodPocztowy) {
            this.kodPocztowy = kodPocztowy;
            return this;
        }

        public Builder miejscowosc(String miejscowosc) {
            this.miejscowosc = miejscowosc;
            return this;
        }
    }

    @Override
    public String toString() {
        return "EntrepreneurOutput{" +
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
