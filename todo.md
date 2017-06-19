TODO: SEFL

- annotations

- what happens if a table doesn't match at all?

-  forward reference extends over definition of value block429967

- bitwise operations
    - “underflow” or “overflow” wrap around
    - Slice
- casts

---------------------------------------------------------------------------------------------------

OBS:

- can bitwise operations be modeled? (they seem to be working on it)
- boolean and/or would be useful
- parse recursion:
    - theoretically limited by the max packet size


---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------

TODO: C

- packet.lookahead, SymbolicValue(), ; , Fork, emit, //Extern: ipv4_checksum.get
- bit fields max size is 64 because of c data types
    -  alternative is using a bitarray library
        - would Klee work properly with it?
- local variables are not inside a bitvector struct
    - potential source of errors because of overflows
    - solution: put them in a struct named after control
        - can also solve some encapsulation problems