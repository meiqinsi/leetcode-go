package util;

public class Util {

	public static void printArray(int[] arr) {
		if (arr == null || arr.length < 1) {
			return;
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void printLinkedList(ListNode head) {
		ListNode curr = head;
		// 下边继续用这个n1;
		while (curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
		System.out.println();
	}


	public static ListNode getLinkedList(int[] nums) {
		return getLinkedList(nums, true);
	}

	public static ListNode getLinkedList(int[] nums, boolean asc) {
		if (nums == null || nums.length < 1) {
			return null;
		}
		ListNode headListNode = new ListNode(nums[0]);
		if (nums.length < 2) {
			return headListNode;
		}
		ListNode currListNode = headListNode;
		for (int i = 1; i < nums.length; i++) {
			currListNode.next = new ListNode(nums[i]);
			currListNode = currListNode.next;
		}
		return asc ? headListNode : currListNode;
	}

}
