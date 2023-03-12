public interface StatsAccumulator {
    void add(int value);
    int getMin();
    int getMax();
    int getCount();
    double getAvg();
}

class StatsAccumulatorImpl implements StatsAccumulator {
    int value;
    int minVal;
    int maxVal;
    int count = 0;
    int sum = 0;
    double avg;

    public void add(int value) {
        this.value = value;
        if (count == 0 || this.value < minVal) {
            minVal = this.value;
        }
        if (count == 0 || this.value > maxVal) {
            maxVal = this.value;
        }
        sum += this.value;
        count++;
        avg = (double) sum / count;
    }

    public int getMin() {
        return minVal;
    }
    public int getMax() {
        return maxVal;
    }
    public int getCount() {
        return count;
    }
    public double getAvg() {
        return avg;
    }
}

class StatsAccumulatorTest {
    public static void main(String[] args) {
        StatsAccumulator s = new StatsAccumulatorImpl();
        s.add(38);
        s.add(-5);
        System.out.println("Минимальное значение: " + s.getMin());
        s.add(5);
        s.add(15);
        s.add(1);
        System.out.println("Максимальное значение: " + s.getMax());
        System.out.println("Среднее значение: " + s.getAvg());
        s.add(43);
        System.out.println("Количество значений: " + s.getCount());
    }
}