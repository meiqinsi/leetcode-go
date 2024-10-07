package algorithm;

import util.ListNode;
import util.Util;

//https://leetcode.com/problems/merge-two-sorted-lists/description/
/***
 * You are given the heads of two sorted linked lists list1 and list2.
 * 
 * Merge the two lists into one sorted list. The list should be made by splicing
 * together the nodes of the first two lists.
 * 
 * Return the head of the merged linked list.
 */
public class Probelm0021_MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode list1 = Util.getLinkedList(new int[] {1,2,4});
		ListNode list2 = Util.getLinkedList(new int[] { 1, 3, 4 });
		Util.printLinkedList(mergeListNode(list1, list2));
	}

	public static ListNode mergeListNode(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}

		// 老师的
		if (list1 == null || list2 == null) {
			return list1 == null ? list2 : list1;
		}
		// 两个链表，最终的总链表肯定是哪个小头，所以
		ListNode resultHead = list1.val <= list2.val ? list1 : list2;
//		ListNode curr1 = list1
		ListNode curr1 = resultHead.next;// 小头看下一个节点。*** 这是关键，决定了走哪条路
		ListNode curr2 = resultHead == list1 ? list2 : list1;
		ListNode curr = resultHead;// curr1
		while (curr1 != null && curr2 != null) {
			if (curr1.val < curr2.val) {
				curr.next = curr1;
				curr1 = curr1.next;
			} else {
				curr.next = curr2;
				curr2 = curr2.next;
			}
			curr = curr.next;
		}

		// 最后会有个==null 因为只有一个指针在动，那么就把不是空的那个放到current后边
		curr.next = curr1 != null ? curr1 : curr2;

		return resultHead;
	}

}
