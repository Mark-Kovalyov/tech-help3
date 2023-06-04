# Cool Python features

# Len

from collections import namedtuple

Car = namedtuple("Car", ["color","brand"])

class Garage:

  def __init__(self):
    self._cars = [
      Car(color="brown",brand="BMW")
    ]

  def __len__(self):
    return len(self._cars)

  def __getitem__(self._position):
    return self._cars[position]

# ------------------

import Car, Garage

garage = Garage()

len(garage)
3

garage[1]
....

## Positional arguments

def somefunc(x,y,/):
  print(x,y)

somefunc(1,2)

somefunc(a=1,b=2) # Doesnt work

# New string interpolation

# Instead

f'name = {name}'

# Use

f'{name=}'


# New assigned operator

import re

hello = "Hello, Vasya"
if (name := re.search(r', (.*)!', hello))
  print(name.group(1))


# Typed Dict

from typing import TypedDict

class Client(TypedDict):
  id: int
  name: str

client = Client(id=1, name="Vasya")

