import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**Class that serves as representation of map that will be used in game */
public class Map {
    /**the map to that will be loaded in through .txt file */
    private char[][] map;
    /**The revealed status of the map */
    private boolean[][] revealed;
    /**single instance of the map class */
    private static Map mInstance = null;

    /**Constructor - instantiates map and revealed arrays
     * the populates the revealed array with all false values
     */
    private Map(){
        this.map = new char[5][5];
        this.revealed = new boolean[5][5]; 
    }

    /** Loads the map from one of the three Map#.txt files
     * @param mapNum the number of the map to be loaded.
     */
    public void loadMap(int mapNum){
        try {
            String mapFile = "Map" + mapNum + ".txt";
            File file = new File(mapFile);
            Scanner map = new Scanner(file);
            while (map.hasNextLine()){
                for (int i = 0; i < this.map.length; i++){
                    String line = map.nextLine().replace(" ", "");
                    for (int j = 0; j < this.map.length; j++){
                        this.map[i][j] = line.charAt(j);
                        this.revealed[i][j] = false;
                    }
                }
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } 
    }
    
    /** Gets the char at the specified point 
     * @param p the point where we want the char 
     * @return char the char at the point inputted
     */
    public char getCharAtLoc(Point p){
        return this.map[p.x][p.y];
    }

    /**Method to print out 5x5 map based on whether or not position is reavealed */
    public void displayMap(Point p){
        for (int i = 0; i < this.map.length; i++){
            for (int j = 0; j < this.map.length; j++){
                if (i == p.x && j == p.y){
                    System.out.print('*' + " ");
                    
                }
                else if(this.revealed[i][j]){
                    System.out.print(this.map[i][j] + " ");
                }
                else{
                    System.out.print('X' + " ");
                }
            }
            System.out.println();
        }
    }

    /** Method to iterate through the map and find the starting 
     *  location. Starting location labeled with 's' char
     * @return Point the location of the char 's'
     */
    public Point findStart(){
        Point point = new Point(0,0);
        for (int i = 0; i < this.map.length; i++){
            for (int j = 0; j < this.map.length; j++){
                if (this.map[i][j] == 's'){
                    point.x = i;
                    point.y = j;
                }
            }
        }
        return point;
    }

    /** Method to change the value of revealed instance variable 
     *  to true 
     * @param p the point that is to be revealed
     */
    public void reveal(Point p){
        revealed[p.x][p.y] = true;
    }

    /** Method to remove the char at specified location with char 'n' to show room is empty
     * @param p the location where the char will removed
     */
    public void removeCharAtLoc(Point p){
        this.map[p.x][p.y] = 'n';
    }
    
    /**
     * Method to get single map instance 
     * @return Map single instance
     */
    public static Map getInstance(){
        if (mInstance == null)
            mInstance = new Map();
        return mInstance;
        
    }
}