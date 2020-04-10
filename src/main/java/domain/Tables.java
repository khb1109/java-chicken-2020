package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tables {
	private final Map<Integer, Table> tables;

	public Tables(List<Table> tables) {
		this.tables = new HashMap<>();
		for (Table table : tables) {
			this.tables.put(table.getNumber(), table);
		}
	}

	public Table findTable(int tableNumber) {
		if (tables.containsKey(tableNumber)) {
			return tables.get(tableNumber);
		}
		throw new IllegalArgumentException("테이블이 존재하지 않습니다.");
	}

	public Map<Integer, Table> getTables() {
		return tables;
	}
}
