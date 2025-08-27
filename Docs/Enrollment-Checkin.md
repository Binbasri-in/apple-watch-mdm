# Apple MDM: Enrollment Check-in Web Service

## Overview
This is a coprehensive guide to create an Enrollment Check-in Web Service for Apple MDM server to check-in the device with the server and get the commands from the server. The check-in process is the first step in the MDM communication between the device and the server. This is done by implemeneting the endpoint '/checkin' in the MDM server. Then the device will send PUT requests with different check-in commands like 'TokenUpdate', 'CheckOut', 'CheckIn', 'Authenticate' and 'UserAuthenticate'.

## Table of Content
- [Check-in Web Service](#check-in-web-service)
- []()
- []()
- []()
- []()

## Check-in Web Service
- The MDM check-in protocol validates a deviceʼs eligibility for MDM enrollment and informs the server that a deviceʼs push token has been updated.
- The check-in web service is a RESTful API that the device sends PUT requests to the server to check-in with the server and get the commands from the server.
- In Controller level, the check-in web service is implemented in the MDM server by creating a new endpoint '/checkin' that accepts PUT requests.
- The controller will parse the request body and check the message type and handle it to the appropriate service.
- The service will handle the request and send the response back to the controller and back to the device.

## Authenticate
- The first command that the device sends to the MDM server is 'Authenticate' command.
- The device sends the Authenticate command to the server with the device information like UDID, DeviceName, Model, ModelName, SerialNumber and the message type.
- The server will parse the request and check the message type and handle it to the appropriate service.

