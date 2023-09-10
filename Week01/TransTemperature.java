package Week01;

//빈 칸을 채우기 (총 6줄)
//섭씨 온도와 화씨 온도를 변환하여 출력
//입력 온도가 섭씨 온도인지, 화씨 온도인지 선택하기->온도 입력->입력한 온도 단위의 반대 단위로 계산하여 출력->계산 재실행 여부 출력
//섭씨 온도=(화씨 온도-32)*5/9 //화씨 온도=(섭씨 온도*9/5)+32

import java.util.Scanner;

public class TransTemperature {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while(true) {
            System.out.print("입력할 온도가 섭씨 온도면 C, 화씨 온도면 F를 입력하세요.>>");
            String fc=sc.next();

            if(fc.equals("F")) {
                System.out.println("화씨 온도(°F)를 섭씨 온도(°C)로 변환합니다.");
                System.out.print("화씨 온도(°F)를 입력하세요.>>");
                //화씨 온도(fahrenheit)를 입력받음
                //섭씨 온도로 환산한 화씨 온도(fahrenheitToCelsius)=(화씨 온도-32)*5/9
                //계산한 결과 출력하기
            }
            else if (fc.equals("C")) {
                System.out.println("섭씨 온도(°C)를 화씨 온도(°F)로 변환합니다.");
                System.out.print("섭씨 온도(°C)를 입력하세요.>>");
                //섭씨 온도(celsius)를 입력받음
                //화씨 온도로 환산한 섭씨 온도(celsiusToFahrenheit)=(섭씨 온도*9/5)+32
                //계산한 결과 출력하기
            }
            else {
                System.out.println("다시 입력하세요. (C/F)");
                continue;
            }

            System.out.print("다시 계산하시겠습니까? (yes/no)>>");
            String yn=sc.next();
            if(yn.equals("yes"))
                continue;
            else if (yn.equals("no"))
                System.out.println("프로그램을 종료합니다.");
            break;
        }
    }
}

