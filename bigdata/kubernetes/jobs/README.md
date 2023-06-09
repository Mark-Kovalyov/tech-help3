# Kubernetes JOBS

* https://www.youtube.com/watch?v=PxVe2YHfUQ

## CronJobs

* Scheduler
* Restart policy
* concurrent policy

cron.yaml
```
apiVersion: batch/v1beta1
kind: CronJob
metadata:
  name: kube-go-cron
spec:
  schedule: "* * * * *"
  concurrencyPolicy: "Forbid"
  jobTemplate:
    spec:
      template:
        spec:
          volumes:
          - name: logs-storage
            persistentVolumeClaim:
              claimName: go-test-pvc
          restartPolicy: Never
          containers:
          - name: kube-go-cron
            image: ssporyshev/wb_go_cron:v1
            command: ["go",  "run", "main.go"]
            volumeMounts:
              - mountPath: "/usr/src/app/logs"
                name: logs-storage
```

```
$ kubectl get cronjobs
```
