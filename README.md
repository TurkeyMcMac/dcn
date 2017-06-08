# dcn (Data Capsule Notation)
This is a parser for an inferior version of JSON that I created.

## Capsule Types
### Primitive Capsules
`#integer;`  

`%float;`  

`?boolean;`  

`'character'`  

`"string"`
### Structured Capsules
`[value1 value2 ...]`  

`{key1 value1 key2 value2 ...}`
### Variable Capsules
`$variableKey value!` variable setter capsule  (ignored as part of data structure on compilation)  

`^variableKey!` variable getter capsule
### Miscellanious Capsules
`_null_` (inner text is arbitrary)  

`` `comment` `` (ignored on compilation)  
  
Note: characters written between elements in capsules that contain multiple elements are arbitrary. However, it is good practice to always enclose comments in backticks in case you accidentally put in a special character which breaks the structure of the data.
