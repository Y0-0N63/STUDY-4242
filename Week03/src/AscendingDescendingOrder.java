import java.util.*;

//HashMap에 저장되어 있는 키의 값을 사용자가 원하는 순서대로 출력하는 문제

//빈칸 넣기

//[문제1] 오름차순으로 정렬되도록 해라.
//[문제2] 내림차순으로 정렬되도록 해라.
//[문제3] 한 번 실행되면 멈추도록 해라.
//[문제4] 값을 제대로 입력하지 않았을 경우 다시 실행되도록 해라.
//[문제5] List에 ArrayList를 이용하여 HashMap 값 넣어라.
public class AscendingDescendingOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 150);
        map.put(2, 180);
        map.put(3, 190);
        map.put(4, 120);
        map.put(5, 130);
        map.put(6, 160);

        while (true){
            System.out.println("정렬 방식을 선택하세요.(UP = 키 작은 순서대로, DOWN = 키 큰 순서대로)");
            System.out.println("UP/DOWN");

            String updown = scanner.next();

            List<Integer> valueList = new ArrayList<>(map.values()); //[문제5] List에 ArrayList를 이용하여 HashMap 값 넣어라.
            valueList.sort(Integer::compareTo); //리스트를 오름차순으로 정렬

            if (updown.equals("UP")) {
                //[문제1] 오름차순으로 정렬되도록 해라.
                for (int i=0;i<valueList.size();i++) { //오름차순 출력
                    System.out.println(valueList.get(i)+"CM");
                }
                //[문제3] 한 번 실행되면 멈추도록 해라.
                break;
            } else if (updown.equals("DOWN")) {
                //[문제2] 내림차순으로 정렬되도록 해라.
                for (int i=valueList.size()-1;i>=0;i--) { //내림차순 출력
                    //리스트의 인덱스->0부터 시작
                    System.out.println(valueList.get(i)+"CM");
                }
                //[문제3] 한 번 실행되면 멈추도록 해라.
                break;
            } else {
                System.out.println("값을 제대로 입력하세요"); //[문제3] 내림차순으로 정렬되도록 해라.
                System.out.println("========================================");

            }
        }
    }
}


/* 결과값
정렬 방식을 선택하세요.(UP = 키 작은 순서대로, DOWN = 키 큰 순서대로)
UP/DOWN
UP
120CM
130CM
150CM
160CM
180CM
190CM

정렬 방식을 선택하세요.(UP = 키 작은 순서대로, DOWN = 키 큰 순서대로)
UP/DOWN
DOWN
190CM
180CM
160CM
150CM
130CM
120CM

정렬 방식을 선택하세요.(UP = 키 작은 순서대로, DOWN = 키 큰 순서대로)
UP/DOWN
SDF
값을 제대로 입력하세요
========================================
정렬 방식을 선택하세요.(UP = 키 작은 순서대로, DOWN = 키 큰 순서대로)
UP/DOWN
 */