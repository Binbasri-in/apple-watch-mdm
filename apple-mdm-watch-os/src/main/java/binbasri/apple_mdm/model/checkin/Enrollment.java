package binbasri.apple_mdm.model.checkin;

public class Enrollment {

    private String UDID;
    private String EnrollmentID;
    private String EnrollmentUserID;

    // Getters and Setters
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

    public String getEnrollmentUserID() {
        return EnrollmentUserID;
    }

    public void setEnrollmentUserID(String EnrollmentUserID) {
        this.EnrollmentUserID = EnrollmentUserID;
    }
}
