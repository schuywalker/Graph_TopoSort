public class SLL {


    public int key; //the SLL's identifier
    private Node head = null;
    public boolean visited;
    public int d_AKA_vertexVisitedTimeStamp;
    public int f_AKA_vertexDFS_Finished_timestamp;
   // public String color;
   // public SLL topoPrev;
   // public SLL topoNext;
   //public boolean inTopoList;


    private int LLsize = 0;

    public SLL(int key){
        this.key = key;
        //head.setValue(key);//heads key is the array index of the LL
        visited = false;
        this.d_AKA_vertexVisitedTimeStamp = 0;
    }


    public void insertNode(Node newNode){
        if (this.LLsize == 0) {
            head = newNode;
        }
        else { // head.getNext() != null
            newNode.setNext(head);
            head = newNode;
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
        if (this == null){
            System.out.println("error: print list on null list");
            return;
        }
        Node cursor = this.head;
        while (cursor != null) {
            System.out.print(cursor.getValue() + ", ");
            cursor = cursor.getNext();
        }
        System.out.println();
    }

    public Node getHead(){
        return this.head;
    }



}

