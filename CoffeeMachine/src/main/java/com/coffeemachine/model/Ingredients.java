package com.coffeemachine.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
public class Ingredients {

	private final String id;
	private final String name;
	private final Integer unit;

	public Ingredients(@NonNull final String id, @NonNull final String name, @NonNull final Integer unit) {
		this.id = id;
		this.name = name;
		this.unit = unit;
	}

}
