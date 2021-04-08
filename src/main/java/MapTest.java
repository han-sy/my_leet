import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class MapTest {
	public void test() {
		Map map = new HashMap();

		map.compute("a", (v, i) -> {
			int a = 1;
			return 3;
		});

	}
}
