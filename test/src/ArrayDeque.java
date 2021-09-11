
public class ArrayDeque<T> {

    private T[] array;
    private int size;

    public ArrayDeque() {
        array = (T[]) new Object[20];
        size = 0;
    }

    public void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(array, 0, a, 0, size);
        array = a;
    }

    public void addLast(T x) {
        if (size == array.length) {
            resize(size * 2);
        }
        array[size] = x;
        size++;
    }

    public void addFirst(T x) {

        if (size == array.length) {
            resize(size * 2);
        }
        for (int i = size - 1; i >= 0; i--) {
            array[i + 1] = array[i];
        }
        array[0] = x;
        size++;
    }

    public T removeLast() {
        T last = array[size - 1];
        array[size - 1] = null;
        return last;
    }

    public T removeFirst() {
        T first = array[0];
        for (int i = 0; i < size; i++) {
            array[i] = array[i + 1];
        }
        return first;
    }

    public T get(int i) {
        return array[i];
    }

    public boolean isEmpty() {
        return array[0] == null;
    }

    public void printAll() {
        for (T i : array) {
            System.out.print(i + " ");
        }
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> list = new ArrayDeque<>();

        for (int i = 0; i < 20; i++) {
            list.addFirst(i);
        }

        list.printAll();
        System.out.println("\n");
        System.out.println(list.removeFirst());
        list.printAll();
    }

}
