package domain;

import java.util.Objects;

public class MenuCount {
	private final long count;

	public MenuCount(long count) {
		validate(count);
		this.count = count;
	}

	private void validate(long count) {
		if (count <= 0 || count >= 100) {
			throw new IllegalArgumentException(String.format("%d 메뉴의 범위를 넘었습니다.", count));
		}
	}
	public MenuCount addCount(MenuCount other){
		return new MenuCount(this.count + other.count);
	}

	@Override
	public String toString() {
		return "MenuCount{" +
			"count=" + count +
			'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		MenuCount menuCount = (MenuCount)o;
		return count == menuCount.count;
	}

	@Override
	public int hashCode() {
		return Objects.hash(count);
	}
}
