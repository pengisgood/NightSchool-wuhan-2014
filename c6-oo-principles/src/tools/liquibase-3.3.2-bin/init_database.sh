./liquibase --driver=org.postgresql.Driver \
          --classpath=driver.jar \
          --url="jdbc:postgresql://localhost:5432/postgres" \
          --changeLogFile="changelog.xml" \
          --username=postgres \
          --password=postgres \
          update