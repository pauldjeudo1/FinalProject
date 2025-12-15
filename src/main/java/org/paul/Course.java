package org.paul;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private List<Assignment> assignments;
    private List<Student> registeredStudents;
    private static int nextId = 1;

    public Course(String courseName, double credits, Department department) {
        this.courseName = Util.toTitlecase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.courseId = "C-" + department.getDepartmentId()
                + "-" + String.format("%02d", nextId++);
    }

    public boolean isAssignmentWeightValid() {
        double sum = 0;

        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }

        return Math.abs(sum - 100.0) < 0.0001;
    }

    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }

        registeredStudents.add(student);

        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }

        return true;
    }

    public int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            double total = 0;

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                if (score != null) {
                    total += score * (assignment.getWeight() / 100.0);
                }
            }

            averages[i] = (int) Math.round(total);
        }

        return averages;
    }

    public boolean addAssignment(String assignmentName, double weight) {
        Assignment assignment = new Assignment(assignmentName, weight);

        for (int i = 0; i < registeredStudents.size(); i++) {
            assignment.getScores().add(null);
        }

        assignments.add(assignment);
        return true;
    }

    public void generateScores() {
        Random random = new Random();

        for (Assignment a : assignments) {
            for (int i = 0; i < registeredStudents.size(); i++) {
                a.getScores().set(i, random.nextInt(41) + 60);
            }
        }
    }

    public void displayScores() {
        System.out.println("Course: " + courseName + " (" + courseId + ")");
        System.out.print("\t\t");

        for (Assignment a : assignments) {
            System.out.print(a.getAssignmentName() + "\t");
        }
        System.out.println("Final Score");

        int[] finalScores = calcStudentsAverage();

        for (int i = 0; i < registeredStudents.size(); i++) {
            Student s = registeredStudents.get(i);
            System.out.print(s.getStudentName() + "\t");

            for (Assignment a : assignments) {
                System.out.print(a.getScores().get(i) + "\t");
            }

            System.out.println(finalScores[i]);
        }

        System.out.print("Average\t");

        for (Assignment a : assignments) {
            System.out.print((int) a.calcAssignmentAvg() + "\t");
        }

        System.out.println();
    }

    public String toSimplifiedString() {
        return courseId + " - " + courseName + " (" + credits + " credits, " + department.getDepartmentName() + ")";
    }

    public String toString() {
        String result = "Course ID: " + courseId + "\n" +
                "Course Name: " + courseName + "\n" +
                "Credits: " + credits + "\n" +
                "Department: " + department.getDepartmentName() + "\n" +
                "Assignments:\n";

        for (Assignment assignment : assignments) {
            result += "  " + assignment + "\n";
        }

        result += "Registered Students:\n";

        for (Student student : registeredStudents) {
            result += "  " + student.toSimplifiedString() + "\n";
        }

        result += "Assignment weight valid: " + isAssignmentWeightValid();

        return result;
    }

}
