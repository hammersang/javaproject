import java.util.Scanner;

public class BankingApplication {
    //뱅킹 시스템 만들어야 할것
    // 시작하면 사용자에게 환영 메세지와 이름이 표시된 다음 사용자에게 잔액 확인, 예금 인출 확인, 이전 거래 확인 이라는 5가지 옵션을 제시
    public static void main(String[] args) {

        BankAccount obj1 = new BankAccount("XYZ", "BA001"); //고객이름과 id 만든후 BankAccount 생성
        obj1.showMenu(); //showMenu 메소드 실행
        
    }
}
    class BankAccount //이것은 은행 계좌에서 일어 날것 이기 때문에 만든 클래스
    {
        //필요한 변수 4개
        int balance; //잔액
        int previousTransaction; //이전 거래에서 마지막 금액이 인출되거나 입금되었는지의 여부를 나타냄
        String customerName; //고객의 이름
        String customerId; //고객의 ID

        BankAccount(String cname, String cid ) //생성자 생성 ,cname은 고객이름, cid는 고객id 이것을 가져오는 이유는 환영 메세지를 보낼때 필요하기 때문이다.
        {
            customerName = cname; //받아온 이름 저장
            customerId = cid; //받아온 id 저장

        }

        void deposit(int amount) //예금 매개변수 하나는 들어갈 금액을 알려주는 변수이다.
        {
            if(amount != 0) //들어갈 금액이 0일 경우엔 작업을 수행하고 싶지 않다.
            {
                balance = balance + amount; //고객의 잔약에 등어갈 금액을 더해준다
                previousTransaction = amount; //입금된 여부를 알려줄수 있게 저장한다.
            }

        }
        void withdraw(int amount) //인출 매개변수 하나는 뺄 금액을 알려주는 변수
        {
            if(amount != 0 && balance >= amount) //뺄 금액이 0일 경우거나 빼는 금액이 잔액보다 작은 경우엔 작업 X
            {
                balance = balance - amount; //뺀 만큼 잔액을 저장한다.
                previousTransaction = -amount; //인출 여부를 알려줄수 있게 저장

            }
            else{ //작업 안될경우
                System.out.println("너는 뺄 수 없어");
                System.out.println("\n");
            }
        }

        void getPreviousTransaction() //이전 거래의 여부 확인 매소드
        {
            if(previousTransaction > 0) // 이전 거래가 0 보다 크다면 = 입금을 했다면 
            {
                System.out.println("Deposited: "+previousTransaction); //이전 거래 여부 보여주기
            }
            else if(previousTransaction < 0) //이전 거래가 0보다 작다면 = 인출을 했다면
            {
                System.out.println("Withdrawn: "+Math.abs(previousTransaction)); //이전 거래 여부 보여주기 Math.abs는 절대값 보여주는 것
            }
            else //이전 거래가 없다면
            {
                System.out.println("No transaction occured"); //안했다고 알려주기
            }
        }

        void showMenu() //사용자에게 보여줄 메뉴
        {
            char option ='\0'; //다시 초기화시키는 관리 변수이다.
            Scanner scanner = new Scanner(System.in); //콘솔에서 사용자 입력을 가져오는데 필요
            
            //환영 메세지 출력
            System.out.println("Welcome "+customerName);
            System.out.println("Your ID is "+customerId);
            System.out.println("\n");
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous transaction");
            System.out.println("E. Exit");

            do //나갈때 까지 수행
            {
                //사용자에게 입력 받기
                System.out.println("=====================================================");
                System.out.println("Enter an option");
                System.out.println("=====================================================");
                option = scanner.next().charAt(0); //받은 문자열중에 인덱스0 번만 받기
                System.out.println("\n");

                switch (option) //사용자가 입력한 메뉴 문자
                {
                    case 'A':
                        //잔액 보기
                        System.out.println("----------------------------------------");
                        System.out.println("Balance = "+balance);
                        System.out.println("----------------------------------------");
                        System.out.println("\n");
                        break;
                
                    case 'B':
                        //입금 하기
                        System.out.println("----------------------------------------");
                        System.out.println("Enter an amount to deposit");
                        System.out.println("----------------------------------------");
                        int amount = scanner.nextInt();
                        deposit(amount); //deposit 메소드 실행
                        System.out.println("\n");
                        break;
                    
                    case 'C':
                        //인출하기
                        System.out.println("----------------------------------------");
                        System.out.println("Enter an amount to widthdraw ");
                        System.out.println("----------------------------------------");
                        int amount2 = scanner.nextInt();
                        withdraw(amount2); //withdraw 메소드 실행
                        System.out.println("\n");
                        break;

                    case 'D':
                        //이전 거래 내역 보여주기
                        System.out.println("----------------------------------------");
                        getPreviousTransaction(); //getPreviousTransaction 메소드 실행
                        System.out.println("----------------------------------------");
                        System.out.println("\n");
                        break;
                    
                    case 'E':
                        //끝내기
                        System.out.println("----------------------------------------");
                        break;

                    default: //다른 걸 입력했을 경우
                        System.out.println("Invalid Option!!. Please enter again");
                        break;

                }

            }while(option != 'E');

            System.out.println("ThankYou for using our services");

        }
    }

