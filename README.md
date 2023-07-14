Task: Automation test.

For automate the seenario i have used following technology

Tech stack: Java, Selenium, TestNG, Allure report

I have used the Page Object Model pattern where the page files are separate and the test files are also kept separate.
For data sharing i used excel file at project root folder.

We can run the seenario separately or full seenario from xml which is located our resource folder.
Use different method implement for testing purpose in methods package

Using allure report
Go to the project root folder
run cmd type command for install allure

windows -- pm install allure-commandline --save-dev  (Will be different for other operating system)

then run allure serve allure-results

java -jar jenkins.war --enable-future-java  --httpPort=8080