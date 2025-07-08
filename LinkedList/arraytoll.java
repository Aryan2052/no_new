import java.util.*;

public class arraytoll {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.println("Enter no of elements in array: ");
        int n = s.nextInt();
        Node head = null;
        Node tail = null;

        for(int i=0; i<n; i++){
            System.out.println("Enter element " + (i+1) + ": ");
            Node node = new Node(s.nextInt());

            if(head==null){
                head = node;
                tail = node;
            }else{
                tail.next = node;
                tail = node;
            }

        }

        //printing the linked list
        System.out.println("Linked List: ");
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
    
}
