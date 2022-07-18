package controller;


import java.io.FileReader;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;



import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import vo.Info;

public class ApiResult {
	
    
    ArrayList<Info> ApiResult(HttpServletRequest request) throws Exception{
    	Object ob = new JSONParser().parse(new FileReader("캠핑장1.json"));
    	JSONObject jsonObj = (JSONObject)ob;
		
		//JSONParse에 json데이터를 넣어 파싱한 다음 JSONObject로 변환한다.
    	JSONObject parse_response = (JSONObject) jsonObj.get("response"); 
    	JSONObject parse_body = (JSONObject) parse_response.get("body");
    	JSONObject parse_items = (JSONObject) parse_body.get("items");
    	JSONArray itemArray = (JSONArray) parse_items.get("item");
    	ArrayList<Info> addr1 = new ArrayList<>();
		for(int i=0; i < itemArray.size(); i++) {
			Info info = new Info();
		    JSONObject itemObject = (JSONObject) itemArray.get(i);		    
		    info.setAddr1((String)itemObject.get("addr1"));
		    addr1.add(info);	    		    		    
		}
		return addr1;	
    }
}