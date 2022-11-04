import java.util.Hashtable;
import java.util.Enumeration;

/** Creates a library
 * 
 */
public class Library extends Building{

    private Hashtable<String, Boolean> collection;
    private boolean hasElevator;

    /* Overloaded constructor with name, address */
    public Library(String name, String address) {
      super(name, address, 1); // Call full constructor with hard-coded # floors
    }

    /* Overloaded constructor with name, address, number of floors */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors); // Call full constructor with hard-coded # floors
    }

    /** Class constructor
    * @param Library's name, address and number of floors
    */
    public Library(String name, String address, int nFloors, boolean hElevator) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = hElevator;

      System.out.println("You have built a library: 📖");
    }
  
    
    /** Add a book to the collection 
    * @param Title of the book we want to add
    */
    public void addTitle(String title) {
      this.collection.put(title, true);
      System.out.println("The book "+ title +" has been added to the collection.");
    }

    
    /** Remove a book from the collection
    * @param title of the book we want to remove
    * @return title of the book we removed
    */
    public String removeTitle(String title) {
      this.collection.remove(title);
      System.out.println("The book "+ title +" has been removed from the collection.");
      return title;
    }

    
    /** Check out a book
    * @param title of the book we want to check out
    */
    public void checkOut(String title) {
      this.collection.replace(title, true, false);
      System.out.println("You are borrowing "+ title +". Enjoy, and please return it on time.");
    }

  
    /** Return a book
    * @param title of the book we want to return
    */
    public void returnBook(String title) {
      this.collection.replace(title, false, true);
      System.out.println("You have succesfully returned the book " + title);
    }

    
    /** See if the library has a book
    * @param title of the book we want to find
    * @return T/F: if the library has the book or not as part of their collection
    */
    public boolean containsTitle(String title) {
      //System.out.println(this.collection.containsKey(title));
      if (this.collection.containsKey(title) == true) {
        System.out.println("The book " + title + " is part of our collection");
      } else {
        System.out.println("The book " + title + " is not part of our collection");
      }
      return this.collection.containsKey(title); 
    }


    /** Check if a book is available
    * @param title of the book we want to find
    * @return T/F: if the book is currently available
    */
    public boolean isAvailable(String title) {
      //System.out.println(this.collection.get(title));
      if (this.collection.get(title) == true) {
        System.out.println("The book " + title + " is available");
      } else {
        System.out.println("The book " + title + " is not currently available");
      }

      return this.collection.get(title); 
    }

    /**Prints out the entire collection
     */
    public void printCollection() {
      Enumeration<String> keys = this.collection.keys();
      System.out.println("Neilson Library collection is composed by:");

      while (keys.hasMoreElements()) {
 
        // Displaying the Enumeration
        System.out.println(keys.nextElement());
    }
  }


    /** Method that ...
   * @param Floor number
   */
    public void goToFloor(int floorNum) {
      
      if (hasElevator == true && floorNum <= nFloors){
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      } else if (hasElevator == true && floorNum > nFloors) {
        System.out.println("You want to go to floor # " + floorNum + " but " + this.name + " only has " + this.nFloors + " floors. Please select one of those floors");
      }
      else{
        System.out.println("There is no elevator in this library.");
      }
    }

    /** Method that shows us the action options for the house building
   * @param None
   */
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + addTitle(title) \n + removeTitle(title) \n + checkOut(title) \n + returnBook(title) \n + containsTitle(title) \n + isAvailable(title) \n + printCollection() \n + goToFloor(floorNum)");
    }

    public static void main(String[] args) {
     Library Neilson = new Library("Neilson", "Smith College", 5, true);
     System.out.println(Neilson);
     Neilson.showOptions();
     Neilson.goToFloor(6);

     Neilson.addTitle("Don Quixote");
     Neilson.addTitle("La Odisea");
     Neilson.addTitle("Azul");
     Neilson.printCollection();

     Neilson.removeTitle("Azul");
     Neilson.printCollection();

     Neilson.checkOut("Don Quixote");
     Neilson.containsTitle("Don Quixote");
     Neilson.isAvailable("Don Quixote");

     Neilson.returnBook("Don Quixote");
     Neilson.isAvailable("Don Quixote");
    }
  
  }