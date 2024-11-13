package binbasri.apple_mdm.checkin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import binbasri.apple_mdm.checkin.model.AuthenticateRequest;
import binbasri.apple_mdm.checkin.model.GetTokenRequest;

@Service
public class CheckinServiceImpl implements CheckinService {

    private static final Logger log = LoggerFactory.getLogger(CheckinServiceImpl.class);
    
    @Override
    public ResponseEntity<String> handleAuthenticate(AuthenticateRequest auth) throws Exception {
        log.info("Handling Authenticate message");
        log.info("UDID: " + auth.getMessageType());
        log.info("DeviceName: " + auth.getTopic());
        log.info("ModelName: " + auth.getSerialNumber());
        log.info("SerialNumber: " + auth.getSerialNumber());

        // return a response
        return ResponseEntity.ok("Handling Authenticate message");
    }

    @Override
    public ResponseEntity<?> handleGetToken(GetTokenRequest getToken) throws Exception {
        log.info("Handling GetToken message");
        log.info("UDID: " + getToken.getUDID());
        // check the service type and handle accordingly
        switch (getToken.getTokenServiceType()) {
            case "com.apple.maid":
                log.info("Still no support for access management for Managed Apple IDs");
                return ResponseEntity.badRequest().body("Still no support for access management for Managed Apple IDs");
            case "com.apple.watch.pairing":
                log.info("Handling Watch pairing Token Service");
                // Validate and return the GetToken response
                return ResponseEntity.ok("Handling Internal Token Service");
            default:
                log.error("Unrecognized Token Service Type: {}", getToken.getTokenServiceType());
                return ResponseEntity.badRequest().body("Unrecognized Token Service Type: " + getToken.getTokenServiceType());
        }
    }
}
