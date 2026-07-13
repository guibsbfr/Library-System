package entities;
import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String email;
    private int id;

    public Student (){}

    public Student(String name, String email, int id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getCpf() {
        return id;
    }

}
