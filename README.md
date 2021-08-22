# TestTask-ABSoft
Напишите автоматический сценарий/сценарии для проверки фильтрации записей по тегам на сайте https://demo.realworld.io.  
Добавьте документацию, необходимую для работы с вашим проектом автоматизации. Загрузите код проекта в публичный репозиторий на GitHub и поделитесь ссылкой на него.  
Приветствуется использование следующей связки инструментов: Java + TestNG + Gradle + Selenium + Allure.

(опционально) Разверните demo realworlds app самостоятельно на любой удобной платформе (Docker, AWS, GCP, etc.)и задокументируйте процесс развертывания. Напишите сценарий, аналогичный UI сценарию для проверки API.
## Tools and technologies
- Java
- Maven
- Selenium
- TestNG
- Allure
## Steps to run test and get report
#### Copy repository  
```git clone https://github.com/HugeMadWorld/TestTask-ABSoft.git```  
#### Run test  
```mvn clean test```  
#### Generate allure report
Report will be generated into temp folder and opened into web browser.  
  
```mvn allure:serve```
