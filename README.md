BeAutomationFramework
=====================

📌 Overview
-----------

**BeAutomationFramework** is a robust **Backend API Automation Framework** designed to perform end-to-end testing of backend services.It is scalable, maintainable, and provides rich, interactive reports for every test run.

🚀 Key Features
---------------

*   **API Testing**: Built with [RestAssured](https://rest-assured.io/) for concise and readable API tests.
    
*   **Test Management**: Uses [TestNG](https://testng.org/) for test execution, grouping, and data-driven testing.
    
*   **Reporting**: Integrates with [ExtentReports](https://www.extentreports.com/) to generate interactive HTML reports.
    
*   **Retries**: Custom RetryAnalyzer to re-run failed tests and improve stability.
    
*   **Data-Driven Testing**: Supports @DataProvider to run tests with multiple datasets.
    
*   **Logging**: Configurable logging powered by [Log4j2](https://logging.apache.org/log4j/2.x/).
    
*   **Code Simplification**: Uses [Lombok](https://projectlombok.org/) to reduce boilerplate code.
    

🛠️ Prerequisites
-----------------

Ensure you have the following installed on your system:

*   **Java JDK** 11 or higher
    
*   **Apache Maven**
    
*   IDE of your choice (e.g., IntelliJ IDEA, Eclipse)
    

⚡ Getting Started
-----------------

1️⃣ Clone the Repository

git clone https://github.com/AniketDas24/BeAutomationFramework.git

cd BeAutomationFramework

### 2️⃣ Run the Tests

Execute the test suite with:

mvn clean install

This will:

*   Compile the project
    
*   Run the tests (based on testng.xml)
    
*   Generate reports
    

### 3️⃣ View the Report

After execution, open the HTML report located at:

target/test-output/Test-Report-\*.html

Open this file in your browser to explore detailed test results with visual dashboards.

### 📖 Configuration

*   **TestNG suite**: Modify src/test/resources/testng.xml to customize test execution (groups, parallel runs, etc.).
    
*   **Logging**: Configure logging levels and appenders in src/test/resources/log4j2.xml.
    

### 🤝 Contributing

Contributions are welcome!

1.  Fork the repo
    
2.  Create a feature branch
    
3.  Submit a pull request
    

### 📜 License

This project is licensed under the MIT License.

You are free to use, modify, and distribute this project with proper attribution.

✅ Built with ❤️ using Java, RestAssured, TestNG, ExtentReports, and Log4j2
