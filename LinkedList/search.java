import java.util.*;
public class search {

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
        Node head = null;
        Node tail = null;
        System.out.println("Enter the number of elements in the linked list:");
        int n = s.nextInt();

        for(int i=0; i<n; i++){
            System.out.println("Enter the element: of node: "+(i+1));
            Node node = new Node(s.nextInt());

            //setting up the head and next
            if(head==null){
                head = node;
                tail = node;
            }else{
                tail.next = node;
                tail = node;
            }
        }

        System.out.println("Enter the element to search in the linked list:");
        int search = s.nextInt();

        Node current = head;
        boolean found = false;

        for(int i=0; i<n; i++){
            if(current.data==search){
                System.out.println("Element found at position: " + (i + 1));
                found = true;
                break;
            }
            current = current.next;
        }

        if(!found){
            System.out.println("Element not found in the linked list.");
        }

        s.close();

    }
    
}
