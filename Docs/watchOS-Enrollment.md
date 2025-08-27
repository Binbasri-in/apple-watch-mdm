## Apple Watch Enrollment


### Introduction

### Prerequisites

### Enrollment Flow 

### 



### Sequence Diagram

```mermaid
sequenceDiagram
    participant Admin as Organization Administrator
    participant MDM as MDM Server
    participant iPhone as Managed iPhone
    participant Watch as Apple Watch
    participant User as End User
    Admin->>MDM: Configure Watch Enrollment<br/>on MDM Server
    Admin->>iPhone: Send Watch Enrollment Configuration
    iPhone->>iPhone: Install Watch Enrollment Configuration
    User->>iPhone: Initiate Pairing with Apple Watch
    iPhone->>Watch: Begin Pairing Process
    Watch->>User: Prompt to Accept Remote Management
    User->>Watch: Accept Remote Management
    Note over Watch: Receives Enrollment URL<br/>and Anchor Certificates from iPhone
    Watch->>MDM: Send Initial Enrollment Request<br/>with Machine Info
    MDM-->>Watch: Respond with HTTP 403 Forbidden<br/>(Includes Security Token)
    Watch->>iPhone: Send Security Token
    iPhone->>MDM: GetToken Check-in Request<br/>(Security Token, iPhone UDID, Watch UDID)
    MDM->>iPhone: Return Pairing Token
    iPhone->>Watch: Forward Pairing Token
    Watch->>MDM: Send Enrollment Request<br/>with Pairing Token
    MDM->>MDM: Verify Pairing Token and Device IDs
    MDM->>Watch: Provide Enrollment Profile
    Watch->>Watch: Install Enrollment Profile
    Watch->>MDM: Check-in with Authenticate Message
    Note over Watch: Enrollment Complete<br/>Apple Watch is Enrolled and Supervised
```

- Shorter one:
```mermaid
sequenceDiagram
    participant MDM as MDM Server
    participant iPhone as Managed, Supervised iPhone
    participant Watch as Apple Watch

    Note over MDM: - Support Declerative Device Management<br/>- Watch Enrollment Configuration pushed 
    Note over iPhone: - Managed and Supervised iOS 17+
    Note over Watch: - After starting pairing, then Receiving Enrollment URL<br/>and Anchor Certificates from iPhone
    Watch->>MDM: Send Initial Enrollment Request<br/>with `MachineInfo`
    MDM-->>Watch: Respond with HTTP 403 Forbidden<br/>(Includes Security Token)
    Watch->>iPhone: Send Security Token
    iPhone->>MDM: GetToken Check-in Request<br/>(Security Token, iPhone UDID, Watch UDID)
    MDM->>iPhone: Return Pairing Token
    iPhone->>Watch: Forward Pairing Token
    Watch->>MDM: Send Enrollment Request<br/>with Pairing Token
    MDM->>MDM: Verify Pairing Token and Device IDs
    MDM->>Watch: Provide Enrollment Profile
    Watch->>Watch: Install Enrollment Profile
    Watch->>MDM: Check-in with Authenticate Message
    Note over Watch: Enrollment Complete<br/>Apple Watch is Enrolled and Supervised
```


### Post-Enrollment Considerations

### Security Considerations

### Troubleshooting



### Declarations and Requests Schemas:

- [Watch Enrollment Configuration Declaration](https://github.com/apple/device-management/blob/release/declarative/declarations/configurations/watch.enrollment.yaml)
- [MachineInfo request Schema](https://github.com/apple/device-management/blob/release/other/machineinfo.yaml)
- [GetTocken MDM Schema](https://github.com/apple/device-management/blob/release/mdm/checkin/gettoken.yaml)
-  

### References

- Check the following video for full details on [Apple Watch Enrollment](https://developer.apple.com/videos/play/wwdc2023/10039/).
