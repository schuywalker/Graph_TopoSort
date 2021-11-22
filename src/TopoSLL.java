public class TopoSLL {
    public Node head;
    public Node tail;
    protected int size;

    public TopoSLL(){
        this.head = null;
        this.size = 0;
    }

    public void insertNode(Node newNode){
        if (size == 0){
            head = newNode;
        }
        else //(size > 0)
        {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }
    public void printTopoSLLInformative(){
        Node cursor = head;
        while (cursor != null){
            System.out.println("Vertex value: "+cursor.getValue() +
                    ", Vertex Begin Time: "+cursor.get_d_topoNode_BeganTime() +
                    ", Vertex End Time: "+cursor.get_f_topoNode_FinishedTime());
            cursor = cursor.getNext();
        }
    }
    public void printTopoSLL(){
        Node cursor = head;
        while (cursor.getNext() != null){
            System.out.print(cursor.getValue() + ", ");
            cursor = cursor.getNext();
        }
        System.out.print(cursor.getValue());
    }




}

