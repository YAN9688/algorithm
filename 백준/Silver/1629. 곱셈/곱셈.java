import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();

        System.out.println(pow(A, B, C));
    }

    public static long pow(long A, long B, long C) {
        if (B == 0) return 1;
        long half = pow(A, B / 2, C);
        long result = (half * half) % C;
        if (B % 2 == 1) result = (result * A) % C;
        return result;
    }
}
