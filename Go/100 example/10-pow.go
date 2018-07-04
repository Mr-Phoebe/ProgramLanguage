package main
import (
    "fmt"
    "math"
)
func main() {
    var x, i int
    var max int = 5
    fmt.Printf("请输入一个数字:")
    fmt.Scanf("%d\n", &x)
    for i = 0; i < max/2; i++ {
        h := x % int(math.Pow10(max-i)) / int(math.Pow10(max-i-1))
        l := x % int(math.Pow10(i+1)) / int(math.Pow10(i))
        if h != l {
            fmt.Printf("%d不是一个回文数.\n", x)
            break
        }
    }
    if i == max/2 {
        fmt.Printf("%d是一个回文数.\n", x)
    }
}
