import java.util.Set;

/*
 * Zookeeper is the superclass of all the Zookeepers from the zoo.
 * They have a treat and moveFood method. It also has the aMonthPasses
 * method which is called every month by the Zoo.
 */

public class Zookeeper {
	int waste = 20;
	Zoo zoo;
	Enclosure enclosure;
	Foodstore zoofoodstore;
	/*
	 * A constructor which takes enclosure and zoo as a parameter
	 * and sets the foodstore to the zoofoodstore
	 */
	public Zookeeper(Enclosure enclosure, Zoo zoo){
		this.enclosure = enclosure;
		this.zoo = zoo;
		this.zoofoodstore = zoo.zoofoodstore;
	}
	
	/*
	 * This method gives a treat to the animal.
	 */

	public void treat(){
		//Creates a variable which stores the treatedAnimals
		int treatedAnimals = 0;
		for(Animal animal : enclosure.GetAnimalList()) {
			try {
				//The general Zookeeper is allowed to only hug and stroke animals
				if(animal.getTreatName().equals("hug") || animal.getTreatName().equals("stroked")) {
					animal.treat();
					treatedAnimals++;
				}
				//The Zookeeper is allowed to give treat to up to 2 animals.
				//It stops if treatedAnimals equals 2.
				if(treatedAnimals == 2) {
					break;
				}
				//Prints out an Exception if the Zookeeper is not qualified to treat those animals
			} catch (Exception e) {
				System.err.println("Zookeeper can't treat those animals");
			}
		}
	}
	
	/*
	 * This method moves food from the Zoo Foodstore to the Enclosure Foodstore
	 */
	
	public void moveFood(){
		int movedItems = 0;
		while(movedItems < 20) {
			Set<String> set = zoofoodstore.getFoodStore().keySet();
			for(String element : set){
				if(zoofoodstore.getFoodStore().get(element) != 0) {
					enclosure.getEnclosureFoodStore().addFood(element, 1);
					zoofoodstore.takeFood(element);
					movedItems++;
					System.out.println(zoofoodstore.getFoodStore().get(element) + " " + enclosure.getEnclosureFoodStore().getFoodStore().get(element));
				}
			}
		}
	}
	
	/*
	 * Has the aMonthPasses method where the Zookeeper can moveFood,
	 * remove waste from the Enclosure and give treat to the animals 
	 */
	
	public void aMonthPasses(){
		moveFood();
		treat();
		enclosure.removeWaste(waste);
		System.out.println();
		System.out.println("Waste has been removed");
		System.out.println(enclosure.getWasteSize());
	}
}
