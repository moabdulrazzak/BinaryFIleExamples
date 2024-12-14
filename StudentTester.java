import java.io.FileOutputStream;
import java.io.IOException;

public class StudentTester {
    public static void main(String[] args) {
        Student t = new Student("Athena", 800, 3.9);
        try {
            FileOutputStream f = new FileOutputStream("Student.bin");
            t.writeToFile(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
     //   Student s = new Student("Student.bin");
       // System.out.println(s);
        // Student s = new Student();
        // System.out.println(s);
        // try {
        //     FileInputStream f = new FileInputStream("Student.bin");

        //         s.readFromFile(f);
        //         System.out.println(s);
        // }
        // catch (ClassNotFoundException e) {
        //         e.printStackTrace();
        //     }
        // catch (IOException e) {
        //     e.printStackTrace();
        // }
    }
}
