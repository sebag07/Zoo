import java.util.*;
import java.util.Hashtable;

/*
 * This is the class that stores the Food in a Hashtable.
 * It puts food in the Hashtable, its key being the food name
 * and the value being the quantity.
 */

public class Foodstore {
	
	private int totalQuantity = 0;
	Hashtable<String, Integer> foodstore = new Hashtable<String, Integer>();
	
	public Foodstore(){
	
		foodstore.put("hay", 10);
		foodstore.put("steak", 10);
		foodstore.put("fruit", 10);
		foodstore.put("celery", 10);
		foodstore.put("fish", 10);
		foodstore.put("icecream", 10);
	}
	/*
	 * Method which adds food to the foodstore
	 */
	public void addFood(String food, int quantity){
		if(foodstore.containsKey(food))
			foodstore.put(food, foodstore.get(food) + quantity);
		else
				foodstore.put(food, quantity);
	}
	
	public void reStock(){
		System.out.println("Zoo restocked");
		for(String aliment : this.getFoodStore().keySet()){
			this.getFoodStore().put(aliment, 20);
		}
	}
	
	public int getTotalQuantity(){
		return this.totalQuantity;
	}
	
	public void setTotalQuantity(int quantity){
		this.totalQuantity = quantity;
	}
	
	/*
	 * Method which takes food from the foodstore
	 */
	public String takeFood(String food){
		int quantity = foodstore.get(food);
		foodstore.put(food, quantity - 1);
		return food;
	}
	
	public Hashtable<String, Integer> getFoodStore(){
		return foodstore;
	}
}
