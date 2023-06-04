# OpenGL

## Install
```
sudo apt-get install mesa-utils
sudo apt-get install freeglut3-dev
```

## Show installed packages
```
$ apt list | grep mesa-utils | grep installed

mesa-utils/focal,now 8.4.0-1build1 amd64 [installed]

$ apt list | grep freeglut3-dev | grep installed

freeglut3-dev/focal,now 2.8.1-3 amd64 [installed]
```

## Show package details (mesa-utils)
```
$ apt show mesa-utils
Package: mesa-utils
Version: 8.4.0-1build1
Priority: extra
Section: universe/graphics
Source: mesa-demos
Origin: Ubuntu
Maintainer: Ubuntu Developers <ubuntu-devel-discuss@lists.ubuntu.com>
Original-Maintainer: Debian X Strike Force <debian-x@lists.debian.org>
Bugs: https://bugs.launchpad.net/ubuntu/+filebug
Installed-Size: 150 kB
Depends: libc6 (>= 2.14), libgl1, libx11-6
Homepage: https://mesa3d.org/
Task: xubuntu-desktop, ubuntustudio-desktop, ubuntu-mate-core, ubuntu-mate-desktop, ubuntu-budgie-desktop
Download-Size: 34.2 kB
APT-Manual-Installed: yes
APT-Sources: http://archive.ubuntu.com/ubuntu focal/universe amd64 Packages
Description: Miscellaneous Mesa GL utilities
 This package provides several basic GL utilities built by Mesa, including
 glxinfo and glxgears.
```

## Show files installed from package
```
$ dpkg -L mesa-utils
/.
/usr
/usr/bin
/usr/bin/glxdemo
/usr/bin/glxgears
/usr/bin/glxheads
/usr/bin/glxinfo
/usr/share
/usr/share/doc
/usr/share/doc/mesa-utils
/usr/share/doc/mesa-utils/changelog.Debian.gz
/usr/share/doc/mesa-utils/copyright
/usr/share/man
/usr/share/man/man1
/usr/share/man/man1/glxdemo.1.gz
/usr/share/man/man1/glxgears.1.gz
/usr/share/man/man1/glxheads.1.gz
/usr/share/man/man1/glxinfo.1.gz
```

```
$ dpkg -L freeglut3-dev
/.
/usr
/usr/include
/usr/include/GL
/usr/include/GL/freeglut.h
/usr/include/GL/freeglut_ext.h
/usr/include/GL/freeglut_std.h
/usr/include/GL/glut.h
/usr/lib
/usr/lib/x86_64-linux-gnu
/usr/lib/x86_64-linux-gnu/libglut.a
/usr/share
/usr/share/doc
/usr/share/doc/freeglut3-dev
/usr/share/doc/freeglut3-dev/copyright
/usr/share/doc/freeglut3-dev/download.html
/usr/share/doc/freeglut3-dev/freeglut.html
/usr/share/doc/freeglut3-dev/freeglut_logo.png
/usr/share/doc/freeglut3-dev/freeglut_user_interface.html
/usr/share/doc/freeglut3-dev/index.html
/usr/share/doc/freeglut3-dev/ogl_sm.png
/usr/share/doc/freeglut3-dev/progress.html
/usr/share/doc/freeglut3-dev/structure.html
/usr/lib/x86_64-linux-gnu/libglut.so
/usr/share/doc/freeglut3-dev/changelog.Debian.gz
```
