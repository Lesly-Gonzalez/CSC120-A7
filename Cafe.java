

/** Creates a cafe 
 * 
 */
public class Cafe extends Building{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory


    /* Overloaded constructor with name, address */
    public Cafe(String name, String address) {
        super(name, address, 1); // Call full constructor with hard-coded # floors
        this.nCoffeeOunces = 100;
        this.nSugarPackets = 20;
        this.nCreams = 10;
        this.nCups = 120;
    }

    /** Class constructor
    * @param Cafe's name, address and number of floors
    */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 100;
        this.nSugarPackets = 20;
        this.nCreams = 10;
        this.nCups = 120;

        System.out.println("You have built a cafe: ☕");
    }

    
    /** Sell a cup of coffee!!
    * @param size of order (ounces), number of sugar packets, amount of cream, number of cups
    */

    //public void sellCoffee(int size, int nSugarPackets, int nCreams); Am I allowed to change this?
    public void sellCoffee(int size, int sugar, int cream) { //change it: delete cup, and have the exact name for the method call
        this.nCoffeeOunces = this.nCoffeeOunces - size;
        this.nSugarPackets = this.nSugarPackets - sugar;
        this.nCreams = this.nCreams - cream;
        this.nCups = this.nCups - 1;

        restock(size, sugar, cream, this.nCups);

        System.out.println("Here is your order of one cup of coffee with "
        + size + " ounces of expresso, " + sugar + " packets of sugar and " +
        cream + " packets of cream. Enjoy!");
    }

    /* Overloaded sellCoffee method to include number of cups */
    //public void sellCoffee(int size, int nSugarPackets, int nCreams); 
    public void sellCoffee(int size, int sugar, int cream, int cups) {
        this.nCoffeeOunces = this.nCoffeeOunces - size;
        this.nSugarPackets = this.nSugarPackets - sugar;
        this.nCreams = this.nCreams - cream;
        this.nCups = this.nCups - cups;

        restock(size, sugar, cream, this.nCups);

        System.out.println("Here is your order of " + cups + " cups of coffee with "
        + size + " ounces of expresso, " + sugar + " packets of sugar and " +
        cream + " packets of cream. Enjoy!");
    }

        
        /** Restock the inventory
        * @param size of order (ounces), number of sugar packets, amount of cream, number of cups
        */

    private void restock(int size, int sugar, int cream, int nCups) {
        if (size > this.nCoffeeOunces){
            this.nCoffeeOunces = this.nCoffeeOunces*10;
            System.out.println("Just a moment. We're restocking the coffee");
         }
        if (sugar > this.nSugarPackets) {
            this.nSugarPackets = this.nSugarPackets*10;
            System.out.println("Just a moment. We're restocking the sugar");
        }
        if (cream > this.nCreams) {
            this.nCreams = this.nCreams*10;
            System.out.println("Just a moment. We're restocking the cream");
        }
        if(1 == nCups) {
            this.nCups = this.nCups*10;
            System.out.println("Just a moment. We're restocking the cups");
        }
     }
    

    public static void main(String[] args) {
        Cafe Compass = new Cafe("Compass", "Smith College", 1);
        System.out.println(Compass);

        Compass.sellCoffee(10, 5, 3);
        Compass.sellCoffee(15, 7, 10);
        Compass.sellCoffee(20, 20, 8);

        Compass.sellCoffee(15, 7, 4, 3);
        

    }
    
}
