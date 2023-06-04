# RTSP/RTP, IP-Cams, Streaming, SDP, SIP

## Terms

* SDI - Serial Digital Interface

## RTSP/RTP

* Protocol : https://www.ietf.org/rfc/rfc2326.txt

RTSP

|Port|Desc|
|-|-|
|554/TCP|Transport protocol-1|
|554/UDP|Transport protocol-2|
|8554|Alternate|

RTP

|Port|Desc|
|-|-|
|6970..6999||


## Soft

* VLC
  * cvlc (Concole VLC player)
* ffmpeg
* openRTSP

```
ffmpeg
ffmpeg version 4.2.4-1ubuntu0.1 Copyright (c) 2000-2020 the FFmpeg developers
  built with gcc 9 (Ubuntu 9.3.0-10ubuntu2)
  configuration: --prefix=/usr --extra-version=1ubuntu0.1 --toolchain=hardened --libdir=/usr/lib/x86_64-linux-gnu --incdir=/usr/include/x86_64-linux-gnu --arch=amd64 --enable-gpl --disable-stripping --enable-avresample --disable-filter=resample --enable-avisynth --enable-gnutls --enable-ladspa --enable-libaom --enable-libass --enable-libbluray --enable-libbs2b --enable-libcaca --enable-libcdio --enable-libcodec2 --enable-libflite --enable-libfontconfig --enable-libfreetype --enable-libfribidi --enable-libgme --enable-libgsm --enable-libjack --enable-libmp3lame --enable-libmysofa --enable-libopenjpeg --enable-libopenmpt --enable-libopus --enable-libpulse --enable-librsvg --enable-librubberband --enable-libshine --enable-libsnappy --enable-libsoxr --enable-libspeex --enable-libssh --enable-libtheora --enable-libtwolame --enable-libvidstab --enable-libvorbis --enable-libvpx --enable-libwavpack --enable-libwebp --enable-libx265 --enable-libxml2 --enable-libxvid --enable-libzmq --enable-libzvbi --enable-lv2 --enable-omx --enable-openal --enable-opencl --enable-opengl --enable-sdl2 --enable-libdc1394 --enable-libdrm --enable-libiec61883 --enable-nvenc --enable-chromaprint --enable-frei0r --enable-libx264 --enable-shared
  libavutil      56. 31.100 / 56. 31.100
  libavcodec     58. 54.100 / 58. 54.100
  libavformat    58. 29.100 / 58. 29.100
  libavdevice    58.  8.100 / 58.  8.100
  libavfilter     7. 57.100 /  7. 57.100
  libavresample   4.  0.  0 /  4.  0.  0
  libswscale      5.  5.100 /  5.  5.100
  libswresample   3.  5.100 /  3.  5.100
  libpostproc    55.  5.100 / 55.  5.100
Hyper fast Audio and Video encoder
usage: ffmpeg [options] [[infile options] -i infile]... {[outfile options] outfile}...

```

```
$ openRTSP
Usage: openRTSP [-p <startPortNum>] [-r|-q|-4|-i] [-a|-v] [-V]
  [-d <duration>] [-D <max-inter-packet-gap-time> [-c] [-S <offset>]
  [-n] [-O] [-t|-T <http-port>] [-u <username> <password>]
  [-s <initial-seek-time>]|[-U <absolute-seek-time>]
  [-E <absolute-seek-end-time>] [-z <scale>] [-g user-agent]
  [-k <username-for-REGISTER> <password-for-REGISTER>]
  [-P <interval-in-seconds>] [-K] [-w <width> -h <height>]
  [-f <frames-per-second>] [-y] [-H] [-Q [<measurement-interval>]]
  [-F <filename-prefix>] [-b <file-sink-buffer-size>]
  [-B <input-socket-buffer-size>] [-I <input-interface-ip-address>]
  [-m] [<url>|-R [<port-num>]] (or openRTSP -o [-V] <url>)

```

## Mobile soft

* iCSee : https://play.google.com/store/apps/details?id=com.xm.csee

## Links

* https://www.javahelps.com/2017/08/parse-pcap-files-in-java.html

* https://www.oracle.com/java/technologies/javase/java-media-framework.html

* https://netty.io/

## VLC

### VLC application protocols samples:

```
http://ipcam.stream:5080
rtp://@:1234
mms://mms.examples.com/stream.asx
rtsp://server.example.org:8080/test.sdp
rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mp4
```

### Transcode the input stream and send it to a multicast IP address with the associated SAP announce:

```
% vlc -vvv input_stream --sout
'#transcode{vcodec=mp4v,acodec=mpga,vb=800,ab=128,deinterlace}:
rtp{mux=ts,dst=239.255.12.42,sdp=sap,name="TestStream"}'
```

### Stream a SDI card to H.264 and AAC in TS on UDP
```
cvlc -vvv
  --live-caching 2000 decklink://
  --decklink-audio-connection embedded
  --decklink-aspect-ratio 16:9
  --decklink-mode hp50
  --sout-x264-preset slow
  --sout-x264-tune film
  --sout-transcode-threads 8
  --no-sout-x264-interlaced
  --sout-x264-keyint 50
  --sout-x264-lookahead 100 --sout-x264-vbv-maxrate 6000 --sout-x264-vbv-bufsize 6000  
  --sout '#transcode{vcodec=h264,vb=6000,acodec=mp4a,aenc=fdkaac,ab=256}:std{access=udp,mux=ts,dst=192.168.2.1:1234}'
```

See more examples : https://wiki.videolan.org/Documentation:Streaming_HowTo/Command_Line_Examples/


## Recording IP camera Streaming with ffmpeg

```
ffmpeg -i http://admin:admin@192.2.2.1:554/dd-a -c copy -map 0 -f segment -segment_time 300 -segment_format mp4 "outfile.mp4"
```

```
ffmpeg -rtsp_flags listen -i rtsp://ownaddress/live.sdp -codec copy -map 0 -f segment -segment_time 900 -segment_atclocktime 1 out%03d.mp4
```

## With openRTSP
```
openRTSP -D 1 -c -B 10000000 -b 10000000 -q -Q -F cam_eight -d 28800 -P 900 -t -u admin 123456 rtsp://192.168.1.108:554/11
```

## Documents

* https://www.diva-portal.org/smash/get/diva2:832774/FULLTEXT01.pdf

## Protocol interactions example

Client -> Server
```
telnet wowzaec2demo.streamlock.net 554
DESCRIBE rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mp4 RTSP/1.0
CSeq: 2
```

Responce
```
RTSP/1.0 200 OK
CSeq: 2
Server: Wowza Streaming Engine 4.8.18+1 build20220318091926
Cache-Control: no-cache
Expires: Sun, 15 May 2022 21:36:04 UTC
Content-Length: 606
Content-Base: rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mp4/
Date: Sun, 15 May 2022 21:36:04 UTC
Content-Type: application/sdp
Session: 406322368;timeout=60

v=0
o=- 406322368 406322368 IN IP4 34.227.104.115
s=BigBuckBunny_115k.mp4
c=IN IP4 34.227.104.115
t=0 0
a=sdplang:en
a=range:npt=0- 634.625
a=control:*
m=audio 0 RTP/AVP 96
a=rtpmap:96 mpeg4-generic/12000/2
a=fmtp:96 profile-level-id=1;mode=AAC-hbr;sizelength=13;indexlength=3;indexdeltalength=3;config=149056e500
a=control:trackID=1
m=video 0 RTP/AVP 97
a=rtpmap:97 H264/90000
a=fmtp:97 packetization-mode=1;profile-level-id=64000C;sprop-parameter-sets=Z2QADKzZQ8Vv/ACAAGxAAAADAEAAAAwDxQplgA==,aOvssiw=
a=cliprect:0,0,160,240
a=framesize:97 240-160
a=framerate:24.0
a=control:trackID=2
```
```
