# Code4Me

### Team Members
*Caelin Hargrave*   
*Mandy Mason*   
*Darius Owens*   
*Yari Velazquez*   
*Stanley Wilder*   

## Project Vision

Our vision for the **Code4Me** App is to provide a platform where developers can present their skill set for client consideration. Clients can view developers' profiles with past projects, biographies, available services, contact information. Clients can also book and pay for services a developer offers. 

## User Stories

[Trello Board](https://trello.com/b/z3n43ytG/code4me)

## Wireframe, Domain, and Data Models

[Figma Whiteboard](https://www.figma.com/file/CBC2hhkoM7X1tF8JKH8KCi/Code4Me-Wireframe%2C-Domain-Model%2C-DB-Model?node-id=0%3A1)

## Scope
### In
#### Features / Functional Requirements
- Developers can create profiles with projects, skills, and  for client consideration.
- Developers and clients can log in and out securely.
- Clients can create a user profile to access the payment system.
- Clients can search for developers using keywords which match a developer's skills.

### Out
- Our app will never guarantee that any developer will receive work.
- Our app will not guarantee that work will be completed by a developer. The responsibility falls to the client and developer do decide upon their terms of agreement.

### Minimum Viable Product
- Storefront-style front-end which utilizes React
- Developers can create a profile with skills, services, and links to past projects
- Clients can search for developers via keywords
- A payment system will be implemented for services

### Stretch Goals
- Social media shareable
- Users can leave comments on user profiles
- Display past transaction

## Data Flow

**Developers**: Sign up and create a profile, post services.
**Clients**: Sign up, search for developer profiles, select a service, checkout with payment

## Non-Functional Requirements

### Security
The app handles username and password for the client, utilizing authentication for signup, login, and payment. Only developers can make changes to their own profiles. *Potential future implementation*: Moderation system for client comments.

### Usability
All links are functional and route to pages appropriately. Payment system allows user sign-in to the payment API. Developers are notified when services are purchased and recieve payment. Clients are notified of payment receipt, and services.

#### Issues
- *Upon REACT initializtion, getting message "We found potential security vulnerabilities in your dependencies."*
