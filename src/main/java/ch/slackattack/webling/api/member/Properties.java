package ch.slackattack.webling.api.member;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Mitglieder ID",
        "Vorname",
        "Name",
        "Strasse",
        "PLZ",
        "Ort",
        "Land",
        "E-Mail",
        "Telefon",
        "Mobile",
        "IBAN",
        "Anrede",
        "Geschlecht",
        "Geburtstag",
        "Mitgliederbild",
        "Status",
        "Funktion",
        "Bemerkungen",
        "Eintrittsdatum",
        "E-Mail 2",
        "Organisation",
        "Kleidergr\u00f6sse (T-shirt)",
        "Austrittsdatum",
        "Prefered Language / Bevorzugte Sprache"
})

public class Properties {
    @JsonProperty("Mitglieder ID")
    private int mitgliederID;
    @JsonProperty("Vorname")
    private String vorname;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Strasse")
    private Object strasse;
    @JsonProperty("PLZ")
    private Object plz;
    @JsonProperty("Ort")
    private Object ort;
    @JsonProperty("Land")
    private Object land;
    @JsonProperty("E-Mail")
    private String eMail;
    @JsonProperty("Telefon")
    private Object telefon;
    @JsonProperty("Mobile")
    private Object mobile;
    @JsonProperty("IBAN")
    private Object iban;
    @JsonProperty("Anrede")
    private Object anrede;
    @JsonProperty("Geschlecht")
    private Object geschlecht;
    @JsonProperty("Geburtstag")
    private Object geburtstag;
    @JsonProperty("Mitgliederbild")
    private Object mitgliederbild;
    @JsonProperty("Status")
    private Object status;
    @JsonProperty("Funktion")
    private Object funktion;
    @JsonProperty("Bemerkungen")
    private Object bemerkungen;
    @JsonProperty("Eintrittsdatum")
    private String eintrittsdatum;
    @JsonProperty("E-Mail 2")
    private Object eMail2;
    @JsonProperty("Organisation")
    private Object organisation;
    @JsonProperty("Kleidergr\u00f6sse (T-shirt)")
    private Object kleidergrSse;
    @JsonProperty("Austrittsdatum")
    private Object austrittsdatum;
    @JsonProperty("Prefered Language / Bevorzugte Sprache")
    private Object sprache;

    @JsonProperty("Mitglieder ID")
    public int getMitgliederID() {
        return mitgliederID;
    }

    @JsonProperty("Mitglieder ID")
    public void setMitgliederID(int mitgliederID) {
        this.mitgliederID = mitgliederID;
    }

    @JsonProperty("Vorname")
    public String getVorname() {
        return vorname;
    }

    @JsonProperty("Vorname")
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Strasse")
    public Object getStrasse() {
        return strasse;
    }

    @JsonProperty("Strasse")
    public void setStrasse(Object strasse) {
        this.strasse = strasse;
    }

    @JsonProperty("PLZ")
    public Object getPlz() {
        return plz;
    }

    @JsonProperty("PLZ")
    public void setPlz(Object plz) {
        this.plz = plz;
    }

    @JsonProperty("Ort")
    public Object getOrt() {
        return ort;
    }

    @JsonProperty("Ort")
    public void setOrt(Object ort) {
        this.ort = ort;
    }

    @JsonProperty("Land")
    public Object getLand() {
        return land;
    }

    @JsonProperty("Land")
    public void setLand(Object land) {
        this.land = land;
    }

    @JsonProperty("E-Mail")
    public String getEMail() {
        return eMail;
    }

    @JsonProperty("E-Mail")
    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    @JsonProperty("Telefon")
    public Object getTelefon() {
        return telefon;
    }

    @JsonProperty("Telefon")
    public void setTelefon(Object telefon) {
        this.telefon = telefon;
    }

    @JsonProperty("Mobile")
    public Object getMobile() {
        return mobile;
    }

    @JsonProperty("Mobile")
    public void setMobile(Object mobile) {
        this.mobile = mobile;
    }

    @JsonProperty("IBAN")
    public Object getIban() {
        return iban;
    }

    @JsonProperty("IBAN")
    public void setIban(Object iban) {
        this.iban = iban;
    }

    @JsonProperty("Anrede")
    public Object getAnrede() {
        return anrede;
    }

    @JsonProperty("Anrede")
    public void setAnrede(Object anrede) {
        this.anrede = anrede;
    }

    @JsonProperty("Geschlecht")
    public Object getGeschlecht() {
        return geschlecht;
    }

    @JsonProperty("Geschlecht")
    public void setGeschlecht(Object geschlecht) {
        this.geschlecht = geschlecht;
    }

    @JsonProperty("Geburtstag")
    public Object getGeburtstag() {
        return geburtstag;
    }

    @JsonProperty("Geburtstag")
    public void setGeburtstag(Object geburtstag) {
        this.geburtstag = geburtstag;
    }

    @JsonProperty("Mitgliederbild")
    public Object getMitgliederbild() {
        return mitgliederbild;
    }

    @JsonProperty("Mitgliederbild")
    public void setMitgliederbild(Object mitgliederbild) {
        this.mitgliederbild = mitgliederbild;
    }

    @JsonProperty("Status")
    public Object getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(Object status) {
        this.status = status;
    }

    @JsonProperty("Funktion")
    public Object getFunktion() {
        return funktion;
    }

    @JsonProperty("Funktion")
    public void setFunktion(Object funktion) {
        this.funktion = funktion;
    }

    @JsonProperty("Bemerkungen")
    public Object getBemerkungen() {
        return bemerkungen;
    }

    @JsonProperty("Bemerkungen")
    public void setBemerkungen(Object bemerkungen) {
        this.bemerkungen = bemerkungen;
    }

    @JsonProperty("Eintrittsdatum")
    public String getEintrittsdatum() {
        return eintrittsdatum;
    }

    @JsonProperty("Eintrittsdatum")
    public void setEintrittsdatum(String eintrittsdatum) {
        this.eintrittsdatum = eintrittsdatum;
    }

    @JsonProperty("E-Mail 2")
    public Object getEMail2() {
        return eMail2;
    }

    @JsonProperty("E-Mail 2")
    public void setEMail2(Object eMail2) {
        this.eMail2 = eMail2;
    }

    @JsonProperty("Organisation")
    public Object getOrganisation() {
        return organisation;
    }

    @JsonProperty("Organisation")
    public void setOrganisation(Object organisation) {
        this.organisation = organisation;
    }

    @JsonProperty("Kleidergr\u00f6sse (T-shirt)")
    public Object getKleidergrSse() {
        return kleidergrSse;
    }

    @JsonProperty("Kleidergr\u00f6sse (T-shirt)")
    public void setKleidergrSse(Object kleidergrSse) {
        this.kleidergrSse = kleidergrSse;
    }

    @JsonProperty("Austrittsdatum")
    public Object getAustrittsdatum() {
        return austrittsdatum;
    }

    @JsonProperty("Austrittsdatum")
    public void setAustrittsdatum(Object austrittsdatum) {
        this.austrittsdatum = austrittsdatum;
    }

    @JsonProperty("Prefered Language / Bevorzugte Sprache")
    public Object getSprache() {
        return sprache;
    }

    @JsonProperty("Prefered Language / Bevorzugte Sprache")
    public void setSprache(Object sprache) {
        this.sprache = sprache;
    }
}