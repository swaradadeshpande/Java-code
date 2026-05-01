// file of food delivery ecosystem small java application

package users;
// Base Class
public abstract class User {
    protected String name;
    public User(String name) { this.name = name; }
    public String getName() { return name; }
}
