# selenium-java SevenSender Task1
Automation of KOMOOT.COM using Page Object/Page Factory 

## Prerequisites 
   Check JAVA and MAVEN system **cmd command**
   ```
   java -version  
   mvn -version
   ```
### Follow steps if JAVA and MAVEN is not installed   
  - JAVA https://www.oracle.com/java/technologies/javase-downloads.html
  - Apache Maven https://maven.apache.org/download.cgi
   
  - How to download and install JAVA https://www.guru99.com/install-java.html
    also need to set Environment Variables 
  - For JAVA https://mkyong.com/java/how-to-set-java_home-on-windows-10/
  - For MAVEN https://mkyong.com/maven/how-to-install-maven-in-windows/
  - Configuration should be look like this (https://i.ibb.co/z8PB6ZW/selenium.jpg)
    
### Browser Version 
- Chrome Version 88.0.4324.150 (Official Build) (64-bit)
- Firefox 85.0.2 (64-bit)

### IF Browser Version Error 
- Check https://www.selenium.dev/downloads/ and download supported webdriver for respective browser 
  and replace into *SRC/MAIN/RESOURCES*

-------------------------------------------------------------------------------------------------------------------------------------------------

## How to run Test Cases
- Copy Project and open into **eclipse IDE**
- Under *src/test/java* go to package **testCases** open script and run as **TESTNG TEST**
- To Run all testCases in one click, go to *src/test/resources* and run **KomootTestSuit.xml**

### Test Case Decription
#### TC001_simpleLoginTest
- Launching Browser (opening browser, maximizing window, navigate to URL)
- Click on **ACCEPT ALL**
- Enter **EMAIL**
- Click on **continueWithEmail**
- ENter **Encrypted Paswword** 
- Click on **LOGIN**
- Compare *Expected and Actual User* then print **ACTUAL USER** *(get text from page)*
- Close Browser

#### TC002_pageTitleTest
- Launching Browser (opening browser, maximizing window, navigate to URL)
- Click on **ACCEPT ALL**
- **CTR** and click **Discover, Route planner, Features** *opening window in new tab*
- Get title of page and print on CONSOLE
- Close Browser

#### TC003_shopPriceTest
- Logged in according to ***TC001_simpleLoginTest***
- Click on **SHOP**
- Extract Text for packageType 
- Using if else loop print Price of pack
- Close Browser

#### TC004_routesAndTopics
- Logged in according to ***TC001_simpleLoginTest***
- Click on **Browse routes and topics**
- Extract Text from all 14 elements 
- Print on console
- Close Browser

#### TC005_dataDrivenSimpleLogin
- Logged in according to ***TC001_simpleLoginTest***
- This Test Case use **data.properties** *(src.main/resources)* to get necessary values 
- **ADVANTAGES - Can eaisly switch to different browser, different enviournment like DEV, LIVE, STAGING and users.**
- Close Browser
 -----------------------------------------------------------------------------------------------------------------------------------------------------

###Results
- Go to *target* -> *surefire-reports* -> *Suite* -> index.xml



💪 Mastering automation testing to improve software quality

🚀 Unleashing the potential of using Selenium WebDriver for automation

