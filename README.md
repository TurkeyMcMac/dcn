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

`&stringOrChar1 stringOrChar2 ...~` for creating prettier long strings
### Variable Capsules
`$variableKey value!` variable setter capsule  (ignored as part of data structure on compilation)  

`^variableKey!` variable getter capsule
### Miscellanious Capsules
`_null_` (inner text is arbitrary)  

`` `comment` `` (ignored on compilation)  
  
Note: characters written between elements in capsules that contain multiple elements are arbitrary. However, it is good practice to always enclose comments in backticks in case you accidentally put in a special character which breaks the structure of the data.

## Example
The following text is a list of maps containing information on various people.
```
$"child" #5;!
$"teenager" #15;!
$"adult" #30;!
$"senior" #65;!

{
	"first-name" "Max"
	"last-name" "Smith"
	"age" ^"child"!
	"has-hair" ?true;
}
{
	"first-name" "Jill"
	"last-name" "Johnson"
	"age" ^"teenager"!
	"has-hair" ?false;
}
{
	"first-name" "Urn"
	"last-name" "Bun"
	"age" ^"senior"!
	"has-hair" ?true;
}
{
	"first-name" "Jeff"
	"last-name" "Potato"
	"age" ^"adult"!
	"has-hair" ?false;
}
```
