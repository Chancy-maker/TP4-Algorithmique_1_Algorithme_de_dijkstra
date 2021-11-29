package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {


    public Dijkstra(){

    }

    /**
     *dijkstra est la fonction permettant d'efefectuer l'algorithme de dikstra sur un graphe
     * @param graphe
     * @param picke
     * @return
     */
    public static ArrayList<Integer> dijkstra(Graph graphe, int picke){
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> f = Graph.liste(graphe.getNumberOfPick());
        ArrayList<Integer> d = new ArrayList<>();
        for (int i = 0; i< f.size(); i++){
            d.add(100000);
        }
        d.set(picke, 0);
        while (!f.isEmpty()){
            int u = extraireMinimum(f,d);


            ArrayList<Arc> neighbors = graphe.listOfNeighbor(u);

            for (Arc v : neighbors){
                if (d.get(v.getArrivalPick()) > (d.get(u) + v.getWeight())){
                    d.set(v.getArrivalPick(), (d.get(u) + v.getWeight()));
                }
            }
            a.add(u);
        }
        return d;
    }

    /**
     * extraireMinimum permet d'extraire le minimum d'une liste de priorité
     * @param queue
     * @param d
     * @return
     */
    public static int extraireMinimum(ArrayList<Integer> queue, ArrayList<Integer> d){
        int indiceSommet = 0;
        int sommet = queue.get(0);
        int minimum = d.get(sommet);
        for (int i = 1 ; i < queue.size() ; i++ ){
            if(minimum > d.get(queue.get(i)) ){
                minimum = d.get(queue.get(i));
                indiceSommet = i;
                sommet = queue.get(i);
            }
        }
        swap(queue,queue.size() - 1,indiceSommet);
        queue.remove(queue.size() - 1);
        return sommet;
    }

    /**
     * swap permet de permuter deux élément dans une liste
     * @param list
     * @param i
     * @param j
     */
    public static void swap(ArrayList<Integer> list, int i , int j){
        int perm = list.get(i);
        list.set(i,list.get(j));
        list.set(j,perm);
    }
}
