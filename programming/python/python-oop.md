# OOP in Python

```python
class Thing:
  def __init__(self, name, price):
    self.name = name
    self.price = price

  def __repr__(self)
    return f"Thing: {self.__dict__}"    
```

## Data classes (constructor, to_string, and equals)

```python
from dataclasses import dataclass

@dataclass
class ThingData:
  name: str
  price: float
```

Do not use mutable structures in @dataclass
```python
class ThingData:
  name: str
  price: float = 0
  dims: list = []
```

```python
class ThingData:
  name: str
  price: float = 0
  dims: list = field(default_factory=list)
```
