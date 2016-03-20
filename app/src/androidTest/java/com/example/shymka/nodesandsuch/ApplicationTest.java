package com.example.shymka.nodesandsuch;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> testGraph =
            new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>
                    (DefaultWeightedEdge.class);

    void createGraph(SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>  graph) {

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

    public ApplicationTest() {
        super("com.example.shymka.nodesandsuch", MainActivity.class);
    }

    public void testEdgeAtoA(){
        Activity activity = getActivity();

        final EditText in1 = (EditText) activity.findViewById(R.id.Start);
        final EditText in2 = (EditText) activity.findViewById(R.id.Dest);
        createGraph(testGraph);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                in1.setText("TFDL");
                in2.setText("TFDL");
                DijkstraShortestPath path;
                path = new DijkstraShortestPath(testGraph, (String.valueOf(in1.getText())), (String.valueOf(in2.getText())));
                double distance = path.getPathLength();
                double zero = 0.0;
                assertEquals(distance, zero);
            }
        });

        activity.finish();
        setActivity(null);

    }

    public void testEdgeAtoB(){
        //DijkstraShortestPath path;
        //path = new DijkstraShortestPath(testGraph, "TFDL", "Craigie");
        //double distance =  path.getPathLength();
        /*Activity activity = getActivity();

        final EditText in3 = (EditText) activity.findViewById(R.id.Start);
        final EditText in4 = (EditText) activity.findViewById(R.id.Dest);
        testGraph.addVertex("Craigie");
        testGraph.addVertex("TFDL");
        DefaultWeightedEdge e1 = testGraph.addEdge("test", "Craigie");
        testGraph.setEdgeWeight(e1, 150.0);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                in3.setText("TFDL");
                in4.setText("Craigie");
                //testGraph.addVertex("TFDL");
                if(testGraph.containsVertex("TFDL")) {
                    DijkstraShortestPath path;
                    path = new DijkstraShortestPath(testGraph, String.valueOf(in3.getText()), String.valueOf(in4.getText()));
                    double distance = path.getPathLength();
                    assertEquals(distance, 150.0);
                }else{
                    fail();
                }
            }
        });
        activity.finish();
        setActivity(null);
        */

        testGraph.addVertex("TFDL");
        testGraph.addVertex("Craigie");
        DefaultWeightedEdge e1 = testGraph.addEdge("TFDL", "Craigie");
        testGraph.setEdgeWeight(e1, 150.0);
        DijkstraShortestPath path;
        path = new DijkstraShortestPath(testGraph, "TFDL", "Craigie");
        double distance = path.getPathLength();
        assertEquals(distance, 150.0);

    }

    public void testEdgeAtoBShortest(){
        //DijkstraShortestPath path;
        //path = new DijkstraShortestPath(testGraph, "TFDL", "Kines");
        //double distance =  path.getPathLength();

        testGraph.addVertex("TFDL");
        testGraph.addVertex("Craigie");
        testGraph.addVertex("Kines");
        testGraph.addVertex("MacHall");

        DefaultWeightedEdge e1 = testGraph.addEdge("TFDL", "Craigie");
        testGraph.setEdgeWeight(e1, 150.0);

        DefaultWeightedEdge e2 = testGraph.addEdge("TFDL", "MacHall");
        testGraph.setEdgeWeight(e2, 50.0);

        DefaultWeightedEdge e3 = testGraph.addEdge("MacHall", "Kines");
        testGraph.setEdgeWeight(e3, 150.0);

        DefaultWeightedEdge e4 = testGraph.addEdge("Craigie", "Kines");
        testGraph.setEdgeWeight(e4, 350.0);

        DijkstraShortestPath path;
        path = new DijkstraShortestPath(testGraph, "TFDL", "Kines");
        double distance = path.getPathLength();
        assertEquals(distance, 200.0);
    }

    public void testEdgeLeastNodes(){
        //DijkstraShortestPath path;
        //path = new DijkstraShortestPath(testGraph, "Craigie", "Kines");
        //double distance =  path.getPathLength();

        testGraph.addVertex("TFDL");
        testGraph.addVertex("Craigie");
        testGraph.addVertex("Kines");
        testGraph.addVertex("MacHall");

        DefaultWeightedEdge e1 = testGraph.addEdge("Craigie", "TFDL");
        testGraph.setEdgeWeight(e1, 150.0);

        DefaultWeightedEdge e2 = testGraph.addEdge("TFDL", "MacHall");
        testGraph.setEdgeWeight(e2, 50.0);

        DefaultWeightedEdge e3 = testGraph.addEdge("MacHall", "Kines");
        testGraph.setEdgeWeight(e3, 150.0);

        DefaultWeightedEdge e4 = testGraph.addEdge("Craigie", "Kines");
        testGraph.setEdgeWeight(e4, 350.0);

        DijkstraShortestPath path;
        path = new DijkstraShortestPath(testGraph, "Craigie", "Kines");
        double distance = path.getPathLength();
        assertEquals(distance, 350.0);
        //compare 2 paths of equal length but different number of nodes between them
    }

    public void testEqualPathOptions(){
        //DijkstraShortestPath path;
        //path = new DijkstraShortestPath(testGraph, "MacHall", "Admin");
        //double distance =  path.getPathLength();

        testGraph.addVertex("TFDL");
        testGraph.addVertex("ICT");
        testGraph.addVertex("Admin");
        testGraph.addVertex("MacHall");

        DefaultWeightedEdge e1 = testGraph.addEdge("MacHall", "ICT");
        testGraph.setEdgeWeight(e1, 50.0);

        DefaultWeightedEdge e2 = testGraph.addEdge("ICT", "Admin");
        testGraph.setEdgeWeight(e2, 250.0);

        DefaultWeightedEdge e3 = testGraph.addEdge("MacHall", "TFDL");
        testGraph.setEdgeWeight(e3, 150.0);

        DefaultWeightedEdge e4 = testGraph.addEdge("TFDL", "Admin");
        testGraph.setEdgeWeight(e4, 150.0);

        DijkstraShortestPath path;
        path = new DijkstraShortestPath(testGraph, "MacHall", "Admin");
        double distance = path.getPathLength();
        assertEquals(distance, 300.0);
       //compare 2 paths of equal length and equal nubmer of nodes between them
    }
}