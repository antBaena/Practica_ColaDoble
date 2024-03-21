/*
@author Antonio Cañete Baena
@author Antonio Blas Moral Sánchez
*/
package deque;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@DisplayName("DoubleLinkedList")
public class DoubleLinkedListTest {

    @Nested
    @DisplayName("cuando esta vacia")
    class emptyDoubleQueue {

        DoubleLinkedQueue<Integer> doubleList;

        @BeforeEach
        public void setUp() {
            doubleList = new DoubleLinkedList<>();
        }

        @DisplayName("El método prepend debe añadir un elemento al principio de la cola")
        @Test
        public void Prepend_ValorValido_AnyadeElementoAlPrincipio() {
            int valor = 1;

            doubleList.prepend(valor);
            int result = doubleList.first();

            assertEquals(valor, result);
        }

        @DisplayName("El método prepend debe lanzar una excepcion si el valor es nulo")
        @Test
        void Prepend_ValorNull_LanzaExcepcion() {

            assertThrows(DoubleLinkedQueueException.class, () -> doubleList.prepend(null));
        }

        @DisplayName("El método append debe añadir un elemento al final de la cola")
        @Test
        void Append_ValorValido_AnyadeElementoAlFinal() {
            int valor = 1;

            doubleList.append(valor);
            int result = doubleList.last();

            assertEquals(valor, result);
        }

        @DisplayName("El método append debe lanzar una excepcion si el valor es nulo")
        @Test
        void Append_ValorNull_LanzaExcepcion() {

            assertThrows(DoubleLinkedQueueException.class, () -> doubleList.append(null));
        }

        @DisplayName("El método deleteFirst debe lanzar una excepcion si la lista esta vacia")
        @Test
        void DeleteFirst_ListaVacia_LanzaExcepcion() {
            assertThrows(DoubleLinkedQueueException.class, () -> doubleList.deleteFirst());
        }

        @DisplayName("El método deleteLast debe lanzar una excepcion si la lista esta vacia")
        @Test
        void DeleteLast_ListaVacia_LanzaExcepcion() {
            assertThrows(DoubleLinkedQueueException.class, () -> doubleList.deleteLast());
        }
    }

    @Nested
    @DisplayName("cuando tiene un elemento")
    class oneElemetDoubleQueue {

        DoubleLinkedQueue<Integer> doubleList;
        int primerElemnto = 1;

        @BeforeEach
        public void setUp() {
            doubleList = new DoubleLinkedList<>();
            doubleList.append(primerElemnto);
        }

    }

    @Nested
    @DisplayName("cuando tiene varios elementos")
    class normalDoubleQueue {

        DoubleLinkedQueue<Integer> doubleList;

        @BeforeEach
        public void setUp() {
            doubleList = new DoubleLinkedList<>();
        }

        @DisplayName("El método prepend debe añadir un elemento al principio de la cola")
        @Test
        public void Prepend_ValorValido_AnyadeElementoAlPrincipio() {
            int valor = 1;

            doubleList.prepend(valor);
            int result = doubleList.first();

            assertEquals(valor, result);
        }

        @DisplayName("El método prepend debe lanzar una excepcion si el valor es nulo")
        @Test
        void Prepend_ValorNull_LanzaExcepcion() {

            assertThrows(DoubleLinkedQueueException.class, () -> doubleList.prepend(null));
        }

        @DisplayName("El método append debe añadir un elemento al final de la cola")
        @Test
        void Append_ValorValido_AnyadeElementoAlFinal() {
            int valor = 1;

            doubleList.append(valor);
            int result = doubleList.last();

            assertEquals(valor, result);
        }

        @DisplayName("El método append debe lanzar una excepcion si el valor es nulo")
        @Test
        void Append_ValorNull_LanzaExcepcion() {

            assertThrows(DoubleLinkedQueueException.class, () -> doubleList.append(null));
        }

        @DisplayName("El método deleteFirst debe lanzar una excepcion si la lista esta vacia")
        @Test
        void DeleteFirst_ListaVacia_LanzaExcepcion() {
            assertThrows(DoubleLinkedQueueException.class, () -> doubleList.deleteFirst());
        }

        @DisplayName("El método deleteLast debe lanzar una excepcion si la lista esta vacia")
        @Test
        void DeleteLast_ListaVacia_LanzaExcepcion() {
            assertThrows(DoubleLinkedQueueException.class, () -> doubleList.deleteLast());
        }
    }

}
