\ Clock shows h hours, m minutes 
\ and s seconds after midnight.

\ Your task is to write a function 
\ which returns the time since midnight in milliseconds.

h = 0
m = 1
s = 1

result = 61000

0 <= h <= 23
0 <= m <= 59
0 <= s <= 59

         h m s rot
         m s h rot
         s h m swap
         s m h 3600 *
         s m (h*3600) swap
         s (h*3600) m 
         
         

: past ( u u u -- u ) 
   
  2drop ;