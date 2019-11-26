--Graph Theory

--"/Users/farissyed/Documents/School/2018-19/Data Structures/Haskell/GraphTheory.hs"

--1

numEdgesInComplete :: Int -> Int
numEdgesInComplete n = sum [ x | x <- [0..n-1] ]

numForm n = n * (n/2) - (n/2)


--2

degree :: [(String,String)] -> String -> Int
degree gs n = length $ [ 1 | (a,b) <- gs, a==n || b==n ]



