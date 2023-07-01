run:
	mvn clean compile exec:java \
        -Dexec.mainClass=mayton.hibernate.ManageEmployee \
        -Dexec.cleanupDaemonThreads=true

