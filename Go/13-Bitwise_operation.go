package main
import (
    "fmt"
)
func main() {
    var a int
    fmt.Printf("input a number:")
    fmt.Scanf("%d\n", &a)
    b := a >> 4
    c := ^(^0 << 4)
    d := b & c
    fmt.Printf("%o\n%o\n", a, d)
}

