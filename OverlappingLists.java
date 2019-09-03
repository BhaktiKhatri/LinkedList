package LinkedList;

import LinkedList.LinkedList.ListNode;

public class OverlappingLists {

	public static ListNode overlappingNoCycleLists(ListNode l1, ListNode l2) {
		System.out.println("l1: "+l1.data+" l2: "+l2.data);
		
		int len1 = length(l1);
		int len2 = length(l2);
		
		System.out.println("len1: "+len1+" len2: "+len2);
		
		//Advances the longer list to get equal length lists
		if(len1 > len2) {
			System.out.println("len1 - len2: "+(len1 - len2));
			l1 = advanceListByK(len1 - len2, l1);
		}
		else {
			System.out.println("len2 - len1: "+(len2 - len1));
			l2 = advanceListByK(len2 - len1, l2);
		}
		
		while(l1 != null && l2 != null && l1.data != l2.data) {
			System.out.println("l1: "+l1.data+" l1.next: "+l1.next.data+" l2: "+l2.data+" l2.next.data: "+l2.next.data);
			l1 = l1.next;
			l2 = l2.next;
			System.out.println("l1: "+l1.data+" l2: "+l2.data);
		}
		
		System.out.println("l1: "+l1.data+" l2: "+l2.data);
		return l1;	// null ptr implies there is no overlap between l1 and l2
	}
	
	public static ListNode advanceListByK(int k, ListNode l) {
		System.out.println("k: "+k+" l: "+l.data);
		while(k-- > 0) {
			l = l.next;
		System.out.println("k: "+k+" l: "+l.data);
		}
		return l;
	} 
	
	public static int length(ListNode l) {
		System.out.println(" l: "+l.data);
		int len = 0;
		while(l != null) {
			++len;
			l = l.next;
			if(l != null)
				System.out.println("len: "+len+" l: "+l.data);
		}
		return len;
	}
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		
		list1.head = new ListNode(3);
		ListNode second = new ListNode(6);
		ListNode third = new ListNode(9);
		ListNode fourth = new ListNode(15);
		ListNode fifth = new ListNode(30);

		list1.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		
		//System.out.println("list1: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data);
		
		LinkedList list2 = new LinkedList();
		list2.head = new ListNode(10);
		ListNode second2 = new ListNode(15);
		ListNode third2 = new ListNode(30);

		list2.head.next = second2;
		second2.next = third2;
		
		//System.out.println("list2: "+list2.head.data+" -> "+list2.head.next.data);
		
		LinkedList result = new LinkedList();
		result.head = overlappingNoCycleLists(list1.head, list2.head);
		System.out.println("result: "+result.head.data);
		
		//System.out.println("result: "+result.head.data+" -> "+result.head.next.data+" -> "+result.head.next.next.data+" -> "+result.head.next.next.next.data+" -> "+result.head.next.next.next.next.data);

	}

}
