public class HashTableTest {

 public static void main(String[] args) {
  HashTable test = new HashTable();
  test.wordCount( "I can play basketball and I can play volleyball ");
  
  HashTable test2 = new HashTable();
  System.out.println("\n");
  test2.wordCount("You cannot end a sentence with because because because is a conjunction.");
 }
 
}