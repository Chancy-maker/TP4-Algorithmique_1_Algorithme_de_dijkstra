package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class FloydWarshall {
    public FloydWarshall(){

    }

    /**
     * floydWarshall est la fonction permettant l'application de l'algorithme de floyd-warshall sur un graphe
     * @param graph
     * @return
     */
    public static int[][] floydWarshall(Graph graph){
        int[][] matrix = graph.adjacencyMatrix();
        for (int k = 0; k < graph.numberOfPick(); k++ ){
            for (int i = 0; i < graph.numberOfPick(); i++){
                for (int j = 0; j < graph.numberOfPick(); j++){
                    if (matrix[i][j] > (matrix[i][k] + matrix[k][j]))
                        matrix[i][j] = (matrix[i][k] + matrix[k][j]);
                }
            }
        }
        return matrix;
    }
}
