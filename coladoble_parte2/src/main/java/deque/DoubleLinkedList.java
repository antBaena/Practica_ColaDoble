/*
@author Antonio Cañete Baena
@author Antonio Blas Moral Sánchez
*/
package deque;

import java.util.Comparator;

public class DoubleLinkedList<T> implements DoubleLinkedQueue<T> {

    private LinkedNode<T> first;
    private LinkedNode<T> last;
    private int size;

    public DoubleLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void prepend(T value) {
        if (value == null) {
            throw new DoubleLinkedQueueException("El valor de entrada no puede ser nulo!");
        }
        LinkedNode<T> node;
        if (first == null) {
            node = new LinkedNode<>(value, null, null);
            last = node;
        } else {
            node = new LinkedNode<>(value, null, first);
            first.setPrevious(node);
        }
        first = node;
        size++;
    }

    @Override
    public void append(T value) {
        if (value == null) {
            throw new DoubleLinkedQueueException("El valor de entrada no puede ser nulo!");
        }
        LinkedNode<T> node;
        if (last == null) {
            node = new LinkedNode<>(value, null, null);
            first = node;
        } else {
            node = new LinkedNode<>(value, last, null);
            last.setNext(node);
        }
        last = node;
        size++;
    }

    @Override
    public void deleteFirst() {
        if (first == null) {
            throw new DoubleLinkedQueueException("No se puede eliminar elementos! La lista esta vacia");
        }
        if (first.getNext() == null) {
            first = null;
            last = null;
            size = 0;
        } else {
            first.getNext().setPrevious(null);
            first = first.getNext();
            size--;
        }

    }

    @Override
    public void deleteLast() {
        if (last == null) {
            throw new DoubleLinkedQueueException("No se puede eliminar elementos! La lista esta vacia");
        }
        if (last.getPrevious() == null) {
            first = null;
            last = null;
            size = 0;
        } else {
            last.getPrevious().setNext(null);
            last = last.getPrevious();
            size--;
        }
    }

    @Override
    public T first() {
        if (first == null) {
            throw new DoubleLinkedQueueException("La lista esta vacia!");
        }
        return first.getItem();
    }

    @Override
    public T last() {
        if (last == null) {
            throw new DoubleLinkedQueueException("La lista esta vacia!");
        }
        return last.getItem();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new DoubleLinkedQueueException("Indice fuera de rango!!!");
        }
        LinkedNode<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getItem();

    }

    @Override
    public boolean contains(T value) {
        LinkedNode<T> node = first;
        while (node != null) {
            if (node.getItem().equals(value)) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    @Override
    public void remove(T value) {
        LinkedNode<T> node = first;
        while (node != null) {
            if (node.getItem().equals(value)) {
                if (node == first) {
                    deleteFirst();
                } else if (node == last) {
                    deleteLast();
                } else {
                    node.getPrevious().setNext(node.getNext());
                    node.getNext().setPrevious(node.getPrevious());
                    size--;
                }
                return;
            }
            node = node.getNext();
        }
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        if (size < 2) {
            return;
        }
        LinkedNode<T> node = first;
        while (node != null) {
            LinkedNode<T> next = node.getNext();
            while (next != null) {
                if (comparator.compare(node.getItem(), next.getItem()) > 0) {
                    T temp = node.getItem();
                    node.setItem(next.getItem());
                    next.setItem(temp);
                }
                next = next.getNext();
            }
            node = node.getNext();
        }
    }
}
