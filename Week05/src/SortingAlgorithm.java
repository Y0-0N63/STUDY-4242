import java.util.ArrayList;
import java.util.Random;

//소팅 알고리즘을 사용하여 ArrayList에 임의의 정수값(1~10) 5개 담아 정렬하기 (선택 정렬)
//정렬 알고리즘(sorting algorithm)
// 원소들을 번호순이나 사전 순서와 같이 일정한 순서대로 열거하는 알고리즘
//   *정렬(sorting):데이터를 특정 항목에 대해 일정한 순서로 수정하여 나열
//선택 정렬(selection sort)-제자리 정렬 알고리즘 중 하나
//가장 작은 데이터를 찾아서 맨 앞에 위치시킴
// 주어진 리스트 중 최솟값을 찾음->해당 값 맨 앞의 값과 교체(패스)
// 첫번째 값을 제외한 나머지 값들에서 최솟값을 찾음->두번째 값과 교체 => 반복
//큰 배열에 대해서는 비효율적
// ->교환 연산 사용->배열 길이의 제곱에 비례하는 시간 복잡도(필요로 하는 시간)->속도가 느림
//파생형:이중 선택 정렬(Double Selecton Sort)->최솟값/최댓값 동시에 찾아 정렬

public class SortingAlgorithm {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        Random random=new Random();

        for(int i=0;i<5;i++){
            int randomNum=random.nextInt(10)+1;
            arrayList.add(randomNum);
        }

        System.out.println("무작위로 뽑은 숫자 배열:"+arrayList);

        selectionSort(arrayList); //선택 정렬을 사용하는 함수 호출
        System.out.println("정렬된 배열:"+arrayList);
    }

    public static void selectionSort(ArrayList<Integer>array){
        int n=array.size();

        for(int i=0;i<n-1;i++){
        //배열의 길이-1=>마지막 값은 앞 순서를 거치면서 자동적으로 정렬됨
            int minNum=i;

            for(int j=i+1;j<n;j++){ //최솟값 찾아 현재 위치의 값과 교환
                if(array.get(j)<array.get(minNum)){
                    minNum=j;
                }
            }
            int temp=array.get(i);
            array.set(i, array.get(minNum));
            array.set(minNum, temp);
        }
    }
}
