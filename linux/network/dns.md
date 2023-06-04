# DNS

## Network

|Port|Protocol|
|----|--------|
|53  |UDP

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
