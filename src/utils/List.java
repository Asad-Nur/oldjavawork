package utils;

public interface List<E> {
    boolean     add(E element);

    void        add(int index, E element);

    void        clear();

    boolean     contains(E element);

    E           get(int index);

    int         indexOf(E element);

    boolean     isEmpty();

    E           remove(int index);

    boolean     remove(E element);

    E           set(int index, E element);

    int         size();


    Iterator<E> iterator();
}
