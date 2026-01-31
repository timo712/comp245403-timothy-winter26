package ex3;

public class CircularlyLinkedList<E> implements  Cloneable{
    private Node<E> tail = null;
    private int size = 0; 
    
    private static class Node<E>{
        E element;
        Node<E> next;
        Node(E e ,Node<E> n){
            element = e;
            next = n;
        }
    }
    
    public int size() {return size; }
    public boolean isEmpty() {return size == 0; }
    
    public void addLast(E e){
        Node<E> newNode = new Node<>(e, null);
        if(isEmpty()){
            newNode.next = newNode;
            tail = newNode; 
        }else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    @SuppressWarnings("uncheckec")
    public  CircularlyLinkedList<E> clone(){
        CircularlyLinkedList<E> other = new CircularlyLinkedList<>();
        if(size == 0) return  other;
        
        Node<E> walk = tail.next;
        for(int i = 0; i < size; i++){
            other.addLast(walk.element);
            walk = walk.next;
        }
        return  other;
    }
    
    public void printList(int n){
        if(isEmpty()){
            System.out.println("List is empty");
            return;
        }
        Node<E> walk = tail.next; 
        for(int i = 0; i < n; i++) {
            System.out.print(walk.element + "");
            walk = walk.next;
        }
        System.out.println();
    }

        public static void main(String[] args){
            CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
            list.addLast(10);
            list.addLast(20);
            
            System.out.print("Original list: ");
            list.printList(list.size);
            
            CircularlyLinkedList<Integer> clonedList = list.clone();
            System.out.print("Cloned list:  ");
            clonedList.printList(clonedList.size());
        }
}
