import java.util.ArrayList;
import java.util.Objects;

public class YearlyReport {  // класс, отвечающий за вывод(!) информации (год, прибыль по каждому месяцу, ср.расход за все операции в году, средний доход)


    Transaction year;





    public YearlyReport(ArrayList<String> yearName) { // идея на вход подавать ArrayList, а делать HashMap, key - месяц, value = ArrayList <Integer> через цикл, чтобы isExpense проверялось, и присваивался минус при false
        year = new Transaction(yearName, "y.2021.csv");
        System.out.println(year);
    }


    void findYear() {}

    Integer benefitForYear() {
        int benefit = 0;
        int exspense = 0;
        for (int i = 0; i < year.unitPrice.size(); i++) {
                benefit = year.unitPrice.get(i);
                if (!year.isExpense.get(i)) {
                    exspense = -year.unitPrice.get(i);
                }
                benefit += exspense;
                System.out.println(benefit);
            }

         return benefit;
    }

  //  double averageExpense() {}

   // double averageBenefit() {}

}
