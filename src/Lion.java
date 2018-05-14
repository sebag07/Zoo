/*
 *  Lion is a sublcass of Animal.
 *  It has a constructor which takes the parameters from the
 *  Animal superclass.
 *  It implements the aMonthPasses method which decreases its health
 *  and makes it eat. It also has a treat method which is called by the Zookeepers
 */

public class Lion extends BigCat{

	public Lion(int age, char gender, int health){
		super(age, gender, health, 24);
		setTreatName("stroked");
	}
	
	public void aMonthPasses(){
		increaseAge(1);
		decreaseHealth();
		eat();
	}
	
	public void treat(){
		System.out.println("Lion has been stroked");
		increaseHealth(2);
	}
}
