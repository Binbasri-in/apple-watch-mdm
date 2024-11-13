package binbasri.apple_mdm.checkin.model;

import java.util.Objects;

public class GetTokenRequest implements CheckinMessage {
    private String MessageType;
    private String TokenServiceType;
    private String UserLongName;
    private String UDID;
    private String UserID;
    private String UserShortName;
    private String EnrollmentID;
    private String EnrollmentUserID;

    TokenParameters TokenParametersObject;

    // Getters and Setters


    @Override
    public String getMessageType() {
        return MessageType;
    }

    public void setMessageType(String messageType) {
        MessageType = messageType;
    }

    public String getTokenServiceType() {
        return TokenServiceType;
    }

    public void setTokenServiceType(String tokenServiceType) {
        TokenServiceType = tokenServiceType;
    }

    public String getUserLongName() {
        return UserLongName;
    }

    public void setUserLongName(String userLongName) {
        UserLongName = userLongName;
    }

    public String getUDID() {
        return UDID;
    }

    public void setUDID(String udid) {
        UDID = udid;
    }

    public TokenParameters getTokenParameters() {
        return TokenParametersObject;
    }

    public void setTokenParameters(TokenParameters tokenParameters) {
        this.TokenParametersObject = tokenParameters;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getUserShortName() {
        return UserShortName;
    }

    public void setUserShortName(String userShortName) {
        UserShortName = userShortName;
    }

    public String getEnrollmentID() {
        return EnrollmentID;
    }

    public void setEnrollmentID(String enrollmentID) {
        EnrollmentID = enrollmentID;
    }

    public String getEnrollmentUserID() {
        return EnrollmentUserID;
    }

    public void setEnrollmentUserID(String enrollmentUserID) {
        EnrollmentUserID = enrollmentUserID;
    }

    // toString
    @Override
    public String toString() {
        return "GetTokenRequest{" +
                "MessageType='" + MessageType + '\'' +
                ", TokenServiceType='" + TokenServiceType + '\'' +
                ", UserLongName='" + UserLongName + '\'' +
                ", UDID='" + UDID + '\'' +
                ", TokenParametersObject=" + TokenParametersObject +
                ", UserID='" + UserID + '\'' +
                ", UserLongName='" + UserLongName + '\'' +
                ", UserShortName='" + UserShortName + '\'' +
                ", EnrollmentID='" + EnrollmentID + '\'' +
                ", EnrollmentUserID='" + EnrollmentUserID + '\'' +
                '}';
    }

    // toPlist
    public String toPlist() {
        return "<plist version=\"1.0\">\n" +
                "<dict>\n" +
                "<key>MessageType</key>\n" +
                "<string>" + MessageType + "</string>\n" +
                "<key>TokenServiceType</key>\n" +
                "<string>" + TokenServiceType + "</string>\n" +
                "<key>UserLongName</key>\n" +
                "<string>" + UserLongName + "</string>\n" +
                "<key>UDID</key>\n" +
                "<string>" + UDID + "</string>\n" +
                "<key>TokenParameters</key>\n" +
                "<dict>\n" +
                "<key>PhoneUDID</key>\n" +
                "<string>" + TokenParametersObject.getPhoneUDID() + "</string>\n" +
                "<key>SecurityToken</key>\n" +
                "<string>" + TokenParametersObject.getSecurityToken() + "</string>\n" +
                "<key>WatchUDID</key>\n" +
                "<string>" + TokenParametersObject.getWatchUDID() + "</string>\n" +
                "</dict>\n" +
                "</dict>\n" +
                "</plist>";
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetTokenRequest that = (GetTokenRequest) o;

        if (MessageType != null ? !MessageType.equals(that.MessageType) : that.MessageType != null) return false;
        if (TokenServiceType != null ? !TokenServiceType.equals(that.TokenServiceType) : that.TokenServiceType != null)
            return false;
        if (UserLongName != null ? !UserLongName.equals(that.UserLongName) : that.UserLongName != null) return false;
        if (UDID != null ? !UDID.equals(that.UDID) : that.UDID != null) return false;
        if (TokenParametersObject != null ? !TokenParametersObject.equals(that.TokenParametersObject) : that.TokenParametersObject != null)
            return false;
        if (UserID != null ? !UserID.equals(that.UserID) : that.UserID != null) return false;
        if (UserLongName != null ? !UserLongName.equals(that.UserLongName) : that.UserLongName != null) return false;
        if (UserShortName != null ? !UserShortName.equals(that.UserShortName) : that.UserShortName != null)
            return false;
        if (EnrollmentID != null ? !EnrollmentID.equals(that.EnrollmentID) : that.EnrollmentID != null) return false;
        return EnrollmentUserID != null ? EnrollmentUserID.equals(that.EnrollmentUserID) : that.EnrollmentUserID == null;
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(MessageType, TokenServiceType, UserLongName, UDID, TokenParametersObject, UserID, UserLongName, UserShortName, EnrollmentID, EnrollmentUserID);
    }
    
}