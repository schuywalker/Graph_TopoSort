/*
Author: Schuyler Asplin
Topographical Sort of an Adjacency List representation of a graph
CSCD320 Algorithms Prog4 Professor Xu

Node class. Used by SLL for representing edges and for TopoSLL for representing verticies.
The latter is only used for final result output.
 */

public class Node {

    private int value;
    public Node next;
    //public String color;
    private int f_topoNode_finishedTime;//only used for TopoSLL, not in actual toposort
    private int d_topoNode_beganTime;

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

    public int get_f_topoNode_FinishedTime(){
        return this.f_topoNode_finishedTime;
    }
    public void set_f_topoNode_FinishedTime(int d_topoNodeTime){
        this.f_topoNode_finishedTime = d_topoNodeTime;
    }
    public int get_d_topoNode_BeganTime(){
        return this.d_topoNode_beganTime;
    }
    public void set_d_topoNode_BeganTime(int d_topoNodeTime){
        this.d_topoNode_beganTime = d_topoNodeTime;
    }

}
