import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CliArgsParser {
	
	private Map<Object, Object> map = new HashMap<Object, Object>();
	
	public String parse(Object[] args) {
		return parse(arrayToStringFormatter(args));
	}

	public String parse(String args) {

		String pattern = "--[a-z]+ ?[a-z0-9]*";
				
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(args);
		
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
	
	private String arrayToStringFormatter(Object[] array) {
		String completeInput = Arrays.toString(array);
		String inputWithoutBrackets = completeInput.substring(1, completeInput.length()-1);
		String correct = inputWithoutBrackets.replaceAll(",","");
		return correct;
	}
	
	

}
