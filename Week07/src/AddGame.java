//10 이하의 랜덤한 두 개의 숫자가 출력되고, 두 숫자의 합을 맞추는 프로그램입니다.
//숫자 출력 2초 후에 정답을 입력하라는 문자열이 출력되며 '종료'를 입력할 시 프로그램이 종료됩니다.
//주석을 참고하여 코드의 빈 부분을 수정해주세요. (총 3문제)

//출력 예시
//정답인 경우
//        3과 1의 합은?
//        2초 남았습니다.
//        1초 남았습니다.
//        답을 입력하세요. '종료'를 입력하면 프로그램이 종료됩니다.>>4
//        정답입니다!
//오답인 경우
//        10과 3의 합은?
//        2초 남았습니다.
//        1초 남았습니다.
//        답을 입력하세요. '종료'를 입력하면 프로그램이 종료됩니다.>>2
//        오답입니다. 정답은 13입니다.
//종료를 입력했을 경우
//        1과 6의 합은?
//        2초 남았습니다.
//        1초 남았습니다.
//        답을 입력하세요. '종료'를 입력하면 프로그램이 종료됩니다.>>종료
//        프로그램을 종료합니다.

import java.util.Random;
import java.util.Scanner;

class CountdownThread extends Thread {
    private int seconds;

    public CountdownThread(int seconds) {
        this.seconds=seconds;
    }

    //[문제 1] 스레드가 시작될 때 실행되는 부분입니다.
    public void run() {
        try {
            //남은 시간 출력하기
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class AddGame {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random r=new Random();

        boolean continueGame=true;

        while (continueGame){
            int num1=r.nextInt(10)+1;
            int num2=r.nextInt(10)+1;
            int correctAnswer=num1+num2;

            System.out.println(num1+"과 "+num2+"의 합은?");

            //[문제 2] CountdownThread 클래스를 이용하여 새로운 스레드를 생성하고 시작하는 부분입니다.
            //카운트다운이 2초 동안 진행되도록 설정하기
            //클래스의 메서드를 호출하여 스레드 실행하기

            //[문제 3] 스레드가 완료될 때까지 대기하는 부분입니다.
            try {
                //스레드가 종료될 때까지 현재 실행 중인 스레드 일시 정지
            } catch ( ) { //중단 예외 처리

            }

            System.out.print("답을 입력하세요. '종료'를 입력하면 프로그램이 종료됩니다.>>");
            String userAnswer = sc.next();

            if (userAnswer.equalsIgnoreCase("종료")) {
                System.out.println("프로그램을 종료합니다.");
                continueGame=false;
            } else {
                try {
                    int parsedUserAnswer=Integer.parseInt(userAnswer);
                    if (parsedUserAnswer==correctAnswer) {
                        System.out.println("정답입니다!");
                    } else {
                        System.out.println("오답입니다. 정답은 "+correctAnswer+"입니다.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("숫자를 입력해주세요.");
                }
            }
        }
        sc.close();
    }
}