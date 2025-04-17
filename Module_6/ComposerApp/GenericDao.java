package Module_6.ComposerApp;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
*/

import java.util.List;

// GenericDao Interface
public interface GenericDao<E, K> {
    List<E> findAll(); // Returns a list of all entities
    E findBy(K key); // Finds an entity by its key
    void insert(E entity); // Inserts a new entity
} // End of GenericDao interface