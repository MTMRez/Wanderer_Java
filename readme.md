* -1 in grid indicates walls
* a number in grid indicates how many beeps there are in that position
* visualize the grid positions like this -example for a 3x4 grid:
```
[0,0][0,1][0,2][0,3]
[1,0][1,1][1,2][1,3]
[2,0][2,1][2,2][2,3]
```
* `posh` and `posw` store the Wanderer position, vertical then horizontal respectively
* Wanderer can't neither start on walls nor move towards them

When testing, Wanderer must be initialized like:
1. Two integers indicating grid size (vertical then horizontal)
2. An array with n pairs of values indicating positions to place walls
3. An array with n triples of values indicating positions to place beeps and how many

* Wanderer must be initialized separately

Based on [JKarel](https://www.cs.tufts.edu/comp/10F/JKarel.htm).