package cce105;

	import java.util.Queue;
	import java.util.LinkedList;
	import java.util.Scanner;

	public class LabActPermCombi {

	    static Scanner input = new Scanner(System.in);

	    // Queue implementation
	    static Queue<String> queue = new LinkedList<>();

	    public static void main(String[] args) {

	        int choice;

	        do {
	            System.out.println("\n===== PERMUTATION AND COMBINATION =====");
	            System.out.println("[1] Add Elements to Queue");
	            System.out.println("[2] Display Queue");
	            System.out.println("[3] Generate Permutations");
	            System.out.println("[4] Generate Combinations");
	            System.out.println("[5] Exit");
	            System.out.print("Enter choice: ");

	            choice = input.nextInt();

	            switch (choice) {

	                case 1:
	                    addElements();
	                    break;

	                case 2:
	                    displayQueue();
	                    break;

	                case 3:
	                    generatePermutations();
	                    break;

	                case 4:
	                    generateCombinations();
	                    break;

	                case 5:
	                    System.out.println("Program terminated.");
	                    break;

	                default:
	                    System.out.println("Invalid choice!");
	            }

	        } while (choice != 5);
	    }

	    // TODO 1: Accept elements and add them to the Queue
	    static void addElements() {
	        // Ask how many elements to add
	        // Use queue.add() to insert elements
	    	System.out.println("How many elements to add?: ");
	    	int count = input.nextInt();
	    	input.nextLine();
	    	
	    	for(int i = 0; i < count; i++ ) {
	    		System.out.println("Add elements: ");
	    		String element = input.nextLine();
	    		queue.add(element);
	    	}
	    }

	    // TODO 2: Display all elements in the Queue
	    static void displayQueue() {
	        // Display the contents of the Queue
	    	System.out.println("Current queue: " + queue);
	    }

	    // TODO 3: Generate all possible permutations
	    static void generatePermutations() {
if (queue.isEmpty()) return;

	        // Ask how many elements should be selected (r)
	        // Generate all possible arrangements
	        // Display the total number of permutations
	    	System.out.println("Enter how many elements should be selected (r): ");
	    	int r = input.nextInt();
	    	System.out.println();
	    	int total = permuteQueue(queue,r,"");
	    	System.out.println("\n Total Permutations: "+ total);
	    	
//	    	if(r < 0 || r > )
	    	

	    }
	    private static int permuteQueue(Queue<String>q,int r, String current) {
	    	if (current.length() == r) {
	    		System.out.println(current);
	    		return 1;
	    		
	    	}
	    	int total = 0;
	    	int size = q.size();
	    	
	    	//standard queue rotat
	    	for(int i=0; i<size; i++) {
	    		String element = q.poll();
	    		
	    		total += permuteQueue(q,r,current + element);
	    		q.add(element);
	    	}
	    	return total;
	    }

	    // TODO 4: Generate all possible combinations
	    static void generateCombinations() {
	    		if (queue.isEmpty()) return;
	    		
	    		System.out.println("Enter number of elements to select: ");
	    		int r = input.nextInt();
	    		
	    		System.out.println();
	    		int total = combineQueue(queue,r,0,"");
	    		System.out.println("\nTotal Combinations: "+ total);
	    		
	        // Ask how many elements should be selected (r)
	        // Generate all possible selections
	        // Avoid duplicate combinations
	        // Display the total number of combinations

	    }
	    private static int combineQueue(Queue<String> q, int r, int index, String current) {
	    	if(current.length()== r) {
	    		System.out.println(current);
	    		return 1;
	    	}
	    	int total = 0;
	    	int size = q.size();
	    	
	    	for (int i = index; i <size; i++) {
	    		for(int j=0;j<i;j++) {
	    			q.add(q.poll());
	    		}
	    	String element = q.poll();
	    	total += combineQueue(q,r,i,current+element);
	    	
	    	q.add(element);
	    	for(int j = i+1;j<size;j++) {
	    		q.add(q.poll());
	    	}
	    	}
	    	return total;
	    		
	    }
	}
	
	