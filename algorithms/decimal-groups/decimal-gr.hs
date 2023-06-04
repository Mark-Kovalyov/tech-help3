module Decimalgr where

{-- Substring --}

:{
subs :: [a] -> Int -> Int -> [a]
subs s start len = take len (drop start s)
:}

subs "The quick brown fox jumps over lazy dog" 10 8
"brown fo"

:{
subs :: [a] -> Int -> Int -> [a]
subs s start len = take len $ drop start s
:}
