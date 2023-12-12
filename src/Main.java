import java.util.Random;

public class Main {

    public static boolean isPrimeFermat(int n, int k) {
        if (n <= 1) {
            return false;
        } else if (n <= 3) {
            return true;
        } else {
            Random random = new Random();

            for (int i = 0; i < k; i++) {
                int a = random.nextInt(n - 3) + 2;
                if (powerModulo(a, n - 1, n) != 1) {
                    return false;
                }
            }

            return true;
        }
    }

    public static int generatePrime(int A) {
        Random random = new Random();

        while (true) {
            int p = random.nextInt(A - 1) + 2;
            if (isPrimeFermat(p, 5)) {
                return p;
            }
        }
    }

    private static int powerModulo(int base, int exponent, int modulus) {
        int result = 1;
        base = base % modulus;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % modulus;
            }

            exponent = exponent >> 1;
            base = (base * base) % modulus;
        }

        return result;
    }

    public static void main(String[] args) {
        // Перевірка простоти числа 17 за теоремою Ферма
        int numberToCheck = 17;
        boolean resultPrimeCheck = isPrimeFermat(numberToCheck, 5);
        System.out.println("Число " + numberToCheck + (resultPrimeCheck ? " просте" : " не є простим"));

        // Генерація простого числа менше або рівного 50
        int upperLimitA = 50;
        int resultGeneratedPrime = generatePrime(upperLimitA);
        System.out.println("Згенероване просте число менше або рівне " + upperLimitA + ": " + resultGeneratedPrime);

        int numberA = 20;
        int numberB = 34;
        int resultGCD = EuclideanAlgorithm.findGCD(numberA, numberB);
        System.out.println("НСД(" + numberA + ", " + numberB + ") = " + resultGCD);
    }
}
