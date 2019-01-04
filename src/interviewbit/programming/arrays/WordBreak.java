package interviewbit.programming.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    public static int wordBreak(String A, ArrayList<String> B) {
        Set<String> dict = new HashSet<>();
        B.forEach(str -> dict.add(str.toLowerCase()));
        System.out.println(dict.toString());
        boolean[][] dp = new boolean[A.length()][A.length()];
        for(int len = 1; len <= A.length() ;len++){
            for(int i = 0 ; i <= A.length() - len ;i++){
                //get starting and ending point of subbarray
                int j = i + len -1;
                StringBuilder str = new StringBuilder(A.substring(i, j +1));
                System.out.println(i + " "+ j + " " +str.toString().toLowerCase());
                if(dict.contains(str.toString().toLowerCase())){
                	dp[i][j] = true;
                	continue;
                }
                else{
                	for(int k = i + 1 ; k <= j ;k++){
                		//form two substrings
                		StringBuilder substr1 = new StringBuilder(A.substring(i, k));
                		StringBuilder substr2 = new StringBuilder(A.substring(k , j+1));
                		System.out.println(substr1 +" " + substr2);
                		if(dp[i][k - 1] && dp[k][j]){
                			dp[i][j] = true;
                			System.out.println("Found separation at" + k);
                			break;
                		}
                	}
                }

            }
        }
        for(boolean[] in : dp){
        	System.out.println(Arrays.toString(in));
        }
        int n = A.length();
        if(dp[0][n-1])
        	return 1;
        else return 0;
    }
    public static void main(String[] args) {
//		String A = "helloWorld";
    	String A ="Iamace";
		ArrayList<String> B = new ArrayList<>();
//		B.add("hello");
		B.add("world");
    	B.add("ace");
    	B.add("am");
    	B.add("i");
		System.out.println(wordBreak(A, B));
	}
}
