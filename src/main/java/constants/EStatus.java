package constants;

public enum EStatus {
    ORDER("ORDER"),
    CANCEL("CANCEL"),
    DELIVERY("DELIVERY"),

            ;

    private String status;

    private EStatus(String status) {
        // TODO Auto-generated constructor stub
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

}
