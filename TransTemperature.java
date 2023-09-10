//표준입력으로 입력 받은 내용으로 연산한 결과를 출력하는 문제 만들기
//섭씨 온도와 화씨 온도를 변환하여 출력

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
                double fahrenheit=sc.nextDouble();
                double fahrenheitToCelsius=(fahrenheit-32)*5/9;
                System.out.println("섭씨 온도는 "+fahrenheitToCelsius+"°C입니다.");
            }
            else if (fc.equals("C")) {
                System.out.println("섭씨 온도(°C)를 화씨 온도(°F)로 변환합니다.");
                System.out.print("섭씨 온도(°C)를 입력하세요.>>");
                double celsius=sc.nextDouble();
                double celsiusToFahrenheit=(celsius*9/5)+32;
                System.out.println("화씨 온도는 "+celsiusToFahrenheit+"°F입니다.");
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
