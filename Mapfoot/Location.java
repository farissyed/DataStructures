import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Location here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Location extends Actor
{
    
    public void act() 
    {
        // Add your action code here.
    }  
    public String toString() {
        return "( " + getX() + ", " + getY() + " )";
    }
    @Override
    public int hashCode() {
        return toString().hashCode();
    }
    public boolean compareTo(Location x) {
        return this.toString().equals( x.toString());
    }
    public List<Edge> getConnectedEdges() {
        List<Edge> edges = ((MyWorld)getWorld()).completeGraph();
        List<Edge> connected = new ArrayList<Edge>();
        for(Edge e : edges) {
            if (e.getVertex1().equals(this) || e.getVertex2().equals(this)) {
                connected.add(e);
            }
        }
        return connected;
    }
}
