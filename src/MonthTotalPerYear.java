import java.util.ArrayList;
import java.util.HashMap;

public class MonthTotalPerYear { // подготовка данных для сверки(считать все месячные отчеты);


    MonthlyReport month1;
    MonthlyReport month2;
    MonthlyReport month3;

    ArrayList<HashMap> monthArrayMap1 = new ArrayList<>(); // каждый массив из HashMap хранит одну мапу по самому большому доходу(первую), одну мапу по самому большому расходу за указанный месяц
    ArrayList<HashMap> monthArrayMap2 = new ArrayList<>();
    ArrayList<HashMap> monthArrayMap3 = new ArrayList<>();



    public MonthTotalPerYear(ArrayList<String> month1, ArrayList<String> month2, ArrayList<String> month3) {

        this.month1 = new MonthlyReport(month1, "m.202101.csv");
        this.month2 = new MonthlyReport(month2, "m.202102.csv");
        this.month3 = new MonthlyReport(month3, "m.202103.csv");

        }

        void printStatistic(MonthlyReport month, ArrayList<HashMap> monthArrayMap) {

            HashMap<String, HashMap<String, Integer>> nameMonth = new HashMap<>();
            HashMap<String, Integer> maxBenefitMonth = new HashMap<>();

            maxBenefitMonth.put(month.month.name.get(month.maxBenefit()), month.month.unitPrice.get(month.maxBenefit()) * month.month.quantity.get(month.maxBenefit()));
            nameMonth.put(month.month.nameMonth, maxBenefitMonth);

            HashMap<String, HashMap<String, Integer>> nameMonthExp = new HashMap<>();
            HashMap<String, Integer> maxExspenseMonth = new HashMap<>();

            maxExspenseMonth.put(month.month.name.get(month.maxExspense()), month.month.unitPrice.get(month.maxExspense()) * month.month.quantity.get(month.maxExspense()));
            nameMonthExp.put(month.month.nameMonth, maxExspenseMonth);

            monthArrayMap.add(nameMonth);
            monthArrayMap.add(nameMonthExp);

            System.out.println("За месяц " + month.month.nameMonth  + " самый прибыльный товар " + monthArrayMap.get(0).get(month.month.nameMonth) + " рублей.");
            System.out.println("За месяц " + month.month.nameMonth + " cамая большая трата " + monthArrayMap.get(1).get(month.month.nameMonth) + " рублей.");
        }

    Integer maxBenefitPerMonth(MonthlyReport month) {
        int maxSumBen = 0;

        for (int i = 0; i < month.month.unitPrice.size(); i++) {

            if (!month.month.isExpense.get(i)) {
                maxSumBen += month.month.quantity.get(i) * month.month.unitPrice.get(i);
            }
        }
        return maxSumBen;
    }

    Integer maxExpensePerMonth(MonthlyReport month) {
        int maxSumExspense = 0;
      //  int maxSumBen = 0;

        for (int i = 0; i < month.month.unitPrice.size(); i++) {

            if (month.month.isExpense.get(i)) {
                maxSumExspense += month.month.quantity.get(i) * month.month.unitPrice.get(i);
            }
        }
        return maxSumExspense;
    }


    }
