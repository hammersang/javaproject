import java.util.Scanner;

public class ScannerTest {
    //뱅킹 프로그램 만들어 보기
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); //Scanner 객체 생성 //Scanner 라이브러리에서 import 해온다.
        System.out.println("Enter a charcater");
        //int a = scanner.nextInt(); //사용자로부터 정수를 받아온다
        char c = scanner.next().charAt(0); //문자열을 가져오는데 전체 문자열을 원하지 않는다  charAt를 통해서 인덱스를 지정할수 있다. 만약 abc가 있다면 a는 인데스(0)에 있는것이고, b는 인덱스(1)에 있는것이다.
        System.out.println("value = "+c);
    }
}
