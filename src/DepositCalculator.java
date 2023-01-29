import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, 2);
    }
    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }
    double round(double value, int places) {
        double scale= Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculatePercents() {
        int periodInYears;
        int percentType;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        periodInYears = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        percentType = scanner.nextInt();
        double sumWithPercents = 0;
        if (percentType == 1) {
            sumWithPercents = calculateSimplePercent(amount, 0.06, periodInYears);
        } else if (percentType == 2) {
            sumWithPercents = calculateComplexPercent(amount, 0.06, periodInYears);
        }
        System.out.println("Результат вклада: " + amount + " за " + periodInYears + " лет превратятся в " + sumWithPercents);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculatePercents();
    }

}
