package binbasri.apple_mdm.controller;

import binbasri.apple_mdm.model.MDMServiceConfig;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class IOSdepContorller {

    @GetMapping(
            value = "/MDMServiceConfig",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8"
    )
    @Operation(summary = "Get MDM service configuration",
            description = "Returns the configuration settings for the MDM service.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "MDM service configuration",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = MDMServiceConfig.class)))
    })
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
    @Operation(summary = "Get DEP anchor certificates",
            description = "Returns the anchor certificates for DEP enrollment.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "DEP anchor certificates",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    public String getAnchorCerts() {
        // Return empty array if using trusted SSL certificate
        return "[]";
    }
}
