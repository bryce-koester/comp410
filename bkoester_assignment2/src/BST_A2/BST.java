package BST_A2;

public class BST implements BST_Interface {
	  public BST_Node root;
	  int size;
	  
	  public BST(){ size=0; root=null; }
	  
	  @Override
	  //used for testing, please leave as is
	  public BST_Node getRoot(){ return root; }
	  
	  public boolean insert(String s) {
		  if (root == null) {
			  root = new BST_Node(s);
			  size++;
			  return true;
		  }
		  if (root.insertNode(s) == true) {
			  size++;
			  return true;
		  }
		  return false;
	  }
	  public boolean remove(String s) {
		  if (root == null) {
			  return false;
		  } else if (size == 1 && root.data == s) {
			  root = null;
			  size = 0;
			  return true;
		  }
		  
		  if (root.removeNode(root, s) == true) {
			  size--;
			  return true;
		  }
		  return false;
	  }
	  public String findMin() {
		  return root.findMin().data;
	  }
	  public String findMax() {
		  return root.findMax().data;
	  }
	  public boolean empty() {
		  if (size == 0) {
			  return true;
		  }
		  return false;
	  }
	  public boolean contains(String s) {
		  return root.containsNode(s);
	  }
	  public int size() {
		  return size;
	  }
	  public int height() {
		  if (size == 0) {
			  return 0;
		  }
		  return root.getHeight();
	  }
	}
