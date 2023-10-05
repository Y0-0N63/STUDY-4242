/*
"그만...!"이 입력될 때까지 배우이름과 작품을 입력받아 저장하고 다시 배우이름을 입력받아 작품를 출력하는 프로그램을 작성하세요.
해당 연예인(배우)를 보고 배우의 대표작을 맞추는 게임입니다.(키(Key)는 배우 이름이고 값(Value)은 대표작품입니다)
 오류 부분 또는 비어있는 부분을 채우시면 됩니다!(총 4문제)
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BestPerformanceGame {

    private HashMap<String,String> store=new HashMap<String,String>();
    private Scanner sc = new Scanner(System.in);

    public BestPerformanceGame() {
        //store에 6명의 배우와 대표작품을 입력하여 초기화
        //이 6개는 이미 입력되어있음
        store.put("박은빈","이상한변호사우영우");
        store.put("신혜선", "서른이지만열입곱입니다");
        store.put("박보검","응답하라1988");
        store.put("한소희","부부의세계");
        store.put("강동원", "전우치");
        store.put("박서준", "쌈마이웨이");
    }
    private void error(String msg) {
        System.out.println(msg);
    }
    public void run() {
        System.out.println("-----지금부터 연예인 대표 작품 맞추기 게임을 시작합니다!~-----");

        while (true) {
            System.out.println("입력:1,퀴즈:2,종료:3 ->");
            int menu =sc.nextInt();
            switch(menu) {
                case 1:Input();
                    break;
                case 2:Quiz();
                    break;
                case 3:Finish();
                    return;

                default:
                    error("잘못된 입력입니다.");
            }
        }
    }
    //입력(입력 되어있는 배우와 작품이외에 배우와 작품 추가하기)
    private void Input() {
        int N =store.size();
        System.out.println("현재"+N+"개 배우와 대표 작품이 입력되었습니다.");

        //[문제 1] 현재 store에 등록된 6개의 배우와 대표작품 다음으로 입력해야 할 7번째 배우와 대표작품을 입력할 수 있도록 코딩하기
        while(true) {
            //[문제 1]에 이어지는 부분임
            System.out.println("배우의 이름을 입력하세요. '그만...!'을 입력하면 선택 창으로 되돌아갑니다.>>");
            String entertainer  = sc.next();
            if(entertainer.equals("그만...!")) { //그만...!을 입력하면 다시 메뉴를 선택할 수 있도록 돌아간다.
                break;
            }

            if(store.containsKey(entertainer)) {
                System.out.println(entertainer+"은(는) 이미 존재합니다");
                //[문제 2] 이미 존재하는 배우가 있을 때 실행은 즉시 중단하지만 반복은 지속해야 함
                continue;
            }

            System.out.println("해당 배우의 대표 작품을 입력하세요.>>");
            String bestperformance =sc.next();
            store.put(entertainer, bestperformance);
            N++;
        }
    }
    //퀴즈(원래 있던 값 이외에 내가 추가적으로 입력했던 값을 포함하여 랜덤으로 배우가 나오면 해당 대표작품을 맞추면 된다)
    private void Quiz(){
        //모든 연예인(키)을 알아낸다
        Set<String>keys =store.keySet();
        Object[]array =(keys.toArray());

        while(true) {
            //[문제 3]연예인 중 하나를 택한다.(즉,랜덤한 위치 결정) 이때, 변수 이름은 index로 하기!
            int index=(int)(Math.random()*array.length);
            //Math.random():0이상 1 미만의 무작위 부동 소수점 숫자 생성
            //(int):부동 소수점 숫자->정수 변환 (소수점 이하 값 삭제)

            //문제(연예인 이름)와 정답(대표작)을 결정한다.
            String question=(String)array[index];
            String answer = store.get(question);

            //문제 출력하기
            System.out.println(question+"의 대표작은?");

            //사용자 입력
            String user =sc.next();
            if(user.equals("그만...!")) { //그만...!을 입력하면 다시 메뉴를 선택할 수 있도록 돌아간다.
                break;
            }
            //[문제 4] 만약 정답이 user가 입력한 것과 같다면 딩~동~댕~동을 출력하기
            else if (user.equals(answer)) {
                System.out.println("딩~동~댕~동");
            }
            else //정답이 user가 입력한 것과 달랐을 때
                System.out.println("때에에엥! 정말 그 작품이라고 생각하시나요?! 더 유명한 거 있자나요~!");
        }
    }
    //종료
    private void Finish() {
        System.out.println("게임을 종료합니다!");
    }
    public static void main(String[] args) {
        BestPerformanceGame game = new BestPerformanceGame();
        game.run();

    }

}




