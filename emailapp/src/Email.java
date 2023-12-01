import java.util.Scanner;

public class Email {
    //그 사람들이 직접 엑세스 하는걸 원하지 않기 때문에 캡슐화 시킬 것이다.
    //나중에 작성할 클래스 API를 통해 이 정보에 엑세스 할 에정이다.
    private String firstName; //이름
    private String lastName; // 성
    private String password; //비밀번호
    private String deparment; //부서
    private String email; //이메일
    private int mailboxCapacity = 500; //box 용량
    private int defaultPasswordLength = 10; //기본비밀번호길이
    private String alternateEmail; //대체 이메일
    private String commpanySuffix = "aeycompany.com"; //회사접두사

    // Constructor to receive the first name and last name
    // 생성자를 위한 첫번째 이름과 마지막 이름을 받아야 한다.
    public Email(String firstName, String lastName) //생성자 생성 
    {
        this.firstName = firstName; //받은 매개변수 값을 private 변수에 저장
        this.lastName = lastName; //받은 매개변수 값을 private 변수에 저장

        //Call a method asking for the department - return the department
        //부서를 요청하는 메소드 호출  - 부서를 반환
        this.deparment = setDepartment(); //매소드 호출

        // Call a method that returns a random password
        //반환된 랜덤 비밀번호 메소드를 호출
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: "+ this.password);

        // Combine elements to generate email
        // 요소를 결합하여 이메일을 생성
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + deparment + "." + commpanySuffix; //이메일 생성

    }

    //Ask for the department
    //부서에 대해서 물어보기
    private String setDepartment() 
    {
        System.out.print("New worker: "+ firstName + ". Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in); //코드 받기
        int depChoice = in.nextInt(); //받은 코드 INT로 변환
        //받은 코드에 따른 부서 분류
        if(depChoice == 1){
            return "sales";
        }
        else if (depChoice ==2) {return "dev";}
        else if (depChoice == 3) {return "acct";}
        else { return "";}
    }

    //Generate a random password
    //무작위 비밀번호 생성
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%"; //비밀번호 자료 생성
        char[] password = new char[length]; //비밀번호 저장
        for (int i = 0; i < length; i++){
            int rand = (int) (Math.random() * passwordSet.length()); //passwordSet의 길이의 안에서 랜덤숫자를 만들어 저장한다.
            password[i] = passwordSet.charAt(rand); //그 랜덤숫자로 인덱스를 돌려 뽑아 낸다.

        }
        return new String(password); //뽑은 비밀번호 반환

    }

    //Set the mailbox capacity
    //메일 박스 용량 세팅
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;

    }

    //Set the alternate email
    //대체 이메일 세팅
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    //Change the password
    //비밀번호 바꾸기
    public void changePassword(String password){
        this.password = password;
    }

    //메일 용량 반환하기
    public int getMailboxCapacity() { return mailboxCapacity;}
    //대체 이메일 반환하기
    public String getAlternateEmail() {return alternateEmail;}
    // 비밀번호 반환하기
    public String getPassword() {return password;}

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " "+lastName+
               "\nCOMPANY EMAIL: " + email +
               "\nMAILBOX CAPACITY: "+mailboxCapacity+"mb";
    }
}
