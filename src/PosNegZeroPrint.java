import java.util.Scanner;

public class PosNegZeroPrint {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.println(sign(num));
    }

    public static int sign(int x) {
        return Integer.compare(x, 0);
    }
}
