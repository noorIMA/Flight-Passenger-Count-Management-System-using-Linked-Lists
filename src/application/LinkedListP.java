package application;

public class LinkedListP {
	


		private NodeP Front;
		private NodeP Back;
		private int size;
		
		public LinkedListP() {
			Front=Back=null;
			size=0;
		}
		
		public LinkedListP(NodeP front, NodeP back, int size) {
			
			Front = front;
			Back = back;
			this.size = size;
		}

		
		public NodeP getFront() {
			return Front;
		}

		public void setFront(NodeP front) {
			Front = front;
		}

		public NodeP getBack() {
			return Back;
		}

		public void setBack(NodeP back) {
			Back = back;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public void addFirst(Passenger element) {
			NodeP newNode=new NodeP(element);
			if(size==0)
				Front=Back=newNode;
			else {
				newNode.next=Front;
				Front=newNode;
			}
				size++;
		}
		
		public Object getFirst() {
			if(size==0)
				return null;
			else
				return Front.element;
		}
		
		public void addLast(Passenger element) {
			NodeP newNode=new NodeP (element);
			if(size==0)
				Front=Back=newNode;
			else {
				Back.next=newNode;
				Back=newNode;
			}
			size++;
		}
		
		public Object getLast() {
			if(size==0)
				return null;
			else
				return Back.element ;
		}
		
		public Object get(int index) {
			if(size==0)
				return null;
			else if(index==0)
				return getFirst();
			else if(index==size-1) 
				return getLast();
			else if(index >0 && index <size-1) {
				NodeP current =Front;
				for (int i = 0; i < index; i++) 
					current=current.next;
				return current.element;
				
			}
			else
				return null;
		}
		
		public void add(int index ,Passenger element) {
			if(index ==0)
				addFirst(element);
			else if(index>=size)
				addLast(element);
			else {
				NodeP newNode =new NodeP(element);
				NodeP current=Front;
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
				NodeP current=Front;
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
				NodeP current=Front;
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
		
		public void traverse(NodeP current) {
			if(current !=null) {
				System.out.println(current.element);
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
		
		public boolean search(NodeP temp, Passenger element)
	    {
			NodeP current = Front;    
	        while (current != null)
	        {
	            if (current.element == element)
	                return true;    
	            current = current.next;
	        }
	        return false;   
	    }

		@Override
		public String toString() {
			return  Front + "," + Back + "," + size ;
		}


	

}
