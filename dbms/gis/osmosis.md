# Osmosis

## Overpass XML, and Overpass QL.

```
node(50.745,7.17,50.75,7.18);
out;

node(50.745,7.17,50.75,7.18)[highway=bus_stop];
out;

node(50.745,7.17,50.75,7.18);way(bn);
( ._; >; );
out;
```
### QL
```
node
  ["name"~"holtorf|Gielgen"]
  (50.7,7.1,50.8,7.25);
out body;
```
### XML
```
<osm-script>
  <query type="node">
    <has-kv k="name" regv="holtorf|Gielgen"/>
    <bbox-query e="7.25" n="50.8" s="50.7" w="7.1"/>
  </query>
  <print/>
</osm-script>
```



```
$ osmosis

Example Usage

Import a planet file into a local PostgreSQL database.

osmosis --read-xml file=~/osm/planbet/planet.osm --write-apidb host="x" database="x" user="x" password="x"

Export a planet file from a local PostgreSQL database.

osmosis --read-apidb host="x" database="x" user="x" password="x" --write-xml file="planet.osm"

Derive a change set between two planet files.

osmosis --read-xml file="planet2.osm" --read-xml file="planet1.osm" --derive-change --write-xml-change file="planetdiff-1-2.osc"

Derive a change set between a planet file and a database.

osmosis --read-mysql host="x" database="x" user="x" password="x" --read-xml file="planet1.osm" --derive-change --write-xml-change file="planetdiff-1-2.osc"

Apply a change set to a planet file.

osmosis --read-xml-change file="planetdiff-1-2.osc" --read-xml file="planet1.osm" --apply-change --write-xml file="planet2.osm"

Sort the contents of a planet file.

osmosis --read-xml file="data.osm" --sort type="TypeThenId" --write-xml file="data-sorted.osm"

The above examples make use of the default pipe connection feature, however a simple read and write planet file command line could be written in two ways. The first example uses default pipe connection, the second explicitly connects the two components using a pipe named "mypipe". The default pipe connection will always work so long as each task is specified in the correct order.

osmosis --read-xml file="planetin.osm" --write-xml file="planetout.osm"

osmosis --read-xml file="planetin.osm" outPipe.0="mypipe" --write-xml file="planetout.osm" inPipe.0="mypipe"

Full usage details are available at: http://wiki.openstreetmap.org/wiki/Osmosis/Detailed_Usage

```
