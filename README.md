# Card Objects Rendered Correctly \(CORC\)

## Version: 0.1.0

### Keywords

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL
NOT", "SHOULD", "SHOULD NOT", "RECOMMENDED",  "MAY", and
"OPTIONAL" in this document are to be interpreted as described in
RFC 2119. https://www.ietf.org/rfc/rfc2119.txt

## Notes
### Naming Convention

- For student readability, interfaces MAY start with "I".
  - This is generally considered bad practice \(A consumer of objects should usually
  by given the interface level object, and should have no idea that they are interacting
  with an interface\). However, early CS students may be confused by
  inheritance/polymorphism. So they should not be aware of the distinctions between a
  "Card" interface and a "StandardCard" object. But rather interact with a "Card" object
  \(That is really the "StandardCard" object\), that interfaces "ICard" \(That is
  really the "Card" interface\).

