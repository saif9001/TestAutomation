import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class ArrayProgramming {


    public void findDuplicatesInArray(int[] sampleArray) {
        for (int i = 0; i < sampleArray.length; i++) {

            for (int j = i + 1; j < sampleArray.length; j++) {

                if (sampleArray[i] == sampleArray[j]) {
                    System.out.println("Duplicate Array Elements are " + sampleArray[i]);

                }

            }
        }

    }

    public void findSecondLargestInteger(int[] sampleArray) {

        int largest = sampleArray[0];
        int secondLargest = 0;
        boolean secondlargestexist = false;
        for (int i = 1; i < sampleArray.length; i++) {


            if (sampleArray[i] > largest) {
                secondLargest = largest;
                largest = sampleArray[i];
                secondlargestexist = true;

            }
            if (sampleArray[i] > secondLargest && sampleArray[i] < largest) {
                secondLargest = sampleArray[i];
                secondlargestexist = true;
            }


        }
        if (secondlargestexist == true) {
            System.out.println("Second largest element " + secondLargest);
        } else {
            System.out.println("All elements are equals");
        }

    }

    public void findThePairs(int[] sampleArray, int sum) {

        for (int i = 0; i < sampleArray.length; i++) {
            for (int j = i + 1; j < sampleArray.length; j++) {
                if (sampleArray[i] + sampleArray[j] == sum) {

                    System.out.println("Sample sum pairs are" + sampleArray[i] + "," + sampleArray[j]);
                }

            }
        }
    }

    public void findContiniousPairs(int[] sampleArray, int sum) {
        for (int i = 0; i < sampleArray.length; i++) {
//          

            int tempSum = sampleArray[i];
//            int tempContnousArray[]=new int[sampleArray.length];
            ArrayList<Integer> tempContnousArrayList = new ArrayList<Integer>();
//            tempContnousArray[0]=sampleArray[i];
            tempContnousArrayList.add(sampleArray[i]);
            int k = 1;
            for (int j = i + 1; j < sampleArray.length; j++) {


                tempSum = tempSum + sampleArray[j];
//               tempContnousArray[k]=sampleArray[j];
                tempContnousArrayList.add(sampleArray[j]);
                k++;
                if (tempSum == sum || tempSum > sum) {
                    break;
                }

            }
            if (tempSum == sum) {
                for (int l = 0; l < tempContnousArrayList.size(); l++) {
                    System.out.println(tempContnousArrayList.get(l));

                }
            }
        }
    }

    public void seperateZeroandNonZeros(int[] sampleArray) {

        int currentSwapIndex;
        for (int i = 0; i < sampleArray.length - 1; i++) {

            if (sampleArray[i + 1] != 0) {
                currentSwapIndex = i + 1;
                while (sampleArray[currentSwapIndex - 1] == 0) {
                    sampleArray[currentSwapIndex - 1] = sampleArray[currentSwapIndex];
                    sampleArray[currentSwapIndex] = 0;
                    currentSwapIndex--;

                }
            }
        }
        for (int i : sampleArray) {
            System.out.print(i + ",");
        }
    }

    public void reverseArray(int[] sampleArray) {
        int[] reversedArray = new int[sampleArray.length];
        int j = 0;

        for (int i = sampleArray.length - 1; i >= 0; i--) {
            reversedArray[j] = sampleArray[i];
            j++;
        }
        for (int b : reversedArray) {
            System.out.print(b + ",");
        }

    }
    
    public void findKthSmallest(int[] sampleArray, int kthValues){
        
        
        int currentSamllest=sampleArray[0];
        int KthSmallest=currentSamllest;
        int j=1;
        while(j<=kthValues ){
            
            for(int i=0;i<sampleArray.length-1;i++){
                if(j==1) {

                    if (sampleArray[i +1] < currentSamllest ) {
                        currentSamllest = sampleArray[i + 1];
                        KthSmallest=currentSamllest;
                    }
                }
                else {
                    if(sampleArray[i+1]<sampleArray[i] && sampleArray[i+1]>KthSmallest){
                        KthSmallest=sampleArray[i+1];
                    }
                    
                }
            }
            j++;
            
           
        }
        System.out.println(KthSmallest);
    }
    
    public void secondLargest(int[] sampleArray) {

        int largest = sampleArray[0];
        int secondLargest =largest;

        for (int i = 1; i <sampleArray.length; i++) {

            if (sampleArray[i] > largest ) {
                secondLargest = largest;
                largest=sampleArray[i];
            }
            if(sampleArray[i]>secondLargest &&sampleArray[i]<largest){
                secondLargest=sampleArray[i];
            }
        }
        System.out.println(secondLargest);
    }
            


    public static void main(String[] args) {

        //int[] testArray = {12, 0, 7, 0, 8, 0, 3};
        int[] testArray={7,2, 4, 20, 26, 6};
        ArrayProgramming arrayProgramming = new ArrayProgramming();
        arrayProgramming.secondLargest(testArray);
    }

}
