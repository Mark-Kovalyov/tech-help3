module Maskify where

{--
 Usually when you buy something, you're asked whether your credit card number, phone
 number or answer to your most secret question is still correct.
 However, since someone could look over your shoulder, you don't
 want that shown on your screen. Instead, we mask it.

 "4556364607935616" --> "############5616"
      "64607935616" -->      "#######5616"
                "1" -->                "1"
                 "" -->                 ""
 -}
--}


maskify :: String -> String
maskify str = reverse $ map (\x -> if (snd x <= 4) then fst x else '#') $ zip (reverse str) [1..]
