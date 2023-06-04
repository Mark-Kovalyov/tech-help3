# mtn-pcap-ds

## Links

* https://wiki.wireshark.org/Development/LibpcapFileFormat

## Capture




### Wireshark
```
sudo wireshark -i eth0 tcp src 192.168.1.100 -w output.pcap
```

* pcap. The default format used by the libpcap packet 
  capture library. Used by tcpdump, _Snort, Nmap, 
  Ntop, and many other tools.
* pcapng. A flexible, extensible successor to the pcap format. 
  Wireshark 1.8 and later save files as pcapng by default. 
  Versions prior to 1.8 used pcap. Used by Wireshark and 
  by tcpdump in newer versions of macOS.

#### Libraries

* libpcap: the origin of this file format (for UN*X based systems)
  * https://www.tcpdump.org/
* Jpcap: JAVA based libpcap wrapper
  * https://github.com/jpcap/jpcap/
  
#### Libpcap

PCAPNG (PCAP Next Generation) is a packet capture file format that was introduced as an improvement over the original PCAP format. It was designed to overcome some of the limitations of the PCAP format and provide additional features.

The PCAPNG format allows for capturing and storing additional information about captured packets, such as interface descriptions, timestamps with higher resolution, and additional metadata. It also supports capturing packets from multiple interfaces and different packet types, such as Ethernet, Wi-Fi, and Bluetooth.

The PCAPNG format is also more extensible than the PCAP format, allowing for the inclusion of custom metadata and the ability to capture and store more types of data than just network packets.

### TCPDump
```
sudo tcpdump -i eth0 tcp src 192.168.1.100 -w output.pcap
```
