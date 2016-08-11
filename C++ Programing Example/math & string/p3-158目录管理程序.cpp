#include<iostream.h>
#include<direct.h>
#include<errno.h>
#define MAX_PATH 250
main()
{
    //声明变量
    char *p,str[MAX_PATH];

    //设置新目录
    if (mkdir("d:\\ABC")){
        cout<<"mkdir Error!"<<endl;
    }

    //更该工作目录
    if (chdir("d:\\ABC")){
        cout<<"chdir Error!"<<endl;
    }

    //读取当前目录
    if ((p=getcwd(str,MAX_PATH))==NULL) {
        cout<<"getcwd Error!"<<endl;
    }
    else
    {
        cout<<"p:"<<p<<endl;
        cout<<"str:"<<str<<endl;
    }

    //更该工作目录
    if (chdir("d:\\")){
        cout<<"chdir Error!"<<endl;
    }

    //删除指定目录
    if (rmdir("d:\\ABC")==-1) 
        cout<<"rmdir Error!"<<endl;
}


/*chdir()改变当前目录的函数
原形：int chdir(const char *path)
功能：把由path指定的目录改为当前目录。path参数中可以指定驱动器号，如“a:\\ddd”, 但只是改变该驱动器上的当前目录，对当前活动驱动器上的当前目录无影响。
返回值：0(成功)；-1(失败)
头文件：dir.h
=======================================================================================
findfirst()函数和findnext()函数
调用方式：整形数=findfirst(文件名,&结构变量名,属性常数组合(如0x26));其中定义struct ffblk 结构变量名;
原形：int findfirst(path,buffer,attr)和int findnext(buffer)
   char *path;//要检索的文件名
   struct ffblk
    {
    char ff_reserved[21];
    char ff_attrib;//被检索的文件属性
    unsigned ff_ftime;//最后修改的时间
     //(0-4位:秒数/2；5-10位:分数；11-15位:小时数)
    unsigned ff_fdate;//最后修改的日期
     //(0-4位：日；5-8位：月；9-15位：年减1980)
    long ff_fsize;//文件大小
    char ff_name[13];//组名
    }*buffer;
   int attr;//要检索的文件属性
功能：检索由path和attr指定的文件，把结果返回到buffer。findfirst返回关于第一个指定文件的信息，findnext继续检索。
返回值：0(检索成功),-1(没有找到指定的文件)
属性常数：
  FA_NORMAL(0x00)  含意：Normal file, no attributes 
  FA_RDONLY(0x01)  含意：只读
  FA_HIDDEN(0x02)  含意：隐含文件
  FA_SYSTEM(0x04)  含意：系统文件
  FA_LABEL(0x08)   含意：卷标
  FA_DIREC(0x10)   含意：子目录
  FA_ARCH(0x20)   含意：修改的文件Archive
头文件：dir.h(dos.h)
====================================================================================
fnmerge()建立文件路径函数
原形：void fnmerge(char *path,const char *drive,const char *dir, const char *name,const char *ext)
功能：合成drive:\dir\name.ext，放在path
头文件：dir.h

fnsplit()分解完整的路径名函数
原形:int fnsplit(char *path,const char *drive,const char *dir,const char *name,const char *ext)
功能：把文件名路径path分成4个部分存放。
  其中drive中有冒号；dir中有开始和结尾的反斜杠；ext包括开始圆点
返回值：如果有扩展名，则 返回值&EXTENSION!=0
    如果有文件名，则 返回值&FILENAME!=0
    如果有目录名，则 返回值&DIRECTORY!=0
    如果有驱动器号，则返回值&DIRVE!=0
头文件：dir.h 
====================================================================================
getcurdir()读取指定驱动器的当前目录的函数
原形：int getcurdir(int drive,char directory)
   drive=0(缺省);1(A驱动器)；...
   directory用来存放目录名，不包括驱动器名，不以反斜杠开始。
返回值：0(调用成功);1(出错)
头文件：dir.h

getcwd()读取当前目录的函数
原形：char *getcwd(char *buf,int buflen)
功能：读取当前目录的完整路径名(包括驱动器名)，最长为buflen个字节，存放在buf中。如果buf为NULL，函数将分配一个buflen字节长的缓冲区，以后可将本函数的返回值作为free函数的参数来释放该缓冲区。
返回值：若buf非空，调用成功返回buf,出错返回NULL;若buf为NULL,返回指向已经分配的内存缓冲区地址。
头文件：dir.h

getdisk()读取当前磁盘驱动器号函数
原形：int getdisk(void)
功能：取得当前驱动器号（0=A;1=B;....）
头文件：dir.h
======================================================================================
mkdir()创建目录函数
原形：int mkdir(const char *path)
功能：按给定的路径建立一个新的目录
头文件：dir.h
返回值：0(成功);-1(失败)

mktemp()建立一个唯一的文件名的函数
原形：char *mktemp(char *template)
功能：使用一个唯一的文件名来替换字符串template,并返回template。
头文件：dir.h
======================================================================================
rmdir()删除目录函数
原形：int rmdir(const char *path)
注意：删除的目录不能是当前目录，不是根目录，是空目录
返回值：0(成功);-1(操作出错) 
头文件：dir.h

searchpath()按dos路径查找一个文件的函数
原形：char *searchpath(const char *file) 
用法：p=searchpath("文件名"); 先定义char *p;
功能：搜索dos路径(环境变量中的path=....)来定位由file给出的文件。
返回值：指向完整路径名字符串的指针。定位失败返回NULL。
头文件：dir.h

segread()读段寄存器函数
原形：void segread(struct SREGS *segp)
作用：把当前寄存器的值保存到SREGS型机构变量segp中。
   segs.cs=代码段寄存器的值;
   segs.ds=数据段寄存器的值；
   segs.es=附加段寄存器的值；
   segs.ss=堆栈段寄存器的值；

setdisk()设置当前驱动器的函数
原形：int setdisk(int drive)
功能：把由drive指定的驱动器修改成当前驱动器，返回可使用的驱动器数。
头文件：dir.h

settextstyle()显示字符的当前设置函数
功能：设置当前输出英文字符的字体、大小和方向。
调用方式：
void far settextstyle(int font,int direction,int charsize)
  其中①参数font确定所选定的字体形状，
     DEFAULT_FONT 或0 是8×8位图字体
     TRIPLEX_FONT 或1 是三重矢量字体
     SMALL_FONT 或2 是小号矢量字体
     SANS_SERIF_FONT或3 是无衬线矢量字体
     GOTHIC_FONT 或4 是哥特矢量字体
    ②参数durection字符的显示方向，
     HORIZ_DIR 或0 是水平方向
     VERT_DIR 或1 是垂直方向
    ③参数charsize表示字符放大的倍数，其值为0到10。

setvect()设置中断向量函数
setvect(int 中断号,void interrupt(*中断函数名)) 
功能：把中断服务程序的地址装入中断向量表中。
调用方法：setvect(中断号，中断函数名即地址);
 (1)得预先定义要代替原函数的新函数
  void interrupt 中断函数名(void)
   {......}
 (2)得先保留原中断函数地址
  void interrupt (*保留函数名)(void);
  保留函数名=getvect(中断号);
 (3)事后得将原中断函数地址装回向量表中
  setvect(中断号，保留函数名);

setviewport()建立视口的函数
原形： void far setviewport(int left,int top,int right,int bottom,int clip)
功能：用左上角坐标left,top和右下角坐标right,bottom建立一个视口，如果clip为1，则超出视口的输出自动被剪裁掉；如果clip为0，则不被剪裁。
例：setviewport(0,0,100,100,1)建立对角线为0，0和100，100的视口，并带有剪裁功能。
注：要清除当前视口，用函数clearnviewport()。
 