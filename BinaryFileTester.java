
public class BinaryFileTester {
    public static void main(String[] args) {
        BinaryFile test = new BinaryFile();
        test.writeRecords("test.bin");
        test.readRecords("test.bin");
    }
}
