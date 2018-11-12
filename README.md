# BsPrdTmpltSvcRst
This template contains the following,
- Rest Service with CRU common headers
- Rest Service with Oracle Database
- Swagger UI
- MyBatis for raws sql and stored procedure
- Actuator (secured)
- AOP based logging framework
- Externalized profile specific configuration

## Import Project
- File (Click from Toolbar)
- Import (Click)
- Existing Gradle Project (Click)
- Follow wizard

## Swagger and API DOCS URL
http://localhost:8080/api-docs?group=v1

http://localhost:8080/swagger-ui.html

## Run Application in Boot mode with embedded container
- Run (Click from Toolbar)
- Run Configuration (Click)
- Spring Boot App (Click - if Spring Boot App not available in eclipse then load STS from eclipse market place and retry)
- New Launch Configuration (Click at top left)
- Select Project and Search Main Type
- Change to Arguments Tab
- Type below environment variables in the Program arguments section and click Apply, Run (make sure that no blank lines appear in eclipse).

--config.location=C:\Users\408183\GitLab\Base\BsPrdTmpltSvcRst\cnfg\

--log.location=src/main/resources

--CRUDB_PASSWORD=adaba5


Note: 
- Change the config.location value to the folder containing environment (lcl, test, dvl, int, prd) specific properties file (location should not contain blank space ' ').
- Change the log.location path to appropriate folder where the logs you want to be generated.
- Change the CRUDB_PASSWORD to oracle database password

## Run JUnit Test Suite
- Open ApplicationUnitTestSuite.java in eclipse editor
- Run (Click from Toolbar)
- Run Configuration (Click)
- JUnit (Click)
- New Launch Configuration (Click at top left)

## Run Cucumber Test Suite
- Open CucumberTest.java in eclipse editor
- Run (Click from Toolbar)
- Run Configuration (Click)
- JUnit (Click)
- New Launch Configuration (Click at top left)
- Click Apply, Run.

Note: 
- Change the config.location value to the folder containing environment (lcl, test, dvl, int, prd) specific properties file (location should not contain blank space ' ') in application.yml file for test profile.
- Change the log.location path to appropriate folder where the logs you want to be generated in application.yml file for test profile..

## Test Application
Perform a POST at http://localhost:8080/example/sql/v1/employees/names with below request header and raw json body using Postman or use swagger-ui http://localhost:8080/swagger-ui.html

###### Body
0000305566

###### Request Headers
applicationOwnerCode:CRU

requestedEmployeeId:test

apiResourceName:test

apiRequestUtcTs:test

applicationName:test

applicationVersionNum:test

applicationDeviceName:test

applicationDeviceOsName:test

applicationDeviceMacAdr:test

networkIpAdr:test

apiConsumerRecordText:test

Authorization:test

TransactionId:1

Content-Type:application/json

Accept:application/json

employeeId:test

###### Response
{
    "emplId": "0000305566",
    "emplName": "FRANZAGO,  CHARLES M"
}

###### Actuator endpoints (userid: admin, password: secret)
http://localhost:8080/admin/env

http://localhost:8080/admin/health

http://localhost:8080/admin/info

http://localhost:8080/admin/metrics

http://localhost:8080/admin/beans

http://localhost:8080/admin/mappings

http://localhost:8080/admin/configprops


###### REST services

This application exposes different URIs related to employee phone records:

URI 1:

When the application is deployed in the embedded Tomcat: 

http://localhost:8080/example/sql/v1/employees/names

When the application is deployed as a WAR in the external WebSphere Liberty: 

http://localhost:9080/BsPrdTmpltSvcRst/example/sql/v1/employees/names

URI 2:

When the application is deployed in the embedded Tomcat: 

http://localhost:8080/example/sql/v1/employees/phones/records

When the application is deployed as a WAR in the external WebSphere Liberty: 

http://localhost:9080/BsPrdTmpltSvcRst/example/sql/v1/employees/phones/records


URI 3:

JSON Payload to create phone record, use POST

When the application is deployed in the embedded Tomcat: 

http://localhost:8080/example/sql/v1/employees/phones

When the application is deployed as a WAR in the external WebSphere Liberty: 

http://localhost:9080/BsPrdTmpltSvcRst/example/sql/v1/employees/phones

URI 4:

JSON Payload to update phone record, use PUT

When the application is deployed in the embedded Tomcat: 

http://localhost:8080/example/sql/v1/employees/phones

When the application is deployed as a WAR in the external WebSphere Liberty: 

http://localhost:9080/BsPrdTmpltSvcRst/example/sql/v1/employees/phones


URI 5:

JSON Payload to delete phone record, use DELETE

When the application is deployed in the embedded Tomcat: 

http://localhost:8080/example/sql/v1/employees/phones

When the application is deployed as a WAR in the external WebSphere Liberty: 

http://localhost:9080/BsPrdTmpltSvcRst/example/sql/v1/employees/phones

## Create WAR
- Run (Click from Toolbar)
- Run Configuration (Click)
- Gradle Project (Click)
- New Launch Configuration (Click at top left)
- Select the working directory by clicking workspace and selecting the project
- Type assemble in gradle task
- Click apply and Run
- Copy the war from \build\libs\ to another directory
- Once the war is moved type clean in gradle task and run it to clean the directories

## Configure environment variables in Liberty
Configure the following environment variables under \wlp-webProfile7-17.0.0.4\usr\shared\jvm.options

-Dconfig.location=C://app-cnfg//

-Dlog.location=src/main/resources

-DCRUDB_PASSWORD=adaba5

Note: 
- Change the config.location value to the folder containing environment (lcl, test, dvl, int, prd) specific properties file (location should not contain blank space ' '). Make sure to copy them to the server using WinScp or putty etc.
- Change the log.location path to appropriate folder where the logs you want to be generated.
- Change the CRUDB_PASSWORD to oracle database password
- Make sure to restart the server after adding any entry for it to take effect

## Configure datasource in Liberty
https://crewmoddal.atlassian.net/wiki/spaces/BASE/pages/78282889/How+to+configure+JNDI+datasource+in+WebSphere+Liberty

## Configure environment variables for WebSphere 9 
Configure the following environment variables under Application servers > crus32105 > Process definition > Java Virtual Machine > Custom properties.

config.location=C:\Users\408183\GitLab\Base\BsPrdTmpltSvcRst\cnfg\

log.location=src/main/resources

CRUDB_PASSWORD=adaba5

Note: 
- Change the config.location value to the folder containing environment (lcl,dvl,int,prd,test) specific properties file (location should not contain blank space ' '). Make sure to copy them to the server using WinScp or putty etc.
- Change the log.location path to appropriate folder where the logs you want to be generated.
- Change the CRUDB_PASSWORD to oracle database password
- Make sure to restart the server after adding any entry for it to take effect

## Configure datasource in WebSphere 9
https://crewmoddal.atlassian.net/wiki/spaces/BASE/pages/78283156/How+to+configure+database+JNDI+in+WebSphere+9
 
## Logging
Since Base template uses AOP(Aspect oriented programming) for logging, there will not be any log statements inside each individual methods/classes.

Common log statements are available in file AspectsForLogging.java.

For more info on Spring AOP,Please go through

https://crewmoddal.atlassian.net/wiki/spaces/BASE/pages/48464040/POC+for+Spring+AOP+draft

If application needs any specific log statements in methods/classes, developers can add those log statements in the individual methods/classes.
