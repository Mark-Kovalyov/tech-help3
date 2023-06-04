import std/strformat
import os
import strutils


type
  BackupFile = object
    name: string
    size: int

  MerkleNode = object
    #block: array[32, string]
    hashcode: string


proc sha256(

proc backup(blocksize: int): bool = 
  echo "GoGo"

proc init(params: seq[string]): bool = true

# 

if paramCount() == 0:
  echo "Usage: bbackup command [options..] [filename]"
  echo " Commands:"
  echo "   init - initialize backup repository"
  echo "     options:"
  echo "       -b [blocksize] (4k,8k,...e.t.c.)" 
  echo " Examples:"
  echo "   bbackup -b 4096 -full        /db/postgres/ /backup"
  echo "   bbackup -b 4096 -incremental /db/postgres/ /backup"
else:
  echo "OK"
  if paramStr(1) == "init":
    let s = paramStr(2)
    let i = parseInt(s)
    echo fmt":: blocksize = {i}"
    let srcfile = paramStr(3)
    
    






       
