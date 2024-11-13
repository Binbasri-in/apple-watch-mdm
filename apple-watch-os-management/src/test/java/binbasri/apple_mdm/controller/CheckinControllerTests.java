package binbasri.apple_mdm.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import binbasri.apple_mdm.checkin.CheckinController;

import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CheckinController.class)
public class CheckinControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHandleAuthenticate() throws Exception {
        String plistData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n" +
                "<plist version=\"1.0\">\n" +
                "<dict>\n" +
                "    <key>MessageType</key>\n" +
                "    <string>Authenticate</string>\n" +
                "    <key>Topic</key>\n" +
                "    <string>com.apple.mgmt.External.1c2b4b7d-0b7b-4b4b-8b4b-4b4b4b4b4b4b</string>\n" +
                "    <key>UDID</key>\n" +
                "    <string>00000000-1111-2222-3333-444455556666</string>\n" +
                "    <key>DeviceName</key>\n" +
                "    <string>My iPhone</string>\n" +
                "    <key>Model</key>\n" +
                "    <string>iPhone</string>\n" +
                "    <key>ModelName</key>\n" +
                "    <string>iPhone</string>\n" +
                "    <key>SerialNumber</key>\n" +
                "    <string>1234567890</string>\n" +
                "</dict>\n" +
                "</plist>";

        mockMvc.perform(put("/checkin")
                .contentType(MediaType.APPLICATION_XML)
                .content(plistData))
                .andExpect(status().isOk());
    }

    @Test
    public void testHandleTokenUpdate() throws Exception {
        String plistData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n" +
                "<plist version=\"1.0\">\n" +
                "<dict>\n" +
                "    <key>MessageType</key>\n" +
                "    <string>TokenUpdate</string>\n" +
                "    <key>Topic</key>\n" +
                "    <string>com.apple.mgmt.External.1c2b4b7d-0b7b-4b4b-8b4b-4b4b4b4b4b4b</string>\n" +
                "    <key>UDID</key>\n" +
                "    <string>00000000-1111-2222-3333-444455556666</string>\n" +
                "    <key>Token</key>\n" +
                "    <string>1234567890</string>\n" +
                "    <key>UnlockToken</key>\n" +
                "    <string>0987654321</string>\n" +

                "</dict>\n" +
                "</plist>";

        mockMvc.perform(put("/checkin")
                .contentType(MediaType.APPLICATION_XML)
                .content(plistData))
                .andExpect(status().isOk());
    }

    @Test
    public void testHandleCheckOut() throws Exception {
        String plistData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n" +
                "<plist version=\"1.0\">\n" +
                "<dict>\n" +
                "    <key>MessageType</key>\n" +
                "    <string>CheckOut</string>\n" +
                "    <key>Topic</key>\n" +
                "    <string>com.apple.mgmt.External.1c2b4b7d-0b7b-4b4b-8b4b-4b4b4b4b4b4b</string>\n" +
                "    <key>UDID</key>\n" +
                "    <string>00000000-1111-2222-3333-444455556666</string>\n" +
                "</dict>\n" +
                "</plist>";

        mockMvc.perform(put("/checkin")
                .contentType(MediaType.APPLICATION_XML)
                .content(plistData))
                .andExpect(status().isOk());
    }

    @Test
    public void testHandleGetToken() throws Exception {
        String plistData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n" +
                "<plist version=\"1.0\">\n" +
                "<dict>\n" +
                "    <key>MessageType</key>\n" +
                "    <string>GetToken</string>\n" +
                "    <key>Topic</key>\n" +
                "    <string>com.apple.mgmt.External.1c2b4b7d-0b7b-4b4b-8b4b-4b4b4b4b4b4b</string>\n" +
                "    <key>UDID</key>\n" +
                "    <string>00000000-1111-2222-3333-444455556666</string>\n" +
                "</dict>\n" +
                "</plist>";

        mockMvc.perform(put("/checkin")
                .contentType(MediaType.APPLICATION_XML)
                .content(plistData))
                .andExpect(status().isOk());
    }
}