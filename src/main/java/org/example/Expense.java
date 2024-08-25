package org.example;

import java.time.LocalDate;

public class Expense {
    private int id;
    LocalDate date;
    private String description;
    private double amount;
    private String category;
    public Expense(int id, String description, double amount, String category) {
        this.id = id;
        this.date = LocalDate.now();
        this.description = description;
        this.amount = amount;
        this.category = category;
    }
    public Expense(int id, LocalDate date, String description, double amount, String category) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.category = category;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
