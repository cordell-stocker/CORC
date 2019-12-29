# Card Objects Rendered Correctly \(CORC\)

### This program is released under license CORC \(GPL version 3\)

### Authors:

- Cordell Stocker 
  - GitHub: https://github.com/cordell-stocker
  - Author of CORC
- Lucas Burdell
  - GitHub: https://github.com/lucas-burdell
  - Author of Blackburn CardFramework (BBCF), the predecessor of CORC. Much of the ground
  work from BBCF that carried over into CORC was created by Lucas.

### Special thanks to:

- Dr. Kevin Coogan
  - GitHub: https://github.com/kpcoogan
- Dr. Joshua Gross
  - GitHub: https://github.com/jbgross
- Rylee Wilson
  - GitHub: https://github.com/Rylee-Wilson
- Delaney Satchwell
  - GitHub: https://github.com/lanesatchwell
- Michael Hoff
  - GitHub: https://github.com/MikeTheAnomaly

## Purpose

This framework is designed to enable the creation of Model View Controller \(MVC\) projects for beginner programmers.
These projects should allow the consumer to be able to write simple programs \(from their perspective\)
that run a card game. The overall goal is to give the new programmer the experience of working with an
external API to create a complex program, without having to write any of the complicated necessary logic
required to run the resulting game.

An simple example would be an implementation of "High Card". Where there are only two players, each player
draws a card, and whoever has the higher face value wins the round. The project from the consumer's view
would be to implement the basic conditional logic in the Model side that is required to run this game.
This means that the overall implementation from the designer's point of view, needs to handle all GUI related
functionality, and the controller communication between the GUI and what the programmer is roughly expected to write.

## Keywords

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL
NOT", "SHOULD", "SHOULD NOT", "RECOMMENDED",  "MAY", and
"OPTIONAL" in this document are to be interpreted as described in
RFC 2119. https://www.ietf.org/rfc/rfc2119.txt

## Development

- Intellij Idea is the preferred IDE platform for working on this project.
- Try to follow the Google Java Style Guide: https://google.github.io/styleguide/javaguide.html
exceptions include:
  - Block indentation is +4 spaces (not +2).
  - Continuation indent is +8 spaces (not +4).
  - The above may change in the future if decided to be necessary.

## Unit Tests

CORC uses JUnit4 for the testing library. 

## Notes

### Naming Convention

- For student comprehension, interfaces MAY start with "I".
  - This is generally considered bad practice \(A consumer of objects should usually
  be given the interface level object, and should have no idea that they are interacting
  with an interface\). However, early CS students may be confused by
  inheritance/polymorphism. So they should not be aware of the distinctions between a
  "Card" interface and a "StandardCard" class. But rather interact with a "Card" class
  \(That is really the "StandardCard" class\), that interfaces "ICard" \(That is
  really the "Card" interface\).
  - Backend classes which students will not see SHOULD follow standard Java naming
  conventions.
