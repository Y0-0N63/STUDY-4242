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
            if(Character.isDigit(c)){
                System.out.print(c);
            }
        }

        sc.close();
    }
}

