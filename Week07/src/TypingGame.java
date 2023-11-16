//다음의 코드는 텍스트기반의 타자연습게임인데 WordGenerator라는 쓰레드가 Vector에 2초마다 단어를 하나씩 추가하고,
//사용자가 단어를 입력하면 Vector에서 일치하는 단어를 삭제하도록 되어 있다.
//맨 아래 기재된 출력값을 참고하여 코드를 작성하는 문제이다. (총 4문제)
import java.util.*;

public class TypingGame {
    Vector words = new Vector(); //Vector는 ArrayList와 동일한 내부구조를 가지고 있음
    //Vector는 동기화된 메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 이 메소드들을 실행할 수 없고,
    //하나의 스레드가 실행을 완료해야만 다른 스레드들이 실행할 수 있음
    //그래서 멀티 스레드 환경에서 안전하게 객체를 추가하고 삭제할 수 있음
    String[] data = {"태연", "유리", "윤아", "효연", "수영", "서현", "티파니", "써니", "제시카"};
    int interval = 2 * 1000; // 2초
    //[문제1] score 변수를 오류 나지 않도록 작성하세요.
    int score;
    WordGenerator wg = new WordGenerator();

    public static void main(String args[]) {
        TypingGame game = new TypingGame();
        game.wg.start();

        Vector words = game.words;

        while (true) {
            System.out.println(words);
            String prompt = ">>";
            System.out.print(prompt);

            // 화면으로부터 라인단위로 입력받는다.
            Scanner s = new Scanner(System.in);
            String input = s.nextLine().trim();
            int index = words.indexOf(input);

            if(input.equals("그만")) {
                game.wg.interrupt();;
                //[문제2] 이전의 상태로 복귀시키는 코드를 작성하세요. (힌트:인터럽트)
                System.out.println("total Score:" + game.score);
                System.out.println("게임 종료");
                break;
            }

            if (index != -1) {
                System.out.println("+10점!");
                game.score+=10;
                words.remove(index);
            }

        }

    }

    public class WordGenerator extends Thread {
        public void run() {
            while (true) {
                //[문제3]배열 data의 값 중 하나를 임의로 선택해서 word에 추가하는 코드를 작성하세요.
                String word=data[(int)(Math.random()*data.length)];
                words.add(word);

                try {
                    //[문제4]interval을 일시중단(=주어진 시간 동안 단어 생성 중단)하는 코드를 작성하세요.
                    Thread.sleep(interval);
                } catch (Exception e) {
                    break;
                }
            }
        }
    }
}


/* 출력 값
[태연]
>>태연
+10점!  ---------------------> 2초마다 단어 랜덤으로 추가

[제시카]
>>제    ---------------------> 잘못 입력했을시, 다음 문제에 추가됌

[제시카, 티파니, 태연] ---------> 제시카 추가된 문제 출력, 2초 지나면 문제 1개씩 증가함
>>티

[제시카, 티파니, 태연, 유리] ----> 티파니 추가된 문제 출력, 2초 지나면 문제 1개씩 증가함
>>그만   ---------------------> 그만 입력시, 문제는 종료되며 제대로 입력한 문제에 대한 점수 출력

total Score:40
게임 종료

 */