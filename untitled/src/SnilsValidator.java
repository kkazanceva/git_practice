import java.util.Scanner;

public interface SnilsValidator {
    boolean validate(String snils);
}

class SnilsValidatorImpl implements SnilsValidator {

    public boolean validate(String snils) throws IllegalArgumentException {
        if (snils.length() != 11) {
            throw new IllegalArgumentException("Неверный номер СНИЛС!");
        }
        int mainNum, sum = 0;
        boolean res = false;
        int ctrlNum = Integer.parseInt(snils.substring(snils.length() - 2));

        for (int i = 0; i < snils.length() - 2; i++) {
            mainNum = Character.digit(snils.charAt(i), 10);
            sum += mainNum * (9 - i);
        }
        if (sum < 100 && sum == ctrlNum) {
            res = true;
        } else if (sum == 100 && ctrlNum == 0) {
            res = true;
        } else {
            if (sum % 101 == 100 && ctrlNum == 0) {
                res = true;
            } else if (sum % 101 == ctrlNum) {
                res = true;
            }
        }
        return res;
    }
}

class SnilsValidatorTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер СНИЛС: ");
        String snils = sc.nextLine();
        try {
            System.out.println(new SnilsValidatorImpl().validate(snils));
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.toString());
            sc.close();
            return;
        }
        sc.close();
    }
}