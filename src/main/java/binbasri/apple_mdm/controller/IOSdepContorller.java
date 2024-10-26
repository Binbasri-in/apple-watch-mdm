package binbasri.apple_mdm.controller;

import binbasri.apple_mdm.model.MDMServiceConfig;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IOSdepContorller {

    @GetMapping(
            value = "/MDMServiceConfig",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8"
    )
    public MDMServiceConfig getMDMServiceConfig() {
        MDMServiceConfig mdmServiceConfig = new MDMServiceConfig();
        mdmServiceConfig.setDep_anchor_certs_url("/dep/anchor-certs");
        mdmServiceConfig.setDep_enrollment_url("/dep/enroll");
        mdmServiceConfig.setTrust_profile_url("/dep/profile");
        return mdmServiceConfig;

    }

    // Optional: Implement the anchor certs endpoint that returns an empty array if using trusted SSL
    @GetMapping(
            value = "/dep/anchor-certs",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8"
    )
    public String getAnchorCerts() {
        // Return empty array if using trusted SSL certificate
        return "[]";
    }

}
