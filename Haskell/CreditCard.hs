import Data.Char

--"/Users/farissyed/Documents/School/2018-19/Data Structures/Haskell/CreditCard.hs"

main = do
  putStrLn("Compiled")

amex x = ("34" == (take 2 $ show x) || "37" == (take 2 $ show x)) && (length x == 15)
discover x = x
masterCard x = x
visa x = xs