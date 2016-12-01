
package br.com.mack.valueobjects;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Student {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("about")
    @Expose
    private Object about;
    @SerializedName("concept")
    @Expose
    private StudentConcept concept;
    @SerializedName("picture")
    @Expose
    private String picture;

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
     *     The about
     */
    public Object getAbout() {
        return about;
    }

    /**
     * 
     * @param about
     *     The about
     */
    public void setAbout(Object about) {
        this.about = about;
    }

    /**
     * 
     * @return
     *     The concept
     */
    public StudentConcept getConcept() {
        return concept;
    }

    /**
     * 
     * @param concept
     *     The concept
     */
    public void setConcept(StudentConcept concept) {
        this.concept = concept;
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

}
