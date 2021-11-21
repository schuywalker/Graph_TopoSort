// not necessary for TopoSort. Only needed in BFS

public class FifoQ implements Queue {

    public int size;
    public Node head;
    public Node tail;

    public FifoQ(){
        head = null;
        tail = null;
        size = 0;

    }

    public void enqueue(Node newNode){

    }

    public int dequeue(){
        if (this.size == 0) return 0;

        //delete node method from SLL
        return head.getNext().getValue();

    }



}
