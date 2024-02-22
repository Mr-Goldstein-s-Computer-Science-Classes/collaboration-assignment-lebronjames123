import java.util.ArrayList;
public class Student
{
    private String name;
    private ArrayList<String> assignmentNames;
    private ArrayList<Double> assignmentGrades;
    private double grade;

    public Student(String name)
    {
        this.name = name;
        this.assignmentNames = new ArrayList<String>();
        this.assignmentGrades = new ArrayList<Double>();
    }
    public void addAssignment(String assignmentName)
    {
        assignmentNames.add(assignmentName);
        assignmentGrades.add(null);
    }
    public void  gradeAssignment(String assignment, double grade)
    {
        int index = assignmentNames.indexOf(assignment);
        if(index != -1)
        {
            assignmentGrades.set(index,grade);
        }
    }

    public Double getAssignmentGrade(String assignment)
    {
        int index = assignmentNames.indexOf(assignment);
        if(index != -1)
        {
            double assignmentGrade = assignmentGrades.get(index);
            return assignmentGrade;
        }
        return null;
    }
    public double getOverallGrade()
    {
        double total = 0.0;
        int numGradedAssignments = 0;
        for(Double grade: assignmentGrades)
        {
            if(grade != null)
            {
                total += grade;
                numGradedAssignments++;
            }
        }
        return total/numGradedAssignments;
    }
    public String toString()
    {
        return "Name: " + name + "Average: " + getOverallGrade();
    }


    public double getGrade()
    {
     return grade;
    }
    public String getName()
    {
        return name;
    }

    public void setGrade(double grade)
    {
        this.grade = grade;
    }

}
