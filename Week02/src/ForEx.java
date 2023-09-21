import java.util.Scanner;

public class ForEx {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("출력하고자 하는 줄의 개수를 입력하세요.>>");
        int num=sc.nextInt();

        for(int i=0;i<num;i++){ //num번 만큼 반복
            for(int j=0;j<=i;j++) //i(<=num)번 만큼 반복
                System.out.print("*");
            System.out.println(); //줄 바꿈
        }
    }
}
