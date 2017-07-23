# Desktop-Search-Engine
Searching File in PC (specific folder) based on its properties, retrieving content of a simple file and semi-structure data(full or partially, e.g. XML file), searching file based on its content 

there are three separate main files :- 
1. model        (for searching files based on its contents)
2. XMLRead       (retrieving partial or full content from semi-structured files)  
3. contensearch  (searching file based on its content)

1.) model.class-  steps - in terminal type 
 java model 
 
 further type on <drive name> <folder> <subfolder> <relationship query> 
e.g.  E "folder" "subfolder" hasFile OR hasFolder

for searching the files -- choose the respective option as visible in the terminal 

2.) XMLRead.class-  steps - in terminal type as 
java XMLRead

after selecting the option
type the complete path of the file : e.g.  E:\folder\abc.xml

and next follow the instructions from the terminal itself for retrieving the semi-structured content

3.) contentsearch.class- in terminal type

java contentsearch

and follow the instructions same as above e.g. E:\folder 
