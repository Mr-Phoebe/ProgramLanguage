package com.mingrisoft;
public class Student {
    private int id;			//表示学生的序号
    private String name;		//表示学生的姓名
    private boolean male;	//表示学生的性别
    private double account;	//表示学生的账户余额
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
	public double getAccount() {
		return account;
	}
	public void setAccount(double account) {
		this.account = account;
	}

}
