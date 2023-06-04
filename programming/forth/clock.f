\Case 1:
\---------

h m s       : swap 
              rot
s m h       : 60 dup * *
s m h*3600  : swap
s h*3600 m  : 60 * 
s 3600h 60m : + + 
s+3600h+60m : 1000 * ; 
1000*(s+3600h+60m)

\Case 2:
\----------
ms = 1000 * (60*60*h + 60*m + s) = 1000 * (60 * (60 * h + m) + s)

h m s       : rot
m s h       : 60 *
m s 60h     : rot
s 60h m     : +
s (60h + m) : 60 *
s 60(60h+m) : +
s+60(60h+m) : 1000 *







