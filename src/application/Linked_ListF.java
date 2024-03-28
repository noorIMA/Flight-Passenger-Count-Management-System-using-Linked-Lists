package application;

public class Linked_ListF {


	private NodeF Front;
	private NodeF Back;
	private int size;
	
	public Linked_ListF() {
		Front=Back=null;
		size=0;
	}
	
	public Linked_ListF(NodeF front, NodeF back, int size) {
		
		Front = front;
		Back = back;
		this.size = size;
	}

	
	public NodeF getFront() {
		return Front;
	}

	public void setFront(NodeF front) {
		Front = front;
	}

	public NodeF getBack() {
		return Back;
	}

	public void setBack(NodeF back) {
		Back = back;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void addFirst(Flights element) {
		NodeF newNode=new NodeF(element);
		if(size==0)
			Front=Back=newNode;
		else {
			newNode.next=Front;
			Front=newNode;
		}
			size++;
	}
	
	public Flights getFirst() {
		if(size==0)
			return null;
		else
			return Front.flight;
	}
	
	public void addLast(Flights element) {
		NodeF newNode=new NodeF (element);
		if(size==0)
			Front=Back=newNode;
		else {
			Back.next=newNode;
			Back=newNode;
		}
		size++;
	}
	
	public Flights getLast() {
		if(size==0)
			return null;
		else
			return Back.flight ;
	}
	
	public Flights get(int index) {
		if(size==0)
			return null;
		else if(index==0)
			return getFirst();
		else if(index==size-1) 
			return getLast();
		else if(index >0 && index <size-1) {
			NodeF current =Front;
			for (int i = 0; i < index; i++) 
				current=current.next;
			return current.flight;
			
		}
		else
			return null;
	}
	
	public void add(int index ,Flights element) {
		if(index ==0)
			addFirst(element);
		else if(index>=size)
			addLast(element);
		else {
			NodeF newNode =new NodeF(element);
			NodeF current=Front;
			for (int i = 0; i < index-1; i++) {
				current=current.next;
			}
			newNode.next=current.next;
			current.next=newNode;
			size++;
		}
	}
	
	public boolean removeFirst() {
		if(size==0)
			return false;
		else if(size==1)
			Front=Back=null;
		else
			Front=Front.next;
		size--;
		return true;
	}
	
	public boolean removeLast() {
		if(size==0)
			return false;
		else if(size==1)
			Front=Back=null;
		else {
			NodeF current=Front;
			for (int i = 0; i <size-2; i++) {
				current=current.next;
			}
			current.next=null;
			Back=current;
		}
		size--;
		return true;
	}
	
	public boolean remove(int index) {
		if(size==0)
			return false;
		else if(index==0)
			return removeFirst();
		else if(index==size-1)
			return removeLast();
		else if(index > 0 && index<size-1) {
			NodeF current=Front;
			for (int i = 0; i < index-1; i++) {
				current=current.next;
			}
			current.next=current.next.next;
			size--;
			return true;
		}
		else
			return false;
	}
	
	public void traverse(NodeF current) {
		if(current !=null) {
			System.out.println(current.flight);
			traverse(current.next);
		}
		
	} 
	
	

	//public Object search(Object element) {
	//	Node current=Front;
	//	while((current!=null)&&!(current.element.equals(element))) {
		//	current=current.next;
		//}
	//	return current.element;
	//}
	
	public LinkedListP search(String flightNumber)
    {
		NodeF current = Front;    
        while (current != null)
        {
            if (current.flight.getFlightNumber().equals(flightNumber))  {
            	
                return  current.flight.getListP();   
            }
            
            current = current.next;
        }
        return null;   
    }

	@Override
	public String toString() {
		return  Front + "," + Back;
	}

	

}
