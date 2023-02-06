/**
 * *Created by : RIDA STITOU
 * Creation date : 06/02/2022
 * discrition : java program to calculate the distance between two points and assign it to a particular Object
 * The Child class represents a child with a label, x, and y coordinates.
 * It also has a field to store the closest Amb to it.
 */
class Child {
    private String label;
    private int x;
    private int y;
    private Amb closestAmb;

     /**
     * Constructor for the Child class.
     * 
     * @param label the label of the child
     * @param x the x coordinate of the child
     * @param y the y coordinate of the child
     */
    
    public Child(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }
 /**
     * Returns the label of the child.
     * 
     * @return the label of the child
     */
    public String getLabel() {
        return label;
    }

    /**
     * Returns the x coordinate of the child.
     * 
     * @return the x coordinate of the child
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y coordinate of the child.
     * 
     * @return the y coordinate of the child
     */
    public int getY() {
        return y;
    }
    
    /**
     * Returns the closest Amb to the child.
     * 
     * @return the closest Amb to the child
     */
    public Amb getClosestAmb() {
        return closestAmb;
    }

    /**
     * Sets the closest Amb to the child.
     * 
     * @param closestAmb the closest Amb to the child
     */
    public void setClosestAmb(Amb closestAmb) {
        this.closestAmb = closestAmb;
    }
}

/**
 * The Amb class represents an Ambrella with a label, x, and y coordinates.
 * It also has a method to calculate the distance between itself and a Child.
 */
class Amb {
    private String label;
    private int x;
    private int y;

     /**
     * Constructor for the Amb class.
     * 
     * @param label the label of the Ambrella
     * @param x the x coordinate of the Ambrella
     * @param y the y coordinate of the Ambrella
     */
    public Amb(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

     /**
     * Returns the label of the Ambrella.
     * 
     * @return the label of the Ambrella
     */
    public String getLabel() {
        return label;
    }

     /**
     * Returns the x coordinate of the Ambrella.
     * 
     * @return the x coordinate of the Ambrella
     */
    public int getX() {
        return x;
    }

       /**
     * Returns the y coordinate of the Ambrella.
     * 
     * @return the y coordinate of the Ambrella
     */
    public int getY() {
        return y;
    }

    /**
     *  Calculate the distance between two points using Pythagorean theorem 
     * @param child
     * @return Distance 
     */
    public double distance(Child child) {
        return Math.sqrt(Math.pow(child.getX() - x, 2) + Math.pow(child.getY() - y, 2));
    }
}

/**
     * Calculates and returns the distance between the ambulance and a Child.
     * 
     * @param child
     * @param amb
     **/

public class ChildAmbAssigner {
    public static void assign(Child[] childs, Amb[] ambs) {
    /**
     * Looping in Child Array so every time we get only one child
     */    
        for (Child child : childs) {
       /**  initialize the minDistance variable with the maximum possible distance       
       * The value of Double.MAX_VALUE is approximately 1.7976931348623157 x 10^308. 
        */  
            double minDistance = Double.MAX_VALUE;
       /** Set the closestAmb object of type amb to refer to null */
            Amb closestAmb = null;
             /** Looping in Amb array and calculate the distance using distance() function in Amb object  */
            for (Amb amb : ambs) {
             /** get the distance value in type Double   */
                double distance = amb.distance(child);
            /** Verify if the distance between Child and current Amb is less than minDistance
             * If it less : the value of minDistance will be changed to distance value and the closestAmb will refer to current Amb
             */
                if (distance < minDistance) {
                    minDistance = distance;
                    closestAmb = amb;
                }
            }
            
            /**
             * assign the closest Amb to the child
             */
            child.setClosestAmb(closestAmb);
        }
    }

    public static void main(String[] args) {
        
        Child[] childs = {
            new Child("Ali", -1, 2),
            new Child("Aicha", -1, -2),
            new Child("Mehdi", -1, -2)
        };
        Amb[] ambs = {
            new Amb("A", 3, 3),
            new Amb("B", 3, -3),
            new Amb("C", -3, -2)
        };
        assign(childs, ambs);
        for (Child child : childs) {
            System.out.println(child.getLabel() + " -> " + child.getClosestAmb().getLabel());
        }
    }
}
