import java.util.Scanner;
import java.lang.Math;
import java.text.NumberFormat;

public class Mortgage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        double p = scanner.nextDouble();

        System.out.print("Annual Interest Rate: ");
        double r = scanner.nextDouble() / 100 / 12;

        System.out.print("Period (Years): ");
        int n = scanner.nextInt() * 12;

        System.out.print("Mortgage: ");

        double temp = Math.pow((1 + r), n);
        double m = p * ((r * temp) / (temp - 1));

        NumberFormat currency = NumberFormat.getCurrencyInstance();

        System.out.println(currency.format(m));
    }
}
