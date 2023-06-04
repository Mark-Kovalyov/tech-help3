module Codewars.Kata.DNA where
import Codewars.Kata.DNA.Types

-- data Base = A | T | G | C
type DNA = [Base]

dnaMute :: Base -> Base
dnaMute A = T
dnaMute T = A
dnaMute C = G
dnaMute G = C

dnaStrand :: DNA -> DNA
dnaStrand [] = []
dnaStrand chrl = dnaMute ( head chrl ) : if (tail chrl) /= [] then (dnaStrand (tail chrl)) else []
