package org.pranav;

import java.util.Arrays;

public class DelectElement {

	public static int[] delectElement(int arr[],int pos) {
//		boolean ans = false;
		int newarr[] = new int[arr.length-1];
		int index = 0;
		for(int i = 0; i<arr.length; i++) {
			if(i == pos ) {
				continue;
			}
			else {
				newarr[index] = arr[i];
				index++;
			}
		}
		return newarr;
		
	}
	
	public static int[] delectElement2(int arr[],int pos) {
		boolean ans = false;
		int i = 0;
		for(; i<arr.length-1; i++) {
			if(i == pos ) {
				ans  = true;
				arr[i] = arr[i+1];
//				continue;
			}
			if(ans) {
				arr[i] = arr[i+1];
			}
			
		}
		arr[i] = 0;
		return arr;
	}
	
	public static int[] delectElement3(int arr[],int pos) {

		int i = pos;
		for(; i<arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[i] = 0;
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {1,2,3,4,5,6,7,8,9};
		System.out.println("Original Array :"+Arrays.toString(arr));
		
//		int newarr[] = delectElement(arr, 5);
//		System.out.println("After delete : "+Arrays.toString(newarr));
//		
//		int newarr2[] = delectElement2(arr, 6);
//		System.out.println("Second Method: "+Arrays.toString(newarr2));
		
		int newarr3[] = delectElement3(arr, 2);
		System.out.println("Third Method: "+Arrays.toString(newarr3));

	}

}
