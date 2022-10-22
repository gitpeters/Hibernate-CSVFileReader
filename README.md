# Hibernate-CSV File Reader

This is hibernate refactor of `maven projects` that reads and authenticates CSV file and stores the record in a database

### Result
![result](https://user-images.githubusercontent.com/111524304/193449914-2a6ee312-db97-4131-8be2-48dd8759dcf2.jpg)

## For contributions/update
```git
git clone https://github.com/gitpeters/Hibernate-CSVFileReader.git
git add .
git commit -m"update"
git push
```

## Dependencies
Add the following dependencies to the `pom.xml` file
```java
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-csv</artifactId>
            <version>1.8</version>
        </dependency>
        
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.30</version>
        </dependency>
        
        <!-- https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-core -->
        <dependency>
            <groupId>org.hibernate.orm</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>6.1.4.Final</version>
        </dependency>
```
## CSV File
Download the CSV file used in this project [here](https://github.com/gitpeters/Hibernate-CSVFileReader/files/9843862/People-data.csv)
## For use
fork [gitpeters/Hibernate-CSVFileReader.git](https://github.com/gitpeters/Hibernate-CSVFileReader.git)
```git
git pull
git add .
git checkout -b new_branch
git status
git commit -m"updated"
git push -u new_branch
```
