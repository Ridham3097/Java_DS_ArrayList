/**
 *   Student Name: Ridham Patel
 *   Student Id: 000831171
 *
 *
 *   1] Do you notice any significant performance difference between
 *      the SortedLinkedList<T> and the ArrayList<T> classes when adding items?
 *   -  Adding in element in linkedlist is alomst 3 times faster than adding elements in
 *      in arrayList.because in Linked list it will search from first element and put element at proper place
 *      while in arraylist we need to put element at the end and then sort whole array and then will take time
 *      so insertion is faster in LinbkedList than ArrayList
 *
 *   2] Do you notice any significant performance difference
 *      between these two collections when removing items?
 *    - Removing element from ArrayList is way more faster than removing from LinkedList
 *      because in arraylist we can directly search index and remove it while in LinkedList everytime we need
 *      to search from first index to target index to remove it.so ArrayList is way faster then LinkedList
 *
 *   3] When would you choose to use a SortedLinkedList over an ArrayList based on the results of this assignment?
 *    - When I need to insert a element on sorted order while insert it at time i would pick SorteNLinkedList over ArrayList .
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Assignment4
{
  public static void main(String[] args)
  {
    final int NUMBER_OF_NAMES = 18756;
    final String filename = "src/bnames.txt";
    final String[] names = new String[NUMBER_OF_NAMES];
    
     // May be useful for selecting random words to remove
    Random random = new Random();


    // Read in all of the names 
    try {
      Scanner fin = new Scanner(new File(filename));
      for (int i=0; i<NUMBER_OF_NAMES; i++)
          names[i] = fin.next();
      fin.close();
    } catch (FileNotFoundException e) {
      System.out.println("Exception caught: " + e.getMessage());
      System.exit(-1);
    }
 
    // Use the system to build the linked List
    
    // 1. Create the linkedList and add all items in Array
            System.out.println("String Data Type Sorting : \n");
            SortedLinkedList<String> linkedList_String = new SortedLinkedList<>();
            long start = System.nanoTime();
            for (int i=0; i<NUMBER_OF_NAMES;i++)
                linkedList_String.add(names[i]);
            System.out.printf("The time required to add %d elements to a Linked List = %d us\n", linkedList_String.size(), (System.nanoTime() - start) / 1000);


    // 2. Build a standard ArrayList of String - Remember to sort list after each element is added
    //     Time this code

            ArrayList<String> array_List =new ArrayList<String>();

            start = System.nanoTime();
            for (int i=0; i<NUMBER_OF_NAMES;i++) {
              array_List.add(names[i]);            // add element in array
              Collections.sort(array_List);       // to sort array
            }
            System.out.printf("The time required to add %d elements to a Array List  = %d us\n", linkedList_String.size(), (System.nanoTime() - start) / 1000);

   // 3.  Remove half the items and time the code.

            Random rand =new Random();

            start = System.nanoTime();
            int num =NUMBER_OF_NAMES;
            for(int i=0;i<NUMBER_OF_NAMES/2;i++) {
                 linkedList_String.remove((String) linkedList_String.get(rand.nextInt(num)));
                 num--;
            }

            System.out.printf("The time required to delete %d elements to a LinkedList = %d us\n", linkedList_String.size(), (System.nanoTime() - start) / 1000);

    //     remove from arraylist
            start = System.nanoTime();
            num =NUMBER_OF_NAMES;
            for(int i=0;i<NUMBER_OF_NAMES/2;i++) {
              array_List.remove(rand.nextInt(num));
              num--;
            }
            System.out.printf("The time required to delete %d elements to a Aray List = %d us\n", linkedList_String.size(), (System.nanoTime() - start) / 1000);


    // Second Data Type Testing : Integer

      final Integer[] numbers = new Integer[23];
      final String filename1 = "src/Number.txt";
      try {
          Scanner fin1 = new Scanner(new File(filename1));
          for (int i=0; i<numbers.length; i++) {
              numbers[i] =Integer.parseInt(fin1.next());
          }
          fin1.close();
      } catch (FileNotFoundException e) {
          System.out.println("Exception caught: " + e.getMessage());
          System.exit(-1);
      }

      System.out.println("\n Int DataType : \n");
      SortedLinkedList<Integer> sorted_Int =new SortedLinkedList<>();
      start = System.nanoTime();
      for (int i=0; i<23;i++)
          sorted_Int.add(numbers[i]);

      System.out.println("After Adding Value: ");
      System.out.println(sorted_Int);
      sorted_Int.remove(12);
      sorted_Int.remove(677);
      sorted_Int.remove(123);
      sorted_Int.remove(23);
      System.out.println("\nAfter Deleting value: ");
      System.out.println(sorted_Int);




  }   
}
