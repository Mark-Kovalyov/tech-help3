# Clouds

## Azure

### Usefull software

* Azure Storage Explorer

Usefull config
```
az config set extension.use_dynamic_install=yes_without_prompt
```
Login
```
az login --use-device-code
```
get
```
[
  {
    "cloudName": "AzureCloud",
    "homeTenantId": "************",
    "id": "*************",
    "isDefault": true,
    "managedByTenants": [],
    "name": "Azure subscription 1",
    "state": "Enabled",
    "tenantId": "**************",
    "user": {
      "name": "user@mail.com",
      "type": "user"
    }
  }
]
```
### Directory list

```
az storage blob directory list -c MyContainer -d DestinationDirectoryPath --account-name MyStorageAccount
```


### Copy

```
az storage file copy ...
az storage azcopy blob  ....
az storage blob copy ...
```



## AWS:

```
cat config
[default]
region = eu-central-1
output = json

cat credentials
[default]
aws_access_key_id = ************
aws_secret_access_key = **************************
```

## List buckets

### S3
```
aws s3api list-buckets --output text
```
### Azure
```
az
```

## List files
```
aws s3 ls s3://vd --recursive --human-readable --summarize
```

## Copy to current folder
```
aws cp s3://path/file .
```
