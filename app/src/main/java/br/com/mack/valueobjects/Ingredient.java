
package br.com.mack.valueobjects;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Ingredient {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("ingredient")
    @Expose
    private String ingredient;

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
     *     The ingredient
     */
    public String getIngredient() {
        return ingredient;
    }

    /**
     * 
     * @param ingredient
     *     The ingredient
     */
    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

}
