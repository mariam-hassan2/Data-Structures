import java.lang.String;
import java.util.*;
/*A class that represents a hashtable*/
public class HashTable{
  // A private class inside the hashtable class
  private class Entry{
    // A field that stores a word 
        private String etymology;
        // A field that stores the frequencey of a word
        private int counter;
        // A field that stores the next entry.
        private Entry next;
        // A constructor for initializing the private class
        private Entry(String etymology) {
          this.etymology = etymology;
          counter = 1;
          next = null;
  }
  }
  // A field that stores a table 
  private Entry[] table;
  // A field that stores the size of the table 
  private int tableSize;
  // A field that stores the number of items in the table
  private int numItems;
  
  
  
  // A constructor that initializes the hashtable class
  public HashTable() {
    tableSize = 3;
    table = new Entry[tableSize];
    numItems = 0;
    
}
 /*A method for the hash function
  * @ parameters: String str*/ 
  private int hash(String str){
    return ((Math.abs(str.hashCode()))%table.length);
  }
  
  /*A mehtod that inserts string into the table
   * @param: String vocable*/
  
  public void add(String vocable){
    Entry str1; 
    String[] arr = vocable.split("\\P{Alpha}+");
    for(String arr2 : arr){
      str1 = new Entry(arr2.toLowerCase());
      add2(str1);
    }    
  }
/*A helper method for the add method above
 * @Param: object Entry */
    public void add2(Entry x){
      // creating a variable to save the key index of the input x
      int index = hash(x.etymology);
   // checking if there is no element at this index
      if(table[index]== null){
        table[index] = x;
        numItems++;
        //checking if the load factor(numItems/tableSize) is bigger than one
          if((numItems/tableSize)>1){
            rehash(); 
          }
        return;
      }
    // checking if there is an element at this index 
      if(table[index]!=null && 
         x.etymology.hashCode()==table[index].etymology.hashCode()){
         table[index].counter++;
         numItems++;
         //checking if the load factor(numItems/tableSize) is bigger than one
          if((numItems/tableSize) >1){
            rehash(); 
          } 
         return;
      }
      //creating an object Entry 
      Entry pointer =table[index];
      //Iterating through the table 
      while(pointer.next !=null){
        //updating the pointer
        pointer = pointer.next;
        // checking if the pointer has the same hashCode as the input 
        if(pointer.etymology.hashCode() == x.etymology.hashCode()){
          //updating the counter
          pointer.counter++;
          //updating numItems
          numItems++;
         //checking if the load factor(numItems/tableSize) is bigger than one 
          if(((double)numItems/(double)tableSize) >1){
            rehash(); 
          } 
          return;
        }
      }
      pointer.next = x;
      numItems++;
      //checking if the load factor(numItems/tableSize) is bigger than one
          if(((double)numItems/(double)tableSize) >1){
            rehash(); 
          }      
    }
    

  //A method for rehasing 
  public void rehash(){
    // creating a veriable to store the size of the current table
  int previousSize = tableSize;
  //  creating a vraiable to stores the current table
  Entry [] previous = table;
  // doubling the size of the table
  tableSize = 2 * previousSize;
  // creating a new table with the new doubled size 
  table = new Entry[tableSize];
  // creating a for loop to add the elements into the new table
  for (int i = 0; i < previousSize; i++){
    if(previous[i]!=null){
    Entry c = previous[i];
    while(c!=null){
      for(int k =0 ; k < c.counter;k++){
      add(c.etymology);
      }
      c = c.next;
    }
    }
  }
  }
 /*A methd for printing the elements of hashtable*/
  public void print(){
    //for loop that iterates over the elements of the table 
    for(int i = 0; i< table.length; i++){
      if(table[i]!=null){
        // Creating a variable called pointer of an index of element in the array
        Entry pointer = table[i];
        // printing the element
        System.out.println(pointer.etymology +" : "+ String.valueOf(pointer.counter));
        //updating the pointer to point at the next element
        pointer = pointer.next;
      }
    }
  }
/*A method for counting the words in a sentence entered
 * @param: String sentence */
  public void wordCount(String sentence){
    // Creating a hashtable object 
    HashTable table = new HashTable();
    // Calling the add method
    table.add(sentence);
    // Calling the print method 
    table.print();
  }
 

}