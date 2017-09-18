package main
import (
    "fmt"
)
func main() {
    fmt.Printf("%d!=%d\n", 5, fact(5))
}
func fact(n int) (sum int) {
    if n == 0 {
        return 1
    }
    sum = n * fact(n-1)
    return
}
