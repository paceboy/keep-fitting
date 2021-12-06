package com.interview.list;

public class LinkedList {
    public LinkNode deleteDuplicates(LinkNode head) {
        if(head==null){return null;}
        if(head.next==null){return head;}

        LinkNode pre=new LinkNode(0);
        pre.next=head;

        LinkNode cur=pre;
        while(head!=null){
            if(head.next!=null && head.val==head.next.val){
                while(head.next!=null &&head.val==head.next.val){
                    head=head.next;
                }
                head=head.next;
                cur.next=head;
            }else{
                head=head.next;
                cur=cur.next;
            }
        }
        return pre.next;
    }

    public  LinkNode myDelete(LinkNode head){
        LinkNode pre =  new LinkNode(0);
        pre.next = head;

        LinkNode cur = pre;

        while(head != null){
            if(head.next != null && head.val == head.next.val){
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                head = head.next;
                cur.next = head;
            }else{
                head = head.next;
                cur = cur.next;
            }
        }
        return pre.next;
    }
}
