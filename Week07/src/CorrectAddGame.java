//10 이하의 랜덤한 두 개의 숫자가 출력되고, 두 숫자의 합을 맞추는 프로그램입니다.
//숫자 출력 2초 후에 정답을 입력하라는 문자열이 출력되며 '종료'를 입력할 시 프로그램이 종료됩니다.
//주석을 참고하여 코드의 빈 부분을 수정해주세요. (총 3문제)

import java.util.Random;
import java.util.Scanner;

class CountdownThread extends Thread {
    private int seconds; //스레드가 수행할 카운트다운의 초를 나타내는 멤버 변수

    public CountdownThread(int seconds) { //생성자
        this.seconds=seconds; //초를 전달받아 내부 멤버 변수에 할당하여 초기화
    }

    //[문제 1] 스레드가 시작될 때 실행되는 부분입니다.
    public void run() { //Thread 클래스에서 상속받은 메서드
        try {
            for (int i = seconds; i > 0; i--) {
                System.out.println(i + "초 남았습니다."); //현재 남은 초 출력
                Thread.sleep(1000); //1초 동안 스레드 일시 중지 (sleep 메서드 통해)
            }
    } catch (InterruptedException e) { //멀티스레딩 환경에서 여러 스레드 동시에 실행될 수 있음
    //서로 다른 스레드가 중단 및 인터럽트 가능->InterruptedException
    //(주로 스레드가 블로킹 메서드에서 대기하다 다른 스레드에 의해 인터럽트되었을 때 발생)
        e.printStackTrace(); //예외 처리하고 스택 추적 정보 출력 (안정성을 높임)
    }
}
}

public class CorrectAddGame {
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
            CountdownThread countdownThread = new CountdownThread(2);
            //카운트다운이 2초 동안 진행되도록 설정하기
            countdownThread.start();
            //클래스의 메서드를 호출하여 스레드 실행하기

            //[문제 3] 스레드가 완료될 때까지 대기하는 부분입니다.
            try {
                countdownThread.join();
                //스레드가 종료될 때까지 현재 실행 중인 스레드 일시 정지
            } catch (InterruptedException e) { //중단 예외 처리
                e.printStackTrace();
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