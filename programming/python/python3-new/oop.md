# Python OOP

```
class Point:
  color = 'red'
  circle = 2

>>> Point.__dict__
mappingproxy({'__module__': '__main__', 'color': 'red', 'circle': 2, '__dict__': <attribute '__dict__' of 'Point' objects>, '__weakref__': <attribute '__weakref__' of 'Point' objects>, '__doc__': None})
>>>   
```
## Create instance
```
>>> a = Point()

>>> isinstance(a, Point)
True
```
## Change attribute (object or class!)
```
>>> setattr(a, 'color', 'gray')

>>> a.color
'gray'
```
## Check for attribute exists
```
>>> getattr(Point, 'a', False)
False
```
## Delete attribute from namespace (object or class)
```
>>> del Point.color

// Check 

>>> hasattr(Point, 'circle')
False

```
## Yet another case with delete
```
>>> delattr(Point, 'circle')
```

