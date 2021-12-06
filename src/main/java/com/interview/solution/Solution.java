package com.interview.solution;

import java.util.*;

public class Solution {

    /**
     * create by shaogeng at 2021/7/13 09:46
     * description: 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     *
     * @param nums
     * @param k
     * @return
     */
    public void rotate(int[] nums, int k) {

    }

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

    /**
     * 判断单词个数
     *
     * @param words 由空格分割的单词
     * @return
     */
    public void statisticsWordCount(String words) {
        // 1、分割字符串
        String[] sa = words.split(" ");

//        2、统计单词个数并放入map
        HashMap hm = new HashMap<String, Integer>();
        for(int i = 0;i < sa.length;i++){
            Integer v = (Integer)hm.get(sa[i]);
            if (v == null){
                hm.put(sa[i], 1);
            }else{
                hm.put(sa[i], v.intValue()+1);
            }

        }

//        3、按顺序输出单词
        List<Map.Entry<String, Integer>> hmList =
                new ArrayList<Map.Entry<String, Integer>>(hm.entrySet());
        Collections.sort(hmList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int vdiff = o2.getValue() - o1.getValue();
                if(vdiff == 0){
                    return (o1.getKey()).compareTo(o2.getKey());
                }
                return vdiff;
            }
        });

        for(Map.Entry<String,Integer> mapping:hmList){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
    }
}