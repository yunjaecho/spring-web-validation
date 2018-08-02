메이븐 패키징시 exe 파일 처럼 단독 실행 가능한 파일 만들기


<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <executable>true</executable>
            </configuration>
        </plugin>
    </plugins>
</build>


위부분에 아래 항목 추가 되면 끝 

<configuration>
    <executable>true</executable>
</configuration>
