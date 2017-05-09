package jude.dcn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public final class Dcn {
	
	private static Map<String, Capsule> capsuleNames = new HashMap<>();
	
	static {
		List<Capsule> capsules = Capsule.capsules;
		for (Capsule c : capsules) {
			String capsuleName = c.getClass().getSimpleName().toLowerCase();
			capsuleNames.put(capsuleName.substring(0, capsuleName.length() - 7), c);
		}
	}
	
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
	
	public static void main(String[] args) {
		System.out.println(constructFromFile("/test", "hash"));
	}
	
}
