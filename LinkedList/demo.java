class Node{
    String data;
    Node next;

    public Node(String data){
        this.data = data;
        this.next = null;
    }
    public void setData(String data){
        this.data = data;
    }
    public void setNext(Node node){
        this.next = node;
    }
    public String getData(){
        return this.data;
    }
    public Node getNext(){
        return this.next;
    }
}

class LinkedList{
    Node head;
    Node tail;

    public Node getHead(){
        return this.head;
    }
    public Node getTail(){
        return this.tail;
    }
    public void addAtEnd(String data){
        Node node = new Node(data);
        if(head==null){
            this.head=this.tail=node;
        } else {this.tail.setNext(node);
            this.tail=node;
        }
    }

    public void addAtStart(String data){

        //creating a new node
        //and setting its data
        Node node = new Node(data);
        if(head==null){
            this.head=this.tail=node;
        }else{
            node.setNext(this.head);
            this.head=node;
        }
    }
}

public class demo{
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.addAtEnd("Milan");
        list.addAtEnd("Paris");
        list.addAtEnd("London");
        System.out.println("Linked List: " + list);
    }
}
