package application;



public class Passenger implements Comparable<Passenger> {

	private String flightNumber;
	private String passportNumber;
	private String fullName;
	private String ticketNumber;
	private String nationality;
	private String birthdate;
	
	
	
	public Passenger() {
		super();
	}


	public Passenger(String flightNumber, String passportNumber, String fullName, String ticketNumber, String nationality,
			String birthdate) {
		super();
		this.flightNumber = flightNumber;
		this.passportNumber = passportNumber;
		this.fullName = fullName;
		this.ticketNumber = ticketNumber;
		this.nationality = nationality;
		this.birthdate = birthdate;
	}


	public String getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getTicketNumber() {
		return ticketNumber;
	}


	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}


	public String getPassportNumber() {
		return passportNumber;
	}


	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public String getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}


	@Override
	public int compareTo(Passenger o) {
		if (this.getFullName().equals(o.getFullName()))
			return 0;
		return -1;
	}

	@Override
	public String toString() {
		return "Passenger " + flightNumber + "," + passportNumber + ", "
	+ fullName + "," + ticketNumber + "," + nationality + ","
				+ birthdate ;
	}
}
