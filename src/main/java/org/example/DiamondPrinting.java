package org.example;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DiamondPrinting extends PyramidTest  {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;

        File file = null;

        while(fis == null){
            System.out.println("What is the location of the file?");
            Scanner input = new Scanner(System.in);
            String fileLocation = input.next();
            file = new File(fileLocation);

            try {
                fis = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                System.out.println("The file does not exist. Please try again.");
            }
        }

        int r = 0;
        List<Character> charArray = new ArrayList<Character>();

        while(r != -1) {
            r = fis.read();
            char c = (char)(r);
            if(Character.isDigit(c)){
                charArray.add(c);
            }
        }

        int numOfDiamonds = charArray.size();
        //output_MM-DD-YYYY_HH_MM_SS.txt
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy_hh_mm_ss");
        String fileName = "output_" + formatter.format(today) + ".txt";

        try {
            FileWriter myWriter = new FileWriter(file.getParent() + "/" + fileName);
            for(int i = 0; i < numOfDiamonds; i++){
                List<char[]> rowList = new ArrayList<>();
                int centerDiamondNumber = Integer.valueOf(charArray.get(0)) - 48;

                for(int j = 0; j <= centerDiamondNumber; j++){
                    rowList.add(generateColumn(j, centerDiamondNumber));
                }

            for(int j = 0; j < rowList.size(); j++){
                for(int k = 0; k < rowList.get(j).length; k++){
                    System.out.println(rowList.get(j)[k]);
                }
                System.out.println();
            }

                //prints bottom half
                for(int j = rowList.size() - 2; j >= 0; j--){
                    rowList.add(rowList.get(j));
                }
                //output_MM-DD-YYYY_HH_MM_SS.txt
                for(char[] aRow : rowList){
                    for(int b = 0; b < aRow.length; b++){
                        myWriter.write(aRow[b]);
                    }
                    myWriter.write("\n");
                }
            }
            myWriter.close();
        } catch(Exception e) {
            System.out.println("An error occurred. Please try again.");
            e.printStackTrace();
        }
    }

    private static char[] generateColumn(int centerRowNumber, int centerDiamondNumber) {
        int numOfSpaces = centerDiamondNumber - centerRowNumber;
        String column = "";
        char[] row = new char[centerDiamondNumber * 2 + 1];
        int counter = 0;
        //Number of spaces loop
        for (int i = 0; i < numOfSpaces; i++){
            row[counter] = ' ';
            counter++;
        }

        //Ascending numbers loop
        for(int i = 0; i < centerRowNumber; i++){
            row[counter] = (char)(i + 48);
            counter++;
        }

        //Descending numbers loop
        for(int i = centerRowNumber; i >= 0; i--){
            row[counter] = (char)(i + 48);
            counter++;
        }

        return row;
    }
}
