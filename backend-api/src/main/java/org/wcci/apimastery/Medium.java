package org.wcci.apimastery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Medium {

    private String type;

    @Id
    @GeneratedValue
    Long id;

    public Medium(){}

    @OneToMany(mappedBy = "medium")
    private Collection<Artist> artists;

    public Medium(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Long getId() {
        return id;
    }

    public Collection<Artist> getArtists() {
        return artists;
    }
}
