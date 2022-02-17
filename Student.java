package LambdaAndStreamAPI;

import java.util.*;

public class Student {


    private String firstName;
    private String lastName;
    private int courseNumber;
    private List<Integer> rating;


    public Student(String firstName, String lastName, int courseNumber, List<Integer> rating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseNumber = courseNumber;
        this.rating = rating;
    }


    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public List<Integer> getRating() {
        return rating;
    }

    public void setRating(List<Integer> rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Student{" +
               "firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", courseNumber=" + courseNumber +
               ", rating=" + rating +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return courseNumber == student.courseNumber && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(rating, student.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, courseNumber, rating);
    }

    static class StudentHelper {

        private String fullName;
        private Double avgGrade;

        public StudentHelper(String fullName, Double avgGrade) {
            this.fullName = fullName;
            this.avgGrade = avgGrade;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public Double getAvgGrade() {
            return avgGrade;
        }

        public void setAvgGrade(Double avgGrade) {
            this.avgGrade = avgGrade;
        }

        @Override
        public String toString() {
            return
                    "fullName='" + fullName + '\'' +
                    ", avgGrade=" + avgGrade +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StudentHelper that = (StudentHelper) o;
            return Objects.equals(fullName, that.fullName) && Objects.equals(avgGrade, that.avgGrade);
        }

        @Override
        public int hashCode() {
            return Objects.hash(fullName, avgGrade);
        }
    }
}

