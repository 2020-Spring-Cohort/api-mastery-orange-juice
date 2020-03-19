package org.wcci.apimastery;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Artist {

    private String name;
    private int age;
    private String bio;

    @Id
    @GeneratedValue
    Long id;
    @ManyToOne
    private Medium medium;

    private Collection<SocialMedia> socialMedia;

    public Artist(){}

    public Artist(String name, int age, String bio, Medium medium){
        this.name = name;
        this.age = age;
        this.bio = bio;
        this.medium = medium;
    }

    public String getName() {
        return name;
    }

    public Long getId(){
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getBio() {
        return bio;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return age == artist.age &&
                Objects.equals(name, artist.name) &&
                Objects.equals(bio, artist.bio) &&
                Objects.equals(id, artist.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, bio, id);
    }

    public Medium getMedium() {
        return medium;
    }

    public Collection<SocialMedia> getSocialMedia() {
        return socialMedia;
    }
}
