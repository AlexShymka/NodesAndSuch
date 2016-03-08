package com.example.shymka.nodesandsuch;

import org.jgrapht.*;
import org.jgrapht.alg.*;
import org.jgrapht.graph.*;

import java.util.List;

public class Graph {
    public static void init(){

        SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>  graph =
                new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>
                        (DefaultWeightedEdge.class);
        graph.addVertex("Admin");
        graph.addVertex("TFDL");
        graph.addVertex("Craigie");
        graph.addVertex("ICT");
        graph.addVertex("MacHall");
        graph.addVertex("Kines");


        DefaultWeightedEdge e1 = graph.addEdge("Craigie", "TFDL");
        graph.setEdgeWeight(e1, 150);

        DefaultWeightedEdge e2 = graph.addEdge("TFDL", "Craigie");
        graph.setEdgeWeight(e2, 150);

        DefaultWeightedEdge e3 = graph.addEdge("TFDL", "Admin");
        graph.setEdgeWeight(e3, 80);

        DefaultWeightedEdge e4 = graph.addEdge("Admin", "TFDL");
        graph.setEdgeWeight(e4, 80);

        DefaultWeightedEdge e5 = graph.addEdge("Admin", "ICT");
        graph.setEdgeWeight(e5, 600);


        DefaultWeightedEdge e6 = graph.addEdge("ICT", "Admin");
        graph.setEdgeWeight(e6, 600);

        DefaultWeightedEdge e7 = graph.addEdge("ICT", "MacHall");
        graph.setEdgeWeight(e7, 300);

        DefaultWeightedEdge e8 = graph.addEdge("MacHall", "ICT");
        graph.setEdgeWeight(e8, 300);

        DefaultWeightedEdge e9 = graph.addEdge("TFDL", "MacHall");
        graph.setEdgeWeight(e9, 100);

        DefaultWeightedEdge e10 = graph.addEdge("MacHall", "TFDL");
        graph.setEdgeWeight(e10, 100);

        DefaultWeightedEdge e11 = graph.addEdge("Kines", "MacHall");
        graph.setEdgeWeight(e9, 50);

        DefaultWeightedEdge e12 = graph.addEdge("MacHall", "Kines");
        graph.setEdgeWeight(e10, 50);

        System.out.println("Shortest path from Admin to Craigie:");
        List shortest_path =   DijkstraShortestPath.findPathBetween(graph, "Admin", "Craigie");
        System.out.println(shortest_path);
        DijkstraShortestPath path;
        path = new DijkstraShortestPath(graph, "Admin", "Craigie");
        double distance =  path.getPathLength();
        System.out.println("Shortest Distance from Admin to Craigie:");
        System.out.println(distance);
    }


}