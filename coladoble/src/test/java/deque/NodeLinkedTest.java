/*
@author Antonio Cañete Baena
@author Antonio Blas Moral Sánchez
*/
package deque;

import org.junit.jupiter.api.*;

public class NodeLinkedTest {

    LinkedNode<String> node;
    LinkedNode<String> previous;
    LinkedNode<String> next;
    String item;

    @BeforeEach
    void setUp() {
        previous = null;
        next = null;
        item = "test";
        node = new LinkedNode<String>(item, previous, next);
    }

    @DisplayName("El método <método> debe <devolver|lanzar> cuando <condición>")
    @Test
    void template() {
        node.getItem().equals(item);
    }

}
