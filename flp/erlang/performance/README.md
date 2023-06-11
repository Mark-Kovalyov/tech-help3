# Erlang and Performance

## Links

* Maxim Lapshin https://www.youtube.com/watch?v=Of-xg6OKpLg

## Disable Swap on PROD!

```
$
```

## Htop doesn't show anything usefull

## Actors instead of threads

* micro-process
* data isolation

## Etop

* reduction - call of the function
* every functon iteration is reduction

## fprof, eprof

* rude, useless
* measures only reduction
* introduces side effects

## Htop is not your friend!

* scheduler sping time - wastes megaflops
* need to look at scheduler usage inside of beam
* erlang:statistics(scheduler_wall_time)

## Bottle necks

* One actor - is a singleton
* Need to inspect queues lengths

## Overloaded Actor. How to fix.

* Take process list
* Take process_info(Pid, message_queue_len)
* sort and take top 10
* See stacktrace

## Locks

* Real thread hided by Actors
* Mutexes still here.

## Where is Mutexes?

* Every "ets" has
* 8-16 mutexes for I/O of ets
* Every process has

## Erlang's lcnt

* tool to collect metrics by Mutexes
* a bit of costs
* +spinlock in ets

```
lcnt:start()
lcnt:rt_opt({copy_save,true})
lcnt:clear()
timer:sleep(5000)
lcnt:collect()
lcnt:swap_pid_keys()
lcnt:conflicts([{max_locks, 5}])

lcnt:inspect(proc_status)
```

## Bad advices

* check process_info from third-party process
* many writes to ETS
* inter-thread interaction
* very offen allocation

## What about ets?

* Shard to multiple ets. More tables == Less locks.
* Route all data to single process per table

## How to detect? No ideas!

* Atomic on N-Cores server :(
* false sharing (L1/L3 caches)

## msacc

* Erlangs CPU analyzer
* allocator, C-code, busy_wait, check_io, emulator, gc, nif, port, send, sleep, timers
* enable/disable
* no sense for 100-200 ms measures

## Allocators

## instrument

## erts_alloc_config

* allocator settings
* disables MT-allocator (beam +Mea config)
* collects history, give advices

##
