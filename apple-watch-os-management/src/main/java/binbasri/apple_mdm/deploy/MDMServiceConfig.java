package binbasri.apple_mdm.deploy;

public class MDMServiceConfig {
    private String dep_anchor_certs_url;
    private String dep_enrollment_url;

    // Getter and Setter
    public String getDep_anchor_certs_url() {
        return dep_anchor_certs_url;
    }

    public void setDep_anchor_certs_url(String dep_anchor_certs_url) {
        this.dep_anchor_certs_url = dep_anchor_certs_url;
    }

    public String getDep_enrollment_url() {
        return dep_enrollment_url;
    }

    public void setDep_enrollment_url(String dep_enrollment_url) {
        this.dep_enrollment_url = dep_enrollment_url;
    }
}
