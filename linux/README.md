# Linux

## Forums

* LINUX.ORG.RU https://www.linux.org.ru/forum/development/


## Create flash USB-stick from .iso image

```
sudo dd bs=4M if=path/to/input.iso of=/dev/sd* conv=fdatasync  status=progress
```

## Extract from *.tgz

```
tar -xf ...
```
