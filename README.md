Série des tutorials pour Spring Sécurity: 
https://www.javainuse.com/boot3/sec
1) Branche inMemory : configuration Basic avec InMemory Authentication
2) 
3) 
MySQL :
By default, data.sql scripts get executed before the Hibernate is initialized. We need Hibernate to create our tables before inserting the data into them. To achieve this, we need to defer the initialization of our data source. We’ll use the below property to achieve this:
spring.jpa.defer-datasource-initialization=true

Configuartion Database with Spring Boot : https://www.baeldung.com/spring-boot-data-sql-and-schema-sql