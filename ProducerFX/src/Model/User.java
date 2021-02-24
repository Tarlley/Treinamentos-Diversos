package Model;

public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private String nickName;


    public User(int id, String name, String email, String password, String nickName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.nickName = nickName;
    }

    public User(String name, String email, String password, String nickName) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.nickName = nickName;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void showUser() {
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Password: " + getPassword());
        System.out.println("NickName: " + getNickName());
    }
}
