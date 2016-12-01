
package br.com.mack.valueobjects;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Recipe {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("servings")
    @Expose
    private Integer servings;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("concept")
    @Expose
    private Concept concept;
    @SerializedName("recipePhotos")
    @Expose
    private List<Object> recipePhotos = new ArrayList<Object>();
    @SerializedName("methods")
    @Expose
    private List<Method> methods = new ArrayList<Method>();
    @SerializedName("ingredients")
    @Expose
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();
    @SerializedName("owner")
    @Expose
    private Owner owner;

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
     *     The kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * 
     * @param kind
     *     The kind
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * 
     * @return
     *     The duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * 
     * @param duration
     *     The duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * 
     * @return
     *     The servings
     */
    public Integer getServings() {
        return servings;
    }

    /**
     * 
     * @param servings
     *     The servings
     */
    public void setServings(Integer servings) {
        this.servings = servings;
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
     *     The concept
     */
    public Concept getConcept() {
        return concept;
    }

    /**
     * 
     * @param concept
     *     The concept
     */
    public void setConcept(Concept concept) {
        this.concept = concept;
    }

    /**
     * 
     * @return
     *     The recipePhotos
     */
    public List<Object> getRecipePhotos() {
        return recipePhotos;
    }

    /**
     * 
     * @param recipePhotos
     *     The recipePhotos
     */
    public void setRecipePhotos(List<Object> recipePhotos) {
        this.recipePhotos = recipePhotos;
    }

    /**
     * 
     * @return
     *     The methods
     */
    public List<Method> getMethods() {
        return methods;
    }

    /**
     * 
     * @param methods
     *     The methods
     */
    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }

    /**
     * 
     * @return
     *     The ingredients
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * 
     * @param ingredients
     *     The ingredients
     */
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * 
     * @return
     *     The owner
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * 
     * @param owner
     *     The owner
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

}
