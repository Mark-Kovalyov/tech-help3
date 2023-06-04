# Kubernetes FAQ

## Q: Where is config?
```
$ echo $KUBECONFIG
/home/$USER/.kube/config
```

## Q: Contexts?
```
$ kubectl config get-contexts
$ URRENT   NAME       CLUSTER    AUTHINFO   NAMESPACE
*         minikube   minikube   minikube   default

# ---- Show current:
$ kubectl config current-context   

# ---- Switch
$ kubectl config use-context <my-cluster-name>
```

## Q : Unable to connect to the server: dial tcp *:8443: connect: no route to host
```
A : minikube start

$ kubectl get nodes
NAME       STATUS   ROLES                  AGE   VERSION
minikube   Ready    control-plane,master   35d   v1.23.3

```

## Q : Last version?
```
kubectl version
1.24
GoVersion:"go1.18.3"
```
