package greatcircledistance;

import java.util.Scanner;

public class GreatCircleDistance {

    static int step = 0;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[][] map = new String[5][5];
        int driverX = (int) Math.ceil(Math.random() * 4);
        int driverY = (int) Math.ceil(Math.random() * 4);
        int passengerX = (int) Math.ceil(Math.random() * 4);
        int passengerY = (int) Math.ceil(Math.random() * 4);
        int balance = 200000;
        boolean repeat = false;

        do {
            showMenu(input);
            switch (answer) {
                case 1:
                    initialize(map, driverX, driverY, passengerX, passengerY);
                    showMap(map);
                    System.out.println("We have found your driver!");
                    findWay(map, driverX, driverY, passengerX, passengerY);
                    balance -= getPrice();
                    showTripInfo(getPrice());
                    System.out.println("Your driver on the way..");
                    System.out.println("Please be patient..");
                    showMap(map);
                    System.out.println("Your driver has arrived!");
                    System.out.println("Thanks for using Go-Van");
                    getBalance(balance);
                    repeat = false;
                    break;
                case 2:
                    getBalance(balance);
                    repeat = true;
                default:
                    break;
            }
        } while (repeat);

    }

    static void initialize(String[][] map, int driverX, int driverY, int passengerX, int passengerY) {
        //Create the map
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = " # ";
            }
        }

        //Assign driver and passenger to given position
        map[driverX][driverY] = " D ";
        map[passengerX][passengerY] = " P ";
    }

    static void findWay(String[][] map, int driverX, int driverY, int passengerX, int passengerY) {
        if (driverX < passengerX & driverY < passengerY) {
            while (driverX < passengerX) {
                map[driverX + 1][driverY] = " O ";
                driverX++;
                step++;
            }

            while (driverY < passengerY) {
                map[driverX][driverY] = " O ";
                driverY++;
                step++;
            }
        } else if (passengerX < driverX & passengerY < driverY) {
            while (passengerX < driverX) {
                map[driverX - 1][driverY] = " O ";
                driverX--;
                step++;
            }

            while (passengerY < driverY) {
                map[driverX][driverY] = " O ";
                driverY--;
                step++;
            }
        } else if (driverX > passengerX & driverY < passengerY) {
            while (driverX > passengerX) {
                map[driverX - 1][driverY] = " O ";
                driverX--;
                step++;
            }

            while (driverY < passengerY) {
                map[driverX][driverY] = " O ";
                driverY++;
                step++;
            }
        } else if (passengerX > driverX & passengerY < driverY) {
            while (passengerX > driverX) {
                map[driverX + 1][driverY] = " O ";
                driverX++;
                step++;
            }

            while (passengerY < driverY) {
                map[driverX][driverY] = " O ";
                driverY--;
                step++;
            }
        } else if (driverX < passengerX | driverX > passengerX) {
            while (driverX < passengerX - 1 & !map[driverX][driverY].equalsIgnoreCase("P")) {
                driverX++;
                map[driverX][driverY] = " O ";
                step++;
            }

            while (driverX > passengerX + 1 & !map[driverX][driverY].equalsIgnoreCase("P")) {
                driverX--;
                map[driverX][driverY] = " O ";
                step++;
            }
        } else {
            while (driverY < passengerY - 1 & !map[driverX][driverY].equalsIgnoreCase("P")) {
                driverY++;
                map[driverX][driverY] = " O ";
                step++;
            }

            while (driverY > passengerY + 1 & !map[driverX][driverY].equalsIgnoreCase("P")) {
                driverY--;
                map[driverX][driverY] = " O ";
                step++;
            }
        }
    }

    static void getBalance(int balance) {
        System.out.println("Your Balance : Rp." + balance);
    }

    static int getPrice() {
        return (step == 0) ? 5000 : step * 10000;
    }

    static void showHeader() {
        System.out.println("========================================");
        System.out.println("#####  #####       #     #  #####  #####");
        System.out.println("#      #   #  ###   #   #   #   #  #   #");
        System.out.println("#  ##  #   #  ###    # #    #####  #   #");
        System.out.println("#####  #####          #     #   #  #   #");
        System.out.println("========================================");
    }

    static void showMenu(Scanner input) {
        do {
            showHeader();
            showOption();

            answer = input.nextInt();
        } while (answer < 1 & answer > 2);
    }

    static void showOption() {
        System.out.println("Menu :");
        System.out.println("1.Order Go-Bike");
        System.out.println("2.Show Balance");
        System.out.print("Choose : ");
    }

    static void showMap(String[][] map) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }

    static void showTripInfo(int price) {
        System.out.println("===================");
        System.out.println("Name    : Uzumaki Naruto");
        System.out.println("Vehicle : Nissan GTR-R35");
        System.out.println("License : B 2412 RR");
        System.out.println("Price   : Rp." + price);
        System.out.println("===================");
    }
}
