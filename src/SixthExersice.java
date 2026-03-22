import java.util.Scanner;
public class SixthExersice {
    static int power(int a, int n){
        if(n == 0)return 1;
        return a * power(a, n-1);
    }
    public static void main(String[] args) {
        System.out.println("6 exersice");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();
        int result = power(a,n);
        System.out.println(result);
    }
}


