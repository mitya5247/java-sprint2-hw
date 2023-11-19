package project.store;

import project.store.Transaction;

import java.util.ArrayList;
import java.util.HashMap;


public class YearlyReport {  // класс, отвечающий за вывод(!) информации (год, прибыль по каждому месяцу, ср.расход за все операции в году, средний доход)


    public Transaction year;
    HashMap<String, Integer> yearToPrice = new HashMap<>();





    public YearlyReport(ArrayList<String> yearName) { // идея на вход подавать ArrayList, а делать HashMap, key - месяц, value = ArrayList <Integer> через цикл, чтобы isExpense проверялось, и присваивался минус при false
        year = new Transaction(yearName);
        for (int i = 0; i < year.unitPrice.size(); i++) {
            int value = year.unitPrice.get(i);
            if (year.isExpense.get(i)) {

                value = value *-1;
            }
            yearToPrice.put(year.name.get(i), yearToPrice.getOrDefault(year.name.get(i), 0) + value); // сразу считаем прибыль в конструкторе
        }

    }


    public void printBenefitForMonth() {
        String key = "";
        for (String nameMonth : yearToPrice.keySet()) {
            int benefit = yearToPrice.get(nameMonth);
            key = nameMonth;
            System.out.println("Месяц - " + key + " прибыль - " + benefit + " рублей.");
        }


    }

    public int averageExpense() {
        int averageExpense = 0;
        int count = 0;
        int sum = 0;
        for (int i = 0; i < year.unitPrice.size(); i++) {
            if (year.isExpense.get(i)) {
                count += 1;
                sum += year.unitPrice.get(i);
                averageExpense = sum / count;
            }
        }
        return averageExpense;
    }

    public int averageBenefit() {
        int averageBenefit = 0;
        int count = 0;
        int sum = 0;
        for (int i = 0; i < year.unitPrice.size(); i++) {
            if (!year.isExpense.get(i)) {
                count += 1;
                sum += year.unitPrice.get(i);
                averageBenefit = sum / count;
            }
        }
        return averageBenefit;
    }

}
