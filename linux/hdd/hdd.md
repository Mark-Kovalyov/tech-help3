# HDD daily routine

## List block devices (without loop)
```
$ lsblk -e 7 -o name,size,type,fstype,mountpoint
NAME          SIZE TYPE FSTYPE MOUNTPOINT
sda           3.7T disk xfs    /bigdata
sdb           1.8T disk xfs    
nvme0n1     232.9G disk        
├─nvme0n1p1   512M part vfat   /boot/efi
├─nvme0n1p2     1K part        
└─nvme0n1p5 232.4G part ext4   /
```
