# Kubernetes

## Master processes

* Cluster Gateway
* Acts as a gatekeeper for auth

## Pod

* Smallest unit of K8s
* Abstraction over container
* Usually 1 application per Pod
* Each Pod gets its own IP addr
* New IP address on re-creation

## Service

* Permanent IP

## Ingress

* Has an address like : https://my-app.com

## ConfigMap and Secret

```
DB_URL = mongo-db

```
(dont put credentials into ConfigMap!)

### Secret

* Used to store secret data
* Base64 encoded

## Deployment

* DB cannot be replicated via Deployment
* Avoid data inconsistencies
* Deploying StatefulSet not eazy

## StatefulSet


## Ubuntu Install

```
sudo snap install microk8s --classic
sudo chown -f -R $USER ~/.kube
```
re-log-in user session
```
microk8s status --wait-ready
microk8s enable dashboard dns ingress
microk8s kubectl get all --all-namespaces
microk8s dashboard-proxy
```





## Links

* https://www.youtube.com/watch?v=X48VuDVv0do
