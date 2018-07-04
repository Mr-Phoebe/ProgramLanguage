package main

import "fmt"

const (
    i = 1<<iota
    j = 3<<iota
    k
    l
)

func main() {
    fmt.Println("i = ", i)
    fmt.Println("j = ", j)
    fmt.Println("k = ", k)
    fmt.Println("l = ", l)
}
