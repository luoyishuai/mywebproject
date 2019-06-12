package com.yishuailuo.mywebproject.algorithm;

import java.util.LinkedList;
import java.util.List;

public class PokerSortSolution {


    public static void main(String[] args) {
        int[] deskPokers = {2, 4, 5, 3, 1};
        sort(deskPokers);
    }


    static List<Integer> sort(int[] deskPokers) {
        int length = deskPokers.length;
        LinkedList<Integer> deskPokersList = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            deskPokersList.add(deskPokers[i]);
        }

        LinkedList<Integer> handPokersList = new LinkedList<>();

        for (Integer poker : deskPokersList) {
            if (handPokersList.size() > 1) {
                handPokersList.addFirst(handPokersList.pollLast());
            }
            handPokersList.addFirst(poker);
        }

        handPokersList.forEach(System.out::println);
        return handPokersList;
    }
}