package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;


public class Main {

    public static void main(String[] args) {


        Graph graph = new Graph("C:\\Users\\bayed\\IdeaProjects\\TP4 Algorithmique 1 Algorithme de dijkstra\\src\\com\\company\\graphe-50.txt");
        System.out.println(graph);

        //Graph graph1 = new Graph(4,1);
        //System.out.println(graph1);

        ArrayList<Integer> b = Dijkstra.dijkstra(graph,0);
        System.out.println(b);


        /*int[][] matrix1 = FloydWarshall.floydWarshall(graph);

        for (int i = 0 ; i < matrix1.length; i ++){
            for (int j = 0; j < matrix1.length; j++){
                System.out.print(matrix1[i][j]  + " ");
            }
            System.out.println("");
        }*/







    }
}
