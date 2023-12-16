/*동물원에 동물 4마리가 있다.
각 동물은 울음소리가 다르고 3마리의 동물은 동시에 운다.
나머지 1마리 동물은 3마리 동물이 모두 울고 나서 마지막에 운다.
Runnable 인터페이스로 멀티쓰레드를 구현하고 반드시 join()을 사용한다.
(각 동물은 10번씩만 운다.)
*/
/*실행결과:
애옹
어흥
멍멍
어흥
애옹
멍멍
어흥
애옹
멍멍
어흥
애옹
멍멍
애옹
멍멍
어흥
애옹
멍멍
어흥
애옹
어흥
멍멍
애옹
멍멍
어흥
멍멍
애옹
어흥
애옹
어흥
멍멍
꿀꿀
꿀꿀
꿀꿀
꿀꿀
꿀꿀
꿀꿀
꿀꿀
꿀꿀
꿀꿀
꿀꿀*/

class Animals extends Thread { //Thread 상속
    private String sounds; //동물의 울음소리를 저장할 String 타입 변수 sounds
    public Animals(String sounds) { //생성자
        super();
        this.sounds = sounds;
    }

    public void run() {
        //[문제1]0.5초 단위로 실행
        try{
            for(int i=0;i<10;i++){
                System.out.println(sounds);
                Thread.sleep(500);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    //동물 울음소리 출력 메소드
    private void printSound(long millis) {
        for(int i=0; i<10; i++) { //10번 반복
            System.out.println(sounds); //동물 울음소리 출력
            try {
                Thread.sleep(millis);
            }catch (InterruptedException e) { //[문제2]에러의 발생근원지를 찾아서 단계별로 에러를 출력하는 예외처리 실행
                e.printStackTrace();
            }
        }
    }
}
public class AnimalSounds {
    public static void main(String[] args) {
        //[문제3]Animals 객체 네개 생성(동물 네마리 생성)
        Animals cat=new Animals("애옹");
        Animals tiger=new Animals("어흥");
        Animals dog=new Animals("멍멍");
        Animals pig=new Animals("꿀꿀");

        //[문제4]3마리의 쓰레드 시작시키기
        cat.start();
        tiger.start();
        dog.start();

        //[문제5]join으로 우선순위를 주어서 세마리의 울음소리가 끝난 후 한마리 실행되게 함
        try{
            cat.join();
            tiger.join();
            dog.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        //[문제6]한마리 실행되게 함
        pig.start();
    }
}
