package org.example;

import java.io.*;
import java.time.LocalDate;



public class Main {
    public static void rewriteFile(ExpensesList expensesList) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("expenses.csv"))) {
            bw.write("ID,Date,Description,Amount,Category");
            bw.newLine();
            for(Expense expense : expensesList.getExpenses()) {
                bw.write(expense.getId() + "," + expense.getDate().toString() + "," + expense.getDescription() + "," + expense.getAmount() + "," + expense.getCategory());
                bw.newLine();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ExpensesList expensesList = new ExpensesList();
        try(BufferedReader br = new BufferedReader(new FileReader("expenses.csv"))) {
            String firstLine = br.readLine();
            String line;
            while((line = br.readLine()) != null)
            {
                String[] tokens = line.split(",");
                expensesList.addExpense(Integer.parseInt(tokens[0]), LocalDate.parse(tokens[1]),tokens[2],Double.parseDouble(tokens[3].replace("$", "")),tokens[4]);
            }
            expensesList.setIdCounter(expensesList.getExpenses().getLast().getId());
            for(Expense expense : expensesList.getExpenses()) {
                expensesList.setTotalExpenses(expensesList.getTotalExpenses() + expense.getAmount());
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        if(args.length < 1) {
            System.out.println("Invalid number of arguments.");
            return;
        }
        String description = null;
        double amount = 0.0;
        String category = null;
        int id = -1;
        for(int i = 1; i < args.length; i++) {
            switch(args[i]) {
                case "--description":
                    description = args[++i];
                    break;
                case "--amount": {
                    amount = Double.parseDouble(args[++i]);
                    break;
                }
                case "--category": {
                    category = args[++i];
                    break;
                }
                case "--id":
                    id = Integer.parseInt(args[++i]);
                    break;
                default: {
                    System.out.println("Unknown argument " + args[i]);
                }
            }
        }
        if(args[0].equals("add")) {
            if(category == null) {
                expensesList.addExpense(description, amount);
            }
            else {
                expensesList.addExpense(description, amount, category);
            }
        }
        else if(args[0].equals("delete")) {
            expensesList.removeExpense(id);
        }
        else if(args[0].equals("list")) {
            expensesList.print();
        }
        else if(args[0].equals("summary")) {
            System.out.println("Total expenses: $" + expensesList.getTotalExpenses());
        }
        rewriteFile(expensesList);
    }
}