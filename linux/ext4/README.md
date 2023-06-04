# EXT4

## History:
* 1992 - ext
* 1993 - ext2
* 2001 - ext3 + journaling
* 2008 - ext4 became the Linux default FS

## Make label (ext2/ext3/ext4)

```
e2label /dev/sda1 Webserver
```

## Tunning ext4 for compillation

https://serverfault.com/questions/230925/whats-the-fastest-filesystem-for-developer-builds

advice1
```
noatime
```

advice2
```
mkfs.ext4 -O dir_index,extent -i 8096 /dev/<disk>

 -i bytes-per-inode
        Specify  the bytes/inode ratio.  mke2fs creates an inode for every bytes-per-inode bytes of space on the disk.  The larger the bytes-per-inode ratio, the
        fewer inodes will be created.  This value generally shouldn't be smaller than the blocksize of the filesystem, since in that case more  inodes  would  be
        made  than can ever be used.  Be warned that it is not possible to change this ratio on a filesystem after it is created, so be careful deciding the cor
        rect value for this parameter.  Note that resizing a filesystem changes the number of inodes to maintain this ratio.

 -O [^]feature[,...]
        Create a filesystem with the given features (filesystem options), overriding the default filesystem options.  The features that are  enabled  by  default
        are  specified  by  the base_features relation, either in the [defaults] section in the /etc/mke2fs.conf configuration file, or in the [fs_types] subsec
        tions for the usage types as specified by the -T option, further modified by the features relation found in the [fs_types] subsections for the filesystem
        and  usage  types.  See the mke2fs.conf(5) manual page for more details.  The filesystem type-specific configuration setting found in the [fs_types] sec
        tion will override the global default found in [defaults].

        The filesystem feature set will be further edited using either the feature set specified by this option, or if this option  is  not  given,  by  the  de
        fault_features relation for the filesystem type being created, or in the [defaults] section of the configuration file.

        The filesystem feature set is comprised of a list of features, separated by commas, that are to be enabled.  To disable a feature, simply prefix the fea
        ture name with a caret ('^') character.  Features with dependencies will not be removed successfully.  The pseudo-filesystem feature  "none"  will  clear
        all filesystem features.

  For more information about the features which can be set, please see
         the manual page ext4(5).
```
