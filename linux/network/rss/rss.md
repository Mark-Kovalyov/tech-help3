# RSS

## NewsRoom
```
$ newsroom --help

    $ newsroom

      Enter an interactive mode to choose your source.

    $ newsroom <source> <number>

    Source:

      Choose one of the following source:
      hackernews, techcrunch, inside, bnext, ithome, wanqu, nodeweekly, codetengu, gankio

    Number:

      The amount you want to see at a time. The default is 5.

    Options:

      -o    The path of your own OPML file. More about OPML format -> http://dev.opml.org/

    Examples:

    - Get hackernews

      $ newsroom hackernews

    - Get 10 latest TechCrunch news

      $ newsroom techcrunch 10

```

## Install
```
sudo npm install -g newsroom-cli
newsroom -o <your-awesome-list.opml>
```

Misc
```
https://www.rt.com/rss/news/
http://www.forbes.com/rss/
```

Habr
```
Все вопросы: https://qna.habr.com/rss/questions_latest/
Вопросы своего аккаунта: https://qna.habr.com/rss/feed/идентификатор аккаунта типа 5343ef0c6....
Node.js: https://qna.habr.com/rss/tag_questions/157899
Tkinter: https://qna.habr.com/rss/tag_questions/229901
Delphi: https://qna.habr.com/rss/tag_questions/604
```

## OPML file

* http://opml.org/

```
<?xml version="1.0" encoding="UTF-8"?>
<opml version="1.0">
 <head>
   <title>Рекомендуемые RSS-потоки</title>
   <ownerName>Имя владельца списка</ownerName>
   <ownerEmail>exmpl@exmpl.com</ownerEmail>
 </head>
```

## RSS file

```
<?xml version="1.0" encoding="utf-8"?>
<rss xmlns:media="http://search.yahoo.com/mrss/" xmlns:content="http://purl.org/rss/1.0/modules/content/" xmlns:atom="http://www.w3.org/2005/Atom" xmlns:dc="http://purl.org/dc/elements/1.1/" version="2.0">
    <channel>
        <title>RT World News</title>
        <link>https://www.rt.com/news/</link>
        <description>RT World News</description>
        <language>en</language>
        <lastBuildDate>Wed, 18 May 2022 10:36:37 +0000</lastBuildDate>
        <copyright>RT</copyright>
        <atom:link href="https://www.rt.com/rss/news" rel="self" type="application/rss+xml" />
```

## Atom file

```
<?xml version="1.0" encoding="utf-8"?>
<feed xmlns="http://www.w3.org/2005/Atom">
  <title>Мой блог</title>
  <subtitle>Самый лучший блог на свете</subtitle>
  <link href="http://example.org/"/>
  <updated>2003-12-13T18:30:02Z</updated>
```
