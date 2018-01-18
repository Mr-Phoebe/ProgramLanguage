using System;
using System.IO;

public class Person
{
    // 枚举类型，用于表示性别。为节省内存，使用byte。
    public enum Sex : byte
    {
        Male = 0, Female
    }

    // 私有属性：姓名，性别，年龄，身高，体重
    private string name;
    private Sex    sex;
    private byte   age;
    private float  height;
    private float  weight;

    // 构造函数，只用一个属性：姓名
    public Person(string sName)
    {
        name = sName;
    }

    // 构造函数2，支持两个属性：姓名，性别
    public Person(string sName, Sex cSex)
    {
        name = sName;
        sex  = cSex;
    }

    // 设置年龄
    public void setAge(byte bAge)
    {
        age = bAge;
    }

    // 设置性别，参数为枚举类型Sex
    public void setSex(Sex cSex)
    {
        sex = cSex;
    }

    // 重载设置性别的方法，参数为byte
    public void setSex(byte bSex)
    {
        sex = (Sex)bSex;
    }

    // 设置身高
    public void setHeight(float fHeight)
    {
        height = fHeight;
    }

    // 设置体重
    public void setWeight(float fWeight)
    {
        weight = fWeight;
    }

    // 得到姓名
    public string getName()
    {
        return name;
    }

    // 得到年龄
    public byte getAge()
    {
        return age;
    }

    // 得到性别
    public Sex getSex()
    {
        return sex;
    }

    // 得到身高
    public float getHeight()
    {
        return height;
    }

    // 得到体重
    public float getWeight()
    {
        return weight;
    } 
}

public class MyClass
{
    public static void Main()
    {
        // 实例化一个人，设置各项属性
        Person p1 = new Person("李娟");
        p1.setSex((byte)1);
        p1.setAge(19);
        p1.setHeight((float)1.68);
        p1.setWeight(45);

        // 实例化另一个人，设置各项属性
        Person p2 = new Person("张建国", 0);
        p2.setAge(25);
        p2.setHeight((float)1.75);
        p2.setWeight(74);

        // 打印出两人的属性
        Console.WriteLine("{0}\t{1}\t{2}\t{3}\t{4}", p1.getName(), p1.getSex(), p1.getAge(), p1.getHeight(), p1.getWeight());
        Console.WriteLine("{0}\t{1}\t{2}\t{3}\t{4}", p2.getName(), p2.getSex(), p2.getAge(), p2.getHeight(), p2.getWeight());

    }
}
