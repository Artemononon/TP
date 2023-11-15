package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"2.2", "101101", "9", "5"},
                {"1", "3", "2", "2"},
                {"9", "100100.8", "232232", "2"},
                {"2", "25", "255", "7"}

        };
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[j].length != 4 || arr.length != 4) {
                    throw new MyArraySizeException();
                }
            }
        }
        double sum = 0;


        boolean hasNumberFormatException = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    double value = Double.parseDouble(arr[i][j]);
                    sum += value;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, arr[i][j]);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    double value = Double.parseDouble(arr[i][j]);
                    if (!isHamming(value) && isHappy(value)){
                        throw new MyHappingException(i, j, arr[i][j]);

                    }
                    if (!isHamming(value)) {
                        throw new MyHammingException(i, j, arr[i][j]);

                    }
                    if (isHappy(value)) {
                        throw new MyHappyException(i, j, arr[i][j]);
                    }

                } catch (MyHappyException | MyHammingException | MyHappingException e) {
                    e.printStackTrace();

                }
            }
        }
        if (!hasNumberFormatException) {
            System.out.println("Сумма чисел в массиве: " + sum);
        }
    }


    public static boolean isHamming(double number) {
        if(number < 1){
            return false;
        }
        if (number % 2 ==0 || number % 3 == 0 || number % 5 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isHappy(double number) {
        String str =  String.valueOf(number);
        char lastChar = str.charAt(str.length() - 1);
        if(lastChar == '0') {
            int value = (int) number;
            String numberString = String.valueOf(value);
            int length = numberString.length();
            if (length != 6) {
                return false; // Число не шестизначное
            }
            int leftSum = 0;
            int rightSum = 0;
            for (int i = 0; i < length / 2; i++) {
                leftSum += Character.getNumericValue(numberString.charAt(i));
                rightSum += Character.getNumericValue(numberString.charAt(length - i - 1));
            }
            return leftSum == rightSum;
        }
        return false;
    }
}