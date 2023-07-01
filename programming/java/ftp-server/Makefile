compile:
	mkdir -p bin
	mvn clean package -DskipTests
	mvn install dependency:copy-dependencies
	rsync -avh target/ftp-server.jar ./bin 
	rsync -avh target/dependency/* ./bin --delete

run: compile
	java -jar bin/ftp-server.jar
