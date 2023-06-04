# Kubernetes

* Youtube community : https://www.youtube.com/kubernetescommunity
* https://kubernetes.io/docs/reference/kubectl/overview/
* https://www.youtube.com/watch?v=ErvySVWY0g8

## Architecture

* Master
* Node
  * Kubelet
* Pod (has IP adress)
  * Singleton
  * Sidecar
  * Ambassador
  * Adapter
* Service (front)  
  * types : { selector | non-selector }
  * { clusterIp | NodePort | LB | ExternalName }
  * has Round-Robin DNS
  * balances applications
  * Selectors

## Practice 1

Simple NodeJS microservice app.
* Two app : foo/bar
* foo - service foo
* bar - service bar

bar/Dockerfile
```
FROM node:10.11

COPY ./ /usr/src/app

WORKDIR /usr/src/app

RUN  npm install

EXPOSE 3002

CMD ["npm", "start"]
```
CMD
```
docker build -t bar:v1 .

docker run -p 3002:3002 -d bar:v1
```
foo/Dockerfile
```
FROM node:10.11

COPY ./ /usr/src/app

WORKDIR /usr/src/app

RUN  npm install

EXPOSE 3001

CMD ["npm", "start"]


```
build and run
```
docker build foo/foo:v1
docker build bar/bar:v1
docker images
...
docker run -p 3001:3001
docker run -p 3002:3002
```

## Kubernetes dashboard

* http://localhost:44105/

## Deploy into Kubernetes

bar/deployment.yaml
```
apiVersion: extensions/v1beta1
kind: Deployment
metadata:
  name: kube-bar-app
spec:
  replicas: 3
  selector:
    matchLabels:
      app: kube-bar-app
  template:
    metadata:
      labels:
        app: kube-bar-app
    spec:
      containers:
        - name: kube-bar-app
          image: ssporyshev/bar:v2
          ports:
          - containerPort: 3002
            protocol: TCP
```
foo/deployment
```
apiVersion: extensions/v1beta1
kind: Deployment
metadata:
  name: kube-foo-app
spec:
  replicas: 3
  selector:
    matchLabels:
      app: kube-foo-app
  template:
    metadata:
      labels:
        app: kube-foo-app
    spec:
      containers:
        - name: kube-foo-app
          image: ssporyshev/foo:v2
          ports:
          - containerPort: 3001
            protocol: TCP
```
deploy
```
$ kubectl apply -f foo/deployment.yaml
$ kubectl apply -f bar/deployment.yaml
```

list pods
```
$ kubectl get pods
```

enter into terminal of current pod
```
$ kubectl exec -ti kube-foo-app-....... bash
```
create service
```
$ kubectl apply -f foo/service.yaml
$ kubectl apply -f bar/service.yaml
```
let show status of services
```
$ kubectl get svc
....
```

## kubectl
```
kubectl controls the Kubernetes cluster manager.

 Find more information at: https://kubernetes.io/docs/reference/kubectl/overview/

Basic Commands (Beginner):
  create        Create a resource from a file or from stdin
  expose        Take a replication controller, service, deployment or pod and expose it as a new Kubernetes service
  run           Run a particular image on the cluster
  set           Set specific features on objects

Basic Commands (Intermediate):
  explain       Get documentation for a resource
  get           Display one or many resources
  edit          Edit a resource on the server
  delete        Delete resources by file names, stdin, resources and names, or by resources and label selector

Deploy Commands:
  rollout       Manage the rollout of a resource
  scale         Set a new size for a deployment, replica set, or replication controller
  autoscale     Auto-scale a deployment, replica set, stateful set, or replication controller

Cluster Management Commands:
  certificate   Modify certificate resources.
  cluster-info  Display cluster information
  top           Display resource (CPU/memory) usage
  cordon        Mark node as unschedulable
  uncordon      Mark node as schedulable
  drain         Drain node in preparation for maintenance
  taint         Update the taints on one or more nodes

Troubleshooting and Debugging Commands:
  describe      Show details of a specific resource or group of resources
  logs          Print the logs for a container in a pod
  attach        Attach to a running container
  exec          Execute a command in a container
  port-forward  Forward one or more local ports to a pod
  proxy         Run a proxy to the Kubernetes API server
  cp            Copy files and directories to and from containers
  auth          Inspect authorization
  debug         Create debugging sessions for troubleshooting workloads and nodes

Advanced Commands:
  diff          Diff the live version against a would-be applied version
  apply         Apply a configuration to a resource by file name or stdin
  patch         Update fields of a resource
  replace       Replace a resource by file name or stdin
  wait          Experimental: Wait for a specific condition on one or many resources
  kustomize     Build a kustomization target from a directory or URL.

Settings Commands:
  label         Update the labels on a resource
  annotate      Update the annotations on a resource
  completion    Output shell completion code for the specified shell (bash, zsh or fish)

Other Commands:
  alpha         Commands for features in alpha
  api-resources Print the supported API resources on the server
  api-versions  Print the supported API versions on the server, in the form of "group/version"
  config        Modify kubeconfig files
  plugin        Provides utilities for interacting with plugins
  version       Print the client and server version information

Usage:
  kubectl [flags] [options]

Use "kubectl <command> --help" for more information about a given command.
Use "kubectl options" for a list of global command-line options (applies to all commands).
```
