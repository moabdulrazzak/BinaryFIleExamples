import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StudentList extends ArrayList<Student> {
    public void writeToFile(String fileName)
                                     throws IOException{
    FileOutputStream outStream = new FileOutputStream(fileName);
    ObjectOutputStream ooStream = new ObjectOutputStream(outStream);
    ooStream.writeObject(this);
    ooStream.flush();
  } // writeToFile()
}
