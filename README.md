# ART Source
This repository will contain the source code of ART processor code and grammar definition

ART processor's core code is built in Java, using a parser/lexer generator tool Antlr. The Antlr version used is 3.2. We were using the feature to define grammars to output AST trees and using tree-rewriting. The new Antlr4 has no tree-rewriting and suggest that logic to be moved in the grammar logic's source code instead of grammar syntax definition, so the syntax and code has to be migrated to use the new Antlr version. Help and suggestions on migration are welcome.

## For developers who are willing to work on the Java base code of ART.

You can use the code as a simple Java project and work on the core code to override, enhance how the ART command will behave.

  - Fork the project [here](http://github.com/art-processor/art-source/ "Art Source"). You can use latest Eclipse version and latest JRE. Just open the project.
  - You can ignore the package named `grammar`, the output of the parser/lexer generation is included in the source code in the package named `antlr-generated`.
  - Happy coding!
  
## For developers who are willing to work on ART grammar as well

We have a pre-configured ecplipse with Antlr 3.2 and Antlr eclipse workbench which will help in modifying grammar files and regenerates the `antlr-generated` grammar code package on every grammar file change.

  - dowload eclipse ANTLR (pre-configured for grammar updates) from [here](http://github.com/art-processor/art-source/ "Eclipse-ART-ANTLR").
  - Open Eclipse-ART-ANTLR and import this project.
  - Once you open a grammar (*.g) file, it will prompt you to select an Antlr package in order to build the grammar. Select Yes, point to the Antlr 3.2 library under the `lib` folder of this project.
  - Make sure the code generation parameters are set (This should be set on the project you donwloaded):
    - On imported project:
    - Project Properties -> ANTLR -> Code Generator: 
      - Tick "Enable project specific settings",
      - Under "Output Folder" select "Project relative folder" and type: "antlr-generated",
      - Under Java, tick "Append Java package to output folder".
      - Apply. Ok.
  - Now, once there is a change in any of the (*.g) files and the change is saved, we can see the Antlr compiler's result on the console window and the affected files in the `antlr-generated` package have been replaced with the newly generated java files from the grammar definition.
  - JRE 1.8 will cause an error to pop up, however the parser/lexer code generation is successful. The error can be ignored, or you can run with JRE 1.7, in that case a NPE error will be reported on the Console view.
     - Changing JRE in Eclipse: Top menu -> Window -> Preferemces -> Java -> Installed JREs -> Add and select 1.7 from your computer
     - More about the JRE 1.8 <-> Antlr 3.2 incompatibility issue [here](http://stackoverflow.com/questions/22366415/antlr-plugin-in-eclipse#22367682)
  - Happy coding!
  
