/*
 *  Bear is a sublcass of Animal.
 *  It has a constructor which takes the parameters from the
 *  Animal superclass.
 *  It implements the aMonthPasses method which decreases its health
 *  and makes it eat. It also has a treat method which is called by the Zookeepers
 */

public class Bear extends Animal {
		
	public Bear(int age, char gender, int health){
		super(age, gender, health, 18, new String[]{"fish","steak"});
		setTreatName("hug");
	}
	
	public void aMonthPasses(){
		increaseAge(1);
		decreaseHealth();
		eat();
	}

	public void treat(){
		System.out.println("Bear has been hugged ");
		increaseHealth(3);
	}
}
