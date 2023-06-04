module Money where

{--
import Data.List
:t
https://www.youtube.com/watch?v=Qa8IfEeBJqk
groupBy :: (a -> a -> Bool) -> [a] -> [[a]]
foldr :: Foldable t => (a -> b -> b) -> b -> t a -> b
foldl :: Foldable t => (b -> a -> b) -> b -> t a -> b
foldr (+) 0 [1,2,5,10,50,100,500]
foldr (\x acc -> if e==x then )
foldr (\(a,b) -> (fst a + fst b, snd a + snd b)) (0,0) [(1,1),(5,1),(50,1),(100,1),(100,1),(100,1),(100,1),(500,1)]

(1,1)
(5,1)
(50,1)
(100,1)
(100,1)
(100,1)
(100,1)
(500,1)

import Data.List
 group :: Eq a => [a] -> [[a]]
 groupBy :: (a -> a -> Bool) -> [a] -> [[a]]

impoer Data.List.GroupBy
 group :: Eq a => [a] -> [[a]]
 groupBy :: (a -> a -> Bool) -> [a] -> [[a]]

 groupBy (\(a,b) -> (snd a) == (snd b)) [(1,2),(1,3),(2,1)]

--}

collapse_pairs :: [Maybe[(Int,Int)], Maybe[(Int,Int)]] -> [(Int,Int)]
collapse_pairs


payment_ru :: Int -> [(Int,Int)]
payment_ru sum = payment sum (reverse [1,2,5,10,50,100,500]) []

payment :: Int -> [Int] -> [(Int,Int)] -> [(Int,Int)]
payment sum nom res
 | sum > 0 && sum - h >= 0 = payment (sum - h) nom $ (h,1) : res
 | sum > 0 && sum - h < 0  = payment sum (tail nom) res
 | otherwise               = res
 where h = head nom

:{
payment' :: Int -> [Int] -> [(Int,Int)] -> [(Int,Int)]
payment' sum nom res
 | sum > 0   = if sum - h >= 0
               then payment' (sum - h) nom $ (h,1) : res
               else payment' sum (tail nom) res
 | otherwise = res
 where h = head nom

payment :: Int -> [(Int,Int)]
payment sum = payment' sum (reverse [1,2,5,10,50,100,500]) []
:}
