package main
import (
    "fmt"
    "math"
)
func main() {
    i := 0
    for {
        x := int(math.Sqrt(float64(i + 100)))
        y := int(math.Sqrt(float64(i + 268)))
        if x*x == i+100 && y*y == i+268 {
            fmt.Printf("这个数字是%d\n", i)
            break
        }
        i++
    }
}
