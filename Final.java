/*
 *  This file is the set up and solution to the lab final of Fall 2023.
 *  
 *  by R. Heise
 *  Dec 11, 2023 at 9:25:28 p.m.
 *  
 */
import java.util.LinkedList;
//only use: constructor, addFirst, addLast, removeFirst, removeLast, size, 
//and isEmpty

public class Final {
    //=========================================================================
    //=========================================================================
    //=========================================================================
    //=========================================================================
    // Put your code here for nested class SearchSpot
   
    
    /**
     * Nested class called SearchSpot
     * 
     * Default constructor: 
     * public SearchSpot(int row, int column)
     * toString: 
     * public String toString()
     */
    public static class SearchSpot {
    //Data field
    public int row;
    public int column;
    //Data field 
    
    /**
     * Default constructor for SearchSpot 
     * @param row
     * @param column 
     */
    public SearchSpot(int row, int column) {
        this.row = row;
        this.column = column;
    }//default constructor 

    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }
}//SearchSpot nested class 

    



    //=========================================================================
    //=========================================================================ca   
    // Put your code here for findTreasure

    /**
     * This method works with the nested class SearchSpot,
     * it goes through a 2D array/map with the goal of finding a row and column
     * value equivalent to value in row/col point on the array/map, for example
     * if the row is 5 and the column is 2, and the value at that point is 52, 
     * then the treasure has been found. Returns the path taken in the form 
     * of the data structure of a linked list 
     * @param array The 2D array/map passed into the method that searches for
     * the treasure. 
     * @return the path taken in order to find the treasure, as well as if it
     * has found the treasure or not. If one of the base cases are satisfied 
     * it returns null as the path instead. 
     */
    public static LinkedList<SearchSpot> findTreasure(int[][] array) {
     //if array size is null it returns null 
     //base case 
    if (array == null || array.length == 0) {
        System.out.println("Treasure not found");
        return null;
    }//if 

    LinkedList<SearchSpot> path = new LinkedList<>();
    //the limit variable limits the method to check over the array to one greater 
    //than the size of the array. 
    int limit = array.length * array.length + 1;
    //setting variables
    int row = 0;
    int column = 0;
    //number of checks 
    int check = 0;

    
   //while loop to stop the method iterating over the array multiple times 
   //rather it stops checking at the one plus the length of the array. 
   //Being the limit variable
    while (check < limit) {
        if (row < 0 || row >= array.length || column < 0 || column >= array[0].length) {
            System.out.println("Treasure not found");
            return null;
        }//if 
        //getting each value for row and column 
        int value = array[row][column];
        int rowClue = value / 10 - 1;
        int columnClue = value % 10 - 1;

        path.addLast(new SearchSpot(row + 1, column + 1));
        if (row == rowClue && column == columnClue) {
            System.out.println("Found treasure");
            return path;
        }//if 
        //sets row and column to where it currently is in the array. 
        row = rowClue;
        column = columnClue;
        check++;
    }//while loop
    //If the code is checked for one more than the size of the it 
    //array prints this
    System.out.println("Treasure not found");
    return null;
}//FindTreasure method 

    
    



    //=========================================================================
    //=========================================================================   
    //=========================================================================
    //=========================================================================

    
    
    
    //=========================================================================
    //=========================================================================
    //Any code placed below here will not be evaluated towards your grade
    //on this lab exam
    
    public static void main(String[] args) {
        System.out.println("Testing 1 2 3...");
        testTreasure();
        System.out.println("\n===========================================");
        testSumMinMax();
    }
    
    /**
     * Tests a bunch of different square arrays for treasure (invariant 
     * points).
     */
    public static void testTreasure(){
        LinkedList<SearchSpot> path;
        int[][] map1 = {{34, 21, 32, 41, 25},
                        {14, 42, 43, 14, 31},
                        {54, 45, 52, 42, 23},
                        {33, 15, 51, 31, 35},
                        {21, 52, 33, 13, 23}};
        
        int[][] map2 = {{62, 13, 53, 14, 51, 66},
                        {12, 25, 43, 31, 56, 42},
                        {55, 42, 36, 22, 26, 54},
                        {51, 34, 45, 61, 13, 22},
                        {51, 44, 36, 54, 25, 66},
                        {54, 35, 63, 15, 21, 45}};
        
        int[][] map3 = {{11, 31, 22},
                        {32, 12, 21},
                        {13, 32, 23}};
        
        int[][] map4 = {{55, 12, 25, 37, 78, 19, 81, 43, 83},
                        {14, 23, 48, 59, 93, 52, 59, 96, 54},
                        {72, 65, 19, 97, 35, 49, 41, 76, 13},
                        {48, 65, 57, 44, 85, 24, 17, 15, 19},
                        {79, 61, 65, 58, 61, 32, 72, 41, 18},
                        {82, 39, 31, 53, 74, 58, 67, 32, 69},
                        {15, 29, 28, 74, 99, 75, 17, 78, 56},
                        {29, 33, 85, 11, 22, 67, 87, 94, 43},
                        {91, 81, 95, 69, 76, 35, 16, 98, 21}};  
        
        int[][] map5 = {{11}};
        
        int[][] map6 = {{55, 12, 25, 37, 78, 19, 81, 43, 83},
                        {14, 23, 48, 59, 93, 52, 59, 96, 54},
                        {72, 65, 19, 97, 35, 49, 41, 76, 13},
                        {48, 65, 57, 44, 85, 24, 17, 15, 19},
                        {79, 61, 65, 58, 61, 32, 72, 41, 18},
                        {82, 39, 31, 53, 74, 58, 67, 32, 69},
                        {15, 29, 28, 74, 99, 75, 17, 12, 56},
                        {29, 33, 85, 11, 22, 67, 87, 94, 43},
                        {91, 81, 95, 69, 76, 35, 16, 98, 21}};
        
        int[][] map7 = {{55, 21, 25, 37, 78, 19, 81, 43, 83},
                        {14, 23, 48, 59, 93, 52, 59, 96, 54},
                        {72, 65, 19, 97, 35, 49, 41, 76, 13},
                        {48, 65, 57, 44, 85, 24, 17, 15, 19},
                        {79, 61, 65, 58, 61, 32, 72, 41, 18},
                        {82, 39, 31, 53, 74, 58, 67, 32, 69},
                        {15, 29, 28, 74, 99, 75, 17, 12, 56},
                        {29, 33, 85, 11, 22, 67, 87, 94, 43},
                        {91, 81, 95, 69, 76, 35, 16, 98, 21}};
        
        int[][] map8 = {};
        
        int[][] map9 = {{33, 23, 13},
                        {32, 21, 13},
                        {22, 12, 31}};
           
        System.out.println("Map 1");
        printGrid(map1);
        path = findTreasure(map1);
        System.out.println(path);
        
        System.out.println("\n\nMap 2");
        printGrid(map2);
        path = findTreasure(map2);
        System.out.println(path);
        
        System.out.println("\n\nMap 3");
        printGrid(map3);
        path = findTreasure(map3);
        System.out.println(path);
        
        System.out.println("\n\nMap 4");
        printGrid(map4);
        path = findTreasure(map4);
        System.out.println(path);
        
        System.out.println("\n\nMap 5");
        printGrid(map5);
        path = findTreasure(map5);
        System.out.println(path);
        
        System.out.println("\n\nMap 6");
        printGrid(map6);
        path = findTreasure(map6);
        System.out.println(path);
        
        System.out.println("\n\nMap 7");
        printGrid(map7);
        path = findTreasure(map7);
        System.out.println(path);
        
        System.out.println("\n\nMap 8  null");
        printGrid(map8);
        path = findTreasure(map8);
        System.out.println(path);
        
        System.out.println("\n\nMap 9");
        printGrid(map9);
        path = findTreasure(map9);
        System.out.println(path);
    }//testTreasure
    
    /**
     * Prints a 2-d array of 2 digit ints to standard output.
     * Puts a space between each int.  Has column and row numbers.
     * 
     * @param grid the array to print
     */
    public static void printGrid(int[][] grid){
        if (grid.length == 0) //print nothing if empty
            return;
        
        //top indices
        System.out.print("    ");
        for(int col = 1; col <= grid[0].length; col++){
            System.out.printf("%2d ", col);
        }   
        System.out.println();
        
        //border
        System.out.print("    ");
        for(int col = 1; col <= grid[0].length; col++){
            System.out.print("---");
        }
        System.out.println();
        
        //body and row numbers (with border)
        for(int row = 0; row < grid.length; row++){
            System.out.print((row + 1) + " |  ");
            for(int col = 0; col < grid[row].length; col++){
                System.out.printf("%2d ", grid[row][col]);
            }
            System.out.println();
        }
    }//printGrid
    
    public static void testSumMinMax(){
        BSTree myEmployees = new BSTree();
        
        System.out.println("Test sumMinMax empty tree");
        System.out.println(myEmployees.sumMinMax());
        
        myEmployees.insert(50, "Bugs Bunny");
        System.out.println("Tree: " + myEmployees);
        System.out.println(myEmployees.sumMinMax());
        
        myEmployees.insert(30, "Mickey Mouse");
        System.out.println("Tree: " + myEmployees);
        System.out.println(myEmployees.sumMinMax());
        
        myEmployees.insert(80, "Minnie Mouse");
        System.out.println("Tree: " + myEmployees);
        System.out.println(myEmployees.sumMinMax());
        
        myEmployees.insert(25, "Donald Duck");
        System.out.println("Tree: " + myEmployees);
        System.out.println(myEmployees.sumMinMax());
        
        myEmployees.insert(65, "Pluto");
        System.out.println("Tree: " + myEmployees);
        System.out.println(myEmployees.sumMinMax());
        
        myEmployees.insert(40, "Santa Claus");
        System.out.println("Tree: " + myEmployees);
        System.out.println(myEmployees.sumMinMax());
        
        myEmployees.insert(100, "Queen Elsa");
        System.out.println("Tree: " + myEmployees);
        System.out.println(myEmployees.sumMinMax());
        
        myEmployees.insert(70, "Anna");
        System.out.println("Tree: " + myEmployees);
        System.out.println(myEmployees.sumMinMax());
        
        myEmployees.insert(58, "Olaf");
        System.out.println("Tree: " + myEmployees);
        System.out.println(myEmployees.sumMinMax());
        
        myEmployees.insert(101, "Ausci 235");
        System.out.println("Tree: " + myEmployees);
        System.out.println(myEmployees.sumMinMax());
        
        myEmployees.insert(10, "Java Reigns");
        System.out.println("Tree: " + myEmployees);
        System.out.println(myEmployees.sumMinMax());
    }   
    
}