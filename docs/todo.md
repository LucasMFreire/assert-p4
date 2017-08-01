TODO: BOTH

- implied reject state
    - default at select expressions
    - if no transition them call explicitly
- reject next of header stack of invalid position


TODO: SEFL

- annotations
- parser recursion?
- what happens if a table doesn't match at all? A: Default action
- bitwise operations
    - “underflow” or “overflow” wrap around
    - Slice
- casts


OBS:

- can bitwise operations be modeled?
- boolean and/or would be useful
- parse recursion:
    - theoretically limited by the max packet size


---------------------------------------------------------------------------------------------------

TODO: C

- VSS architecture: outctrl, inout headers
- header stack index initialization, forward declarations,
- emit
    - what happens if we emit invalid headers?
- bit fields max size is 64 because of c data types
    -  alternative is using a bitarray library
        - would Klee work properly with it?
- local variables are not inside a bitvector struct
    - potential source of errors because of overflows
    - solution: put them in a struct named after control
        - can also solve some encapsulation problems