public class SLL {


    public int key; //the SLL's identifier
    private Node head = new Node();
    public boolean visited;
    public int vertTime;
    public String color;
    public SLL topoPrev;
    public SLL topoNext;
    public boolean inTopoList;


    private int LLsize = 0;

    public SLL(int key){
        this.key = key;
        head.setValue(key);//heads key is the array index of the LL
        visited = false;
        this.vertTime = 0;
        this.color = "white";
        this.inTopoList = false;
    }


    public void insertNode(Node newNode){
        if (this.LLsize == 0) {
            this.head.setNext(newNode);
        }
        else { // head.getNext() != null
            newNode.setNext(head.getNext()); //do we even need this? should be set already.
            head.setNext(newNode);
        }
        LLsize++;
    }

    public int getNodeValue(){
        return this.key;
    }
    public void setNodeValue(int nodeValue){
        this.key = nodeValue;
    }

    public int getLLsize(){
        return this.LLsize;
    }

    public void printList(){
        System.out.print(this.key + ": head, ");
        Node cursor = this.head;
        while (cursor.getNext() != null) {
            System.out.print(cursor.getNext().getValue() + ", ");
            cursor = cursor.getNext();
        }
        System.out.println();
    }

    public Node getHead(){
        return this.head;
    }



}

