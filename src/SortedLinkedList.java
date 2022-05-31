
/**
 * @author : Ridham Patel 000831171
 * Generic Linked List class that always keeps the elements in order 
 *
 */
public class SortedLinkedList<T extends Comparable>
{
  /**
   * The Node class stores a list element and a reference to the next node.
   */
  private final class Node<T extends Comparable >
  {
    T value;
    Node next;

    /**
     * Constructor.
     * @param val The element to store in the node.
     * @param n The reference to the successor node.
     */
    Node(T val, Node n)
    {
      value = val;
      next = n;
    }

    /**
     * Constructor.
     *
     * @param val The element to store in the node.
     */
    Node(T val)
    {
      // Call the other (sister) constructor.
      this(val, null);
    }
  }
  private Node first;  // list head

  /**
   * Constructor.
   */
  public SortedLinkedList()
  {
    first = null;
  }

  /**
   * The isEmpty method checks to see if the list is empty.
   *
   * @return true if list is empty, false otherwise.
   */
  public boolean isEmpty()
  {
    return first == null;
  }

  /**
   * The size method returns the length of the list.
   * @return The number of elements in the list.
   */
  public int size()
  {
    int count = 0;
    Node p = first;
    while (p != null) {
      // There is an element at p
      count++;
      p = p.next;
    }
    return count;
  }

  /**
   * The add method adds an element at a position.
   * @param element The element to add to the list in sorted order.
   */
  public void add(T element)
  {

    if(isEmpty()) {
      first = new Node(element);

    } else {

      Node n = first;
      while((n.next != null) && (n.next.value).compareTo(element) < 0  ) {
        n = n.next;
      }

      Node newNode1 = new Node(element);
      newNode1.next = n.next;
      n.next = newNode1;

    }
  }

  /**
   * To get element from perticular index
   * @param data index number
   * @return element
   */
  public T get(int data){

    Node node=first;
    for(int i=0;i<data;i++){
         node =  node.next;
    }

    return (T) node.value;
  }


  /**
   * The toString method computes the string representation of the list.
   * @return The string form of the list.
   */
  public String toString()
  {
    String listOfItems = "";   
    
    // TODO: Iterate through the list and append items to end of listOfItems

    String s = "["; // Use p to walk down the linked list
    Node current = first;
    while (current != null) {
      listOfItems += current.value;
      current = current.next;
      if (current != null) listOfItems += ",";
    }
    return listOfItems + "]";
    

  }

  /**
   * The remove method removes an element.
   * @param element The element to remove.
   * @return true if the remove succeeded, false otherwise.
   */
  public boolean remove(T element)
  {
    Node n=first;
    boolean result =true;
    if(n.value.equals(element)){
      first = first.next;
      return result;
    }
    else{
      Node n1=null;
      while(n.next != null){
        if(!n.next.value.equals(element)) {
          n = n.next;
          result = false;
        }else{

          break;
        }
      }

      if(n.next!=null) {
        n1 = n.next;
        n.next = n1.next;
      }

    }
    return result;
  }
}