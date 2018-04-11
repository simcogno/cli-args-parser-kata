import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;


public class CliArgsParserTest {
	
	Reader reader;
	CliArgsParser parser;
	
	@Test
	public void parseSimpleFlagInputIsString() {
		reader = new InputFormatter("--foo");
		parser = new CliArgsParser(reader);
		String output = parser.parse();
		assertEquals("{foo=true}", output);
	} 
	
	
	@Test
	public void parseCompositeFlagInputIsString() {
		reader = new InputFormatter("--foo bar");
		parser = new CliArgsParser(reader);
		String output = parser.parse();
		assertEquals("{foo=bar}", output);
	} 
	
	
	
	@Test
	public void parseCompositeFlagWithIntegerInputIsString() {
		reader = new InputFormatter("--number 1");
		parser = new CliArgsParser(reader);
		String output = parser.parse();
		assertEquals("{number=1}", output);
	}
	
	
	
	@Test
	public void parseMultipleFlagsInputIsString() {
		reader = new InputFormatter("--foo --bar baz --number 1");
		parser = new CliArgsParser(reader);
		String output = parser.parse();
		assertEquals("{number=1, bar=baz, foo=true}", output);
	}
	
	@Test
	public void parseSimpleFlag() {
		Object[] input = {"--foo"};
		reader = new InputFormatter(input);
		parser = new CliArgsParser(reader);
		String output = parser.parse();
		assertEquals("{foo=true}", output);
	}
	
	@Test
	public void parseCompositeFlag() {
		Object[] input = {"--foo", "bar"};
		reader = new InputFormatter(input);
		parser = new CliArgsParser(reader);
		String output = parser.parse();
		assertEquals("{foo=bar}", output);
	}
	
	@Test
	public void parseCompositeFlagWithInteger() {
		Object[] input = {"--number", 1};
		reader = new InputFormatter(input);
		parser = new CliArgsParser(reader);
		String output = parser.parse();
		assertEquals("{number=1}", output);
	}
	
	@Test
	public void parseMultipleFlags() {
		Object[] input = {"--foo", "--bar", "baz", "--number", 1};
		reader = new InputFormatter(input);
		parser = new CliArgsParser(reader);
		String output = parser.parse();
		assertEquals("{number=1, bar=baz, foo=true}", output);
	} 

}
