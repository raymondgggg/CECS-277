/**Represents a location (x,y) in a coordinate plane*/
public class Point {
    /**Represents the x coordinate of this point */
    public int x; 
    /**Represents the y coordinate of this point */
    public int y;

    /**Constructs a point at (x,y)
     * @param x the x coordinate of the new point
     * @param y the y coordinate of the new point 
     */
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}