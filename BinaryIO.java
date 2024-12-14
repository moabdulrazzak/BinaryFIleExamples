import java.awt.*;         // Swing components
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class BinaryIO extends JFrame implements ActionListener{
    private JTextArea display = new JTextArea();
    private JButton read = new JButton("Read Records From File"),
                    write = new JButton("Generate Random Records");
    private JTextField nameField = new JTextField(10);
    private JLabel prompt = new JLabel("Filename:", JLabel.RIGHT);
    private JPanel commands = new JPanel();
    public BinaryIO() {
        super("BinaryIO Demo");                    // Set window title
        read.addActionListener(this);
        write.addActionListener(this);
        commands.setLayout(new GridLayout(2,2,1,1)); // Control panel
        commands.add(prompt);
        commands.add(nameField);
        commands.add(read);
        commands.add(write);
        display.setLineWrap(true);
        this.getContentPane().setLayout(new BorderLayout () );
        this.getContentPane().add("North", commands);
        this.getContentPane().add( new JScrollPane(display));
        this.getContentPane().add("Center", display);
    } // BinaryIO()

    private void readRecords( String fileName ) {
        try {
            DataInputStream inStream     // Open stream
               = new DataInputStream(new FileInputStream(fileName));
            display.setText("Name   Age Pay\n");
            try {
                while (true) {                // Infinite loop
                    String name = inStream.readUTF(); // Read a record
                    int age = inStream.readInt();
                    double pay = inStream.readDouble();
                    display.append(name + "   " + age + "   " + pay + "\n");
                } // while
            } catch (EOFException e) {  // Until EOF exception
            } finally {
                inStream.close();                  // Close the stream
            }
        } catch (FileNotFoundException e) {
            display.setText("IOERROR: File NOT Found: " + fileName + "\n");
        } catch (IOException e) {
            display.setText("IOERROR: " + e.getMessage() + "\n");
        }
    } // readRecords()

private void writeRecords( String fileName )  {
   try {
     DataOutputStream outStream   // Open stream
       = new DataOutputStream(new FileOutputStream(fileName));
     for (int k = 0; k < 5; k++) { // Output 5 data records
       String name = "Name" + k;   // of name, age, payrate
       outStream.writeUTF("Name" + k);
       outStream.writeInt((int)(20 + Math.random() * 25));
       outStream.writeDouble(5.00 + Math.random() * 10);
     } // for
     outStream.close();             // Close the stream
   } catch (IOException e) {
      display.setText("IOERROR: " + e.getMessage() + "\n");
   }
 } // writeRecords()

 public void actionPerformed(ActionEvent evt) {
     String fileName = nameField.getText();
     if (evt.getSource()  == read)
         readRecords(fileName);
      else
         writeRecords(fileName);
 } // actionPerformed()
 
 public static void main(String args[]) {
    BinaryIO bio = new BinaryIO();
    bio.setSize(400, 200);
    bio.setVisible(true);
    bio.addWindowListener(new WindowAdapter() { // Quit
       public void windowClosing(WindowEvent e) {
            System.exit(0);
       }
    });
 } // main()
} // BinaryIO