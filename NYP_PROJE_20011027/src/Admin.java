import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Admin {
    private String name;
    private List<Child> children;
  
    
    public Admin(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }
    
    public void addChild(Child child) {
        children.add(child);
    }
    
    public List<Child> getChildList() {
        return children;
    }
    
    public boolean checkChild(String childName) {
        for (Child child : children) {
            if (child.getName().equals(childName)) {
                return true;
            }
        }
        return false;
    }
    public String getName() {
    	return name;
    }
    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("admin.txt"))) {
            writer.println(name);
            writer.println(children.size());
            for (Child child : children) {
                writer.println(child.getName());
            }
            System.out.println("Admin data saved to " + "admin.txt");
        } catch (IOException e) {
            System.err.println("Error saving admin data to " +"admin.txt");
            e.printStackTrace();
        }
    }
}
