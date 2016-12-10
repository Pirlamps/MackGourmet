
package br.com.mack.valueobjects;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class Method implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("step")
    @Expose
    private Integer step;
    @SerializedName("description")
    @Expose
    private String description;

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
     *     The step
     */
    public Integer getStep() {
        return step;
    }

    /**
     * 
     * @param step
     *     The step
     */
    public void setStep(Integer step) {
        this.step = step;
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

}
