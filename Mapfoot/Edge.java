import greenfoot.*;
/**
 * Write a description of class Edge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Edge implements Comparable 
{
    private Location vertex1;
    private Location vertex2;
    /**
     * Constructor for objects of class Edge
     */
    public Edge(Location vertex1, Location vertex2) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }
    public Location getVertex1() {
        return vertex1;
    }
    public Location getVertex2() {
        return vertex2;
    } 
    public double getDistance() {
        return Math.sqrt(Math.pow((vertex1.getX() - vertex2.getX()), 2) + Math.pow((vertex1.getY() - vertex2.getY()), 2));
    }
    public int compareTo(Object e) {
        return (int)(this.getDistance() - ((Edge)e).getDistance());
    }
    public void show(World w) {
        GreenfootImage bg = w.getBackground();
        bg.setColor( Color.ORANGE );
        bg.drawLine( vertex1.getX(), vertex1.getY(), vertex2.getX(), vertex2.getY() );
    } 
    public boolean equals(Object e) {
        return e.hashCode() == this.hashCode();
    }
    public Location getOtherNode(Location l) {
        if (l.equals(vertex1)) return vertex2;
        else return vertex1;
    }
}
