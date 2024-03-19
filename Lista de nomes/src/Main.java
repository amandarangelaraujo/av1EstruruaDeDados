import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<String> names = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            names.add(name);
        }

        while (!names.isEmpty()) {

            int longestSize = 0;
            for (int i = 0; i < names.size(); i++) {
                int nameLength = names.get(i).length();
                if (nameLength > longestSize) {
                    longestSize = nameLength;
                }
            }

            StringBuilder string = new StringBuilder();
            boolean isFirst = true;

            for (int size = 1; size <= longestSize; size++) {
                for (int i = 0; i < names.size(); i++) {
                    if (names.get(i).length() == size) {
                        if (!isFirst) {
                            string.append(", ");
                        } else {
                            isFirst = false;
                        }
                        string.append(names.get(i));
                        names.removeByIndex(i);
                        break;
                    }
                }
            }

            System.out.println(string.toString());
        }

        sc.close();
    }
}

class EmptyListException extends RuntimeException {
    public EmptyListException(String errorMessage) {
        super(errorMessage);
    }
}

class FullStaticListException extends RuntimeException {

    public FullStaticListException(String errorMessage) {
        super(errorMessage);
    }

}

// TAD
interface List<E> {
    int size();

    boolean isEmpty();

    void add(E value);

    E get(int index) throws IndexOutOfBoundsException;

    void clear();

    boolean contains(E value) throws EmptyListException;

    void removeByIndex(int index) throws IndexOutOfBoundsException, EmptyListException;
}

class StaticList<E> implements List<E> {

    protected int size;
    protected E[] staticList;
    private final int MAX_SIZE = 5;

    @SuppressWarnings("unchecked")
    public StaticList() {
        staticList = (E[]) new Object[MAX_SIZE];
        // size = 0;
    }

    @Override
    public void add(E value) throws FullStaticListException {
        if (isFull()) {
            throw new FullStaticListException("Static List is Full!");
        }

        staticList[size++] = value;
    }

    @Override
    public void removeByIndex(int index) throws IndexOutOfBoundsException, EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Static List is Empty!");
        }
        checkIndex(index, size);

        E value = staticList[index];
        for (int i = index; i < size - 1; i++) {
            staticList[i] = staticList[i + 1];
        }
        size--;

    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        staticList = (E[]) new Object[MAX_SIZE];
        size = 0;

    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        return staticList[index];
    }

    private void checkIndex(int index, int referenceIndex) {
        if (index < 0 || index >= referenceIndex) {
            throw new IllegalArgumentException("index " + index + " is invalid!");
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == MAX_SIZE;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(E value) throws EmptyListException {
        for (int i = 0; i < size; i++) {
            if (staticList[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

}

class ArrayList<E> extends StaticList<E> {

    @SuppressWarnings("unchecked")
    public ArrayList() {
        staticList = (E[]) new Object[5];
    }

    @SuppressWarnings("unchecked")
    private void recreateStaticList() {
        E[] newStaticList = (E[]) new Object[staticList.length * 2];

        for (int i = 0; i < staticList.length; i++) {
            newStaticList[i] = staticList[i];
        }

        staticList = newStaticList;

    }

    @Override
    public void add(E value) {
        if (size == staticList.length) {
            recreateStaticList();
        }
        staticList[size++] = value;
    }

}