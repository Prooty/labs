//Класс для работы с палиндромами
public class Palindrome {
    //Точка входа в программу
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            String reversed = reverseString(s);

            if (s.equalsIgnoreCase(reversed)) {
                System.out.println(s + " is palindrome");
            } else {
                System.out.println(s + " is not palindrome");
            }
        }
    }

    //Метод разворачивающий строку задом наперед
    public static String reverseString(String s) {
        String result = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }

        return result;
    }
}
