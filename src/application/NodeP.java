package application;

public class NodeP {
	

		public Passenger element;
		public NodeP next;
		
		public NodeP(Passenger element) {
			this(element,null);
		}
		
		public NodeP(Passenger element, NodeP next) {
			this.element = element;
			this.next = next;
		}
		
	


}
