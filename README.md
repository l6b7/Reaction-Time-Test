# Reaction Time Test

An application that tests your reaction time based on visual stimuli.

Additionally, it stores 20 results locally and shows various averages of past results

![](https://i.imgur.com/wmcwAba.gif)

Screenshots : https://i.imgur.com/HFmry8z.png

## Motivation

I wanted to put into practise what I've learnt over the past few weeks, mostly referring to design patterns or good coding practises.
I wished to create a program that my friends and strangers could use, so I could get a lot of feedback, but additionally something that I enjoyed using.

## Challenges and decisions

Records storing system; I decided to simply write output data to a text file because I wanted it to be an offline app.

Reaction time measuring system; It was probably the most disappointing part as it cannot’t be as price as I would want it both from software and hardware standpoint.
I decided to use a timer (it could tick once every millisecond).
It was a very good way to make the application more pleasant to use as well as it gave a pretty repetitive margin of error.

Java swing; It was perhaps the most challenging part of my project as I had to go over many components that I wanted to include in my application as well as plan a layout of my application with planes and such.
That was especially difficult to research as the documentation rarely includes enough visual to represent said visual interface.
I am unhappy with the amount of panels I used for the records screen and how the records screen looks in general,
to fix that, I am going to implement dynamic scaling in future updates.

## What went well, what did I learn

Planing good structure of the program and writing the code along with good principles helped me to save a lot of time. Especially when I had to find what causes an error or when I wanted to add a new feature.
I could skip comments because my code could easily describe itself, in therms of what it does.
I’ve learnt that even the least complex 2 way interactions between methods or objects will eventually lead to unaccountable for states, so they should be avoided at all cost.


## Class description & misc

Model interface and the class that implements it serves to read and store records to a text file

Controller interface and ReactionTimeApplication class that implements it serves as a standard controller, allows for an indirect communication between view and the model.

ApplicationView class draws and updates GUI based on user input.
It might be hard to follow panel names, but I always tried to work on them in an order (sub panels should always come in code after their parent panels).

The application creates records.txt file in the same directory it was run from, to store time records.
