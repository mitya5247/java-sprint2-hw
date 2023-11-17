import java.util.ArrayList;
import java.util.HashMap;

public class MonthTotalPerYear { // подготовка данных для сверки(считать все месячные отчеты);


  //  String monthName;

    MonthlyReport month1;
    MonthlyReport month2;
    MonthlyReport month3;
    MonthlyReport month4;


    // HashMap<String, Transaction> totalQuantityMonth = new HashMap<>();

    HashMap<String, ArrayList<String>> totalQuantityMonth = new HashMap<>();

  //  public MonthTotalPerYear(Transition month1, Transition month2, Transition month3) { // предыдущий варик

    public MonthTotalPerYear(ArrayList<String> month1, ArrayList<String> month2, ArrayList<String> month3) {
//        month1.addMonth(month2);
//        month1.addMonth(month3);
//        System.out.println(month1);
//        ArrayList<Transaction> monthTotal = new ArrayList<>();
//        monthTotal.add(month1);
//        monthTotal.add(month2);
//        monthTotal.add(month3);
        this.month1 = new MonthlyReport(month1, "m.202101.csv");
        this.month2 = new MonthlyReport(month2, "m.202102.csv");
        this.month3 = new MonthlyReport(month3, "m.202103.csv");
     //   totalQuantityMonth.put(month1.get(), month1);
    //    totalQuantityMonth.put(month2.nameMonth, month2);
    //    totalQuantityMonth.put(month3.nameMonth, month3);
    //    System.out.println(totalQuantityMonth);
        }

        Integer maxBenefitPerMonthAll() {
        int maxSumBenefit = 0;
        int sum = 0;
           //     for (int i = 0; i < totalQuantityMonth.keySet().size(); i++) {
             //       if (totalQuantityMonth.get().isExpense.get(i)) {
               //         int benefit = totalQuantityMonth.get(monthName).unitPrice.get(i) * totalQuantityMonth.get(monthName).quantity.get(i);
                 //       sum += benefit;
                   // }
               // }

          //  System.out.println(totalQuantityMonth.get(monthName).unitPrice);
          //  month = new MonthlyReport(totalQuantityMonth.get(nameMonth).name, "m.202101.csv"); // исключение, так как мы посылаем уже отработанный Transition, но он начинает обрабатываться еще раз, а цикл идет с первого, а не нулевого
          //  maxSumBenefit = month.maxBenefit();
            int monthBenefF = month1.monthBenefitSum();
            int monthBenefS = month2.monthBenefitSum();
            int monthBenefT = month3.monthBenefitSum();

            sum = monthBenefF + monthBenefS + monthBenefT;
            maxSumBenefit = sum;

            return maxSumBenefit;
        }


        Integer maxExspensePerMonthAll() {
            int maxSumExspense = 0;
            int sum = 0;

            int monthBenefF = month1.monthExpsenseSum();
            int monthBenefS = month2.monthExpsenseSum();
            int monthBenefT = month3.monthExpsenseSum();

            sum = monthBenefF + monthBenefS + monthBenefT;
            maxSumExspense = sum;

            return maxSumExspense;
        }


}
