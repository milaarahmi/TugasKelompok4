package com.company;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class Main {
    static final Scanner in = new Scanner ( System.in );

    public static void main(String[] args) {
        boolean run = true;
        List<Integer> list = null;

        while (run) {
            int menu = menuProgram ();

            switch (menu) {
                case 1:
                    list = randomData();
                    String output = list.toString().replaceAll("(^\\[|\\]$)", "");
                    System.out.print(output +"\n");
                    break;
                case 2:
                    bubbleAscending (list);
                    break;
                case 3 :
                    selectionAscending (list);
                    break;
                case 4 :
                    bubbleDescending (list);
                    break;
                case 5 :
                    selectionDescending (list);
                    break;
                case 6 :
                    run = false;
                    break;
            }
        }

        System.out.println ( "\n-------------------------Terima Kasih-------------------------" );
    }

    private static int menuProgram() {
        System.out.println ( "\n----------------------------------------" );
        System.out.println("Selamat Datang di Program Simulasi\n" +
                "Menu\n" +
                "1. Random Data\n" +
                "2. Simulasi Bubble Sort - Ascending\n" +
                "3. Simulasi Selection Sort - Ascending\n" +
                "4. Simulasi Bubble Sort - Descending\n" +
                "5. Simulasi Selection Sort - Descending\n" +
                "6. Keluar");

        int dataMenu = 0;

        while (dataMenu < 1 || dataMenu > 6) {
            try{
                System.out.print("Inputkan menu: ");
                dataMenu = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Mohon maaf menu yang anda inputkan salah");
            }
            in.nextLine();
        }

        return dataMenu;
    }

    private static List<Integer> randomData() {
        int batasBawah = 0, batasAtas = 0;

        System.out.print("Batas Bawah \t: ");
        batasBawah = in.nextInt();

        System.out.print("Batas Atas  \t: ");
        batasAtas = in.nextInt();

        List<Integer> randomInteger = new ArrayList<> ();

        if (batasBawah<batasAtas){
            randomInteger = new Random().ints(5, batasBawah, batasAtas).boxed().collect(toList());
        } else {
            System.out.print("Batas bawah harus lebih kecil \t: ");
        }

        return randomInteger;

    }

    private static void bubbleAscending(List<Integer> list) {
        for (int x = 1; x < list.size(); x++) {
            System.out.println("\n");
            System.out.print("Pass " + x);
            System.out.println();
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + "   ");
            }
            for (int y = 0; y < list.size() - x; y++) {
                System.out.println();
                if (list.get(y) > list.get(y+1)) {
                    int temp;
                    temp = list.get(y);
                    list.set(y,list.get(y+1));
                    list.set(y+1,temp);
                }
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i) + "   ");
                }
            }
            System.out.println("\n Result of Pass " + x );
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + "   ");
            }
        }
    }

    private static void selectionAscending(List<Integer> num) {
        int size = num.size();
        if (size < 1) {
            System.out.println("Belum memasukkan data");
            return;
        }


        int i, j, first, temp;

        int step = 0;

        for ( i = size - 1; i > 0; i -- )
        {
            System.out.println("Pass " + step);
            first = 0;
            for(j = 1; j <= i; j ++)
            {
                if( num.get(j) > num.get(first))
                    first = j;

                System.out.println(num);
            }
            temp = num.get(first);
            num.set(first, num.get(i));
            num.set(i, temp);

            System.out.println("");

            step += 1;
        }

        System.out.println("Hasil: ");
        System.out.println(num);
    }

    private static void bubbleDescending(List<Integer> list) {
        for (int x = 1; x < list.size(); x++) {
            System.out.println("\n");
            System.out.print("Pass " + x);
            System.out.println();
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + "   ");
            }
            for (int y = 0; y < list.size() - x; y++) {
                System.out.println();
                if (list.get(y) < list.get(y+1)) {
                    int temp;
                    temp = list.get(y);
                    list.set(y,list.get(y+1));
                    list.set(y+1,temp);
                }
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i) + "   ");
                }
            }
            System.out.println("\n Result of Pass " + x );
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + "   ");
            }
        }
    }

    private static void selectionDescending(List<Integer> num) {

        int size = num.size();
        if (size < 1) {
            System.out.println("Belum memasukkan data");
            return;
        }


        int i, j, first, temp;

        int step = 0;

        for ( i = size - 1; i > 0; i -- )
        {
            System.out.println("Pass " + step);
            first = 0;
            for(j = 1; j <= i; j ++)
            {
                if( num.get(j) < num.get(first))
                    first = j;

                System.out.println(num);
            }
            temp = num.get(first);
            num.set(first, num.get(i));
            num.set(i, temp);

            System.out.println("");

            step += 1;
        }

        System.out.println("Hasil: ");
        System.out.println(num);
    }

}
