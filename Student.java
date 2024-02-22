import java.util.ArrayList;
public class Student
{
    private String name;
    private ArrayList<String> assignments;
    private double grade;
    public Student(String name)
    {
        this.name = name;
        this.assignments = new ArrayList<String>();
    }
    public void addAssignment(String assignmentName)
    {
        String assignment = new String(assignmentName);
        assignments.add(assignmentName);
    }
    public void  gradeAssignment(String assignment, double grade)
    {
        for(String a: assignments)
        {
            if(assignments.contains(assignment))
            {
                
            }
        }
    }

    public double getGrade()
    {
     return grade;
    }

    public void setGrade(double grade)
    {
        this.grade = grade;
    }

}
