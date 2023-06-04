# SWAP

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
sudo dd if=/dev/zero of=/swapfile bs=1024 count=1048576
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
