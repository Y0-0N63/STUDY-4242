package Week01;

//자바로 표준입력으로 임의의 문자열을 입력받고 그 문자열에서 숫자만 골라 출력하는 프로그램을 만드시오.

import java.util.Scanner;

public class SelectNum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("문자열을 입력하시오. >> ");
        String input=sc.nextLine();

        System.out.println("문자열 내 숫자는 ");

        for(int i=0;i<input.length();i++){
            char c=input.charAt(i);
            //charAt()=문자열에서 지정된 인덱스의 특정 문자를 가지고 옴
            if(Character.isDigit(c)){ //c(i번째 문자)가 숫자라면
                //isDigit()=Character클래스의 함수
                System.out.print(c);
            }
        }

        sc.close();
    }
}

