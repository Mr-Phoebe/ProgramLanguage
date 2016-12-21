package com.lzw;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * 带背景的面板组件
 * 
 * @author ZhongWei Lee
 */
public class BackgroundPanel extends JPanel {

	/**
     * 
     */
    private static final long serialVersionUID = 7758689434195492602L;
    /**
	 * 背景图片
	 */
	private Image image;

	/**
	 * 构造方法
	 */
	public BackgroundPanel() {
		super();
		setOpaque(false);
		setLayout(null);
	}

	/**
	 * 设置图片的方法
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	@Override
	protected void paintComponent(Graphics g) {// 重写绘制组件外观
		if (image != null) {
			int width = getWidth();// 获取组件大小
			int height = getHeight();
			g.drawImage(image, 0, 0, width, height, this);// 绘制图片与组件大小相同
		}
		super.paintComponent(g);// 执行超类方法
	}
}
