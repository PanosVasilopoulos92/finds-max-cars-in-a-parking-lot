import java.util.Arrays;
import java.util.Comparator;

/**
 *  Το πρόγραμμα διαβάζει να εκτυπώνει τον μέγιστο αριθμό αυτοκινήτων που
 *  είναι σταθμευμένα το ίδιο χρονικό διάστημα.
 */
public class Exercise2 {

    static int[][] arr = new int[][]{{1010, 1049}, {1020, 1035}, {1100, 1150}, {1045, 1120},
                                         {1050, 1100}, {1030, 1050}, {1130, 1244}, {1120, 1259}};

    public static void main(String[] args) {
        int[][] transformed = {};

        transformed = arrTransformed(arr);
        sortByTime(transformed);

        for (int[] row : transformed) {
            System.out.print(row[0] + " ");
            System.out.println(row[1]);
        }

        System.out.println("Max cars that were simultaneously at the parking lot: " + getMaxCarsInParkingLot(transformed));
    }

    public static int[][] arrTransformed(int[][] arr) {
        int[][] transformed = new int[arr.length * 2][2];

        for (int i = 0; i < arr.length; i++) {
            transformed[i*2][0] = arr[i][0];
            transformed[i*2][1] = 1;
            transformed[i*2+1][0] = arr[i][1];
            transformed[i*2+1][1] = 0;
        }
        return transformed;
    }

    public static void sortByTime(int[][] arr) {
        Arrays.sort(arr, Comparator.comparing((int[] a) -> a[0]));
    }

    public static int getMaxCarsInParkingLot(int[][] arr) {
        int currentCarsInParking = 0;
        int maxCarsInParking = 0;

        for (int i =0; i < arr.length; i++) {
            if (arr[i][1] == 1) {
                currentCarsInParking++;
            } else {
                currentCarsInParking--;
            }
            maxCarsInParking = Math.max(currentCarsInParking, maxCarsInParking);
        }
        return maxCarsInParking;
    }

}
