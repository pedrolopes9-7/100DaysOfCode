import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsExample {
    public static void main(String[] args) {
        Set<Integer> setOne = new HashSet<>();
        Set<Integer> setTwo = new HashSet<>();

        //is sub set
        setTwo.containsAll(setOne);
        //union
        setOne.addAll(setTwo);
        //intersection
        setOne.retainAll(setTwo);
        //difference
        setOne.removeAll(setTwo);

        List<Integer> myList = new ArrayList<>(Arrays.asList(5, 3, 10, 15));
        boolean isContained = myList.contains(5); //true
        List<Integer> firstTwoIndexes = myList.subList(0, 1); //[5, 3]
        int size = myList.size(); //4
        int indexOfFive = myList.indexOf(5); //0
        myList.remove(Integer.valueOf(15));
        myList.remove(1);

        Collections.sort(myList); //myList = [3, 5, 10, 15]
        Integer element = Collections.binarySearch(myList, 5); //1 (index of the key=5)
        Integer maxValue = Collections.max(myList); //15
        Collections.swap(myList, 0, 1); //myList = [5, 3, 10, 15]
        Collections.reverse(myList); //myList = [15, 10, 3, 5]


        //1 - Using the common public constructor
        //List<Integer> myList = new ArrayList<>(4);
//
//        myList.add(5);
//        myList.add(3);
//        myList.add(10);
//        myList.add(15);

        //2 - Using the static factory in List interface.
        List<Integer> mySecondList = List.of(5, 3, 10, 15);

        //3 - Using the Arrays utility class


    }
}
