package main
import (
    "fmt"
)
func main() {
    var I float32 = 0.0
    var bonus float32 = 0.0
    fmt.Print("输入利润：")
    fmt.Scanf("%f\n", &I)
    switch {
    case I > 1000000:
        bonus = (I - 1000000) * 0.01
        I = 1000000
        fallthrough
    case I > 600000:
        bonus += (I - 600000) * 0.015
        I = 600000
        fallthrough
    case I > 400000:
        bonus += (I - 400000) * 0.03
        I = 400000
        fallthrough
    case I > 200000:
        bonus += (I - 200000) * 0.05
        I = 200000
        fallthrough
    case I > 100000:
        bonus += (I - 100000) * 0.075
        I = 100000
        fallthrough
    default:
        bonus += I * 0.1
    }
    fmt.Printf("提成总计：%f\n", bonus)
}
