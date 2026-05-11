package restaurants;
import java.util.ArrayList;

public class Restaurant {
    private String name;
    private ArrayList<String> menu = new ArrayList<>(); // to store records

    public Restaurant(String name) { this.name = name; }// constructor

    public void addMenuItem(String item) { menu.add(item); } // method to add menu 
    public String getName() { return name; } // get method
    public void showMenu() { System.out.println("Menu for " + name + ": " + menu); //method to display
                           }
}

