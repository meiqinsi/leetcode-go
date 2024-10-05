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

}
