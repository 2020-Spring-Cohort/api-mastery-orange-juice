package org.wcci.apimastery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAWiringTest {

    @Autowired
    private ArtistRepository artistRepo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void artistShouldHaveInfo(){
        Artist artist = new Artist("TestArtist", 2, "testBio");
        String retrievedName = artist.getName();
        int retrievedAge = artist.getAge();
        String retrievedBio = artist.getBio();
        assertThat(retrievedName).isEqualTo("TestArtist");
        assertThat(retrievedAge).isEqualTo(2);
        assertThat(retrievedBio).isEqualTo("testBio");
    }

    @Test
    public void shouldFindArtistByName(){
        Artist artist = new Artist("testArtist", 2, "testBio");
        artistRepo.save(artist);

        entityManager.flush();
        entityManager.clear();

        Artist retrievedArtist = artistRepo.findByName("testArtist");
        assertThat(retrievedArtist).isEqualTo(artist);
    }

}
