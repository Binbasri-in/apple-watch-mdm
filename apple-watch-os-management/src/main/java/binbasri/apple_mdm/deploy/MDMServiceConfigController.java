package binbasri.apple_mdm.deploy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;


@RestController
public class MDMServiceConfigController {

    private static final Logger log = LoggerFactory.getLogger(MDMServiceConfigController.class);

    
     @GetMapping(
            value = "/MDMServiceConfig",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8"
    )
    public MDMServiceConfig getMDMServiceConfig(HttpServletRequest request) throws IOException {
        log.info("MDMServiceConfig request received with the body: {}", request);

        MDMServiceConfig mdmServiceConfig = new MDMServiceConfig();

        // server URL
        String serverUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

        // Set the MDM service configuration
        mdmServiceConfig.setDep_anchor_certs_url(serverUrl + "/watchos/anchor-certs");
        mdmServiceConfig.setDep_enrollment_url(serverUrl + "/watchos/enroll");
   
        return mdmServiceConfig;

    }

    // Optional: Implement the anchor certs endpoint that returns an empty array if using trusted SSL
    @GetMapping(
            value = "/watchos/anchor-certs",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8"
    )
    public String getAnchorCerts(HttpServletRequest request) throws IOException {
        // Return empty array if using trusted SSL certificate
        log.info("Anchor certs request received with the body: {}", request);
        return "[]";
    }

    // Machine Info endpoint
    @PostMapping(
        value = "/watchos/enroll",
        produces = MediaType.APPLICATION_XML_VALUE + ";charset=UTF-8")
    public ResponseEntity<String> machineInfoController(@RequestHeader Map<String, String> headers, @RequestBody byte[] signatureData){
        log.info("Request Received");
        for (Map.Entry<String, String> entry :  headers.entrySet()){
            log.info("{}  :  {}", entry.getKey(), entry.getValue());
        }

        // receive the body and store it in a file
        try {
            File file = new File("signatureData");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(signatureData);
            fos.close();
            log.info("Signature Data: {}", signatureData);
        } catch (Exception e){
            log.error("Error writing signature data to file: {}", e.getMessage());
            try {
                log.info("Signature Data: {}", signatureData);
            } catch (Exception e2){
                log.error("Error writing signature data to file: {}", e2.getMessage());
                log.info("Signature Data: {}", signatureData.toString());
            }
        }
        log.info("Signature Data: {}", signatureData.toString());



        return ResponseEntity.ok().body("null");

    }
}
