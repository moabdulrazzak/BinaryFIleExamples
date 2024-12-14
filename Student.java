import java.io.*;
public class Student implements Serializable {
  private String name;
  private int year;
  private double gpa;
  public Student(String fileName) {
  }
  public Student (String nameIn, int yr, double gpaIn) {
    name = nameIn;
    year = yr;
    gpa = gpaIn;
  }

  public void writeToFile(FileOutputStream outStream)
                                     throws IOException{
    ObjectOutputStream ooStream = new ObjectOutputStream(outStream);
    ooStream.writeObject(this);
    ooStream.flush();
  } // writeToFile()
  
  public void readFromFile(FileInputStream inStream)
           throws IOException, ClassNotFoundException {
    ObjectInputStream oiStream = new ObjectInputStream(inStream);
    Student s = (Student)oiStream.readObject();
    this.name = s.name;
    this.year = s.year;
    this.gpa = s.gpa;
  } // readFromFile()
  
  public String toString() {
    return name + "\t" + year + "\t" + gpa;
  }
} // Student