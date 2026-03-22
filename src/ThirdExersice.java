import java.util.Scanner;
public class ThirdExersice {
    static boolean check(int n, int i) {
        if (i == 1) return false;
        if (n % i == 0) return true;
        return check(n, i - 1);
    }
    public static void main(String[] args){
        System.out.println("3 exersice");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(check(num, num - 1)){
            System.out.println(num + " Composite");
        } else{
            System.out.println(num + " Prime");
        }
    }
}

