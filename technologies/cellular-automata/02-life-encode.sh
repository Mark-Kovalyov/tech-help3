#!/bin/bash -v


ffmpeg -i video/i%04d.png -c:v libvpx -b:v 1M video/output.webm

