
package br.com.mack.valueobjects;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Restaurant {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("instagram_url")
    @Expose
    private String instagramUrl;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("neighborhood")
    @Expose
    private String neighborhood;
    @SerializedName("priceAvarage")
    @Expose
    private Object priceAvarage;
    @SerializedName("coordinates")
    @Expose
    private List<Double> coordinates = new ArrayList<Double>();
    @SerializedName("concept")
    @Expose
    private RestaurantConcept concept;
    @SerializedName("chef")
    @Expose
    private RestaurantChef chef;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The instagramUrl
     */
    public String getInstagramUrl() {
        return instagramUrl;
    }

    /**
     * 
     * @param instagramUrl
     *     The instagram_url
     */
    public void setInstagramUrl(String instagramUrl) {
        this.instagramUrl = instagramUrl;
    }

    /**
     * 
     * @return
     *     The picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 
     * @param picture
     *     The picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * 
     * @return
     *     The address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 
     * @return
     *     The neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * 
     * @param neighborhood
     *     The neighborhood
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * 
     * @return
     *     The priceAvarage
     */
    public Object getPriceAvarage() {
        return priceAvarage;
    }

    /**
     * 
     * @param priceAvarage
     *     The priceAvarage
     */
    public void setPriceAvarage(Object priceAvarage) {
        this.priceAvarage = priceAvarage;
    }

    /**
     * 
     * @return
     *     The coordinates
     */
    public List<Double> getCoordinates() {
        return coordinates;
    }

    /**
     * 
     * @param coordinates
     *     The coordinates
     */
    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * 
     * @return
     *     The concept
     */
    public RestaurantConcept getConcept() {
        return concept;
    }

    /**
     * 
     * @param concept
     *     The concept
     */
    public void setConcept(RestaurantConcept concept) {
        this.concept = concept;
    }

    /**
     * 
     * @return
     *     The chef
     */
    public RestaurantChef getChef() {
        return chef;
    }

    /**
     * 
     * @param chef
     *     The chef
     */
    public void setChef(RestaurantChef chef) {
        this.chef = chef;
    }

}
