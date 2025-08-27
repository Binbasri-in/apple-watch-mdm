# Apple MDM: Set up MDM server for Apple Devices
## Overview
The connection between the MDM server and the device is the Enrollment profile, once its installed the device can receieve commands from the server and once its deleted the connection terminate and no further commands received. In this document I tried to explain the process of creating an Enrollment Profile for iOS and watchOS devices to be managed and supervised device.

## Table of Content
- [](#apple-mdm-enrollment-profile)
- []()
- []()
- []()
- []()
To set up an MDM server for Apple Devices the following Certificates are required:
- To prove to Apple that you’re allowed to use their Push Service (APNS).
- To prove that your MDM isn’t being impersonated (TLS).
- To prove that someone isn’t impersonating an Apple Device connecting to your MDM (SCEP/Identity Certificate).

