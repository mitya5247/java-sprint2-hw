
import java.util.ArrayList;
public class MonthlyReport { // класс для работы с уже имеющимся массивом данных(нахождение различных параметров) (месяц, самый прибыльный товар, самая большая трата)


    Transaction month; // передаем экземпляр, в котором храним массив



    public MonthlyReport(ArrayList<String> monthName, String nameMonth) {
        month = new Transaction(monthName, nameMonth);

    }


    Integer maxExspense() {
        int max = 0;
        int index = 0;

        for (int i = 0; i < month.quantity.size(); i++) {
            if (month.isExpense.get(i)) {
            int expense = month.unitPrice.get(i) * month.quantity.get(i);
                if (max < expense) {
                    max = expense;
                    index = i;
                }
            }
        }
        return index;
    }

    Integer maxBenefit() {
        int maxBenefit = 0;
        int index = 0;

        for (int i = 0; i < month.unitPrice.size(); i++) {
            if (!month.isExpense.get(i)) {
                int benefit = month.unitPrice.get(i) * month.quantity.get(i);
                if (benefit > maxBenefit) {
                    index = i;
                    maxBenefit = benefit;
                }
            }

        }
        return index;
    }

    Integer monthBenefitSum() {
        int sum = 0;
        for (int i = 0; i < month.unitPrice.size(); i++) {
            if (!month.isExpense.get(i)) {
                int benefit = month.unitPrice.get(i) * month.quantity.get(i);
                    sum += benefit;
                }
            }
        return sum;
    }

    Integer monthExpsenseSum() {
        int sum = 0;
        for (int i = 0; i < month.unitPrice.size(); i++) {
            if (month.isExpense.get(i)) {
                int benefit = month.unitPrice.get(i) * month.quantity.get(i);
                sum += benefit;
            }
        }
        return sum;
    }

}
