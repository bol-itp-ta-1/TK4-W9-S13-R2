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
    }

    private static void bubbleSort(boolean isAscending) {

    }

    private static void randomData() {
    }
}
