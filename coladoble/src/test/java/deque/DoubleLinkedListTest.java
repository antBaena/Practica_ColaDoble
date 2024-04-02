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
    @DisplayName("metodo prepend")
    class prepend {

        @DisplayName("El método prepend debe añadir un elemento al principio de la cola si esta vacia")
        @Test
        public void Prepend_ValorValido_AnyadeElementoAlPrincipio() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            int valor = 1;

            doubleList.prepend(valor);
            int result = doubleList.first();

            assertEquals(valor, result);
        }

        @DisplayName("El método prepend debe insertar un elemento al principio de la cola y mover el anterior primer elemento")
        @Test
        public void Prepend_ValorValido_InsertaElementoAlPrincipio() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            int valor1 = 1;
            int valor2 = 2;
            doubleList.prepend(valor1);
            doubleList.prepend(valor2);
            int result = doubleList.first();

            assertEquals(valor2, result);
        }

        @DisplayName("El método prepend debe desplazar el anterior primer elemento al la segundo posicion")
        @Test
        public void Prepend_ValorValido_DesplazaElementoAlPrincipio() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            int valor1 = 1;
            int valor2 = 2;
            doubleList.prepend(valor1);
            doubleList.prepend(valor2);
            int result = doubleList.last();

            assertEquals(valor1, result);
        }

        @DisplayName("El método prepend debe lanzar una excepcion si el valor es nulo")
        @Test
        void Prepend_ValorNull_LanzaExcepcion() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();

            assertThrows(DoubleLinkedQueueException.class, () -> doubleList.prepend(null));
        }

    }

    @Nested
    @DisplayName("metodo append")
    class append {
        @DisplayName("El método append debe añadir un elemento al final de la cola si la lista esta vacia")
        @Test
        void Append_ValorValido_AnyadeElementoAlFinal() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            int valor = 1;

            doubleList.append(valor);
            int result = doubleList.last();

            assertEquals(valor, result);
        }

        @DisplayName("El método prepend debe insertar un elemento al final de la cola y mover el anterior ultimo elemento")
        @Test
        public void Prepend_ValorValido_InsertaElementoAlPrincipio() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            int valor1 = 1;
            int valor2 = 2;
            doubleList.append(valor1);
            doubleList.append(valor2);
            int result = doubleList.last();

            assertEquals(valor2, result);
        }

        @DisplayName("El método prepend debe desplazar el anterior ultimo elemento al la segundo posicion anterior")
        @Test
        public void Prepend_ValorValido_DesplazaElementoAlPrincipio() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            int valor1 = 1;
            int valor2 = 2;
            doubleList.append(valor1);
            doubleList.append(valor2);
            int result = doubleList.first();

            assertEquals(valor1, result);
        }

        @DisplayName("El método append debe lanzar una excepcion si el valor es nulo")
        @Test
        void Append_ValorNull_LanzaExcepcion() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();

            assertThrows(DoubleLinkedQueueException.class, () -> doubleList.append(null));
        }

    }

    @Nested
    @DisplayName("metodo deleteFirst")
    class deleteFirst {
        @DisplayName("El método deleteFirst debe eliminar el primer elemento de la cola si la lista tiene un solo elemento")
        @Test
        void DeleteFirst_ListaConUnElemento_EliminaElemento() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            int valor = 1;
            doubleList.append(valor);

            doubleList.deleteFirst();

            assertThrows(DoubleLinkedQueueException.class, () -> doubleList.first());
        }

        @DisplayName("El método deleteFirst debe eliminar el primer elemento de la cola si la lista tiene varios elementos")
        @Test
        void DeleteFirst_ListaConVariosElementos_EliminaElemento() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            int valor1 = 1;
            int valor2 = 2;
            doubleList.append(valor1);
            doubleList.append(valor2);

            doubleList.deleteFirst();

            int result = doubleList.first();

            assertEquals(valor2, result);
        }

        @DisplayName("El método deleteFirst debe lanzar una excepcion si la lista esta vacia")
        @Test
        void DeleteFirst_ListaVacia_LanzaExcepcion() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            assertThrows(DoubleLinkedQueueException.class, () -> doubleList.deleteFirst());
        }

    }

    @Nested
    @DisplayName("metodo deleteLast")
    class deleteLast {
        @DisplayName("El método deleteLast debe eliminar el ultimo elemento de la cola si la lista tiene un solo elemento")
        @Test
        void DeleteLast_ListaConUnElemento_EliminaElemento() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            int valor = 1;
            doubleList.append(valor);

            doubleList.deleteLast();

            assertThrows(DoubleLinkedQueueException.class, () -> doubleList.last());
        }

        @DisplayName("El método deleteLast debe eliminar el ultimo elemento de la cola si la lista tiene varios elementos")
        @Test
        void DeleteLast_ListaConVariosElementos_EliminaElemento() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            int valor1 = 1;
            int valor2 = 2;
            doubleList.append(valor1);
            doubleList.append(valor2);

            doubleList.deleteLast();

            int result = doubleList.last();

            assertEquals(valor1, result);
        }

        @DisplayName("El método deleteLast debe lanzar una excepcion si la lista esta vacia")
        @Test
        void DeleteLast_ListaVacia_LanzaExcepcion() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            assertThrows(DoubleLinkedQueueException.class, () -> doubleList.deleteLast());
        }
    }

    @Nested
    @DisplayName("metodo first")
    class first {
        @DisplayName("El método first debe devolver el primer elemento de la cola si la lista tiene al menos un elemento")
        @Test
        void First_ListaConUnElemento_DevuelveElemento() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            int valor = 1;
            doubleList.append(valor);

            int result = doubleList.first();

            assertEquals(valor, result);
        }

        @DisplayName("El método first debe lanzar una excepcion si la lista esta vacia")
        @Test
        void First_ListaVacia_LanzaExcepcion() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            assertThrows(DoubleLinkedQueueException.class, () -> doubleList.first());
        }

    }

    @Nested
    @DisplayName("metodo last")
    class last {
        @DisplayName("El método last debe devolver el ultimo elemento de la cola si la lista tiene al menos un elemento")
        @Test
        void Last_ListaConUnElemento_DevuelveElemento() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            int valor = 1;
            doubleList.append(valor);

            int result = doubleList.last();

            assertEquals(valor, result);
        }

        @DisplayName("El método last debe lanzar una excepcion si la lista esta vacia")
        @Test
        void Last_ListaVacia_LanzaExcepcion() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            assertThrows(DoubleLinkedQueueException.class, () -> doubleList.last());
        }

    }

    @Nested
    @DisplayName("metodo size")
    class size {
        @DisplayName("El método size debe devolver 0 si la lista esta vacia")
        @Test
        void Size_ListaVacia_DevuelveCero() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            int result = doubleList.size();

            assertEquals(0, result);
        }

        @DisplayName("El método size debe devolver el tamaño de la cola")
        @Test
        void Size_ListaConVariosElementos_DevuelveTamaño() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            int valor1 = 1;
            int valor2 = 2;
            doubleList.append(valor1);
            doubleList.append(valor2);

            int result = doubleList.size();

            assertEquals(2, result);
        }

    }

    // ParametazidTest
    // csvSource
    // Prohibido hacar for/if/while
    // @ParameterizedTest
    // @CsvSource({"1,2,3,4,5", "6,7,8,9,10"})
    // void test(int a, int b, int c, int d, int e) {
    // System.out.println(a + b + c + d + e);
    // }
}
