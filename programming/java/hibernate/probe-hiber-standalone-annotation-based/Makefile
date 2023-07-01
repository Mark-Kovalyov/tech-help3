run:
	mvn clean compile exec:java \
          -Dexec.mainClass=mayton.hibernate.ManageEmployee \
          -Dexec.cleanupDaemonThreads=true

flyway-clean:
	mvn flyway:clean \
         -Dflyway.url=jdbc:postgresql://127.0.0.1:5432/dht \
         -Dflyway.user=mayton \
         -Dflyway.password=*** \
         -Dflyway.schemas=probe \
         -Dflyway.locations=filesystem:./sql

flyway-migrate:
	mvn flyway:migrate \
         -Dflyway.url=jdbc:postgresql://127.0.0.1:5432/dht \
         -Dflyway.user=mayton \
         -Dflyway.password=***** \
         -Dflyway.schemas=probe \
         -Dflyway.locations=filesystem:./sql


