package project;

import project.reader.FileReader;
import project.checker.*;
import project.store.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader();
        int readCounterMonthReport = 0;
        int readCounterYearReport = 0;


        ArrayList<String> linesMonth1 = fileReader.readFileContents("m.202101.csv");
        ArrayList<String> linesMonth2 = fileReader.readFileContents("m.202102.csv");
        ArrayList<String> linesMonth3 = fileReader.readFileContents("m.202103.csv");

        ArrayList<String> yearMonth = fileReader.readFileContents("y.2021.csv");
        MonthTotalPerYear monthTotal = new MonthTotalPerYear(linesMonth1, linesMonth2, linesMonth3);


        ReportEngine reportEngine = new ReportEngine(yearMonth, linesMonth1, linesMonth2, linesMonth3);
        YearlyReport year = new YearlyReport(yearMonth);
        
        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                readCounterMonthReport = 1;
                System.out.println("Месячные отсчеты считаны");
            } else if (command == 2) {
                readCounterYearReport = 1;
                System.out.println("Годовой отсчет считан");
            } else if (command == 3) {
                if (readCounterYearReport == 1 && readCounterMonthReport == 1) {
                    reportEngine.checkReport(monthTotal, year);
                } else {
                    System.out.println("Необходимо сначала считать файлы");
                }
            } else if (command == 4) {
                if (readCounterMonthReport == 1) {
                    monthTotal.printStatistic(monthTotal.month1, monthTotal.monthArrayMap1);
                    monthTotal.printStatistic(monthTotal.month2, monthTotal.monthArrayMap2);
                    monthTotal.printStatistic(monthTotal.month3, monthTotal.monthArrayMap3);
                } else {
                    System.out.println("Необходимо сначала считать файлы");
                }
            } else if (command == 5) {
                if (readCounterYearReport == 1) {
                    year.printBenefitForMonth();
                    System.out.println("Средний расход за все имеющиеся операции в году - " + year.averageExpense() + " рублей.");
                    System.out.println("Средний доход за все имеющиеся операции в году - " + year.averageBenefit() + " рублей.");
                } else {
                    System.out.println("Необходимо считать годовой отчет");
                }
            } else if (command == 0) {
                System.out.println("Завершаем программу!");
                break;
            } else {
                System.out.println("Такой команды пока нет");
            }
        }


    }
    public static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Считать все месячные отчеты");
        System.out.println("2 - Считать годовой отчет");
        System.out.println("3 -  Сверить отчеты");
        System.out.println("4 - Вывести информацию обо всех месячных отчетах");
        System.out.println("5 -  Вывести информацию о годовом отчете");
        System.out.println("0 - Выход");

    }

}

