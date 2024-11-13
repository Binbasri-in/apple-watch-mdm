package binbasri.apple_mdm.checkin;

import binbasri.apple_mdm.checkin.model.AuthenticateRequest;
import binbasri.apple_mdm.checkin.model.CheckinMessage;
import binbasri.apple_mdm.checkin.model.GetTokenRequest;
import binbasri.apple_mdm.checkin.model.TokenUpdateRequest;
import binbasri.apple_mdm.checkin.service.CheckinService;
import binbasri.apple_mdm.checkin.util.CheckinDecoder;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckinController {

    private static final Logger log = LoggerFactory.getLogger(CheckinController.class);

    @Autowired
    private CheckinService checkinService;

    @PutMapping("/checkin")
    public ResponseEntity<?> handleCheckin(HttpServletRequest request) {
        try {
            byte[] bodyBytes = request.getInputStream().readAllBytes();
            CheckinMessage checkinMessage = CheckinDecoder.decodeCheckin(bodyBytes);

            log.info("Checkin message received: {}", checkinMessage.getMessageType());

            // Pass the decoded message directly to the service.
            switch (checkinMessage.getMessageType()) {
                case "Authenticate" -> {
                    AuthenticateRequest auth = (AuthenticateRequest) checkinMessage;
                    log.info("Authenticate request received: {}", auth);
                    return ResponseEntity.ok("Authenticate request received: " + auth);
                }
                case "TokenUpdate" -> {
                    TokenUpdateRequest tokenUpdate = (TokenUpdateRequest) checkinMessage;
                    log.info("TokenUpdate request received: {}", tokenUpdate);
                    return ResponseEntity.ok("TokenUpdate request received: " + tokenUpdate);
                }
                case "CheckOut" -> {
                    log.info("CheckOut request received");
                    return ResponseEntity.ok("CheckOut request received");
                }
                case "GetToken" -> {
                    GetTokenRequest getToken = (GetTokenRequest) checkinMessage;
                    log.info("GetToken request received: {}", getToken);

                    // send request to its own handler
                    return checkinService.handleGetToken(getToken);
                }
                case "DeclarativeManagement" -> {
                    log.info("DeclarativeManagement request received");
                    return ResponseEntity.ok("DeclarativeManagement request received");
                }
                default -> {
                    log.error("Unrecognized message type: {}", checkinMessage.getMessageType());
                    return ResponseEntity.badRequest().body("Unrecognized message type: " + checkinMessage.getMessageType());
                }
            }
        } catch (Exception e) {
            log.error("Error handling checkin", e);
            return ResponseEntity.badRequest().body("Error handling checkin: " + e.getMessage());
        }
    }
}