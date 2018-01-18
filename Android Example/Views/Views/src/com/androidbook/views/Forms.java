package com.androidbook.views;

public class Forms extends Menu {

	@Override
	void prepareMenu() {
		addMenuItem("Text Input", TextInput.class);
		addMenuItem("Buttons", Buttons.class);
		addMenuItem("Pickers", Pickers.class);
		
	}

}
