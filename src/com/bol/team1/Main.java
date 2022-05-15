package com.bol.team1;

import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRestart = true;

        while (isRestart) {
            isRestart = runProgram();
        }

        System.exit(0);
    }

    private static boolean runProgram() {
        System.out.println("""
                Welcome in Simulation Program!
                Menu:
                1. Random Data
                2. Simulasi Bubble Sort - Ascending
                3. Simulasi Selection Sort - Ascending
                4. Simulasi Bubble Sort - Descending
                5. Simulasi Selection Sort - Descending
                6. Keluar
                """);

        System.out.print("Masukkan Pilihan Anda: ");
        int selectedMenu = input.nextInt();
        System.out.println();

        switch (selectedMenu) {
            case 1:
                randomData();
                break;
            case 2:
                bubbleSort(true);
                break;
            case 3:
                selectionSort(true);
                break;
            case 4:
                bubbleSort(false);
                break;
            case 5:
                selectionSort(false);
                break;
            case 6:
                return exitProgram();
            default:
                System.out.println("\n---- Invalid menu! ----\n\n");
                break;
        }

        return true;
    }

    private static boolean exitProgram() {
        return false;
    }

    private static void selectionSort(boolean isAscending) {
        int[] list = getRandomNumber(500, 100);

        for (int i = 1; i < list.length; i++) {
            System.out.println("Pass " + i);
            int currentElement = list[i];
            int j;

            for (j = i - 1; j >= 0 && (isAscending ? (list[j] > currentElement) : (list[j] < currentElement)); j--) {
                printArray(list, false);
                list[j + 1] = list[j];
            }

            list[j + 1] = currentElement;

            System.out.println("\nResult of Pass " + i);
            printArray(list, true);
        }

        System.out.println("Selection Sort " + (isAscending ? "Ascending" : "Descending") + " :");
        printArray(list, true);
    }

    private static void bubbleSort(boolean isAscending) {
        int[] list = getRandomNumber(500, 100);
        boolean isNeedNextPass = true;

        for (int i = 1; i < list.length && isNeedNextPass; i++) {
            System.out.println("Pass " + i);
            isNeedNextPass = false;
            for (int j = 0; j < list.length - i; j++) {
                if (list[j] > list[j + 1]) {
                    printArray(list, false);
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;

                    isNeedNextPass = true;
                }
            }

            System.out.println("\nResult of Pass " + i);
            printArray(list, true);
        }

        System.out.println("Bubble Sort " + (isAscending ? "Ascending" : "Descending") + " :");
        printArray(list, true);
    }

    private static void randomData() {
        System.out.print("Batas Bawah = ");
        int bottomLimit = input.nextInt();

        System.out.print("Batas Atas = ");
        int topLimit = input.nextInt();

        System.out.println();

        if (bottomLimit > topLimit) {
            System.out.println("Invalid batas bawah!!");
            return;
        }

        System.out.println("Random Number:");

        int[] randomData = getRandomNumber(topLimit, bottomLimit);
        printArray(randomData, true);
    }

    private static int[] getRandomNumber(int topLimit, int bottomLimit) {
        int[] randomData = new int[5];

        for (int i = 0; i < randomData.length; i++) {
            randomData[i] = (int) (Math.random() * (topLimit - bottomLimit)) + bottomLimit;
        }

        return randomData;
    }

    private static void printArray(int[] array, boolean isAddNewLine) {
        for (int j : array) {
            System.out.print(j + "    ");
        }

        if (isAddNewLine)
            System.out.println("\n");
        else
            System.out.println();
    }
}
