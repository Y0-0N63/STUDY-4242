//배열과 for문을 이용하는 예제

//1~5까지의 숫자 중에 랜덤으로 숫자를 입력하여 lotto에 입력되어 있는 순서대로 숫자 맞추기
//사용자가 입력한 값과 lotto(랜덤으로 돌아간 수)에 입력된 값이 2개 이상 맞으면 정답 처리

//코드 채워넣기
//[문제1] 5크기의 배열을 생성해라
//[문제2] 1~5가 아닌 숫자를 입력하였을때 다시 입력하도록 코드를 작성하여라
//[문제3] user[x]가 0~5까지의 숫자라면, 랜덤으로 lotto 변수가 출력되도록 하여라
//[문제4] for문을 올바르게 사용하여라 (for문이 필요한 위치에 두기)

import java.util.Scanner;
import java.util.Random;

public class Lotto {
    public static void main(String[] args) { //메인메서드
        Scanner scanner = new Scanner(System.in); //사용자 입력
        Random r=new Random();

        //[문제1] 5크기의 배열을 생성해라
        //배열 lotto 5만큼 생성
        int[] lotto=new int[5];
        //배열 user 5만큼 생성
        int[] user=new int[5];

        int cnt = 0; //cnt 값 초기화

        System.out.println("1~5까지의 숫자를 입력하세요."); //"1~5까지의 숫자를 입력하세요." 문구 출력

        for (int x=0;x<5;x++) { //반복문 (x=0으로 초기화, x는 0~4까지 총 5회 실행)
            user[x] = scanner.nextInt(); //user[x]는 사용자가 입력한 값

            //[문제2] 1~5가 아닌 숫자를 입력하였을때 다시 입력하도록 코드를 작성하여라
            while (user[x]<1||user[x]>5){
                System.out.println("1~5까지의 숫자를 올바르게 입력하세요."); //"1~5까지의 숫자를 입력하세요." 문구 출력
                System.out.println("범위 벗어난 숫자 제외 하고 이어서 count 됩니다."); //"범위 벗어난 숫자 제외 하고 이이서 count 됩니다." 문구 출력
                user[x]=scanner.nextInt();
            }

            //[문제3] user[x]가 0~5까지의 숫자라면, 랜덤으로 lotto 변수가 출력되도록 하여라
            //lotto[x]에 랜덤 숫자 출력
            lotto[x]=r.nextInt(5)+1; //0~4까지 임의의 숫자 생성 후 +1=>1~5

            //[문제4] for문을 올바르게 사용하여라 (for문이 필요한 위치에 두기)
            if (lotto[x] == user[x]) { //만약 lotto[x] == user[x]라면,
                cnt = cnt + 1; //cnt 증가
            }
        }

        for(int x=0;x<5;x++){
            System.out.print(user[x] + " "); //lotto[x] 값 출력
        }
        System.out.println(""); //한줄 공백으로 출력

        for(int x=0;x<5;x++){
            System.out.print(lotto[x] + " "); //lotto[x] 값 출력
        }
        System.out.println(""); //한줄 공백으로 출력

        if (cnt >= 2) { //cnt 가 2보다 크다면,
            System.out.println(""); //한줄 공백으로 출력
            System.out.println("====================");
            System.out.println("당첨"); //"당첨" 문구 출력
        } else { //만약 cnt가 2보다 크지 않다면,
            System.out.println(""); //한줄 공백으로 출력
            System.out.println("====================");
            System.out.println("꽝"); //"실패" 문구 출력
        }
    }
}


/*
case1)
1~5까지의 숫자를 입력하세요.
        1
        2
        2
        5
        1
        1 2 5 5 2
        1 2 2 5 1
        ====================
        당첨 //2개 이상 숫자가 맞다면 당첨

case2)
1~5까지의 숫자를 입력하세요.
        1 //배열 0
        2 //배열 1
        3 //배열 2
        9 //x
1~5까지의 숫자를 올바르게 입력하세요.
범위 벗어난 숫자 제외 하고 이이서 count 됩니다.
        2 //배열 3
        5 //배열 4
        5 5 2 0 2
        1 2 3 2 5
        ====================
        꽝 //2개 이상 숫자가 맞지 않다면 꽝

 */


