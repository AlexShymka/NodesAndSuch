package com.example.shymka.nodesandsuch;

import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import java.util.List;

/**
 * Created by alex on 3/20/2016.
 */
public class Controller {
    SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> graph =
            new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>
                    (DefaultWeightedEdge.class);
    List shortestPath;
    Double distance;
    String instructions;


    public Controller(){
        createGraph(graph);
    }

    public List getInstructions(String start, String dest){
        shortestPath = getList(start, dest);
        return shortestPath;
    }

    private List getList(String start, String dest){
        List shortest_path =   DijkstraShortestPath.findPathBetween(graph, start, dest);
        return shortest_path;
    }
    public Double getDist(String start, String dest){
        DijkstraShortestPath path;
        path = new DijkstraShortestPath(graph, start, dest);
        double distance =  path.getPathLength();
        return distance;
    }

    public void createGraph(SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>  graph) {

        graph.addVertex("Admin");
        graph.addVertex("TFDL");
        graph.addVertex("Craigie");
        graph.addVertex("ICT");
        graph.addVertex("MacHall");
        graph.addVertex("Kines");
        graph.addVertex("1");

        DefaultWeightedEdge e1 = graph.addEdge("Craigie", "TFDL");
        graph.setEdgeWeight(e1, 150);

        DefaultWeightedEdge e2 = graph.addEdge("TFDL", "Craigie");
        graph.setEdgeWeight(e2, 150);

        DefaultWeightedEdge e3 = graph.addEdge("TFDL", "Admin");
        graph.setEdgeWeight(e3, 150);

        DefaultWeightedEdge e4 = graph.addEdge("Admin", "TFDL");
        graph.setEdgeWeight(e4, 150);

        DefaultWeightedEdge e5 = graph.addEdge("Admin", "ICT");
        graph.setEdgeWeight(e5, 250);

        DefaultWeightedEdge e6 = graph.addEdge("ICT", "Admin");
        graph.setEdgeWeight(e6, 250);

        DefaultWeightedEdge e7 = graph.addEdge("ICT", "MacHall");
        graph.setEdgeWeight(e7, 50);

        DefaultWeightedEdge e8 = graph.addEdge("MacHall", "ICT");
        graph.setEdgeWeight(e8, 50);

        DefaultWeightedEdge e9 = graph.addEdge("TFDL", "MacHall");
        graph.setEdgeWeight(e9, 150);

        DefaultWeightedEdge e10 = graph.addEdge("MacHall", "TFDL");
        graph.setEdgeWeight(e10, 150);

        DefaultWeightedEdge e11 = graph.addEdge("Kines", "MacHall");
        graph.setEdgeWeight(e11, 50);

        DefaultWeightedEdge e12 = graph.addEdge("MacHall", "Kines");
        graph.setEdgeWeight(e12, 50);

        DefaultWeightedEdge e13 = graph.addEdge("Craigie", "Kines");
        graph.setEdgeWeight(e13, 350);

        DefaultWeightedEdge e14 = graph.addEdge("Kines", "Craigie");
        graph.setEdgeWeight(e14, 350);


    }
}
