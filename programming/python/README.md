# Python

https://www.python.org/

## Versions

```bash
$ python3 -VV
Python 3.8.10 (default, Jun  2 2021, 10:49:15)
[GCC 9.4.0]

$ python2 --version
Python 2.7.18
```

```python
>>> import sys
>>> sys.version_info
sys.version_info(major=3, minor=8, micro=10, releaselevel='final', serial=0)
>>>
```

## Get Type

```
filelist = dbutils.fs.ls(".......")
type(filelist[0])
```
```
Out : dbruntime.dbutils.FileInfo
```

## Plot

```bash
pip install matplotlib
```

```python3
from matplotlib import pyplot as plt

years = [1950, 1960]
gpd = [300.2, 543.3]

plt.plot(years, gdp, color='green', marker='o',)
```

## Using specific Unicode symbols

```
"\N{GREEK CAPITAL LETTER DELTA}" # Char name
"\u0394"       # 16 bit hex val
"\U00000394"   # 32 bit hex val
```
get code
```
ord("\u0394")
916
```
wrap non ascii
```
def asciiWrap(s : str) -> str:
  buf = ""
  for ch in range(0, len(s)):
    if s[ch].isasscii():
      buf = buf + s[ch]
    else:  
      buf = buf + "\\u" + '{:04X}'.format(ord(s[ch]))
  return buf
```


## Numba

Numba is an open source JIT compiler that translates a subset of Python and NumPy code into fast machine code.

* https://numba.pydata.org/

## Other popular python libs:

* Telegram
  * python-telegram-bot. A wrapper you can't refuse.
  * pyTelegramBotAPI. A simple, but extensible Python implementation for the Telegram Bot API.
  * AIOGram. A pretty simple and fully asynchronous library for Telegram Bot API written with asyncio and aiohttp.
  * TGramBot. A partially auto-generated and asynchronous Minimal Telegram Bot API framework.
  * OrigamiBot. A pythonic Telegram bot API library.
  * telefone. A modern Telegram Bot API framework built with speed and stability in mind.
  * pytgbot. A module to access the Telegram Bot API.
  * teleflask. A framework based on flask and pytgbot.
* Web
  * flask - https://flask.palletsprojects.com/en/2.1.x/
  * urllib3
  * requests
* Wep-scraping
  * BeautifulSoup https://www.crummy.com/software/BeautifulSoup/bs4/doc/  
  * Grab https://github.com/lorien/grab
* Science
  * numpy - https://numpy.org/
  * scipy https://scipy.org/
  * tensorflow-gpu https://www.tensorflow.org/guide/gpu
  * tensorflow_addons
* Linquistic  
  * razdel - сегментация русскоязычного текста на токены и предложения
  * sentencepiece - Python wrapper for SentencePiece. This API will offer the encoding, decoding and training of Sentencepiece.
  * tokenizers - Provides an implementation of today's most used tokenizers, with a focus on performance and versatility.
* Utils
  * tqdm -Progress Bar :) https://github.com/tqdm/tqdm
  * six - Six is a Python 2 and 3 compatibility library.
* BigData
  * Pyspark - pyspark
* Unknown
  * transformers
  * time
  * sys
  * telebot
  * os
  * asyncio


  >>> dict = {
  ...   "a": "1",
  ...   "b": "2",
  ...   "dict2": {
  ...     "c": "3",
  ...     "d": "4",
  ...   }
  ... }
  >>>
  >>> for i in dict:
  ...   print(type(dict[i]))
  ...
  <class 'str'>
  <class 'str'>
  <class 'dict'>


## Roman Duskin about Python

```
Почему в Пайтоне:
- для удаления єлемнта из списка используется ключевое слово
- для вставки - срез или метод
- для вычисления длины - функция 
```