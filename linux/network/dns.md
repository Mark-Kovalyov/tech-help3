# DNS

## Network

|Port|Protocol|
|----|--------|
|53  |UDP

## Dns Records

### A record

TYPE | NAME       | IP        | TTL
-----|------------|-----------|----
A    |example.com |12.34.56.78| 7200

### Qaud-A Record

TYPE | NAME       | IP               | TTL
-----|------------|------------------|----
AAAA |example.com |2501:0:54::23:c2ff|7200

### CNAME


TYPE | NAME       | ALIAS TO         | TTL
-----|------------|------------------|----
CNAME|www.ex.com  |ex.com            |7200

### Mail Records (MX)

TYPE | PRIORITY   | NAME         | HOST              | TTL
-----|------------|--------------|-------------------|------
MX   | 10         | example.com  | mail1.example.com | 7200



### SOA (start of authority)

TYPE | MNAME      | RNAME            | SERIAL#           | RETRY | TTL
-----|------------|------------------|-------------------|-------|-----
SOA  | ns1.ex.com | admin.example.com| 57468268          | 60    | 7200

* ns1.ex.com - primary name server
* admin.example.com - email address of the administrator

### NS

TYPE | VALUE      | NAME        | TTL
-----|------------|-------------|-------
NS   | ns1.ex.com | example.com | 7200
NS   | ns2.ex.com | example.com | 7200

### SRV

TYPE | PRIORITY   | SERVICE          | PORT | NAME        | WEIGHT | TTL
-----|------------|------------------|------|-------------|--------|-----
SRV  |    10      | XMPP             | 5223 | example.com |   5    | 86400

#### advanced SRV fields from Cloudflare

  KEY | VALUE
------|-------
proto | TCP
class | IN
target| server.example.com

### PTR
TYPE | IP-ADDR    | NAME             | TTL
-----|------------|------------------|-----
PTR  | 44.44.44.44| ex.info          | 1000

### TXT (general contact information)

TYPE | NAME       | VALUE            | TTL
-----|------------|------------------|-----
PTR  | 44.44.44.44| ex.info          | 1000


* Point to specific service with port number
  * Voice IP
  * Twitter
  * ....

### SPF (?)

SPF records are a type of DNS TXT record commonly used for email authentication. SPF records include a list of IP addresses and domains authorized to send emails from that domain.

#### example
* DNS ZONE1
  * shop.example.com
  * blog.example.com
* DNS ZONE2
  * support.example.com

### Hierachy

```
example.com => [.] [com] [example]
               root
                   top
                         2st level
```



## Format Request

```rust
use std::io::Read;
use std::mem;
use std::slice;

#[repr(C, packed)]
struct DNSPacket {
    // Header 12 bytes
    id: i32,
    //    Flags:
    //      QR : { 0 - req, 1 - resp }
    //      OPCODE(4bit) : 0 - standard
    //      AA : isAuth
    //      TC : isCropped
    //      RD : req for recursive
    //      RA : req allowed
    //      Z : reserved
    //      RCODE(4bit) : state = { 0 - success, others - error }
    flags: i32,    
    countReq: i32,
    countResp: i32,
    countAuthResp: i32,
    countAdvResp: i32,
    // Body
    dnsReqs: [DNSReq; ?],
    //  Body:resp
    dnsResp: [DNSResp: ?],
    authServers: ?,
    advancedInfo: ?
}
```

## Format Record

```rust
#[repr(C, packed)]
struct DNSPacket {
  name  : String, // www.google.com
  type  : String, // 1 (A-record)
  class : String // 1 (IN - Internet)
}
```

## Типы серверов

* Итеративный
  * Если сервер отвечает за данную зону - он возвращает ответ
  * Если не отвечает - то возвращает адрес DNS сервера у которого
    есть более точная информаци
* Рекурсивный
  * Сервер сам выполняет запросы к другим серверам чтоб найти
    нужный адрес


Корневые обычно работают в итеративном режиме.

## Типы ответов

* Authoritative - заслуживающий доверия.
* Non-Authoritative - получен из кеша

## Reverse request

|prefix|suffix|
|------|------|
|20.112.52.29|in-addr.arpa.
||ip6.arpa.


## Docs

* RFC-1035 https://datatracker.ietf.org/doc/html/rfc1035

## Top public DNS
Provider      |Primary DNS    |Secondary DNS
--------------|---------------|-------------
Google        |8.8.8.8        |8.8.4.4
Control D     |76.76.2.0      |76.76.10.0
Quad9         |9.9.9.9        |149.112.112.112
OpenDNS Home  |208.67.222.222 |208.67.220.220
Cloudflare    |1.1.1.1        |1.0.0.1
CleanBrowsing |185.228.168.9  |185.228.169.9
Alternate DNS |76.76.19.19    |76.223.122.150
AdGuard DNS   |94.140.14.14   |94.140.15.15
Yandex DNS    |77.88.8.8      |77.88.8.1

## Message format

```yaml
dns-message:
  header:
    id: 16bit
    qr: 1bit
    opcode:
  question:
  answer:
  authority:
  additional:
```
