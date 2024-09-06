import java.util.Scanner;

public class abb {
    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else if (bill == 20) {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of customers: ");
        int n = scanner.nextInt();

        int[] bills = new int[n];
        System.out.println("Enter the bills each customer pays:");
        for (int i = 0; i < n; i++) {
            bills[i] = scanner.nextInt();
        }

        boolean result = lemonadeChange(bills);
        System.out.println("Can provide change to every customer: " + result);
    }
}