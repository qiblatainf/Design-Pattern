package DecoratorPattern;

interface Beverages {
	String getDescription();
	double getCost();
}

//Wrapper Class
class Espresso implements Beverages {

	@Override
	public String getDescription() {
		return "Espresso";
	}

	@Override
	public double getCost() {
		return 150;
	}
	
}

//you can add more beverages here

abstract class CondimentDecorator implements Beverages {
	protected Beverages beverage;
	
	public CondimentDecorator(Beverages beverage) {
		this.beverage = beverage;
	}
	
	public String getDescription() {
		return beverage.getDescription();
	}

	public double getCost() {
		return beverage.getCost();
	}
}

class Milk extends CondimentDecorator {
	//calling the values of the beverage
	public Milk(Beverages beverage) {
		super(beverage);
	}
	
	public String getDescription() {
		return beverage.getDescription() + ", milk";
	}

	public double getCost() {
		return beverage.getCost() + 5;
	}
}

class Caramel extends CondimentDecorator {
	public Caramel(Beverages beverage) {
		super(beverage);
	}
	
	public String getDescription() {
		return beverage.getDescription() + ", caramel";
	}

	public double getCost() {
		return beverage.getCost() + 10;
	}
	
}

public class DecoratorPatternDemo {
	
	public static void main(String [] args) {
		Beverages espresso = new Espresso() ;
		System.out.println("Beverage: " + espresso.getDescription());
    System.out.println("Cost: $" + espresso.getCost());

    Beverages espressowmilk = new Milk(espresso);
    System.out.println("Beverage: " + espressowmilk.getDescription());
    System.out.println("Cost: $" + espressowmilk.getCost());

    Beverages espressoWithMilkAndCaramel = new Caramel(espressowmilk);
    System.out.println("Beverage: " + espressoWithMilkAndCaramel.getDescription());
    System.out.println("Cost: $" + espressoWithMilkAndCaramel.getCost());
		
	}
}
