package org.example;

import java.util.Scanner;

public class PyramidTest {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of lines you would like to have : ");

        int numLines = input.nextInt() + 2;
        String spaces = "";
        String nums = "";
        String reverseNums = "";
        String wholeStr = "";

        for (int i = 0; i < numLines; i++){
            spaces += " ";
        }

        for(int i = 0; i < numLines; i++){
            if(i != numLines - 1){
                System.out.println(spaces + reverseNums + nums);
            } else {
                System.out.print(spaces + reverseNums + nums);
            }

            if(i != numLines - 1){
                wholeStr += spaces + reverseNums + nums + spaces + "\n";
            }

            nums = i + nums;
            reverseNums = reverse(nums).substring(0, nums.length() - 1);

            spaces = spaces.substring(0, spaces.length() - 1);
        }

        System.out.println(reverse(wholeStr.substring(2)));
    }

    public static String reverse(String nums) {
        char ch;
        String reverseNums = "";

        for(int j = 0; j < nums.length(); j++){
            ch = nums.charAt(j);
            reverseNums = ch + reverseNums;
        }
        return reverseNums;
    }
}
