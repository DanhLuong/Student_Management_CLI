import java.util.*;

public class Main {
    public static void main(String[] args) {
        String command;
        String nextRound="";
        String sure="";
        List<Student> studentList=new ArrayList<>();
        String tempName;
        int tempMark;
        Student tempStudent;
        int studentNumber;
        while (!nextRound.equals("q")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Available command:");
            System.out.println("1.Add student");
            System.out.println("2.Delete student");
            System.out.println("3.Check all student information");
            System.out.println("4.Find student by name");
            System.out.println("5.Print all student with increasing mark");
            System.out.print("Please choose command (1-5): ");
            command=scanner.next();
            switch(command){
                case "1":
                    System.out.print("Please input student number you want to add: ");
                    studentNumber=scanner.nextInt();
                    for(int i=0;i<studentNumber;i++) {
                        System.out.print("Please input student name :");
                        tempName=scanner.next();
                        System.out.print("Please input student mark :");
                        tempMark=scanner.nextInt();
                        tempStudent=new Student(tempName,tempMark);
                        studentList.add(tempStudent);
                    }
                    System.out.println("Student added: "+studentList.toString());
                    break;
                case "2":
                    System.out.print("Please input student name to delete: ");
                    tempName=scanner.next();
                    System.out.print("Are you sure to delete "+tempName+" in student list (y/n):");
                    sure=scanner.next();
                    if(sure.equals("y")) {
                        int initalSize=studentList.size();
                        if(initalSize==0) {
                            System.out.println("No student in the list yet!");
                        }else {
                            List<Integer> removeList=new ArrayList<>();
                            for (Student student : studentList) {
                                if (student.getName().toLowerCase().equals(tempName.toLowerCase())) {
                                    studentList.remove(student);
                                }
                            }
                            int finalSize = studentList.size();
                            if (finalSize - initalSize == 0) {
                                System.out.println("No student with name: " + tempName);
                            } else {
                                System.out.println("Student(s) with name " + tempName + " is deleted.");
                            }
                        }
                    } else {
                        System.out.println("Cancel Operation");
                    }
                    break;
                case "3":
                    System.out.println("Student_name : Mark");
                    for (Student student : studentList) {
                        System.out.println(student.toString());
                    }
                    break;
                case "4":
                    System.out.print("Please input student name to find: ");
                    tempName=scanner.next();
                    int initalSize=studentList.size();
                    int count=0;
                    if(initalSize==0) {
                        System.out.println("No student in the list yet!");
                    }else {
                        for (Student student : studentList) {
                            if (student.getName().toLowerCase().equals(tempName.toLowerCase())) {
                                System.out.println("Founded: "+student.toString());
                                count++;
                            }
                        }
                    }
                    if(count==0){
                        System.out.println("No student with name: " + tempName);
                    }
                    break;
                case "5":
                    Collections.sort(studentList,new SortStudentByMark());
                    System.out.println("Student_name : Mark");
                    for (Student student : studentList) {
                        System.out.println(student.toString());
                    }
                    break;
                default:
                    System.out.println("Command is not available, please choose 1 to 5 only.");
                    break;
            }
            System.out.print("Press any key then Enter to continue (press q to exit): ");
            nextRound = scanner.next();
        }
    }
}