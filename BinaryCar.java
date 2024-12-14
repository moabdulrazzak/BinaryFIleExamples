import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryCar {
    private String make;
    private String model;
    private int year;
    private Color color;
    private int miles;
    private int mpg;
    private double horsepower;

    public BinaryCar(String filename){
        if(!read(filename)){
            System.out.println("Binary Car corrupt.");
        }
    }

    public boolean write(String fileName){
        try {
        DataOutputStream outStream   // Open stream
            = new DataOutputStream(new FileOutputStream(fileName));
        for (int k = 0; k < 5; k++) { // Output 5 data records
            String name = "Name" + k;  // of name, age, payrate
            outStream.writeUTF(make);
            outStream.writeUTF(model);
            outStream.writeInt(year);
            outStream.writeInt(color.getRGB());
            outStream.writeInt(miles);
            outStream.writeInt(mpg);
            outStream.writeDouble(horsepower);
        } // for
        outStream.close();          // Close the stream
        } catch (IOException e) {
        //display.setText("IOERROR: " + e.getMessage() + "\n");
        System.out.println(e);
        return false;
        }
        return true;
    }
    public boolean read(String fileName){
        try {
          DataInputStream inStream                 // Open stream
            = new DataInputStream(new FileInputStream(fileName));
          //display.setText("Name   Age Pay\n");
          try {
                make = inStream.readUTF();  // Read a record
                model = inStream.readUTF();
                year = inStream.readInt();
                int rgb = inStream.readInt();
                color = new Color(rgb);
                miles = inStream.readInt();
                mpg = inStream.readInt();
                horsepower = inStream.readDouble();
               //display.append(name + " " + age + " " + pay + "\n");
             // while
          } catch (EOFException e) { // Until EOF exception
          } finally {
              inStream.close();             // Close the stream
          }
          } catch (FileNotFoundException e) {
             //display.setText("IOERROR: "+ fileName + " NOT Found: \n");
             System.out.println(e);
             return false;
          } catch (IOException e) {
             //display.setText("IOERROR: " + e.getMessage() + "\n");
             System.out.println(e);
             return false;
          }
          return true;
    }

}
