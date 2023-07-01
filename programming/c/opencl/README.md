# OpenCL / CUDA e.t.c

OpenCL
* https://www.khronos.org/opencl/

Heterogenous compute acceleration for
* CPU
* CPU
* FPGA
* DSP
* AI / Tensor HW
* Custom

## C++ for OpenCL

```
clang -cl-std=clc++ test.cl
```

```
OpenCL C       =>
                     Clang => LLVM => SPIR-V LLVM IR Translator => SPIR => OpenCL
C++ for OpenCL =>

```

## Install OPenCL

apt install ocl-icd-opencl-dev


## Hardware
```
lshw -C display
  *-display                 
       description: VGA compatible controller
       product: Ellesmere [Radeon RX 470/480/570/570X/580/580X/590]
       vendor: Advanced Micro Devices, Inc. [AMD/ATI]
       physical id: 0
       bus info: pci@0000:09:00.0
       version: ef
       width: 64 bits
       clock: 33MHz
       capabilities: pm pciexpress msi vga_controller bus_master cap_list rom
       configuration: driver=amdgpu latency=0
       resources: irq:70 memory:e0000000-efffffff memory:f0000000-f01fffff ioport:f000(size=256) memory:fe800000-fe83ffff memory:c0000-dffff
```

```
glxinfo -B
name of display: :0
display: :0  screen: 0
direct rendering: Yes
Extended renderer info (GLX_MESA_query_renderer):
    Vendor: AMD (0x1002)
    Device: Radeon RX 570 Series (POLARIS10, DRM 3.40.0, 5.11.0-40-generic, LLVM 12.0.0) (0x67df)
    Version: 21.0.3
    Accelerated: yes
    Video memory: 4096MB
    Unified memory: no
    Preferred profile: core (0x1)
    Max core profile version: 4.6
    Max compat profile version: 4.6
    Max GLES1 profile version: 1.1
    Max GLES[23] profile version: 3.2
Memory info (GL_ATI_meminfo):
    VBO free memory - total: 3571 MB, largest block: 3571 MB
    VBO free aux. memory - total: 4016 MB, largest block: 4016 MB
    Texture free memory - total: 3571 MB, largest block: 3571 MB
    Texture free aux. memory - total: 4016 MB, largest block: 4016 MB
    Renderbuffer free memory - total: 3571 MB, largest block: 3571 MB
    Renderbuffer free aux. memory - total: 4016 MB, largest block: 4016 MB
Memory info (GL_NVX_gpu_memory_info):
    Dedicated video memory: 4096 MB
    Total available memory: 8192 MB
    Currently available dedicated video memory: 3571 MB
OpenGL vendor string: AMD
OpenGL renderer string: Radeon RX 570 Series (POLARIS10, DRM 3.40.0, 5.11.0-40-generic, LLVM 12.0.0)
OpenGL core profile version string: 4.6 (Core Profile) Mesa 21.0.3
OpenGL core profile shading language version string: 4.60
OpenGL core profile context flags: (none)
OpenGL core profile profile mask: core profile

OpenGL version string: 4.6 (Compatibility Profile) Mesa 21.0.3
OpenGL shading language version string: 4.60
OpenGL context flags: (none)
OpenGL profile mask: compatibility profile

OpenGL ES profile version string: OpenGL ES 3.2 Mesa 21.0.3
OpenGL ES profile shading language version string: OpenGL ES GLSL ES 3.20

```

## Install
```
apt install ocl-icd-opencl-dev
apt install mesa-utils ?
```

## Compile

```
gcc -I /path-to-AMD/include -L/path-to-AMD/lib/x86_64 -o hello hello.c -Wl,-rpath,/path-to-AMD/lib/x86_64 -lOpenCL
```
