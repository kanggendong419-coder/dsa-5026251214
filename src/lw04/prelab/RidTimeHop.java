import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RidTimeHop {
    static void insertionSortDesc(int[] arr, int passes) {
        for (int i = 1; i <= passes && i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new File("branches.txt"))) {
            int n = sc.nextInt();
            int[] branches = new int[n];
            for (int i = 0; i < n; i++) {
                branches[i] = sc.nextInt();
            }

            int m = sc.nextInt();
            int[] targets = new int[m];
            for (int i = 0; i < m; i++) {
                targets[i] = sc.nextInt();
            }

            insertionSortDesc(branches, 3);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i > 0) sb.append(" ");
                sb.append(branches[i]);
            }
            System.out.println(sb);

            for (int t : targets) {
                int idx = linearSearch(branches, t);
                if (idx != -1) {
                    System.out.println(t + ": FOUND at index " + idx);
                } else {
                    System.out.println(t + ": NOT FOUND");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File branches.txt tidak ditemukan.");
        }
    }
}