import java.util.Scanner;

public class DoWhileEx {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("출력하고자 하는 줄의 개수를 입력하세요.>>");
        int num=sc.nextInt();

        int i=0; //i를 0으로 초기화
        do{
            int j=0; //j를 0으로 초기화
                do{
                    System.out.print("*");
                    j++;
                }
                while (j<=i); //j가 i보다 작거나 같은 동안+i 개수만큼 * 출력
                System.out.println();//줄 바꾸기
                i++;
        }
        while (i<num); //i가 num보다 작은 동안
    }
}
