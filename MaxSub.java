import java.util.Scanner;

public class MaxSub {

    private int nCases=0;//int for the number of cases
    private int theSize;//int for the array size
    private int theArray[] = new int[100000];//array of ints to be entered
    private long peak;
    private long sum;
    private long posSum;
    private boolean neg = true;//use this if all numbers are negative; in this case, the less negative is the answer
    private Scanner input = new Scanner(System.in);

    private void inputNCases(){

        nCases = input.nextInt();//enter the array size
    }

    private void inputArray(){

            theSize = input.nextInt();//enter the array size
            for(int j=0; j<theSize; j++){
                theArray[j] = input.nextInt();
            }
    }

    private void maxSum(){

        peak=theArray[0];
        for(int i=0;i<theSize;i++){

            if(sum>=0){
                sum+=theArray[i];
                neg=false;}
            if(sum>peak){peak=sum;}
            if(sum<0&&!neg){sum=0;}//if the sum is negative this will reset the sum
        }
        System.out.print(peak+" ");
    }

    private void positiveSum(){

        if(peak<0){
            posSum=peak;
        }else {
            for (int i = 0; i < theSize; i++) {
                if (theArray[i] > 0) {
                    posSum += theArray[i];
                }
            }
        }
        System.out.println(posSum);
    }

    public static void main(String[] args) {

        MaxSub mySolution = new MaxSub();
        mySolution.inputNCases();

        for(int i=0;i<mySolution.nCases;i++){
            mySolution.inputArray();
            mySolution.maxSum();
            mySolution.positiveSum();
            mySolution.peak = 0;
            mySolution.sum = 0;
            mySolution.posSum = 0;
        }
    }
}