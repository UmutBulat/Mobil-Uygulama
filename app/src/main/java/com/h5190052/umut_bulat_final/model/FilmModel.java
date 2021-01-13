package com.h5190052.umut_bulat_final.model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilmModel {

    @SerializedName(" FilmAdi ")
    @Expose
    private String filmAdi;
    @SerializedName(" CikisYili ")
    @Expose
    private String cikisYili;
    @SerializedName(" BasrolAdi ")
    @Expose
    private String basrolAdi;
    @SerializedName(" LogoUrl ")
    @Expose
    private String logoUrl;
    @SerializedName(" KapakUrl ")
    @Expose
    private String kapakUrl;
    @SerializedName(" Aciklama ")
    @Expose
    private String aciklama;
    @SerializedName(" ImdbPuani ")
    @Expose
    private String imdbPuani;

    /**
     * No args constructor for use in serialization
     *
     */
    public FilmModel() {
    }

    /**
     *
     * @param aciklama
     * @param cikisYili
     * @param kapakUrl
     * @param basrolAdi
     * @param imdbPuani
     * @param filmAdi
     * @param logoUrl
     */
    public FilmModel(String filmAdi, String cikisYili, String basrolAdi, String logoUrl, String kapakUrl, String aciklama, String imdbPuani) {
        super();
        this.filmAdi = filmAdi;
        this.cikisYili = cikisYili;
        this.basrolAdi = basrolAdi;
        this.logoUrl = logoUrl;
        this.kapakUrl = kapakUrl;
        this.aciklama = aciklama;
        this.imdbPuani = imdbPuani;
    }

    public String getFilmAdi() {
        return filmAdi;
    }

    public void setFilmAdi(String filmAdi) {
        this.filmAdi = filmAdi;
    }

    public String getCikisYili() {
        return cikisYili;
    }

    public void setCikisYili(String cikisYili) {
        this.cikisYili = cikisYili;
    }

    public String getBasrolAdi() {
        return basrolAdi;
    }

    public void setBasrolAdi(String basrolAdi) {
        this.basrolAdi = basrolAdi;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getKapakUrl() {
        return kapakUrl;
    }

    public void setKapakUrl(String kapakUrl) {
        this.kapakUrl = kapakUrl;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getImdbPuani() {
        return imdbPuani;
    }

    public void setImdbPuani(String imdbPuani) {
        this.imdbPuani = imdbPuani;
    }

}