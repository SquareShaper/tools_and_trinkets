
# Goal
## Function
A tome that shoots bubbles at enemies. When an enemy is hit by a bubble they get the drowning effect. 
The drowning effect does damage over time. The tome's special ability creates a big circular AoE. 
Everyone affected by the AoE has any "over time" effects applied instantly, so 10 seconds of 1 dmg per second
effect does 10 dmg instantly and cleanses the 10-second effect.

## Form
The tome is a 3D model in the player's hand. 
When attacking, the player's hands follow a cast animation. 
The bubbles use a 3D model as well. 
The AoE is implemented with shaders. 
The drowning effect is shown visually by one of the bubbles enveloping the afflicted mobs head. 
If a player is caught in the AoE, it shows a Totem of Undying animation on their screen, with a clock. 
When a status effect is instantly triggered it plays an effect based off of what got triggered. 
This is done via shader shenanigans. 

# Execution
## Function
 - [x] Create the tome item
 - [x] Create the bubble entity
 - [x] Make the bubble entity track mobs
 - [x] Create the drowning effect
 - [x] Create the AoE
 - [x] Make the tome special ability have a cooldown
 - [x] Make the tome normal attack have cooldown
 - [x] Make the AoE instantly apply X seconds of "over time" effects
   - [x] damage/heal Status Effects
   - [x] Funky status effects
   - [x] Accelerate breath loss/gain
   - [x] Fire ticks
 - [x] Figure out if it moves time by x seconds, or all the way but cap the effect
   - [x] X seconds (5?)
   - ~~[ ] capped effect~~
 - [x] Do I need a cumulative dmg cap? how much dmg is 2 or 3 DoT effects if they all get accelerated 5 seconds? if it's around 10, then it doesn't matter, and I'll do no cap but just 5 seconds (they still add together, so dmg immunity doesn't trigger)
   - [x] make healing remove dmg from the trigger (if there's regen as well(Also, check for inverted healing or dmg (undead)))
   - [x] keep track of how much of the dmg is poison, so poison doesn't kill
   - [x] remember to track fire resistance
   - [x] remember to track fire protection

## Form
 - [ ] Create the tome model
 - [ ] Create the bubble model
 - [ ] Figure out player animations
 - [ ] Make the player cast animations
 - [ ] Figure out shaders
 - [ ] Make the AoE sphere effect
 - [ ] Make the AoE wave effect
 - [ ] Make the AoE clock effect
 - [ ] Make the clock animation play on affected player's screen
 - [ ] Make the bubble status effect visual
 - [ ] Make the instant application VFX
 - [ ] Show the special ability cooldown visually

## Bugs
 - [ ] Ghost item created when dropping tome during special cooldown
 - [ ] When bubbles burst, they don't always play particles