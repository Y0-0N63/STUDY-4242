//A와 B가 5초 동안 숨고 이후 술래가 5초를 다 셌다는 말과 함께 찾으러 가는 숨바꼭질 프로그램입니다.
//주석을 참고하여 코드의 빈 부분을 수정해주세요. (총 4문제)

//아래는 출력 결과의 예시입니다.
//숨바꼭질 게임을 시작합니다!
//A(이)가 숨고 있습니다.
//B(이)가 숨고 있습니다.
//술래가 1초를 셌습니다.
//A(이)가 숨고 있습니다.
//B(이)가 숨고 있습니다.
//술래가 2초를 셌습니다.
//술래가 3초를 셌습니다.
//B(이)가 숨고 있습니다.
//B(이)가 다 숨었습니다!
//A(이)가 숨고 있습니다.
//A(이)가 다 숨었습니다!
//술래가 4초를 셌습니다.
//술래가 5초를 셌습니다.
//술래가 초를 다 셌습니다!
//술래가 찾으러 갑니다!

import java.util.Random;

class Seeker implements Runnable{

    @Override
    public void run(){
        try{
            //[문제 1] 1초가 지날 때마다 '술래가 n초를 셌습니다.'를 출력하기
            //술래는 1초에서 5초까지 세야 합니다.
            for(int i=1; i<=5; i++){
                Thread.sleep(1000);
                System.out.println("술래가 "+i+"초를 셌습니다.");
            }
            System.out.println("술래가 초를 다 셌습니다!");
            System.out.println("술래가 찾으러 갑니다!");
        }
        //[문제 2] 스레드에 인터럽트가 발생했을 때 사용할 수 있는 예외 객체가 담긴 코드 작성하기
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Hider implements Runnable{
    Random random=new Random();
    String name;

    Hider(String name){
        this.name=name;
    }

    @Override
    public void run(){
        try{
            //[문제 3] 1초~5초 사이의 랜덤한 시간 동안 숨기 (Random 클래스 사용)
            for(int i=0;i<random.nextInt(5);i++){
                Thread.sleep(1000);
                System.out.println(name+"(이)가 숨고 있습니다.");
            }
            System.out.println(name+"(이)가 다 숨었습니다!");
        }
        //[문제 2] 스레드에 인터럽트가 발생했을 때 사용할 수 있는 예외 객체가 담긴 코드 작성하기
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class CorrectHideAndSeek {
    public static void main(String[] args) {
        System.out.println("숨바꼭질 게임을 시작합니다!");

        //[문제 4-1] 각 클래스(Seeker, Hider)의 인스턴스 생성해준 후

        //[문제 4-2] 각 클래스의 객체들을 사용하여 플레이어에 대한 스레드 생성한 후 시작하기
        Seeker seeker=new Seeker();
        Hider hider1=new Hider("A");
        Hider hider2=new Hider("B");

        Thread seekerThread=new Thread(seeker);
        seekerThread.start();

        Thread hider1Thread=new Thread(hider1);
        hider1Thread.start();

        Thread hider2Thread=new Thread(hider2);
        hider2Thread.start();
    }
}