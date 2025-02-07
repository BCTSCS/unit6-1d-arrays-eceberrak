import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DataAnalyzer{
    
    //binary search
    public static int searchList(int target, int[] numbers){
        int minIndex = 0;
        int maxIndex = numbers.length - 1;
        
        while (minIndex <= maxIndex) {
            int middleIndex = (minIndex + maxIndex) / 2;
            
            if (numbers[middleIndex] == target) {
                return middleIndex;
            } else if (target > numbers[middleIndex]) {
                minIndex = middleIndex + 1;
            } else {
                maxIndex = middleIndex - 1;
            }
        }
        
        return -1;
    }
    
    //linear search
    public static int searchList(int[] numbers, int target){
        int index=0;
        while(index<=numbers.length-1){
            if(numbers[index]==target){
                return index;
            }
            index++;
        }
        return -1;
    }

    // Reverse list
    public static int[] reverseList(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;
            left++;
            right--;
        }
        return numbers;
    }
    
    
    public static void main(String[] args) {
        // int[] arr = {10, 20, 30, 40, 50};

        // System.out.println(searchList(arr, 50));
        // System.out.println(searchList(50,arr));
        
        // int[] reversedArr = reverseList(arr);
        // System.out.print("Reversed List: ");
        // for (int num : reversedArr) {
        //     System.out.print(num + " ");
        // }

        int[] numbers = new int[100];
        int index=0;
        try {
            File f = new File("numbers.txt");
            try (Scanner input = new Scanner(f)) {
                while(input.hasNextInt()&&index<numbers.length){
                    numbers[index++]=input.nextInt();
                }
            }
            
        } catch (IOException e) {
            System.out.println("file not found");
        }
        int target = 9; 
        int linearResult = searchList(numbers, target);
        System.out.println("Linear Search (" + target + "): " + ("Found at index " + linearResult));
    
        int binaryResult = searchList(target,numbers);
        System.out.println("Binary Search (" + target + "): " + ("Found at index " + binaryResult));
    
        numbers = reverseList(numbers);
        System.out.print("Reversed List: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}