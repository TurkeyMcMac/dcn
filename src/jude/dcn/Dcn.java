package jude.dcn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public final class Dcn {
	
	private static Map<String, Capsule> capsuleNames = new HashMap<>();
	
	//Instantiate capsule types
	static {
		new BooleanCapsule();
		new CharacterCapsule();
		new HashCapsule();
		new IntegerCapsule();
		new ListCapsule();
		new StringCapsule();
	}
	
	static {
		List<Capsule> capsules = Capsule.capsules;
		for (Capsule c : capsules) {
			capsuleNames.put(c.SELECTOR, c);
		}
	}
	
	public static final Set<String> SELECTORS = capsuleNames.keySet();
	
	public static Object construct(String capsule, String textStruct) {
		Capsule structure = capsuleNames.get(textStruct.toLowerCase());
		capsule += structure.FINISH;
		return structure.evaluate(capsule).value;
	}
	
	public static Object constructFromFile(String path, String fileStruct) {
		String capsule = "";
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(Paths.class.getResourceAsStream(path)));
			String line = null;
			while((line = reader.readLine()) != null) {
				capsule += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return construct(capsule, fileStruct);
	}
	
}
