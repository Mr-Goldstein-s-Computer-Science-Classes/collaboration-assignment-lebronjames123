import java.util.ArrayList;
import java.util.List;

class Gradebook {

    private List<Student> students;
    private List<String> assignments;

    public Gradebook() {
        students = new ArrayList<>();
        assignments = new ArrayList<>();
    }

    public void createStudent(String name) {
        students.add(new Student(name));
    }


    public void addAssignment(String assignment) {
        assignments.add(assignment);
        for (Student student : students) {
            student.addAssignment();
        }
    }

    public void gradeAssignment(String assignment, String studentName, double grade) {
        Student student = getStudent(studentName);
        if (student != null) {
            int assignmentIndex = assignments.indexOf(assignment);
            if (assignmentIndex != -1) {
                student.gradeAssignment(String.valueOf(assignmentIndex), grade);
            }
        }
    }

    public double getAverageGrade(String assignment) {
        int assignmentIndex = assignments.indexOf(assignment);
        if (assignmentIndex != -1) {
            double total = 0;
            int count = 0;
            for (Student student : students) {
                double grade = student.getAssignmentGrade(assignmentIndex);
                if (grade != -1) {
                    total += grade;
                    count++;
                }
            }
            return count == 0 ? 0 : total / count;
        } else {
            return 0;
        }
    }

    public double getMinimumGrade(String assignment) {
        int assignmentIndex = assignments.indexOf(assignment);
        if (assignmentIndex != -1) {
            double min = Double.MAX_VALUE;
            for (Student student : students) {
                double grade = student.getAssignmentGrade(assignmentIndex);
                if (grade != -1 && grade < min) {
                    min = grade;
                }
            }
            return min == Double.MAX_VALUE ? 0 : min;
        } else {
            return 0;
        }
    }

    public double getMaximumGrade(String assignment) {
        int assignmentIndex = assignments.indexOf(assignment);
        if (assignmentIndex != -1) {
            double max = Double.MIN_VALUE;
            for (Student student : students) {
                double grade = student.getAssignmentGrade(assignmentIndex);
                if (grade > max) {
                    max = grade;
                }
            }
            return max == Double.MIN_VALUE ? 0 : max;
        } else {
            return 0;
        }
    }

    public double getAverageOverall() {
        double total = 0;
        int count = 0;
        for (Student student : students) {
            double grade = student.getOverallGrade();
            if (grade != -1) {
                total += grade;
                count++;
            }
        }
        return count == 0 ? 0 : total / count;
    }

    public double getMaxOverall() {
        double max = Double.MIN_VALUE;
        for (Student student : students) {
            double grade = student.getOverallGrade();
            if (grade > max) {
                max = grade;
            }
        }
        return max == Double.MIN_VALUE ? 0 : max;
    }

    public double getMinOverall() {
        double min = Double.MAX_VALUE;
        for (Student student : students) {
            double grade = student.getOverallGrade();
            if (grade != -1 && grade < min) {
                min = grade;
            }
        }
        return min == Double.MAX_VALUE ? 0 : min;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Students:\n");
        for (Student student : students) {
            sb.append(student.getName()).append(": ").append(student.getOverallGrade()).append("\n");
        }
        sb.append("\nAssignments:\n");
        for (String assignment : assignments) {
            sb.append(assignment).append("\n");
        }
        return sb.toString();
    }

    public Student getStudent(String studentName) {
        for (Student student : students) {
            if (student.getName().equals(studentName)) {
                return student;
            }
        }
        return null;
    }
}

