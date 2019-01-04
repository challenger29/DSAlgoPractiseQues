package interviewbit.programming.arrays;

import java.util.ArrayList;
import java.util.Scanner;
 
public class MinStepsInInfiniteGrid {

    public static void main(String args[]){

        System.out.println("Enter the No of Points: ");

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> X = new ArrayList<Integer>();
        ArrayList<Integer> Y = new ArrayList<Integer>();

        int size = sc.nextInt();

        System.out.println("Enter the Points: ");

        for(int i=0 ; i<size; i++){
            System.out.print("X: ");
            X.add(sc.nextInt());
            System.out.print("Y: " );
            Y.add(sc.nextInt());
            System.out.println();
        }

        MinStepsInInfiniteGrid obj = new MinStepsInInfiniteGrid();
        size = obj.coverPoints(X,Y);
        System.out.println("The minimum required steps are: "+ size);
    }

    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {

            int Steps = 0;
            for(int i = 1; i < X.size(); i++){
                Steps += Math.max( Math.abs(X.get(i) - X.get(i-1)), Math.abs(Y.get(i) - Y.get(i-1)) );
            }
            return Steps;
    }
}