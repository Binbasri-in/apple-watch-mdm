# Simple Apple MDM Server for iOS Devices

## Overview
Device management starts with setting up an MDM server and distribute MDM enrollment profiles to devices.Once the device installs an MDM enrollment profile and connects to the server, it can receive commands from the server. When you remove the MDM enrollment profile from a device, that terminates the device mangagement relationship with the server.

## Table of Contents
- [Overview](#overview)
- [Table of Contents](#table-of-contents)
- [About Apple MDM profiles](#about-apple-mdm-profiles)
- [Encrypt and Sign the Profile](#encrypt-and-sign-the-profile)


## About Apple MDM profiles
- A profile is a property list XML file that have defined objects or properties that store information required by the MDM server or the MDM built-in framework in the device.
- We can create a profile using Apple Configurator 2, for example the following is a sample profile that contains Wi-Fi payload. click on `File` -> `New Profile` and choose the settings and the configuration you want to include in the profile.
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
<plist version="1.0">
<dict>
	<key>PayloadContent</key>
	<array>
		<dict>
			<key>AutoJoin</key>
			<true/>
			<key>CaptiveBypass</key>
			<false/>
			<key>DisableAssociationMACRandomization</key>
			<false/>
			<key>EncryptionType</key>
			<string>None</string>
			<key>HIDDEN_NETWORK</key>
			<false/>
			<key>IsHotspot</key>
			<false/>
			<key>PayloadDescription</key>
			<string>Configures Wi-Fi settings</string>
			<key>PayloadDisplayName</key>
			<string>Wi-Fi</string>
			<key>PayloadIdentifier</key>
			<string>com.apple.wifi.managed.1D5DD5A1-E8BA-4617-8082-F97E70A164FB</string>
			<key>PayloadType</key>
			<string>com.apple.wifi.managed</string>
			<key>PayloadUUID</key>
			<string>1D5DD5A1-E8BA-4617-8082-F97E70A164FB</string>
			<key>PayloadVersion</key>
			<integer>1</integer>
			<key>ProxyType</key>
			<string>None</string>
			<key>SSID_STR</key>
			<string>MAS_5G</string>
		</dict>
	</array>
	<key>PayloadDisplayName</key>
	<string>wifi-mas</string>
	<key>PayloadIdentifier</key>
	<string>Mohammeds-MacBook-Pro.2F7062AE-8820-4DFB-B5CD-8F32FE33B514</string>
	<key>PayloadRemovalDisallowed</key>
	<false/>
	<key>PayloadType</key>
	<string>Configuration</string>
	<key>PayloadUUID</key>
	<string>C6441FF9-E709-471D-A791-E2635AAFDB22</string>
	<key>PayloadVersion</key>
	<integer>1</integer>
</dict>
</plist>
```
- The profile contains the following:
    - `TopLevel Object`: It describe the profile and the rules for deploying it.
    - Then we have each payload content that contains common keys like `PayloadType`, `PayloadDisplayName`, `PayloadIdentifier`, `PayloadUUID`, `PayloadVersion` and other keys that are specific to the payload type.
- For more details check [here](https://developer.apple.com/documentation/devicemanagement/configuring_multiple_devices_using_profiles#3234104)

## Encrypt and Sign the Profile

- Both iOS and macOS support using encryption to protect the contents of profiles from unauthorized access. The encrypted profile can only be decrypted using a private key previously installed on a device.


## Simplified MDM server for iOS devices

- Create a service configuration entry point to your MDM server to access to frequently used information.
- Here is how to implement it:
    - Create the entry point using the endpoint `/MDMServiceConfig`.
    - The server code should return a UTF-8 JSON-encoded hash `(Content-Type: application/json; charset=UTF8)`.
    - It should return the following:
        - `dep_enrollment_url`: The URL a device uses to begin MDM enrollment with the MDM server.
        - `dep_anchor_certs_url`: The URL a device uses to obtain the certificates required to trust the URL specified by the `dep_enrollment_url` key.
        - `trust_profile_url`: The URL a device uses to obtain a Trust Profile for the MDM server, as a fully-formed `.mobileconfig` profile with only payloads of type com.apple.security.root.
    - Provide a value for `dep_anchor_certs_url` if you provide a value for `dep_enrollment_url`.
    - Omit `trust_profile_url` key if the MDM server doesn't require a Trust Profile because it's using a trusted SSL certificate.
    - Also return an empty body `(Content-Length: 0)` or an empty array JSON string `(‘[]’)` in case of trusted SSL certificate.





## Short Note About Secure Socket Layer (SSL) and Transport Layer Security (TLS)

- The goal of SSL/TLS is to provide a secure channel between two communicating applications (client and server) over the internet.
- SSL was the older version of the protocol and the last one was SSL 3.0 developed by Netscape in 1996.
- TLS is the newer version of the protocol and the first one was TLS 1.0 developed by IETF (Internet Engineering Task Force) in 1999.
- The new version of TLS is 1.3 which was released in 2018. and before 1.2 was standardised in 2008.
- 