
public class Main {
    public static double calculatePhone(double hour, double distance, boolean intraNet) {
        double res = 0.0;
        double discountHour = 0.0;
        double discountDistance = 0.0;
        double price = 890;

        if (distance < 0) {
            return -1;
        }
        if (hour < 0 || hour > 24) return -1;
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
        Object[][] testCasesDT = {
                {-1.0,0.0,true,-1.0},
                {0.0, -1.0, true, -1.0},
                {0.0, 30.0, true, 13350.0},
                {10.0, 30.0, true, 26700.0},
                {19.0, 30.0, true, 13350.0},
                {0.0, 100.0, true, 37825.0},
                {10.0, 100.0, true, 75650.0},
                {19.0, 100.0, true, 37825.0},
                {0.0, 30.0, false, 14850.0},
                {10.0, 30.0, false, 29700.0},
                {19.0, 30.0, false, 14850.0},
                {0.0, 100.0, false, 42075.0},
                {10.0, 100.0, false, 84150.0},
                {19.0, 100.0, false, 42075.0}
        };
        Object[][] testCasesBAV = {
                {-0.01, 30.0, false, -1.0},
                {-0.01, 30.0, true, -1.0},
                {0.0, 30.0, false, 14850.0},
                {0.0, 30.0, true, 13350.0},
                {0.01, 30.0, false, 14850.0},
                {0.01, 30.0, true, 13350.0},
                {7.99, 30.0, false, 14850.0},
                {7.99, 30.0, true, 13350.0},
                {8.0, 30.0, false, 29700.0},
                {8.0, 30.0, true, 26700.0},
                {8.01, 30.0, false, 29700.0},
                {8.01, 30.0, true, 26700.0},
                {17.99, 30.0, false, 29700.0},
                {17.99, 30.0, true, 26700.0},
                {18.0, 30.0, false, 14850.0},
                {18.0, 30.0, true, 13350.0},
                {18.01, 30.0, false, 14850.0},
                {18.01, 30.0, true, 13350.0},
                {23.99, 30.0, false, 14850.0},
                {23.99, 30.0, true, 13350.0},
                {24.0, 30.0, false, 14850.0},
                {24.0, 30.0, true, 13350.0},
                {24.01, 30.0, false, -1.0},
                {24.01, 30.0, true, -1.0},

                {4.0, -1.0, false, -1.0},
                {4.0, -1.0, true, -1.0},
                {4.0, 0.0, false, 0.0},
                {4.0, 0.0, true, 0.0},
                {4.0, 1.0, false, 495.0},
                {4.0, 1.0, true, 445.0},
                {4.0, 59.0, false, 29205.0},
                {4.0, 59.0, true, 26255.0},
                {4.0, 60.0, false, 29700.0},
                {4.0, 60.0, true, 26700.0},
                {4.0, 61.0, false, 25665.750},
                {4.0, 61.0, true, 23073.250},

                {13.0, -1.0, false, -1.0},
                {13.0, -1.0, true, -1.0},
                {13.0, 0.0, false, 0.0},
                {13.0, 0.0, true, 0.0},
                {13.0, 1.0, false, 990.0},
                {13.0, 1.0, true, 890.0},
                {13.0, 59.0, false, 58410.0},
                {13.0, 59.0, true, 52510.0},
                {13.0, 60.0, false, 59400.0},
                {13.0, 60.0, true, 53400.0},
                {13.0, 61.0, false, 51331.500},
                {13.0, 61.0, true, 46146.500},

                {21.0, -1.0, false, -1.0},
                {21.0, -1.0, true, -1.0},
                {21.0, 0.0, false, 0.0},
                {21.0, 0.0, true, 0.0},
                {21.0, 1.0, false, 495.0},
                {21.0, 1.0, true, 445.0},
                {21.0, 59.0, false, 29205.0},
                {21.0, 59.0, true, 26255.0},
                {21.0, 60.0, false, 29700.0},
                {21.0, 60.0, true, 26700.0},
                {21.0, 61.0, false, 25665.750},
                {21.0, 61.0, true, 23073.250},
        };

        solve(testCasesBAV);
    }
}