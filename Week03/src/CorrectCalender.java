import java.util.HashMap;
import java.util.Scanner;

public class CorrectCalender {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<String, String> calender=new HashMap<>();

        while (true){
            System.out.println("원하는 작업을 선택하세요.");
            System.out.println("1.일정 추가 2.일정 검색 3.종료");
            System.out.print("원하는 작업의 번호를 입력하세요.>>");
            int choice=sc.nextInt();
            sc.nextLine();

            if(choice==1){
                System.out.print("추가할 일정의 날짜를 입력하세요.(YYYY/MM/DD)>>");
                String date=sc.nextLine();
                System.out.print("일정 내용을 입력하세요.>>");
                String event=sc.nextLine();
                calender.put(date, event);
                System.out.println("일정이 추가되었습니다.");
                System.out.println("\n");
            }
            else if (choice==2) {
                System.out.print("검색할 날짜를 입력하세요.(YYYY/MM/DD)>>");
                String date=sc.nextLine();
                String searchEvent=calender.get(date);
                if(searchEvent!=null){
                    System.out.println(date+"의 일정은 "+searchEvent+"입니다.");
                    System.out.println("\n");
                }
                else{
                    System.out.println("해당 날짜는 일정이 없습니다.");
                    System.out.println("\n");
                }
            }
            else if (choice==3) {
                System.out.println("종료합니다.");
                System.exit(0);
            }
            else {
                System.out.println("숫자를 다시 입력해주세요.");
                System.out.println("\n");
            }
        }
    }
}
