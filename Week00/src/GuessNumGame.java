import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GuessNumGame {
    public static void main(String[] args) {
        Game.game();
    }
}

class Game {
    public static void game() {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        while (true) {
            int k = r.nextInt(10) + 1; //0~9까지 임의의 정수 생성 후 +1 => 1~1;
            int maxAttempt = 3; //최대 시도 횟수
            int attempt = 0;

            System.out.println("수를 결정하였습니다. 맞추어 보세요.");
            System.out.println("1-10");

            ArrayList<Integer> inputNumber = new ArrayList<>();

            while (attempt < maxAttempt) {
                if (sc.hasNextInt()) { //입력이 숫자인지 확인
                    int ans = sc.nextInt(); //사용자가 입력하는 숫자=ans

                    if (ans < 1 || ans > 10) {
                        System.out.println("범위에서 벗어났습니다. 다시 입력하세요.");
                    }
                    else{
                        attempt++;
                        if (ans < k) { //입력한 숫자가 정답보다 작음
                            System.out.println("낮음");
                        } else if (ans > k) { //입력한 숫자가 정답보다 큼
                            System.out.println("높음");
                        } else if (ans == k) { //입력한 숫자=정답
                            System.out.println("맞았습니다.");
                            System.out.print("입력한 숫자들: ");
                            for (int i = 0; i < inputNumber.size(); i++) {
                                System.out.print(inputNumber.get(i));
                                if (i < inputNumber.size() - 1) { //마지막에 입력한 숫자 외의 것만 뒤에 ,를 붙임
                                    System.out.print(", ");
                                }
                            }
                            System.out.print(", " + k); //마지막에 정답 숫자 더해주기
                            System.out.println();
                            PrintResult.saveGame(inputNumber, k); //입력한 숫자+정답 숫자->게임 결과 파일에 저장
                            break;
                        }
                    }

                    inputNumber.add(ans); //입력한 숫자 ArrayList(inputNumber)에 추가

                    if (attempt < maxAttempt) {
                        System.out.println("남은 기회는 " + (maxAttempt - attempt) + "번입니다.");
                    }

                    if (ans != k && attempt >= maxAttempt) { //답변이 정답이 아니고+시도 횟수가 3번 이상으로 넘어갈 시,
                        System.out.println("모든 기회를 사용했습니다. 정답은 " + k + "입니다.");
                        System.out.print("입력한 숫자들: ");
                        for (int i = 0; i < inputNumber.size(); i++) { //리스트 길이 만큼
                            System.out.print(inputNumber.get(i));
                            if (i < inputNumber.size() - 1) { //마지막에 출력되는 숫자에는 , 붙이지 X
                                System.out.print(", ");
                            }
                        }
                        System.out.println();
                        PrintResult.saveGame(inputNumber, k); //입력한 숫자+정답 숫자->게임 결과 파일에 저장
                    }
                } else {
                    //문자를 입력했을 때
                    System.out.println("숫자를 입력해주세요.");
                    sc.next(); //이전 입력 무시->다음 입력(숫자)을 기다림
                }
            }

            System.out.print("다시하시겠습니까? (yes/no) >> ");
            String yn = sc.next();
            if (yn.equals("yes"))
                continue;
            if (yn.equals("no"))
                break;
        }
    }
}

class PrintResult {
    static void saveGame(ArrayList<Integer> inputNumber, int k) {
        //사용자가 게임 중 입력한 값x` 저장한 리스트+정답 숫자 -> 게임 결과 파일에 저장
        try {
            FileWriter fout = new FileWriter("C:\\Temp\\game.txt"); //파일 열기
            fout.write("정답: " + k + ", 입력한 숫자: ");
            for (int i = 0; i < inputNumber.size(); i++) {
                fout.write(inputNumber.get(i).toString());
                if (i < inputNumber.size() - 1) {
                    fout.write(", ");
                }
            }
            fout.write("\n"); //줄 바꿈
            fout.close();
            System.out.println("c:\\Temp\\test.txt에 저장하였습니다.");
        } catch (IOException e) {
            System.out.println("입출력 오류. c:\\Temp\\test.txt에 저장하지 못했습니다.");
        }
    }
}
