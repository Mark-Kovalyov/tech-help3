# Listen UDP port

SO_REUSEPORT

## Transmission

port = 51413

## See also

https://github.com/pmatev/udp-tap


## Mirror all traffic from one port to another on localhost using iptables

```
iptables -t mangle -A PREROUTING -p UDP --dport 162 -j TEE --gateway 127.0.0.2

iptables -t nat -A PREROUTING -d 127.0.0.2 -p UDP --dport 162 -j DNAT --to 127.0.0.1:51413
```

## Can I have both ufw and iptables running together? My server is currently using ufw, if I add an iptables rule will it have any effect?

* There is really only iptables because UFW is a front-end for iptables. Whichever method you used last will take priority.

* If you have rules via UFW and then add ones via iptables directly, then you will have both mixed.

* iptables is up and running all the time whether you have set rules for it or not.
