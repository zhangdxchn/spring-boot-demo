package com.zhangdxchn.lib.weixin.bean.menu;


import java.util.ArrayList;
import java.util.List;

public class Menu {

	private List<Button> button = new ArrayList<Button>();

	public List<Button> getButton() {
		return button;
	}

	public void addButton(Button btn) {
		button.add(btn);
	}
}
