# Apple MDM: Enrollment Profiles creation for iOS and watchOS

## Overview
The connection between the MDM server and the device is the Enrollment profile, once its installed the device can receieve commands from the server and once its deleted the connection terminate and no further commands received. In this document I tried to explain the process of creating an Enrollment Profile for iOS and watchOS devices to be managed and supervised device.

## Table of Content
- [Apple MDM Enrollment Profile](#apple-mdm-enrollment-profile)
- []()
- []()
- []()
- []()

## Apple MDM Enrollment Profile

### General Structure (Configuration Profile)
- A property list XML file that have devfined objects or properties that store information required by the MDM server or the MDM built-in framework in the device.
- Here is a simple example of a property list XML file, this is for Authenticate request with the required keys and values:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
<plist version="1.0">
<dict>
    <key>MessageType</key>
    <string>Authenticate</string>
    <key>Topic</key>
    <string>com.apple.mgmt.External.1c2b4b7d-0b7b-4b4b-8b4b-4b4b4b4b4b4b</string>
    <key>UDID</key>
    <string>00000000-1111-2222-3333-444455556666</string>
    <key>DeviceName</key>
    <string>My iPhone</string>
    <key>Model</key>
    <string>iPhone</string>
    <key>ModelName</key>
    <string>iPhone</string>
    <key>SerialNumber</key>
    <string>1234567890</string>
</dict>
</plist>
```

Configuration profiles are in a property list format, which any XML tool can read and write. 
- **TopLevel** object:

### Sample Enrollment Profile
