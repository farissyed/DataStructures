--Set 7
import Data.Char

--"/Users/farissyed/Documents/School/2018-19/Data Structures/Haskell/HaskellQuestionSet7.hs"

main = do
  putStrLn("Compiled")

fstTriple (x,_,_) = x
sndTriple (_,x,_) = x
thrdTriple (_,_,x) = x

--1

fromOrigin :: (RealFloat a) => [(a, a)] -> [a]
fromOrigin points = [ distance | (x,y) <- points, let distance = sqrt $ x^2 + y^2 ]

--2

closeEnough :: (RealFloat a) => [(a, a)] -> a -> [((a, a), a)]
closeEnough points d =
  let distance x y = sqrt $ x^2 + y^2 
  in [ ((x,y), distance x y) | (x,y) <- points , distance x y < d]

--3

article :: String -> String
article xs = case head xs of 'a' -> "an " ++ xs
                             'e' -> "an " ++ xs
                             'i' -> "an " ++ xs
                             'o' -> "an " ++ xs
                             'u' -> "an " ++ xs
                             _ -> "a " ++ xs

--4

haveNum :: Int -> String -> String
haveNum n xs = case n of 1 -> "You have a " ++ xs
                         _ -> "You have " ++ show n ++ " " ++ xs ++ "s"

--5

gpa :: Char -> Double
gpa x = case toUpper x of 'A' -> 4.0
                          'B' -> 3.0
                          'C' -> 2.0
                          'D' -> 1.0
                          'F' -> 0.0

--6

factorial :: Int -> Int
factorial 1 = 1
factorial x = x * (factorial $ x - 1)

--7

powers :: Int -> Int -> Int
powers x 1 = x
powers x y = x * (powers x (y - 1))

--8

fibonacci :: Int -> Int
fibonacci 0 = 0
fibonacci 1 = 1
fibonacci n = (fibonacci $ n - 1) + (fibonacci $ n - 2)

--9

reversing :: String -> String
reversing [x] = [x]
reversing (x:xs) = reversing xs ++ [x]



