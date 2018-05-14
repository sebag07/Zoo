/*
 *  Giraffe is a sublcass of Animal.
 *  It has a constructor which takes the parameters from the
 *  Animal superclass.
 *  It implements the aMonthPasses method which decreases its health
 *  and makes it eat. It also has a treat method which is called by the Zookeepers
 */

public class Giraffe extends Animal{
	
	public Giraffe(int age, char gender, int health){
		super(age, gender, health, 28, new String[] {"hay", "fruit"});
		setTreatName("neckMassage");
	}
	
	public void aMonthPasses(){
		increaseAge(1);
		decreaseHealth();
		eat();
	}
	
	public void treat(){
		System.out.println("Giraffe's neck has been massaged");
		increaseHealth(4);
	}
}
