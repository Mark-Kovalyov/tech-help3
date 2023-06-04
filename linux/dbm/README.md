# Dbm/Dbu

## Links

* BerkeleyDb C API https://docs.oracle.com/cd/E17076_05/html/api_reference/C/index.html
* GDBM www.gnu.org/software/gdbm/gdbm.html



## Samples API

Ruby
```ruby
require 'dbm'
d=DBM.new("data")
d["abc"]="123"
d.close

e=DBM.open("data")
puts e["abc"]
f=e.to_hash
e.close
```

Python
```python
import dbm

with dbm.open('cache', 'c') as db:

    db[b'hello'] = b'there'
    db['www.python.org'] = 'Python Website'
    db['www.cnn.com'] = 'Cable News Network'

    assert db[b'www.python.org'] == b'Python Website'
    assert db['www.cnn.com'] == b'Cable News Network'

    print(db.get('python.org', b'not present'))

    db['www.yahoo.com'] = 4

# db is automatically closed when leaving the with statement.
```

