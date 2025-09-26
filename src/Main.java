
public class Main {
    public static int calculateBill(int kWh) {

        if (kWh < 0) {
            throw new IllegalArgumentException("Số kWh không hợp lệ!");
        }
        int[] levelElectric = {50, 50, 100, 100, 100};
        int[] priceInLevel = {1984, 2050, 2380, 2998, 3350};

        int res = 0;
        int index = 0;
        while (kWh > 0 && index < 5) {
            if (kWh >= levelElectric[index]) {
                res += levelElectric[index] * priceInLevel[index];
                kWh -= levelElectric[index];
                index++;
            } else {
                res += kWh * priceInLevel[index];
                kWh = 0;
                break;
            }
        }
        if (kWh > 0) {
            res += kWh * 3460;
        }
        return res;

    }

    public static void main(String[] args) {
        int[] testValues = {-1, 0, 1, 50, 51, 100, 101, 200, 201};
        for (int i = 0; i < testValues.length; i++) {
            try {
                int bill = calculateBill(testValues[i]);
                System.out.printf("Testcase %d: kWh= %d -> Result= %d%n", i, testValues[i], bill);
            } catch (IllegalArgumentException e) {
                System.out.printf("Testcase %d: kWh= %d -> Result= %s%n",i, testValues[i], e.getMessage());
            }
        }
    }
}