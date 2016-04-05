public abstract class Mammal {
	public String toString( ){
		return "Mammal type";
	}
	
}

public abstract class Insect {
	public String toString( ){
		return "Insect type";
	}
}

interface Motile {
	// float getDistTraveled();
	// void setSpeed();
	// void setOrigin(String origin);
	// void setDestination(String destination);
}

interface Flyable extends Motile {
	// void fly();
	// void land();
}

interface Predatory {
	// void Hunt();
	// void Attack();
}


public class Lemur extends Mammal implements Flyable {
	public String toString( ){
		return "Lemur type";
	}
}

public class Dragonfly extends Insect implements Flyable, Predatory{
	public String toString( ){
		return "Dragonfly type";
	}
}


public class Zoo {
 Flyable[] creatures;

 public Zoo() {
 	System.out.println("in Zoo default CSTR");
 }

 public Zoo(Flyable[] creatures){
 	this.creatures = creatures;
 }

 public static void main(String[] args){
 	new Zoo();
 }
	
}