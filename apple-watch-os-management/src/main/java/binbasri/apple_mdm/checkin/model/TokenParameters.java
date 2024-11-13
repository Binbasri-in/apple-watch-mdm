package binbasri.apple_mdm.checkin.model;

import java.util.Objects;

public class TokenParameters {
    private String PhoneUDID;
    private String SecurityToken;
    private String WatchUDID;

    public TokenParameters(){
        super();
    }
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

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TokenParameters that = (TokenParameters) o;

        if (PhoneUDID != null ? !PhoneUDID.equals(that.PhoneUDID) : that.PhoneUDID != null) return false;
        if (SecurityToken != null ? !SecurityToken.equals(that.SecurityToken) : that.SecurityToken != null) return false;
        return WatchUDID != null ? WatchUDID.equals(that.WatchUDID) : that.WatchUDID == null;
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(PhoneUDID, SecurityToken, WatchUDID);
    }
    
    // toString
    @Override
    public String toString() {
        return "TokenParameters{" +
                "PhoneUDID='" + PhoneUDID + '\'' +
                ", SecurityToken='" + SecurityToken + '\'' +
                ", WatchUDID='" + WatchUDID + '\'' +
                '}';
    }

}