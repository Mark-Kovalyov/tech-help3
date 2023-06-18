# Geo search systems

## MaxMind


## Geo street map

https://planet.openstreetmap.org/

### Last weekly planet XML (126G)

https://planet.openstreetmap.org/planet/planet-latest.osm.bz2

### Last weekly changeset  

https://planet.openstreetmap.org/planet/changesets-latest.osm.bz2

### Last weekly PBF (70G)

https://planet.openstreetmap.org/pbf/planet-latest.osm.pbf

### Parse

PBF (Protocol Buffer Binary Format) is a binary format for OpenStreetMap data.
In order to parse PBF files, you will need to use a programming language that supports the Protocol Buffers
library. Here are the general steps you can follow:

* Install the Protocol Buffers library for your programming language.
* Define a data structure that matches the schema of the OpenStreetMap data model.
* Use the Protocol Buffers library to deserialize the PBF file into instances of your data structure.
* Process the data as needed.

Here is an example of how to parse a PBF file in Python using the protobuf library:

```
import osmium
import sys

class OSMHandler(osmium.SimpleHandler):
    def __init__(self):
        osmium.SimpleHandler.__init__(self)

    def node(self, n):
        print(n)

if __name__ == '__main__':
    if len(sys.argv) != 2:
        print("Usage: {} FILENAME.osm.pbf".format(sys.argv[0]))
        sys.exit(-1)

    input_file = sys.argv[1]

    handler = OSMHandler()
    reader = osmium.osm.reader(input_file)
    reader.apply(handler)

```

This example uses the Osmium library, which is a C++ library that provides Python bindings for parsing
OpenStreetMap data in PBF format. The OSMHandler class defines a method node that will be called for each
node in the PBF file. The reader.apply(handler) method reads the PBF file and applies the handler to each object in the file.

You can customize the OSMHandler class to process the OpenStreetMap data as needed. For example, you can
define methods to handle ways and relations, or you can filter the data to only process certain tags.
