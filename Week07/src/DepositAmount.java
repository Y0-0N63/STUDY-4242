/* 문제:처음 잔액은 1000원으로 시작하여 100원씩 최종잔액이 2000원이 나올 때까지
  더합니다.그리고 100원씩 더할 때마다 입금 금액과 총 잔액이 나오도록 출력하는 문제입니다.
  단 0.5초마다 출력되어야 합니다.
  주석을 보고 빈 부분 또는 오류를 고쳐주세요.(총4문제)

 */
class BankAccount { //BankAccount 클래스를 만들기

    private int totalMoney; //필드
    //[문제1] 생성자에서 매개변수로 필드 초기화
    public BankAccount(int totalMoney){
        this.totalMoney=totalMoney;
    }
    public synchronized void deposit(int money) { //정수(입금금액) 하나를 매개변수로 받아
        totalMoney += money ; //totalMoney에 더해주는 deposit 메소드 만들기
    //synchronized->해당 메서드, 객체의 락 획득 (다른 스레드에서 접근할 때 객체의 락을 얻어야 함)
    //해당 메서드 전체 동기화된 블럭으로 만들고, 메서드 내 모든 코드 한 번에 한 스레드에 의해 실행
    //다른 스레드에서 접근 불가능
    //->deposit 접근 방지, 데이터 일관성 유지

        try {
			//[문제2] 0.5초 단위로 출력
            Thread.sleep(500);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("입금 금액 : " + money + " | 총 잔액 : " + totalMoney);
        //메소드는 동기화가 될 수 있도록 하고 입금금액과 총 잔액을 출력해준다.
    }

    // [문제3] 필드값을 얻을 수 있도록 getter메소드를 만든다.
    public int getTotalMoney(){
        return totalMoney;
    }
}

public class DepositAmount {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(1000); //BankAccount 클래스로부터 객체 생성
        Runnable run = new Runnable() { //Runnable 익명클래스를 만들어서

            @Override                   //run메소드를 오버라이딩
            public void run() {
                for(int i = 0; i < 5; i++) {
                    account.deposit(100); //BankAccount 객체의 deposit 메소드를 호출하도록 한다.
                }
            }
        };

        // [문제4] Runnable 익명객체를 생성자의 매개값으로 받는
        //Thread 객체 2개를 생성 후 start 메소드 호출하기
        Thread thread1=new Thread(run);
        Thread thread2=new Thread(run);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();

        }catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("최종잔액 : " + account.getTotalMoney());
    }
}


