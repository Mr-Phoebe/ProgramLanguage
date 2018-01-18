package com.mingrisoft;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;


public class MainFrame extends JFrame {

	/**
     * 
     */
    private static final long serialVersionUID = -4595347311922711984L;
    private JTextField textField_3;
	private JTextField textField_1;
	private JComboBox comboBox_1;
	private JTextField textField;
	private JComboBox cityComboBox;
	private JComboBox comboBox;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame
	 */
	public MainFrame() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 518, 379);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//获取默认的市/县
		String province=(String)getProvince()[0];
		setTitle("输入指定省/直辖市查询对应的市县");

		final BackgroundPanel backgroundPanel = new BackgroundPanel();
		backgroundPanel.setImage(SwingResourceManager.getImage(MainFrame.class, "/images/background.jpg"));
		backgroundPanel.setBounds(0, 0, 510, 380);
		getContentPane().add(backgroundPanel);

		final JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(36, 126, 438, 70);
		backgroundPanel.add(panel);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "居住地", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		cityComboBox = new JComboBox();
		cityComboBox.setBounds(245, 25, 124, 27);
		panel.add(cityComboBox);
		
		cityComboBox.setModel(new DefaultComboBoxModel(getCity(province)));

		comboBox = new JComboBox();
		comboBox.setBounds(25, 25, 124, 27);
		panel.add(comboBox);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(final ItemEvent e) { // 选项状态更改事件
				itemChange();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(getProvince())); // 添加省份信息

		final JLabel label = new JLabel();
		label.setText("省/直辖市");
		label.setBounds(155, 30, 66, 18);
		panel.add(label);

		final JLabel label_1 = new JLabel();
		label_1.setText("市/县");
		label_1.setBounds(375, 30, 37, 18);
		panel.add(label_1);

		final JLabel label_2 = new JLabel();
		label_2.setBounds(36, 43, 65, 18);
		backgroundPanel.add(label_2);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setHorizontalTextPosition(SwingConstants.LEADING);
		label_2.setText("姓    名：");

		textField = new JTextField();
		textField.setBounds(113, 38, 154, 28);
		backgroundPanel.add(textField);

		final JLabel label_3 = new JLabel();
		label_3.setBounds(36, 84, 65, 18);
		backgroundPanel.add(label_3);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setHorizontalTextPosition(SwingConstants.LEADING);
		label_3.setText("性    别：");

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(113, 81, 66, 25);
		backgroundPanel.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));

		final JLabel label_4 = new JLabel();
		label_4.setBounds(36, 212, 65, 18);
		backgroundPanel.add(label_4);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setHorizontalTextPosition(SwingConstants.LEADING);
		label_4.setText("详细地址：");

		textField_1 = new JTextField();
		textField_1.setBounds(113, 208, 367, 28);
		backgroundPanel.add(textField_1);

		final JLabel label_4_1 = new JLabel();
		label_4_1.setBounds(36, 252, 65, 18);
		backgroundPanel.add(label_4_1);
		label_4_1.setHorizontalTextPosition(SwingConstants.LEADING);
		label_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4_1.setText("E-mail：");

		textField_3 = new JTextField();
		textField_3.setBounds(113, 248, 367, 27);
		backgroundPanel.add(textField_3);

		final JButton button = new JButton();
		button.setBounds(159, 289, 75, 28);
		backgroundPanel.add(button);
		button.setText("保存");

		final JButton button_1 = new JButton();
		button_1.setBounds(265, 289, 75, 28);
		backgroundPanel.add(button_1);
		button_1.setText("重置");
		//
	}

	/**
	 * 获取省、直辖市，自治区
	 * 
	 * @return
	 */
	public Object[] getProvince() {
		Map<String, String[]> map = CityMap.model;// 获取省份信息保存到Map中
		Set<String> set = map.keySet(); // 获取Map集合中的键，并以Set集合返回
		Object[] province = set.toArray(); // 转换为数组
		return province; // 返回获取的省份信息
	}

	/**
	 * 获取指定省对应的市/县
	 * 
	 * @param selectProvince
	 * @return
	 */
	public String[] getCity(String selectProvince) {
		Map<String, String[]> map = CityMap.model; // 获取省份信息保存到Map中
		String[] arrCity = map.get(selectProvince); // 获取指定键的值
		return arrCity; // 返回获取的市/县
	}

    private void itemChange() {
        String selectProvince = (String) comboBox.getSelectedItem();
        cityComboBox.removeAllItems(); // 清空市/县列表
        String[] arrCity = getCity(selectProvince); // 获取市/县
        cityComboBox.setModel(new DefaultComboBoxModel(arrCity)); // 重新添加市/县列表的值
    }

}
