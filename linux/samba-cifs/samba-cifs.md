# Ubuntu and SMB/Cifs

## Ports

|Port|Protocol|Desc|
|-|-|-|
|137|UDP|NetBios/Name resolution|
|138|UDP|NetBios/Name resolution|
|139|TCP|NetBios/Name resolution|
|445|TCP|After Windows 2000|

* CIFS is a common file sharing protocol used by Windows servers and compatible NAS devices.

* Samba is an open-source implementation of Microsoft Active Directory that allows non-Windows machines to communicate with a Windows network.

```
Do you want to install package samba?

Samba is an implementation of the SMB/CIFS protocol for Unix systems, providing support for cross-platform file and printer sharing with Microsoft Windows, OS X, and other Unix systems.  Samba can also function as an NT4-style domain controller, and can integrate with both NT4 domains and Active Directory realms as a member server.

 This package provides the components necessary to use Samba as a stand-alone file and print server or as an NT4 or Active Directory domain controller. For use in an NT4 domain or Active Directory realm, you will also need the winbind package.

This package is not required for connecting to existing SMB/CIFS servers (see smbclient) or for mounting remote filesystems (see cifs-utils).
```

Newest services added
```
nmbd.service                                           loaded active running Samba NMB
packagekit.service                                     loaded active running PackageKit
smbd.service                                           loaded active running Samba SMB
```

```
systemctl status nmbd.service
● nmbd.service - Samba NMB Daemon

systemctl status packagekit.service
● packagekit.service - PackageKit Daemon

systemctl status smbd.service
● smbd.service - Samba SMB Daemon

```
