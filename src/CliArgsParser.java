import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class CliArgsParser {
	
	Reader r;
	
	public CliArgsParser(Reader r) {
		this.r = r;
	}
	
	private Map<Object, Object> map = new HashMap<Object, Object>();

	public String parse() {
		
		Matcher m = r.getMatcher();
		
		while(m.find()) {
			addToMap(m.group());
		}
		
		return map.toString();
	}
	
	private void addToMap(String completeArgument) {
		String[] parts = completeArgument.split(" ");
		String firstPart = parts[0].replaceAll("--", "");
		
		if(parts.length == 1) {
			map.put(firstPart, true);
		} else {
			map.put(firstPart, parts[1]);
		}
	}

}
