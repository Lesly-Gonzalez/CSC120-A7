import java.util.ArrayList;



/** Creates a house
 * 
 */
public class House extends Building{

  private ArrayList<String> residents;
  private boolean hasDiningRoom;

/** Class constructor 
 * @param House's name, address, number of floors, and whether or not it has a dinning room
 */
  public House(String name, String address, int nFloors, boolean hDiningRoom) {
    super(name, address, nFloors); //The first set of step for constructing this house is constructing a building
    this.hasDiningRoom = hDiningRoom;
    this.residents = new ArrayList<String>();
 
    System.out.println("You have built a house: 🏠");
  }


/** Tell us if there is a dinning room in the house
 * @param None
 * @return T/F: Whether the house has a dinning room or not.
 */
  public boolean hasDiningRoom(){
    if (hasDiningRoom == true){
        System.out.println("There is a dining hall in this house.");
      }
      else{
        System.out.println("There is no dining hall in this house.");
      }
      return hasDiningRoom;
  }

  
/** Get the number of residents in the house
 * @param None
 * @return number of residents in the house
 */
  public int nResidents() {
    return this.residents.size();
  }

/** Method to update the `ArrayList` of `residents` every time someone moves in
 * @param Name of the person moving into the house
 */ 
  public void moveIn(String name) {
    this.residents.add(0,name); //add.(index, new resident)
  }

  
/** Method to update the `ArrayList` of `residents` every time someone moves out
 * @param Name of the person moving out of the house
 * @return name of the person who moved out of the house.
 */
  public String moveOut(String name) {
    this.residents.remove(String.valueOf(name));
    return name; 
  }

/** Method that tells us whether or not a given person is a resident of the `House`
 * @param Name of the person 
 * @return T/F: if this person is a resident of the house
 */
  public boolean isResident(String person) {
    return this.residents.contains(person);
  }

  public static void main(String[] args) {
    House chase = new House("Chase", "134 Elm st", 4, true);
    System.out.println(chase);
    System.out.println(chase.hasDiningRoom());
    System.out.println("Chase house has " + chase.nResidents() + " residents");
    chase.moveIn("Lesly");
    System.out.println("Chase house has " + chase.nResidents() + " residents");
    chase.moveIn("Katalina");
    System.out.println("Chase house has " + chase.nResidents() + " residents");
    chase.moveIn("Anglis");
    chase.moveIn("Bianca");
    System.out.println("Chase house has " + chase.nResidents() + " residents");
    System.out.println(chase.moveOut("Bianca") + " moved out");
    System.out.println(chase.isResident("Lesly"));
    System.out.println(chase.isResident("Bianca"));
  }

}