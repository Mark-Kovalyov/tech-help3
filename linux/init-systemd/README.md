# Init.d - SystemD

## See

* https://www.youtube.com/watch?v=AKGnZnvUIvE

## SystemD
```
/usr/lib/systemd - with app
/run/systemd/system - dynamic units
/etc/systemd/system - changed by admin
```

### Unit types

* Service
* Device
* Target
* mount
* automount
* timer
* socket
* path
* slice
* snapshot

### SystemCtl

```
systemctl status
systemctl status nginx
systemctl restart ....
systemctl reload ....
```

Check is enabled
```
$ systemctl is-enabled nginx
enabled
```
Enable/Disable
```
$ systemctl enable nginx
$ systemctl disable nginx
```
Mask/Unmask
```
$ systemctl mask ...
```

### Check desired target state for SystemCtl
```
systemctl get-default
graphical.target
```

Possible targets:
```
systemctl list-units --type=target
```

* rescue.target
* multi-user.target
* graphical.target

Set server style target:
```
systemctl set-default multi-user.target
```

### Create own Service

1) Lets describe nginx unit for example
```
systemctl cat nginx.service

[Unit]
Description=A high performance web server and a reverse proxy server
Documentation=man:nginx(8)
After=network.target

[Service]
Type=forking
PIDFile=/run/nginx.pid
ExecStartPre=/usr/sbin/nginx -t -q -g 'daemon on; master_process on;'
ExecStart=/usr/sbin/nginx -g 'daemon on; master_process on;'
ExecReload=/usr/sbin/nginx -g 'daemon on; master_process on;' -s reload
ExecStop=-/sbin/start-stop-daemon --quiet --stop --retry QUIT/5 --pidfile /run/nginx.pid
TimeoutStopSec=5
KillMode=mixed

[Install]
WantedBy=multi-user.target
```

2) Other interesting parameters:
```
User=Vasya
Group=VasyaGroup
WorkingDirectory=/home/Basil
Environment="VAR1=word1 word2" VAR2=word3
OOMScoreAdjust=[-1000...1000]
```

3) Create "jetty-service"


```
vim /etc/systemd/system/jetty.service
```

```
[Unit]
After=network.target

[Service]
ExecStart=/home/jetty/jetty.sh
Restart=always
WorkingDirectory=/home/jetty
User=mtn
Group=mtn
Environment="TMP=/tmp"

[Install]
WantedBy=multi-user.target
```

```
systemctl daemon-reload
systemctl enable jetty.service
systemctl start jetty.service
systemctl status jetty.service
```

4) Edit if needed :
```
systemctl edit jetty --full
```
