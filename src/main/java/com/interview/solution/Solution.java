package com.interview.solution;

import java.util.Stack;

public class Solution {
    /**
     * create by shaogeng at 2021/7/13 19:38
     * description: 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        int mid;
        if (nums.length == 1){
            return nums[0]>=target ? 0:1;
        }

        while(start < end){
            mid = (end+start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return nums[start]>=target ? start:start+1;
    }

    /**
     * create by shaogeng at 2021/3/22 19:38
     * description: 二分法查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target) {
        int start, end, mid;
        start = 0;
        end = nums.length - 1;
        if(nums.length < 3){
            for(int i=0;i< nums.length;i++){
                if(nums[i] == target){
                    return i;
                }
            }
            return -1;
        }

        while(start <= end){
            mid = start + (end - start) / 2;
            if (target == nums[mid]){
                return mid;
            }
            if(target < nums[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }

    public int rotate(int i) {

        int ret = 0;
        int mod;
        while (i != 0) {
            if (ret > Integer.MAX_VALUE / 10 || ret < Integer.MIN_VALUE / 10) {
                return 0;
            }
            mod = i % 10;
            ret = ret * 10 + mod;
            i = i / 10;
        }
        return ret;
    }


    /**
     * create by shaogeng at 2021/3/22 19:38
     * description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *
     * @param
     * @return
     */
    public boolean validBrackets(String s) {
        java.util.Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (isValidLeftBracket(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (isValidRightBracket(s.charAt(i))) {
                if (isValidBracketGroup(stack.lastElement(), s.charAt(i))) {
                    stack.pop();
                }
            } else {
                break; // 无效字符跳出循环
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否一对正确的括号
     *
     * @param
     * @return
     */
    public boolean isValidBracketGroup(char first, char second) {
        switch(second){
            case ']':
                if(first == '['){
                    return true;
                }
                break;
            case '}':
                if(first == '{'){
                    return true;
                }
                break;
            case ')':
                if(first == '('){
                    return true;
                }
                break;
        }
        return false;
    }

    /**
     * 判断是否是左括号
     *
     * @param
     * @return
     */
    public boolean isValidLeftBracket(char c) {
        if (c == '[' || c == '{' || c == '(') {
            return true;
        }
        return false;
    }

    /**
     * 判断是否是右括号
     *
     * @param
     * @return
     */
    public boolean isValidRightBracket(char c) {
        if (c == ']' || c == '}' || c == ')') {
            return true;
        }
        return false;
    }
}