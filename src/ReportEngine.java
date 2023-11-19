import java.util.ArrayList;
import java.util.Objects;

public class ReportEngine { // класс формирования вывода информации, сверка отчетов

    MonthTotalPerYear monthlySumValues; // загружаем сюда объекты для сверки
    YearlyReport yearlyReport;

    ReportEngine(ArrayList<String> yearnName, ArrayList<String> month1, ArrayList<String> month2, ArrayList<String> month3) { // получаем экземпляры классов monthlyReport и YearlyReport при инициализации. Тип - объекты ( HashMap ?)
        this.yearlyReport = new YearlyReport(yearnName);
        this.monthlySumValues = new MonthTotalPerYear(month1, month2, month3);
    }

    void checkReport(MonthTotalPerYear monthesReport, YearlyReport yearReport) {

        Integer benefitForMonthInYear1 = 0;
        Integer benefitForMonthInYear2 = 0;
        Integer benefitForMonthInYear3 = 0;

        Integer exspenseForMonthInYear1 = 0;
        Integer exspenseForMonthInYear2 = 0;
        Integer exspenseForMonthInYear3 = 0;

        for (int i = 0; i < yearReport.year.unitPrice.size(); i++) {

            if (yearReport.year.name.get(i).equals("01")) {
                if (!yearReport.year.isExpense.get(i)) {
                    benefitForMonthInYear1 = yearReport.year.unitPrice.get(i);
                } else {
                    exspenseForMonthInYear1 = yearReport.year.unitPrice.get(i);
                }
            } else if(yearReport.year.name.get(i).equals("02")) {
                if (!yearReport.year.isExpense.get(i)) {
                    benefitForMonthInYear2 = yearReport.year.unitPrice.get(i);

                } else {
                    exspenseForMonthInYear2 = yearReport.year.unitPrice.get(i);

                }
            } else {
                if (!yearReport.year.isExpense.get(i)) {
                    benefitForMonthInYear3 = yearReport.year.unitPrice.get(i);

                } else {
                    exspenseForMonthInYear3 = yearReport.year.unitPrice.get(i);

                }
            }

        }

        boolean monthBen1 = Objects.equals(monthesReport.maxBenefitPerMonth(monthesReport.month1), benefitForMonthInYear1);
        if(!monthBen1) {
            System.out.println("Доходы в первом месяце не сходятся с годовым отчетом");
        }
        boolean monthBen2 = Objects.equals(monthesReport.maxBenefitPerMonth(monthesReport.month2), benefitForMonthInYear2);
        if(!monthBen2) {
            System.out.println("Доходы во втором месяце не сходятся с годовым отчетом");
        }
        boolean monthBen3 = Objects.equals(monthesReport.maxBenefitPerMonth(monthesReport.month3), benefitForMonthInYear3);
        if(!monthBen3) {
            System.out.println("Доходы в третьем месяце не сходятся с годовым отчетом");
        }

        boolean monthExp1 = Objects.equals(monthesReport.maxExpensePerMonth(monthesReport.month1), exspenseForMonthInYear1);
        if(!monthExp1) {
            System.out.println("Расходы в первом месяце не сходятся с годовым отчетом");
        }
        boolean monthExp2 = Objects.equals(monthesReport.maxExpensePerMonth(monthesReport.month2), exspenseForMonthInYear2);
        if(!monthExp2) {
            System.out.println("Расходы во втором месяце не сходятся с годовым отчетом");
        }
        boolean monthExp3 = Objects.equals(monthesReport.maxExpensePerMonth(monthesReport.month3), exspenseForMonthInYear3);
        if(!monthExp3) {
            System.out.println("Расходы в третьем месяце не сходятся с годовым отчетом");
        }

        if (monthBen1 && monthExp1) {
            System.out.println("Доходы и расходы за первый месяц сходятся");
        }
        if (monthBen2 && monthExp2) {
            System.out.println("Доходы и расходы за второй месяц сходятся");
        }
        if (monthBen3 && monthExp3) {
            System.out.println("Доходы и расходы за третий месяц сходятся");
        }

    }


}
