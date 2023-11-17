
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        FileReader fileReader = new FileReader();
        ArrayList<String> linesMonth1 = fileReader.readFileContents("m.202101.csv");
        ArrayList<String> linesMonth2 = fileReader.readFileContents("m.202102.csv");
        ArrayList<String> linesMonth3 = fileReader.readFileContents("m.202103.csv");
        ArrayList<String> yearMonth = fileReader.readFileContents("y.2021.csv");



      //  MonthlyReport month1 = new MonthlyReport(linesMonth1, "m.202101.csv"); // объявляем массивы с месяцами
        Transaction month1 = new Transaction(linesMonth1, "m.202101.csv");
        Transaction month2 = new Transaction(linesMonth2, "m.202102.csv");
        Transaction month3 = new Transaction(linesMonth3, "m.202103.csv");


          YearlyReport year = new YearlyReport(yearMonth);
          year.benefitForMonth();
        System.out.println("Средний расход " + year.averageExpense());
        System.out.println("Средний доход " + year.averageBenefit());

        MonthTotalPerYear ex1 = new MonthTotalPerYear(linesMonth1, linesMonth2, linesMonth3);

        ex1.printStatistic();
       // System.out.println("Самая большая прибыль за 3 месяца" + ex1.maxBenefitPerMonthAll());

        System.out.println("Самая большая траты за 3 месяца" + ex1.maxExspensePerMonthAll());

        // System.out.println(yearMonth);
      //  System.out.println("Самая большая прибыль по каждому месяцу");
//        System.out.println(year.benefitForMonth());

    //    MonthlyReport month1 = new MonthlyReport(linesMonth1, "m.202101.csv");
       //     System.out.println("Самая большая затрата " + month1.maxExspense());
      //     System.out.println("Самая большая прибыль " + month1.maxBenefit());

        //   } else {
       //     System.out.println("Файлы не прочитаны");
      //  }



    }
}

