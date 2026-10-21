Just for quick reference,syntax,examples etc:
-------------Sure fire maven plugin sample -----------------------------------
Sample Maven sure fire plugin format: eg:
<build>
<plugins>
<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-surefire-plugin</artifactId>
<version>3.5.4</version>
<configuration>
<suiteXmlFiles>
<suiteXmlFile>testng.xml</suiteXmlFile>
</suiteXmlFiles>
</configuration>
</plugin>
</plugins>
</build>
============================================================================

The important distinction is that not declaring Surefire in the POM does not mean Surefire is absent. 
Maven's default lifecycle bindings can invoke it automatically. 
An explicit declaration lets you select its version and configure its behavior.

=====================TestNG xml sample=========================================
testng.xml sample code for reference:
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="AutomationSuite">
    <test name="SmokeTests">
        <classes>
            <class name="tests.LoginTest"/>
            <class name="tests.CheckoutTest"/>
        </classes>
    </test>
</suite>
===================================================================