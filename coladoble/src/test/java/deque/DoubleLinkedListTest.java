/*
@author Antonio Cañete Baena
@author Antonio Blas Moral Sánchez
*/
package deque;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@DisplayName("DoubleLinkedList")
public class DoubleLinkedListTest {

    @DisplayName("Constructor")
    @Nested
    class Constructor {
        @DisplayName("El constructor debe establecer el tamaño a 0")
        @Test
        void Constructor_EstableceTamanyoA0() {
            DoubleLinkedQueue<Integer> test = new DoubleLinkedList<Integer>();
            int expected = 0;

            int result = test.size();

            assertEquals(expected, result);

        }

    }

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

        @DisplayName("El método prepend debe insertar un elemento al principio de la cola si hay mas elementos")
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

        @DisplayName("El método prepend debe insertar el primer elemento al principio y mover el anterior primero a la segunda pos")
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

        @DisplayName("El método append debe insertar un elemento al final de la cola si hay mas elementos")
        @Test
        public void Append_ValorValido_InsertaElementoAlFinal() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            int valor1 = 1;
            int valor2 = 2;

            doubleList.append(valor1);
            doubleList.append(valor2);
            int result = doubleList.last();

            assertEquals(valor2, result);
        }

        @DisplayName("El método append debe insertar un elemento al final y desplazar el anterior ultimo elemento al la segundo posicion anterior")
        @Test
        public void Append_ValorValido_DesplazaElementoAlFinal() {
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
        @DisplayName("El método first debe devolver el primer elemento de la cola si la lista tiene un elemento")
        @Test
        void First_ListaConUnElemento_DevuelveElemento() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            int valor = 1;
            doubleList.append(valor);

            int result = doubleList.first();

            assertEquals(valor, result);
        }

        @DisplayName("El método first debe devolver el primer elemento de la cola si la lista tiene varios elementos")
        @Test
        void First_ListaConVariosElementos_DevuelveElemento() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            int valor1 = 1;
            int valor2 = 2;
            doubleList.append(valor1);
            doubleList.prepend(valor2);

            int result = doubleList.first();

            assertEquals(valor2, result);
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
        @DisplayName("El método last debe devolver el ultimo elemento de la cola si la lista tiene un elemento")
        @Test
        void Last_ListaConUnElemento_DevuelveElemento() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            int valor = 1;
            doubleList.append(valor);

            int result = doubleList.last();

            assertEquals(valor, result);
        }

        @DisplayName("El método last debe devolver el ultimo elemento de la cola si la lista tiene varios elementos")
        @Test
        void Last_ListaConVariosElementos_DevuelveElemento() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            int valor1 = 1;
            int valor2 = 2;
            doubleList.append(valor1);
            doubleList.append(valor2);

            int result = doubleList.last();

            assertEquals(valor2, result);
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
            int expected = 0;

            assertEquals(expected, result);
        }

        @DisplayName("El método size debe devolver 1 si la lista tiene un elemento")
        @Test
        void Size_ListaConUnElemento_DevuelveUno() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            int valor = 1;
            doubleList.append(valor);

            int result = doubleList.size();
            int expected = 1;

            assertEquals(expected, result);
        }

        @DisplayName("El método size debe devolver el tamaño de la lista si tiene varios elementos")
        @Test
        void Size_ListaConVariosElementos_DevuelveTamanyo() {
            DoubleLinkedQueue<Integer> doubleList = new DoubleLinkedList<>();
            int valor1 = 1;
            int valor2 = 2;
            doubleList.append(valor1);
            doubleList.append(valor2);

            int result = doubleList.size();
            int expected = 2;

            assertEquals(expected, result);
        }

    }
}
