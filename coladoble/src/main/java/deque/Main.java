package deque;

public class Main {

    public static void main(String[] args) {
        DoubleLinkedList<Integer> d1 = new DoubleLinkedList<>();
        d1.append(1);
        show(d1);

        d1.append(2);
        show(d1);

        d1.append(3);
        show(d1);

        d1.deleteFirst();
        show(d1);

        d1.deleteLast();
        show(d1);

        d1.deleteFirst();
        show(d1);

        d1.deleteFirst();

        show(d1);

    }

    private static <T> void show(DoubleLinkedList<T> list) {
        System.out.println("Size --> " + list.size());
        System.out.println("First --> " + list.first());
        System.out.println("Last --> " + list.last());
        System.out.println("----------------------------");
        System.out.flush();
    }
}
