/*
<상속을 활용하는 문제>
Beer클래스(부모클래스), Hoegaarden클래스(자식클래스)를 참고하여
HoegaardenBeerExample 클래스에서 빈칸을 채워 호가든 레몬맛의 맥주 마셔보기
*/

public class Beer {
    String type;
    String model;
    // 생성자(객체 값 세팅)
    public Beer(String type, String model) {
        this.type = type;
        this.model = model;
    }
    public void drink() {
        System.out.println("마십니다.");
    }
    public void mix() {
        System.out.println("섞습니다.");
    }
    public String getType() {
        return type;
    }
    public String getModel() {
        return model;
    }
}
class Hoegaarden extends Beer {
    String flavor;
    int ABV = 6;

    // 생성자 입력
    Hoegaarden(String model, String flavor) {
        super("밀맥주", model); //부모 클래스인 Beer의 생성자 호출
        this.model = model; // model은 상위 Beer 클래스로부터 상속받음
        this.flavor = flavor;
        this.ABV = ABV;
    }

    // 메서드 입력
    public void flavordrink() {
        System.out.println(model + "맥주의 " + flavor + "맛을 마십니다.");
    }

    // Getter
    public String getFlavor() {
        return flavor;
    }
    public int getABV() {
        return ABV;
    }
}
class HoegaardenBeerExample {
    public static void main(String[] args) {
        //[문제1] 호가든 맥주 레몬맛 객체 생성하기
        Hoegaarden hoegaarden=new Hoegaarden("호가든", "레몬");
        //Hoegaarden 생성자 호출 후 객체 초기화 (생성자에 전달하는 인자:호가든(model 매개변수에 전달)/레몬(flavor))
        //Hooegaarden 생성자 내 super("밀맥주"(type), model);를 통해 Beer 클래스 생성자 호출


        //[문제2-3줄] Beer 클래스와 Hoegaarden 클래스로부터 상속받은 필드로 맥주의 타입, 알콜 도수, 맛 출력하기
        System.out.println("타입 : "+hoegaarden.getType());
        System.out.println("알콜 도수 : "+hoegaarden.getABV());
        System.out.println("맛 : "+hoegaarden.getFlavor());

        //[문제3] Hoegaarden 클래스 메서드 호출
        hoegaarden.flavordrink();
    }
}

/*
타입 : 밀맥주
알콜 도수 : 6
맛 : 레몬
호가든맥주의 레몬맛을 마십니다.
*/