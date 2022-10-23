package Baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_12015_binarySearch7 { 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        ArrayList<Integer> rs = new ArrayList<>(); 
        rs.add(arr[0]); //ArrayList를 empty로 만들지 않는다.
        
        for (int i =1 ; i < arr.length; i++) { 
        	int lower = lowerBound(rs, 0, rs.size(), arr[i]); 
        	//삽입할 위치가 맨 뒤일 때 
        	if(rs.size() <= lower) rs.add(arr[i]); 
        	//삽입할 위치에 이미 숫자가 존재하면 바꾼다. 
        	else rs.set(lower, arr[i]);  
        }
	
		System.out.println(rs.size());

	}
	
	// Basic한 Lower Bound 코드 
	public static int lowerBound(ArrayList<Integer> arr, int left, int right, int key) {
		int mid = 0; 
		while (left < right) { 
			mid = (left + right) / 2; 
			if (arr.get(mid) < key) left = mid + 1; 
			else right = mid; 
		} 
		
		return right; 
	}

}
