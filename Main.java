package LambdaAndStreamAPI;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * Given a list of students with fields:
 * - Name
 * - Surname
 * - University course number
 * - List of grades for study
 *                                                   First Task
 *
 * Convert this list of students to an associative array, where the key is the course number and the value is:
 *
 *
 *
 * Average grade of students in this course who have more than 3 grades
 *
 *                                                  Second Task
 *
 * A list of students in this course, but only with the fields First Name and Last Name.
 * The list must be sorted by these two fields
 *
 *                                                  Third Task
 * 
 * Volume
 * ect with two fields:
 * - Sorted list of students from point 2
 * - The average grade of these students
 */

public class Main {
    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student("John", "Wick", 1, List.of(79, 85, 95, 74)),
                new Student("Taylor", "Smith", 2, List.of(99, 87, 85, 93)),
                new Student("Emmy", "Swift", 2, List.of(99, 87, 95, 93)),
                new Student("Billy", "Gun", 3, List.of(99, 100)),
                new Student("Jackie", "Williams", 3, List.of(99, 87, 95, 93)),
                new Student("Any", "Millie", 4, List.of(78, 80, 99, 76))
        );


        //FIRST TASK
        Map<Integer, Double> firstTask = students.stream()
                .filter(x -> x.getRating().size() > 3)
                .collect(groupingBy(Student::getCourseNumber, mapping(x -> x.getRating()
                        .stream()
                        .mapToDouble(Integer::doubleValue)
                        .average()
                        .getAsDouble(), averagingDouble(x -> x))));


        //SECOND TASK
        Map<Integer, List<String>> secondTask = students.stream()
                .sorted(Comparator.comparing(Student::getFullName))
                .collect(groupingBy(Student::getCourseNumber, mapping(x -> x.getFullName(), toList())));


        //THIRD TASK
        Map<Integer, Student.StudentHelper> fullNameAndAvgScore = new HashMap<>();

        for (Student student : students) {
            fullNameAndAvgScore.put(student.getCourseNumber(), new Student.StudentHelper(student.getFullName(),
                    student.getRating()
                            .stream()
                            .mapToInt(Integer::intValue)
                            .average()
                            .getAsDouble()));
        }

    }
}
