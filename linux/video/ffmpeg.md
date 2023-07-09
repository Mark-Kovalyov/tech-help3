# FFMpeg use cases

## Mix Video and Audio from different sources
```
ffmpeg -i "[Anime-Ancestors] Baki The Grappler S1_12.mka" \
       -i "[Anime-Ancestors] Baki The Grappler S1_12.mkv" \
       -c:v copy -c:a copy \
       -map 0:v:0 -map 1:a:0 \
       baki-s01-12.mp4
```

## Encode pictures
```
ffmpeg -framerate -pattern_type glob -i '*.png' -c:v libx264 out.mp4
```


## Encode video with scaling and audio/video codec

```
ffmpeg -i world-smallest-asm-win-app.webm -vcodec libx264 -s 1920x1080 -acodec libvorbis world-smallest-asm-win-app.mp4
```

## Encode anime series, for each file, with change screen size and codec

### Get video info
```
$ mkvinfo 'Temnyj.dvoreckij.(1.sezon.01.serija.iz.24).mkv'
mayton@ryzen-ssd:/bigdata/video.anime/Dvorets.S01$ cat out
+ EBML head
|+ EBML version: 1
|+ EBML read version: 1
|+ Maximum EBML ID length: 4
|+ Maximum EBML size length: 8
|+ Document type: matroska
|+ Document type version: 2
|+ Document type read version: 2
+ Segment: size 809709620
|+ Seek head (subentries will be skipped)
|+ EBML void: size 4044
|+ Segment information
| + Timestamp scale: 1000000
| + Multiplexing application: libebml v1.0.0 + libmatroska v1.0.0
| + Writing application: mkvmerge v4.0.0 ('The Stars were mine') сборка от Jun  6 2010 16:18:42
| + Duration: 00:24:30.570000000
| + Date: Fri Jul 27 21:46:30 2012 UTC
| + Segment UID: 0xb4 0x3c 0xed 0x2c 0xcc 0x42 0x30 0xc7 0xb5 0x5b 0xc8 0x7a 0xc2 0x51 0x61 0xf6
|+ Tracks
| + Track
|  + Track number: 1 (track ID for mkvmerge & mkvextract: 0)
|  + Track UID: 1
|  + Track type: video
|  + Default track flag: 0
|  + Lacing flag: 0
|  + Minimum cache: 1
|  + Codec ID: V_MPEG4/ISO/AVC
|  + Codec's private data: size 43 (H.264 profile: High @L5.0)
|  + Default duration: 00:00:00.041708332 (23.976 frames/fields per second for a video track)
|  + Video track
|   + Pixel width: 1280
|   + Pixel height: 720
|   + Display width: 1280
|   + Display height: 720
| + Track
|  + Track number: 2 (track ID for mkvmerge & mkvextract: 1)
|  + Track UID: 470962859
|  + Track type: audio
|  + Forced track flag: 1
|  + Codec ID: A_AC3
|  + Default duration: 00:00:00.032000000 (31.250 frames/fields per second for a video track)
|  + Language: rus
|  + Name: Persona99
|  + Audio track
|   + Sampling frequency: 48000
|   + Channels: 2
| + Track
|  + Track number: 3 (track ID for mkvmerge & mkvextract: 2)
|  + Track UID: 619191950
|  + Track type: audio
|  + Default track flag: 0
|  + Codec ID: A_AC3
|  + Default duration: 00:00:00.032000000 (31.250 frames/fields per second for a video track)
|  + Language: rus
|  + Name: Persona99 & MaxDamage
|  + Audio track
|   + Sampling frequency: 48000
|   + Channels: 2
| + Track
|  + Track number: 4 (track ID for mkvmerge & mkvextract: 3)
|  + Track UID: 1803333553
|  + Track type: audio
|  + Default track flag: 0
|  + Codec ID: A_AC3
|  + Default duration: 00:00:00.032000000 (31.250 frames/fields per second for a video track)
|  + Language: rus
|  + Name: n_o_i_r
|  + Audio track
|   + Sampling frequency: 48000
|   + Channels: 2
| + Track
|  + Track number: 5 (track ID for mkvmerge & mkvextract: 4)
|  + Track UID: 2095477946
|  + Track type: audio
|  + Default track flag: 0
|  + Codec ID: A_AC3
|  + Default duration: 00:00:00.032000000 (31.250 frames/fields per second for a video track)
|  + Language: rus
|  + Name: sad_kit
|  + Audio track
|   + Sampling frequency: 48000
|   + Channels: 2
| + Track
|  + Track number: 6 (track ID for mkvmerge & mkvextract: 5)
|  + Track UID: 2294941321
|  + Track type: audio
|  + Default track flag: 0
|  + Codec ID: A_AC3
|  + Default duration: 00:00:00.032000000 (31.250 frames/fields per second for a video track)
|  + Language: jpn
|  + Audio track
|   + Sampling frequency: 48000
|   + Channels: 2
| + Track
|  + Track number: 7 (track ID for mkvmerge & mkvextract: 6)
|  + Track UID: 117943477
|  + Track type: audio
|  + Default track flag: 0
|  + Codec ID: A_AC3
|  + Default duration: 00:00:00.032000000 (31.250 frames/fields per second for a video track)
|  + Audio track
|   + Sampling frequency: 48000
|   + Channels: 6
| + Track
|  + Track number: 8 (track ID for mkvmerge & mkvextract: 7)
|  + Track UID: 3306739613
|  + Track type: subtitles
|  + Lacing flag: 0
|  + Codec ID: S_TEXT/ASS
|  + Codec's private data: size 1375
|  + Language: rus
|+ EBML void: size 1266
|+ Cluster

```
The track Track number: 5 (track ID for mkvmerge & mkvextract: 4) sounds good. Lets take it.

Testing
```
ffmpeg -i "Temnyj.dvoreckij.(1.sezon.01.serija.iz.24).mkv" -map 0:v:0 -vcodec libx264 -s 1280x720 -map 0:a:3 -acodec mp3 dvoreckij-01.mp4
```

Scripting for all sequence
```bash
#!/bin/bash -v

for i in $(seq -f "%02g" 1 24)
do
  ifile="Temnyj.dvoreckij.(1.sezon.$i.serija.iz.24).mkv"
  ofile="dvoretsky-$i.mp4"
  ffmpeg -i "$ifile" -map 0:v:0 -vcodec libx264 -s 1280x720 -map 0:a:3 -acodec mp3 "$ofile"
done
```

## Encode with parallel utility
```
$ ls *.mp4 | parallel ffmpeg -i {} fr1/{.}_%d.jpg -hide_banner
```

## Encode audio only with keep video steam as is
```
ffmpeg -i .... -vcodec copy -acodec vorbis .....
```

## Re-map second audio-track
```
ffmpeg -i holmes-shadow-game.mkv -vcodec libx264 -s 816x340 -map 0:a:1 -acodec mp3 holmes-shadow-game-a1.mp4
```

## Cut specific scene from video. Keep audio/video formats as is
```
ffmpeg -i eneida-1991.mp4 -ss 00:12:00 -to 00:14:10 -c:v copy -c:a copy eneida-1991-cut-01.mp4
```

## Change gamma
```
ffmpeg -i vir-lin.mp4 -vf eq=gamma=1.5:saturation=1.3 -c:a copy vir-lin-gamma-1-5.mp4
```

## Create animated gifs
```
ffmpeg -i %04d.png -s 288x162 test.gif
```
