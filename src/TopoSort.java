/*
Author: Schuyler Asplin
Topographical Sort of an Adjacency List representation of a graph
CSCD320 Algorithms Prog4 Professor Xu
 */


import java.io.File;
import java.util.Scanner;

public class TopoSort {

    public static void main (String[] args){

        Graph graph = null;
        File file = new File(args[0]);

        // file io, filling adjacency list
        try {
            Scanner sc = new Scanner(file);
/*
Currently, key is the array index at which linked lists are added to the adjacency list.
If keys are inserted into occupied indexes, room is made by moving
 */
            int numOfLines = 0;
            while (sc.hasNextLine()) {

                numOfLines++;
                sc.nextLine();
            }

            graph = new Graph(numOfLines);

            sc.close();

        } catch (Exception eLineGetter) {}

        try {

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                String[] splitLine = line.split(":");
                int key = Integer.parseInt(splitLine[0]);
                SLL sll = new SLL(key);
                graph.insert(key, sll); // adding the linked list to our arrayList at index == nodes value.
                // if node x is occupying this spot, x and all following nodes will be bumepd to the right to make room
                //this way, nodes will be located at an array index == the nodes' value
                if (splitLine.length > 1 && splitLine[1].length() > 0){ // dont need second clause
                    String[] nextHopNeighbors = splitLine[1].split(",");

                    for (int i = 0; i < nextHopNeighbors.length; i++){
                        Node neighbor = new Node(Integer.parseInt(nextHopNeighbors[i]));
                        sll.insertNode(neighbor);
                    }
                }
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("e: " + e.getStackTrace());
        }

        graph.printAdjList();

        //graph.DepthFirstSearch(graph.adjList[0]);
        int GlobalTimeF = 0;
        graph.TopoSort(GlobalTimeF);

    }

}
