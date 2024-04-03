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

    @DisplayName("Constructor")
    @Nested
    class Constructor {
        @DisplayName("El constructor debe establecer el item")
        @Test
        void Constructor_EstableceItem() {
            String item = "test";
            LinkedNode<String> test = new LinkedNode<String>(item, null, null);

            String result = test.getItem();

            assertEquals(item, result);
        }

        @DisplayName("El constructor debe establecer el nodo anterior")
        @Test
        void Constructor_EstableceNodoAnterior() {
            String itemPrev = "prev";
            String item = "test";
            LinkedNode<String> previous = new LinkedNode<String>(itemPrev, null, null);
            LinkedNode<String> test = new LinkedNode<String>(item, previous, null);

            LinkedNode<String> result = test.getPrevious();

            assertEquals(previous, result);
        }

        @DisplayName("El constructor debe establecer el nodo siguiente")
        @Test
        void Constructor_EstableceNodoSiguiente() {
            String itemNext = "prev";
            String item = "test";
            LinkedNode<String> next = new LinkedNode<String>(itemNext, null, null);
            LinkedNode<String> test = new LinkedNode<String>(item, null, next);

            LinkedNode<String> result = test.getNext();

            assertEquals(next, result);
        }
    }

    @DisplayName("método getItem")
    @Nested
    class getItem {
        @DisplayName("El método getItem debe devolver el item")
        @Test
        void getItem_DevulveItem() {

            String result = node.getItem();

            assertEquals(item, result);

        }
    }

    @DisplayName("método getPrevious")
    @Nested
    class getPrevious {
        @DisplayName("El método getPrevious debe devolver null si no hay previo")
        @Test
        void getPrevious_DevuelveNull() {
            LinkedNode<String> result = node.getPrevious();

            assertNull(result);
        }

        @DisplayName("El método getPrevious debe devolver el nodo anterior")
        @Test
        void getPrevious_DevuelveNodoAnterior() {
            LinkedNode<String> previous = new LinkedNode<String>("previous", null, null);
            LinkedNode<String> test = new LinkedNode<String>("test", previous, null);

            LinkedNode<String> result = test.getPrevious();

            assertEquals(previous, result);
        }

    }

    @DisplayName("método getNext")
    @Nested
    class getNext {
        @DisplayName("El método getNext debe devolver null si no hay siguiente")
        @Test
        void getNext_DevuelveNull() {
            LinkedNode<String> result = node.getNext();

            assertNull(result);
        }

        @DisplayName("El método getNext debe devolver el nodo siguiente")
        @Test
        void getNext_DevuelveNodoSiguiente() {
            LinkedNode<String> next = new LinkedNode<String>("next", null, null);
            LinkedNode<String> test = new LinkedNode<String>("test", null, next);

            LinkedNode<String> result = test.getNext();

            assertEquals(next, result);

        }
    }

    @DisplayName("método setItem")
    @Nested
    class setItem {
        @DisplayName("El método setItem debe establecer el item")
        @Test
        void setItem_EstableceItem() {
            String newItem = "newItem";

            node.setItem(newItem);
            String result = node.getItem();

            assertEquals(newItem, result);
        }
    }

    @DisplayName("método setPrevious")
    @Nested
    class setPrevious {
        @DisplayName("El método setPrevious debe establecer el nodo anterior")
        @Test
        void setPrevious_EstableceNodoAnterior() {
            LinkedNode<String> newPrevious = new LinkedNode<String>("previous", null, null);

            node.setPrevious(newPrevious);

            assertEquals(newPrevious, node.getPrevious());
        }
    }

    @DisplayName("método setNext")
    @Nested
    class setNext {
        @DisplayName("El método setNext debe establecer el nodo siguiente")
        @Test
        void setNext_EstableceNodoSiguiente() {
            LinkedNode<String> newNext = new LinkedNode<String>("next", null, null);

            node.setNext(newNext);

            assertEquals(newNext, node.getNext());
        }
    }

    @DisplayName("método isFirstNode")
    @Nested
    class isFirstNode {
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
    }

    @DisplayName("método isLastNode")
    @Nested
    class isLastNode {
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
    }

    @DisplayName("método isNotATerminalNode")
    @Nested
    class isNotATerminalNode {

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

}
