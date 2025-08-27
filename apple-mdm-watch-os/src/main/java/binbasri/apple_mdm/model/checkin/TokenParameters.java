package binbasri.apple_mdm.model.checkin;

public class TokenParameters {
    private String PhoneUDID;
    private String SecurityToken;
    private String WatchUDID;

    // Getters and Setters

    public String getPhoneUDID() {
        return PhoneUDID;
    }

    public void setPhoneUDID(String phoneUDID) {
        PhoneUDID = phoneUDID;
    }

    public String getSecurityToken() {
        return SecurityToken;
    }

    public void setSecurityToken(String securityToken) {
        SecurityToken = securityToken;
    }

    public String getWatchUDID() {
        return WatchUDID;
    }

    public void setWatchUDID(String watchUDID) {
        WatchUDID = watchUDID;
    }

    @Override
    public String toString() {
        return "TokenParameters{" +
                "PhoneUDID='" + PhoneUDID + '\'' +
                ", SecurityToken='" + SecurityToken + '\'' +
                ", WatchUDID='" + WatchUDID + '\'' +
                '}';
    }

}
