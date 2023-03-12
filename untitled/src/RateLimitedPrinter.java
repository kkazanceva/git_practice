public class RateLimitedPrinter {
    int interval;
    long prevTime = 0;

    public RateLimitedPrinter(int interval) throws IllegalArgumentException {
        if (interval < 0) {
            throw new IllegalArgumentException("Интервал не может быть отрицательным!");
        }
        this.interval = interval;
    }

    public void print(String message) {
        long currentTime = System.currentTimeMillis();
        long diffTime = currentTime - prevTime;
        if (prevTime == 0 || interval < diffTime) {
            System.out.println(message);
            prevTime = currentTime;
        }
    }

    public static void main(String[] args) {
        RateLimitedPrinter rateLimitedPrinter;
        try {
            rateLimitedPrinter = new RateLimitedPrinter(1000);
        } catch (Exception e) {
            System.out.println(e.toString());
            return;
        }

        for (int i = 0; i < 1_000_000_000; i++) {
            rateLimitedPrinter.print(String.valueOf(i));
        }
    }
}