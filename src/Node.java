public class Node {

    private int value;
    public Node next;
    //public String color;
    public int d;


    private Node[] edges; /// ????????

    public Node() {}

    public Node(int value){
        this.value = value;
        //this.color = "white";

    }



    public int getValue(){
        return this.value;
    }
    public void setValue(int value){
        this.value = value;
    }

    public Node getNext(){
        return this.next;
    }

    public void setNext(Node next){
        this.next = next;
    }

}
