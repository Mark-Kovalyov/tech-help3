# SWAP

## Info
```
swapon -s
Filename				Type		Size	Used	Priority
/swapfile                              	file    	2097148	713728	-2
```
### Swap free
```
$ free -m
              total        used        free      shared  buff/cache   available
Mem:          15916        6394         891         102        8630        9097
Swap:          2047         697        1350
```
### swap by processes
```
$ smem
  PID User     Command                         Swap      USS      PSS      RSS
11890 user     /bin/bash                       2532        4       24     2208
.....................
```


## Quick scenario to change SWAP location

* swapoff /dev/hda3
* mkswap /dev/hda4
* swapon /dev/hda4

## Details

Disable swap
```
sudo swapoff -a -v
```
After that we can remove partition
```
?????
```

Allocate new

```
sudo fallocate -l 1G /swapfile
sudo dd if=/dev/zero of=/bigdata/swapfile bs=1024 count=1048576
sudo chmod 600 /swapfile
sudo mkswap /swapfile
sudo swapon /swapfile
```

Not recommended to use Btrfs with SWAP!


## Sysctl

/etc/sysctl.conf
```
swapiness=60
```
## Advises
* Make sure you do not have a SWAP on the SSD, again to reduce write cycles
* If you have a mechanical drive, then you should create a SWAP space on the mechanical drive and avoid having it on SSD.
