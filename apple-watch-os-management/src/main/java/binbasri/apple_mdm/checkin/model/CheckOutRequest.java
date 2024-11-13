package binbasri.apple_mdm.checkin.model;

public class CheckOutRequest implements CheckinMessage {
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

    // toString
    @Override
    public String toString() {
        return "CheckOutRequest{" + "MessageType=" + MessageType +
                ", Topic=" + Topic + ", SerialNumber=" + SerialNumber +
                ", DeviceName=" + DeviceName + ", Model=" + Model +
                ", ModelName=" + ModelName + ", UDID=" + UDID +
                ", EnrollmentID=" + EnrollmentID + '}';
    }

    public String toPlist() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n" +
                "<plist version=\"1.0\">\n" +
                "<dict>\n" +
                "    <key>MessageType</key>\n" +
                "    <string>" + MessageType + "</string>\n" +
                "    <key>Topic</key>\n" +
                "    <string>" + Topic + "</string>\n" +
                "    <key>SerialNumber</key>\n" +
                "    <string>" + SerialNumber + "</string>\n" +
                "    <key>DeviceName</key>\n" +
                "    <string>" + DeviceName + "</string>\n" +
                "    <key>Model</key>\n" +
                "    <string>" + Model + "</string>\n" +
                "    <key>ModelName</key>\n" +
                "    <string>" + ModelName + "</string>\n" +
                "    <key>UDID</key>\n" +
                "    <string>" + UDID + "</string>\n" +
                "    <key>EnrollmentID</key>\n" +
                "    <string>" + EnrollmentID + "</string>\n" +
                "</dict>\n" +
                "</plist>";
    }

}