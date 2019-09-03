package LinkedList;

import LinkedList.LinkedList.ListNode;

public class OverlappingOfListsWithCycles {

	public static ListNode overlappingLists(ListNode l1, ListNode l2) {
		//Store the start of the cycle if any
		ListNode root1 = TestForCyclicity.hasCycle1(l1);
		ListNode root2 = TestForCyclicity.hasCycle1(l2);
		
		if(root1 == null && root2 == null) {
			//Both lists dont have cycles
			return OverlappingLists.overlappingNoCycleLists(l1, l2);
		}
		else if((root1 != null && root2 == null) || (root1 == null && root2 != null)) {
			//One lists has cycle and the other list has no cycle
			return null;
		}
		
		//Both lists have cycles
		ListNode temp = root2;
		
		do {
			temp = temp.next;
		} while(temp != root1 && temp != root2);
		
		//l1 and l2 do not end in the same cycle
		if(temp != root1) {
			return null;	//cycles are disjoint
		}
		
		//l1 and l2 end in the same cycle, locate the overlapping node if they first overlap before cycle starts
		int stem1Length = distance(l1, root1);
		int stem2LEngth = distance(l2, root2);
		int count = Math.abs(stem1Length - stem2LEngth);
		
		if(stem1Length > stem2LEngth) {
			l1 = OverlappingLists.advanceListByK(stem1Length - stem2LEngth, l1);
		}
		else {
			l2 = OverlappingLists.advanceListByK(stem2LEngth - stem1Length, l2);
		}
		
		while(l1 != l2 && l1 != root1 && l2 != root2) {
			l1 = l1.next;
			l2 = l2.next;
		}
		
		//if l1 == l2 before reaching root1, it means the overlap first occurs before the cyle starts; otherwise the first overlapping node is not unique, so we can return any node on the cycle
		return l1 == l2 ? l1 : root1;
	}
	
	public static int distance(ListNode a, ListNode b) {
		int dis = 0;
		while(a != b) {
			a = a.next;
			++dis;
		}
		return dis;
	}
	
	public static void main(String[] args) {

	}

}
