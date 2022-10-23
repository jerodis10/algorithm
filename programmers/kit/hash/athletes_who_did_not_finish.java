package programmers.kit.hash;

import java.util.HashMap;

public class athletes_who_did_not_finish {
	public static String solution(String[] participant, String[] completion) {
		HashMap<String ,Integer> h = new HashMap<String ,Integer>();
	    int tmp=0;
		for(String s: completion) {
	    	if(h.get(s) != null) {
	    		tmp = h.get(s);
	    		h.put(s,tmp+1);
	    	}
	    	else
	    		h.put(s,1);
	    }
		for(String s:participant) {
			if(h.get(s) != null) {
	    		tmp = h.get(s);
				if(tmp>0)
					h.put(s,tmp-1);                
				else
					return s;
			}
			else
				return s;
		}
		return "Error";
    	
	}
}
