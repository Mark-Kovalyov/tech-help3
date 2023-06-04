# SSD

## properties
* Block 512 bytes
* Pagesize 4K
* Cells:
  * SLC : 0,1 (single level)
  * MLC : 00,10,11,01 (multi level)
  * TLC : 000..111 (Triple)
  * QLC : 0001..1111 (Quad)
* SLC cache (small size ~10Gb)

## Advices:
* Not recommeded to fill greather than 80-85%, may cause performance degradation
* Not recommeded to full-format.
* No sense to defragment.
* The partition should start on a clean 1Mb boundary so that block
size of the FileSusyem aligns with the block size of the SSD.

## Terminology
* FTL - Flash Translation Layer

## Side effects:
* write aplification issue
* significant FTL GC responsibilities
* inevitable FS GC overhear
* read disturbance
* retention issue



## Trim
* Command to clean block? or Page?

## Ext4 + Trim
* EXT4 with trim improoves performance

### Windows

```
>fsutil behavior query disabledeletenotify
NTFS DisableDeleteNotify = 0  (Disabled)
ReFS DisableDeleteNotify = 0  (Disabled)

fsutil behavior set disabledeletenotify 0
```
see also
```
winsat diskformal
```

### Linux
```

```


## f2fs

```
Usage: mkfs.f2fs [options] device [sectors]
[options]:
  -a heap-based allocation [default:0]
  -c [device path] up to 7 devices excepts meta device
  -d debug level [default:0]
  -e [cold file ext list] e.g. "mp3,gif,mov"
  -E [hot file ext list] e.g. "db"
  -f force overwrite the exist filesystem
  -i extended node bitmap, node ratio is 20% by default
  -l label
  -m support zoned block device [default:0]
  -o overprovision ratio [default:5]
  -O [feature list] e.g. "encrypt"
  -q quiet mode
  -s # of segments per section [default:1]
  -S sparse mode
  -t 0: nodiscard, 1: discard [default:1]
  -w wanted sector size
  -z # of sections per zone [default:1]
sectors: number of sectors. [default: determined by device size]
```
