class Day6 {
    // A linked list is a recursive structure with a pointer to the next element
    // and a integer value. If there's no next, the element is null. You can iterate
    //over this kind of list using the next pointer, checking if that's null.
    //eg. : (head) 5 -> 6 -> 7 -> 8 -> null
    //head=5, head.next=6, head.next.next=7, etc..
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
    //Problem statement: Remove the duplicates (by value) from a sorted LinkedList

    //Solution: While the current element is not null, we can keep iterating the list. (1st while loop)
    //We get the current node and all its next nodes and compare its values. (2nd while loop)
    //Keep comparing and removing the duplicates, making the node pointers maintenance in the way.

    //Time complexity: The algorithm runs in O(n) time, even if it seems that it is O(n^2), due to the
    //two while loops. But, in fact, the second while loop will eliminate all the duplicate values,
    //so when it get back to the first loop, it will not compare again the duplicated values.

    //Space complexity - O(1) no extra space created
    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {

        LinkedList current = linkedList;

        while (current != null) {
            LinkedList next = current.next;

            //We keep going until we removed all duplicates, since the input list is already sorted
            while (next != null && current.value == next.value) {
                //If one duplication is removed, then the next of the current node
                //should point to the next.next node. This is the way to say that we have
                //eliminated the duplicated node. Java Garbage collector will take care of deleting this Object
                //since it doesn't have a reference anymore
                next = next.next;
            }

            //Also do the same node pointer maintenance for the current node. Its next should should point to whatever next value
            //the 2nd while loop found.
            current.next = next;

            //This is to move the pointer and keep iterating over the linked list.
            current = next;
        }

        return linkedList;
    }

}

