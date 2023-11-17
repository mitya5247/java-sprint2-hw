
import java.util.ArrayList;
public class MonthlyReport { // класс для работы с уже имеющимся массивом данных(нахождение различных параметров) (месяц, самый прибыльный товар, самая большая трата)


    Transaction month; // передаем экземпляр, в котором храним массив



    public MonthlyReport(ArrayList<String> monthName, String nameMonth) {
        month = new Transaction(monthName, nameMonth);
      //  System.out.println(month);

    }


    Integer maxExspense() {
        int max = 0;
        int index = 0;

        for (int i = 0; i < month.quantity.size(); i++) {
            if (month.isExpense.get(i)) {
            int expense = month.unitPrice.get(i) * month.quantity.get(i);
             //   expense = -expense; // при суммировании можно использовать
                if (max < expense) {
                  //  System.out.println(month.name);
                    max = expense;
                    index = i;
                }
            }
        }
        String nameExpense = month.name.get(index);
        System.out.println("Самая большая затрата в месяце " + nameExpense);
        return max;
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
          //  String maxBenefitName = month.name.get(index);
          //  System.out.println(maxBenefitName);
        }
        return maxBenefit;
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




//    void addMonth(Transaction currentMonth) {
//        for (int i = 0; i < currentMonth.name.size(); i++) {
//            month.name.add(currentMonth.name.get(i));
//            month.unitPrice.add(currentMonth.unitPrice.get(i));
//            month.isExpense.add(currentMonth.isExpense.get(i));
//            month.quantity.add(currentMonth.quantity.get(i));
//        }
//    }



}
