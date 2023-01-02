import java.io.*;
import java.util.*;
public class Sort {

	public static void main(String[] args)throws Exception {
		
	    generateRandomArray(5);
	    //testing insertion method
	    int[] array_test1 = {6,4,5,2};
	    insertionSort(array_test1);
	    print(array_test1);
	    //testing shell sort method
	    int[] array_test2 = {6,4,3,4,10,5,2};
	    shellSort(array_test2);
	    print(array_test2); 
	    //testing quicksort method
	    int[] array_test3 = {3,2,4,6,5,4,6,2,3,1};
	    quickSort(array_test3);
	    print(array_test3);
	    //testing merge sort
	    int[] array_test4 = {40,20,30,70,50};
	    mergeSort(array_test4);
	    print(array_test4);  
	    //testing bubblesort method
	    int[] array_test5 = {0,9,4,60,15,12,1,3};
	    bubbleSort(array_test5);
	    print(array_test5);
	    
	    //testing upgraded quick sort method
	    int[] array_test6 = {70,90,60,80,10,40,100,1};
	    int d = array_test6.length/2;
	    int k = d/2;
	    upgradedQuickSort(array_test6,d,k);
	    print(array_test6); 

	    //testing readCommands method
	    //readCommands("C:\\Users\\mxh939\\Downloads\\commands.txt");	    
	    
	  } 
	  /*A method for printing the array
	   * @param: an array of type int*/
	  public static void print(int[] array){
	    String newArray = "{";
	    //A for loop that iterates through the array 
	    for(int i=0; i< array.length; i++){
	      newArray+= String.valueOf(array[i])+",";
	   }
	    newArray += "}";
	    // printing the array
	    System.out.println(newArray);
	 }
	  /*A method that sorts an array
	   * @param: array of type int*/
	  public static void insertionSort(int[] array2){
	    // A for loop that iterates through the elements of the array
	    for(int i = 1; i < array2.length; i++){
	      //creating a variable that the stores the element at a certain index
	      int insert = array2[i];
	      // A for loop that iterates 
	      int j = 0;
	      // A for loop that iterates through the swaps two elements in the array
	      for(j = i; j > 0 && insert < array2[j-1];j--){
	        array2[j] = array2[j-1];
	      }
	        array2[j] = insert;
	    }
	  }
	  /*A method that sorts an array using bubble sort algorithm*/
	  public static void bubbleSort(int[] array){
		//two for loops that iterate through the array
	    for(int i= array.length-1; i > 0; i--){	
	      for(int j =0; j < i ;j++){
	        if(array[j] > array[j+1]){
	        //swapping array[j] and array[j+1] if array[j] is greater than array[j+1]
	        swap(array, j, j+1);
	        }
	      }
	    }
	  
	  }
	  /*A helper method for swapping two elements in an array
	   * @param: array and two ints*/
	  public static void swap(int[] array, int index_1, int index_2){
	    //creating a variable that stores the element in index 1
	  int temp = array[index_1];
	  //swapping the two elements
	  array[index_1] = array[index_2];
	  array[index_2] = temp;
	  }
	  /*A method that sorts an array using shell sort algorithm 
	   * @param: int array*/
	  public static void shellSort(int[] array){
	    // creating a variable to store the value of the increment
	    int increment = 1;
	    //a while loop that iterates as loong as the array length is equal to or greater than double the increment value
	    while(2 * increment <= array.length)
	      increment = increment * 2;
	      increment = increment - 1;
	      
	    //a while loop that iterates as long as increment is equal to or greater than 1
	      while(increment >= 1){
	    	  // a for loop that iterates through the array
	        for(int i = increment; i < array.length; i++){
	        //creating a variable that stores the element at a certain index in the array
	          int insert = array[i];
	          int j = 0;
	          
	          for(j = i; j > increment - 1 && insert < array[j-increment]; j = j-increment)
	            array[j] = array[j - increment];
	          
	          array[j] = insert;        
	        }
	        //updating the increment variable
	      increment = increment / 2;        
	      }
	  }
	  
	  /*A method that sorts the array using quicksort algorithm
	   * @param: an array of type int*/
	  public static void quickSort(int[] array){
	    myQuickSort(array,0,array.length-1);  
	  }
	  /*A helper method for quicksort
	   * @param: an array of type int, two ints */
	  public static void myQuickSort(int[] array, int first, int last){
		  // checking if first is equal to greater than last
	    if(first >= last)return;
	    //creating a variable split and calling helper method partition 
	    int split = partition(array,first,last);
	    myQuickSort(array, first, split);
	    myQuickSort(array, split+1, last);
	  }
	  
	  /*A helper method for quicksort method
	   * @ param: an array of type int, two ints*/
	  public static int partition(int[] array, int first, int last){
		  // creating a variable for the pivot point 
	    int pivot = array[(first+last)/2];
	    int i = first - 1;
	    int j = last + 1;
	    while(true){
	      do{
	        i++;
	      }
	      while(array[i] < pivot);
	      do{
	        j--;
	      }
	      while(array[j] > pivot);{
	        if(i<j){
	          swap(array,i,j);
	        }
	        else{
	          return j;
	        }
	        
	      }
	   }
	  }
	  /*A method that  uses the merge sort algorithm to sort the input array
	   * into descending order.
	   @param: takes an input array of integers.*/
	  public static void mergeSort(int[] array){
	    myMergeSort(array);
	  }
	  /*A helper method for the merge method
	   * @param: array of type int*/
	  public static void myMergeSort(int[] array){
		  //checking if the array has only one element
	  if(array.length == 1) return;
	  // creating two variables for left and right arrays
	  int[] left_array = new int[(array.length)/2];
	  int[] right_array = new int[array.length- left_array.length];  
	  //calling the helper method split
	  split(array, left_array, right_array);
	  
	  myMergeSort(left_array);
	  myMergeSort(right_array);
	  merge(array, left_array, right_array);
	  }
	  /*A helper method for the merge method taht splits the array into two arrays
	   * @param: three arrays of type int*/
	  public static void split(int[] array, int[] left_array, int[] right_array){
		  // a for loop that iterates through the left array
	    for(int i=0; i < left_array.length; i++){
	    left_array[i] = array[i];
	    }
	    // a for loop that iterates through the right array
	    for(int j = 0; j < right_array.length; j++){
	    right_array[j] = array[left_array.length + j];
	    }    
	  }
	  /*A method that sorts the array using the merge algorithm*/
	  public static void merge(int[] array, int[] left_array, int[] right_array){
	    int i = 0;
	    int j = 0;
	    int k = 0;
	    while(i < left_array.length && j < right_array.length){
	      if(left_array[i] < right_array[j]){
	        array[k] = left_array[i];
	        i++;
	      }
	      else{
	        array[k]= right_array[j];
	        j++;
	      }
	      k++;
	    }
	    while(i < left_array.length){
	      array[k] = left_array[i];
	      i++;
	      k++;
	    }
	    while(j < right_array.length){
	      array[k] = right_array[j];
	      j++;
	      k++;
	    }  
	  
	  }
	  /*A method that sorts the array using the upgraded quick sort algorithm*/
	  public static void upgradedQuickSort(int[] input, int d, int k){
		  //a while loop that works as long as d is greater than k
		    while(d > k){
		       // checking if k minus d is less than 10, then insertion sort method is called    
		      if(k - d < 10){
		        insertionSort(input);
		        break;
		      } 
		      // if d is equal to 10, then the merge sort is called
		      else if(d == 10){
		        
		            mergeSort(input);
		            break;
		           
		      }
		      else{
		      int pivot = partition(input, d, k);
		          if(pivot - d < k - pivot){
		            upgradedQuickSort(input, d, pivot - 1);
		            d = pivot + 1;
		          }          
		          else{
		            upgradedQuickSort(input, pivot + 1, k);
		            k = pivot - 1;
		          }
		      }
		    }
		  }
	  
	  /*A method that generates a random array
	   * @ input: int value (size of the array)*/
	  public static int[] generateRandomArray (int n){
	  Random temp = new Random();
	  //creating a variable for the random array with size n (input size)
	  int[] Random_Array = new int[n];
	  String String_Array = "{";
	  // a for loop that iterates through the array to fill it up with elements
	  for(int i = 0; i < n; i++){
	    Random_Array[i] = temp.nextInt();
	    String_Array += String.valueOf(Random_Array[i]) + ",";
	  }
	  //printing the array
	  System.out.println(String_Array);
	  //returning the array created
	  return Random_Array;
	  }
	 /*A method that reads the commands in a file
	  * @param: string that represents a file path*/ 
	  public static void readCommands(String filepath)throws Exception{
		  // creating a bufferreader object
	    BufferedReader br = new BufferedReader(new FileReader(filepath));
	    String s;
	    while((s = br.readLine())!=null){
	    //printing the commands
	    System.out.println(s);
	    }    
	  }
	

}
