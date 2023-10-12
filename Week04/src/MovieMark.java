/*상속문제
Movie클래스에 감독,배우 평점을 입력하여 영화 총점을 계산하고 영화 평점을 출력한 후
Movie클래스를 상속받은 MovieWork에 감독,배우,작품성,대중성,대본 평점을 입력하여 영화 총점을 계산하고 영화 평점 출력하기
Movie 클래스를 상속받아 MovieWork클래스를 구현하는 프로그램을 만드는 문제 입니다 (display()메소드를 오버라이딩하여 구현하기)
빈부분이나 오류를 수정하여주세요!(총5문제)
*/

class Movie{
    String title; //영화제목(멤버변수) -new 키워드 없이 인스턴스(객체)생성
    int director; //감독점수(멤버변수) -new 키워드 없이 인스턴스(객체)생성
    int actor; //배우점수(멤버변수)    -new 키워드 없이 인스턴스(객체)생성


    public Movie(String title,int director,int actor) { //생성자
        //[문제1]생성자의 매개변수로 선언된 변수의 이름이 인스턴스 변수와 같으므로 인스턴스 변수와 지역변수를 구분하기 위한 this참조변수 사용하기(객체멤버접근)
        this.title=title;
        this.director=director;
        this.actor=actor;
    }

    void display() {

        int total=director+actor;
        String result="";
        //[문제2]main에서 Movie클래스에 영화제목,감독과배우평점,영화총점이 입력되어 출력될 수 있도록 코딩하기(힌트:printf사용하기)
        System.out.println("영화제목:"+title);
        System.out.println("감독:"+director+", 배우:"+actor);
        System.out.println("영화 총점:"+total);

        if(total>=17)
            result="☆☆☆☆☆";
        else if(total>=15)
            result="☆☆☆☆";
        else if(total>=10)
            result="☆☆☆";
        else
            result="☆☆";

        System.out.println("영화평점:"+result);

    }

}
//[문제3]Movie클래스를 상속받아 MovieWork클래스를 구현하는 클래스 생성하기
class MovieWork extends Movie{
    private int cinematic; //작품성
    private int popular; //대중성
    private int scenario; //시나리오

    public MovieWork(String title,int director,int actor,int cinematic,int popular,int scenario) {
        super(title,director,actor); //슈퍼 즉 부모 클래스가 상속

        //[문제4]생성자의 매개변수로 선언된 변수의 이름이 인스턴스 변수와 같으므로 인스턴스 변수와 지역변수를 구분하기 위한 this참조변수 사용하기(객체멤버접근)
        this.cinematic=cinematic;
        this.popular=popular;
        this.scenario=scenario;
    }

    @Override
    void display() {

        int total=director+actor+cinematic+popular+scenario;
        String result="";
        //[문제5]main에서 MovieWork클래스에 영화제목,감독과배우,작품성,대중성,대본 평점,영화총점이 입력되어 출력될 수 있도록 코딩하기(힌트:printf사용하기)
        System.out.println("영화 제목:"+title);
        System.out.println("감독:"+director+", 배우:"+actor+", 작품성:"+cinematic+", 대중성:"+popular+", 대본:"+scenario);
        System.out.println("영화 총점:"+total);
        if(total>=17)
            result="☆☆☆☆☆";
        else if(total>=15)
            result="☆☆☆☆";
        else if(total>=10)
            result="☆☆☆";
        else
            result="☆☆";

        System.out.println("영화평점:"+result);
    }
}
public class MovieMark {

    public static void main(String[] args) {
        Movie m=new Movie("1987",9,10);
        m.display();

        System.out.println("-----------------------------------------------");


        //매개변수 4개인 생성자로 객체 생성
        MovieWork mw= new MovieWork("부산행",8,10,10,10,7);
        mw.display();
    }

}
 /*출력결과
영화제목:1987
감독:9,배우:10
영화총점:19
영화평점:☆☆☆☆☆
-----------------------------------------------
영화제목:부산행
감독:8,배우:10,작품성:10,대중성:10,대본:7
영화총점:45
영화평점:☆☆☆☆☆
*/



