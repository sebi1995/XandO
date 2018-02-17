import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("What a program...");
        System.out.print("Please enter a number: ");
        int num = new Scanner(System.in).nextInt();
        for (int i = 0; i < num; i++) {
            System.out.println("What a program...");
        }
    }
}
