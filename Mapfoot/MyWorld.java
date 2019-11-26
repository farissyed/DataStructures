import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(961, 604, 1);
    }
    
    public void fillLocations(int num) {
        for(int i = 0; i < num; i++) {
            int x = (int)(Math.random() * getWidth());
            int y = (int)(Math.random() * getHeight());
            if (!getBackground().getColorAt(x,y).equals(Color.WHITE)){
                Location l = new Location();
                addObject(l,x,y);
            }
            else
            {
                i--;
            }
        }
    }
    public void drawEdges(List<Edge> edges) {
        for(Edge e : edges) {
            e.show(this);
            Greenfoot.delay(1);
        }
    }
    public List<Edge> completeGraph() {
        List<Location> locations = getObjects(Location.class);
        List<Edge> edges = new ArrayList<Edge>();
        for (Location l : locations) {
            for (Location a : locations) {
                if(!l.equals(a)){
                    edges.add(new Edge(l,a));
                }
            }
        }
        
        return edges;
    }
    public void drawComplete() {
        drawEdges(completeGraph());
    }
    public List<Edge> buildRandomConnections(int n) {
        List<Location> locations = getObjects(Location.class);
        List<Edge> edges = new ArrayList<Edge>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            Location l = locations.get(rand.nextInt(locations.size()));
            Location a = locations.get(rand.nextInt(locations.size()));
            if(!l.equals(a)){
                    edges.add(new Edge(l,a));
            }            
        }
        drawEdges(edges);
        return edges;
    }
    public boolean formsCycle(Collection<Edge> edges, Edge e) {
        return false;
    }
    public List<Edge> prim() {
        List<Location> locations = getObjects(Location.class);
        
        List<Location> visited = new ArrayList<>();
        List<Location> visitedTrail = new ArrayList<>();
        List<Edge> edges = new ArrayList<Edge>();
        Location start = locations.get(0);
        visited.add(start);
        List<Edge> possibleEdges = new ArrayList<Edge>();
        
        while (visited.size() != locations.size()) {
            visitedTrail.add(start);
            List<Edge> connectedEdges = start.getConnectedEdges();
            for (Edge e : connectedEdges) {
                possibleEdges.add(e);
            }
            Collections.sort(possibleEdges);
            Edge smallest = possibleEdges.get(0);
            //possibleEdges.remove(0);
            int i = 0;
            while( i<possibleEdges.size() 
            && visited.contains(smallest.getOtherNode(start)) == true) {
                smallest = possibleEdges.get(i);
                i++;
            }   
            i--;
            if(i>=possibleEdges.size()) {
                start = visitedTrail.get(visitedTrail.size()-2);
            }
            else{
                edges.add(smallest);
                visited.add(start);
                start=smallest.getOtherNode(start);
            }
        }
        drawEdges(edges);
        return edges;
    }
    
    //public List<Edge> prim2() {
        
    //}
}
