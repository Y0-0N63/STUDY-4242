import java.util.Scanner;

//빈칸 채우는 문제 (주석을 참고하여 작성하세요)
//피자 주문이 들어오면 그 피자에 대한 재료를 알려주는 코드 입니다!
//기본 피자를 기반으로 다른 피자들의 재료가 각자 다르게 추가되면 됩니다!

public class Pizza {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in); //사용자 입력

        for(int i=0; i<7; i++) { //반복문
            System.out.println("어떤 피자를 주문하시겠습니까?"); //"어떤 피자를 주문하시겠습니까?" 문구 출력
            String pizzaName = scanner.next(); //문자열인 피자이름은 사용자가 입력한 값
            BasicPizza pizza = null; //변수 pizza 선언 및 초기화
            switch(pizzaName) { //다중 선택문으로 switch문의 조건식의 상수와 일치하는 case의 상수를 찾아서 실행하는 것
                case "Basic": //[문제1]"Basic"문구 입력시, BasicPizza() 호출
                    pizza=new BasicPizza();
                    break;
                case "Sweet": //[문제1]"Sweet"문구 입력시, SweetPotatoPizza() 호출
                    pizza=new SweetPotatoPizza();
                    break;
                case "Meet": //[문제1]"Meet"문구 입력시, MeetPizza() 호출
                    pizza=new MeatPizza();
                    break;
                case "Cheeze": //[문제1]"Cheeze"문구 입력시, CheezePizza() 호출
                    pizza=new CheezePizza();
                    break;
                case "Pineapple": //[문제1]"Pineapple"문구 입력시, PineapplePizza() 호출
                    pizza=new PineApplePizza();
                    break;
                case "Potato": //[문제1]"Potato"문구 입력시, PotatoPizza() 호출
                    pizza=new PotatoPizza();
                    break;
            }
            System.out.println(pizza); //pizza 출력
        }
        scanner.close(); //사용자 입력 종료
    }
}
class BasicPizza{ //BasicPizza 클래스
    @Override
    public String toString() { //[문제2]객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메서드, object 클래스의 toString 메서드 오버라이딩
        return "피자도우, 치즈, 토마토소스, 옥수수, 파프리카, 양파"; //값 리턴
    }
}
class SweetPotatoPizza extends BasicPizza{
    @Override
    public String toString() { //[문제2]객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메서드, object 클래스의 toString 메서드 오버라이딩
        return super.toString()+", 고구마, 고구마 무스, 햄, 베이컨 "; //[문제3]값 리턴 (상속받은 BasicPizza 리턴 값 + 새로 리턴한 값 출력)
    }
}
class MeatPizza extends BasicPizza{
    @Override
    public String toString() { //[문제2]객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메서드, object 클래스의 toString 메서드 오버라이딩
        return super.toString()+", 불고기"; //[문제3]값 리턴 (상속받은 BasicPizza 리턴 값 + 새로 리턴한 값 출력)
    }
}
class CheezePizza extends MeatPizza{
    @Override
    public String toString() { //[문제2]객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메서드, object 클래스의 toString 메서드 오버라이딩
        return super.toString()+", 치즈 2배"; //[문제3]값 리턴 (상속받은 BasicPizza 리턴 값 + 새로 리턴한 값 출력)
    }
}
class PineApplePizza extends BasicPizza {
    @Override
    public String toString() { //[문제2]객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메서드, object 클래스의 toString 메서드 오버라이딩
        return super.toString()+", 파인애플, 양송이버섯"; //[문제3]값 리턴 (상속받은 BasicPizza 리턴 값 + 새로 리턴한 값 출력)
    }
}
class PotatoPizza extends BasicPizza {
    @Override
    public String toString() {//[문제2]객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메서드, object 클래스의 toString 메서드 오버라이딩
        return super.toString()+", 감자, 마요네즈, 베이컨"; //[문제3]값 리턴 (상속받은 BasicPizza 리턴 값 + 새로 리턴한 값 출력)
    }
}

