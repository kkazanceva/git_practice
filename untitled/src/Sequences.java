import java.util.Scanner;

public interface Sequences {
    void a(int n);
    void b(int n);
    void c(int n);
    void d(int n);
    void e(int n);
    void f(int n);
    void g(int n);
    void h(int n);
    void i(int n);
    void j(int n);
}

class SequencesImpl implements Sequences {
    public void a(int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res = 1;
            }
            System.out.println(res * 2);
            res = i + 2;
        }
    }
    public void b(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(2 * i + 1);
        }
    }
    public void c(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) * (i + 1));
        }
    }
    public void d(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) * (i + 1) * (i + 1));
        }
    }

    public void e(int n) {
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                System.out.println(1);
            } else {
                System.out.println(-1);
            }
        }
    }
    public void f(int n) {
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                System.out.println(i + 1);
            } else {
                System.out.println(-1 * (i + 1));
            }
        }
    }
    public void g(int n) {
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                System.out.println((i + 1) * (i + 1));
            } else {
                System.out.println(-1 * (i + 1) * (i + 1));
            }
        }
    }
    public void h(int n) {
        int k = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.println(k);
                k++;
            } else if (i % 2 != 0) {
                System.out.println(0);
            } else {
                System.out.println(k);
                k++;
            }
        }
    }
    public void i(int n) {
        long res = 1;
        for (int i = 0; i < n; i++) {
            res += res * i;
            System.out.println(res);
        }
    }
    public void j(int n) {
        int res = 0;
        int res1 = 0;
        int res2 = 1;
        for (int i = 0; i < n; i++) {
            res = res1 + res2;
            res2 = res1;
            res1 = res;
            System.out.println(res);
        }
    }
}

class SequencesTest {
    public static void main(String[] args) {
        Sequences s = new SequencesImpl();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название последовательности: ");
        String str = sc.nextLine();
        System.out.println("Введите количество значений: ");
        int num;
        try {
            num = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.toString());
            sc.close();
            return;
        }
        if (num < 1) {
            System.out.println("Неверное значение!");
            sc.close();
            return;
        }
        switch (str) {
            case ("a") -> s.a(num);
            case ("b") -> s.b(num);
            case ("c") -> s.c(num);
            case ("d") -> s.d(num);
            case ("e") -> s.e(num);
            case ("f") -> s.f(num);
            case ("g") -> s.g(num);
            case ("h") -> s.h(num);
            case ("i") -> s.i(num);
            case ("j") -> s.j(num);
            default -> System.out.println("Неверное название!");
        }
        sc.close();
    }
}