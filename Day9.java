import java.util.ArrayList;
import java.util.List;

public class Day9 {

    //Problem statement: Given an integer array, return an array answer such that answer[i]
    // is equal to the product of all the elements of nums except array[i].
    //Example:
    //Given the array [10, 2, 3, 4], the answer should be [24, 120, 80, 60], because:
    //[24, 120, 80, 60] = [2*3*4, 10*3*4, 10*2*4, 10*2*3]
    //Solution strategy:
        //Calculate all the products from left to right, except for the current element at index i (1st loop)
        //After the left calculation pass, your array will be something like this:
        //[1, 10, 20, 60] = [1, 1*10, 1*10*2, 1*10*2*3]
        //Now you need a second pass starting at the rightMost index in your array (2nd loop) to handle the missed elements,
        //After the second pass:
        //[24, 120, 80, 60] = [1*2*3*4*1 ,10*3*4*1, 20*4*1, 60*1]
    //Time complexity: Two non-nested loops of the same size of the input array, leading to O(n) time
    //Space complexity: Extra space needed to store the elements of the output, thus this is O(n) in space

    public List<Integer> productExceptSelf(List<Integer> array) {
        List<Integer> output = new ArrayList<>();

        int leftProd = 1;
        int rightProd = 1;

        for (int i = 0; i < array.size(); i++) {
            output.add(i, leftProd);
            leftProd = leftProd * array.get(i);
        }

        for (int j = array.size() - 1; j >= 0; j--) {
            output.add(j, output.get(j) * rightProd);
            rightProd = rightProd * array.get(j);
        }

        return output;
    }
}
