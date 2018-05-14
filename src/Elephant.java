/*
 *  Elephant is a sublcass of Animal.
 *  It has a constructor which takes the parameters from the
 *  Animal superclass.
 *  It implements the aMonthPasses method which decreases its health
 *  and makes it eat. It also has a treat method which is called by the Zookeepers
 */

public class Elephant extends Animal{
	
	public Elephant(int age, char gender, int health){
		super(age, gender, health, 36, new String[]{"hay", "fruit"});
		setTreatName("bath");
	}
	
	public void aMonthPasses(){
		increaseAge(1);
		decreaseHealth();
		eat();
	}
	
	public void treat(){
		System.out.println("Elephant has been bath");
		increaseHealth(5);
	}
}
