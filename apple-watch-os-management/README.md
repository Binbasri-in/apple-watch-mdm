## Apple watch OS Management

#### Mentors: `Prasad Kulkarni` `Deepak Rajanikanth`
#### Intern: `Mohammed Ali Mohammed Al Sakkaf`

### Project Description
Apple Watch running watchOS 10 or later is paired with an iPhone running iOS 17 or later, the watch can be enrolled into and managed by mobile device management (MDM). In this way, the watch supports use cases that not only improve the user’s productivity, but also support their wellness and offer them extra safety benefits.
- Enable MDM management
- Install, remove and update Apple Watch apps using MDM commands
- Configure settings, retrieve device information, clear the passcode, lock or erase the Apple Watch.
- Unenroll Apple Watch from MDM
- DDM support.

### Justifications
 This project is crucial for supporting OS management on the Apple platform, specifically for Apple Watch. It presents an excellent opportunity for interns, offering a comprehensive learning experience. Interns will engage in reading and understanding Apple documentation, designing a solution, and both developing and documenting their work. Notably, this project can be accomplished without current MDM support by using Apple Configurator.

### Scope:
1. Understand how apple devices are managed currently. 
2. Understand various paradigms of management of Apple Watch introduced by Apple.
3. Understand, design and POC how an apple watch can be enrolled in Maas360. 
4. Review and recommend what use cases and policies are most relevant  to be implemented for apple watch managemet. (Market Study and other things)
5. Understand, design and POC how policies/configurations can be applied an apple watch 
6. Understand, desisgn and POC of how apps can be distributed to apple watch 

### Comment
- Must cover use cases for DLP/Data protection/Restrictions use cases in both paired mode and independent modes of operation.


### Status:
✅ ⚠
| Topic       | Status     |
| :---        |          :---: |
| Understand how apple devices are managed currently | Done ✅ |
| Understand various paradigms of management of Apple Watch introduced by Apple | Done ✅  |
| Understand and try configuration profiles with Apple Configurator | Done ✅  |
| Create a test environment which is a simple MDM server with iOS enrollment with CheckIn endpoint | Partially ✅ |
| Add watchOS enrollment flow to the test server and the CheckIn endpoint and map recommended changes for MaaS360 | in progress ⚠ |
| Complete watchOS enrollment POC with enrollment profiles, checkIn endpoint, and unerollment flow | Not Started |
| Extract all possible watchOS payloads and configurations from apple documnetation | Not Started |
| Choose and Recoommend the Configurations and Restrictions requested by the market that MaaS360 should include | Not Started |
| Implement the chosen payloads and use cases to the separate server | Not Started |
| Implement support for Declairative Device Management for watchOS | Not Started |
| Map the changes and recommend the way how watchOS MDM can be done in MaaS360 | Not Started |
| Check how Mobile App Management is implemented in MaaS360 and design how apps in pairing mode are managed | Not Started |
| Choose and Recommend use cases for app management for watchOS | Not Started |
| Implement simple Mobile Application Management flows to the separate server | Not Started |
| Finalize POCs and Documentations for the full work | Not Started |


### Resources

##### Apple Watch Management
- [Deploy Apple Watch](https://support.apple.com/en-gb/guide/deployment/dep04f0c5414/web)
- [MDM payload list for Apple Watch devices](https://support.apple.com/en-gb/guide/deployment/depf591be1e7/1/web/1.0)
- [MDM restrictions for Apple Watch devices](https://support.apple.com/en-gb/guide/deployment/dep34c5cd30f/1/web/1.0)
- [Apple Device Management Developer Documentation](https://developer.apple.com/documentation/devicemanagement)
- [Apple Watch Configuration Profile Reference](https://developer.apple.com/business/documentation/Configuration-Profile-Reference.pdf)

##### Apple Services and Tools Guides
- [Apple Configurator User Guide](https://support.apple.com/en-in/guide/apple-configurator-mac/welcome/mac)
- [Apple Business Manager User Guide](https://support.apple.com/en-gb/guide/apple-business-manager/welcome/web)
- [Apple School Manager User Guide](https://support.apple.com/en-gb/guide/apple-school-manager/welcome/web)
- [Apple Business Essentials User Guide](https://support.apple.com/en-gb/guide/apple-business-essentials/welcome/web)
- [Apple Watch User Guide](https://support.apple.com/en-gb/guide/watch/welcome/10.0/watchos/10.0)
- [Apple Watch Products Documentation](https://support.apple.com/en-us/docs/watch)

##### Apple Watch Developer related Documentation
- [Watch Connectivity Framework](https://developer.apple.com/documentation/watchconnectivity)
- [WatchKit Framework](https://developer.apple.com/documentation/watchkit)
- [watchOS Apps](https://developer.apple.com/documentation/watchOS-Apps)
- [watchOS Human Interface Guidelines](https://developer.apple.com/design/human-interface-guidelines/watchos/overview/introduction/)
- [watchOS Release Notes](https://developer.apple.com/documentation/watchos-release-notes)


##### General Apple Resources
- [Apple Developer Documentation](https://developer.apple.com/documentation)
- [Apple Documentation Archive](https://developer.apple.com/library/archive/navigation/)


