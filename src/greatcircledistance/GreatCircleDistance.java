package greatcircledistance;

public class GreatCircleDistance {

    public static void main(String[] args) {
        String[][] map = new String[5][5];
        int driverX = (int) Math.ceil(Math.random() * 4);
        int driverY = (int) Math.ceil(Math.random() * 4);
        int passengerX = (int) Math.ceil(Math.random() * 4);
        int passengerY = (int) Math.ceil(Math.random() * 4);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = " X ";
            }
        }

        map[driverX][driverY] = " D ";
        map[passengerX][passengerY] = " P ";

        showMap(map);
        
        System.out.println("");
        System.out.println("==========");
        System.out.println("");
        
        findWay(map, driverX, driverY, passengerX, passengerY);

        showMap(map);

    }
    
    static void findWays(String[][] map, int driverX, int driverY, int passengerX, int passengerY) {
        if (driverX < passengerX & driverY < passengerY) {
            while (driverX < passengerX) {
                map[driverX + 1][driverY] = " O ";
                driverX++;
            }

            while (driverY < passengerY) {
                map[driverX][driverY] = " O ";
                driverY++;
            }
        } else if (passengerX < driverX & passengerY < driverY) {
            while (passengerX < driverX) {
                map[driverX - 1][driverY] = " O ";
                driverX--;
            }

            while (passengerY < driverY) {
                map[driverX][driverY] = " O ";
                driverY--;
            }
        } else if (driverX > passengerX & driverY < passengerY) {
            while (driverX > passengerX) {
                map[driverX - 1][driverY] = " O ";
                driverX--;
            }

            while (driverY < passengerY) {
                map[driverX][driverY] = " O ";
                driverY++;
            }
        } else if (passengerX > driverX & passengerY < driverY) {
            while (passengerX > driverX) {
                map[driverX+1][driverY] = " O ";
                driverX++;
            }
            
            while (passengerY < driverY) {
                map[driverX][driverY] = " O ";
                driverY--;
            }
        } else if (driverX < passengerX | driverX > passengerX) {
            while (driverX < passengerX-1 & !map[driverX][driverY].equalsIgnoreCase("P")) {
                driverX++;
                map[driverX][driverY] = " O ";
            }
            
            while (driverX > passengerX+1 & !map[driverX][driverY].equalsIgnoreCase("P")) {
                driverX--;
                map[driverX][driverY] = " O ";
            }
        } else {
            while (driverY < passengerY-1 & !map[driverX][driverY].equalsIgnoreCase("P")) {
                driverY++;
                map[driverX][driverY] = " O ";
            }
            
            while (driverY > passengerY+1 & !map[driverX][driverY].equalsIgnoreCase("P")) {
                driverY--;
                map[driverX][driverY] = " O ";
            }
        }
    }
    
    static void findWay(String[][] map, int driverX, int driverY, int passengerX, int passengerY) {
        if (driverX < passengerX & driverY < passengerY) {
            while (driverX < passengerX) {
                map[driverX + 1][driverY] = " O ";
                driverX++;
            }

            while (driverY < passengerY) {
                map[driverX][driverY] = " O ";
                driverY++;
            }
        } else if (passengerX < driverX & passengerY < driverY) {
            while (passengerX < driverX) {
                map[driverX - 1][driverY] = " O ";
                driverX--;
            }

            while (passengerY < driverY) {
                map[driverX][driverY] = " O ";
                driverY--;
            }
        } else if (driverX > passengerX & driverY < passengerY) {
            while (driverX > passengerX) {
                map[driverX - 1][driverY] = " O ";
                driverX--;
            }

            while (driverY < passengerY) {
                map[driverX][driverY] = " O ";
                driverY++;
            }
        } else if (passengerX > driverX & passengerY < driverY) {
            while (passengerX > driverX) {
                map[driverX+1][driverY] = " O ";
                driverX++;
            }
            
            while (passengerY < driverY) {
                map[driverX][driverY] = " O ";
                driverY--;
            }
        } else if (driverX < passengerX | driverX > passengerX) {
            while (driverX < passengerX-1 & !map[driverX][driverY].equalsIgnoreCase("P")) {
                driverX++;
                map[driverX][driverY] = " O ";
            }
            
            while (driverX > passengerX+1 & !map[driverX][driverY].equalsIgnoreCase("P")) {
                driverX--;
                map[driverX][driverY] = " O ";
            }
        } else {
            while (driverY < passengerY-1 & !map[driverX][driverY].equalsIgnoreCase("P")) {
                driverY++;
                map[driverX][driverY] = " O ";
            }
            
            while (driverY > passengerY+1 & !map[driverX][driverY].equalsIgnoreCase("P")) {
                driverY--;
                map[driverX][driverY] = " O ";
            }
        }
    }

    static void showMap(String[][] map) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }
}
