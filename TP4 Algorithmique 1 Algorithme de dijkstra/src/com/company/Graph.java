package com.company;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Graph {

    private ArrayList<LinkedList<Arc>> adjacencyList;
    private String name;

    private int numberOfPick;
    private int density;


    /**
     * Constructeur permettant de générer de manière aléatoire un graphe
     * @param numberOfPick
     * @param density
     */
    public Graph(int numberOfPick, int density){
        this.density = density;
        this.numberOfPick = numberOfPick;
        this.adjacencyList= new ArrayList<>();
        for (int i = 0; i < this.numberOfPick; i++){
            adjacencyList.add(new LinkedList<Arc>());
        }
        int numberOfArc = this.density * numberOfPick * (numberOfPick -1);
        int i = 0;
        Random rand = new Random();
        while (i<numberOfArc){
            int pick = rand.nextInt(numberOfPick);
            int neighbor = rand.nextInt(numberOfPick );
            int weight = rand.nextInt(30);
            if (pick!=neighbor){
                Arc couple = new Arc(pick,neighbor,weight);
                for (int j = 0; j < adjacencyList.size(); j++){
                    if(  !(adjacencyList.get(j).contains(couple)) && couple.getStartingPick()==j ){
                        adjacencyList.get(j).add(couple);
                        i++;
                    }
                }
            }
        }
    }

    /**
     * Constructeur permettant de construire un graphe à partir d'un fichier texte
     * @param name
     */
    public Graph( String name ){
        this.name = name;
        this.numberOfPick = numberOfPick();
        this.adjacencyList = new ArrayList<>();

        LinkedList<Arc> arcList = arcRecovery();
        for ( int i = 0; i<numberOfPick; i++) {
            adjacencyList.add(new LinkedList<Arc>());
        }
        for (int i = 0; i < arcList.size(); i++){
            adjacencyList.get(arcList.get(i).getStartingPick()).add(arcList.get(i));
        }
    }


    /**
     * arcRecovery permet d'obtenir une liste d'arc à partir d'un fichier texte décrivant un arc
     * @param
     * @return
     */
    public LinkedList<Arc> arcRecovery() {
        LinkedList<Arc> arcList = null;

        try {
            InputStream flux = new FileInputStream(name);
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader bufferedReader = new BufferedReader(lecture);
            String line = bufferedReader.readLine();
            arcList = new LinkedList<>();
            while ((line = bufferedReader.readLine()) != null) {
                String[] tab1 = line.split(" ");
                arcList.add(new Arc(Integer.parseInt(tab1[0]), Integer.parseInt(tab1[1]), Integer.parseInt(tab1[2])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arcList;
    }


    /**
     * numberOfPick retourne la liste des sommets d'un graphe donnée sous forme de ficher texte
     * @return
     */
    public int numberOfPick(){
        int i = 0;
        try{
            InputStream flux = new FileInputStream(this.name);
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader bufferedReader = new BufferedReader(lecture);
            String line = bufferedReader.readLine();
            String[] tab = line.split(" ");
            String  element =  tab[0];
             i = Integer.parseInt(element);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }

    public int getNumberOfPick(){
        return numberOfPick;
    }

    /**
     * Liste retourne la liste des entiers allant de 0 à n - 1 d'un entier n
     * @param number
     * @return
     */
    public static ArrayList<Integer> liste(int number){
        ArrayList<Integer> liste = new ArrayList<>();
        for (int i = 0; i < number; i++){
            liste.add(i);
        }
        return liste;
    }

    /**
     * listOfNeighbor permet de retourner la liste des voisins des sommets d'un Graphe
     * @param sommet
     * @return
     */
    public  ArrayList<Arc> listOfNeighbor(int sommet){
        ArrayList<Arc> listOfNeighbor = new ArrayList<>();
        listOfNeighbor.addAll(adjacencyList.get(sommet));
        return listOfNeighbor;
    }

    /**
     * adjacencyMatrix permet de transformer une liste d'adjacence en matrice
     * @return
     */
    public  int[][] adjacencyMatrix(){
        int[][] tab= new int[numberOfPick][numberOfPick];
        for (int i = 0; i < numberOfPick; i++){
            for (int j = 0; j < numberOfPick; j++) {
                if (i == j) {
                    tab[i][j]=0;
                }
                else {
                    tab[i][j] = 100000000;
                }
            }
        }
        for (int i = 0; i < adjacencyList.size(); i++){
            for (Arc arc:adjacencyList.get(i)
                 ) {
                tab[arc.getStartingPick()][arc.getArrivalPick()] = arc.getWeight();
            }
        }
        return tab;
    }


    @Override
    public String toString(){
        return "Graphe" + adjacencyList;
    }
}
