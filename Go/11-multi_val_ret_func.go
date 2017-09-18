package main
import (
    "fmt"
)
func main() {
    noresult()
    ret := oneresult()
    fmt.Println("存在1个返回值的函数", ret)
    _, b := tworesult()
    fmt.Println("存在2个返回值的函数", b)
    _, _, _ = threeresult()
}
func noresult() {
    fmt.Println("没有返回值的函数")
}
func oneresult() int {
    fmt.Println("存在1个返回值的函数")
    return 1
}
func tworesult() (int, bool) {
    fmt.Println("存在2个返回值的函数")
    return 2, true
}
func threeresult() (int, bool, string) {
    fmt.Println("存在3个返回值的函数")
    return 3, false, "错误"
}
