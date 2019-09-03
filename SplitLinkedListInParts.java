package LinkedList;

import java.util.Arrays;

import LinkedList.LinkedList.ListNode;

/*
 * 725. Split Linked List in Parts
 * https://leetcode.com/problems/split-linked-list-in-parts/description/
 * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.
 * The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.
 * Return a List of ListNode's representing the linked list parts that are formed.
 * Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 * Example 1: Input: root = [1, 2, 3], k = 5; Output: [[1],[2],[3],[],[]]
 * Explanation: The input and each element of the output are ListNodes, not arrays.
 * For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but it's string representation as a ListNode is [].
 * Example 2: Input: root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3; Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * Explanation: The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
 * Explanation and Code from: https://leetcode.com/problems/split-linked-list-in-parts/solution/ 
 * https://leetcode.com/problems/split-linked-list-in-parts/discuss/109296/JavaC++-Clean-Code
 * Time Complexity: O(N+k), where N is the number of nodes in the given list. If k is large, it could still require creating many new empty lists.
 * Space Complexity: O(max(N, k)), the space used in writing the answer.
 * Amazon
 * Medium
 */

public class SplitLinkedListInParts {
	
	/*
	 * If there are N nodes in the linked list root, then there are N/k items in each part, plus the first N % k parts have an extra item.
	 * We can count N with a simple loop.
	 * Now for each part, we have calculated how many nodes that part will have: width + (i < remainder ? 1 : 0).
	 * We create a new list and write the part to that list.
	 */
	public static ListNode[] splitListToParts(ListNode root, int k) {
		ListNode[] ans = new ListNode[k];
		ListNode cur = root;
        int N = 0;
        
        System.out.println("root: "+root.data+" k: "+k);
        
        while(cur != null) {
            cur = cur.next;
            N++;
        }
        
        System.out.println("N: "+N+" k: "+k+" N / k: "+(N / k)+" N % k: "+(N % k));

        int width = N / k;
        int rem = N % k;
        cur = root;
        
        System.out.println("width: "+width+" rem: "+rem+" cur: "+cur.data);
        
        for(int i=0; i<k; i++) {
            ListNode head = cur;
            System.out.println("i: "+i+" head: "+head.data);
            
            for(int j=0; j < width + (i < rem ? 1 : 0) - 1; j++) {
                System.out.println("i: "+i+" j: "+j);
            	
            	if(cur != null) {
            		System.out.println("cur: "+cur.data);
                	cur = cur.next;
                }
            }
            
            if(cur != null) {
            	System.out.println("cur: "+cur.data);
                ListNode prev = cur;
                cur = cur.next;
                prev.next = null;
            }
            System.out.println("i: "+i+" ans[i]: "+ans[i]+" head: "+head.data);
            ans[i] = head;
            System.out.println("i: "+i+" ans[i]: "+ans[i].data);
        }
        System.out.println("ans: "+ans);
        
        return ans;
    }
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		
		list1.head = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode forth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);
		ListNode seventh = new ListNode(7);
		ListNode eighth = new ListNode(8);
		ListNode ninth = new ListNode(9);
		ListNode tenth = new ListNode(10);
		
		list1.head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		fifth.next = sixth;
		sixth.next = seventh;
		seventh.next = eighth;
		eighth.next = ninth;
		ninth.next = tenth;
		
		int k = 3;
		
		System.out.println("list: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data+" -> "+list1.head.next.next.next.data+" -> "+list1.head.next.next.next.next.data);
		
		ListNode[] res = new ListNode[k];
		LinkedList result = new LinkedList();
		
		res = splitListToParts(list1.head, k);
		System.out.println(Arrays.toString(res));
		
		//System.out.println("result: "+result.head.data+" -> "+result.head.next.data+" -> "+result.head.next.next.data);	//+" -> "+result.head.next.next.next.data+" -> "+result.head.next.next.next.next.data

	}

}
