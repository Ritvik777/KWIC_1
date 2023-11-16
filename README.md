# Design_Patterns
KWIC (Key Word In Context) is a text analysis technique used to index and search for specific words or phrases within a larger body of text. It involves creating an index of all the words or phrases in a document, and then listing them in alphabetical order, along with their context (i.e. the words immediately preceding and following them).
The purpose of KWIC indexing is to allow users to quickly and easily locate specific information within a large corpus of text. It is often used in information retrieval systems, such as search engines, where users can enter a keyword or phrase and receive a list of all the occurrences of that keyword or phrase within the indexed documents, along with their context.
In this Report we have applied the following 3 requests to Both Modularization 1 and Modularization 2 and then analyse how each request causes the source code to change.
The Three Requests:
(a) Request 1: All the input remains string. Sort the result in the reverse alphabetic order. Also, allows input from the command line.
(b) Request 2: All the input remains string. Introduces noise elimination in KWIC (you determine which module in both Modularizations 1 and 2 and how) that eliminates “a”, “an”, “the”, “and”, “or” (both upper and lower cases).
(c) Request 3: All the input are integers instead of string.
