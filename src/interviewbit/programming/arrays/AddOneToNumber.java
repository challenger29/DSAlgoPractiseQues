package interviewbit.programming.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
    	
    	ArrayList<Integer> result = new ArrayList<Integer>(A);
    	System.out.println(result);
    	int size = A.size();
    	int carry = 1;
    	for (int i = A.size() - 1 ; i >=0 ; i--){
    		int sum = A.get(i) +carry;
    		carry = sum / 10;
    		System.out.println(sum);
    		System.out.println(carry);
    		int digit = sum % 10;
    		System.out.println(digit);

    		result.set(i, digit);
    		
    	}
    	if (carry != 0) {
    		result.add(0, 1);
    	}
        int index = 0;
        while (index < result.size() && result.get(index) == 0) {
            result.remove(index);
        }
        
    	return result;
    }

    public static void main(String args[]){

        System.out.println("Enter length of number ");

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> X = new ArrayList<Integer>();

        int size = sc.nextInt();

        System.out.println("Enter the Points: ");

        for(int i=0 ; i<size; i++){
            System.out.print("X: ");
            X.add(sc.nextInt());
            System.out.println();
        }

        AddOneToNumber obj = new AddOneToNumber();
        ArrayList<Integer> result = obj.plusOne(X);
        System.out.println("Number is "+ result);
    }
}
