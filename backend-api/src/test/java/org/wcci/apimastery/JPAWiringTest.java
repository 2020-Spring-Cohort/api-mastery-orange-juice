package org.wcci.apimastery;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JPAWiringTest {

    @Test
    public void artistShouldHaveAName(){
        Artist artist = new Artist("TestArtist");
        String retrievedName = artist.getName();
        assertThat(retrievedName).isEqualTo("TestArtist");
;    }
}
