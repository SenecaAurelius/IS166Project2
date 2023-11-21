package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiamondPrinting extends PyramidTest  {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;

        while(fis == null){
            System.out.println("What is the location of the file?");
            Scanner input = new Scanner(System.in);
            String fileLocation = input.next();
            File file = new File(fileLocation);

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
        int rows = Integer.valueOf(charArray.get(0)) * 2 + 1;
        int columns = rows;
        int centerDiamondNumber = Integer.valueOf(charArray.get(0));

        char[][][] wholeDiamond = new char[numOfDiamonds][rows][columns];
        for(int i = 0; i < numOfDiamonds - 1; i++){
            List<char[]> rowList = new ArrayList<>();
            wholeDiamond[0][i] = generateColumn(i, centerDiamondNumber);
            for(int j = 0; j < wholeDiamond[0][i].length; j++){
                System.out.print(wholeDiamond[0][i][j]);
            }
            System.out.println();
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
