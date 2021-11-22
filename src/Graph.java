/*
Author: Schuyler Asplin
Topographical Sort of an Adjacency List representation of a graph
CSCD320 Algorithms Prog4 Professor Xu

Graph function with DFS and TopoSort
 */
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
            if (this.adjList[i] == null) {
                //do nothing. this saves program if a number (including 0) is not present in dag
            }
            else if (this.adjList[i].getLLsize() > 0) {
                this.adjList[i].printList();
            }
            else if (this.adjList[i].getLLsize() == 0)
            System.out.println(this.adjList[i].key + ": head");
        }
    }

    public void DepthFirstSearch(SLL vert){


        if (vert.visited == false) {
            vert.visited = true;
            //System.out.println("DFS on "+vert.key);
        }


        Node cursor = adjList[vert.key].getHead().getNext();

        for (int i = 0; i < vert.getLLsize(); i++){

            if (adjList[cursor.getValue()].visited == false) {
                DepthFirstSearch(adjList[cursor.getValue()]);
            }
            cursor = cursor.getNext();
        }
    }








    public int DepthFirstSearchTopo(SLL vert, int GlobalTimeF, TopoSLL finalProduct){
        //same as regular DFS but increments time variable

        if (vert == null || vert.visited == true) {
            return GlobalTimeF;
        }


        GlobalTimeF++;
        vert.d_AKA_vertexVisitedTimeStamp = GlobalTimeF;
        //System.out.println("DFS on "+vert.key+ ". vertTime: "+vert.d_AKA_vertexVisitedTimeStamp + ". Global Time: "+GlobalTimeF);
        vert.visited = true;

        //building our topo LL for output
        Node finalProductNode = new Node(vert.key);
        finalProductNode.set_d_topoNode_BeganTime(GlobalTimeF);

        Node cursor = adjList[vert.key].getHead();


        for (int i = 0; i < adjList[vert.key].getLLsize(); i++){


            if (adjList[cursor.getValue()].visited == false) {

                GlobalTimeF = DepthFirstSearchTopo(adjList[cursor.getValue()], GlobalTimeF, finalProduct);

            }


            cursor = cursor.getNext();



        }

        GlobalTimeF++;
        vert.f_AKA_vertexDFS_Finished_timestamp = GlobalTimeF;
        finalProductNode.set_f_topoNode_FinishedTime(GlobalTimeF);

        finalProduct.insertNode(finalProductNode); //inserted into the front of our linked list
        return GlobalTimeF;
    }

    public void BreadthFirstSearch(){ //not written
    }



    public void TopoSort(int GlobalTimeF){
//        GlobalTimeF = 0;
        TopoSLL finalProduct = new TopoSLL();

        for (int i = 0; i < adjList.length; i++){
            GlobalTimeF = DepthFirstSearchTopo(adjList[i], GlobalTimeF, finalProduct);
        }

        //System.out.println("Global Time: " + GlobalTimeF);
        finalProduct.printTopoSLL();
        System.out.println();
        //finalProduct.printTopoSLLInformative();

    }


}



// Adjust functions not needed because input is garunteed to be 0...n-1

//    public int[] adjustForArraySizeVariability(int vertKey){
//        //adjusts in case that 0 is not a node in the list.
//        int[] forLoopValues = {0, adjList[vertKey].getLLsize()};
//
//        if (this.adjList[0] == null) {
//            forLoopValues[0]++;
//            forLoopValues[1] = adjList[vertKey].getLLsize();
//        }
//        return forLoopValues;
//    }
//
//    public int[] adjustForArraySizeVariability(){
//        //adjusts in case that 0 is not a node in the list.
//        int[] forLoopValues = {0, adjList.length};
//
//        if (this.adjList[0] == null) {
//            forLoopValues[0]++;
//            forLoopValues[1]--;
//        }
//        return forLoopValues;
//    }





//    public void TopoPrint(){
//        SLL vertCursor = adjList[0];
//        while (vertCursor.topoPrev != null){
//            vertCursor = vertCursor.topoPrev;
//        }
//        while (vertCursor.topoNext != null){
//            System.out.print(vertCursor.key + ", ");
//            vertCursor = vertCursor.topoNext;
//        }
//
//    }