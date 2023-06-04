module Pangram where

import Data.Char
import Data.Sort
import Data.Maybe

{--
str = "The quick brown fox jumps over the lazy dog."
Pack my box with five dozen liquor jugs.

Not every sentence is a a pangram. An example"

isPunctuation :: Char -> Bool
isPunctuation c = c `elem` ['.', ',', '?', '!', ':', ';',' ']

.aaabbc
aaabbc
a  b

abcdefghijklmnopqrstuvwxyz
bcdefghijklmnopqrstuvwxyz

arr = ['a'..'z']
pairs = zip (Nothing : map Just arr) (map Just arr)
map fromJust (map snd $ filter (\x -> fst x /= snd x) pairs)

(a,b)
....
(y.z)

 -}

--}


sorted_letters :: [Char] -> [Char]
sorted_letters str = sort (filter (\c -> not (isPunctuation c || c==' ')) (map toLower str))

shifted_pairs :: [Char] -> [(Maybe::Char,Maybe::Char)]
shifted_pairs str = zip (Nothing : map Just str) (map Just str)

uniq_from_pairs :: [(Maybe::Char,Maybe::Char)] -> [Char]
uniq_from_pairs = map fromJust (map snd $ filter (\x -> fst x /= snd x) shifted_pairs)

isPangram :: String -> Bool
isPangram str =
  let sorted = sorted_letters str
      sh_p = shifted_pairs sorted
      unq = uniq_from_pairs sh_p
  in
      unq == ['a'..'z']





















