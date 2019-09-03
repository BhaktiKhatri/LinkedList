package LinkedList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import LinkedList.LinkedList.ListNode;

/*
 * 817. Linked List Components
 * We are given head, the head node of a linked list containing unique integer values.
 * We are also given the list G, a subset of the values in the linked list.
 * Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.
 * Example 1: Input: head: 0->1->2->3; G = [0, 1, 3]; Output: 2; Explanation: 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 * Example 2: Input: head: 0->1->2->3->4; G = [0, 3, 1, 4]; Output: 2; Explanation: 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 * Note:If N is the length of the linked list given by head, 1 <= N <= 10000.
 * The value of each node in the linked list will be in the range [0, N - 1].
 * 1 <= G.length <= 10000.
 * G is a subset of all values in the linked list.
 * Explanation and Code from: Approach #1: Grouping https://leetcode.com/problems/linked-list-components/solution/
 * Time Complexity: O(N+G.length), where N is the length of the linked list with root node head.
 * Space Complexity: O(G.length), to store Gset.
 */

public class LinkedListComponents {

	/*
	 * Intuition:
	 * Instead of thinking about connected components in G, think about them in the linked list. Connected components in G must occur consecutively
	 * in the linked list.
	 * Algorithm:
	 * Scanning through the list, if node.val is in G and node.next.val isn't (including if node.next is null), then this must be the end of a connected
	 * component.
	 * For example, if the list is 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7, and G = [0, 2, 3, 5, 7], then when scanning through the list, we fulfill the 
	 * above condition at 0, 3, 5, 7, for a total answer of 4.
	 */
	public static int numComponents(ListNode head, int[] G) {
        Set<Integer> Gset = new HashSet<Integer>();
        
        System.out.println("head: "+head.data+" G: "+Arrays.toString(G));
        
        for(int x: G) { 
        	System.out.println("x: "+x);
        	Gset.add(x);
        }
        System.out.println("Gset: "+Gset);

        ListNode cur = head;
        int ans = 0;

        System.out.println("cur: "+cur.data);
        
        while(cur != null) {
        	System.out.println("cur: "+cur.data+" Gset: "+Gset+" ans: "+ans);
        	
            if(Gset.contains(cur.data) && (cur.next == null || !Gset.contains(cur.next.data))) {
                ans++;
            }
            cur = cur.next;
        }

        return ans;
    }
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		
		list1.head = new ListNode(0);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(2);
		ListNode forth = new ListNode(3);
		ListNode fifth = new ListNode(4);
	
		list1.head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		
		int[] G = {0, 3, 1, 4};
		System.out.println("list: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data+" -> "+list1.head.next.next.next.data+" -> "+list1.head.next.next.next.next.data);
		
		System.out.println(numComponents(list1.head, G));
	}
}