package org.wcci.apimastery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Medium {

    private String type;

    @Id
    @GeneratedValue
    Long id;

    public Medium(){}

    public Medium(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Long getId() {
        return id;
    }
}
