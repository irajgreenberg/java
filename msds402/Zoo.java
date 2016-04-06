abstract class Mammal {
	
}

abstract class Insect {
	
}

interface Motile {
	float getDistTraveled();
}

interface Flyable extends Motile {
	void fly();
}

interface Morphable {

}

class Bat extends Mammal implements Flyable, Morphable {
	public void fly(){
		System.out.println("The Bat is creaping!");
	}

	public float getDistTraveled() {
		return 1.0f;
	}
}

class Dragonfly extends Insect implements Flyable {
	public void fly(){
		System.out.println("The Dragonfly is soaring!");
	}

	public float getDistTraveled() {
		return 1.0f;
	}
}

public class Zoo {

	Flyable[] critters;
	
	public Zoo(){
		System.out.println("in Zoo cstr");
	}

	public Zoo(Flyable[] critters){
		for(Flyable f: critters){
			f.fly();
		}
	}

	public static void main(String[] args) {
		
		Flyable f1 = new Bat();
		Flyable f2 = new Dragonfly();
		Flyable[] critters = {f1, f2};
		new Zoo(critters);
	}
}