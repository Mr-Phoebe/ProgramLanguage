// Stack名字空间
namespace Stack
{
  using System;

  public class Stack
  {
    // first: 栈最上面一个节点
    private Node first = null;
    
    // count: 栈中节点的数量
    private int count = 0;

    // 判空属性，提供get访问器
    public bool Empty
    {
      get
      {
        return (first == null);
      }
    }

    // 计数属性，提供get访问器
    public int Count
    {
    get
    {
      return count;
    }
  }

  // 压栈操作，注意返回object
  public object Pop()
  {
    if (first == null)
    {
      throw new InvalidOperationException ("Cant pop from an empty stack");
    }
    else
    {
      object temp = first.Value;
      first = first.Next;
      count--;
      return temp;
    }
  }

  // 弹栈操作，返回空
  public void Push(object o)
  {
    first = new Node(o, first);
    count++;
  }

  // 节点类
  class Node
  {
    // 节点有两个属性：自己、指向下一个节点
    public Node Next;
    public object Value;

    public Node(object value) : this(value, null) {}

    public Node(object value, Node next)
    {
      Next = next;
      Value = value;
    }
  }
}

class StackApp
{
  static void Main()
  {
    Stack s = new Stack();

    if (s.Empty)
      Console.WriteLine("堆栈为空");
    else
      Console.WriteLine("堆栈非空");

    // 往栈中压入5个节点
    for (int i = 0; i < 5; i++)
      s.Push(i);

    Console.WriteLine("往堆栈中压入了{0}个元素", s.Count);
    
    // 把栈中节点全部弹出来
    for (int i = 0; i < 5; i++)
      Console.WriteLine("弹出了第{0}个元素，还剩{1}个元素。", (int)s.Pop()+1, s.Count);

    s = null;
    Console.ReadKey();
    }
  }
}

