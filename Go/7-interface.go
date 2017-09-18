package main
import (
    "fmt"
)

func main() {
    var score int = 0
    fmt.Scanf("%d", &score)
    fmt.Println(B(score >= 90).C("A", B(score >= 60).C("B", "C")))
}

func (b Bool) C(t, f interface{}) interface{} {
    if bool(b) == true {
        return t
    }
    return f
}
