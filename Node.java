package TPE_LinkedList;
public class Node<E> {
    private Node<E> next;
    private Node<E> prev;
    private E data;

    public Node(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void deleteAt(int index){
        if (index == 0){
            getPrev().setNext(getNext());
        }else{
            deleteAt(index -1);
        }
    }

    @Override
    public String toString() {
        return getData().toString();
    }
}