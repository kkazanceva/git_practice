public class ComplexNumbers {
    double r;
    double i;

    public ComplexNumbers() {
    }

    ComplexNumbers(double r) {
        this.r = r;
        this.i = 0;
    }

    ComplexNumbers(double r, double i) {
        this.r = r;
        this.i = i;
    }

    public String toString() {
        if (i > 0) {
            return r + "+" + i + "i";
        } else {
            return r + "-" + i + "i";
        }
    }

    public ComplexNumbers sum(ComplexNumbers n) {
        ComplexNumbers sum = new ComplexNumbers();
        sum.r = r + n.r;
        sum.i = i + n.i;
        return sum;
    }

    public ComplexNumbers sub(ComplexNumbers n) {
        ComplexNumbers sub = new ComplexNumbers();
        sub.r = r - n.r;
        sub.i = i - n.i;
        return sub;
    }

    public ComplexNumbers mult(ComplexNumbers n) {
        ComplexNumbers mult = new ComplexNumbers();
        mult.r = r * n.r - i * n.i;
        mult.i = i * n.r + r * n.i;
        return mult;
    }

    public ComplexNumbers div(ComplexNumbers n) {
        ComplexNumbers div = new ComplexNumbers();
        double fact, denom;
        if (Math.abs(n.r) >= Math.abs(n.i)) {
            fact = n.i / n.r;
            denom = n.r + fact * n.i;
            div.r = (r + fact * i) / denom;
            div.i = (i - fact * r) / denom;
        } else {
            fact = n.r / n.i;
            denom = n.i + fact * n.r;
            div.r = (fact * r + i) / denom;
            div.i = (fact * i - r) / denom;
        }
        return div;
    }

    public double abs() {
        double abs;
        if (Math.abs(r) == 0)
            abs = Math.abs(i);
        else if (Math.abs(i) == 0)
            abs = Math.abs(r);
        else if (Math.abs(r) > Math.abs(i)) {
            abs = Math.abs(r) * Math.sqrt(1.0 + (Math.abs(i) / Math.abs(r)) * (Math.abs(i) / Math.abs(r)));
        } else {
            abs = Math.abs(i) * Math.sqrt(1.0 + (Math.abs(r) / Math.abs(i)) * (Math.abs(r) / Math.abs(i)));
        }
        return abs;
    }

    public static void main(String[] args) {
        ComplexNumbers num1 = new ComplexNumbers(9.0, 5.0);
        ComplexNumbers num2 = new ComplexNumbers(8.0);
        ComplexNumbers res;
        System.out.println("Первое комплексное число: num1 = " + num1.toString());
        System.out.println("Второе комплексное число: num2 = " + num2.toString());
        res = num1.mult(num2);
        System.out.println("Результат умножения комплексных чисел: num1*num2 = " + res.toString());
        res = num1.div(num2);
        System.out.println("Результат деления комплексных чисел: num1/num2 = " + res.toString());
        res = num1.sum(num2);
        System.out.println("Результат сложения комплексных чисел: num1+num2 = " + res.toString());
        res = num1.sub(num2);
        System.out.println("Результат вычитания комплексных чисел: num1-num2 = " + res.toString());
        System.out.println("Значение по модулю первого комплексного числа: |num1| = " + num1.abs());
        System.out.println("Значение по модулю второго комплексного числа: |num2| = " + num2.abs());
    }
}