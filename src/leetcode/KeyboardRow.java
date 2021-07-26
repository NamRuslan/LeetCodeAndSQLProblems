package leetcode;

import java.util.*;

/**
 * Given an array of strings words, return the words that can be typed
 * using letters of the alphabet on only one row of American keyboard
 *
 * Example 1:
 *
 * Input: words = ["Hello","Alaska","Dad","Peace"]
 * Output: ["Alaska","Dad"]
 *
 * Example 2:
 *
 * Input: words = ["omk"]
 * Output: []
 *
 * Example 3:
 *
 * Input: words = ["adsdf","sfd"]
 * Output: ["adsdf","sfd"]
 */
public class KeyboardRow {
static class Solution {
    public String[] findWords(String[] words) {
        Set<Character> qwe = Set.of('q','w','e','r','t','y','u','i','o','p','Q','W','E','R','T','Y','U','I','O','P');
        Set<Character> asd = Set.of('a','s','d','f','g','h','j','k','l','A','S','D','F','G','H','J','K','L');
        Set<Character> zxc = Set.of('z','x','c','v','b','n','m','Z','X','C','V','B','N','M');

        List<String> list = new ArrayList<>();

        WORDS: for (String s : words) {
            Set<Character> set = new HashSet<>();
            if (qwe.contains(s.charAt(0))) {
                set = qwe;
            } else if (asd.contains(s.charAt(0))) {
                set = asd;
            } else if (zxc.contains(s.charAt(0))) {
                set = zxc;
            }

            for (int i = 1; i < s.length(); i++) {
                if (!set.contains(s.charAt(i))) {
                    continue WORDS;
                }
            }
            list.add(s);
        }

        return list.toArray(new String[0]);
    }
}

}
