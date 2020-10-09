import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Board {
	private Tile[][] tiles;
	
	Board(String mapString){
		tiles = new Tile[7][7]; //this shouldn't be hard-coded, i'm being lazy
		int ringNumber = 0;
		int ringLength = 0;
		String[] mapList = mapString.split(" ");
		for(int i = 0; i<7; ++i){
			if()
			int num = Integer.parseInt(mapList[i]);
			tiles[];
		}
	}
	/* Useful hexagonal coordinate stuff
	function cube_spiral(center, radius):
	    results = [center]
	    for each 1 <= k <= radius:
	        results = results + cube_ring(center, k)
	 	return results
	    
	function cube_ring(center, radius):
    	var results = []
    	# this code doesn't work for radius == 0; can you see why?
    	var cube = cube_add(center, 
                        cube_scale(cube_direction(4), radius))
    	for each 0 <= i < 6:
        	for each 0 <= j < radius:
            	results.append(cube)
            	cube = cube_neighbor(cube, i)
    	return results
    
    function cube_to_axial(cube):
    	var q = cube.x
    	var r = cube.z
    	return Hex(q, r)
		
	function axial_to_cube(hex):
    	var x = hex.q
    	var z = hex.r
    	var y = -x-z
    return Cube(x, y, z)
    
    
    Json Parsing stuff:
        private static void parseSystemObject(JSONObject system) 
    {
        //Get employee object within list
        JSONObject systemObject = (JSONObject) system.get("employee");
         
        //Get employee first name
        String firstName = (String) systemObject.get("firstName");    
    }
    
    private static  createMap() {
        //FORMULA FOR READING JSON
       try (FileReader reader = new FileReader("systems.json"))
       {
           //Read JSON file
           Object obj = JSONParser.parse(reader);

           JSONArray employeeList = (JSONArray) obj;
          //Iterate over employee array
           employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (ParseException e) {
           e.printStackTrace();
       }
    }
    
	*/
}