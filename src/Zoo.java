import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Zoo {
	
	BufferedReader reader;
	//Creates a new foodstore
	Foodstore zoofoodstore = new Foodstore();
	//Creates an ArrayList of enclosures
	ArrayList<Enclosure> zooenclosures = new ArrayList<Enclosure>();
	//Creats an ArrayList of zookeepers
	ArrayList<Zookeeper> zookeeperArray = new ArrayList<Zookeeper>();
	//
	private int months = 0;
	
	public void aMonthPasses() {
		zoofoodstore.reStock();
		//Removes any dead Animal if there is one
		for(Enclosure enclosures : zooenclosures) {
			for(int i = 0; i < enclosures.GetAnimalList().size(); i++){
				if(enclosures.GetAnimalList().get(i).getHealth() == 0) {
					enclosures.removeAnimal(enclosures.GetAnimalList().get(i));
					System.out.println("The dead Animal has been removed");
				}
			}
		}
		//Calls the aMonthPasses method on all the enclosures from the zoo
		for(Enclosure enclosures : zooenclosures) {
			enclosures.aMonthPasses();
		}
		//Calls the aMonthPasses method on all the zookeepers from the zoo
		for(Zookeeper zookeepers : zookeeperArray) {
			zookeepers.aMonthPasses();
		}
	}
	/*
	 * The go method loops round the simulation by calling
	 * aMonthPasses. I paused for half a second between months
	 * to slow things down.
	 */
	
	public void go() {
		while(true) {
			try {
				aMonthPasses();
				System.out.println("A month has passed");
				Thread.sleep(500);
				months++;
				if(months > 12) {
					break;
				}
			} catch (InterruptedException e){
			System.out.println(e);
			}
		}
	}
	/**
	 * This is a constructor which creates a new BufferedReader
	 * which reads from a new File called myZoo.txt
	 * It prints out the Exception if the reader can't read
	 * from the file
	 */
	public Zoo(String myZoo) {
		try {
			reader = new BufferedReader(new FileReader(myZoo));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method reads a line from the file
	 */
	public String getLine() {
		try{
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	*This method checks if the file is ready to be read.
	*If yes, it returns true, else it returns false
	*/
	public boolean checkFile() throws IOException {
		try {
			if(reader.ready()){
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * This method reads from a File
	 * 
	 */
	public void readFromFile() throws Exception {
		// It reads the first line of the file
		String fileLine = getLine();
		// Set enclosure to null
		Enclosure enclosure = null;
		// While there is at least one line left in the file
		while (fileLine != null) {
			System.out.println(fileLine);
			String[] stringSplit1 = fileLine.split(":");
			// If the read line corresponds to a Zoo, we create the zoo
			if(stringSplit1[0].equalsIgnoreCase("Zoo")){
				// If the read line corresponds to an enclosure, we create the enclosure
				// and add it to the zooenclosures
			} else if(stringSplit1[0].equalsIgnoreCase("enclosure")){
				enclosure = new Enclosure();
				zooenclosures.add(enclosure);
				// If the read line corresponds to a Zookeeper, we create the Zookeeper
				// and add him to the zookeeperArray from the zoo
			} else if(stringSplit1[0].equalsIgnoreCase("Zookeeper")){
				Zookeeper keeper = new Zookeeper(enclosure, this);
				keeper.enclosure = enclosure;
				zookeeperArray.add(keeper);
				// If the read line corresponds to a PlayZookeeper, we create the Playzookeeper
				// and add him to the zookeeperArray from the zoo
			} else if(stringSplit1[0].equalsIgnoreCase("PlayZookeeper")){
				PlayZookeeper playkeeper = new PlayZookeeper(enclosure, this);
				playkeeper.enclosure = enclosure;
				zookeeperArray.add(playkeeper);
				// If the read line corresponds to a PhysioZookeeper, we create the Physiozookeeper
				// and add him to the zookeeperArray from the zoo
			}  else if(stringSplit1[0].equalsIgnoreCase("PhysioZookeeper")){
				PhysioZookeeper physiokeeper = new PhysioZookeeper(enclosure, this);
				physiokeeper.enclosure = enclosure;
				zookeeperArray.add(physiokeeper);
				// If the read line corresponds to a Bear, we create the Bear
				// and put it in the enclosure
			} else if(stringSplit1[0].equalsIgnoreCase("Bear")) {
				String[] stringSplit2 = stringSplit1[1].split(",");
				Bear bear = new Bear(new Integer(stringSplit2[1]), stringSplit2[0].charAt(0), new Integer(stringSplit2[2]));
				enclosure.addAnimal(bear);
				bear.setEnclosure(enclosure);
				// If the read line corresponds to a Chimpanzee, we create the Chimpanzee
				// and put it in the enclosure
			} else if(stringSplit1[0].equalsIgnoreCase("Chimpanzee")){
				String[] stringSplit2 = stringSplit1[1].split(",");
				Chimpanzee chimpanzee = new Chimpanzee(new Integer(stringSplit2[1]), stringSplit2[0].charAt(0), new Integer(stringSplit2[2]));
				enclosure.addAnimal(chimpanzee);
				chimpanzee.setEnclosure(enclosure);
				// If the read line corresponds to an Elephant, we create the Elephant
				// and put it in the enclosure
			} else if(stringSplit1[0].equalsIgnoreCase("Elephant")){
				String[] stringSplit2 = stringSplit1[1].split(",");
				Elephant elephant = new Elephant(new Integer(stringSplit2[1]), stringSplit2[0].charAt(0), new Integer(stringSplit2[2]));
				enclosure.addAnimal(elephant);
				elephant.setEnclosure(enclosure);
				// If the read line corresponds to a Giraffe, we create the Giraffe
				// and put it in the enclosure
			} else if(stringSplit1[0].equalsIgnoreCase("Giraffe")){
				String[] stringSplit2 = stringSplit1[1].split(",");
				Giraffe giraffe = new Giraffe(new Integer(stringSplit2[1]), stringSplit2[0].charAt(0), new Integer(stringSplit2[2]));
				enclosure.addAnimal(giraffe);
				giraffe.setEnclosure(enclosure);
				// If the read line corresponds to a Gorilla, we create the Gorilla
				// and put it in the enclosure
			} else if(stringSplit1[0].equalsIgnoreCase("Gorilla")){
				String[] stringSplit2 = stringSplit1[1].split(",");
				Gorilla gorilla = new Gorilla(new Integer(stringSplit2[1]), stringSplit2[0].charAt(0), new Integer(stringSplit2[2]));
				enclosure.addAnimal(gorilla);
				gorilla.setEnclosure(enclosure);
				// If the read line corresponds to a Lion, we create the Lion
				// and put it in the enclosure
			} else if(stringSplit1[0].equalsIgnoreCase("Lion")) {
				String[] stringSplit2 = stringSplit1[1].split(",");
				Lion lion = new Lion(new Integer(stringSplit2[1]), stringSplit2[0].charAt(0), new Integer(stringSplit2[2]));
				enclosure.addAnimal(lion);
				lion.setEnclosure(enclosure);
				// If the read line corresponds to a Penguin, we create the Penguin
				// and put it in the enclosure
			} else if(stringSplit1[0].equalsIgnoreCase("Penguin")){
				String[] stringSplit2 = stringSplit1[1].split(",");
				Penguin penguin = new Penguin(new Integer(stringSplit2[1]), stringSplit2[0].charAt(0), new Integer(stringSplit2[2]));
				enclosure.addAnimal(penguin);
				penguin.setEnclosure(enclosure);
				// If the read line corresponds to a Tiger, we create the Tiger
				// and put it in the enclosure
			} else if(stringSplit1[0].equalsIgnoreCase("Tiger")){
				String[] stringSplit2 = stringSplit1[1].split(",");
				Tiger tiger = new Tiger(new Integer(stringSplit2[1]), stringSplit2[0].charAt(0), new Integer(stringSplit2[2]));
				enclosure.addAnimal(tiger);
				tiger.setEnclosure(enclosure);
				// The next line it reads doesn't correspond to any of the above, which means
				// that the next lines correspond to the Food and it adds food to the zoofoodstore
				// and to the enclosure foodstore
			} else {
//				String[] stringSplit2 = stringSplit1[0].split(":");
				if(enclosure == null) {
					zoofoodstore.addFood(stringSplit1[0], new Integer(stringSplit1[1]));
				} else {
					enclosure.foodstore.addFood(stringSplit1[0], new Integer(stringSplit1[1]));
				}
			}
			// It moves to the next Line
			fileLine = getLine();
			}
		}
	/*
	 * Public static void main method which creates a zoo and calls
	 *  the readFromFile method and the go method
	 */
	public static void main(String[] args) throws Exception {
		String myZoo = args[0];
		Zoo zoo = new Zoo(myZoo);	
		zoo.readFromFile();
		zoo.go();
	}
}
