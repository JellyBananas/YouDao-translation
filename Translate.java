import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.test.JSONAssert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by jellyBananas on 2016/9/4.
 */
public class Translate {
    String R;
    public String query(String word){
        try {
            String u = "http://fanyi.youdao.com/openapi.do?keyfrom=ElegantNews&key=1219620241&type=data&doctype=json&version=1.1&q=";
            u = u + word;
            URL url = new URL(u);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputString ;
            String result = null;
            while((inputString = in.readLine()) != null){
//                System.out.println(inputString);
                result = inputString;
            }//inputString 局部变量
            in.close();
            String tr = "{\"translation\":[\"";
            String ba = "\"],\"basic\":{\"";
            String up = "\":{\"us-phonetic\":\"";
            String ex = "\",\"explains\":[\"";
            String qu = "\"]},\"query\":\"";
            String ph = "\",\"phonetic\":\"";
            String up2 = "\",\"uk-phonetic\":\"";
            String translation = result.substring(result.indexOf(tr)+tr.length(),result.indexOf(ba));
            String phonetic = result.substring(result.indexOf(up)+up.length(),result.indexOf(ex)).replace(ph,"; ").replace(up2,"; ");
            String explains = result.substring(result.indexOf(ex)+ex.length(),result.indexOf(qu)).replace("\",\""," ");
            R =  translation+"\n"+phonetic+"\n"+explains;
        }catch (Exception e){
            e.printStackTrace();
        }
        return R;
    }
}
