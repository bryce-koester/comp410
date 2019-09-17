package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
	  private EntryPair[] array; //load this array
	  private int size = 0;
	  private int nextEmpty = 1;
	  private static final int arraySize = 10000; //Everything in the array will initially 
	                                              //be null. This is ok! Just build out 
	                                              //from array[1]

	  public MinBinHeap() {
	    this.array = new EntryPair[arraySize];
	    array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
	                                             //of child/parent computations...
	                                             //the book/animation page both do this.
	  }
	    
	  //Please do not remove or modify this method! Used to test your entire Heap.
	  @Override
	  public EntryPair[] getHeap() { 
	    return this.array;
	  }
	  public void insert(EntryPair entry) {
		  if (nextEmpty == 1) {
			  array[1] = entry;
			  nextEmpty = 2;
			  size = 1;
			  return;
		  } else
		  array[nextEmpty] = entry;
		  bubbleUp(entry, nextEmpty);
		  nextEmpty++;
		  size = nextEmpty - 1;
		  return;
	  }
	  public void delMin() {
		  array[1] = array[nextEmpty - 1];
		  array[nextEmpty - 1] = null;
		  bubbleDown(1);
		  nextEmpty--;
		  size--;
		  return;
	  }
	  public EntryPair getMin() {
		  return array[1];
	  }
	  public int size() {
		  return size;
	  }
	  public void build(EntryPair [] entries) { 
		  for (int i = 0; i<entries.length; i++) {
			  array[i+1] = entries[i];
		  }
		  size = entries.length;
	      nextEmpty = entries.length + 1;
		  int current = (int) (Math.floor((nextEmpty - 1) / 2));
		  while (current != 0) {
			  bubbleDown(current);
			  current--;
		  }
		  size = entries.length;
		  return;
	  }
	  public void bubbleDown(int current) {
		  if (current*2 > size ) {
			  return;
		  }
		  if ((current*2 + 1) > size) {
			  if (array[current*2] != null) {
				  if (array[current].priority > array[current*2].priority) {
					  EntryPair temp  = array[current];
					  array[current] = array[current*2];
					  array[current*2] = temp;
					  return;
				  }
			  }
		  }
		  EntryPair leftChild = array[current * 2];
		  EntryPair rightChild = array[current * 2 + 1];
		  if (leftChild == null && rightChild == null) {
			  return;
		  }
		  if (leftChild!= null && rightChild == null) {
			  if (array[current].priority > leftChild.priority) {
				  array[current * 2] = array[current];
				  array[current] = leftChild;
				  return;
			  } else {
				  return;
			  }
		  }

		  if (array[current].priority < leftChild.priority && array[current].priority < rightChild.priority) {
			  return;
		  } 
		  int diff = leftChild.priority - rightChild.priority;
		  if (diff < 0) {
			  if (leftChild.priority < array[current].priority) {
				  array[current * 2] = array[current];
				  array[current] = leftChild;
				  bubbleDown(current * 2);
			  }
		  }
		  if (diff > 0) {
			  if (rightChild.priority < array[current].priority) {
				  array[current * 2 + 1] = array[current];
				  array[current] = rightChild;
				  bubbleDown(current * 2 + 1);
			  }
		  }
	  }
	  public void bubbleUp(EntryPair entry, int current) {
		  int parent = (int) (Math.floor(current / 2));
		  if (parent == 0) {
			  return;
		  }
		  if (entry.priority > array[parent].priority) {
			  return;
		  }
		  if (entry.priority < array[parent].priority) {
			  EntryPair temp = entry;
			  array[current] = array[parent];
			  array[parent] = temp;
		      bubbleUp(entry, parent);
		  }
	  }
	}
