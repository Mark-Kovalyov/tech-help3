# Minikube & KVM

```bash
$ uname -a
Linux ryzen-ssd 5.13.0-39-generic #44~20.04.1-Ubuntu SMP Thu Mar 24 16:43:35 UTC 2022 x86_64 x86_64 x86_64 GNU/Linux

$ sudo kvm-ok
[sudo] password for USER:
INFO: /dev/kvm exists
KVM acceleration can be used

$ sudo apt install libvirt-clients libvirt-daemon-system qemu-kvm

$ sudo usermod -a -G libvirt $(whoami)

$ sudo newgrp libvirt

$ curl -LO https://storage.googleapis.com/minikube/releases/latest/docker-machine-driver-kvm2 \
     && sudo install docker-machine-driver-kvm2 /usr/local/bin/ && rm docker-machine-driver-kvm2

     curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64 \
     >     && sudo install minikube-linux-amd64 /usr/local/bin/minikube && rm minikube-linux-amd64

$ minikube version
minikube version: v1.25.2
commit: 362d5fdc0a3dbee389b3d3f1034e8023e72bd3a7

$ minikube start --vm-driver kvm2
....
Done! kubectl is now configured to use "minikube" cluster and "default" namespace by default

$ kubectl get nodes
NAME       STATUS   ROLES                  AGE   VERSION
minikube   Ready    control-plane,master   50s   v1.23.3

```

## After reboot
```bash
$ kubectl get nodes
Unable to connect to the server: dial tcp 192.168.39.14:8443: connect: no route to host

$ minikube start --vm-driver kvm2

$ kubectl get nodes
NAME       STATUS   ROLES                  AGE    VERSION
minikube   Ready    control-plane,master   2d3h   v1.23.3

```
