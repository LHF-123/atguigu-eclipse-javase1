package com.atguigu.exercise;

public class TwoArrayExer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[][] {{3,8,2},{2,7},{9,0,1,6}};
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}
		}
		System.out.println(sum);
	}

}
