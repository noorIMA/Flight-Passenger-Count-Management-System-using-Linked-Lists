package application;

public class NodeF {

	public Flights flight;
	public NodeF next;
	
	
	public NodeF(Flights flight) {
		this(flight,null);
	}
	
	public NodeF(Flights flight, NodeF next) {
		this.flight = flight;
		this.next = next;
	}
	
	

	

}


