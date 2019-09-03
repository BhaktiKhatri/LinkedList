package LinkedList;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import LinkedList.LinkedList.ListNode;

/*
 * https://leetcode.com/problems/merge-k-sorted-lists/discuss/10528/A-java-solution-based-on-Priority-Queue
 * @wksora
 */

public class MergeKSortedLists {

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode curr = dummyHead;
		
		System.out.println("l1: "+l1.data+" l2: "+l2.data);
		
		while(l1 != null && l2 != null) {
			if(l1.data < l2.data) {
				curr.next = l1;
				l1 = l1.next; 
			}
			else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		
		curr.next = l1 != null ? l1 : l2;
		return dummyHead.next;
	}
	
	public static ListNode mergeKLists(List<ListNode> lists) {
		System.out.println("lists.size(): "+lists.size());
		
		String[] arr = new String[10];
		
		if (lists.size()==0) 
        	return null;
        
		else if (lists.size()==1) 
        	return lists.get(0);
        
		else if (lists.size()==2) 
        	return mergeTwoLists(lists.get(0), lists.get(1));
        
        System.out.println("lists.size(): "+lists.size()+" lists.size()/2: "+lists.size()/2);
        
        ListNode left = mergeKLists(lists.subList(0, lists.size()/2));
        System.out.println("left: "+left.data);
        
        ListNode right = mergeKLists(lists.subList(lists.size()/2, lists.size()));
        System.out.println("left: "+left.data+" right: "+right.data);
        
        ListNode result = mergeTwoLists(left, right);
        System.out.println("result: "+result);
        return result;
    }
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		
		list1.head = new ListNode(2);
		ListNode second = new ListNode(5);
		ListNode third = new ListNode(7);

		list1.head.next = second;
		second.next = third;
		
		System.out.println("list1: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data);
		
		LinkedList list2 = new LinkedList();
		list2.head = new ListNode(3);
		ListNode second2 = new ListNode(11);
		list2.head.next = second2;
		
		System.out.println("list2: "+list2.head.data+" -> "+list2.head.next.data);
		
		LinkedList list3 = new LinkedList();
		list3.head = new ListNode(1);
		ListNode second3 = new ListNode(4);
		ListNode third3 = new ListNode(6);
		list3.head.next = second3;
		second3.next = third3;
		
		System.out.println("list3: "+list3.head.data+" -> "+list3.head.next.data+" -> "+list3.head.next.next.data);
		
		List<ListNode> list = new ArrayList<ListNode>();
		list.add(list1.head);
		list.add(list2.head);
		list.add(list3.head);
		
		LinkedList result = new LinkedList();
		result.head = mergeKLists(list);
		
		System.out.println("result: "+result.head.data+" -> "+result.head.next.data+" -> "+result.head.next.next.data+" -> "+result.head.next.next.next.data+" -> "+result.head.next.next.next.next.data+" -> "+result.head.next.next.next.next.next.data+" -> "+result.head.next.next.next.next.next.next.data+" -> "+result.head.next.next.next.next.next.next.next.data);
	}

}
