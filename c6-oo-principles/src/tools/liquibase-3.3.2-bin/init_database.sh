./liquibase --driver=org.postgresql.Driver \
          --classpath=driver.jar \
          --url="jdbc:postgresql://localhost:5432/shopping_mall" \
          --changeLogFile="changelog.xml" \
          --username=twer \
          --password=123456 \
          update