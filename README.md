# QAEngineerTest

Berikut ini merupakan tools dan setup process untuk Automation Test Cucumber

Tools :
•	Java 19.0.1 
•	IntelliJ IDEA
•	Chromedriver
•	Maven  

Steps :
•	Install Java, Maven dan IDE pada device anda
•	Buat project baru pada IDE (IntelliJ)
•	Install plugin yang dibutuhkan : Cucumber for Java , Gherkin
•	Tambahkan beberapa dependency ke pom.xml yang sudah ada di StockbitTest/pom.xml  pada repository di atas
•	Buat directory baru untuk menambahkan chromedriver yang sudah di download. 
Untuk pathnya dapat di lihat di StockbitTest/driver/chromedriver.exe 
•	Buat directory StepDefinitions dan TestRunner seperti pada StockbitTest/src/test/java dan Features pada StockbitTest/src/test/resources/Features
•	Buat feature yand dibutuhkan serta create step Definition dari masing masing Scenario
•	Run test pada feature menggunakan TestRunner
•	Lihat hasilnya pada terminal 
