Project Overview

This project is a Selenium-based automation framework developed to test the Craftyfy e-commerce web application. The framework validates core user flows such as login, product browsing, cart operations, and order placement using Java, Selenium WebDriver, TestNG, and Maven, following Page Object Model (POM) design principles

Tech Stack:
Programming Language: Java
Automation Tool: Selenium WebDriver
Test Framework: TestNG
Build Tool: Maven
Design Pattern: Page Object Model (POM)
Reporting: TestNG Reports
Version Control: Git

CraftyfyProject
│
├── src/test/java
│   ├── base
│   ├── listeners
│   ├── pages
│   ├── testcases
│   └── utility
│ 
│
├── src/test/resources
│   ├── 
│   └── config.properties
│
├── target
│   ├── screenshots
│   
├── test-output
│   └── junit-reports
│
├── pom.xml
├── testng.xml
└── README.md

Prerequesites
Ensure the following are installed on your system:

-Java JDK 8 or above
-Maven
-Git
-Chrome browser
-ChromeDriver 

Setup Instructions
1. Clone the Repository
git clone <your-github-repo-url>
cd CraftyfyProject

2. Configure Browser & Environment
Update browser settings in config.properties if applicable
Ensure ChromeDriver path is properly set (or managed via WebDriverManager)

Install Dependencies
mvn clean install

How to Run Tests

Run using TestNG XML 
mvn test

Screenshot Handling:

Screenshots are automatically captured only when a test fails
Implemented using TestNG Listeners
Stored under:
target/screenshots/

Challenges Addressed:

- Handling dynamic elements using Explicit Waits
- Capturing screenshots automatically on failures
- Validating negative scenarios where UI error messages are not available

