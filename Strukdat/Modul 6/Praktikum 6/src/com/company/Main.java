package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Graph {
    private final int V;

    private final LinkedList<Integer>[] adj;
    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i){
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSCheck(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]){
                DFSCheck(n, visited);
            }
        }
    }

    void DFS(int v) {
        boolean[] visited = new boolean[V];
        DFSCheck(v, visited);
    }

    void BFS(int s) {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

    }
}
public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Graph graph = new Graph(12);
        int no;

        graph.addEdge(1, 2);
        graph.addEdge(2, 1);
        graph.addEdge(2, 5);
        graph.addEdge(5, 2);
        graph.addEdge(5, 3);
        graph.addEdge(5, 7);
        graph.addEdge(5, 9);
        graph.addEdge(9, 5);
        graph.addEdge(9, 8);
        graph.addEdge(8, 9);
        graph.addEdge(8, 11);
        graph.addEdge(11, 10);
        graph.addEdge(11, 7);
        graph.addEdge(7,  11);
        graph.addEdge(7, 6);
        graph.addEdge(6, 7);
        graph.addEdge(1, 4);
        graph.addEdge(4, 6);
        do {
            System.out.print("\nInput Start : ");
            no = userInput.nextInt();
            System.out.print("DFS : ");
            graph.DFS(no);
            System.out.print("\nBFS : ");
            graph.BFS(no);
        }while(no != 0);





    }
}
