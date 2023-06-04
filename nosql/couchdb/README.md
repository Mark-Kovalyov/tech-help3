# CouchDb

## Links

* https://docs.couchdb.org/en/stable/

gets a list of all of the databases in a CouchDB instance
```
/_all_dbs
```

Create index
```
POST /{db}/_index
```

Get all documents
```
GET /{db}/_all_docs
```

Get document by id
```
GET /{db}/{docid}
```

Get attribute
```
GET /{db}/{docid}/{attname}
```
