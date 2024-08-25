package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExpensesList {
    private List<Expense> expenses;
    private int idCounter;
    private double totalExpenses;
    public ExpensesList() {
        this.expenses = new ArrayList<Expense>();
        this.idCounter = 0;
        this.totalExpenses = 0;
    }
    public ExpensesList(List<Expense> expenses) {
        this.expenses = expenses;
        this.idCounter = expenses.size();
        for(Expense expense : expenses) {
            this.totalExpenses += expense.getAmount();
        }
    }
    public List<Expense> getExpenses() {
        return expenses;
    }
    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
    public int getIdCounter() {
        return idCounter;
    }
    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }
    public double getTotalExpenses() {
        return totalExpenses;
    }
    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }
    public void addExpense(String description, double amount) {
        Expense expense = new Expense(++idCounter, description, amount, "General");
        expenses.add(expense);
    }
    public void addExpense(String description, double amount, String category) {
        Expense expense = new Expense(++idCounter, description, amount, category);
        expenses.add(expense);
    }
    public void addExpense(int id, LocalDate date, String description, double amount, String category) {
        Expense expense = new Expense(id, date, description, amount, category);
        expenses.add(expense);
    }
    public void removeExpense(int id) {
        expenses.removeIf(expense -> expense.getId() == id);
    }
    public void print() {
        System.out.println("ID \t Date \t\t Description \t Amount \t Category" );
        for (Expense expense : expenses) {
            System.out.print(expense.getId());
            for(int i = 0; i <= 4 - Integer.toString(expense.getId()).length(); i++) {
                System.out.print(" ");
            }
            System.out.print(expense.getDate());
            for(int i = 0; i <= 11 - expense.getDate().toString().length(); i++) {
                System.out.print(" ");
            }
            System.out.print(expense.getDescription());
            for(int i = 0; i <= 15 - expense.getDescription().length(); i++) {
                System.out.print(" ");
            }
            System.out.print("$" + expense.getAmount());
            for(int i = 0; i <= 10 - Double.toString(expense.getAmount()).length(); i++) {
                System.out.print(" ");
            }
            System.out.print(expense.getCategory());
            System.out.print("\n");
        }
    }

}
