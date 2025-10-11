
public class Main {
    public static double calculatePhone(double hour, double distance, boolean intraNet) {
        double res = 0.0;
        double discountHour = 0.0;
        double discountDistance = 0.0;
        double price = 890;

        if (distance < 0) {
            return -1;
        }
        if (hour <= 0 || hour > 24) return -1;
        if (hour >= 18 || hour < 8) discountHour = 0.5;
        if (distance > 60) discountDistance = 0.15;
        if (!intraNet) price = 990;

        res = distance * price * (1 - discountHour) * (1 - discountDistance);

        return res;

    }

    public static void solve(Object[][] testCases){
        System.out.println("Amount of testcase: "+testCases.length);
        for (int i = 0; i < testCases.length; i++) {
            String result = "PASS";
            double hour = (double) testCases[i][0];
            double distance = (double) testCases[i][1];
            boolean intraNet = (boolean) testCases[i][2];
            double expected = (double) testCases[i][3];

            double actualOput = calculatePhone(hour, distance, intraNet);
            if (actualOput != expected) {
                result = "FAILED";
            }
            System.out.printf("Case %d: hour=%.2f, distance=%.2f, intraNet=%s -> actualOutput=%.3f (expected=%.3f), result= %s%n",
                    i + 1, hour, distance, intraNet, actualOput, expected, result);
        }
    }

    public static void main(String[] args) {
        solve(Tescase.All_Uses);
    }
}