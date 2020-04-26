# Microservice Tutorial

**Objective:** Objective of this repository is to develop a set of API(s) using Spring Boot to demonstrate several features. The services will be cloud native service.
This project is developed during the tough time of COVID19 where I thought it will be very helpful for students and young professional to learn OR seek new jobs. 

**Overview** 
Set of cloud native API(s) has  been created considering simplest use case of hospital.  Total of 6 API(s) are developed.

**Database Design**

- Login Table
- Doctor Table
- Patient Table
- Patient Appointment / History

**List of services**

- _authenticateUser_ -This service  will authenticate the receptionist and generate the token. Token will be of limited time and will be required to invoke every other API.
 

- _manageDoctor_ - This service will manage the doctor data. 

- _managePatient_ - This service will manage the patient data like new registration etc.

- _patientAppointment_ - This service will add appointment and later will be used to by doctor module to update the prescribed medicines.


- _Validation API_  - This api will validate that patient id or doctor id supplied in above service is valid.  This will be called internally by patientAppointment service before registration of any appointment.  This will serve the demo of service to service communication via

- _API Gateway Service_ - API gateway implementation.


**Technology**

- Spring Boot 2.x 
- Java 8
- MySQL database 
- Github 