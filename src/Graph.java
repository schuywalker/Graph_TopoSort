import java.lang.reflect.Array;
import java.util.ArrayList;

public class Graph {

    public SLL[] adjList;    // adjacency list representation of our graph

    public Graph (int size) {
        this.adjList = new SLL[size];

    }

    public void insert(int key, SLL sll){
            this.adjList[key] = sll;

    }



    public void printAdjList(){
        for (int i = 0; i < this.adjList.length; i++){
            if (this.adjList[i].getLLsize() > 0) {
                this.adjList[i].printList();
            }
            else if (this.adjList[i].getLLsize() == 0)
            System.out.println(this.adjList[i].key + ": head");
        }
    }

    public void DepthFirstSearch(SLL vert){


        if (vert.visited == false) {
            System.out.println("DFS on "+vert.key);
//        System.out.println(s.getValue());
            vert.visited = true;
        }


        Node cursor = adjList[vert.key].getHead().getNext();

        for (int i = 0; i < vert.getLLsize(); i++){

            if (adjList[cursor.getValue()].visited == false) {
                DepthFirstSearch(adjList[cursor.getValue()]);
            }
            cursor = cursor.getNext();
        }
    }








    public int DepthFirstSearchTopo(SLL vert, SLL callerSLL, int GlobalTimeF){
    //same as regular DFS but increments time variable
        //first call must be made with null passed in for callerSLL

        if (vert.visited == false) {

            GlobalTimeF++;
            vert.vertTime = GlobalTimeF;
            System.out.println("DFS on "+vert.key+ ". vertTime: "+vert.vertTime + ". Global Time: "+GlobalTimeF);
            vert.visited = true;

        }
        //System.out.println(vert.key);

        //vert.color = "gray";

        if (callerSLL != null && vert.inTopoList == false) {
            vert.topoPrev = callerSLL;
            callerSLL.topoNext = vert;
            callerSLL.inTopoList = true;
            vert.inTopoList = true;
        }


        Node cursor = adjList[vert.key].getHead().getNext();
        if (cursor == null) return GlobalTimeF;

        for (int i = 0; i < adjList.length; i++){

            //if (adjList[cursor.getValue()].color.equals("white")) {
            if (adjList[cursor.getValue()].visited == false) {

                GlobalTimeF = DepthFirstSearchTopo(adjList[cursor.getValue()], vert, GlobalTimeF);
            }
            if (cursor.getNext() == null) {
                return GlobalTimeF;
            }
            else {
                cursor = cursor.getNext();
            }


        }

       // vert.color = "black";
        return GlobalTimeF;
    }

    public void BreadthFirstSearch(){

    }

    public void TopoPrint(){
        SLL vertCursor = adjList[0];
        while (vertCursor.topoPrev != null){
            vertCursor = vertCursor.topoPrev;
        }
        while (vertCursor.topoNext != null){
            System.out.print(vertCursor.key + ", ");
            vertCursor = vertCursor.topoNext;
        }

    }

    public void TopoSort(int GlobalTimeF){
//        GlobalTimeF = 0;

        for (int i = 0; i < adjList.length; i++){
            GlobalTimeF = DepthFirstSearchTopo(adjList[i], null, GlobalTimeF);
        }

        System.out.println(GlobalTimeF);

        TopoPrint();

    }

}
