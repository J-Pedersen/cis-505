package Module_6.ComposerApp;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
*/

import java.util.ArrayList;
import java.util.List;

// MemComposerDao Class
public class MemComposerDao implements ComposerDao {
    private List<Composer> composers;

    // No-argument constructor with default composers
    public MemComposerDao() {
        composers = new ArrayList<>(); // Initialize the list of composers
        composers.add(new Composer(1007, "Ludwig Van Beethoven", "Classical"));
        composers.add(new Composer(1008, "Johann Sebastian Bach", "Classical"));
        composers.add(new Composer(1009, "Wolfgang Amadeus Mozart", "Classical"));
        composers.add(new Composer(1010, "Johannes Brahms", "Classical"));
        composers.add(new Composer(1011, "Joseph Haydn", "Classical"));
    }

    @Override
    // findAll method to return all composers
    public List<Composer> findAll() {
        return composers; // Return the list of composers
    } // End findAll method

    @Override
    // findBy method to find a composer by id
    public Composer findBy(Integer id) {
        // Loop through the list of composers to find the one with the given id
        for (Composer composer : composers) {
            // Check if the id matches
            if (composer.getId() == id) {
                return composer; // Return the matching composer
            } // End if
        } // End for loop
        return null; // Return null if no matching composer is found
    } // End findBy method

    @Override
    // insert method to add a new composer
    public void insert(Composer composer) {
        composers.add(composer); // Add the new composer to the list
    } // End insert method
} // End of MemComposerDao class