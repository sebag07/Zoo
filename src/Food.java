/*
 * Food is a class which models the Food object that are present
 * in the foodstore Hashtable. It has a construct and several getters
 */
public class Food {
	
	String name;
	int health;
	int waste;
	
	public Food(String name, int health, int waste){
		this.name = name;
		this.health = health;
		this.waste = waste;
	}
	
	public String getName(){
		return name;
	}
	
	public int getHealth(){
		return health;
	}
	
	public int getWaste(){
		return waste;
	}
}
