using System; 
using Microsoft.Win32; 

public class ReadRegData 
{ 
    public ReadRegData()
    { 
        // 
        // TODO: Add Constructor Logic here 
        // 
    }

    public static int Main(string[] args) 
    { 
        // 打开根路径
        RegistryKey MYSOFTKEY = RegistryKey.OpenRemoteBaseKey(Microsoft.Win32.RegistryHive.CurrentUser,""); 

        // 子路径
        string subkey = "Software\\公司名\\软件名"; 

        // 打开子路径
        RegistryKey SUBKEY = MYSOFTKEY.OpenSubKey(subkey); 

        // 遍历所有的键名
        String [] keyNameArray = SUBKEY.GetValueNames();

        // 打印出所有键名及其对应的键值
        foreach (String keyName in keyNameArray)
        {
            // 读取键值
            string keyValue = (string)SUBKEY.GetValue(keyName);             
            Console.WriteLine(keyName + " = " + keyValue);
        }

        return 0; 
    } 
} 

