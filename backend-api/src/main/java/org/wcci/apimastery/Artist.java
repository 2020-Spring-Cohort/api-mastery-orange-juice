package org.wcci.apimastery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Artist {

    private String name;

    @Id
    @GeneratedValue
    Long id;

    public Artist(){}

    public Artist(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId(){
        return id;
    }
}
