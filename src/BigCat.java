/*
 * BigCat is a subclass of Animal
 * It has a constructor which takes parameters from
 * it superclass Animal
 */

public abstract class BigCat extends Animal{
	
	public BigCat(int age, char gender,int health, int lifeExpectancy){
		super(age, gender, health, lifeExpectancy, new String[]{"steak", "celery"});
	}
	
}
