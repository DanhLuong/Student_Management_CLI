import java.util.Comparator;

public class SortStudentByMark implements Comparator<Student>{
        public int compare(Student a, Student b)
        {

            return a.getMark()-b.getMark();
        }
}
