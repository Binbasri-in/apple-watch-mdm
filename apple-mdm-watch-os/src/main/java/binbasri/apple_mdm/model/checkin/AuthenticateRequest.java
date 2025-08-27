package binbasri.apple_mdm.model.checkin;

public class AuthenticateRequest extends Enrollment implements CheckinMessage {
    private String MessageType;
    private String Topic;
    private String SerialNumber;
    private String DeviceName;
    private String Model;
    private String ModelName;
    private String UDID;
    private String EnrollmentID;

    // Getters and Setters
    @Override
    public String getMessageType() {
        return MessageType;
    }

    public void setMessageType(String MessageType) {
        this.MessageType = MessageType;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String Topic) {
        this.Topic = Topic;
    }

    public String getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(String SerialNumber) {
        this.SerialNumber = SerialNumber;
    }

    public String getDeviceName() {
        return DeviceName;
    }

    public void setDeviceName(String DeviceName) {
        this.DeviceName = DeviceName;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getModelName() {
        return ModelName;
    }

    public void setModelName(String ModelName) {
        this.ModelName = ModelName;
    }

    public String getUDID() {
        return UDID;
    }

    public void setUDID(String UDID) {
        this.UDID = UDID;
    }

    public String getEnrollmentID() {
        return EnrollmentID;
    }

    public void setEnrollmentID(String EnrollmentID) {
        this.EnrollmentID = EnrollmentID;
    }

    @Override
    public String toString() {
        return "Authenticate{" + "MessageType=" + MessageType +
                ", Topic=" + Topic + ", SerialNumber=" + SerialNumber +
                ", DeviceName=" + DeviceName + ", Model=" + Model +
                ", ModelName=" + ModelName + ", UDID=" + UDID + '}';
    }

    public String toPlist() {
        return "<plist version=\"1.0\"><dict><key>MessageType</key><string>" + MessageType +
                "</string><key>Topic</key><string>" + Topic +
                "</string><key>SerialNumber</key><string>" + SerialNumber +
                "</string><key>DeviceName</key><string>" + DeviceName +
                "</string><key>Model</key><string>" + Model +
                "</string><key>ModelName</key><string>" + ModelName +
                "</string><key>UDID</key><string>" + UDID +
                "</string><key>EnrollmentID</key><string>" + EnrollmentID +
                "</string></dict></plist>";
    }
}
