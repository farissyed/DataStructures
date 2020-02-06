import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class ThanksgivingFood {
    public static void main( String[] args ) {
        Scanner scan = null;
        Map<String, Integer> food = new TreeMap<>();
        try {
            File f = new File( "./src/thanksgivingfoods.txt" );
            scan = new Scanner( f );

            while ( scan.hasNext() ) {
                String s = scan.nextLine();
                if ( food.containsKey( s ) ) {
                    food.put( s, food.get( s ) + 1 );
                }
                else {
                    food.put( s, 1 );
                }
            }
            for ( String s : food.keySet() ) { // idk what do
                System.out.printf( "Food: %-40s  Num: %-40s\n", s, food.get( s ) );
            }
        } catch ( Exception e ) {
            System.err.println( e + "\nMerry Christmas" );
        } finally {
            if ( scan != null ) {
                scan.close();
            }
        }
        Map<Integer, TreeSet<String>> numsOfFoods = new TreeMap<>();
        for ( String key : food.keySet() ) {
            if ( numsOfFoods.containsKey( food.get( key ) ) ) {
                numsOfFoods.get( food.get( key ) ).add( key );
            }
            else {
                TreeSet<String> a = new TreeSet<>();
                a.add( key );
                numsOfFoods.put( food.get( key ), a );
            }
        }
        for ( Integer i : numsOfFoods.keySet() ) { // idk what do
            System.out.printf( "Num: %-41s  Food: %-41s\n", i, numsOfFoods.get( i ) );
        }
    }
}
