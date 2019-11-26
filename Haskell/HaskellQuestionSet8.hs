--Set 8
import Data.Char

--"/Users/farissyed/Documents/School/2018-19/Data Structures/Haskell/HaskellQuestionSet8.hs"

main = do
  putStrLn("Compiled")

fstTriple (x,_,_) = x
sndTriple (_,x,_) = x
thrdTriple (_,_,x) = x

--1

isPos :: Int -> Bool 
isPos = (>0)

--2

isEven :: Int -> Bool
isEven = (\a-> a `mod` 2 == 0)

--3

fstItem :: [(a,a)] -> [a]    
fstItem xs = map(fst) xs

--4

square :: Int -> [Int]
square = (\a -> map( ^2 ) $ take a [1..])

--5

reverseTuple :: [(a,a)] -> [(a,a)]
reverseTuple xs = zip (map (snd) xs) (map (fst) xs)    

--reverseTuple xs = [ (b,a) | (a,b) <- xs ]

--6

{-
	We have been using filters in List Comprehension when listing what 
	constraints we have on the elements in the list.
-}

--7

imdb :: [(String,Int)] -> Int
imdb xs = length $ filter (>8) $ map (snd) xs

--8

triangle :: Int -> Int -> [(Int,Int,Int)]
triangle x y = filter (\x -> isTriangle x) $ [ (a,b,c) | a <- [x..y], b <- [x..y], c <- [x..y] ]
  where isTriangle (a,b,c) = a + b > c && a + c > b && b + c > a

--9
vote = do
  putStrLn "Hello, what is your age?"
  age <- getLine
  let canVote = (read age :: Int) >= 18 
  if canVote then putStrLn "You can vote!" else putStrLn "You can not vote!"

--10
newSeq = do
  putStrLn "Type in a start value"
  start <- getLine
  let a = read start :: Int
  putStrLn "Type in a stop value"
  stop <- getLine
  let b = read stop :: Int
  putStrLn "Type in a delta"
  delta <- getLine
  let d = read delta :: Int
  let seq = [a,a+d..b]
  if seq == [] then error "sequence does not work" else putStrLn (show seq)


dada = do
 putStrLn "Type a start number."
 start <- getLine
 let a = read start :: Int
 putStrLn "Type stop number."
 stop <- getLine
 let b = read stop :: Int
 putStrLn "Type in a delta number."
 delta <- getLine
 let c = read delta :: Int
 let seqc = [a,(a+c)..b]
 putStrLn $ validList seqc

validList :: [Int] -> String
validList xs
 | xs == [] = error "Not a possible list"
 | otherwise = show xs





