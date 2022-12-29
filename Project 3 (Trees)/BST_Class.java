public class BST_Class {
    //node class that defines BST node
    // BST root node 
    Node root;

    // Constructor for BST =>initial empty tree
    BST_Class(){
        root = null;
    }
    /* a helper method for deleting a key
     *@param: root of type node and the key wanted to be deleted */
      protected Node delete(Node root, int key){
        //checks is there is a root
      if(root == null){
      return root;
      }
      //checks if the key if smaller than the root
      if(key < root.key){
        //use recursion to traverse down the tree
        root.left = delete(root.left, key);
      }
      //checks if the key is bigger than the root
      else if(key > root.key){
      //use recursion to traverse down the tree
        root.right = delete(root.right, key);
      } 
      else{
        //checks if there is left for the root
        if(root.left == null){
          return root.right;
     }
        //checks if there is right for the root        
       else if(root.right == null){
        return root.left;
      }      
      // rearranging the nodes to be inorder
      root.key = minValue(root.right);
      root.right = delete(root.right, root.key);
      }
      //returning the root
      return root;
}    
    //delete a node from BST
    void deleteKey(int key) {
      //calls the helper method above for deleting a key in the tree
     root = delete(root, key); 
    }
    
/*a method that returns the smallest element in BST*/
    int minValue(Node root){
      //checks if the left of the root is null
      // base case
      if(root.left == null){
      //returns the root if the condition is met
      return root.key;
      }
      //uses recursion to reaverse down the tree till 
      //the smallest value is found
      return minValue(root.left);
    }

    // insert a node in BST
    void insert(int key)  {
        root = insert_Recursive(root, key);
    }

    //recursive insert function
    Node insert_Recursive(Node root, int key) {
        //tree is empty
        if (root == null){
            root = new Node(key);
            return root;
        }
        //traverse the tree
        if (key < root.key)     //insert in the left subtree
            root.left = insert_Recursive(root.left, key);
        else if (key > root.key)    //insert in the right subtree
            root.right = insert_Recursive(root.right, key);
        // return pointer
        return root;
    }
/*A method that checks whether a given key exists in BST
 * @param: int key */
    boolean search(int key)  {
      //a variable for traverse the tree
      Node trav = root;
      //a while loop for iterating through the tree
      while(trav != null){     

      // checks if the key is less than the variable trav
        if(key < trav.key){
          //update the variable trav to be the left of the old variable trav
          trav = trav.left;
        }
      // checks if the key is less than the variable trav  
        else if(key > trav.key){
         //update the variable trav to be the right of the old variable trav   
          trav = trav.right;
        }
        else{
          // an exist condition for the while loop if the key was found
          return true;
        }
    }
      // Returning false if the key is not found
      return false;
    }

    //PostOrder Traversal - Left:Right:rootNode (LRn)
    void postOrder(Node node)  {
      
        if (node == null)
            return;
        //first traverse left subtree recursively
        postOrder(node.left);

        //next traverse right subtree recursively
        postOrder(node.right);
        //then go for root node
        System.out.print(node.key + " ");        
    
    }
    
    // InOrder Traversal - Left:rootNode:Right (LnR)
    void inOrder(Node node)  {
        if (node == null)
            return;
        //first traverse left subtree recursively
        inOrder(node.left);

        //then go for root node
        System.out.print(node.key + " ");

        //next traverse right subtree recursively
        inOrder(node.right);
    }
    //PreOrder Traversal - rootNode:Left:Right (nLR)
    void preOrder(Node node)  {
        if (node == null)
            return;
         //go for root node
        System.out.print(node.key + " ");         
        //first traverse left subtree recursively
        preOrder(node.left);

        //next traverse right subtree recursively
        preOrder(node.right);      
    }

    // Wrappers for recursive functions
    void postOrder_traversal()  {
        postOrder(root);  }
    void inOrder_traversal() {
        inOrder(root);   }
    void preOrder_traversal() {
        preOrder(root);  }
//}
    
/*I added more tests to the main method*/
    public static void main(String[] args)  {
        //create a BST object
      System.out.println("printed");
        BST_Class bst = new BST_Class();
        //insert data into BST
        bst.insert(45);
        bst.insert(10);
        bst.insert(7);
        bst.insert(12);
        bst.insert(90);
        bst.insert(50);
        //bst.postOrder(new Node(30));
        //print the BST
        System.out.println(" \n The BST Created with input data(Left-root-right):");
        bst.inOrder_traversal();
        System.out.println("\n The BST Created with input data(root-left-right):");        
        bst.preOrder_traversal();
        System.out.println("\n The BST Created with input data(left-right-root):");        
        bst.postOrder_traversal();
        
       // Test 1  for min value method 
        BST_Class bst2 = new BST_Class();
        bst2.root = new Node(200);
        bst2.root.left = new Node(100); 
        bst2.root.right = new Node(400);        
        System.out.println("\n The minimum value is "+ bst2.minValue(bst2.root));
      
      // Testing min value method  and the deletion method
        BST_Class bst3 = new BST_Class();
        bst3.root = new Node(15);
        bst3.root.left = new Node(5);
        bst3.root.right = new Node(25);
        bst3.root.right.right = new Node(35);
        //bst3.root.left.right = new Node(12);  
        System.out.println("The BST tree in inorder");
        bst3.inOrder_traversal();  
        System.out.println("\n The minimum value is "+ bst3.minValue(bst3.root));        
        System.out.println("\nThe BST after Delete 15:");
        bst3.deleteKey(15);
        bst3.inOrder_traversal();
        //delete the node with one child
        System.out.println("\nThe BST after Delete 25:");
        bst3.deleteKey(25);
        bst3.inOrder_traversal();

        
        
        //Testing the deletion method
        //delete leaf node
        System.out.println("\nThe BST after Delete 12(leaf node):");
        bst.deleteKey(12);
        bst.inOrder_traversal();
        //delete the node with one child
        System.out.println("\nThe BST after Delete 90 (node with 1 child):");
        bst.deleteKey(90);
        bst.inOrder_traversal();

        //delete node with two children  
        System.out.println("\nThe BST after Delete 45 (Node with two children):");
        bst.deleteKey(45);
        bst.inOrder_traversal();
        //search a key in the BST
        boolean ret_val = bst.search (50);
        System.out.println("\nKey 50 found in BST: " + ret_val );
        ret_val = bst.search (12);
        System.out.println("Key 12 found in BST: " + ret_val );


        //construct a BST
        BST_Class tree = new BST_Class();
        tree.root = new Node(45);
        tree.root.left = new Node(10);
        tree.root.right = new Node(90);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(12);
        //PreOrder Traversal
        System.out.println("\nBST => PreOrder Traversal:");
        tree.preOrder_traversal();
        //InOrder Traversal
        System.out.println("\nBST => InOrder Traversal:");
        tree.inOrder_traversal();
        //PostOrder Traversal
        System.out.println("\nBST => PostOrder Traversal:");
        tree.postOrder_traversal();
        
        
/*I added more tests for my methods*/        
        //construct a BST
        BST_Class tree2 = new BST_Class();
        tree2.root = new Node(30);
        tree2.root.left = new Node(10);
        tree2.root.right = new Node(90);
        tree2.root.left.left = new Node(8);
        tree2.root.left.right = new Node(12);
        //PreOrder Traversal
        System.out.println("\nBST => PreOrder Traversal:");
        tree2.preOrder_traversal();
        //InOrder Traversal
        System.out.println("\nBST => InOrder Traversal:");
        tree2.inOrder_traversal();
        //PostOrder Traversal
        System.out.println("\nBST => PostOrder Traversal:");
        tree2.postOrder_traversal();        
        tree2.minValue(tree.root);
        System.out.println("\n" + tree2.search(10));
        tree2.deleteKey(10);
        System.out.println("\n" + tree2.search(10));
        System.out.println("\n"+ "Deleting 10");
        tree2.inOrder_traversal();
    }
}