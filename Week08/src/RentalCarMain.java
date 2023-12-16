/*문제: 렌트카를 빌리기 위해 렌트카를 조회하고 렌트카를 찾아주는 문제입니다.
  빌릴 차 이름 순서는 스케줄링에 따라 랜덤입니다.
  오류가 생긴 부분을 주석을 참고하여 고쳐주세요.(총 4문제)
 */

//멀티스레드의 경우 여러스레드가 객체를 공유해서 작업을 하면 서로의 작업에
//영향을 주게된다. 이러한 일이 발생하지 않도록 한 스레드가 작업을 마치기 전까지
//다른스레드의 방해받지 않도록 하는것이 필요하다.


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class RentalCar {

    private String carName;
    private final Lock lock=new ReentrantLock();

    public  void getRentalCar(String carName) {
        //[문제1]
        //이것을 붙이면 메소드가 호출된 시점부터 해당 메소드가
        //포함된 객체의 lock을 얻어 작업을 수행하다가 종료되면 락을 반환합니다(알맞는 곳에 이것을 넣어 코딩해주세요)
        synchronized (this){
            System.out.println();
            System.out.println("찾으시는 렌트카 조회를 시작하겠습니다.");
            searchTime();
            this.carName = carName;
            System.out.println("렌터카가 있네요~~!!");
            System.out.println("렌트카 이름 : " + this.carName);

        }
    }

    public void searchTime() {

        for(int i = 0; i < 1000000; i++) {
            if(i == 100000) {
                System.out.println("잠시만 기다려주세요. 지금 조회중 입니다...");
            }
        }

    }

}

class Person extends Thread {

    //[문제2] new 키워드 없이 carName과 rentalCar 인스턴스(객체 생성)
    private String carName;
    private RentalCar rentalCar;

    public Person(String carName, RentalCar rentalCar) { //생성자
        this.carName = carName;
        this.rentalCar = rentalCar;
    }

    @Override
    public void run() {
        rentalCar.getRentalCar(carName);
    }


}




public class RentalCarMain {

    public static void main(String[] args) {
        //[문제3]try{} catch{}외에 다른 것으로 오류를 잡아주세요.

        RentalCar rentalCar = new RentalCar();
        //RentalCar 클래스로부터 RentalCar 객체 생성

	/*[문제4]
	Person 클래스로부터 Person 객체 생성
	차 종은 소나타,그렌져,벤츠,포르쉐 4종류
	각각의 변수이름은 Person1,Person2,Person3,Person4로 지정*/
        Person person1=new Person("소나타", rentalCar);
        Person person2=new Person("그렌져", rentalCar);
        Person person3=new Person("벤츠", rentalCar);
        Person person4=new Person("포르쉐", rentalCar);

        person1.start();
        person2.start();
        person3.start();
        person4.start();

    }

}

/*출력
 * 찾으시는 렌트카 조회를 시작하겠습니다.
잠시만 기다려주세요. 지금 조회중 입니다...
렌터카가 있네요~~!!
렌트카 이름 : 소나타

찾으시는 렌트카 조회를 시작하겠습니다.
잠시만 기다려주세요. 지금 조회중 입니다...
렌터카가 있네요~~!!
렌트카 이름 : 벤츠

찾으시는 렌트카 조회를 시작하겠습니다.
잠시만 기다려주세요. 지금 조회중 입니다...
렌터카가 있네요~~!!
렌트카 이름 : 포르쉐

찾으시는 렌트카 조회를 시작하겠습니다.
잠시만 기다려주세요. 지금 조회중 입니다...
렌터카가 있네요~~!!
렌트카 이름 : 그랜져
*/

