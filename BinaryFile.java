
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class BinaryFile{
    
    public void writeRecords( String fileName )  {
        try {
        DataOutputStream outStream   // Open stream
            = new DataOutputStream(new FileOutputStream(fileName));
        for (int k = 0; k < 5; k++) { // Output 5 data records
            String name = "Name" + k;  // of name, age, payrate
            outStream.writeUTF("Name" + k);
            outStream.writeInt((int)(20 + Math.random() * 25));
            outStream.writeDouble(5.00 + Math.random() * 10);
        } // for
        outStream.close();          // Close the stream
        } catch (IOException e) {
        //display.setText("IOERROR: " + e.getMessage() + "\n");
        System.out.println(e);
        }
    } // writeRecords()
    public void readRecords( String fileName ) {
        try {
          DataInputStream inStream                 // Open stream
            = new DataInputStream(new FileInputStream(fileName));
          //display.setText("Name   Age Pay\n");
          System.out.println("Name   Age Pay\n");
          try {
            while (true) {                        // Infinite loop
               String name = inStream.readUTF();  // Read a record
               int age = inStream.readInt();
               double pay = inStream.readDouble();
               //display.append(name + " " + age + " " + pay + "\n");
               System.out.println(name + " " + age + " " + pay);
            } // while
          } catch (EOFException e) { // Until EOF exception
          } finally {
              inStream.close();             // Close the stream
          }
          } catch (FileNotFoundException e) {
             //display.setText("IOERROR: "+ fileName + " NOT Found: \n");
             System.out.println(e);
          } catch (IOException e) {
             //display.setText("IOERROR: " + e.getMessage() + "\n");
             System.out.println(e);
          }
       } // readRecords()
}