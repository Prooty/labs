//Класс для работы с простыми числами
public class Primes {

    //Точка входа в программу
    public static void main(String[] args) {

        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                System.out.println(i + " is prime");
            }
        }
    }

    //Метод, определяющий простое число или нет
    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
