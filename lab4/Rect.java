public class Rect{
    private int x; 
    private int y; 
    private int width;
    private int height;

    /**
     * Constructor of rectangle object
     * @param x value of rectangle 
     * @param y value of rectangle
     * @param width of rectangle 
     * @param height of rectangle 
     */
    public Rect(int x, int y, int width, int height){
        this.x = x;
        this.y = y; 
        this.width = width;
        this.height = height;
    }

    
    /** 
     * Method for returning the x-value of rectangle
     * @return int X-value
     */
    public int getX(){
        return this.x;
    }

    
    /** 
     * Method for returning the y-value of rectangle 
     * @return int Y-value
     */
    public int getY(){
        return this.y;
    }

    
    /** 
     * Method for returning the width of rectangle 
     * @return int Width
     */
    public int getWidth(){
        return this.width;
    }

    
    /** 
     * Method for returning the height of rectangle
     * @return int Height
     */
    public int getHeight(){
        return this.height;
    }
}