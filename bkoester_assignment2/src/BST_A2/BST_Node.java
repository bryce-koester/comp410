package BST_A2;

public class BST_Node {
	  String data;
	  BST_Node left;
	  BST_Node right;
	  int height = 0;
	  
	  BST_Node(String data){ this.data=data; }

	  // --- used for testing  ----------------------------------------------
	  //
	  // leave these 3 methods in, as is

	  public String getData(){ return data; }
	  public BST_Node getLeft(){ return left; }
	  public BST_Node getRight(){ return right; }

	  // --- end used for testing -------------------------------------------

	  
	  // --- fill in these methods ------------------------------------------
	  //
	  // at the moment, they are stubs returning false 
	  // or some appropriate "fake" value
	  //
	  // you make them work properly
	  // add the meat of correct implementation logic to them

	  // you MAY change the signatures if you wish...
	  // make the take more or different parameters
	  // have them return different types
	  //
	  // you may use recursive or iterative implementations

	
	  public boolean containsNode(String s){ 
		  int x = s.compareTo(this.data);
		  if (x == 0) {
			  return true;
		  }
		  if (this.left == null && this.right == null) {
			  return false;
		  }
		  if (x < 0)  {
			 if (this.left == null) {
				 return false;
			 }
			  return this.left.containsNode(s);
		  }
		  if (x > 0) {
			  if (this.right == null) {
				  return false;
			  }
			  return this.right.containsNode(s);
		  }
			  
		  return false; 
		  }
	  public boolean insertNode(String s){ 
		 
		  int x = s.compareTo(this.data);
		  if (x == 0) {
			  return false;
		  }
		  if (x < 0)  {
			  if (this.left == null) {
				  this.left = new BST_Node(s);
				  return true;
			  } else {
				  return this.left.insertNode(s);
			  }
		  }
		  if (x > 0) {
			  if (right == null) {
				  right = new BST_Node(s);
				  return true;
			  } else {
				  return this.right.insertNode(s);
			  }
		  }
		  return false; 
		  }
	  public boolean removeNode(BST_Node prev, String s){ 
		  
		  int x = s.compareTo(this.data);
		  if (x == 0) {
			  if (right == null && left == null) {
				 int y = data.compareTo(prev.data);
				 if (y < 0) {
					 prev.left = null;
					 return true;
				 }
				 if (y > 0) {
					 prev.right = null;
					 return true;
				 }
			  }
			  if (right == null && left != null) {
				  String newData = left.findMax().data;
				  left.removeNode(this, newData);
				  this.data = newData;
				  return true;
			  }
			  if (left == null && right != null) {
				  String newData = right.findMin().data;
				  right.removeNode(this, newData);
				  this.data = newData;
				  return true;
			  }
			  if (left != null && right != null) {
			  String newData = right.findMin().data;
			  right.removeNode(this, newData);
			  this.data = newData;
			  return true;
			  }
		  }
		  if (x > 0) {
			  return this.right.removeNode(this, s);
		  }
		  if (x < 0) {
			  return this.left.removeNode(this, s);
		  }
		  return false;
		 }
			
	  public BST_Node findMin() { 	  		 
		  if (left != null) {
			 return left.findMin();
		 	} else {
		 return this;
		 	}
		  }
	  public BST_Node findMax(){ 
		  if (right != null) {
			    return right.findMax();
			 	} else {
			 return this;
			 	}
		  }
	  public int getHeight(){ 
		 height = heightCalc(this);
		  return height; 
		  }
	  public int heightCalc(BST_Node b) {
		  if (b == null) {
			  return -1;
		  }
		  int leftHeight = heightCalc(b.left);
		  int rightHeight = heightCalc(b.right);
		  
		  if (leftHeight > rightHeight) {
			  return leftHeight + 1;
		  } else return rightHeight + 1;
			    
	  }

	  // --- end fill in these methods --------------------------------------


	  // --------------------------------------------------------------------
	  // you may add any other methods you want to get the job done
	  // --------------------------------------------------------------------
	  
	  public String toString(){
	    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
	            +",Right: "+((this.right!=null)?right.data:"null");
	  }
	}
