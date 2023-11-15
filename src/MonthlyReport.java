
import java.util.ArrayList;
public class MonthlyReport { // класс для работы с уже имеющимся массивом данных(нахождение различных параметров) (месяц, самый прибыльный товар, самая большая трата)


    Transaction month; // передаем экземпляр, в котором храним массив

    public MonthlyReport(ArrayList<String> monthName) {
        month = new Transaction(monthName);
        System.out.println(month);
    }


 //   String findMonth() {
  //      return month.name;
  //  }

    Integer maxExspense() {
        int max = 0;
        int index = 0;

        for (int i = 0; i < month.quantity.size(); i++) {
            if (!month.isExpense.get(i)) {
            int expense = month.unitPrice.get(i) * month.quantity.get(i);
             //   expense = -expense; // при суммировании можно использовать
                if (max < expense) {
                  //  System.out.println(month.name);
                    max = expense;
                    index = i;
                }
            }
        }
        String nameEsxpense = month.name.get(index);
        System.out.println("Самая большая затрата " + nameEsxpense);
        return max;
    }



}
