package main

import (
    "fmt"
    "net"
    "bufio"
)

const TRANSMISSION_PORT = 51413

func main() {
    p :=  make([]byte, 2048)
    conn, err := net.Dial("udp", "0.0.0.0:51413")
    if err != nil {
        fmt.Printf("Some error %v", err)
        return
    }
    /*
    fmt.Fprintf(conn, "Hi UDP Server, How are you doing?")
    _, err = bufio.NewReader(conn).Read(p)
    if err == nil {
        fmt.Printf("%s\n", p)
    } else {
        fmt.Printf("Some error %v\n", err)
    }*/
    conn.Close()
}
