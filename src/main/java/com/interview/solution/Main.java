package com.interview.solution;

import com.interview.list.LinkNode;
import com.interview.list.LinkedList;
import com.interview.list.Palindrome;

import java.util.Base64;

/**
 * @author : liushaogeng
 * create at:  2021/7/13
 * @description:
 */
public class Main {

    private static LinkedList linkedList;

    public static void main(String[] args) {
        String ss = "";
        try {
            ss = new String(Base64.getDecoder().decode("eyJsb2dpZCI6IiIsImVycl9ubyI6MCwiZXJyX21zZyI6IlNVQ0NFU1MiLCJxdWVyeXNpZ24iOiI0Mjg5ODgyOTkxLDIzNDIwMTM3NTEiLCJyZXQiOlt7InBsYXRlX251bWJlciI6IueypEI0Vkg2MyIsInBsYXRlX2NvbG9yIjoiYmx1ZSIsInNjb3JlcyI6WzAuOTk5OTI3NjQsMC45OTk5NjU5MDYxLDAuOTk5ODQxMDk0LDAuOTk5NjY4ODM2NiwwLjk5OTkxNDc2NTQsMC45OTk4MjQxMDY3LDAuOTk5NTE3Nzk4NCwwLjk5OTgwODYwOTVdLCJ2ZXJ0ZXhlc19sb2NhdGlvbiI6W3sieCI6Mzg4LCJ5IjoyOTF9LHsieCI6NDg2LCJ5IjozMDR9LHsieCI6NDg0LCJ5IjozMzR9LHsieCI6Mzg2LCJ5IjozMjF9XX1dfQ=="), "UTF-8");
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("ss = " + ss);

        Palindrome palindrome = new Palindrome();
        ss = "baidu";
//        System.out.println(" ss palindrome = " + palindrome.longestPalindrome(ss));
        ss = "baiab";
        System.out.println("ss palindrome = " + palindrome.longestPalindrome(ss));

        ss = "cbbd";
        System.out.println("ss palindrome = " + palindrome.longestPalindrome(ss));

        Solution s = new Solution();
        // System.out.printf("searchInsert = %d \n", s.searchInsert(new int[]{-1,0,3,5,9,12}, 9));
        // System.out.printf("searchInsert = %d \n", s.searchInsert(new int[]{1,3,5,6}, 2));
        // System.out.printf("searchInsert = %d \n", s.searchInsert(new int[]{1,3,5,6}, 0));
        // System.out.printf("searchInsert = %d \n", s.searchInsert(new int[]{1}, 1));
//        System.out.printf("searchInsert = %d \n", s.searchInsert(new int[]{1,3}, 3));

//        s.statisticsWordCount("face face is big big small big");

        linkedList = new LinkedList();

        LinkNode listNode = new LinkNode(1);
        LinkNode pHead = listNode;
        pHead.setNext(new LinkNode(1));
        pHead = pHead.getNext();
        pHead.setNext(new LinkNode(2));

        testDeleteDuplicates(listNode);

        listNode = new LinkNode(1);
        pHead = listNode;


        pHead.setNext(new LinkNode(2));
        pHead = pHead.getNext();

        pHead.setNext(new LinkNode(3));
        pHead = pHead.getNext();
        pHead.setNext(new LinkNode(4));

        pHead = pHead.getNext();
        pHead.setNext(new LinkNode(4));
        testDeleteDuplicates(listNode);

        listNode = new LinkNode(1);
        pHead = listNode;


        pHead.setNext(new LinkNode(2));
        pHead = pHead.getNext();

        pHead.setNext(new LinkNode(3));
        pHead = pHead.getNext();
        pHead.setNext(new LinkNode(4));

        testDeleteDuplicates(listNode);

    }

    private static void testDeleteDuplicates(LinkNode listNode){
        LinkNode pHead = listNode;

        System.out.println("before handle : ");
        while(pHead != null){
            System.out.print(pHead.getVal()+",");
            pHead = pHead.getNext();
        }
        System.out.println();

        LinkNode result = linkedList.deleteDuplicates(listNode);
        while(result != null){
            System.out.print(result.getVal());
            result = result.getNext();
        }
        System.out.println();
    }
}
