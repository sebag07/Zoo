I have done all of the parts of this coursework, except for the extensions.This coursework has to construct a simple simulation of a zoo. I have created the following classes:
1.Animal
2.Enclosure
3.Food
4.Foodstore
5.Zoo
6.Zookeeper
7.PhysioZookeeper
8.PlayZookeeper
9.Ape
10.BigCat
11.Bear
12.Chimpanzee
13.Elephant
14.Giraffe
15.Gorilla
16.Lion
17.Penguin
18.Tiger

In order to run the code, you have to type java Zoo myZoo.txt in the command line.

1.I’ve created an Animal class which defines an animal who has:
- a gender
- an age
- health
- lifeExpectancy
It has several getters and setters for things like gender, age, health etc.
It also has the methods aMonthPasses and treat which will be implemented in its subclasses.

2.Enclosure is the class which holds the Animals.
It has an ArrayList of animals and a foodstore.
It has methods like:
	*add an animal
	*removing an animal
	*getters and setters
	*aMonthPasses which is called on all the animals

3.I’ve created the Food class to describe the food which is in the foodstore.
It has a constructor and getters for each of its variable.

4.Foodstore is the class which stores the Food in a Hashtable.
It has a takeFood and an addFood method.

5.Zoo is the class which contains the simulation of the zoo.
The simulation is being read from a simple configuration file.
When the class receives the configuration, it reads the file a line at a time.
It has the aMonthPasses method and the void go which starts the zoo.

6.Zookeeper is the class that takes care of the animals.
It has a moveFood and treat method, as well as aMonthPasses method.
The general Zookeeper can only hug and stroke animals.

7.PhysioZookeeper is a sub class of the Zookeeper class.
It provides the treat method for the animals: neckMassage and bath.

8.PlayZookeeper is a sub class of the Zookeeper class.
It provides the treat method for the animals: watchAFilm, playChase, painting.

9.Ape is a superclass for Gorilla and Chimpanzee.

10.BigCat is a superclass for Lion and Tiger.

11.All the animals have a constructor, as well as the aMonthPasses method and the treat method called on them.