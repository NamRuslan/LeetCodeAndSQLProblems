package leetcode;

import java.util.*;

/**
 * Suppose Andy and Doris want to choose a restaurant for dinner,
 * and they both have a list of favorite restaurants represented by strings.
 *
 * You need to help them find out their common interest with the least list index sum.
 * If there is a choice tie between answers, output all of them with no order requirement.
 * You could assume there always exists an answer.
 *
 * Example 1:
 *
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 *
 * Example 2:
 *
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
 * Output: ["Shogun"]
 * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 *
 * Example 3:
 *
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Burger King","Tapioca Express","Shogun"]
 * Output: ["KFC","Burger King","Tapioca Express","Shogun"]
 *
 * Example 4:
 *
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KNN","KFC","Burger King","Tapioca Express","Shogun"]
 * Output: ["KFC","Burger King","Tapioca Express","Shogun"]
 *
 * Example 5:
 *
 * Input: list1 = ["KFC"], list2 = ["KFC"]
 * Output: ["KFC"]
 */
public class MinimumIndexSumOfTwoLists {
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {

        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int indSum = list1.length + list2.length - 2;

        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    map.put(list1[i], i + j);
                    if (i + j < indSum) indSum = i + j;
                    break;
                }
            }
        }

        for (String s : map.keySet()) {
            if (map.get(s) == indSum) {
                res.add(s);
            }
        }

        return res.toArray(String[]::new);
    }
}

class Solution2 {
    public String[] findRestaurant(String[] list1, String[] list2) {

        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int curIndSum, minIndSum = Integer.MAX_VALUE;

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                curIndSum = map.get(list2[i]) + i;
                if (curIndSum < minIndSum) {
                    res.clear();
                    res.add(list2[i]);
                    minIndSum = curIndSum;
                } else if (curIndSum == minIndSum) {
                    res.add(list2[i]);
                }
            }
        }

        return res.toArray(String[]::new);
    }
}


}