# TrackMySpend

## Overview

TrackMySpend is a CLI application developed using Java that manages a list of expenses. It reads from and writes to a CSV file to persist data. Users can add, delete, list, and summarize expenses via command-line arguments.

## Features

- **Add Expenses:** Add a new expense with a description, amount, and optional category.
- **Delete Expenses:** Remove an expense by its ID.
- **List Expenses:** Print a list of all recorded expenses.
- **Summary:** Print the total amount of all recorded expenses.

## How It Works

### Reading and Writing Expenses

- **Reading:** The application reads the `expenses.csv` file to populate the `ExpensesList` with existing expenses. It parses each line into `Expense` objects.
- **Writing:** After any operation, the application writes the updated list of expenses back to `expenses.csv`.

### Command-Line Arguments

The application accepts the following arguments:

- `add --description <description> --amount <amount> [--category <category>]`: Adds a new expense with the provided description, amount, and optional category.
- `delete --id <id>`: Deletes an expense with the specified ID.
- `list`: Lists all expenses.
- `summary`: Prints the total amount of all expenses.

### Example Usage

```bash
java Main add --description "Lunch" --amount 12.50 --category "Food"
java Main delete --id 1
java Main list
java Main summary

```
## CSV File Format
The expenses.csv file should have the following format:

```bash
ID,Date,Description,Amount,Category
1,2024-08-25,Lunch,12.50,Food
```
- ID: Unique identifier for the expense.
- Date: Date of the expense in YYYY-MM-DD format.
- Description: Description of the expense.
- Amount: Amount spent, formatted as a number without currency symbols.
- Category: Optional category of the expense.

## Dependencies
- Java SE 8 or later: The application is developed using Java and requires Java SE 8 or later.
- Maven

## Getting Started
Clone the repository:

```bash
git clone https://github.com/yourusername/TrackMySpend.git
```
Navigate to the project directory:
```bash
cd TrackMySpend
```
Compile the application:
```bash
mvn compile
```
Run the application:

```bash
mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="<command> [options]"
```
Replace <command> with one of add, delete, list, or summary, and provide the appropriate options as described above.
