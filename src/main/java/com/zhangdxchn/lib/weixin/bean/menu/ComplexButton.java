package com.zhangdxchn.lib.weixin.bean.menu;

import java.util.ArrayList;
import java.util.List;

public class ComplexButton extends Button {

	private List<Button> sub_button;

	public List<Button> getSub_button() {
		return sub_button;
	}

	public void addSubButton(Button btn) {
		if (sub_button == null) {
			sub_button = new ArrayList<Button>();
		}
		sub_button.add(btn);
	}
}
