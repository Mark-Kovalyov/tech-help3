module Knighttour where

horse_directions = [(2,1),(1,2), (-2,1),(-1,2), (2,-1),(1,-2), (-2,-1),(-1,-2)]

tour :: Int -> Int -> Int -> [(Int,Int)]
tour size x y
 | size < 5 = error("Unable!")
 | otherwise = safe_tour size x y 0 []

is_allowed_move xx yy size = xx >= 0 && xx < size && yy >= 0 && yy < size

safe_tour size x y cnt list
 | cnt < size * size = []
 | otherwise = map safe_tour horse_directions
