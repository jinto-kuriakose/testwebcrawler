# Technical Assignment for Qantas

Simple Web Crawler

# Getting Started

Make sure that you have Java and Maven installed on your computer.
run below command from project directory.

```
mvn clean install
java -jar target\test-webcrawler.war
```

# API Docs
### GET http://localhost:8080/webcrawler?url={url}
This REST API will return a tree of child pages linked to the URL
# Testing
```
mvn test
http://localhost:8080/webcrawler?url=http://localhost:8080/testhtml
```
