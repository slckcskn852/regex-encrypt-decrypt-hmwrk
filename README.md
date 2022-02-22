# regex-encrypt-decrypt-hmwrk

AUTOMATA THEORY AND FORMAL LANGUAGE – CODING ASSIGNMENT
SELÇUK COŞKUN -- 041801079	KORHAN ALADAĞ -- 041601002

Goal of the Project:
This code should be able to decrypt a message that has 6 encryption methods. When the message is decrypted it should then check it against a CFG. If it matches it will be written into the output file. If it is rejected, the message will not appear in the output.
What we have achieved:
In this assignment we have been able to do the decryption part of the project and have been able to create a CFG for our input. However, we have failed to implement it into the code.
# What our code decrypts:
1. If a file begins with “,,” the message is about PANDEMIC INFO
2. If a file begins with “,” the message is about MILITARY INFO
3. If 1st,2nd,3rd,4th,5th,6th,7th,8th,9th, or 10th is present in the message the decryption would be tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first
4. If the incoming message has some info in parentheses the info inside the parentheses is labeled as FAKE INFO
5. If there are select month names written in Turkish inside the message the decryption will be as follows
- ocak -> I
- subat -> we
- aralik -> they
- ekim -> you
- eylul -> it
  
If the message contains scrambled directions the message will be decrypted as follows

- htron -> west
- htuos -> east
- tsew -> north
- tsae -> south
The lack of a space and the in the phrase “have met” and the phrase itself will be decrypted as follows
- have met -> will meet
- havemet -> going to meet






Input / Output Example
The message that has been intercepted is the one below:
,,ocak have met htron of the 4th division ( Commander Kory) and the 5th
Our decryption methods would decrypt the message as:
PANDEMIC INFO: I will meet west of the seventh division FAKE INFO and the sixth
How the program operates
1.	The input txt file is selected with the Windows file browser.
2.	The code runs and displays which file is selected and the decrypted output in the console
3.	The output txt file is then created at the same directory of the input txt file

# The CFG
S -> AX|BB

A -> SA|BB 

B -> m|i|l|t|r|y|n|f|w|e|u|s|h|d|c|a|o|h
X -> SA|military|info|i|will|meet|you|west|east|north|south|on|first|second|third|fourth|fifth|sixth|seventh|eighth|ninth|tenth|FAKE|INFO|and|the


# P.S.
The .jar file included requires the latest version of JDK (Java development kit) to run.
