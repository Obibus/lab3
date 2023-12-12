import java.util.Scanner;

public class EulerPhiCalculator {

    public static int calculateEulerPhi(int n) {
        int result = n;

        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                while (n % i == 0)
                    n /= i;
                result -= result / i;
            }
        }

        if (n > 1)
            result -= result / n;

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть значення n: ");
        int n = scanner.nextInt();

        int eulerPhi = calculateEulerPhi(n);

        System.out.println("Функція Ейлера для " + n + ": " + eulerPhi);
    }

}
