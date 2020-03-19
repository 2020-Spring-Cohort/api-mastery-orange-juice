package org.wcci.apimastery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAWiringTest {

    @Autowired
    private ArtistRepository artistRepo;
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private MediumRepository mediumRepo;

    private Artist artist;
    private Medium testMedium;


    @BeforeEach
    public void setUp(){
        testMedium = new Medium("Test Medium");

        artist = new Artist("TestArtist", 2, "testBio", testMedium);
        mediumRepo.save(testMedium);
        artistRepo.save(artist);
        entityManager.flush();
        entityManager.clear();
    }

    @Test
    public void artistShouldHaveInfo(){
        String retrievedName = artist.getName();
        int retrievedAge = artist.getAge();
        String retrievedBio = artist.getBio();
        assertThat(retrievedName).isEqualTo("TestArtist");
        assertThat(retrievedAge).isEqualTo(2);
        assertThat(retrievedBio).isEqualTo("testBio");
    }

    @Test
    public void shouldFindArtistByName(){


        Artist retrievedArtist = artistRepo.findByName("TestArtist");
        assertThat(retrievedArtist).isEqualTo(artist);
    }

    @Test
    public void artistShouldHaveMedium(){

        assertThat(artist.getMedium()).isEqualTo(testMedium);
    }

    @Test
    public void mediumShouldHaveListOfArtists(){
        Medium retrievedMedium = mediumRepo.findById(testMedium.getId()).get();
        Collection<Artist> retrievedArtists = retrievedMedium.getArtists();
        assertThat(retrievedArtists).contains(artist);
    }

    @Test
    public void artistShouldHaveSocialMedia(){
        Artist retrievedArtist = artistRepo.findByName("Test Artist");
        assertThat(retrievedArtist.getSocialMedia()).contains
    }


}
