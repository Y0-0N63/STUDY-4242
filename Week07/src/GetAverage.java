//학생들의 평균점수를 구하고, 평균점수 보다 높은 학생의 수를 구하는 코드

//출력값:
//The average score is 83.0
//3 students scored above average.

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

class Student { //[문제1]학생 객체를 생성할 클래스 정의. 학생의 이름과 점수를 가지는 필드가 있다.
    String name;
    int score;
    Student(String name, int score){
        this.name=name;
        this.score=score;
    }
}

public class GetAverage {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Alice", 85),
                new Student("Bob", 70),
                new Student("Charlie", 90),
                new Student("David", 75),
                new Student("Eve", 95)
        }; //앞서 정의한 학생 클래스로 여러개의 학생 객체를 만들어 배열에 담는다.

        double average = Arrays.stream(students)
                //[문제2]stream의 mapToInt() 메소드를 통해 학생들의 점수를 정수형으로 추출
                .mapToInt(Student -> Student.score)
                //[문제3]average() 메소드를 사용하여 평균을 계산하여 학생의 평균 점수를 나타내는 average 변수에 담는다.
                .average()
                .orElse(Double.NaN);

        long countAboveAverage = Arrays.stream(students)
                //[문제4]stream의 mapToInt() 메소드를 통해 학생들의 점수를 정수형으로 추출
                .mapToInt(Student->Student.score)
                //[문제5]filter() 메소드를 통해 평균보다 높은 점수를 가진 학생의 수를 계산하여 countAboveAverage 변수에 담는다.
                .filter(score->score>average)
                .count();

        System.out.println("The average score is " + average);
        System.out.println(countAboveAverage + " students scored above average.");
    }
}
