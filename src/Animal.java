import java.util.ArrayList;
/*
 * Abstract class Animal is the superclass of the Ape, BigCat and other animal classes.
 * It provides code for:
 * 1. age, gender, health, lifeExpectancy, String[] eats, treat for animals
 * 2. different getters and setters
 * 3. has 2 abstract methods aMonthPasses and treat which are being implemented
 * differently in its subclasses and other classes based on what happens in a month 
 * and what kind of treat they need to receive. 
 */

public abstract class Animal {
	private int age;
	private char gender;
	int health;
	private int lifeExpectancy;
	String treat;
	String[] eats;
	Enclosure enclosure;
	
	//Creates an ArrayList of food which stores the Food objects
	ArrayList<Food> foodArray = new ArrayList<Food>();
	Food hay = new Food("hay", 1, 4);
	Food steak = new Food("steak", 3, 4);
	Food fruit = new Food("fruit", 2, 3);
	Food celery = new Food("celery", 0, 1);
	Food fish = new Food("fish", 3, 2);
	Food icecream = new Food("ice cream", 1, 3);
	
	/*
	 * The constructor sets the age, gender, health, lifeExpectancy and a string of eats which
	 */
	public Animal(int age, char gender, int health, int lifeExpectancy, String[] eats) {
		this.age = age;
		this.gender = gender;
		this.health = health;
		this.lifeExpectancy = lifeExpectancy;
		this.eats = eats;
		foodArray.add(hay);
		foodArray.add(steak);
		foodArray.add(fruit);
		foodArray.add(celery);
		foodArray.add(fish);
		foodArray.add(icecream);
	}
	
	public int getAge(){
		return age;
	}
	
	public char getGender(){
		return gender;
	}
	
	public int getLifeExpectancy(){
		return lifeExpectancy;
	}
	
	public int getHealth(){
		return health;
	}
	
	public void setHealth(int health){
		// 10 is the maximum health an animal can have,
		// if health goes over 10, then health gets a value of 10.
		if(health > 10){
			this.health = 10;
		} 
		// 0 is the minimum health an animal can have,
		//if health goes under 0, then health gets a value of 0
		else if(health < 0) {
			this.health = 0;
		}
		else
			this.health = health;
	}
	
	public void setTreatName(String treatName){
		this.treat = treatName;
	}
	
	public String getTreatName(){
		return this.treat;
	}
	/*
	 * Method which checks if the animal can eat the given food
	 * It returns true if it can, or false if it can't
	 */
	public boolean canEat(String food){
		for (String eatableFood : eats){
			if(food.equals(eatableFood)){
				return true;
			}
		} return false;
	}
	/*
	 * Method which is called on aMonthPasses on each Animal
	 * If the animal can eat the food, it will increase its health
	 * and produces waste
	 */
	public void eat() {
		for(String food : enclosure.getEnclosureFoodStore().getFoodStore().keySet()){
			if(canEat(food)){
				for(Food item : foodArray){
					if(item.getName().equals(food)){
						 increaseHealth(item.getHealth());
						 enclosure.addWaste(item.getWaste());
						 for(Animal animal : enclosure.animals){
							 System.out.println(animal.getClass().getName() + " " + animal.getAge() + " " + animal.getGender() + " " + animal.getHealth() + " has eaten");
						 }
					}break;
				}
			}
		}
	}
	/*
	 * Method which decreases health by 2 and is called in the
	 * aMonthPasses method from each Animal
	 */
	public void decreaseHealth(){
		this.health = this.health - 2;
		if(health <= 0){
			health = 0;
		}
		System.out.println(getHealth());
	}
	/*
	 * Method which increases health by an int value
	 */
	public void increaseHealth(int health){
		this.health = this.health + health;
		if(this.health >= 10){
			this.health = 10;
		}
	}
	
	public void increaseAge(int age){
		this.age = this.age + age;
	}
	
	public void setEnclosure(Enclosure enclosure){
		this.enclosure = enclosure;
	}
	
	public abstract void aMonthPasses();
	
	public abstract void treat();

}
