# Wireshark / Tcpdump

## Examples

### Capture inbound UDP packets to 51413 (Transission listener)

```

```

### The same with tcpdump
```
sudo tcpdump -i wlp7s0 udp port 51413
```
with body
```
sudo tcpdump -i wlp7s0 -X udp port 51413
```
with disable name resolution
```
sudo tcpdump -n -i wlp7s0 -X udp port 51413
```
with saving into *pcap file
```
sudo tcpdump -n -i wlp7s0 -w transmission-dht.pcap -X udp port 51413
```
### To convert a pcap file into another format using tcpdump, use the following command:
```
tcpdump -r input.pcap -A > output.txt
```
In this command, replace "input.pcap" with the name of the pcap file you want to convert and "output.txt" with the name of the file you want to save the converted output to. The "-A" option is used to convert the captured packets into ASCII text format.

## To capture specific destination IP
```
..... udp port 51413 and dst host <destination_ip>
```

## Appendix

### tdpdump help
```
$ tcpdump --help
tcpdump version 4.9.3
libpcap version 1.9.1 (with TPACKET_V3)
OpenSSL 1.1.1f  31 Mar 2020
Usage: tcpdump [-aAbdDefhHIJKlLnNOpqStuUvxX#] [ -B size ] [ -c count ]
		[ -C file_size ] [ -E algo:secret ] [ -F file ] [ -G seconds ]
		[ -i interface ] [ -j tstamptype ] [ -M secret ] [ --number ]
		[ -Q in|out|inout ]
		[ -r file ] [ -s snaplen ] [ --time-stamp-precision precision ]
		[ --immediate-mode ] [ -T type ] [ --version ] [ -V file ]
		[ -w file ] [ -W filecount ] [ -y datalinktype ] [ -z postrotate-command ]
		[ -Z user ] [ expression ]
```
