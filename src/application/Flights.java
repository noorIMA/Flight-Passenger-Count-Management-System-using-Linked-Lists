package application;

public class Flights implements Comparable<Flights>{

	private String flightNumber;
	private String airlineName;
	private String source;
	private String destination;
	private String capacity;
	private LinkedListP listP = new LinkedListP();
	
	
	public Flights() {
		super();
	}



	public Flights(String flightNumber, String airlineName, String source, String destination, String capacity) {
		super();
		this.flightNumber = flightNumber;
		this.airlineName = airlineName;
		this.source = source;
		this.destination = destination;
		this.capacity = capacity;
	}


	
	

	public LinkedListP getListP() {
		return listP;
	}



	public void setListP(LinkedListP listP) {
		this.listP = listP;
	}



	public String getFlightNumber() {
		return flightNumber;
	}



	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}



	public String getAirlineName() {
		return airlineName;
	}



	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}



	public String getSource() {
		return source;
	}



	public void setSource(String source) {
		this.source = source;
	}



	public String getDestination() {
		return destination;
	}



	public void setDestination(String destination) {
		this.destination = destination;
	}



	public String getCapacity() {
		return capacity;
	}



	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}



	@Override
	public int compareTo(Flights o) {
		if (this.getFlightNumber()==(o.getFlightNumber()))
			return 0;
		return -1;
		
	}



	@Override
	public String toString() {
		return "Flights :" + flightNumber + "," + airlineName +","+ source
				+ "," + destination + "," + capacity + ", " + listP ;
	}
	
	

	
}
