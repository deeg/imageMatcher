# Image Matcher #

This program will take in a list of pattern files and a list of source files, and attempt to find the pattern within
the source.

It assumes the files are text based, and tries to find the best matches it can. Matches are not only 100%, but accounts
for noise.

## Running ##

It expects 4 parameters

-p {patternFiles} -s {sourceFiles}

{patternFiles} & {sourceFiles} can be locations to directories or files.

If either is a directory, it will use all files within that directory.

## Matching ##

I decided to spit out matches only which were over 70%. Given more time, I will use a formula to determine if there
are enough pixels to be considered a match or not.

