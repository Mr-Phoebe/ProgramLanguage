package main

import (
    "container/list"
    "fmt"
    "strconv"
)

func xixi(a int) *list.List {
    l := list.New()
    for i := a; i < a+5; i++ {
        l.PushBack(i)
    }
    return l
}

func main() {
    l := list.New()
    for i := 0; i < 5; i++ {
        l.PushBack(i)
    }
    for e := l.Front(); e != nil; e = e.Next() {
        fmt.Print(e.Value)
    }
    fmt.Println("")
    l2 := xixi(5)
    for e := l2.Front(); e != nil; e = e.Next() {
        if value, ok := e.Value.(int); ok {
            if strconv.Itoa(value) == "7" {
                fmt.Print(value)
            }
        } else {
            continue
        }
    }
    fmt.Println("")
}

