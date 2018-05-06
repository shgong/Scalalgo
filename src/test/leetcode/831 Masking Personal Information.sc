/*
831. Masking Personal Information

We are given a personal information string S,
either an email address or a phone number.


1. Email address:

name: string of length ≥ 2 consisting of only lowercase letters a-z or uppercase letters A-Z.

email addresses are guaranteed to be valid and in the format of "name1@name2.name3".

all names must be converted to lowercase
all letters between the first and last letter of the first name must be replaced by 5 asterisks '*'.


2. Phone number:

A phone number is a string consisting of only the digits 0-9 or the characters from the set {'+', '-', '(', ')', ' '}.
You may assume a phone number contains 10 to 13 digits.

The last 10 digits make up the local number, while the digits before those make up the country code.
Note that the country code is optional.

We want to expose only the last 4 digits and mask all other digits.

The local number should be formatted and masked as "***-***-1111", where 1 represents the exposed digits.

To mask a phone number with country code like "+111 111 111 1111", we write it in the form "+***-***-***-1111".
The '+' sign and the first '-' sign before the local number should only exist if there is a country code.  For example, a 12 digit phone number mask should start with "+**-".
Note that extraneous characters like "(", ")", " ", as well as extra dashes or plus signs not part of the above formatting scheme should be removed.



Return the correct "mask" of the information provided.
 */

def maskPII(S: String): String = {
  if(S.contains('@')){
    val Array(a,b) = S.split('@')

    a.toLowerCase().head + "*****" + a.toLowerCase().last + '@' + b.toLowerCase()

  } else {
    val digits = S.filter(_.isDigit)
    val ctry = digits.length - 10

    if(ctry==0) "***-***-" + digits.takeRight(4)
    else "+" + "*" * ctry + "-***-***-" + digits.takeRight(4)
  }


}

maskPII("LeetCode@LeetCode.com")
maskPII("AB@qq.com")
maskPII("1(234)567-890")
maskPII("86-(10)12345678")