package Week01;

//높이와 너비를 입력 받아서 삼각형의 넓이를 출력하는 프로그램을 작성하시오.

import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("삼각형의 높이는>>");
        double height=sc.nextDouble();

        System.out.print("삼각형의 밑변은>>");
        double width=sc.nextDouble();

        double area=height*width/2;
        System.out.print("삼각형의 넓이는 "+area);

        //Integer 타입으로 받게 되면 정수*정수=정수이므로 소수점 이하가 탈락되어 출력됨 (버그성의 문제들=컴파일할 때 나타나는 문제들)
        //->double 또는 float로 변화시켜야 함
    }
}
