package com.example.shymka.nodesandsuch;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.jgrapht.*;
import org.jgrapht.Graph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText start;
    private EditText dest;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        start = (EditText) findViewById(R.id.Start);
        dest = (EditText) findViewById(R.id.Dest);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               createGraph();


            }
        });


                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void createGraph() {

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


        String firstNum = (String.valueOf(start.getText()));
        String secNum = (String.valueOf(dest.getText()));

       // System.out.println("Shortest path from Admin to Craigie:");
        List shortest_path =   DijkstraShortestPath.findPathBetween(graph, firstNum, secNum);
        System.out.println(shortest_path);
        DijkstraShortestPath path;
        path = new DijkstraShortestPath(graph, firstNum, secNum);
        double distance =  path.getPathLength();
        //System.out.println("Shortest Distance from Admin to Craigie:");
        System.out.println(distance);



        Toast.makeText(MainActivity.this, "Path is" + shortest_path + " Dist: " + distance, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.shymka.nodesandsuch/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.shymka.nodesandsuch/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
