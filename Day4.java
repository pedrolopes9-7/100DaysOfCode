package com.sigma.dsalgo.factory;

import java.util.Collections;
import java.util.List;

public class Day4 {
    //Problem statement: You're given a list of orders in a restaurant
    //where each integer represents the time needed to finish that particular order.
    //The waiting time of an order is the amount of time that it needs to wait before its
    //execution starts. In other words, a particular order must wait the time of all orders executed before it.
    //You job is to find the minimum amount of total waiting time for all orders.For instance, if orders are [6 7 5],
    //then the minimum waiting time would be (0) + (5) + (6 + 5) = 16 executing the orders as [5 6 7].
    //The first orders doesn't need to wait.

    //The problem can be solved using a Greedy algorithm. The greedy choice for this problem will always be to pick
    //the minimum waiting times first, since we are iterating the orders from beginning to end.
    //So, the first thing we need to do is to sort the orders in crescent order. Then we always pick the next order in the
    //sorted orders list and calculate the overall waiting time.

    //Time complexity: This is O(n log n) since the Collections.sort method in Java uses TimSort implementation.
    //Both methods are O(n lg n). Also, the for loop is O(n), but O(n lg n) is bigger than O(n), so we cut it from the equation.

    //Space complexity: No additional space needed and TimSort doesn't need additional space. Therefore, this algorithm is O(1)
    public int minimumWaitingTime(List<Integer> orders) {
        Collections.sort(orders);
        int totalWaitingTime = 0;

        for (int i = 0; i < orders.size(); i++){
            //Notice that each orders must count the times from ALL the previous orders. That's why we multiply the current order by
            //all the orders visited so far, and then we add up to the Total Waiting Time.
            totalWaitingTime += (orders.size() - (i + 1)) * orders.get(i);
        }
        return totalWaitingTime;
    }
}
