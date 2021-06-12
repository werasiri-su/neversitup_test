package constants;

public enum ERole {
    ADMIN("ADMIN"),
    CUSTOMER("CUSTOMER"),

            ;

    private String status;

    private ERole(String status) {
        // TODO Auto-generated constructor stub
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}
