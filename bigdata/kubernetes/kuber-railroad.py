from railroad import Diagram, Choice

import sys

d = Diagram("foo", Choice(0, "bar", "baz"))

d.writeSvg(sys.stdout.write)
