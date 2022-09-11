# Recipe Manager

*Springboot application that provides API's to allow users to manage their favourite recipes. It allows add, update, remove, fetch recipes, & filter recipes with given criteria*
 - *Whether dish is veg or non-veg*
 - *The number of servings*
 - *And combination of attributes such as dish can serve for 4, which include potato as ingredient*
 - *Specific ingredients included/excluded*
 - *Text search within the instructions*



## Initial setup

Prerequisites/Installations used

```bash
  spring-tool-suite-3.9.12 (IDE)
  postgresql-14.5-1  & Its client
  Gradle (wrapper)
  Springboot 2.5.7
  lombok v1.18.24 ( install for IDE, for ex. 'java -jar lombok.jar' then select your IDE to install )
  ```
    
## API Reference
#### /swagger-ui/index.html

    http(s)://<server>/api/v1/recipes/search


This API helps to search Recipe by its attributes

- Search by category
- Search by combination of category/ingredient/searving_no..etc

 ![search](https://user-images.githubusercontent.com/37103790/189521386-b59a9eb1-f014-40f2-8dc7-535c194b4208.png)

#### *APIs for Create/Update/Delete Recipe*
  Below Image is self explainatory about respective endpoints
  
![crud](https://user-images.githubusercontent.com/37103790/189521376-4d306dbb-51e4-4740-b6ca-3fa4136b36d3.png)

#### *DB schema*


![db](https://user-images.githubusercontent.com/37103790/189487126-6828c439-903d-4f2d-81da-9a4c81af2218.png)



## Run Locally
### PostgreSQL
```bash
  1. Make sure PostgresQL DB is up and running
  2. Ensure scripts db/migration/v1/recipe.sql are executed manually/automatically ( can implement automation by any opensource flywaydb or any alternativs
  3. build the project , for ex. here gradlew used with STS.
  	-	'./gradlew.bat clean build'
  4. Run the spring boot with default profile.
   - go to jar file location i.e. 'recipe-0.0.1-SNAPSHOT.jar' , and execute 'java -jar recipe-0.0.1-SNAPSHOT.jar' 
```
### H2
```bash
  1. Make sure uncomment H2 related properties in the application-local.properties
  2. Make sure comment PostgreSQL dependency, and uncomment H2 dependencis in the build.gradlew
  3. Use spring profile "local" while running springboot 
  4.build the project , for ex. here gradlew used with STS.
  	-	'./gradlew.bat clean build'
  5. Run the spring boot with default profile.
   - go to jar file location i.e. 'recipe-0.0.1-SNAPSHOT.jar' , and execute 'java -jar -Dspring.profiles.active=local recipe-0.0.1-SNAPSHOT.jar' 
  6. Open /h2/console , and run insertion queries from src/main/db/data.sql
  
  
  ```




## Other Info

- Dockerfile is added, which helps to build images and use it create container.
- Provided /actuator endpoints,  same can be seen **/actuator** endpoint of the application.


![actuator](https://user-images.githubusercontent.com/37103790/189521706-98c7ffd1-ac59-489e-84c7-0118765acc77.png)
- Unit & Integration tests are performed minimally as below


![testResu](https://user-images.githubusercontent.com/37103790/189521389-ecc22056-a9fc-4682-a3c7-517691667ab6.png)
## 🚀 Thank you ,[Bharath Kumar Pappisetty ](www.linkedin.com/in/bharathpappisetty) !
