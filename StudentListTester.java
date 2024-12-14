public class StudentListTester{
    public static void main(String[] args) {
        StudentList list = new StudentList();
        System.out.println(list.size());

        list.add(new Student("Student.bin"));
        System.out.println(list.get(0));
        try {
            list.writeToFile("studentList.bin");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}