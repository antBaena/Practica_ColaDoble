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
    @DisplayName("metodo get")
    class get {
        @DisplayName("El método get debe devolver el elemento en la posición dada")
        @Test
        public void Get_ListaConElementos_DevuelveElemento() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            int valor1 = 1;
            int valor2 = 2;
            int valor3 = 3;
            list.append(valor1);
            list.append(valor2);
            list.append(valor3);

            int expected = 2;
            int indice = 1;

            assertEquals(expected, list.get(indice));
        }

        @DisplayName("El método get debe lanzar una excepción si la lista está vacía")
        @Test
        public void Get_ListaVacia_LanzaExcepcion() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

            assertThrows(DoubleLinkedQueueException.class, () -> list.get(0));
        }

        @DisplayName("El método get debe lanzar una excepción si el índice indicado es negativo")
        @Test
        public void Get_IndiceNegativo_LanzaExcepcion() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

            assertThrows(DoubleLinkedQueueException.class, () -> list.get(-1));
        }

        @DisplayName("El método get debe lanzar una excepción si el índice indicado está fuera de rango")
        @Test
        public void Get_IndiceFueraDeRango_LanzaExcepcion() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            int valor = 1;

            list.append(valor);

            assertThrows(DoubleLinkedQueueException.class, () -> list.get(2));
        }
    }

    @Nested
    @DisplayName("metodo contains")
    class contains {
        @DisplayName("El método contains debe devolver true si el elemento está dentro de la lista")
        @Test
        public void Contains_ExisteElElementoEnLaLista_DevuelveTrue() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            int valor = 3;

            list.append(valor);
            int expected = valor;

            assertTrue(list.contains(expected));
        }

        @DisplayName("El método contains debe devolver false si el elemento no está dentro de la lista")
        @Test
        public void Contains_NoExisteElElementoEnLaLista_DevuelveFalse() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

            int expected = 3;

            assertFalse(list.contains(expected));
        }
    }

    @Nested
    @DisplayName("metodo remove")
    class remove {
        @DisplayName("El método remove debe eliminar un elemento de la lista si el elemento está en la lista")
        @Test
        public void Remove_ListaConElementoAEliminar_EliminaElementoDeLaLista() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            int valor1 = 1;
            int valor2 = 2;
            list.append(valor1);
            list.append(valor2);

            list.remove(valor2);

            assertFalse(list.contains(valor2));
        }

        @DisplayName("El método remove no debe eliminar un elemento de la lista si el elemento no está en la lista")
        @Test
        public void Remove_ListaSinElementoAEliminar_NoEliminaNingunElemento() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            int valor1 = 1;
            int valor2 = 2;
            int valor3 = 3;
            list.append(valor1);
            list.append(valor2);

            int expected = list.size();
            list.remove(valor3);

            assertEquals(expected, list.size());
        }
    }

    @Nested
    @DisplayName("metodo sort")
    class sort {

    }
}
