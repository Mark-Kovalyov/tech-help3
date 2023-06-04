# UPnP (Universal Plug and Play)

## Netis router

```
Use UPnp or Nat-PMP port forwarding
```

## UPNPC

```
$ upnpc -a 192.168.254.10 2222 7777
```

* http://miniupnp.free.fr/
* https://miniupnp.tuxfamily.org/

```
$ upnpc
upnpc : miniupnpc library test client, version 2.1.
 (c) 2005-2019 Thomas Bernard.
Go to http://miniupnp.free.fr/ or https://miniupnp.tuxfamily.org/
for more information.
Usage :	upnpc [options] -a ip port external_port protocol [duration] [remote host]
		Add port redirection
       	upnpc [options] -d external_port protocol [remote host]
		Delete port redirection
       	upnpc [options] -s
		Get Connection status
       	upnpc [options] -l
		List redirections
       	upnpc [options] -L
		List redirections (using GetListOfPortMappings (for IGD:2 only)
       	upnpc [options] -n ip port external_port protocol [duration] [remote host]
		Add (any) port redirection allowing IGD to use alternative external_port (for IGD:2 only)
       	upnpc [options] -N external_port_start external_port_end protocol [manage]
		Delete range of port redirections (for IGD:2 only)
       	upnpc [options] -r port1 [external_port1] protocol1 [port2 [external_port2] protocol2] [...]
		Add all redirections to the current host
       	upnpc [options] -A remote_ip remote_port internal_ip internal_port protocol lease_time
		Add Pinhole (for IGD:2 only)
       	upnpc [options] -U uniqueID new_lease_time
		Update Pinhole (for IGD:2 only)
       	upnpc [options] -C uniqueID
		Check if Pinhole is Working (for IGD:2 only)
       	upnpc [options] -K uniqueID
		Get Number of packets going through the rule (for IGD:2 only)
       	upnpc [options] -D uniqueID
		Delete Pinhole (for IGD:2 only)
       	upnpc [options] -S
		Get Firewall status (for IGD:2 only)
       	upnpc [options] -G remote_ip remote_port internal_ip internal_port protocol
		Get Outbound Pinhole Timeout (for IGD:2 only)
       	upnpc [options] -P
		Get Presentation url

protocol is UDP or TCP
Options:
  -e description : set description for port mapping.
  -6 : use ip v6 instead of ip v4.
  -u url : bypass discovery process by providing the XML root description url.
  -m address/interface : provide ip address (ip v4) or interface name (ip v4 or v6) to use for sending SSDP multicast packets.
  -z localport : SSDP packets local (source) port (1024-65535).
  -p path : use this path for MiniSSDPd socket.
  -t ttl : set multicast TTL. Default value is 2.

```
