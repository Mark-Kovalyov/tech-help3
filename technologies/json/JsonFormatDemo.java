import com.google.gson.*;
import java.io.*;


public class JsonFormatDemo {
    
	// Streamable non-memory invasive formatter
	//
	// Depends on:
	//   com.google.code.gson:gson:2.9.1
	//    
	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonElement el = JsonParser.parseReader(new FileReader(args[0]));
		FileWriter fw = new FileWriter(args[1]);
		gson.toJson(el, fw);
		fw.close();
	}
	
	

}


