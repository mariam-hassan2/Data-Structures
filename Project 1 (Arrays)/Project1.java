import java.util.Random;
import java.io.*;
/* A class that represents the project*/
public class Project1{
//Part A  
  
  
/*A mehtod that prints out the Fibonacci ??? element using iteration
 * @param: n (the number of the element)
    complexity: O(n)*/
  public int fibonacciIteration(int n){
  int prev = 1;
  int last = 1;
  int total = 0;
  //Checking if the input entered by the user is one or two,
  //consequently return one
  if(n==1 || n == 2)
    return 1;
  //iterate through the list to find the nth element
  for(int i=2; i < n; i++){
     total = prev + last;
     prev = last;
     last = total;
  }
  //return the nth element
  return total;
}
  /*A mehtod that prints out the Fibonacci ??? element using recursion
 * @param: n (the number of the element)
    complexity: O(2^n)*/
  public int fibonacciRecursion(int n){
    //check if the input entered by the user is zero, consequently return 0
    if(n == 0){
      return 0;
    }
    //check if the input entered by the user is one or two
    //consequently return 1
    else if(n == 1|| n == 2 ){
      return 1;
    }

    else{

    return fibonacciRecursion(n-1) 
      + fibonacciRecursion(n-2);
    }
      
  }
  /*Iteration method is more efficient: 
   * Iteration: O(n)  
   * Recursion: O(2^n)*/
   public static void main(String[] args) {
    Project1 fib = new Project1();  
    assert(fib.fibonacciIteration(6)==8); 
    System.out.println("Iteration method is more efficient: \nIteration: O(n) \nRecursion: O(2^n)\n"
                        + "Printing the 6th term in the fibonaacci sequence using the iteration method:\n" 
                         + "Expected value is 8 \n" +
                         "Actual result is " + fib.fibonacciIteration(6));
  }
  //part B
  // a field that stores an array
  int array[] = {0,1,1,2,3,5,0,0,0,0,0,0,0,0};
  // a field that stores the number of items in the array
  int numItems = 6;
  /*A mehtod that adds an element to the array
 * @param: int item*/  
  public void add(int item){
    array[numItems] = item;
    numItems++;
  }
  /*A mehtod that removes an element from the array
 * @param: int item*/   
  public void remove(int item){
    int index = -1;
    //A for loop that iterates till we find the item needed to be removed
    for(int i = 0; i < numItems; i++){
      if(array[i] == item)
        index = i;
    }
    if(index == -1)
      return;
    for(int i = index; i < numItems;i++){
      array[i]= array[i+1];
    }
     numItems--;
  }
  /*A mehtod that adds an element to the array
 * @param: int item
   return a boolean*/ 
    public boolean ifContains(int item){
      //A for loop that iterates through the loop to check if a certain item 
      // is in the array
      for(int i = 0; i < array.length;i++){
      if(array[i] == item)
      return true;
  }
      return false;
}
 /*A mehtod that returns a random element from the array
 * returns int */ 
    public int random(){
      return array[new Random().nextInt(array.length)];
    }
/*A mehtod prints out the number of unique items in the list 
 * (without duplicates)*/    
    public void numItems(){
      int counter =0;
      for(int i = 0; i < array.length; i++){
        boolean isDuplicate = false;
        int j;
        for(j = 1; j < i; j++){
           if(array[i] == array[j]){
             isDuplicate = true;
        }
    }
        if(!isDuplicate){
        counter++;
        }
    }
      System.out.println("The numebr of unique elements in the array is " +counter);
}
}