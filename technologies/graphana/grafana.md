# Grafana

Grafana open source software enables you to query, visualize, alert on, 
and explore your metrics, logs, and traces wherever they are stored. 
Grafana OSS provides you with tools to turn your time-series database 
(TSDB) data into insightful graphs and visualizations.

## From local

```

```

## From docker

```
docker pull grafana/grafana
docker run -d --name=grafana -p 3000:3000 grafana/grafana
```

## Data sources for Grafana

* MySQL
* MongoDb
* Graphite
* Time Series:
  * InfluxDb
  * OpenTSDB
* Postgresql
* Elasticsearch
* Azure Monitor
* Prometheus
* Loki
* files
  * Infinity (JSON,CSV,XML,GraphQL,HTML)
