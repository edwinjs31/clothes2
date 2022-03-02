package com.albares.clothes.db;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author Edwin Jaldin S.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Brand {

    private Integer id;
    private String name;
    private String origin;

    public Brand() {
    }

    public Brand(Integer id) {
        this.id = id;
    }

    public Brand(String name, String origin) {
        this.name = name;
        this.origin = origin;
    }
    

    public Brand(Integer id, String name, String origin) {
        this.id = id;
        this.name = name;
        this.origin = origin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

}
