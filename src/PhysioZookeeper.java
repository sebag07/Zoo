/*
 * PhysioZookeeper is a subclass for the Zookeeper class.
 * It has a constructor which takes the variables from the Zookeeper
 * and has the treat method to carry his duties	
 */

public class PhysioZookeeper extends Zookeeper{
	
	public PhysioZookeeper(Enclosure enclosure, Zoo zoo){
		super(enclosure, zoo);
	}
	
	/*
	 * This method gives a treat to the animal.
	 */
	
	public void treat(){
		//Creates a variable which stores the treatedAnimals
		int treatedAnimals = 0;
		for(Animal animal : enclosure.GetAnimalList()){
			try{
				//The Physiozookeeper is allowed to neckMassage and bath animals
				if(animal.getTreatName().equals("neckMassage") || animal.getTreatName().equals("bath")){
					animal.treat();
					treatedAnimals++;
					//The Zookeeper is allowed to give treat to up to 2 animals.
					//It stops if treatedAnimals equals 2.
				} if(treatedAnimals == 2) {
					break;
				}
				//Prints out an Exception if the Zookeeper is not qualified to treat those animals
			} catch (Exception e) {
				System.err.println("Physiozookeper can't treat");
			}
		}
	}
}
