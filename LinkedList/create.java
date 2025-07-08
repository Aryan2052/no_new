import java.util.*;
public class create {

    static class Node{
        public int data;
        public Node next;

        //next parameter missing
        public Node(int data){
            this.data=data;
            this.next = null;
        }
    }

        

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.println("No of nodes: ");
        int n = s.nextInt();
        Node head = null;
        Node tail = null;

        for(int i=0; i<n; i++){
            System.out.println("Enter data for node " + (i+1) + ": ");
            int x = s.nextInt();

            Node node = new Node(x);

            if(head==null){
                //if first node, then head will be that node
                head = node;
                tail = node;
            }else{
                //pointing 1st node to 2nd node
                //and so on
                tail.next = node;
                //  tail is updated to latest node
                //so that next node can be added
                tail = node;
            }
        }

        //printing the linked list
        System.out.println("Linked List: ");
        Node current = head;
        while(current!=null){
            System.out.println(current.data);
            current = current.next;
        }
    }
    
}
