package com.interview.list;

import lombok.Data;

@Data
public class LinkNode {
    int val;

    LinkNode next;
    public LinkNode() {}
    public LinkNode(int val) { this.val = val; }
    public LinkNode(int val, LinkNode next) { this.val = val; this.next = next; }
}
