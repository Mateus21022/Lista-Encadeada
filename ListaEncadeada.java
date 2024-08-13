package listaencadeada;

public class ListaEncadeada {
    private ListNode head;
    private ListNode tail;
    private ListNode previous;
    private int size;
    
    private class ListNode{
    	private Object element;
    	private ListNode Next;
    	private ListNode (Object e, ListNode n) {
    		element = e;
    		Next = n;
    	}
    }
    
    public ListaEncadeada(){
        size = 0;
        head = tail = previous = null;
    }
    
    public int size() {
    	return size;
    }
    
    public boolean isEmpty() {
    	return (head==null);
    }
    
    public boolean Add (Object elem) {
    	ListNode newElement = new ListNode(elem,null);
    	if (head == null) {
    		head = newElement;
    	}else {
    		tail.Next = newElement;
    		tail = newElement;
    		size++;
    		return true;
    	}
    	return false;
    }
    
    
    public void clear () {
    	head = tail = null;
    	size = 0;
    }
    
    
    public void print() {
    	if (size == 0) {
    		System.out.println ("<---Lista Vazia--->");
    	}else {
    		System.out.println ("<---Início--->");
    		ListNode itr = head;
    		while (itr!=null) {
    			System.out.println (itr.element);
    			itr = itr.Next;
    		}
    	      System.out.println ("<---Fim--->");
    	}
    }
    
   public Object get (int index) {
	   if (index<0 || index>size -1 ) {
		   throw new IndexOutOfBoundsException ("Index = "+index+"e Size = "+size);
	   }else {
		   if (index==0) {
			   /*return head.element;
			   findprevious(index);
			   return previous.Next.element;*/
		   }
	   }
	return index;
   }
    

	private void findprevious(int index) {
	 ListNode itr = head;
	 previous = null;
	 for (int i = 0; i<size;i++) {
		 if (i==index) {
			 previous = itr;
			 itr = itr.Next;
			 return;
		 }
		 return;
	 
	 }
	
}

	public void add(Object elem, int index) {
	     if (index<0||index>size) {
	    	 throw new IndexOutOfBoundsException ("Index="+index+"e Size="+size);
	     }else {
	    	 if (index==0) {
	    		 if(head==null) {
	    			 ListNode newElement = new ListNode (elem,null);
	    			  head=tail=newElement;
	    		 }else {
	    			 ListNode newElement = new ListNode (elem,head);
	    			 head = newElement; 
	    		 }
	     }else {
	    	 findprevious(index);
	    	 ListNode newElement = new ListNode(elem,previous.Next);
	    	 previous.Next = newElement;
	    	 if(newElement.Next==null) {
	    		 tail = newElement;
	    	 }
	     }
	     size++;
	}

  }
	
	public Object remove (int index) {
		Object toBeDeleted;
		if (index<0||index>size) {
			throw new IndexOutOfBoundsException ("Index="+index+"e Size = "+size);
	}else {
		if (index==0) {
			toBeDeleted = head.element;
			 if (head == tail ){
				 head = tail = null;
			 }else {
				 head = head.Next;
			 }
		}else {
			findprevious(index);
			toBeDeleted=previous.Next.element;
			 if (previous.Next==tail) {
				 tail = previous;
				  previous.Next = previous.Next.Next;
			 }
			 size --;
		}
		return toBeDeleted;
	}
 }
	
	public boolean remove (Object elem) {
		int index = indexOf(elem);
		 if (index<0) return false;
		 remove (index);
		 return true;
	}

	private int indexOf(Object elem) {
		ListNode itr = head;
		previous = null;
		for (int i =0;i<size;i++) {
			if (itr.element.equals(elem)) {
				return i;
			}else {
				previous = itr;
				itr = itr.Next;
		     }
		  }
		previous = null;
		return -1;
	}
}
 
