package target2024.java8;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

public class MapFromStringStreams {

	public static void main(String[] args) {
		String str = "Cargo:1234King,transport:0987Ace";
		
		//Map[Cargo:1234King, transport:0987Ace]
		
	   Map<String, String> result = Arrays.stream(str.split(","))
	           .map(s -> s.split(":", 2)) // split each entry into key/value
	           .collect(Collectors.toMap(
	               a -> a[0], // key
	               a -> a[1]  // value
	           ));
	
	   System.out.println(result);
	   
       
    }
}
