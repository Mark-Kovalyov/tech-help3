# XFS

## Make filesystem with label and block size = 1024

```
mkfs.xfs -f -L bigdata -b size=1024 /dev/sdb
```

## Defrag

Estimate degree of frag
```
xfs_db -r -c frag /dev/sda8
```

```
xfs_fsr -v /dev/sda8
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
