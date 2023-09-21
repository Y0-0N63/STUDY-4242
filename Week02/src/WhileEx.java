import java.util.Scanner;

public class WhileEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("출력하고자 하는 줄의 개수를 입력하세요.>>");
        int num = sc.nextInt();

        int i=1; //i를 1로 초기화
        while (i<=num) { //i가 num보다 이하인 동안 (num번 만큼)
            int j=1; //j를 1로 초기화
            while (j<=i) { //j가 i보다 이하인 동안 (j가 i번 만큼)
                System.out.print("*");
                j++;
            }
            System.out.println(); //한 줄이 끝날 때마다 줄 바꿈
            i++;
        }
    }
}