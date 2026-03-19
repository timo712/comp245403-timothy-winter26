package Exercise1;


public class PositionalList<E> {

    private int size = 0;

    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n)
        {
            element = e;
            next = n;
        }
        public E getElement()
        {
            return element;
        }
    }

    private Node<E> head = null;
    public boolean isEmpty()
    {
        return size == 0;
    }

    public Position<E> first()
    {
        return head;
    }

    public Position<E> after(Position<E> p)
    {
        Node<E> node = (Node<E>) p;
        return node.next;
    }

    public int indexOf(Position<E> p)
    {
        if(isEmpty()) return -1; // if empty - nothing

        Position<E> current = first();
        int index = 0;

        while (current != null)
        {
            if(current.equals(p))
            {
                return index;
            }
            current = after(current);
            index++;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        PositionalList<Integer> Number = new PositionalList<>();
    }
}
