 import java.util.Arrays;
public class Benchmarking{
	
	public static void main(String[] args){
		
		int size = Integer.parseInt(args[0]);
		//System.out.printf("Results for arrays of size %d\n",size);
		
		/*
		Carrying out the methods timing for the methods this way:
		-> Generate Sorted, unsorted, random arrays of size "size"
		-> Run the sorting algorithms on these arrays and time them
		-> Printout the results	
		*/
		
		/*insertion sort*/
		System.out.println("Insertion sort");		
		Sort s = new Sort();
		//generating random, sorted and unsorted arrays 
		int[] randomArray1 = s.generateRandomArray(size);
		int[] sortedArray1 = s.generateRandomArray(size);
		s.insertionSort(sortedArray1);
		int[] unsortedArray1 = s.generateRandomArray(size);
		Arrays.sort(unsortedArray1);	
		
		
		/*running the sorting algorithm on the random arrays and printing the time */
		System.out.printf("Results for random arrays of size %d\n",size);			
		long start = System.nanoTime();		
		s.insertionSort(randomArray1);
		long end = System.nanoTime();		
		long time = end - start;
		System.out.println("Insertion sort time: " + time + "\n");	
		start = System.nanoTime();
		
		/*running the sorting algorithm on the unsorted arrays and printing the time */		
		System.out.printf("Results for unsorted arrays of size %d\n",size);				 
		start = System.nanoTime();		
		s.insertionSort(unsortedArray1);
		end = System.nanoTime();		
		time = end - start;
		System.out.println("Insertion sort time: "+ time + "\n");	
		
		/*running the sorting algorithm on the sorted arrays and printing the time */
		System.out.printf("Results for sorted arrays of size %d\n",size);				
		start = System.nanoTime();
		s.insertionSort(sortedArray1);
		 end = System.nanoTime();		
		 time = end - start;
		System.out.println("Insertion sort time: "+ time + "\n");	
		
	
	
		/*bubble sort*/
	
		/*generating random, sorted and unsorted arrays*/
		System.out.println("bubble sort");
		int[] randomArray2 = s.generateRandomArray(size);
		int[] sortedArray2 = s.generateRandomArray(size);
		s.bubbleSort(sortedArray2);
		int[] unsortedArray2 = s.generateRandomArray(size);
		Arrays.sort(unsortedArray2);	
		
		
		/*running the sorting algorithm on the random arrays and printing the time */		
		System.out.printf("Results for random arrays of size %d\n",size);
		start = System.nanoTime();		
		s.bubbleSort(randomArray2);
		end = System.nanoTime();		
		time = end - start;		
		System.out.println("bubble sort time: "+ time + "\n");	
		 
		
		
		/*running the sorting algorithm on the unsorted arrays and printing the time */		
		System.out.printf("Results for unsorted arrays of size %d\n",size);		 
		start = System.nanoTime();		
		s.bubbleSort(unsortedArray2);
		end = System.nanoTime();		
		time = end - start;
		System.out.println("bubble sort time: "+ time + "\n");	

		
		/*running the sorting algorithm on the sorted arrays and printing the time */		
		System.out.printf("Results for sorted arrays of size %d\n",size);				
		start = System.nanoTime();
		s.bubbleSort(sortedArray2);
		 end = System.nanoTime();		
		 time = end - start;
		 System.out.println("bubble sort time: "+ time + "\n");			
			
		
		

		 /*shell sort*/
		/*generating random, sorted and unsorted arrays*/		 
		System.out.println("shell sort");
		int[] randomArray3 = s.generateRandomArray(size);
		int[] sortedArray3 = s.generateRandomArray(size);
		s.shellSort(sortedArray3);
		int[] unsortedArray3 = s.generateRandomArray(size);
		Arrays.sort(unsortedArray3);	
		
		
		/*running the sorting algorithm on the random arrays and printing the time */				
		System.out.printf("Results for random arrays of size %d\n",size);
		start = System.nanoTime();		
		s.shellSort(randomArray3);
		end = System.nanoTime();		
		time = end - start;		
		System.out.println("shell sort time: "+ time + "\n");	
		start = System.nanoTime();
		
		/*running the sorting algorithm on the unsorted arrays and printing the time */		
		System.out.printf("Results for unsorted arrays of size %d\n",size);		 
		start = System.nanoTime();		
		s.shellSort(unsortedArray3);
		end = System.nanoTime();		
		time = end - start;
		System.out.println("shell sort time: "+ time + "\n");	
		
		
		/*running the sorting algorithm on the sorted arrays and printing the time */		
		System.out.printf("Results for sorted arrays of size %d\n",size);				
		start = System.nanoTime();
		s.shellSort(sortedArray3);
		 end = System.nanoTime();		
		 time = end - start;
		 System.out.println("shell sort time: " + time + "\n");	
		
		 		 
		 
            /*quick sort*/
			/*generating random, sorted and unsorted arrays*/		 
			System.out.println("quick sort");
			int[] randomArray4 = s.generateRandomArray(size);
			int[] sortedArray4 = s.generateRandomArray(size);
			s.quickSort(sortedArray4);
			int[] unsortedArray4 = s.generateRandomArray(size);
			Arrays.sort(unsortedArray4);	
			
			
			/*running the sorting algorithm on the random arrays and printing the time */			
			System.out.printf("Results for random arrays of size %d\n",size);
			start = System.nanoTime();		
			s.quickSort(randomArray4);
			end = System.nanoTime();		
			time = end - start;		
			System.out.println("quick sort time: "+ time + "\n");	
			 
			/*running the sorting algorithm on the unsorted arrays and printing the time */			
			System.out.printf("Results for unsorted arrays of size %d\n",size);		 
			start = System.nanoTime();		
			s.quickSort(unsortedArray4);
			end = System.nanoTime();		
			time = end - start;
			System.out.println("quick sort time: "+ time + "\n");	
			
			/*running the sorting algorithm on the sorted arrays and printing the time */			
			System.out.printf("Results for sorted arrays of size %d\n",size);				
			start = System.nanoTime();
			s.quickSort(sortedArray4);
			 end = System.nanoTime();		
			 time = end - start;
			 System.out.println("quick sort time: "+ time + "\n");		
			 
			 
			/* merge sort*/
			 
				/*generating random, sorted and unsorted arrays*/			 
				System.out.println("merge sort");
				int[] randomArray5 = s.generateRandomArray(size);
				int[] sortedArray5 = s.generateRandomArray(size);
				s.mergeSort(sortedArray5);
				int[] unsortedArray5 = s.generateRandomArray(size);
				Arrays.sort(unsortedArray5);	
				
				
				/*running the random algorithm on the sorted arrays and printing the time */			
				System.out.printf("Results for random arrays of size %d\n",size);
				start = System.nanoTime();		
				s.mergeSort(randomArray5);
				end = System.nanoTime();		
				time = end - start;		
				System.out.println("merge sort time: "+ time + "\n");	
				 
				
				/*running the sorting algorithm on the unsorted arrays and printing the time */							
				System.out.printf("Results for unsorted arrays of size %d\n",size);		 
				start = System.nanoTime();		
				s.mergeSort(unsortedArray5);
				end = System.nanoTime();		
				time = end - start;
				System.out.println("merge sort time: "+ time + "\n");	
				
				/*running the sorting algorithm on the sorted arrays and printing the time */			
				
				System.out.printf("Results for sorted arrays of size %d\n",size);				
				start = System.nanoTime();
				s.mergeSort(sortedArray5);
				 end = System.nanoTime();		
				 time = end - start;
				 System.out.println("merge sort time: "+ time + "\n");					 
			 

				 
				 
				 
				  /*upgraded quick sort*/
				 /*generating random, sorted and unsorted arrays*/
					System.out.println("upgraded quick sort");
					int[] randomArray6 = s.generateRandomArray(size);
					int[] sortedArray6 = s.generateRandomArray(size);
					s.quickSort(sortedArray6);
					int[] unsortedArray6 = s.generateRandomArray(size);
					Arrays.sort(unsortedArray6);	
					
					
					/*running the sorting algorithm on the random arrays and printing the time */			
					System.out.printf("Results for random arrays of size %d\n",size);
					start = System.nanoTime();
					int d = randomArray6.length/2;
					int k = d/2;
					s.upgradedQuickSort(randomArray6,d,k);
					end = System.nanoTime();		
					time = end - start;		
					System.out.println("upgraded quick sort sort time: "+ time + "\n");	
					 
					
					
					/*running the sorting algorithm on the unsorted arrays and printing the time */								
					System.out.printf("Results for unsorted arrays of size %d\n",size);		
					 d = unsortedArray6.length/2;
					 k = d/2;					
					start = System.nanoTime();		
					s.upgradedQuickSort(unsortedArray6,d,k);
					end = System.nanoTime();		
					time = end - start;
					System.out.println("upgraded quick sort time: "+ time + "\n");	
					
					/*running the sorting algorithm on the unsorted arrays and printing the time */			
					System.out.printf("Results for sorted arrays of size %d\n",size);	
					 d = sortedArray6.length/2;
					 k = d/2;					
					 start = System.nanoTime();
					 s.upgradedQuickSort(sortedArray6,d,k);
					 end = System.nanoTime();		
					 time = end - start;
					 System.out.println("upgraded quick sort time: "+ time + "\n");	 	
	}

}

