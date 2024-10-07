package algorithm;

import util.ListNode;
import util.Util;

//https://leetcode.com/problems/add-two-numbers/description/
/***
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * 
 */
public class Porblem0002_AddTwoNumbers {

//	public class ListNode {
//		int val;
//		ListNode next;
//
//		ListNode() {
//		}
//
//		ListNode(int val) {
//			this.val = val;
//		}
//
//		ListNode(int val, ListNode next) {
//			this.val = val;
//			this.next = next;
//		}
//	}
//
	/**
	 * 工具类，返回链表长度
	 * 
	 * @param head
	 * @return
	 */
	public static int listLength(ListNode head) {
		int len = 0;
		if (head == null) {
			return len;
		}
		while (head.next != null) {
			len++;
			head = head.next;
		}
		return len;
	}

	public static void main(String[] args) {
		ListNode num1 = Util.getLinkedList(new int[] { 5 });
		ListNode num2 = Util.getLinkedList(new int[] { 5 });
		ListNode sumListNode = addTwoNumbers(num1, num2);

		Util.printLinkedList(sumListNode);
	}

	/**
	 * 准备两个 长链表L 和短链表S 三种情况： 1L S 都有值：li + si + carry(进位） ，如果%10
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// 先区分长短链表
		int len1 = listLength(l1);
		int len2 = listLength(l2);
		ListNode L = len1 > len2 ? l1 : l2;
		ListNode S = len1 > len2 ? l2 : l1;


		int carry = 0;
		int currentSum = 0;
		ListNode currentL = L;
		ListNode currentS = S;
		ListNode lastNode = L;

		// 第一步： L S 都有值
		while (currentS != null) {// 如果短链表 位上有值
			currentSum = currentS.val + currentL.val + carry;
//sum 直接放到长链表
			currentL.val = currentSum % 10;
			carry = currentSum / 10;
			lastNode = currentL;
			currentL = currentL.next;
			currentS = currentS.next;
		}
		// 第二步： L还有值，S没值
		while (currentL != null) {// 如果短链表 位上有值
			currentSum = currentL.val + carry;
			// sum 直接放到长链表
			currentL.val = currentSum % 10;
			carry = currentSum / 10;
			lastNode = currentL;
			currentL = currentL.next;
		}
		// 第三部： L没值，S没值，看进位是否有值
		if (carry != 0) {
			lastNode.next = new ListNode(1);
		}

		return L;
	}

}
