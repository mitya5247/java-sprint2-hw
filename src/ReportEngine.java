import java.util.ArrayList;

public class ReportEngine { // класс формирования вывода информации (?), сверка отчетов(?)

    MonthTotalPerYear monthlySumValues; // загружаем сюда объекты для сверки
    YearlyReport yearlyReport;

    ReportEngine(ArrayList<String> yearnName, ArrayList<String> month1, ArrayList<String> month2, ArrayList<String> month3) { // получаем экземпляры классов monthlyReport и YearlyReport при инициализации. Тип - объекты ( HashMap ?)
        this.yearlyReport = new YearlyReport(yearnName);
        this.monthlySumValues = new MonthTotalPerYear(month1, month2, month3);
    }


}
