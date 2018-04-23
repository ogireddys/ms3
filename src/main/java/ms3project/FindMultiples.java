package ms3project;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

public class FindMultiples implements Callable{
	
	private int input1;
	private int input2;
	private HashMap<Integer, String> hashMap = new LinkedHashMap<Integer, String>();
	
	public HashMap<Integer, String> getHashMap() {
		return hashMap;
	}

	public int getInput1() {
		return input1;
	}

	public void setInput1(int input1) {
		this.input1 = input1;
	}

	public int getInput2() {
		return input2;
	}
	
	public void setInput2(int input2) {
		this.input2 = input2;
	}
	
	public FindMultiples(){
	}

	public static void main(String[] args) {
		FindMultiples m = new FindMultiples();
		System.out.println(m.getHashMap().toString());
	}
	
	public void findAndReplaceMultiples( int multiple, String replaceWith) {
		//find the first multiple
		int firstMultiple = (input1!= 0 && input1 % multiple == 0) ? input1 : input1 + multiple - (input1 % multiple);
		
		//iterate over the range to get multiples for input
		//only interates over multiples
		for (int i = firstMultiple; i <= input2; i = i + multiple) {
				hashMap.put(i, replaceWith);
		}		
	}

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {		
		MuleMessage message= eventContext.getMessage();		
		Map<String, String> queryParams= (Map<String, String>)message.getInboundProperty("http.query.params");		
		
		//instantiate FindMultiples
		FindMultiples m = new FindMultiples();
		
		//get the query params
		m.setInput1(Integer.parseInt(queryParams.get("input1")));
		m.setInput2(Integer.parseInt(queryParams.get("input2")));
		// find a replace multiple of 3
		m.findAndReplaceMultiples(3, "ME");
		
		// find a replace multiple of 7
		m.findAndReplaceMultiples(7, "MS3");
		
		// find a replace multiple of 3 and 7 
		// if key already exists from above methods, it will get replaced by new value
		m.findAndReplaceMultiples(3*7, "MS3 and ME");
		System.out.println(m.getHashMap().toString());
		return m.getHashMap();
	}

}
