package registeration;

public class Register {

   // Scanner sc= new Scanner(System.in);

    private String username;
    private String password;

    public Register(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    void prompt_valid() {
        System.out.println("Enter Username");
     //   username = sc.nextLine();
        System.out.println("Enter Password");

       // password = sc.nextLine();

    }
}
