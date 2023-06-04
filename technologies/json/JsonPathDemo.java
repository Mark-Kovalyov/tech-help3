package mayton.spark.bitcoin;

import com.google.gson.Gson;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DemoJsonPath {

    // Dot notation
    // $.tool.jsonpath.creator.location[2]

    // Bracket notation
    // $['tool']['jsonpath']['creator']['location'][2]

    // $ - root node
    // @ - current node
    // * - all elements in scope(book[*] )

    // Depends on :
    //   com.jayway.jsonpath:json-path:2.4.0
    //
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream(args[0]);
        String query   = args[1]; // "$['library']['book']['part']"
        FileWriter fw  = new FileWriter(args[2]);

        DocumentContext jsonContext = JsonPath.parse(is);
        JSONArray array = jsonContext.read(query);

        // map to Java LinkedHashMap and serialize to Json-string with Google GSON
        for(Object lhm : array) {
            String gsonString = new Gson().toJson((LinkedHashMap)lhm, Map.class);
            fw.write(gsonString);
            fw.write("\n");
        }
        

        is.close();
        fw.close();
    }

}
