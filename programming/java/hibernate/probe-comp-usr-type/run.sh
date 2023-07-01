export MAVEN_OPTS="-verbose:class"

mvn compile exec:java -Dexec.mainClass=mayton.hibernate.jpa.JpaTest
