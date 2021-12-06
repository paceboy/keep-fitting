package com.interview.list;

/**
 * @author liushaogneg
 * @date 2021/11/15 4:15 下午
 * @description
 */
public class Palindrome {
    public String longestPalindrome(String s) {
        return longestPalindromeWithCenter(s);
//        String res;
//        for(int i=s.length();i>1;i--){
//            for(int j=0;j<=s.length()-i;j++){
//                res = s.substring(j, i+j);
//                if(isPalindrome(res)){
//                    return res;
//                }
//            }
//        }
//        return s.substring(0,1);
    }

    private boolean isPalindrome(String s) {
        boolean ret = true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                ret = false;
                break;
            }
        }
        return ret;
    }

    /**
     * 中心扩散法，遍历整个字符串，以每个字符为中心扩散来判断是不是回文，保留最大的即可
     *
     * @param s
     */
    private String longestPalindromeWithCenter(String s) {
        if (s.length() < 2) {
            return s.substring(0, 1);
        }
        int leftIndex, rightIndex;
        int left, right;
        int step;
        String ret = "", temp = "";
        for (int i = 0; i < s.length(); i++) {
            // 奇数
            left = i;
            right = s.length() - i - 1;
            step = left > right ? right : left;
            leftIndex = i - step;
            rightIndex = i + step;
            temp = getLongestPalindrome(s, leftIndex, rightIndex);
            if (temp.length() > ret.length()) {
                ret = temp;
            }

            // 偶数
            right = s.length() - i - 2;
            step = left > right ? right : left;
            leftIndex = i - step;
            rightIndex = i + step + 1;
            temp = getLongestPalindrome(s, leftIndex, rightIndex);
            if (temp.length() > ret.length()) {
                ret = temp;
            }

        }
        return ret;
    }

    /**
     * 获取最长回文串
     *
     * @param s
     */
    private String getLongestPalindrome(String s, int leftIndex, int rightIndex) {
        String ret = "", temp = "";
        boolean flag = false;
        int left = leftIndex;
        int right = rightIndex;
        while (leftIndex < rightIndex) {
            if (s.charAt(leftIndex) != s.charAt(rightIndex)) {
                flag = true;
            }
            leftIndex++;
            rightIndex--;
            if (flag == true) {
                left = leftIndex;
                right = rightIndex;
                // reset
                flag = false;
            }
        }
        temp = s.substring(left, right + 1);
        if (temp.length() > ret.length()) {
            ret = temp;
        }
        return ret;
    }
}
