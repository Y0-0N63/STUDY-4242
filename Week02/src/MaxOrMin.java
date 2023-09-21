import java.util.Scanner;

/*문제: N(1<=N<=1000000)개의 정수가 주어졌을 때 주어진 N개의 정수들 중 최솟값과 최댓값을 구하는 프로그램을 작성하세요!(오류를 없애기 위해 채워넣어야 할 문제 총 4개)
  조건: 이때 모든 정수는 -1000000보다 크거나 같고 ,1000000보다 작거나 같은 정수이다.*/

public class MaxOrMin {

    public static void main(String[] args) {

        System.out.println("정수 N을 입력하세요:");
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();

        System.out.println("N개의 정수들을 입력하세요:");
        //[문제1] N개의 정수들을 담기위해 배열로 저장하기
        int[] array=new int[N];

        int Max=Integer.MIN_VALUE;//[문제2] Max 초기화하기
        //Integer.MIN_VALUE 정수 변수(int)에 저장할 수 있는 최솟값<-Max에 할당되는 값이 최솟값 이상이게 됨
        int Min=Integer.MAX_VALUE;//[문제3] Min 초기화하기
        //Integer.MAX_VALUE 정수 변수(int)에 저장할 수 있는 최댓값<-Max에 할당되는 값이 최솟값 이상이게 됨




        for(int i=0; i<array.length; i++) {
            array[i]=sc.nextInt(); //array[i] 인덱스에 들어갈 정수 입력

            if(array[i]>Max) {    //array에 저장된 정수들끼리 비교해가며 Max값 찾기
                Max=array[i];     //array[i]가 최댓값이 나올 때 까지 for문 반복
            }

            if(array[i]<Min) {   //array에 저장된 정수들끼리 비교해가며 Min값 찾기
                Min=array[i];    //array[i]가 최솟값이 나올 때 까지 for문 반복
            }
        }


        //[문제4] Max와 Min값을 +연산자를 사용하여 공백을 포함해 출력하기
        System.out.print("Max: "+Max+", Min: "+Min);
    }
}
