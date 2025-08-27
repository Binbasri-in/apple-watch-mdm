package binbasri.apple_mdm.controller;

import binbasri.apple_mdm.model.checkin.AuthenticateRequest;
import binbasri.apple_mdm.model.checkin.CheckinMessage;
import binbasri.apple_mdm.model.checkin.TokenUpdateRequest;
import binbasri.apple_mdm.service.CheckinService;
import binbasri.apple_mdm.util.CheckinDecoder;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class CheckinController {

    private static final Logger log = LoggerFactory.getLogger(CheckinController.class);

    @Autowired
    private CheckinService checkinService;

    @PutMapping("/checkin")
    @Operation(summary = "Handle MDM check-in requests",
            description = "Processes the check-in request from Apple MDM clients, supporting authentication and token updates.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Check-in processed successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request format"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public String handleCheckin(HttpServletRequest request) {
        try {
            byte[] bodyBytes = request.getInputStream().readAllBytes();
            CheckinMessage checkinMessage = CheckinDecoder.decodeCheckin(bodyBytes);

            log.info("Checkin message received: {}", checkinMessage.getMessageType());

            // Pass the decoded message directly to the service.
            return switch (checkinMessage.getMessageType()) {
                case "Authenticate" -> checkinService.handleAuthenticate((AuthenticateRequest) checkinMessage);
                case "TokenUpdate" -> checkinService.handleTokenUpdate((TokenUpdateRequest) checkinMessage);

                default -> "Unrecognized MessageType";
            };
        } catch (Exception e) {
            log.error("Error handling checkin", e);
            return e.getMessage();
        }
    }
}
