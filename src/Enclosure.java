import java.util.ArrayList;
import java.util.*;

/*
 * Enclosure class contains a foodstore and an ArrayList of animals
 * and specific methods
 */

public class Enclosure {
	private int waste;
	
	Foodstore foodstore = new Foodstore();
	//Creates an ArrayList of animals
	ArrayList<Animal> animals = new ArrayList<Animal>();
	
	/*
	 * Method which adds animals to the ArrayList
	 * If the size of the ArrayList goes over 20
	 * it throws an Exception which tells us that there is
	 * not enough space in the Enclosure
	 */
	public void addAnimal(Animal animal) throws Exception {
		if(size() == 20) {
			throw new Exception("Not enough space");
		} else {
			animals.add(animal);
		}
	}
	
	public void removeAnimal(Animal animal){
		animals.remove(animal);
	}
	/*
	 * Method which removes waste by an int value
	 */
	public void removeWaste(int waste){
		this.waste = this.waste - waste;
		if(this.waste < 0 ) {
			this.waste = 0;	
		}
	}
	/*
	 * Method which adds waste by an int value
	 */
	public void addWaste(int waste){
		this.waste = this.waste + waste;
	}
	
	public int getWasteSize(){
		return waste;
	}
	
	public Foodstore getEnclosureFoodStore(){
		return foodstore;
	}
	
	public int size(){
		return animals.size();
	}
	/*
	 * aMonthPasses method which calls the aMonthPasses method on
	 * all the animals from the ArrayList
	 */
	public void aMonthPasses() {
		for(Animal animal : animals){
			animal.aMonthPasses();
		}
	}
	
	public ArrayList<Animal> GetAnimalList(){
		return this.animals;
	}
	


}
