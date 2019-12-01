# TestAPI
- Внести в pom.xml, необходимые зависмости.
- Используя json-simple, сформировать JSON объект, с необходимыми полями. 
- Описать запрос используя стилистику: given, when, then.
- Использовать аннотацию @Test для определения и запуска теста. 

#### Add the follwing Plugins and Dependencies #### 

- add rest-assured dependency
```
<dependency>
      <groupId>io.rest-assured</groupId>
      <artifactId>rest-assured</artifactId>
      <version>4.1.2</version>
      <scope>test</scope>
</dependency>

```
- json-simple
```
       <dependency>
            <groupId>com.googlecode.json-simple</groupId>
            <artifactId>json-simple</artifactId>
            <version>1.1</version>
            <scope>test</scope>
        </dependency>
```
- maven-compiler-plugin 
```
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
```
- maven-surefire-plugin
```
 <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.20</version>
                <configuration>
                    <suiteXmlFiles>
                        <suiteXmlFile>TestNG.xml</suiteXmlFile>
                    </suiteXmlFiles>
                    <argLine>
                        -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
                    </argLine>
                </configuration>
```

- aspectj
```
                <dependencies>
                    <dependency>
                        <groupId>org.aspectj</groupId>
                        <artifactId>aspectjweaver</artifactId>
                        <version>${aspectj.version}</version>
                    </dependency>
                </dependencies>
```

- testng
```
<dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>6.14.3</version>
        </dependency>
```
