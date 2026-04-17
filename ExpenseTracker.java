import java.util.*;
// main class
public class ExpenseTracker{
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        ExpTrack t = new ExpTrack();
        int choice;
        do {
            System.out.println("\n1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Generate Summary");
            System.out.println("5. Monthly Report");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch(choice)  {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter category: ");
                    String cat = sc.nextLine();
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();

                   sc.nextLine();
                    System.out.print("Enter date (DD-MM-YYYY): ");
                    String date = sc.nextLine();
                    t.addExp(cat, amt, date);
                    break;

                case 2:
                    t.displayExpenses();
                    break;

                case 3:
                    System.out.print("Enter index to delete: ");
                    int index = sc.nextInt();
                    t.deleteExp(index);
                    break;

                case 4:
                    t.generateSummary();
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Enter month (MM-YYYY): ");
                    String month = sc.nextLine();
                    t.monthlyReport(month);
                    break;

                case 6:
                    System.out.println("Exiting...\n Thank you for using Expense Tracking System");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while(choice != 6);
        sc.close();
    }
}

// expense class
class Expense{
    String category;
    double amount;
    String date;

    Expense(String category, double amount, String date) { //constructor
        this.category = category;
        this.amount = amount;
        this.date = date;
    }
    public String toString() {
        return date + " | " + category + " | ₹" + amount;
    }
}

class ExpTrack {
    private ArrayList<Expense> expenses = new ArrayList<>();// Add expense
    public void addExp(String category, double amount, String date) {
        expenses.add(new Expense(category, amount, date));
        System.out.println("\nAdded Expense: " + category + " - ₹" + amount);
    }

    public void displayExpenses(){  // Display expense
        System.out.println("\n===== ALL EXPENSES =====\n");
        for(int i=0;i<expenses.size();i++)   {
            System.out.println(i + ". " + expenses.get(i));
            System.out.println();
        }
    }

    public void deleteExp(int index) // Delete Expense
    {
        if(index >= 0 && index < expenses.size())  {
            Expense removed = expenses.remove(index);
            System.out.println("\nDeleted Expense: " + removed);
        }
        else{
            System.out.println("Invalid index! Cannot delete.");
        }
    }

    public void generateSummary() { // Generate summary
        HashMap<String, Double> catTotal = new HashMap<>();
        double total = 0;

        for(int i=0;i<expenses.size();i++){
            Expense e = expenses.get(i);
            total += e.amount;
            catTotal.put(e.category,
                    catTotal.getOrDefault(e.category,0.0) + e.amount);
        }

        System.out.println("\n===== EXPENSE SUMMARY =====\n");
        System.out.println("Total Expenses: ₹" + total);

        System.out.println("\nBy Category:\n");

        for(String cat : catTotal.keySet())
        {
            System.out.println(cat + " : ₹" + catTotal.get(cat));
        }
    }

    public void monthlyReport(String month) // Monthly report
   {
        HashMap<String, Double> catTotal = new HashMap<>();
        double total = 0;
        for(int i=0;i<expenses.size();i++)
        {
            Expense e = expenses.get(i);

            if(e.date.substring(3,10).equals(month))
            {
                total += e.amount;

                catTotal.put(e.category,
                        catTotal.getOrDefault(e.category,0.0)+e.amount);
            }
        }
        System.out.println("\n===== MONTHLY REPORT: " + month + " =====\n");
        System.out.println("Total for " + month + ": ₹" + total);
        System.out.println("\nBy Category:\n");
        for(String cat : catTotal.keySet())
        {
            System.out.println(cat + " : ₹" + catTotal.get(cat));
        }
    }
}
