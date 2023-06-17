# LSM and SS-Table (Sorted String table)

## LSM

 log-structured merge-tree (LSM tree) is a data structure typically used when dealing with write-heavy workloads. The write path is optimized by only performing sequential writes. LSM trees are the core data structure behind many databases, including BigTable, Cassandra, Scylla, and RocksDB.

https://yetanotherdevblog.com/lsm/#:~:text=A%20log-structured%20merge-tree%20%28LSM%20tree%29%20is%20a%20data,many%20databases%2C%20including%20BigTable%2C%20Cassandra%2C%20Scylla%2C%20and%20RocksDB.
