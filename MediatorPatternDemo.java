package MediatorPattern;
//Mediator is an interface containing all the methods 
interface IATCMediator
{

	public void registerRunway(Runway runway);

	public void registerFlight(Flight flight);

	public boolean isLandingOk();

	public void setLandingStatus(boolean status);
}

//Concrete mediator implements all the fuctions in the mediator interface
class ATCMediator implements IATCMediator
{
	//create objects of the colleagues
	private Flight flight;
	private Runway runway;
	public boolean land;

	public void registerRunway(Runway runway)
	{
		this.runway = runway;
	}

	public void registerFlight(Flight flight)
	{
		this.flight = flight;
	}

	public boolean isLandingOk()
	{
		return land;
	}

	@Override
	public void setLandingStatus(boolean status)
	{
		land = status;
	}
}

//Create an interface for the Colleagues
interface Command
{
	void land();
}


//Colleague number 1 implements the method of interface
class Flight implements Command
{
	//create an object of the mediator with whom the colleague can communicate with
	private IATCMediator atcMediator;

	//create a private constructor for the mediator
	public Flight(IATCMediator atcMediator)
	{
		this.atcMediator = atcMediator;
	}

	public void land()
	{
		if (atcMediator.isLandingOk())
		{
			System.out.println("Successfully Landed.");
			atcMediator.setLandingStatus(true);
		}
		else
			System.out.println("Waiting for landing.");
	}

	public void getReady()
	{
		System.out.println("Ready for landing.");
	}

}

class Runway implements Command
{
	private IATCMediator atcMediator;

	public Runway(IATCMediator atcMediator)
	{
		this.atcMediator = atcMediator;
		atcMediator.setLandingStatus(true);
	}

	@Override
	public void land()
	{
		System.out.println("Landing permission granted.");
		atcMediator.setLandingStatus(true);
	}

}

//Driver Class
class MediatorPatternDemo
{
	public static void main(String args[])
	{

		IATCMediator atcMediator = new ATCMediator(); //Mediator creating and instance of Concrete Mediator
		Flight sparrow101 = new Flight(atcMediator);
		Runway mainRunway = new Runway(atcMediator);
		atcMediator.registerFlight(sparrow101);
		atcMediator.registerRunway(mainRunway);
		sparrow101.getReady();
		mainRunway.land();
		sparrow101.land();
		
	}
}
