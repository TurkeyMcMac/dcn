package jwmh.dcn;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Capsules {
	
	//Instantiate capsule types
	static {
		new BooleanCapsule();
		new CharacterCapsule();
		new HashCapsule();
		new IntegerCapsule();
		new ListCapsule();
		new StringCapsule();
	}
	
	protected static Map<String, Capsule<?>> capsuleIds = new HashMap<>();
	
	static {
		List<Capsule<?>> capsules = Capsule.capsules;
		for (Capsule<?> c : capsules) {
			capsuleIds.put(c.SELECTOR, c);
		}
	}
	
	public static final Set<String> SELECTORS = capsuleIds.keySet();
	
	public static Object read(String text, String capsuleId) {
		Capsule<?> capsule = capsuleIds.get(capsuleId);
		return capsule.evaluate(text + capsule.FINISH).value;
	}
	
	public static Map<Object, Object> readHash(String text) {
		return (Map<Object, Object>)read(text, "hash");
	}
	
	public static List<Object> readList(String text) {
		return (List<Object>)read(text, "list");
	}
	
	public static Object readFile(String path, String capsuleId) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return read(new String(encoded, StandardCharsets.UTF_8), capsuleId);
	}
	
	public static Map<Object, Object> readHashFile(String path) throws IOException {
		return (Map<Object, Object>)readFile(path, "hash");
	}
	
	public static List<Object> readListFile(String path) throws IOException {
		return (List<Object>)readFile(path, "list");
	}
	
}
