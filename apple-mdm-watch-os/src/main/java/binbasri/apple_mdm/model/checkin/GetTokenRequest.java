package binbasri.apple_mdm.model.checkin;

public class GetTokenRequest extends Enrollment implements CheckinMessage {
    private String MessageType;
    private String TokenServiceType;
    private String UserLongName;
    private String UDID;
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

    @Override
    public String toString() {
        return "GetTokenRequest{" +
                "MessageType='" + MessageType + '\'' +
                ", TokenServiceType='" + TokenServiceType + '\'' +
                ", UserLongName='" + UserLongName + '\'' +
                ", UDID='" + UDID + '\'' +
                ", TokenParametersObject=" + TokenParametersObject +
                '}';
    }

}
