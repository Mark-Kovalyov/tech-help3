# Shape files

## Points

* part of shapelib
* ESRI shapefiles and ascociated *.dbf
* ARCGis
* ARCView

## Toolset

* shpcreate - create an empty ESRI shapefile
* shpinfo - Displays basic information for a given shapefile
* shpdump - dumps as text and/or validates the content of an ESRI shapefile

## Shpcreate
```
shpcreate shp_file [point|arc|polygon|multipoint]
```

## Shpinfo
```

```

## Shpadd
```
$ shpadd
shpadd shp_file [[x y] [+]]*
  or
shpadd shp_file -m [[x y m] [+]]*
  or
shpadd shp_file -z [[x y z] [+]]*
  or
shpadd shp_file -zm [[x y z m] [+]]*
```

## Shpdump
```
shpdump [-validate] [-ho] [-precision number] shp_file
```