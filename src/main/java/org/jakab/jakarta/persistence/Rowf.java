package org.jakab.jakarta.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "rowf")
public class Rowf {
	
    @Id
    @GeneratedValue
    private Long id;
    
    private String value;

    /**
     * Empty constructor needed for JPA.
     */
    @SuppressWarnings("unused")
    public Rowf() {
    }

    public Rowf(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
