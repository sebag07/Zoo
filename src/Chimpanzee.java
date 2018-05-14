/*
 *  Chimpanzee is a sublcass of Ape.
 *  It has a constructor which takes the parameters from the
 *  Ape superclass.
 *  It implements the aMonthPasses method which decreases its health
 *  and makes it eat. It also has a treat method which is called by the Zookeepers
 */

public class Chimpanzee extends Ape {
	
	public Chimpanzee(int age, char gender, int health){
		super(age, gender, health, 24);
		setTreatName("playChase");
	}
	
	public void aMonthPasses(){
		increaseAge(1);
		decreaseHealth();
		eat();
	}
	
	public void treat(){
		System.out.println("Chimpanzee has played Chase");
		increaseHealth(4);
	}
}
