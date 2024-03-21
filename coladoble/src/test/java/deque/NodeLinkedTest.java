/*
@author Antonio Cañete Baena
@author Antonio Blas Moral Sánchez
*/
package deque;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/*
    @DisplayName("El método <método> debe <devolver|lanzar> cuando <condición>")
        @Test
        void template() {
            node.getItem().equals(item);
    }
 */

@DisplayName("LinkedNode")
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

    @DisplayName("El método getItem debe devolver el item")
    @Test
    void getItem_DevulveItem() {

        String result = node.getItem();

        assertEquals(item, result);

    }

    @DisplayName("El método getPrevious debe devolver null")
    @Test
    void getPrevious_DevuelveNull() {
        LinkedNode<String> result = node.getPrevious();

        assertNull(result);
    }

    @DisplayName("El método getNext debe devolver null")
    @Test
    void getNext_DevuelveNull() {
        LinkedNode<String> result = node.getNext();

        assertNull(result);
    }

    @DisplayName("El método setItem debe establecer el item")
    @Test
    void setItem_EstableceItem() {
        String newItem = "newItem";

        node.setItem(newItem);
        String result = node.getItem();

        assertEquals(newItem, result);
    }

    @DisplayName("El método setPrevious debe establecer el nodo anterior")
    @Test
    void setPrevious_EstableceNodoAnterior() {
        LinkedNode<String> newPrevious = new LinkedNode<String>("previous", null, null);

        node.setPrevious(newPrevious);

        assertEquals(newPrevious, node.getPrevious());
    }

    @DisplayName("El método setNext debe establecer el nodo siguiente")
    @Test
    void setNext_EstableceNodoSiguiente() {
        LinkedNode<String> newNext = new LinkedNode<String>("next", null, null);

        node.setNext(newNext);

        assertEquals(newNext, node.getNext());
    }

    @DisplayName("El método isFirstNode debe devolver false si el nodo no es el primero")
    @Test
    void isFirstNode_DevuelveFalse() {
        LinkedNode<String> newNode = new LinkedNode<String>("new", null, null);
        node.setPrevious(newNode);

        boolean result = node.isFirstNode();

        assertFalse(result);
    }

    @DisplayName("El método isFirstNode debe devolver true si el nodo es el primero")
    @Test
    void isFirstNode_DevuelveTrue() {
        boolean result = node.isFirstNode();

        assertTrue(result);
    }

    @DisplayName("El método isLastNode debe devolver false si el nodo no es el último")
    @Test
    void isLastNode_DevuelveFalse() {
        LinkedNode<String> newNode = new LinkedNode<String>("new", null, null);
        node.setNext(newNode);

        boolean result = node.isLastNode();

        assertFalse(result);
    }

    @DisplayName("El método isLastNode debe devolver true si el nodo es el último")
    @Test
    void isLastNode_DevuelveTrue() {
        boolean result = node.isLastNode();

        assertTrue(result);
    }

    @DisplayName("El método isNotATerminalNode debe devolver true si el nodo no es el primero ni el último")
    @Test
    void isNotATerminalNode_DevuelveTrue() {
        LinkedNode<String> previous = new LinkedNode<String>("previous", null, null);
        LinkedNode<String> next = new LinkedNode<String>("next", null, null);
        LinkedNode<String> node = new LinkedNode<String>("test", previous, next);

        boolean result = node.isNotATerminalNode();

        assertTrue(result);
    }

    @DisplayName("El método isNotATerminalNode debe devolver false si el nodo es el primero")
    @Test
    void isNotATerminalNode_Primero_DevuelveFalse() {
        LinkedNode<String> previous = null;
        LinkedNode<String> next = new LinkedNode<String>("next", null, null);
        LinkedNode<String> node = new LinkedNode<String>("test", previous, next);

        boolean result = node.isNotATerminalNode();

        assertFalse(result);

    }

    @DisplayName("El método isNotATerminalNode debe devolver false si el nodo es el último")
    @Test
    void isNotATerminalNode_Ultimo_DevuelveFalse() {
        LinkedNode<String> previous = new LinkedNode<String>("previous", null, null);
        LinkedNode<String> next = null;
        LinkedNode<String> node = new LinkedNode<String>("test", previous, next);

        boolean result = node.isNotATerminalNode();

        assertFalse(result);

    }

}
