import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputFormatter implements Reader {
	
	private String pattern = "--[a-z]+ ?[a-z0-9]*";
	private Pattern p;
	private Matcher m;
	
	public InputFormatter(String input) {
			
		p = Pattern.compile(pattern);	
		m = p.matcher(input);
	}
	
	public InputFormatter(Object[] input) {
		String completeInput = Arrays.toString(input);
		String inputWithoutBrackets = completeInput.substring(1, completeInput.length()-1);
		String correct = inputWithoutBrackets.replaceAll(",","");
		
		p = Pattern.compile(pattern);	
		m = p.matcher(correct);
	}
	
	public Matcher getMatcher() {
		return m;
	}

}
