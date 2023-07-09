# XFS

## LSBLK
```
$ lsblk -e 7 -o name,size,type,fstype,mountpoint,label
NAME          SIZE TYPE FSTYPE MOUNTPOINT LABEL
sdb           1.8T disk xfs               backup2
...           ..............              .......
```

## XFS info
```
$ sudo xfs_info /dev/sdb
meta-data=/dev/sdb               isize=512    agcount=4, agsize=122094662 blks
         =                       sectsz=4096  attr=2, projid32bit=1
         =                       crc=1        finobt=1, sparse=1, rmapbt=0
         =                       reflink=1
data     =                       bsize=4096   blocks=488378646, imaxpct=5
         =                       sunit=0      swidth=0 blks
naming   =version 2              bsize=4096   ascii-ci=0, ftype=1
log      =internal log           bsize=4096   blocks=238466, version=2
         =                       sectsz=4096  sunit=1 blks, lazy-count=1
realtime =none                   extsz=4096   blocks=0, rtextents=0
```

## Make filesystem with label and block size = 1024

```
mkfs.xfs -f -L bigdata -b size=1024 /dev/sdb
```

## What about 'noatime' attribute?

В некоторых файловых системах можно повысить производительность, добавив параметр монтирования noatime в файле /etc/fstab. Для XFS стандартным поведением atime является relatime, которое почти не имеет накладных расходов по сравнению с noatime, но при этом сохраняет нормальные значения atime. Все файловые системы Linux теперь используют это в качестве значения по умолчанию (примерно с версии 2.6.30), но XFS использует relatime-поведение с 2006 года, поэтому нет никакой необходимости использовать noatime по соображениям производительности.

## Defrag

Estimate degree of frag
```
$ sudo xfs_db -c frag -r /dev/sdb
 actual 209196, ideal 198090, fragmentation factor 5.31%
Note, this number is largely meaningless.
Files on this filesystem average 1.06 extents per file
```

(must be mounted before)
```
xfs_fsr /dev/sdb
```


## XFS copy

xfs_copy - copy the contents of an XFS filesystem


## Repair

```
xfs_repair /dev/sd?
```

## Add label

```
xfs_io -c label -s "MYNEWLABEL" /MNTPOINT
```

## Incremental backup with level

```
xfsdump -l 0 -f /root/dump0.xfsdump /mnt

.... changes

xfsdump -l 1 -f /root/dump1.xfsdump /mnt
```

## Restore (Simple, Cumulative, Interactive)

### Simple

```
xfsrestore -f /root/dump0.xfsdump /mnt
```

### Full (dump0 - is first)

```
xfsrestore -r -f /root/dump0.xfsdump /mnt
```

### Interactive (i)

```
xfsrestore -i ....
```
