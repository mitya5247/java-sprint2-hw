import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.HashMap;

public class MonthTotalPerYear { // подготовка данных для сверки(считать все месячные отчеты);


  //  String monthName;
//    Transaction month1;
//    Transaction month2;
 //   Transaction month3;


    MonthlyReport month1;
    MonthlyReport month2;
    MonthlyReport month3;

    ArrayList<HashMap> monthArrayMap1 = new ArrayList<>(); // каждый массив из HashMap хранит одну мапу по самому большому доходу(первую), одну мапу по самому большому расходу за указанный месяц
    ArrayList<HashMap> monthArrayMap2 = new ArrayList<>();
    ArrayList<HashMap> monthArrayMap3 = new ArrayList<>();



    // HashMap<String, HashMap<String, Integer>> maxBenefitMonth1 = new HashMap<>();
 //   HashMap<String, HashMap<String, Integer>> maxExpenseMonth1 = new HashMap<>();
 //   HashMap<String, HashMap<String, Integer>> maxBenefitMonth2 = new HashMap<>();
 //   HashMap<String, HashMap<String, Integer>> maxExpenseMonth2 = new HashMap<>();
 //   HashMap<String, HashMap<String, Integer>> maxBenefitMonth3 = new HashMap<>();
 //   HashMap<String, HashMap<String, Integer>> maxExpenseMonth3 = new HashMap<>();





  //    public MonthTotalPerYear(Transaction month1, Transaction month2, Transaction month3) { // предыдущий варик

    public MonthTotalPerYear(ArrayList<String> month1, ArrayList<String> month2, ArrayList<String> month3) {
//        month1.addMonth(month2);
//        month1.addMonth(month3);
//        System.out.println(month1);
//        ArrayList<Transaction> monthTotal = new ArrayList<>();
//        monthTotal.add(month1);
//        monthTotal.add(month2);
//        monthTotal.add(month3);

    //    this.month1 = new MonthlyReport(month1, "m.202101.csv");
    //    this.month2 = new MonthlyReport(month2, "m.202102.csv");
    //    this.month3 = new MonthlyReport(month3, "m.202103.csv");
    //   totalQuantityMonth.put(month1.get(), month1);
    //    totalQuantityMonth.put(month2.nameMonth, month2);
    //    totalQuantityMonth.put(month3.nameMonth, month3);
    //    System.out.println(totalQuantityMonth);
    //      System.out.println(monthTotal);

        this.month1 = new MonthlyReport(month1, "m.202101.csv");
        this.month2 = new MonthlyReport(month2, "m.202102.csv");
        this.month3 = new MonthlyReport(month3, "m.202103.csv");


    //    System.out.println(month1);

        }

        void printStatistic() {
            HashMap<String, HashMap<String, Integer>> nameMonth1 = new HashMap<>();
            HashMap<String, Integer> maxBenefitMonth1 = new HashMap<>();

            maxBenefitMonth1.put(month1.month.name.get(month1.maxBenefit()), month1.month.unitPrice.get(month1.maxBenefit())*month1.month.quantity.get(month1.maxBenefit()));
            nameMonth1.put(month1.month.nameMonth, maxBenefitMonth1);

            HashMap<String, HashMap<String, Integer>> nameMonth2 = new HashMap<>();
            HashMap<String, Integer> maxBenefitMonth2 = new HashMap<>();

            maxBenefitMonth2.put(month2.month.name.get(month2.maxBenefit()), month2.month.unitPrice.get(month2.maxBenefit())*month2.month.quantity.get(month2.maxBenefit()));
            nameMonth2.put(month2.month.nameMonth, maxBenefitMonth2);

            HashMap<String, HashMap<String, Integer>> nameMonth3 = new HashMap<>();
            HashMap<String, Integer> maxBenefitMonth3 = new HashMap<>();

            maxBenefitMonth3.put(month3.month.name.get(month3.maxBenefit()), month3.month.unitPrice.get(month3.maxBenefit())*month3.month.quantity.get(month3.maxBenefit()));
            nameMonth3.put(month3.month.nameMonth, maxBenefitMonth3);

            HashMap<String, HashMap<String, Integer>> nameMonthExp1 = new HashMap<>();
            HashMap<String, Integer> maxExpMonth1 = new HashMap<>();

            maxExpMonth1.put(month1.month.name.get(month1.maxExspense()), month1.month.unitPrice.get(month1.maxExspense())*month1.month.quantity.get(month1.maxExspense()));
            nameMonthExp1.put(month1.month.nameMonth, maxExpMonth1);

            HashMap<String, HashMap<String, Integer>> nameMonthExp2 = new HashMap<>();
            HashMap<String, Integer> maxExpMonth2 = new HashMap<>();

            maxExpMonth2.put(month2.month.name.get(month2.maxExspense()), month2.month.unitPrice.get(month2.maxExspense())*month2.month.quantity.get(month2.maxExspense()));
            nameMonthExp2.put(month2.month.nameMonth, maxExpMonth2);


            HashMap<String, HashMap<String, Integer>> nameMonthExp3 = new HashMap<>();
            HashMap<String, Integer> maxExpMonth3 = new HashMap<>();

            maxExpMonth3.put(month3.month.name.get(month3.maxExspense()), month3.month.unitPrice.get(month3.maxExspense())*month3.month.quantity.get(month3.maxExspense()));
            nameMonthExp3.put(month3.month.nameMonth, maxExpMonth3);


            monthArrayMap1.add(nameMonth1);
            monthArrayMap1.add(nameMonthExp1);
            System.out.println(monthArrayMap1);


            monthArrayMap2.add(nameMonth2);
            monthArrayMap2.add(nameMonthExp2);


            monthArrayMap3.add(nameMonth3);
            monthArrayMap3.add(nameMonthExp3);

            System.out.println("За месяц " + month1.month.nameMonth + " прибыль составила " + monthArrayMap1.get(0).get(month1.month.nameMonth) + " рублей.");
            System.out.println("За месяц " + month2.month.nameMonth + " прибыль составила " + monthArrayMap2.get(0).get(month2.month.nameMonth) + " рублей.");
            System.out.println("За месяц " + month3.month.nameMonth + " прибыль составила " + monthArrayMap3.get(0).get(month3.month.nameMonth) + " рублей.");



        }


        void maxExspensePerMonthAll() {
            int maxSumExspense = 0;
            int maxSumBen = 0;




            for (int i = 0; i < month1.month.unitPrice.size(); i++) {

                    if (!month1.month.isExpense.get(i)) {
                        maxSumBen += month1.month.quantity.get(i) * month1.month.unitPrice.get(i);
                    }
                }
            System.out.println(maxSumBen);

        //    for (int i = 0; i < month1.month.quantity.size(); i++) {
         //       if (month1.month.isExpense.get(i)) {
         //           maxSumExspense += month1.month.quantity.get(i) * month1.month.unitPrice.get(i);
         //       }

         //   }

        //    System.out.println(maxSumExspense);

         //   int monthBenefit = maxSumBen - maxSumExspense;

       //     System.out.println(monthBenefit);




        }


}
