# Java/Scala and CosmosDb


## Create collection 
```
libraryDependencies += "com.azure" % "azure-cosmos" % "4.30.0"
```


```scala
import com.azure.cosmos._
import com.azure.cosmos.models._

object Main {
	def main(args: Array[String]) : Unit = {
		val clientBuilder = new CosmosClientBuilder()

		val cosmosClient = clientBuilder
			.endpoint("https://......azure.com:443")
			.key("*********************")
			.consistencyLevel(ConsistencyLevel.EVENTUAL)
			.buildClient()

		val dbName = "scott"

		val ccp = new CosmosContainerProperties("emp", "/id")
		val cosmosDb = cosmosClient.getDatabase(dbName)
		val res = cosmosDatabase.createContainerIfNotExists(ccp)

		println(s"status = ${res.getStatusCode}")
	}
}
```
