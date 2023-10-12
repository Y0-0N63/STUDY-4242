import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String date; //지출 날짜를 저장하는 문자열+멤버 변수
    String category; //지출 종류를 저장하는+멤버 문자열 변수
    int amount; //지출 금액을 저장하는 정수+멤버 변수

    public Expense(String date, int amount, String category) {
        //Expense 클래스의 생성자(매개 변수)->멤버 변수에 값 할당 후 객체 초기화
        this.date = date; //this.클래스의 멤버 변수=매개 변수;
        this.amount = amount;
        this.category = category;
    }

    void display() { //반환값 X->void
        System.out.println("날짜>>" + date); //지출 날짜 출력
        System.out.println("카테고리>>" + category); //지출 종류 출력
        System.out.println("금액(원)>>" + amount + "원"); //지출 금액 출력
    }
}

class DailyExpense extends Expense { //Expense 클래스를 상속받음
    DailyExpense(String date, int amount, String category) {
        //DailyExpense클래스의 생성자 (객체 초기화) date, amount, category 값 전달받아
        super(date, amount, category);
        //부모 클래스인 Expense의 생성자 호출 및 해당 값 부모 클래스의 생성자로 전달
    }

    @Override
    void display() {
        //DailyExpense에서 정의된 메서드->Expense의 display() 메서드 재정의 (출력의 역할)
        System.out.println("일일 지출 내역");
        super.display();
        //Expense의 display()메서드 호출
    }
}

class MonthlyExpense extends Expense {
    MonthlyExpense(String date, int amount) {
        //MonthlyExpense의 생성자 (객체 초기화) date와 amount 값 전달받아
        super(date, amount, "월별 지출");
        //부모 클래스인 Expense 생성자 호출
    }

    @Override
    void display() {
        //MonthlyExpense에서 정의된 메서드->Expense의 display()메서드 재정의 (출력 역할)
        System.out.println("월별 지출 내역");
        super.display();
        //Expense의 display() 호출
    }
}

class AccountBook {
    public ArrayList<Expense> expenses; //Expense 객체 저장

    AccountBook() { //AccountBook 클래스의 생성자->객체 초기화
        expenses = new ArrayList<>();
    }

    void addExpense(Expense expense) { //Expense 객체를 받아 지출 내역에 추가
        expenses.add(expense); //Expense 객체를 expenses 목록에 추가하여 관리
    }

    void showExpenses() { //저장된 지출 내역(expenses 목록에 저장된 Expense 객체의 정보) 출력
        System.out.println("지출 내역");
        for (int i=0;i<expenses.size();i++){
            Expense expense=expenses.get(i);
            System.out.println("날짜>>"+expense.date);
            System.out.println("카테고리>>"+expense.category);
            System.out.print("금액(원)>>"+expense.amount+"원");
        }
    }

    int totalExpense() { //현재까지 총 지출 금액 계산 (=expenses 목록의 Expense 객체 금액 합산 결과)
        int total = 0;
        for (int i=0;i<expenses.size();i++){
            Expense expense=expenses.get(i);
            total+=expense.amount;
        }
        return total;
    }
}

public class CorrectExpenseArrange {
    public static void main(String[] args) {
        AccountBook account = new AccountBook(); //AccountBook의 객체->account:지출 내역 저장 및 관리
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("원하는 작업을 선택하세요.");
            System.out.println("1. 일일 지출 기록 추가");
            System.out.println("2. 월별 지출 기록 추가");
            System.out.println("3. 총 지출 내역 보기");
            System.out.println("4. 총 지출 계산");
            System.out.println("5. 종료");
            System.out.print("원하는 작업의 번호를 입력하세요.>>");

            String choiceStr = sc.next();
            int choice; //정수형 변수 선언
            try {
                choice = Integer.parseInt(choiceStr); //문자열 choiceStr 정수로 변환->choice에 저장
            } catch (NumberFormatException e) { //예외가 발생하였을 때 (입력값이 숫자로 변환되지 X)
                System.out.println("숫자로 입력하세요.");
                continue;
            }

            if (choice == 1) {
                System.out.print("추가할 지출 내역의 날짜를 입력하세요.(YYYY/MM/DD)>>");
                String date = sc.next();
                System.out.print("지출 내역의 카테고리를 입력하세요.>>");
                String category = sc.next();
                System.out.print("지출액을 입력하세요.(원)>>");
                int amount;
                try {
                    amount = Integer.parseInt(sc.next());
                } catch (NumberFormatException e) {
                    System.out.println("금액을 숫자로 입력하세요.");
                    continue;
                }
                Expense dailyExpense = new DailyExpense(date, amount, category);
                //Expense 클래스를 상속   받은 DailyExpense 클래스의 객체 생성 (일일 지출 내역)
                //생성자 호출 후 생성자에 사용자로부터 받은 date, amount, category 값 전달
                account.addExpense(dailyExpense);
                //객체 dailyExpense AccountBook 클래스의 addExpense() 사용하여 지출 내역 목록에 추가
                System.out.println("일일 지출 내역이 추가되었습니다.");
            }
            else if (choice == 2) {
                System.out.print("월을 입력하세요.(YYYY/MM)>>");
                String date = sc.next();
                System.out.print("월별 지출액을 입력하세요.(원)>>");
                int amount;
                try {
                    amount = Integer.parseInt(sc.next());
                } catch (NumberFormatException e) {
                    System.out.println("금액을 숫자로 입력하세요.");
                    continue;
                }
                Expense monthlyExpense = new MonthlyExpense(date, amount);
                //Expense 클래스를 상속받은 MonthlyExpense 클래스의 객체 생성
                //사용자로부터 입력받은 date, amount 값->생성자에 전달
                account.addExpense(monthlyExpense);
                System.out.println("월별 지출 내역이 추가되었습니다.");
            } else if (choice == 3) {
                account.showExpenses();
            } else if (choice == 4) {
                int totalExpense = account.totalExpense();
                System.out.println("현재까지 총 지출은 " + totalExpense + "원 입니다.");
            } else if (choice == 5) {
                System.out.println("종료합니다.");
                break;
            } else {
                System.out.println("올바른 번호를 입력해주세요.");
            }
        }
    }
}
