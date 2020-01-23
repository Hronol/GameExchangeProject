package game;

public class ClientData {
    private String name;
    private String lastName;
    private String emailAddress;
    private long phoneNumber;

    public ClientData(String name, String lastName, String emailAddress) {
        this.name = name;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public ClientData(String name, String lastName, String emailAddress, long phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }


}
