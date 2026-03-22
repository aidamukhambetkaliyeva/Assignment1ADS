import java.util.Scanner;
public class FifthExersice {
    static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("5 exersice");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int result = fibonacci(num);
        System.out.println(result);
    }
}

