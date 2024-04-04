/*
@author Antonio Cañete Baena
@author Antonio Blas Moral Sánchez
*/
package deque;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.*;

/*
 * WHatsapp pero en vscode
 * 
 * NO sew puede resorver DoubleLInkedList
 * 
 */
@DisplayName("DoubleLinkedList")
public class DoubleLinkedListTest {

    @Nested
    @DisplayName("metodo get")
    class get {
        @DisplayName("El método get debe devolver el elemento en la posición dada cunado le pasamos un indice valido")
        @Test
        public void Get_ListaConElementos_DevuelveElemento() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            int valor1 = 1;
            int valor2 = 2;
            int valor3 = 3;
            int indice = 1;
            list.append(valor1);
            list.append(valor2);
            list.append(valor3);

            int expected = valor2;
            int actual = list.get(indice);

            assertEquals(expected, actual);
        }

        @DisplayName("El método get debe lanzar una excepción si la lista está vacía")
        @Test
        public void Get_ListaVacia_LanzaExcepcion() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            int indice = 0;

            assertThrows(DoubleLinkedQueueException.class, () -> list.get(indice));
        }

        @DisplayName("El método get debe lanzar una excepción si el índice indicado es negativo")
        @Test
        public void Get_IndiceNegativo_LanzaExcepcion() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            int indice = -1;

            assertThrows(DoubleLinkedQueueException.class, () -> list.get(indice));
        }

        @DisplayName("El método get debe lanzar una excepción si el índice indicado está fuera de rango")
        @Test
        public void Get_IndiceFueraDeRango_LanzaExcepcion() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            int valor = 1;
            int indice = 2;

            list.append(valor);

            assertThrows(DoubleLinkedQueueException.class, () -> list.get(indice));
        }
    }

    @Nested
    @DisplayName("metodo contains")
    class contains {
        @DisplayName("El método contains debe devolver true si el elemento está dentro de la lista")
        @Test
        public void Contains_ExisteElementoEnLista_DevuelveTrue() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            int valor = 3;
            list.append(valor);

            boolean resultado = list.contains(valor);

            assertTrue(resultado);
        }

        @DisplayName("El método contains debe devolver false si el elemento no está dentro de la lista")
        @Test
        public void Contains_NoExisteElementoEnLista_DevuelveFalse() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            int valor1 = 1;
            list.append(valor1);
            int valor = 3;

            boolean resultado = list.contains(valor);

            assertFalse(resultado);
        }

        @DisplayName("El método contains debe devolver false si la lista esta vacia")
        @Test
        public void Contains_ListaVacia_DevuelveFalse() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            int valor = 3;

            boolean resultado = list.contains(valor);

            assertFalse(resultado);
        }
    }

    @Nested
    @DisplayName("metodo remove")
    class remove {
        @DisplayName("El método remove debe eliminar un elemento de la lista si el elemento está en la lista")
        @Test
        public void Remove_ListaConElemento_EliminaElementoDeLista() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            int valor1 = 1;
            int valor2 = 2;
            int valor3 = 3;
            list.append(valor1);
            list.append(valor2);
            list.append(valor3);

            list.remove(valor2);
            boolean resultado = list.contains(valor2);

            assertFalse(resultado);
        }

        @DisplayName("El método remove debe eliminar solo un elemento de la lista si el elemento está repetido en la lista")
        @Test
        public void Remove_ListaConElementoRepetido_NoEliminaTodosElementoDeLista() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            int valor1 = 1;
            int valor2 = 2;
            list.append(valor1);
            list.append(valor1);
            list.append(valor2);

            int tamanoEsperado = list.size() - 1;
            list.remove(valor1);
            boolean resultado = list.contains(valor1);
            int tamanoReal = list.size();

            assertTrue(resultado);
            assertEquals(tamanoEsperado, tamanoReal);
        }

        @DisplayName("El método remove no debe eliminar un elemento de la lista si el elemento no está en la lista")
        @Test
        public void Remove_ListaSinElemento_NoEliminaNingunElemento() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            int valor1 = 1;
            int valor2 = 2;
            int valor3 = 3;
            list.append(valor1);
            list.append(valor2);

            int expected = list.size();
            list.remove(valor3);
            int result = list.size();

            assertEquals(expected, result);
        }

        @DisplayName("El método remove no debe eliminar un elemento de la lista si la lista está vacía")
        @Test
        public void Remove_ListaVacia_NoEliminaNingunElemento() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            int valor = 3;

            int expected = list.size();
            list.remove(valor);
            int result = list.size();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("metodo sort")
    class sort {
        Comparator<Integer> cmp;

        @BeforeEach
        public void setUp() {
            cmp = Comparator.naturalOrder();
        }

        @DisplayName("El método sort debe ordenar la lista de forma correcta si los elementos no tienen el orden establecido")
        @Test
        public void Sort_ListaDesordenada_OrdenaLista() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            int valor1 = 3;
            int valor2 = 2;
            int valor3 = 1;
            list.append(valor1);
            list.append(valor2);
            list.append(valor3);

            list.sort(cmp);
            int expected1 = valor3;
            int result1 = list.first();
            int expected2 = valor2;
            int result2 = list.get(1);
            int expected3 = valor1;
            int result3 = list.last();

            assertEquals(expected1, result1);
            assertEquals(expected2, result2);
            assertEquals(expected3, result3);
        }

        @DisplayName("El método sort no debe modificar la lista si está ya ordenada de forma correcta")
        @Test
        public void Sort_ListaOrdenada_NoModificaLista() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            int valor1 = 1;
            int valor2 = 2;
            int valor3 = 3;
            list.append(valor1);
            list.append(valor2);
            list.append(valor3);

            list.sort(cmp);
            int expected1 = valor1;
            int result1 = list.first();
            int expected2 = valor2;
            int result2 = list.get(1);
            int expected3 = valor3;
            int result3 = list.last();

            assertEquals(expected1, result1);
            assertEquals(expected2, result2);
            assertEquals(expected3, result3);
        }

        @DisplayName("El método sort debe ordenar la lista correctamente si la lista tiene elementos repetidos")
        @Test
        public void Sort_ListaConElementosRepetidos_OrdenaLista() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            int valor1 = 3;
            int valor2 = 2;
            int valor3 = 3;
            int valor4 = 2;
            int valor5 = 1;
            list.append(valor1);
            list.append(valor2);
            list.append(valor3);
            list.append(valor4);
            list.append(valor5);

            list.sort(cmp);
            int expected1 = valor5;
            int result1 = list.first();
            int expected2 = valor2;
            int result2 = list.get(1);
            int expected3 = valor4;
            int result3 = list.get(2);
            int expected4 = valor3;
            int result4 = list.get(3);
            int expected5 = valor1;
            int result5 = list.last();

            assertEquals(expected1, result1);
            assertEquals(expected2, result2);
            assertEquals(expected3, result3);
            assertEquals(expected4, result4);
            assertEquals(expected5, result5);
        }

        @DisplayName("El método sort no debe modificar la lista si está vacia")
        @Test
        public void Sort_ListaVacia_NoModificaLista() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

            int expected = list.size();
            list.sort(cmp);
            int result = list.size();

            assertEquals(expected, result);
        }

        @DisplayName("El método sort no debe modificar la lista si tiene solo un elemento")
        @Test
        public void Sort_ListaConUnElemento_NoModificaLista() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            int valor = 1;
            list.append(valor);

            int expected = list.first();
            list.sort(cmp);
            int result = list.first();

            assertEquals(expected, result);
        }
    }

}
