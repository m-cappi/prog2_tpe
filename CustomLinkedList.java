package TPE_LinkedList;


import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class CustomLinkedList<E> implements Iterable<Node<E>> {
    private Node<E> first;
    private Node<E> last;
    private int length;

    public CustomLinkedList() {
        length = 0;
    }

    public CustomLinkedList(Node<E> head, Node<E> last) {
        this.first = Objects.requireNonNull(head);
        this.last = Objects.requireNonNull(last);
        length = 2;
    }

    public Node<E> getFirst() {
        return first;
    }

    public void setFirst(Node<E> first) {
        this.first = first;
    }

    public Node<E> getLast() {
        return last;
    }

    public void setLast(Node<E> last) {
        this.last = last;
    }

    public int getLength() {
        return length;
    }

    private void insertAtEnd(E data) {
        Node<E> node = new Node<>(data);
        if (this.isEmpty()) {
            insertIfEmpty(node);
        } else {
            this.getLast().setNext(node);
            node.setPrev(this.getLast());
            node.setNext(null);
            this.setLast(node);
            length++;
        }

    }

    private void insertAt(E data, int index) {
        if (length == 0 || itShouldBeLast(index)) {
            insertAtEnd(data);
            return;
        }

        Node<E> currentIndexNode = getNodeByIndex(index);
        insertNodeAsPrev(new Node<>(data), currentIndexNode);
    }

    public void addElement(Comparable<E> data) {
        for (Node<E> current : this) {
            if (data.compareTo(current.getData()) < 0) {
                insertNodeAsPrev((Node<E>) new Node<>(data), current);
                return;
            }
        }
        insertAtEnd((E) data);
    }
    // 4
    // 1, 3, 5, 7,
    public void addElement(E data, Comparator<E> comparator) {
        for (Node<E> current : this) {
            if (comparator.compare(current.getData(), data) >= 0) {
                insertNodeAsPrev(new Node<>(data), current);
                return;
            }
        }
        insertAtEnd(data);
    }

    public void addElementAt(E data, int index) {
        Node<E> node = new Node<>(data);
        Node<E> tempNode = this.first;
        int i = 0;
        if (index <= length) {
            while (positionNotFound(index, i)) {
                tempNode = tempNode.getNext();
                i++;
            }
            if (itShouldBeLast(i)) {
                this.insertAtEnd(data);
            } else if (i == 0) {
                insertAtFirst(data);
            } else {
                insertNodeAsPrev(node, tempNode);
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private void insertNodeAsPrev(Node<E> nodeToInsert, Node<E> contextNode) {
        if (nodeToInsert == null || contextNode == null)
            throw new NullPointerException();

        // prev < nodeToInsert < contextNode
        Node<E> prev = contextNode.getPrev();
        if (Objects.isNull(prev)) {
            setFirst(nodeToInsert);
        } else {
            prev.setNext(nodeToInsert);
        }
        nodeToInsert.setPrev(prev);
        nodeToInsert.setNext(contextNode);
        contextNode.setPrev(nodeToInsert);
        this.length++;
    }

    private boolean itShouldBeLast(int i) {
        return i == length && i != 0;
    }

    private boolean positionNotFound(int index, int i) {
        return i < length && i != index;
    }

    public void insertAtFirst(E data) {
        Node<E> node = new Node<>(data);
        if (isEmpty()) {
            insertIfEmpty(node);
        } else {
            node.setPrev(null);
            node.setNext(this.getFirst());
            this.getFirst().setPrev(node);
            if (this.getFirst().getNext() == null) {
                this.getFirst().setNext(null);
                this.setLast(this.getFirst());
            }
            this.setFirst(node);
            this.length++;
        }
    }

    public void deleteAt(int index) {
        if (index > this.length || index < 0) {
            throw new IndexOutOfBoundsException(index);
        }

        deleteNode(getNodeByIndex(index));
    }

    private void insertIfEmpty(Node<E> node) {
        this.first = node;
        this.last = node;
        node.setPrev(null);
        node.setNext(null);
        this.length++;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public void validateIndex(int index) {
        if (index > this.length || index < 0) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    public Node getNodeByIndex(int index) {
        validateIndex(index);
        int pos = 0;
        for (Node<E> current : this) {
            if (pos == index) {
                return current;
            }
            pos++;
        }
        return null;
        /*
        if (index == length) {
            // shortcut to last
            return last;
        }
        Node aux = first;
        int count = 0;
        while (index != count) {
            count++;
            aux = aux.getNext();
        }
        return aux;
        */
    }

    @Override
    public String toString() {
        return "CustomLinkedList{" +
                "first=" + first +
                ", last=" + last +
                ", lenght=" + length +
                '}';
    }

    public void deleteByData(E targetData) {
        int pos = 0;
        Node aux = first;
        while (pos < length) {
            if (aux.getData().equals(targetData)) {
                deleteNode(aux);
            }
            pos++;
            aux = aux.getNext();
        }
    }

    public void deleteByNode(Node<E> targetNode) {
        int pos = 0;
        Node aux = first;
        while (pos < length) {
            if (aux.equals(targetNode)) {
                deleteNode(aux);
            }
            pos++;
            aux = aux.getNext();
        }
    }

    private void deleteNode(Node<E> targetNode) {
        // [A, targetNode, C]
        Node prev = targetNode.getPrev(); // A
        Node next = targetNode.getNext(); // C
        prev.setNext(next); // A -> C
        next.setPrev(prev); // A <- C
        length--;
    }

    public int getIndexByNode(Node<E> targetNode) {
        int pos = 0;
        Node aux = first;
        while (pos < length) {
            if (aux.equals(targetNode)) {
                break;
            }
            pos++;
            aux = aux.getNext();
        }
        return pos;
    }

    @Override
    public Iterator<Node<E>> iterator() {
        return new CustomLinkedListIterator();
    }

    private class CustomLinkedListIterator implements Iterator<Node<E>> {
        Node<E> current;

        public CustomLinkedListIterator() {
            current = first;
        }

        @Override
        public boolean hasNext() {
            if (current == null) {
                return false;
            }
            return Objects.nonNull(current.getNext());
        }

        @Override
        public Node<E> next() {
            current = current.getNext();
            return current;
        }
    }


}